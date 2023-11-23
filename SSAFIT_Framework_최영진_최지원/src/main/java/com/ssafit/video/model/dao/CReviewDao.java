package com.ssafit.video.model.dao;

import java.util.List;

import com.ssafit.video.model.dto.CReview;

public interface CReviewDao {
	//자유게시판 댓글 리스트
	public List<CReview> selectAll(int communityId);
	//댓글 달기
	public int insertCReview(CReview cReview);
	//댓글 수정
	public int updateCReview(CReview cReview);
	//댓글 삭제
	public int deleteCReview(int cReviewId);
	//회원의 자유게시판 댓글 리스트
	public List<CReview> selectMyCReview(String userId);
}
