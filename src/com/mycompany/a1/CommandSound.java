package com.mycompany.a1;

import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.Command;
public class CommandSound extends Command{
	private GameWorld gw;

	public CommandSound(GameWorld gw)
	{
		super("Sound");
		this.gw = gw;
	}
	
	public void actionPerfromed(ActionEvent evt)
	{
		gw.soundSetting();
	}
	
	
}
