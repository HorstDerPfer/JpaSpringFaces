package de.fmi.framework.core.security.ui;

public class CheckValidUser {

	private String userName;
	private String password;
	private boolean exist;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String pwd) {
		this.password = pwd;
	}

	public boolean isExist() {
		return exist;
	}

	public void setExist(boolean exist) {
		this.exist = exist;
	}

	public String checkUser() throws Exception {
		String status = "failure";
		
		return status;
	}
}
