package com.arcmind.jsfquickstart.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Calculator {

	private final Logger log = LoggerFactory.getLogger(Calculator.class);

	/** First number used in operation. */
	private int firstNumber = 0;
	/** Result of operation on first number and second number. */
	private int result = 0;
	/** Second number used in operation. */
	private int secondNumber = 0;

	/** Add the two numbers. */
	public void add() {
		log.debug("adding {} and {}", firstNumber, secondNumber);
		result = firstNumber + secondNumber;
	}

	/** Multiply the two numbers. */
	public void multiply() {
		log.debug("multiplying {} and {}", firstNumber, secondNumber);
		result = firstNumber * secondNumber;
	}

	/** Clear the results. */
	public void clear() {
		log.debug("clearing results");
		result = 0;
	}

	/* ---------- properties ------------- */
	public int getFirstNumber() {
		return firstNumber;
	}

	public void setFirstNumber(int firstNumber) {
		this.firstNumber = firstNumber;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	public int getSecondNumber() {
		return secondNumber;
	}

	public void setSecondNumber(int secondNumber) {
		this.secondNumber = secondNumber;
	}
}
