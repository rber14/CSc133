package com.mycompany.a1;

import com.codename1.ui.*;
import com.codename1.ui.events.ActionEvent;

public class CommandNPRCol extends Command{
	private GameWorld gw;
	
	public CommandNPRCol(GameWorld gw)
	{
		super("Collided with npr");
		this.gw = gw;
	}
	
	public void actionPerformed(ActionEvent evt)
	{
		gw.contactWithRobot();
	}
}
