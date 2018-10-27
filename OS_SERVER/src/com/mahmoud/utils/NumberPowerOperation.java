package com.mahmoud.utils;

public class NumberPowerOperation implements IOperation {
	private final String input;
	private final int power;

	public NumberPowerOperation(String input, int power) {
		super();
		this.input = input;
		this.power = power;
	}

	@Override
	public int executeOperation() {
		int integer = toInteger(input);
		return (int) (integer == 0 ? 0 : Math.pow(integer, power));
	}

}
