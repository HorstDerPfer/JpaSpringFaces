package de.fmi.framework.core.util;

import javax.servlet.ServletContextEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import de.fmi.framework.core.dao.DaoFactory;
import de.fmi.framework.core.service.ServiceFactory;

public class ContextLoaderListener extends
		org.springframework.web.context.ContextLoaderListener {

	final Logger log = LoggerFactory.getLogger(ContextLoaderListener.class);

	@Override
	public void contextInitialized(ServletContextEvent event) {

		log.debug("Start initializing Object Factories");
		super.contextInitialized(event);

		WebApplicationContext wac = WebApplicationContextUtils
				.getWebApplicationContext(event.getServletContext());

		DaoFactory.getInstance().setWebApplicationContext(wac);
		ServiceFactory.getInstance().setWebApplicationContext(wac);

		log.debug("Finished initializing Object Factories");
	}
}
