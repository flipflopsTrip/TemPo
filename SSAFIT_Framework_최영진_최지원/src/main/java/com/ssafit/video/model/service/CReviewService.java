package com.ssafit.video.model.service;

import java.util.List;

import com.ssafit.video.model.dto.CReview;

public interface CReviewService {
	List<CReview> getList(int communityId);//자유게시판 댓글 리스트
	int createCReview(CReview cReview);
	int updateCReview(CReview cReview);
	int removeCReview(int cReviewId);
}
