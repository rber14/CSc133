package com.mycompany.a1;

import com.codename1.ui.*;
import com.codename1.ui.events.ActionEvent;

public class CommandDroneCol extends Command{
	private GameWorld gw;
	
	public CommandDroneCol(GameWorld gw)
	{
		super("Contact with drone");
		this.gw = gw;
	}
	
	public void actionPerformed(ActionEvent evt) 
	{
		gw.contactWithDrone();
	}
}
