package com.mycompany.a1;

import com.codename1.charts.util.ColorUtil;

public class NonePlayerRobot extends Robot {
	final private int size = 60;
	final private  int maxSpeed = 60;
	
	public NonePlayerRobot(float x, float y) {
		super(x, y);
		// TODO Auto-generated constructor stub
		this.setX(x);
		this.setY(y);
		this.setSpeed(maxSpeed);
		this.setSize(size);
		this.setColor(ColorUtil.rgb(25,60,190));
	}
	
}
