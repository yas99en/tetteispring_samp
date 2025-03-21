package com.example.domain.service;

import org.springframework.stereotype.Component;

@Component
public class CalcService {
	public int calc(int input) {
		System.out.println("CalcService calc 実行");
		return input * 2;
	}
}
