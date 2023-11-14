package com.ssafit.video.model.dao;

import java.util.List;

import com.ssafit.video.model.dto.User;

public interface UserDao {

	int insertUser(User user);//가입시 사용
	
	User selectOne(String id);//로그인 시 사용

	List<User> selectAll(); //회원 전체 목록
	
}