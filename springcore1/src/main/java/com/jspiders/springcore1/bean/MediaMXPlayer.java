package com.jspiders.springcore1.bean;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@Primary
public class MediaMXPlayer implements MediaPlayer {

	@Override
	public String play() {
		// TODO Auto-generated method stub
		return "MX Player Playing Video";
	}

}
