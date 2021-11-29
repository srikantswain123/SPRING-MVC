package com.nt.clear;

import java.util.Arrays;
import java.util.Locale;

public class Test {
	public static void main(String[] args) {
		String [] str=Locale.getISOLanguages();
		for(String st:str) {
			Locale lo=new Locale(st);
			System.out.println();
		}
	}

}
