package com.ssafit.video.model.dao;

import java.util.List;
import com.ssafit.video.model.dto.Comment;

public interface CommentDao {
	//리뷰 게시글의 댓글 리스트
	public List<Comment> selectAll(int reviewId);
	//댓글 달기
	public int insertComment(Comment comment);
	//댓글 수정
	public int updateComment(Comment comment);
	//댓글 삭제
	public int deleteComment(int commentId);
}
