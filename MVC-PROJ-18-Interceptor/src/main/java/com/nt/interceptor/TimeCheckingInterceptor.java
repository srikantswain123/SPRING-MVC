package com.nt.interceptor;

import java.time.LocalDateTime;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component("tci")
public class TimeCheckingInterceptor implements HandlerInterceptor {
	
   @Override
   	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
   			throws Exception {
   		LocalDateTime sysdate=LocalDateTime.now();
   		int hour=sysdate.getHour();
   		if(hour<9 ||hour>17) {
   			RequestDispatcher rd=request.getRequestDispatcher("/time.jsp");
   			rd.forward(request, response);
   			return false;
   		}else {
   		return true;
   		}
   	}	

}
