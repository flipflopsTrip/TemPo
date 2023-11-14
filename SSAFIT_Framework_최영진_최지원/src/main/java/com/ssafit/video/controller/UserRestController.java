package com.ssafit.video.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafit.video.model.dto.User;
import com.ssafit.video.model.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/api-user")
@Api(tags="회원 컨트롤러")
public class UserRestController {
	
	//UserService 주입
	@Autowired
	private UserService userService;
	
	@GetMapping("/user")
	@ApiOperation(value="전체 회원 목록", notes="전체 회원 목록 가져오기")
	public ResponseEntity<?> selectAll() {
		List<User> users = userService.selectAll();
		if (users == null || users.size() == 0) 
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		else 
			return new ResponseEntity<List<User>>(users, HttpStatus.OK);
		
	}
	
	//회원가입을 해보자 form 태그 형식으로 넘어왔다.
	@PostMapping("/user")
	@ApiOperation(value="회원가입", notes="회원가입(회원 정보 등록)")
	public ResponseEntity<?> signup(@RequestBody User user) {
		int result = userService.signup(user);		
		//result 가 0이면 등록 x
		if (result == 0) return new ResponseEntity<Void>(HttpStatus.FORBIDDEN);
		//result 가 1이면 등록 o
		else return new ResponseEntity<Integer>(result, HttpStatus.CREATED);
	}	
	
	@PostMapping("login")
	@ApiOperation(value="로그인", notes="아이디와 비밀번호를 이용한 로그인")
	public ResponseEntity<?> login(@RequestBody User user, HttpSession session) {
		User tmp = userService.login(user);
		if(tmp == null)
//			return new ResponseEntity<Void>(HttpStatus.UNAUTHORIZED);
			return new ResponseEntity<String>("", HttpStatus.OK);
		
		session.setAttribute("loginUser", tmp);
		return new ResponseEntity<String>(tmp.getId(), HttpStatus.OK);
	}
	
	@GetMapping("logout")
	@ApiOperation(value="로그아웃", notes="세션 소멸을 통한 로그아웃")
	public ResponseEntity<Void> logout(HttpSession session) {
		session.invalidate();
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}