package de.fmi.framework.core.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

import org.hibernate.Hibernate;

@MappedSuperclass
public abstract class IdentityFieldProvider implements Serializable {

	private static final long serialVersionUID = -2732568426897736141L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", nullable = false, insertable = true, updatable = true)
	private Integer id;

	@Transient
	private Integer cachedHashCode;

	/**
	 * @see http 
	 *      ://computinglife.wordpress.com/2008/11/20/why-do-hash-functions-use
	 *      -prime-numbers
	 */
	@Transient
	private final int HashMultiplier = 31;

	public Integer getId() {
		return id;
	}

	protected void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @see http
	 *      ://nhforge.org/blogs/nhibernate/archive/2008/09/06/identity-field
	 *      -equality-and-hash-code.aspx
	 * @see http
	 *      ://github.com/codai/Sharp-Architecture/blob/master/src/SharpArch/
	 *      SharpArch.Core/DomainModel/Entity.cs
	 */
	@Override
	public int hashCode() {
		// ein Objekt muss immer denselben HashCode besitzen
		if (cachedHashCode != null)
			return cachedHashCode;

		boolean thisIsTransient = (this.id == null);

		if (thisIsTransient) {
			cachedHashCode = super.hashCode();
		} else {

			int hashCode = getClass().hashCode();
			cachedHashCode = (hashCode * HashMultiplier) ^ id.hashCode();

		}

		return cachedHashCode;
	}

	/**
	 * @see http
	 *      ://nhforge.org/blogs/nhibernate/archive/2008/09/06/identity-field
	 *      -equality-and-hash-code.aspx
	 */
	@Override
	public boolean equals(Object obj) {

		if (obj == null)
			return false;

		if (Hibernate.getClass(this) != Hibernate.getClass(obj))
			return false;

		final IdentityFieldProvider other = (IdentityFieldProvider) obj;

		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format("IdentityFieldProvider Id=%d", this.id);
	}
}
