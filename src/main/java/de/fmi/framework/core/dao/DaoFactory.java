package de.fmi.framework.core.dao;

import org.springframework.web.context.WebApplicationContext;

public class DaoFactory {

	private WebApplicationContext wac;

	private static DaoFactory instance;

	private DaoFactory() {
	}

	public static DaoFactory getInstance() {
		if (instance == null)
			instance = new DaoFactory();

		return instance;
	}

	public void setWebApplicationContext(WebApplicationContext wac) {
		this.wac = wac;
	}
}
