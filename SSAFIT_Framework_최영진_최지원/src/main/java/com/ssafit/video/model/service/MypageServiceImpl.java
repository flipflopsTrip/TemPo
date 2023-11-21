package com.ssafit.video.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafit.video.model.dao.MypageDao;
import com.ssafit.video.model.dao.ReviewDao;
import com.ssafit.video.model.dto.Review;
import com.ssafit.video.model.dto.Weight;

@Service
public class MypageServiceImpl implements MypageService {
	
	@Autowired
	private MypageDao mypageDao;

	@Override
	public List<Weight> getWeight(String userId) {
		return mypageDao.selectWeight(userId);
	}
	
	@Override
	@Transactional
	public boolean createWeight(Weight weight) {
		if (mypageDao.insertWeight(weight) > 0) return true;
		else return false;
	}
	
}
