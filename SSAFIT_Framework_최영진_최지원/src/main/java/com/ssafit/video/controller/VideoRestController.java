package com.ssafit.video.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafit.video.model.dto.SearchCondition;
import com.ssafit.video.model.dto.Video;
import com.ssafit.video.model.service.VideoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("/api-video")
@Api(tags="비디오 컨트롤러")
public class VideoRestController {
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	
	@Autowired
	private VideoService videoService;

	@GetMapping("/video")
	@ApiOperation(value="비디오 조회+검색", notes="전체 목록 조회 & 검색조건이 있는 경우 검색 조건으로 조회(조회순&부위별 조회)")
	public ResponseEntity<?> list(SearchCondition condition){
		List<Video> list;
		if(condition==null) {
			list = videoService.getList(); //전체 조회
		}else {
			list = videoService.search(condition); //검색 조건이 있다면 그것으로 조회
		}
		if(list == null || list.size() == 0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<Video>>(list, HttpStatus.OK);
	}
	
	
	@GetMapping("/video/{id}")
	@ApiOperation(value="비디오 상세 조회", notes="비디오 상세 조회")
	public ResponseEntity<Video> detail(@PathVariable int id){
		Video video = videoService.getVideo(id);
		return new ResponseEntity<Video>(video, HttpStatus.OK);
	}
	
	
	@PostMapping("/check")
	@ApiOperation(value="비디오 중복 확인", notes="비디오 중복 확인")
    public ResponseEntity<Video> checkVideo(@RequestBody String videoUrl) {
		videoUrl = videoUrl.replace("=", "");
        Video video = videoService.checkVideo(videoUrl);
        if (video != null) { //이미 들어있는 영상
            return new ResponseEntity<Video>(video, HttpStatus.OK);
        } else { //새 영상
        	return new ResponseEntity<Video>(video, HttpStatus.OK);
        }
    }
	
	@PostMapping("/video")
	@ApiOperation(value="비디오 저장", notes="비디오 클릭 시 데이터 저장")
	public ResponseEntity<Video> clickInsert(@RequestBody Video video) {
		System.out.println("저장. 컨트 들어온 video: "+video);
		Video savedVideo = videoService.saveVideo(video);
		System.out.println("저장후 url로 가져온 비디오: "+savedVideo);
		return new ResponseEntity<Video>(savedVideo, HttpStatus.OK);
	}
	
	
	
}
