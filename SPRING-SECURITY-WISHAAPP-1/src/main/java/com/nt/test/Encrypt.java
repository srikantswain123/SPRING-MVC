package com.nt.test;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Encrypt {

	public static void main(String[] args) {
		BCryptPasswordEncoder encoder=new BCryptPasswordEncoder(15);
		System.out.println(encoder.encode("rani"));
		System.out.println(encoder.encode("umesh123"));
		System.out.println(encoder.encode("rajesh123"));
		System.out.println(encoder.encode("ritesh123"));

	}

}
