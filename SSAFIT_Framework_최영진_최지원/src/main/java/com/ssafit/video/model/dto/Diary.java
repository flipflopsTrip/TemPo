package com.ssafit.video.model.dto;

import io.swagger.annotations.ApiModel;

@ApiModel(value="운동일지 바구니", description = "운동일지 정보")
public class Diary {
	private int diaryId;
	private String userId;
	private String start;
	private String end;
	private String title;
	private String content;
	private boolean allDay;
	
	public Diary() { }

	public Diary(String userId, String start, String end, String title, String content, boolean allDay) {
		super();
		this.userId = userId;
		this.start = start;
		this.end = end;
		this.title = title;
		this.content = content;
		this.allDay = allDay;
	}

	public int getDiaryId() {
		return diaryId;
	}

	public void setDiaryId(int diaryId) {
		this.diaryId = diaryId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public boolean isAllDay() {
		return allDay;
	}

	public void setAllDay(boolean allDay) {
		this.allDay = allDay;
	}

	@Override
	public String toString() {
		return "Diary [diaryId=" + diaryId + ", userId=" + userId + ", start=" + start + ", end=" + end + ", title="
				+ title + ", content=" + content + ", allDay=" + allDay + "]";
	}
	
}
