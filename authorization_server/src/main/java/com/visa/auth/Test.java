package com.visa.auth;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Test {

	public static void main(String[] args) {
		BCryptPasswordEncoder e = new BCryptPasswordEncoder();
		System.out.println(e.encode("secret"));
	}

}
