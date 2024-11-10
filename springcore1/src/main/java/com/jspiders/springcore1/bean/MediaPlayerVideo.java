package com.jspiders.springcore1.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MediaPlayerVideo {
	@Autowired
	private MediaPlayer mediaPlayer;

	public MediaPlayer getMediaPlayer() {
		return mediaPlayer;
	}

	public void setMediaPlayer(MediaPlayer mediaPlayer) {
		this.mediaPlayer = mediaPlayer;
	}

	@Override
	public String toString() {
		return "MediaPlayerVideo [mediaPlayer= " + mediaPlayer.play() + "]";
	}
	
}
