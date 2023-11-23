package com.ssafit.video.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafit.video.model.dao.ReviewDao;
import com.ssafit.video.model.dto.Review;

@Service
public class ReviewServiceImpl implements ReviewService {
	
	@Autowired
	ReviewDao reviewDao;

	@Override
	public List<Review> getList(int videoId) {
		return reviewDao.selectAll(videoId);
	}

	@Override
	public Review getReview(int reviewId) {
		reviewDao.updateViewCnt(reviewId);
		return reviewDao.selectOne(reviewId);
	}

	@Override
	public int createReview(Review review) {
		return reviewDao.insertReview(review);
	}

	@Override
	public int updateReview(Review review) {
		return reviewDao.updateReview(review);
	}

	@Override
	public int removeReview(int reviewId) {
		return reviewDao.deleteReview(reviewId);
	}
	
	@Override
	public List<Review> getMyReview(String userId) {
		return reviewDao.selectMyReview(userId);
	}
	
}
