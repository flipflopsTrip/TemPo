package com.ssafit.video.model.dto;

import io.swagger.annotations.ApiModel;

@ApiModel(value="자유게시판 댓글 바구니", description = "자유게시판 댓글 정보")
public class CReview {
	private int cReviewId;
	private int communityId;
	private String userId;
	private String content;
	private String regDate;
	
	public CReview() { }

	public CReview(int communityId, String userId, String content) {
		super();
		this.communityId = communityId;
		this.userId = userId;
		this.content = content;
	}

	public int getcReviewId() {
		return cReviewId;
	}

	public void setcReviewId(int cReviewId) {
		this.cReviewId = cReviewId;
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
		return "CReview [cReviewId=" + cReviewId + ", communityId=" + communityId + ", userId=" + userId + ", content="
				+ content + ", regDate=" + regDate + "]";
	}
	
}
