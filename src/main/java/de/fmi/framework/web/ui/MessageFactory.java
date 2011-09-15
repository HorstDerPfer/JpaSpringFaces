package de.fmi.framework.web.ui;

import java.util.Locale;
import java.util.ResourceBundle;

import javax.faces.context.FacesContext;

public class MessageFactory {
	private ResourceBundle bundle;
	private Locale locale;

	public MessageFactory() {
		this.locale = FacesContext.getCurrentInstance().getViewRoot()
				.getLocale();
		this.bundle = ResourceBundle.getBundle(
				"de.fmi.framework.web.ui.messages", locale);
	}

	public String getMessage(String key) {
		return bundle.getString(key);
	}
}
