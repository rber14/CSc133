package com.mycompany.a1;

import com.codename1.ui.*;
import com.codename1.ui.events.ActionEvent;

public class CommandTick extends Command {
	private GameWorld gw;
	public CommandTick(GameWorld gw)
	{
		super("Tick");
		this.gw = gw;
	}
	
	public void actionPerformed(ActionEvent evt)
	{
		gw.clockTick();
	}
}
