package com.mycompany.a1;

import com.codename1.ui.*;
import com.codename1.ui.table.TableLayout;
import com.codename1.ui.events.ActionEvent;

public class CommandAbout extends Command{
	private GameWorld gw;
	
	public CommandAbout(GameWorld gw)
	{
		super("About");
		this.gw = gw;
	}
	
	public void actionPerformed(ActionEvent evt) 
	{
		Command okC = new Command("ok");
		Dialog abBox =  new Dialog("About");
		abBox.setLayout(new TableLayout(4,1));
		abBox.add(new Label("By: Roberto"));
		abBox.add(new Label("CSc133"));
		abBox.add(new Label("Robo-Track"));
		abBox.add(new Label("v.5"));
		Dialog.show("",abBox,okC);		
	}
	
}









