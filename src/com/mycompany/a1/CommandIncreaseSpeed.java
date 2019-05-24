package com.mycompany.a1;

import com.codename1.ui.*;
import com.codename1.ui.events.ActionEvent;

public class CommandIncreaseSpeed extends Command {
	private GameWorld gw;
	
	public CommandIncreaseSpeed(GameWorld gw)
	{
		super("Accelerate");
		this.gw = gw;
	}
	public void actionPerformed(ActionEvent evt)
	{
		System.out.println("Accelerate Robot");
		gw.increaseSpeed();
	}
}
