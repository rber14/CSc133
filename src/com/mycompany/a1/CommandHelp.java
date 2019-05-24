package com.mycompany.a1;

import com.codename1.ui.*;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.table.TableLayout;


public class CommandHelp extends Command 
{
	private GameWorld gw;
	
	public CommandHelp(GameWorld gw)
	{
		super("Help");
		this.gw = gw;
	}
	public void actionPerformed(ActionEvent evt)
	{
	
		Command okC = new Command("ok");
		Dialog helpBox =  new Dialog("About");
		helpBox.setLayout(new TableLayout(8,1));
		helpBox.add(new Label("Command"));
		helpBox.add(new Label("Accelerate: a"));
		helpBox.add(new Label("Brake: b"));
		helpBox.add(new Label("Left-Turn: l"));
		helpBox.add(new Label("Right-Turn: r"));
		helpBox.add(new Label("Collid energy: e"));
		helpBox.add(new Label("Collid drone: g"));
		helpBox.add(new Label("Tick: t"));
		Dialog.show("",helpBox,okC);
	}
}
