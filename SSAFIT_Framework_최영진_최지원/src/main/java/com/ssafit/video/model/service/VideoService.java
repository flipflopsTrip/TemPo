package com.ssafit.video.model.service;

import java.util.List;

import com.ssafit.video.model.dto.Video;
import com.ssafit.video.model.dto.SearchCondition;

public interface VideoService {
	List<Video> getList();
	
	List<Video> search(SearchCondition condition);

	Video getVideo(int videoId);
	
	Video checkVideo(String videoUrl);

	Video saveVideo(Video video);
}
