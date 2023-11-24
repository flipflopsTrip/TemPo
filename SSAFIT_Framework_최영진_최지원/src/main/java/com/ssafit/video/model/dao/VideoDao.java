package com.ssafit.video.model.dao;

import java.util.List;

import com.ssafit.video.model.dto.Video;
import com.ssafit.video.model.dto.SearchCondition;

public interface VideoDao {
	public List<Video> selectAll();
	
	public List<Video> search(SearchCondition condition);
	
	public Video selectOne(int videoId);
	
	public void updateViewCnt(int videoId);
	
	public Video selectUrl(String videoUrl);

	public boolean insertVideo(Video video);

	public List<Video> selectLevelVideo(int level);

	public List<Video> selectLevelAll();

//	public void insertVideo(Video video);
//	public void deleteVideo(int id);
//	public void updateVideo(Video video);

}
