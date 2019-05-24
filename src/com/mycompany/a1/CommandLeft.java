package com.mycompany.a1;

import com.codename1.ui.*;
import com.codename1.ui.events.ActionEvent;

public class CommandLeft extends Command {
	private GameWorld gw;
	
	public CommandLeft(GameWorld gw)
	{
		super("Left");
		this.gw = gw;
	}
	
	public void actionPerformed(ActionEvent evt)
	{
		gw.steeringDirectionLeft();
	}
}

