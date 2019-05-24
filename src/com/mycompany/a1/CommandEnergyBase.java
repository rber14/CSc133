package com.mycompany.a1;
import com.codename1.ui.*;
import com.codename1.ui.events.ActionEvent;

public class CommandEnergyBase extends Command {
	private GameWorld gw;
	
	public CommandEnergyBase(GameWorld gw)
	{
		super("Collide with Energy Station");
		this.gw =gw;
	}
	
	public void actionPerformed(ActionEvent evt)
	{
		gw.ranOverEnergyStation();
	}
}
