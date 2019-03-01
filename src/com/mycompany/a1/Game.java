package com.mycompany.a1;

import com.codename1.ui.Form;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import java.lang.String;


public class Game extends Form 
{
	private GameWorld gw;
	
	public Game()
	{
		gw = new GameWorld();
		gw.init();
		play();
	}
	
	@SuppressWarnings("rawtypes")
	private void play() 
	{
		Label myLabel=new Label ("Enter a Command:");
		this.addComponent(myLabel);
		final TextField myTextField = new TextField();
		this.addComponent(myTextField);
		this.show();
		myTextField.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent evt) 
			{
				String sCommand = myTextField.getText().toString();
				myTextField.clear();
				switch (sCommand.charAt(0))
				{
				case 'a':
					gw.increaseSpeed();
					break;
				case 'b':
					gw.applyBrake();
					break;
				case 'l':
					gw.steeringDirectionLeft();
					break;
				case 'r':
					gw.steeringDirectionRight();
					break;
				case 'c': //fix this
					System.out.println("collided with robot");
					break;
				case '1':
					gw.ranOverBase(1);
					System.out.println(" ran over base 1");
					break;
				case '2':
					gw.ranOverBase(2);
					System.out.println(" ran over base 2");
					break;
				case '3':
					gw.ranOverBase(3);
					System.out.println(" ran over base 3");
					break;
				case '4':
					gw.ranOverBase(4);
					System.out.println(" ran over base 4");
					break;
				case '5':
					gw.ranOverBase(5);
					System.out.println(" ran over base 5");
					break;
				case '6':
					gw.ranOverBase(6);
					System.out.println(" ran over base 6");
					break;
				case '7':
					gw.ranOverBase(7);
					System.out.println(" ran over base 7");
					break;
				case '8':
					gw.ranOverBase(8);
					System.out.println(" ran over base 8");
					break;
				case '9':
					gw.ranOverBase(9);
					System.out.println(" ran over base 9");
					break;
				case 'e' :
					gw.ranOverEnergyStation();
					System.out.println("ran over energy station");
					break;
				case 'g' :
					gw.contactWithDrone();
					System.out.println("hit drone");
					break;
				case 't' :
					gw.clockTick();
					System.out.println("Clock Ticked");
					break;
				case 'd' :
					gw.gameDisplay();
					System.out.println("game displayed");
					break;
				case 'm' :
					gw.mapDisplay();
					System.out.println("map display");
					break;
				case 'z' :
					gw.exit();
					System.out.println("game exit"); 
				
				
				}
			}	
		});
					
	}
				
			
}
