package com.mycompany.a1;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.Dialog;
import com.codename1.ui.TextField;


public class CommandBase extends Command {
	private GameWorld gw;
	
	public CommandBase(GameWorld gw)
	{
		super("Collide with base");
		this.gw = gw;
	}
	
	public void actionPerformed(ActionEvent evt)
	{
		Command entC = new Command("Enter");
		TextField tf = new TextField();
		Command c = Dialog.show("Enter a base number between 1-9: ", tf, entC);
		int base =1;
		if(c == entC) {
			try {
				base = Integer.parseInt(tf.getText());
			}catch(Exception e) {
				Dialog.show("Error", "Enter a base number between 1-9","ok","");
				return;
			}
			if(base>9 || base<1)
			{
				Dialog.show("Error", "Enter a base number between 1-9","ok","");
			}
		}
		gw.ranOverBase(base);
	}
}
