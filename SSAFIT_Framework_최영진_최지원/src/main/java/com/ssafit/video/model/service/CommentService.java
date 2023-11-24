package com.ssafit.video.model.service;

import java.util.List;

import com.ssafit.video.model.dto.Comment;

public interface CommentService {
	List<Comment> getList(int reviewId);//비디오 리뷰의 comment 리스트
	int createComment(Comment comment);
	int updateComment(Comment comment);
	int removeComment(int commentId);
	List<Comment> getMyComment(String userId);
}
