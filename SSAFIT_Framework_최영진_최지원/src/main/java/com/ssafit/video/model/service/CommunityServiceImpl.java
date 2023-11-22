package com.ssafit.video.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafit.video.model.dao.CommunityDao;
import com.ssafit.video.model.dto.Community;
import com.ssafit.video.model.dto.SearchCondition;

@Service
public class CommunityServiceImpl implements CommunityService {
	@Autowired
	private CommunityDao communityDao;
	
	@Autowired
	public void setCommunityDao(CommunityDao communityDao) {
		this.communityDao = communityDao;
	}

	@Override
	public List<Community> getList() {
		System.out.println("게시글 목록 불러오기");
		return communityDao.selectAll();
	}

	@Transactional
	@Override
	public int writeCommunity(Community community) {
		System.out.println("게시글 작성");
		communityDao.insertCommunity(community);
		return 1;
	}

	@Override
	public Community getCommunity(int communityId) {
		System.out.println(communityId+"번 글 상세 조회");
		communityDao.updateViewCnt(communityId);
		return communityDao.selectOne(communityId);
	}

	@Transactional
	@Override
	public int modifyCommunity(Community community) {
		communityDao.updateCommunity(community);
		return community.getCommunityId();	
	}

	@Transactional
	@Override
	public int removeCommunity(int communityId) {
		System.out.println(communityId+"번 글 삭제");
		communityDao.deleteCommunity(communityId);
		return communityId;
	}

	@Override
	public List<Community> search(SearchCondition condition) {
		return communityDao.search(condition);
	}

}
