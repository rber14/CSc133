package com.mycompany.a1;

import com.codename1.ui.*;

import com.codename1.ui.events.ActionEvent;

public class CommandDecreaseSpeed extends Command{
	private GameWorld gw;
	
	public CommandDecreaseSpeed(GameWorld gw)
	{
		super("Brake");
		this.gw = gw;
	}
	
	public void actionPerformed(ActionEvent evt)
	{
		gw.applyBrake();
	}
	
}
