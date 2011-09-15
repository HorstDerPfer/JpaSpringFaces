package de.fmi.framework.core.service;

import org.springframework.web.context.WebApplicationContext;

public class ServiceFactory {
	private WebApplicationContext wac;

	private static ServiceFactory instance;

	private ServiceFactory() {
	}

	public static ServiceFactory getInstance() {
		if (instance == null)
			instance = new ServiceFactory();

		return instance;
	}

	public void setWebApplicationContext(WebApplicationContext wac) {
		this.wac = wac;
	}

	public UserService getUserService() {
		return (UserService) wac.getBean("userService");
	}
}
