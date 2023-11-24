package com.ssafit.video.model.service;

import java.util.List;

import com.ssafit.video.model.dto.User;

public interface UserService {

	int signup(User user);//가입

	User login(User user);//로그인

	List<User> selectAll();

	User selectOne(String id);

	String getUserId(User user);

	User getUserForPw(User user);

	boolean modifyPw(User user);

	
}