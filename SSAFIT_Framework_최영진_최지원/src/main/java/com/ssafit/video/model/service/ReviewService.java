package com.ssafit.video.model.service;

import java.util.List;

import com.ssafit.video.model.dto.Review;

public interface ReviewService {
	List<Review> getList(int videoId);
	Review getReview(int reviewId);
	int createReview(Review review);
	int updateReview(Review review);
	int removeReview(int reviewId);
	List<Review> getMyReview(String userId);
}
