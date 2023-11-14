package com.ssafit.video.model.dto;

import io.swagger.annotations.ApiModel;

@ApiModel(value="회원 바구니", description = "회원 정보")
public class User {
	private String id;
	private String password;
	private String name;
	private String nickname;
	private String birth;
	private String email;

	public User() {}
	public User(String id, String password, String name, String nickname, String birth, String email) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.nickname = nickname;
		this.birth = birth;
		this.email = email;
	}



	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", password=" + password + ", name=" + name + ", nickname=" + nickname + ", birth="
				+ birth + ", email=" + email + "]";
	}
	
	
}