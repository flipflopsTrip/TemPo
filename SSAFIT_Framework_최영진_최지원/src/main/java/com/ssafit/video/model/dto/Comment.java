package com.ssafit.video.model.dto;

import io.swagger.annotations.ApiModel;

@ApiModel(value="댓글 바구니", description = "댓글 정보")
public class Comment {
	private int commentId;
	private String userId;
	private int reviewId;
	private String content;
	private String regDate;
	
	public Comment() {}

	public Comment(String userId, int reviewId, String content) {
		super();
		this.userId = userId;
		this.reviewId = reviewId;
		this.content = content;
	}

	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getReviewId() {
		return reviewId;
	}

	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
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
		return "Comment [commentId=" + commentId + ", userId=" + userId + ", reviewId=" + reviewId + ", content="
				+ content + ", regDate=" + regDate + "]";
	}
}
