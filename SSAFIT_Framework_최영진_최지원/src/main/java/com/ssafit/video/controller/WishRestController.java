package com.ssafit.video.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafit.video.model.dto.Review;
import com.ssafit.video.model.dto.Video;
import com.ssafit.video.model.dto.Wish;
import com.ssafit.video.model.service.WishService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api-wish")
@Api(tags="찜 컨트롤러")
public class WishRestController {

	@Autowired
	WishService wishService;
	
	@GetMapping("/wish")
	@ApiOperation(value="찜 목록 조회", notes="해당 유저의 전체 찜 비디오 목록")
	public ResponseEntity<?> getWishList(@RequestParam String userId){
		List<Video> list = wishService.getWishList(userId);
		if(list == null || list.size() == 0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<Video>>(list, HttpStatus.OK);
	}
	
	@GetMapping("/wish/{id}")
	@ApiOperation(value="찜 확인", notes="찜한 영상인지 확인")
	public ResponseEntity<?> isWish(@PathVariable int id, @RequestParam String userId){
		boolean iswish = wishService.isWish(id, userId);
		return new ResponseEntity<Integer>(iswish ? 1:0, HttpStatus.OK);//1이면 찜, 안했으면 0
	}
	
	@PostMapping("/wish/{id}")
	@ApiOperation(value="찜하기/취소", notes="찜하기/취소")
	public ResponseEntity<?> setWish(@PathVariable int id, @RequestParam String userId){
		boolean iswish = wishService.isWish(id, userId);//(videoId, userId)
		int result;
		if(iswish) 
			result = wishService.removeWish(id, userId);
		else result = wishService.makeWish(id, userId);//변경하고
		if (result == 0) return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<Integer>(!iswish ? 1:0, HttpStatus.OK);//변경했으면 수정 후 상태 리턴
	}
}
