package com.ssafit.video.model.dto;

import io.swagger.annotations.ApiModel;

@ApiModel(value="몸무게 바구니", description = "몸무게 정보")
public class Weight {
	private int weightId;
	private String userId;
	private int weight;
	private String regDate;
	
	public Weight() { }

	public Weight(String userId, int weight) {
		super();
		this.userId = userId;
		this.weight = weight;
	}

	public int getWeightId() {
		return weightId;
	}

	public void setWeightId(int weightId) {
		this.weightId = weightId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "Weight [weightId=" + weightId + ", userId=" + userId + ", weight=" + weight + ", regDate=" + regDate
				+ "]";
	}
	
}
