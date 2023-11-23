package com.ssafit.video.model.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafit.video.model.dao.LevelVoteDao;
import com.ssafit.video.model.dto.LevelVote;
import com.ssafit.video.model.dto.Video;

@Service
public class LevelVoteServiceImpl implements LevelVoteService {

	@Autowired
	LevelVoteDao levelVoteDao;
	
	@Override
	public int getAverageLevel(int videoId) {
		//한 영상의 난이도 득표 결과. 가장 많은 표를 받은 난이도 표시
		int avg = levelVoteDao.calculateAverageLevel(videoId);
		HashMap<Object, Object> params = new HashMap<>();
        params.put("videoId", videoId);
        params.put("level", avg);
        levelVoteDao.updateVideoLevel(params);
		return avg;//레벨 값만 int로 리턴
	}

	@Override
	public LevelVote getUserVote(String userId,int videoId) {
		HashMap<String, Object> params = new HashMap<>();
        params.put("userId", userId);
        params.put("videoId", videoId);
		//내가 했던 투표 결과
		return levelVoteDao.findVoteByUserIdAndVideoId(params);//SELECT * 로 LevelVote 반환
	}

	@Override
	public int createOrUpdateVote(LevelVote levelVote) {
		HashMap<String, Object> params = new HashMap<>();               
        params.put("userId",levelVote.getUserId());
        params.put("videoId", levelVote.getVideoId());
		//투표
		if (levelVoteDao.findVoteByUserIdAndVideoId(params) == null) {
			//새로운 투표
			return levelVoteDao.createVote(levelVote);//등록했다면 1			
		} else {
			int level = levelVoteDao.findVoteByUserIdAndVideoId(params).getLevelVoteId();
			levelVote.setLevelVoteId(level);
			int tmp = levelVoteDao.updateVote(levelVote);
			return tmp+1;//수정됬다면 2
		}
	}

	@Override
	public List<Video> getVoteList(String userId) {
		List<Video> list = levelVoteDao.myVoteList(userId);
		return list;
	}
	

}
