package com.nt.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;
@Service("service")
public class WishMsgServiceImpl implements IwishMessageService {

	@Override
	public String getWmsg() {
		//get Date time
	LocalDateTime dt=LocalDateTime.now();
	int hour=dt.getHour()+1;
	if(hour<12)
		return "good morning";
	else if(hour<16)
		return "good AfterNoon";
	else if(hour<20)
		return "good evening";
	else
		return "good night";
	}

}
