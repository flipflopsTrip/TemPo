package com.ssafit.video.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafit.video.model.dao.WishDao;
import com.ssafit.video.model.dto.Video;

@Service
public class WishServiceImpl implements WishService {
	
	@Autowired
	WishDao wishDao;

	@Override
	public List<Video> getWishList(String userId) {
		List<Video> list = wishDao.selectWishList(userId);
		// TODO Auto-generated method stub
		return list;
	}

	@Override
	public boolean isWish(int videoId, String userId) {
		// TODO Auto-generated method stub
		return wishDao.isWish(videoId, userId)>0 ? true : false;
	}

	@Override
	public int makeWish(int videoId, String userId) {
		// TODO Auto-generated method stub
		return wishDao.createWish(videoId, userId);
	}

	@Override
	public int removeWish(int videoId, String userId) {
		// TODO Auto-generated method stub
		return wishDao.deleteWish(videoId, userId);
	}
	
}
