package com.ssafit.video.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafit.video.model.dto.Weight;
import com.ssafit.video.model.service.MypageService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/api-mypage")
@Api(tags="마이페이지 컨트롤러")
public class MyPageRestController {
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	
	//MypageService
	@Autowired
	private MypageService mypageService;
	
	@GetMapping("/weight/{userId}")
	@ApiOperation(value="회원의 몸무게 목록", notes="회원의 몸무게 목록 가져오기")
	public ResponseEntity<?> selectWeight(@PathVariable String userId) {
		List<Weight> weights = mypageService.getWeight(userId);
		if (weights == null || weights.size() == 0) 
			return new ResponseEntity<String>(SUCCESS, HttpStatus.NO_CONTENT);
		else 
			return new ResponseEntity<List<Weight>>(weights, HttpStatus.OK);
	}
	
	@PostMapping("/weight")
	@ApiOperation(value="몸무게 저장or수정", notes="회원의 몸무게 데이터 저장 혹은 수정")
	public ResponseEntity<String> writeWeight(@RequestBody Weight weight) {
		boolean result = mypageService.createOrModifyWeight(weight);
		if (result) return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		else return new ResponseEntity<String>(FAIL, HttpStatus.OK);
	}
	
	
}











