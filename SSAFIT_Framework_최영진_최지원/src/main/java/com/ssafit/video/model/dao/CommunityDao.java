package com.ssafit.video.model.dao;

import java.util.List;
import com.ssafit.video.model.dto.Community;
import com.ssafit.video.model.dto.SearchCondition;

public interface CommunityDao {
	
	//전체 게시글 목록
	public List<Community> selectAll();
	
	//id로 게시글 가져오기
	public Community selectOne(int communityId);
	
	//게시글 등록
	public void insertCommunity (Community community);
	
	//게시글 삭제
	public void deleteCommunity(int communityId);
	
	//게시글 수정
	public void updateCommunity (Community community);
	
	//조회수 증가
	public void updateViewCnt(int communityId);
	
	//검색 기능
	public List<Community> search(SearchCondition condition);
}
