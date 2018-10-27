package com.mahmoud.client.util;

public class ObjectInput {
	private int option;
	private String input;
	private int powerOption;

	public ObjectInput(int option, String input, int powerOption) {
		super();
		this.option = option;
		this.input = input;
		this.powerOption = powerOption;
	}

	@Override
	public String toString() {
		return option + ":" + input + ":" + powerOption;
	}

}
