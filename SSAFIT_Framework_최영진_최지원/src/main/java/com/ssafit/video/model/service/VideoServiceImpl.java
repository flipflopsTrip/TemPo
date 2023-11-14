package com.ssafit.video.model.service;

import java.lang.annotation.Target;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafit.video.model.dao.VideoDao;
import com.ssafit.video.model.dto.Video;
import com.ssafit.video.model.dto.SearchCondition;

@Service
public class VideoServiceImpl implements VideoService {

	private VideoDao videoDao;
	
	@Autowired
	public void setVideoDao(VideoDao videoDao) {
		this.videoDao = videoDao;
	}

	@Override
	public List<Video> getList() {
		return videoDao.selectAll();
	}
	@Override
	public List<Video> search(SearchCondition condition) {
		return videoDao.search(condition);
	}

	
	@Override
	@Transactional
	public Video getVideo(int videoId) {
		videoDao.updateViewCnt(videoId);
		return videoDao.selectOne(videoId);
	}
	
}
