package com.ssafit.video.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafit.video.model.dao.UserDao;
import com.ssafit.video.model.dto.User;


@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	@Transactional
	public int signup(User user) {
		//중복 가입 방지를 위해 여기서 체크를 해준 후에 userDao.insertUser(user)로 넘어가야하는데
		User tmp = userDao.selectOne(user.getId());
		if(tmp == null) return userDao.insertUser(user); //없는 id이면 
		else return 0;
//		return userDao.insertUser(user);
	}

	@Override
	public User login(User user) {
		//DB 해당 ID만 넘겨서 데이터를 가지고 오고 가지고온 User 데이터와 내가 현재 가지고 있는 user의 비밀번호를 확인하면
		User tmp = userDao.selectOne(user.getId());
		//tmp가 실제 User 정보 일수도 있고 / null 넘어왔다.
		if(tmp != null && tmp.getPassword().equals(user.getPassword()))
			return tmp;
		return null;
	}

	@Override
	public List<User> selectAll() {
		return userDao.selectAll();
	}

	@Override
	public User selectOne(String id) {
		User tmp = userDao.selectOne(id);
		if (tmp != null) {
			tmp.setPassword(null);
			return tmp;
		}
		return null;
	}
	
	@Override
	public String getUserId(User user) {
		String userId = userDao.selectId(user);
		if (userId != null) return userId; //아이디 존재하면 반환
		return null;
	}
	
	@Override
	public User getUserForPw(User user) {
		User tmp = userDao.selectForPw(user);
		if (tmp != null) return tmp;
		return null;
	}
	
	@Override
	@Transactional
	public boolean modifyPw(User user) {
		if (userDao.updatePw(user) > 0) return true; //성공
		return false; //실패
	}

}


