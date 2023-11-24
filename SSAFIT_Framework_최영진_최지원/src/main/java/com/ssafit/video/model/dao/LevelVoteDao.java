package com.ssafit.video.model.dao;

import java.util.HashMap;
import java.util.List;

import com.ssafit.video.model.dto.LevelVote;
import com.ssafit.video.model.dto.Video;

public interface LevelVoteDao {
	
	//투표 상세
	public LevelVote findVoteByUserIdAndVideoId(HashMap<String, Object> params);
	
	//투표하기
	public int createVote(LevelVote levelVote);
	
	//투표하기 수정
	public int updateVote(LevelVote levelVote);
	
	//그 영상의 투표 결과 평균
	public Integer calculateAverageLevel(int videoId);
	
	public void updateVideoLevel(HashMap<Object, Object> params);
	
	public List<Video> myVoteList(String userId);
	
}
