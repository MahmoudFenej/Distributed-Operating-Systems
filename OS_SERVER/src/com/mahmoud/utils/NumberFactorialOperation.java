package com.mahmoud.utils;

public class NumberFactorialOperation implements IOperation {
	private String input;

	public NumberFactorialOperation(String input) {
		super();
		this.input = input;
	}

	@Override
	public int executeOperation() {
		Integer integer = toInteger(input);
		return integer == 0 ? 0 : factorial(integer);
	}

	public Integer factorial(Integer n) {
		if (n == 1) {
			return 1;
		}
		return n * (factorial(n - 1));
	}
}
