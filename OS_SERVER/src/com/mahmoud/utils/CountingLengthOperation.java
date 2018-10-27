package com.mahmoud.utils;

public class CountingLengthOperation implements IOperation{
	private final String input;
	
	public CountingLengthOperation(String input) {
		super();
		this.input = input;
	}

	@Override
	public int executeOperation() {
		return input.length();
	}

}
