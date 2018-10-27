package com.mahmoud.utils;

public interface IOperation {

	public int executeOperation();

	default int toInteger(String str) {
		int res = 0;
		try {
			res = Integer.parseInt(str);
		} catch (NumberFormatException nfe) {
		}
		return res;
	}
}
