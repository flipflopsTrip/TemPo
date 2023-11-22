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

import com.ssafit.video.model.dto.Community;
import com.ssafit.video.model.dto.SearchCondition;
import com.ssafit.video.model.service.CommunityService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("/api-community")
@Api(tags="자유게시판 컨트롤러")
public class CommunityRestController {

	@Autowired
	private CommunityService communityService;

	//전체 글 조회
	@GetMapping("/community")
	@ApiOperation(value="게시글 조회", notes="자유게시판의 전체 글 조회")
	public ResponseEntity<?> list(SearchCondition condition){//, @RequestParam int communityId
		List<Community> list = communityService.search(condition);
		if(list == null || list.size() == 0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<Community>>(list, HttpStatus.OK);
	}
	
	//글 상세 조회
	@GetMapping("/community/{id}")
	@ApiOperation(value="게시글 상세 조회", notes="게시글 상세 조회")
	public ResponseEntity<Community> detail(@PathVariable int id){
		Community community = communityService.getCommunity(id);
		System.out.println(community+"=========");
		return new ResponseEntity<Community>(community, HttpStatus.OK);
	}
	
	//글 등록
	@PostMapping("/community")///{communityId}
	@ApiOperation(value="게시글 등록", notes="게시글 등록")
	public ResponseEntity<?> write(@RequestBody Community community){ //, @PathVariable int communityId
		System.out.println(community+"=========");
		int result = communityService.writeCommunity(community);
		if (result == 0) return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<Community>(communityService.getCommunity(community.getCommunityId()), HttpStatus.CREATED);
	}
	
	//글 삭제
	@DeleteMapping("/community/{communityId}")
	@ApiOperation(value="게시글 삭제", notes="게시글 삭제")	
	public ResponseEntity<Void> delete(@PathVariable int communityId){
		communityService.removeCommunity(communityId);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	//글 수정
	@ApiIgnore
	@PutMapping("/community")
	@ApiOperation(value="게시글 수정", notes="게시글 수정")
	public ResponseEntity<?> update(@RequestBody Community community){//, @PathVariable int communityId
		System.out.println(community);
		communityService.modifyCommunity(community);
		return new ResponseEntity<Integer>(community.getCommunityId(),HttpStatus.OK);
	}
}
