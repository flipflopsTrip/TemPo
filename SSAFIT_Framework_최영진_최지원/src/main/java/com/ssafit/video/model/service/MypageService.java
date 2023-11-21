package com.ssafit.video.model.service;

import java.util.List;

import com.ssafit.video.model.dto.User;
import com.ssafit.video.model.dto.Weight;

public interface MypageService {

	List<Weight> getWeight(String userId);

	boolean createOrModifyWeight(Weight weight);

	
	
}