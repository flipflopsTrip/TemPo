package com.ssafit.video.model.service;

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
	
	@Override
	public Video checkVideo(String videoUrl) {
		Video tmp = videoDao.selectUrl(videoUrl);
		if (tmp != null) return tmp; //일치하는 영상이 있음 == 이미 존재하는 영상
		else return null; //새 영상
	}
	
	@Override
	@Transactional
	public Video saveVideo(Video video) {
		if (videoDao.insertVideo(video)) {
			return videoDao.selectUrl(video.getUrl());
		}
		return null;
	}
	
}
