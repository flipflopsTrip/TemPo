package com.ssafit.video.util;

import java.io.UnsupportedEncodingException;
import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtil {
	private static final String SALT = "SSAFIT";
	private static final long EXP_TIME = 1000L * 60 * 10; //10분
	
	//토큰 생성, 유효기간 10분
	public String createToken(String key, String value) throws UnsupportedEncodingException {
		return Jwts.builder()
			.setHeaderParam("alg", "HS256")
			.setHeaderParam("typ", "JWT") //헤더
			.claim(key, value)
			.setExpiration(new Date(System.currentTimeMillis() + EXP_TIME)) //10분 페이로드
			.signWith(SignatureAlgorithm.HS256, SALT.getBytes("UTF-8")) //서명
			.compact();
	}
	
	//토큰 유효성 검사
	public void valid(String token) throws Exception {
		Jwts.parser().setSigningKey(SALT.getBytes("UTF-8")).parseClaimsJws(token);
	}
	
} //class
