package com.ssafit.video.model.dto;

import io.swagger.annotations.ApiModel;

@ApiModel(value="찜 바구니", description = "찜 영상 및 회원 정보")
public class Wish {
	private int wishId;
	private int videoId;
	private String userId;
	private String regDate;
	
	public Wish() {}

	public Wish(int videoId, String userId) {
		super();
		this.videoId = videoId;
		this.userId = userId;
	}

	public int getWishId() {
		return wishId;
	}

	public void setWishId(int wishId) {
		this.wishId = wishId;
	}

	public int getVideoId() {
		return videoId;
	}

	public void setVideoId(int videoId) {
		this.videoId = videoId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "Wish [wishId=" + wishId + ", videoId=" + videoId + ", userId=" + userId + ", regDate=" + regDate + "]";
	}

}
