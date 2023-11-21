package com.ssafit.video.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafit.video.model.dto.User;
import com.ssafit.video.model.service.UserService;
import com.ssafit.video.util.JwtUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/api-user")
@Api(tags="회원 컨트롤러")
public class UserRestController {
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	
	//UserService
	@Autowired
	private UserService userService;
	
	//JWT
	@Autowired
	private JwtUtil jwtUtil;
	
	@GetMapping("/user")
	@ApiOperation(value="전체 회원 목록", notes="전체 회원 목록 가져오기")
	public ResponseEntity<?> selectAll() {
		List<User> users = userService.selectAll();
		if (users == null || users.size() == 0) 
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		else 
			return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}
	
	@PostMapping("/user/{id}")
	@ApiOperation(value="회원 정보", notes="id와 일치하는 회원 가져오기")
	public ResponseEntity<User> selectOne(@PathVariable String id) {
		HttpStatus status = null;
		User user = userService.selectOne(id);
		System.out.println(user);
		
		if (user != null) status = HttpStatus.OK; 
		else status = HttpStatus.NO_CONTENT;
		
		return new ResponseEntity<User>(user, status);
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
	
	@PostMapping("/login")
	@ApiOperation(value="로그인", notes="아이디와 비밀번호를 이용한 로그인")
	public ResponseEntity<Map<String, Object>> login(@RequestBody User user) {
		HttpStatus status = null;
		HashMap<String, Object> result = new HashMap<>();
		try {
			//들어온 user가 null이 아니거나 작성되어 있고,
			if (user.getId() != null || user.getId().length() > 0) {
				User tmp = userService.login(user);
				System.out.println("가져온 유저: "+tmp);
				
				//가져온 유저 데이터가 null이 아니고 id가 있을 때 -> 로그인 성공
				if (tmp != null && tmp.getId() != null && tmp.getId().length() > 0) {
					result.put("access-token", jwtUtil.createToken("id", user.getId()));
					result.put("msg", SUCCESS);
					//result.put("loginMember", tmp);
					status = HttpStatus.ACCEPTED;
					
				} else {
					result.put("msg", FAIL);
					status = HttpStatus.UNAUTHORIZED; // 권한없음
				}
			} //if
			
		} catch (Exception e) {
			result.put("msg", FAIL);
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<Map<String, Object>>(result, status);
	}
	
	@GetMapping("/logout")
	@ApiOperation(value="로그아웃", notes="세션 소멸을 통한 로그아웃")
	public ResponseEntity<Void> logout(HttpSession session) {
		session.invalidate();
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@PostMapping("/find/id")
	@ApiOperation(value="아이디 찾기", notes="유저 name과 email을 받아서 아이디 반환")
	public ResponseEntity<String> findId(@RequestBody User user) {
		String userId = userService.getUserId(user);
		return new ResponseEntity<String>(userId, HttpStatus.OK);
	}
	
	@PostMapping("/find/pw")
	@ApiOperation(value="비밀번호 찾기", notes="유저 id과 email을 받아서 유저 반환")
	public ResponseEntity<User> findPw(@RequestBody User user) {
		User checkUser = userService.getUserForPw(user);
		return new ResponseEntity<User>(checkUser, HttpStatus.OK);
	}
	
	@PostMapping("/changePw")
	@ApiOperation(value="비밀번호 변경", notes="유저 id과 password을 받아서 비밀번호 변경")
	public ResponseEntity<String> changePw(@RequestBody User user) {
		System.out.println("들어온 유저: "+user);
		boolean result = userService.modifyPw(user);
		if (result) return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		else return new ResponseEntity<String>(FAIL, HttpStatus.OK);
	}
	
	
}











