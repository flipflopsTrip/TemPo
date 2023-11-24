package com.ssafit.video.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafit.video.model.dto.LevelVote;
import com.ssafit.video.model.dto.Video;
import com.ssafit.video.model.service.LevelVoteService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api-levelVote")
@Api(tags = "난이도 투표 컨트롤러")
public class LevelVoteRestController {

	@Autowired
	LevelVoteService levelVoteService;

	@GetMapping("/levelVote")
	@ApiOperation(value = "난이도 투표 결과 조회", notes = "평균값 반환")
	public ResponseEntity<?> getLevel(@RequestParam int id) {// 비디오id
		int result = levelVoteService.getAverageLevel(id); // 레벨 값 들어있음
		if (result == 0) {
			return new ResponseEntity<Integer>(result, HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Integer>(result, HttpStatus.OK);// 레벨값 리턴됨
	}

	@GetMapping("/levelVote/{videoId}/{userId}") // 비디오id
	@ApiOperation(value = "사용자 투표 결과", notes = "본인 투표 결과 확인")
	public ResponseEntity<?> getMyVote(@PathVariable("videoId") int videoId, @PathVariable("userId") String userId) {// 비디오id,
																														// 유저id
		LevelVote result = levelVoteService.getUserVote(userId, videoId);// SELECT * 로 LevelVote 반환
		int yet = 0;// 만약 투표 아직 안했다면
		if (result == null)// 만약 투표 아직 안했다면
			return new ResponseEntity<Integer>(yet, HttpStatus.OK);// 투표 없어도 문제는 아님.
		return new ResponseEntity<LevelVote>(result, HttpStatus.OK);// 결과 있으면 전체 LevelVote 객체를 리턴
	}

	@PostMapping("/levelVote")
	@ApiOperation(value = "영상 난이도 투표 또는 기존 투표 수정", notes = "난이도 1~5 투표하기")
	public ResponseEntity<?> createVote(@RequestBody LevelVote levelVote) {
		int result = levelVoteService.createOrUpdateVote(levelVote);// 등록했다면 1, 수정됬다면 2
		return new ResponseEntity<Integer>(result, HttpStatus.OK);
	}
	
	@GetMapping("/levelVote/list")
	@ApiOperation(value="투표영상 목록 조회", notes="해당 유저가 투표한 전체 비디오 목록")
	public ResponseEntity<?> getVoteList(@RequestParam String userId){
		List<Video> list = levelVoteService.getVoteList(userId);
		if(list == null || list.size() == 0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<Video>>(list, HttpStatus.OK);
	}

}
