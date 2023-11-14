package com.ssafit.video.model.dto;

import io.swagger.annotations.ApiModel;

@ApiModel(value="영상 바구니", description = "영상 정보")
public class Video {
	private int videoId;
	private String title;
	private String url;
	private String fitpart;
	private String youtuber;
	private String regDate;
	private int viewCnt;

	public Video() {
	}

	public Video(String title, String url, String fitpart, String youtuber) {
		super();
		this.title = title;
		this.url = url;
		this.fitpart = fitpart;
		this.youtuber = youtuber;
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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getFitpart() {
		return fitpart;
	}

	public void setFitpart(String fitpart) {
		this.fitpart = fitpart;
	}

	public String getYoutuber() {
		return youtuber;
	}

	public void setYoutuber(String youtuber) {
		this.youtuber = youtuber;
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
		return "Video [videoId=" + videoId + ", title=" + title + ", url=" + url + ", fitpart=" + fitpart
				+ ", youtuber=" + youtuber + ", regDate=" + regDate + ", viewCnt=" + viewCnt + "]";
	}

}	