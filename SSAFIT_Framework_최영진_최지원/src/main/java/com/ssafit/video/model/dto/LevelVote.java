package com.ssafit.video.model.dto;

import io.swagger.annotations.ApiModel;

@ApiModel(value="난이도 투표 바구니", description = "영상 난이도 정보")
public class LevelVote {
	private int levelVoteId;
	private String userId;
	private int videoId;
	private int level;
	
	public LevelVote() { }

	public LevelVote(String userId, int videoId, int level) {
		this.userId = userId;
		this.videoId = videoId;
		this.level = level;
	}

	public int getLevelVoteId() {
		return levelVoteId;
	}

	public void setLevelVoteId(int levelVoteId) {
		this.levelVoteId = levelVoteId;
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

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	@Override
	public String toString() {
		return "LevelVote [levelVoteId=" + levelVoteId + ", userId=" + userId + ", videoId=" + videoId + ", level="
				+ level + "]";
	}
	
}
