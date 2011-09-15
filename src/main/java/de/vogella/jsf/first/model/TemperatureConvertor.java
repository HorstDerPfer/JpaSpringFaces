package de.vogella.jsf.first.model;

import java.util.List;

import de.fmi.framework.core.model.User;
import de.fmi.framework.core.service.ServiceFactory;
import de.fmi.framework.core.service.UserService;

public class TemperatureConvertor {
	private double celsius;
	private double fahrenheit;
	private boolean initial = true;

	public void setCelsius(double celsius) {
		this.celsius = celsius;
	}

	public double getCelsius() {
		return celsius;
	}

	public void setFahrenheit(double fahrenheit) {
		this.fahrenheit = fahrenheit;
	}

	public double getFahrenheit() {
		return fahrenheit;
	}

	public void setInitial(boolean initial) {
		this.initial = initial;
	}

	public boolean isInitial() {
		return initial;
	}

	public String reset() {
		initial = true;
		fahrenheit = 0;
		celsius = 0;
		return "reset";
	}

	public String celsiusToFahrenheit() {
		final UserService service = ServiceFactory.getInstance()
				.getUserService();
		List<User> users = service.findAllUsers();

		initial = false;
		fahrenheit = (celsius * 9 / 5) + 32;
		return "calculated";
	}
}
