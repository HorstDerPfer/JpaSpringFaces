/**
 * 
 */
package de.fmi.framework.core.util;

import java.sql.Types;

/**
 * @author michels
 * 
 *         bildet den Hibernate Typ 'bit' auf dem MySQL Typ 'tinyint(1)' ab.
 * 
 */
public class MySQL5InnoDBDialect extends
		org.hibernate.dialect.MySQL5InnoDBDialect {

	public MySQL5InnoDBDialect() {
		super();

		registerColumnType(Types.BIT, "tinyint(1)");
	}
}
