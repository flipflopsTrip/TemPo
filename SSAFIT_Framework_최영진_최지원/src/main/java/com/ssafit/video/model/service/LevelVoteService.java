package com.ssafit.video.model.service;

import java.util.List;

import com.ssafit.video.model.dto.LevelVote;
import com.ssafit.video.model.dto.Video;

public interface LevelVoteService {
	
	//한 영상의가장 많은 표를 받은 난이도 표시
	public int getAverageLevel(int videoId);
	
	//내가 했던 투표 결과
	public LevelVote getUserVote(String userId,int videoId);
		
	//위의 결과가 있다면, selectOne의 결과가 있다면 
	//투표하기 또는 수정하기
	public int createOrUpdateVote(LevelVote levelVote);
	
	List<Video> getVoteList(String userId);
	
}
