package com.ssafit.video.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafit.video.model.dao.CommentDao;
import com.ssafit.video.model.dto.Comment;

@Service
public class CommentServiceImpl implements CommentService {
	@Autowired
	CommentDao commentDao;
	@Override
	public List<Comment> getList(int reviewId) {
		return commentDao.selectAll(reviewId);
	}

	@Override
	public int createComment(Comment comment) {
		return commentDao.insertComment(comment);
	}

	@Override
	public int updateComment(Comment comment) {
		return commentDao.updateComment(comment);
	}

	@Override
	public int removeComment(int commentId) {
		return commentDao.deleteComment(commentId);
	}
	
	@Override
	public List<Comment> getMyComment(String userId) {
		return commentDao.selectMyComment(userId);
	}
}
