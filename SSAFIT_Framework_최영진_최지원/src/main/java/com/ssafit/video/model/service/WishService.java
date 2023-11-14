package com.ssafit.video.model.service;

import java.util.List;

import com.ssafit.video.model.dto.Video;

public interface WishService {
	//리스트(찜)
	List<Video> getWishList(String userId);
	//찜 여부
	boolean isWish(int videoId, String userId);
	//생성
	int makeWish(int videoId, String userId);
	//삭제
	int removeWish(int videoId, String userId);
}
