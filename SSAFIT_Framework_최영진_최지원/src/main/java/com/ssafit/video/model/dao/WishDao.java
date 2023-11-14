package com.ssafit.video.model.dao;

import java.util.List;

import com.ssafit.video.model.dto.Video;

public interface WishDao {
	//리스트(찜)
	List<Video> selectWishList(String userId);
	//찜 여부
	int isWish(int videoId, String userId);
	//생성
	int createWish(int videoId, String userId);
	//삭제
	int deleteWish(int videoId, String userId);
}
