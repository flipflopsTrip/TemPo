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

import com.ssafit.video.model.dto.Comment;
import com.ssafit.video.model.dto.Review;
import com.ssafit.video.model.service.CommentService;
import com.ssafit.video.model.service.ReviewService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/api-comment")
@Api(tags="운동영상 리뷰 댓글 컨트롤러")
public class CommentRestController {
    @Autowired
    private CommentService commentService;

    @GetMapping("/comment")
    @ApiOperation(value="댓글 조회", notes="해당 영상 리뷰글의 전체 댓글 목록")
    public ResponseEntity<?> getCommentList(@RequestParam int id){
        List<Comment> list = commentService.getList(id);
        System.out.println(id);//id 잘 갖고있음
        if(list == null || list.size() == 0)
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<List<Comment>>(list, HttpStatus.OK);
    }
    
    @PostMapping("/comment")
    @ApiOperation(value="댓글 등록", notes="댓글 등록")
    public ResponseEntity<?> writeComment(@RequestBody Comment comment){
        int result = commentService.createComment(comment);
        if (result == 0) return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<Comment>(HttpStatus.OK);
    }
    
    @PutMapping("/comment")
    @ApiOperation(value="댓글 수정", notes="댓글 수정")
    public ResponseEntity<?> modifyComment(@RequestBody Comment comment){
        int result = commentService.updateComment(comment);
        if (result == 0) return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<Comment>(HttpStatus.OK);
    }
    
    @DeleteMapping("/comment/{id}")
    @ApiOperation(value="댓글 삭제", notes="댓글 삭제")
    public ResponseEntity<?> deleteComment(@PathVariable int id){
        int result = commentService.removeComment(id);
        if (result == 0) return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<Integer>(result, HttpStatus.OK);
    }
    
    @GetMapping("/myComment/{userId}")
    @ApiOperation(value="특정 회원의 댓글 목록", notes="특정 회원의 댓글 목록 가져오기")
    public ResponseEntity<List<Comment>> getMyComment(@PathVariable String userId) {
    	List<Comment> comments = commentService.getMyComment(userId);
    	if (comments != null && comments.size() != 0)
    		return new ResponseEntity<List<Comment>>(comments, HttpStatus.OK);
    	else
    		return new ResponseEntity<List<Comment>>(comments, HttpStatus.NO_CONTENT);
    }
}
