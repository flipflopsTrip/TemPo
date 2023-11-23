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

import com.ssafit.video.model.dto.Review;
import com.ssafit.video.model.service.ReviewService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/api-review")
@Api(tags="리뷰 컨트롤러")
public class ReviewRestController {
    @Autowired
    private ReviewService reviewService;
    //목록, 등록, 수정, 상세, 삭제
    @GetMapping("/review")
    @ApiOperation(value="리뷰 조회", notes="해당 비디오의 전체 리뷰 목록")
    public ResponseEntity<?> getReviewList(@RequestParam int videoId){
        List<Review> list = reviewService.getList(videoId);
        if(list == null || list.size() == 0)
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<List<Review>>(list, HttpStatus.OK);
    }
    
    @GetMapping("/review/{reviewId}")
    @ApiOperation(value="리뷰 상세 조회", notes="리뷰 상세 조회")
    public ResponseEntity<?> getReview(@PathVariable int reviewId){
        Review review = reviewService.getReview(reviewId);
        if (review == null) return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<Review>(review, HttpStatus.OK);
    }
    
    @PostMapping("/review/{id}")
    @ApiOperation(value="리뷰 등록", notes="리뷰 등록")
    public ResponseEntity<?> writeReview(@RequestBody Review review, @PathVariable int id){
        int result = reviewService.createReview(review);
        if (result == 0) return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<Review>(reviewService.getReview(review.getReviewId()), HttpStatus.OK);
    }
    
    @PutMapping("/review")
    @ApiOperation(value="리뷰 수정", notes="리뷰 수정")
    public ResponseEntity<?> modifyReview(@RequestBody Review review){
        int result = reviewService.updateReview(review);
        if (result == 0) return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<Review>(reviewService.getReview(review.getReviewId()), HttpStatus.OK);
    }
    
    @DeleteMapping("/review/{id}")
    @ApiOperation(value="리뷰 삭제", notes="리뷰 삭제")
    public ResponseEntity<?> deleteReview(@PathVariable int id){
        int result = reviewService.removeReview(id);
        if (result == 0) return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<Integer>(result, HttpStatus.OK);
    }
    
    @GetMapping("/myReview/{userId}")
    @ApiOperation(value="특정 회원의 리뷰 목록", notes="특정 회원의 리뷰 목록 가져오기")
    public ResponseEntity<List<Review>> getMyReview(@PathVariable String userId) {
    	List<Review> reviews = reviewService.getMyReview(userId);
    	if (reviews != null && reviews.size() != 0)
    		return new ResponseEntity<List<Review>>(reviews, HttpStatus.OK);
    	else
    		return new ResponseEntity<List<Review>>(reviews, HttpStatus.NO_CONTENT);
    }
}
