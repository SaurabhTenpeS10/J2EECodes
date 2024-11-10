package com.jpiders.springcore1.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jspiders.springcore1.bean.MediaPlayerVideo;

public class MediaPlayerMain {
	
	public static void main(String[] args) {
		
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext("com.jspiders.springcore1");
		MediaPlayerVideo bean = applicationContext.getBean(MediaPlayerVideo.class);
		System.out.println(bean);
		((AnnotationConfigApplicationContext)applicationContext).close();
		
	}
}
