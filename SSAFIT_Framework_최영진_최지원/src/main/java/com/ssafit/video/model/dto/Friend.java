package com.ssafit.video.model.dto;

import io.swagger.annotations.ApiModel;

@ApiModel(value="친구", description = "팔로우/팔로워")
public class Friend {
	int friendId;
	String followerId;
	String followId;
	
	public Friend() {}

	public Friend(String followerId, String followId) {
		super();
		this.followerId = followerId;
		this.followId = followId;
	}

	public int getFriendId() {
		return friendId;
	}

	public void setFriendId(int friendId) {
		this.friendId = friendId;
	}

	public String getFollowerId() {
		return followerId;
	}

	public void setFollowerId(String followerId) {
		this.followerId = followerId;
	}

	public String getFollowId() {
		return followId;
	}

	public void setFollowId(String followId) {
		this.followId = followId;
	}

	@Override
	public String toString() {
		return "Friend [friendId=" + friendId + ", followerId=" + followerId + ", followId=" + followId + "]";
	}
	
}
