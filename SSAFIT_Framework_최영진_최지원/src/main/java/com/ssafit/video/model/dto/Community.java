package com.ssafit.video.model.dto;

import io.swagger.annotations.ApiModel;

@ApiModel(value="자유게시판 바구니", description = "자유게시판 정보")
public class Community {
	private int communityId;
	private String userId;
	private String category;
	private String title;
	private String content;
	private String regDate;
	
	public Community() { }

	public Community(String userId, String category, String title, String content) {
		this.userId = userId;
		this.category = category;
		this.title = title;
		this.content = content;
	}

	public int getCommunityId() {
		return communityId;
	}

	public void setCommunityId(int communityId) {
		this.communityId = communityId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "Community [communityId=" + communityId + ", userId=" + userId + ", category=" + category + ", title="
				+ title + ", content=" + content + ", regDate=" + regDate + "]";
	}
	
	
}
