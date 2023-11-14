package com.ssafit.video.model.dto;

import io.swagger.annotations.ApiModel;

@ApiModel(value="리뷰 바구니", description = "리뷰 정보")
public class Review {
	  private int reviewId;
	    private String userId;
	    private int videoId;
	    private String title;
	    private String content;
	    private String regDate;
	    private int viewCnt;
	    
	    public Review() {
	    }

	    public Review(String userId, int videoId, String title, String content, int viewCnt) {
	        super();
	        this.userId = userId;
	        this.videoId = videoId;
	        this.title = title;
	        this.content = content;
	        this.viewCnt = viewCnt;
	    }



	    public int getReviewId() {
	        return reviewId;
	    }

	    public void setReviewId(int reviewId) {
	        this.reviewId = reviewId;
	    }

	    public String getUserId() {
	        return userId;
	    }

	    public void setUserId(String userId) {
	        this.userId = userId;
	    }

	    public int getVideoId() {
	        return videoId;
	    }

	    public void setVideoId(int videoId) {
	        this.videoId = videoId;
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

	    public int getViewCnt() {
	        return viewCnt;
	    }

	    public void setViewCnt(int viewCnt) {
	        this.viewCnt = viewCnt;
	    }

	    @Override
	    public String toString() {
	        return "Review [reviewId=" + reviewId + ", userId=" + userId + ", videoId=" + videoId + ", title=" + title
	                + ", content=" + content + ", regDate=" + regDate + ", viewCnt=" + viewCnt + "]";
	    }
	    
}
