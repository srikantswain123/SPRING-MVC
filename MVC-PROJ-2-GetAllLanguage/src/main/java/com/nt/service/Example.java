package com.nt.service;

import java.util.Locale;
import java.util.TreeSet;

public class Example {

	public static void main(String[] args) {
		String str[]=Locale.getISOLanguages();
		TreeSet<String> set=new TreeSet<String>();
		for(String st:str) {
			Locale l=new Locale(st);
			set.add(l.getDisplayLanguage());
			
		}
		System.out.println(set);
		

	}

}
