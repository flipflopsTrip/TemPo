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

import com.ssafit.video.model.dto.CReview;
import com.ssafit.video.model.dto.Comment;
import com.ssafit.video.model.dto.Review;
import com.ssafit.video.model.service.CReviewService;
import com.ssafit.video.model.service.CommentService;
import com.ssafit.video.model.service.ReviewService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/api-cReview")
@Api(tags="자유게시판 댓글 컨트롤러")
public class CReviewRestController {
    @Autowired
    private CReviewService cReviewService;

    @GetMapping("/cReview")
    @ApiOperation(value="댓글 조회", notes="게시글의 전체 댓글 목록")
    public ResponseEntity<?> getCReviewList(@RequestParam int id){
        List<CReview> list = cReviewService.getList(id);
        if(list == null || list.size() == 0)
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<List<CReview>>(list, HttpStatus.OK);
    }
    
    @PostMapping("/cReview")
    @ApiOperation(value="댓글 등록", notes="댓글 등록")
    public ResponseEntity<?> writeCReview(@RequestBody CReview cReview){
        int result = cReviewService.createCReview(cReview);
        if (result == 0) return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<Integer>(result, HttpStatus.OK);
    }
    
    @PutMapping("/cReview")
    @ApiOperation(value="댓글 수정", notes="댓글 수정")
    public ResponseEntity<?> modifyCReview(@RequestBody CReview cReview){
        int result = cReviewService.updateCReview(cReview);
        if (result == 0) return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<Integer>(result,HttpStatus.OK);
    }
    
    @DeleteMapping("/cReview/{cReviewId}")
    @ApiOperation(value="댓글 삭제", notes="댓글 삭제")
    public ResponseEntity<?> deleteCReview(@PathVariable int cReviewId){
        int result = cReviewService.removeCReview(cReviewId);
        if (result == 0) return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<Integer>(result, HttpStatus.OK);
    }
    
    @GetMapping("/myCReview/{userId}")
    @ApiOperation(value="특정 회원의 댓글 목록", notes="특정 회원의 댓글 목록 가져오기")
    public ResponseEntity<List<CReview>> getMyCReview(@PathVariable String userId) {
    	List<CReview> cReviews = cReviewService.getMyCReviewt(userId);
    	if (cReviews != null && cReviews.size() != 0)
    		return new ResponseEntity<List<CReview>>(cReviews, HttpStatus.OK);
    	else
    		return new ResponseEntity<List<CReview>>(cReviews, HttpStatus.NO_CONTENT);
    }
}
