package com.video.domain;

import java.util.Date;
import java.util.List;

public class Video {
	
	enum VideoStatus{UPLOADING, VERIFYING, PUBLIC};
	
	private int videoId;
	private String url;
	private String tittle;
	private User owner;
	private List<Tag> tags;
	private Date uploadDate;
	private VideoStatus vs;
	private static int videosCount = 1;
	
	public Video(String url, String tittle, User owner, List<Tag> tags, Date uploadDate) {
		super();
		this.url = url;
		this.tittle = tittle;
		this.owner = owner;
		this.tags = tags;
		this.uploadDate = uploadDate;
		
		vs = VideoStatus.UPLOADING;
		
		videoId = videosCount;
		videosCount++;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTittle() {
		return tittle;
	}

	public void setTittle(String tittle) {
		this.tittle = tittle;
	}

	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}
	
	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public int getVideoId() {
		return videoId;
	}

	public static int getVideosCount() {
		return videosCount;
	}

	public Date getUploadDate() {
		return uploadDate;
	}

	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}
	
	
	public VideoStatus getVs() {
		return vs;
	}

	public void setVs(VideoStatus vs) {
		this.vs = vs;
	}

	public long checkVideoStatus(Date actualDate) {

		long difference;
		
		difference = actualDate.getTime() - uploadDate.getTime();
		
		return difference;
	}

	public void updateStatus(Date actualDate) {

		if(checkVideoStatus(actualDate)<15000) {
			vs=VideoStatus.UPLOADING;
		}else if(checkVideoStatus(actualDate)<30000) {
			vs=VideoStatus.VERIFYING;
		}else {
			vs=VideoStatus.PUBLIC;
		}
	}

	@Override
	public String toString() {
		return "Video [videoId=" + videoId + ", url=" + url + ", tittle=" + tittle + ", owner=" + owner + ", tags="
				+ tags + ", uploadDate=" + uploadDate + ", vs=" + vs + "]";
	}


}
