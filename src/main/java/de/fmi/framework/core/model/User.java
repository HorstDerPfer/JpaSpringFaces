package de.fmi.framework.core.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.CollectionOfElements;
import org.hibernate.annotations.IndexColumn;

@Entity
@Table(name = "sec_user")
public class User extends IdentityFieldProvider {

	private static final long serialVersionUID = -3562419911346915236L;

	private static int maxLoginFailures = 4;

	/** hashed password */
	@Column(nullable = false)
	protected String password;

	/** hashed temporaeres Kennwort bei Kennwortrequest */
	@Column(name = "new_password")
	protected String newPassword;

	/** hash des ersten Kennworts */
	@Column(name = "first_password")
	protected String firstPassword;

	/** Liste der letzten <code>historySize</code> Kennwoerter */
	@CollectionOfElements
	@IndexColumn(name = "list_index")
	@JoinTable(name = "sec_password_history")
	protected List<String> passwordHistory = new ArrayList<String>();

	/** Benutzername bzw. Loginname */
	@Column(name = "username", nullable = false, unique = true)
	protected String username;

	/**
	 * false, wenn der Account nicht mehr gueltig ist (nach einem bestimmten
	 * Zeitraum)
	 */
	@Column(name = "account_non_expired", nullable = false)
	protected boolean accountNonExpired = true;

	/** false, wenn der Account gesperrt wurden, z.B. nach einem bestimmten */
	@Column(name = "account_non_locked", nullable = false)
	protected boolean accountNonLocked = true;

	/** false, wenn das Kennwort veraltet ist */
	@Column(name = "credentials_non_expired", nullable = false)
	protected boolean credentialsNonExpired = true;

	/** false, wenn der Account nicht aktiviert ist, hat keinen Zeitraumbezug */
	@Column(name = "enabled", nullable = false)
	protected boolean enabled = true;

	/** anzahl der falschen Logins */
	@Column(name = "failed_login", nullable = false)
	protected int failedLogin;

	/**
	 * Anzahl der Kennworter, die nicht wiederverwendet werden duerfen
	 * Konzernrichtlinie 114.0231A03 Abchnitt 2.3
	 */
	@Transient
	protected int historySize = 6;

	public User() {
		this.unlock();
	}

	public User(String username) {
		super();
		this.username = username;
		this.password = firstPassword;
		this.unlock();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see db.training.security.User#increaseFailedLogin()
	 */
	public void increaseFailedLogin() {
		failedLogin++;
		if (failedLogin > maxLoginFailures)
			lock();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see db.training.security.User#resetFailedLogin()
	 */
	public void resetFailedLogin() {
		failedLogin = 0;
	}

	public boolean isAccountNonExpired() {
		return accountNonExpired;
	}

	public void setAccountNonExpired(boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}

	public boolean isAccountNonLocked() {
		return accountNonLocked;
	}

	public void setAccountNonLocked(boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}

	public boolean isCredentialsNonExpired() {
		return credentialsNonExpired;
	}

	public void setCredentialsNonExpired(boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getPassword() {
		return password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<String> getPasswordHistory() {
		return passwordHistory;
	}

	public void changePassword(String oldPassword, String newPassword)
			throws SecurityException {
		String trimmedPassword = null;
		if (newPassword != null)
			trimmedPassword = newPassword.trim();
		if (trimmedPassword == null || trimmedPassword.length() == 0)
			throw new SecurityException("Password is null or empty.");
		if (oldPassword == null || !password.equals(oldPassword))
			throw new SecurityException("Old password is not correct.");
		if (oldPassword.equals(newPassword))
			throw new SecurityException(
					"Altes und neues Kennwort muss unterschiedlich sein.");
		this.password = trimmedPassword;
		// Kennwort zur Historie hinzufuegen und Historie auf max. Laenge
		// kuerzen
		passwordHistory.add(oldPassword);
		while (passwordHistory.size() > historySize)
			passwordHistory.remove(0);

	}

	public void initPassword(String firstPassword) {
		this.firstPassword = firstPassword;
		password = firstPassword;
		passwordHistory.clear();

	}

	public void changePasswordRequest(String oldPassword, String newPassword)
			throws SecurityException {
		String trimmedPassword = null;
		if (newPassword != null)
			trimmedPassword = newPassword.trim();
		if (trimmedPassword == null || trimmedPassword.length() == 0)
			throw new SecurityException("Password is null or empty.");
		if (oldPassword == null || !password.equals(oldPassword))
			throw new SecurityException("Old password is not correct.");
		this.newPassword = trimmedPassword;

	}

	public void confirmPasswordRequest() {
		// Kennwort zur Historie hinzufuegen und Historie auf max. Laenge
		// kuerzen
		passwordHistory.add(password);
		while (passwordHistory.size() > historySize)
			passwordHistory.remove(0);
		password = newPassword;
		newPassword = null;

	}

	public void disable() {
		enabled = false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see db.training.security.User#enableUser()
	 */
	public void enable() {
		enabled = true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see db.training.security.User#lock()
	 */
	public void lock() {
		accountNonLocked = false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see db.training.security.User#unlock()
	 */
	public void unlock() {
		accountNonLocked = true;
		resetFailedLogin();
	}

	public int getLoginAttempts() {
		return failedLogin;
	}

	public void resetPassword() {
		password = firstPassword;
	}

	public int getHistorySize() {
		return historySize;
	}

	public void setHistorySize(int historySize) {
		this.historySize = historySize;
	}

	public boolean hasAuthorization(String authorizationName) {
		return false;
	}
}
