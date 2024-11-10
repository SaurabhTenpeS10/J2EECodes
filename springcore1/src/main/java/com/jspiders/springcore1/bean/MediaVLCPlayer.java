package com.jspiders.springcore1.bean;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class MediaVLCPlayer implements MediaPlayer {

	@Override
	public String play() {
		
		return "VLC Player Playing Video";
	}

}
