package com.ssafit.video.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafit.video.model.dao.CReviewDao;
import com.ssafit.video.model.dto.CReview;

@Service
public class CReviewServiceImpl implements CReviewService {
	@Autowired
	CReviewDao cReviewDao;
	@Override
	public List<CReview> getList(int communityId) {
		return cReviewDao.selectAll(communityId);
	}
	
	@Override
	public int createCReview(CReview cReview) {
		int result = cReviewDao.insertCReview(cReview);
		return result;
	}

	@Override
	public int updateCReview(CReview cReview) {
		return cReviewDao.updateCReview(cReview);
	}

	@Override
	public int removeCReview(int cReviewId) {
		return cReviewDao.deleteCReview(cReviewId);
	}

}
