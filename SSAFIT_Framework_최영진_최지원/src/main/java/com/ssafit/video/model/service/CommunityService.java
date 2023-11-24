package com.ssafit.video.model.service;

import java.util.List;

import com.ssafit.video.model.dto.Community;
import com.ssafit.video.model.dto.SearchCondition;

public interface CommunityService {
	// 게시글 전체 조회
	List<Community> getList();

	// 게시글 등록
	int writeCommunity(Community community);

	// 게시글 상세 조회
	Community getCommunity(int communityId);

	// 게시글 수정
	int modifyCommunity(Community community);

	// 게시글 삭제
	int removeCommunity(int communityId);

	// 검색
	List <Community> search(SearchCondition condition);
}
