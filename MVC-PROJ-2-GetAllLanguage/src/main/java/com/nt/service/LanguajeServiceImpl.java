package com.nt.service;

import java.util.Locale;
import java.util.TreeSet;

public class LanguajeServiceImpl implements IAllLanguageService {

	@Override
	public TreeSet getLanguajes() {
		String str[]=Locale.getISOLanguages();
		TreeSet<String> set=new TreeSet<String>();
		for(String l:str) {
			Locale loc=new Locale(l);
			set.add(loc.getDisplayLanguage());
		}
		
		return set;
	}

}
