package com.mycompany.a1;

import com.codename1.ui.*;
import com.codename1.ui.events.ActionEvent;

public class CommandRight extends Command{
	private GameWorld gw;
	
	public CommandRight(GameWorld gw)
	{
		super("Right");
		this.gw = gw;
	}
	
	public void actionPerformed(ActionEvent evt)
	{
		gw.steeringDirectionRight();
	}
}
