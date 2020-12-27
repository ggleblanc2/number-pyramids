package com.ggl.testing;

public class NumberPyramids {

	public static void main(String[] args) {
		new NumberPyramids().createPyramids(8);
	}
	
	public void createPyramids(int range) {
		String line = createOutputString(1, range, range, false);
		String format1 = "%-" + (line.length() + 3) + "s";
		String format2 = "%" + line.length() + "s";
		String format3 = "%" + Integer.toString(range).length() + "s";
		
		System.out.println(createHeader(format1, format3));
		
		for (int i = 1; i <= range; i++) {
			String string = createPyramidLine(i, range,	format1, format2);
			System.out.println(string);
		}
	}
	
	private String createHeader(String format1, String format3) {
		StringBuilder builder = new StringBuilder();
		
		builder.append(String.format(format3, " "));
		builder.append(String.format(format1, "Pattern I"));
		builder.append(String.format(format1, "Pattern II"));
		builder.append(String.format(format1, "Pattern III"));
		builder.append(String.format(format1, "Pattern IV"));
		
		return builder.toString();
	}

	private String createPyramidLine(int index, int range, 
			String format1, String format2) {
		StringBuilder builder = new StringBuilder();
		int j = range - index + 1;
		
		String line = createOutputString(1, index, range, false);
		builder.append(String.format(format1, line));
		line = createOutputString(1, j, range, false);
		builder.append(String.format(format1, line));
		line = createOutputString(1, index, range, true);
		builder.append(String.format(format1, line));
		line = createOutputString(1, j, j, false);
		builder.append(String.format(format2, line));
		
		return builder.toString();
	}
	
	private String createOutputString(int minimum, int maximum, 
			int range, boolean reverse) {
		String test = Integer.toString(range);
		int length = test.length() + 1;
		String format1 = "%" + length + "d";
		String format2 = "%" + length + "s";
		String string;
		StringBuilder builder = new StringBuilder();
		
		if (reverse) {
			for (int i = range; i >= 1; i--) {
				string = createString(minimum, maximum, format1, format2, i);
				builder.append(string);
			}
		} else {
			for (int i = 1; i <= range; i++) {
				string = createString(minimum, maximum, format1, format2, i);
				builder.append(string);
			}
		}
		
		return builder.toString();
	}

	private String createString(int minimum, int maximum, 
			String format1, String format2, int index) {
		if (index >= minimum && index <= maximum) {
			return String.format(format1, index);
		} else {
			return String.format(format2, " ");
		}
	}

}
