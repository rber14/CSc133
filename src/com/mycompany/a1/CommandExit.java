package com.mycompany.a1;
import com.codename1.ui.*;
import com.codename1.ui.events.ActionEvent;
public class CommandExit extends Command{
	private GameWorld gw;
	
	public CommandExit(GameWorld gw)
	{
		super("Exit");
		this.gw = gw;
	}
	public void actionPerformed(ActionEvent evt)
	{
		if(Dialog.show("Exit", "Do you want to exit game",  "yes", "no"))
		{
			gw.exit();
		}
		
	}
}
