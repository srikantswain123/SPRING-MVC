package com.nt.service;

import java.util.Calendar;

import org.springframework.stereotype.Service;

@Service("wishService")
public class WishMessageGeneratorImpl implements IWishMessageGenerator {

	@Override
	public String wishMessageGenerator() {
		Calendar cal=Calendar.getInstance();
		int hour=cal.get(Calendar.HOUR_OF_DAY);
		if(hour<12)
		return "Good Morning";
		else if(hour<16)
			return "good afternoon";
		else if(hour<20)
			return "good evening";
		else
			return "good night";
	}

}
