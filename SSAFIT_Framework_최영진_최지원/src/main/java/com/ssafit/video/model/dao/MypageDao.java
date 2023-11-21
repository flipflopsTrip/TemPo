package com.ssafit.video.model.dao;

import java.util.List;

import com.ssafit.video.model.dto.Weight;

public interface MypageDao {

	List<Weight> selectWeight(String userId);

	int insertWeight(Weight weight);

	Weight isCheckNewWeight(Weight weight);

	int updateWeight(Weight weight);

}
