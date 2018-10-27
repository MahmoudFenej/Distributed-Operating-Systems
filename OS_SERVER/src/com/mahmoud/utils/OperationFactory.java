package com.mahmoud.utils;

public class OperationFactory {
	public static IOperation getOperation(String input) {
		int option = getOption(input);
		String opInput = getInput(input);
		int numberPower = getNumberPower(input);
		switch (option) {
		case 1:
			return new CountingLengthOperation(opInput);
		case 2:
			return new NumberFactorialOperation(opInput);
		case 3:
			return new NumberPowerOperation(opInput, numberPower);
		default:
			return null;
		}
	}
	
	private static int getOption(String input) {
		return Integer.parseInt(input.substring(0,1));
	}

	private static String getInput(String input) {
		return input.substring(input.indexOf(":")+1, input.lastIndexOf(":"));
	}

	private static int getNumberPower(String input) {
		return  Integer.parseInt(input.substring(input.lastIndexOf(":")+1, input.length()));
	}
}
