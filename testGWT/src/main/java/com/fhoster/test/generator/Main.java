package com.fhoster.test.generator;

import java.io.IOException;

public class Main {

	public static void main(String[] args)
	{
		Generator generator = new Generator();
		try {
			generator.generate(1,1, false);
			System.out.println("Done");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
