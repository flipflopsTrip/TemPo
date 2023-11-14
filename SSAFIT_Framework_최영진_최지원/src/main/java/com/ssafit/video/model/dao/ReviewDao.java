package com.ssafit.video.model.dao;

import java.util.List;

import com.ssafit.video.model.dto.Review;

public interface ReviewDao {
    
    //리뷰 목록
    public List<Review> selectAll(int videoId);
    
    //리뷰 상세
    public Review selectOne(int reviewId);
    
    //리뷰 등록
    public int insertReview(Review review);
    
    //리뷰 수정
    public int updateReview(Review review);    
    
    //리뷰 삭제
    public int deleteReview(int reviewId);
    
    //리뷰 조회수 증가
    public int updateViewCnt(int reviewId);

}
