package com.mycompany.a1;

import com.codename1.ui.Form; 
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import java.lang.String;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Button;
import com.codename1.ui.CheckBox;
import com.codename1.ui.Command;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.table.TableLayout;

import com.codename1.ui.Toolbar;


public class Game extends Form 
{
	private GameWorld gw;
	private MapView mv;
	private ScoreView sv;
	
	public Game()
	{
		gw = new GameWorld();
		mv = new MapView(gw);
		sv = new ScoreView(gw); 
		
		Command accelCommand = new CommandIncreaseSpeed(gw);
		Command brakeCommand = new CommandDecreaseSpeed(gw);
		Command leftCommand = new CommandLeft(gw);
		Command rightCommand = new CommandRight(gw);
		Command baseCommand = new CommandBase(gw);
		Command droneCommand = new CommandDroneCol(gw);
		Command nprCommand = new CommandNPRCol(gw);
		Command energyCommand = new CommandEnergyBase(gw);
		Command tickCommand = new CommandTick(gw);
		Command helpCommand =  new CommandHelp(gw);
		Command exitCommand = new CommandExit(gw);
		Command aboutCommand = new CommandAbout(gw);
		Command soundCommand = new  CommandSound(gw);
		
		addKeyListener('a', accelCommand);
		addKeyListener('b', brakeCommand);
		addKeyListener('l', leftCommand);
		addKeyListener('r', rightCommand);
		addKeyListener('e', energyCommand);
		addKeyListener('g', droneCommand);
		addKeyListener('t', tickCommand);
		
		this.setLayout(new BorderLayout());
		Container westContainer = new Container();
		Container eastContainer = new Container();
		Container southContainer= new Container();
		
		westContainer.getAllStyles().setBorder(Border.createLineBorder(4, ColorUtil.BLACK));
		westContainer.setLayout(new TableLayout(3,1));
		Button accelButton = new Button("Accelerate");
		accelButton.setCommand(accelCommand);
		westContainer.addComponent(accelButton);
		accelButton.getAllStyles().setFgColor(ColorUtil.WHITE);
		accelButton.getAllStyles().setBgColor(ColorUtil.BLUE);
		accelButton.getAllStyles().setBgTransparency(255);
		accelButton.getAllStyles().setMarginBottom(10);
		
		Button leftButton = new Button("Left");
		leftButton.setCommand(leftCommand);
		westContainer.addComponent(leftButton);
		leftButton.getAllStyles().setFgColor(ColorUtil.WHITE);
		leftButton.getAllStyles().setBgColor(ColorUtil.BLUE);
		leftButton.getAllStyles().setBgTransparency(255);
		leftButton.getAllStyles().setMarginBottom(10);
		
		Button stratButton = new Button("Change Strategies");
		//stratButton.setCommand(strategyCommand);
		westContainer.addComponent(stratButton);
		stratButton.getAllStyles().setFgColor(ColorUtil.WHITE);
		stratButton.getAllStyles().setBgColor(ColorUtil.BLUE);
		stratButton.getAllStyles().setBgTransparency(255);
		stratButton.getAllStyles().setMarginBottom(10);
		
		eastContainer.getAllStyles().setBorder(Border.createLineBorder(4, ColorUtil.GRAY));
		eastContainer.setLayout(new BoxLayout(2));
		Button brakeButton = new Button("Break");
		brakeButton.setCommand(brakeCommand);
		eastContainer.addComponent(brakeButton);
		brakeButton.getAllStyles().setFgColor(ColorUtil.WHITE);
		brakeButton.getAllStyles().setBgColor(ColorUtil.BLUE);
		brakeButton.getAllStyles().setBgTransparency(255);	
		brakeButton.getAllStyles().setMarginBottom(10);
		
		Button rightButton = new Button("Right");
		rightButton.setCommand(rightCommand);
		eastContainer.addComponent(rightButton);
		rightButton.getAllStyles().setFgColor(ColorUtil.WHITE);
		rightButton.getAllStyles().setBgColor(ColorUtil.BLUE);
		rightButton.getAllStyles().setBgTransparency(255);	
		rightButton.getAllStyles().setMarginBottom(10);
		
		southContainer.getAllStyles().setBorder(Border.createLineBorder(4, ColorUtil.GRAY));
		southContainer.setLayout(new FlowLayout(Component.CENTER));
		Button NPRButton =  new Button("Collide with NPR");
		NPRButton.setCommand(nprCommand);
		southContainer.addComponent(NPRButton);
		NPRButton.getAllStyles().setFgColor(ColorUtil.WHITE);
		NPRButton.getAllStyles().setBgColor(ColorUtil.BLUE);
		NPRButton.getAllStyles().setBgTransparency(255);	
		NPRButton.getAllStyles().setMarginRight(5);
		
		Button baseButton =  new Button();
		baseButton.setCommand(baseCommand);
		southContainer.addComponent(baseButton);
		baseButton.getAllStyles().setFgColor(ColorUtil.WHITE);
		baseButton.getAllStyles().setBgColor(ColorUtil.BLUE);
		baseButton.getAllStyles().setBgTransparency(255);	
		baseButton.getAllStyles().setMarginRight(5);
		
		Button energyButton =  new Button();
		energyButton.setCommand(energyCommand);
		southContainer.add(energyButton);
		energyButton.getAllStyles().setFgColor(ColorUtil.WHITE);
		energyButton.getAllStyles().setBgColor(ColorUtil.BLUE);
		energyButton.getAllStyles().setBgTransparency(255);	
		energyButton.getAllStyles().setMarginRight(5);
		
		Button droneButton =  new Button();
		droneButton.setCommand(droneCommand);
		southContainer.add(droneButton);
		droneButton.getAllStyles().setFgColor(ColorUtil.WHITE);
		droneButton.getAllStyles().setBgColor(ColorUtil.BLUE);
		droneButton.getAllStyles().setBgTransparency(255);	
		droneButton.getAllStyles().setMarginRight(5);
		
		Button tickButton =  new Button();
		droneButton.setCommand(tickCommand);
		southContainer.add(tickButton);
		tickButton.getAllStyles().setFgColor(ColorUtil.WHITE);
		tickButton.getAllStyles().setBgColor(ColorUtil.BLUE);
		tickButton.getAllStyles().setBgTransparency(255);	
		tickButton.getAllStyles().setMarginRight(5);
				
		Toolbar toolbar = new Toolbar();
		this.setToolbar(toolbar);
		toolbar.setTitle("Robo-Track Game");		
		toolbar.addCommandToRightBar(helpCommand);
		toolbar.addCommandToSideMenu(exitCommand); //put about and exit command and sound
		toolbar.addCommandToSideMenu(aboutCommand);		
		CheckBox soundCh = new CheckBox("sound");
		soundCh.setCommand(soundCommand);
		toolbar.addComponentToLeftSideMenu(soundCh);		
		this.add(BorderLayout.WEST, westContainer);
		this.add(BorderLayout.EAST, eastContainer);
		this.add(BorderLayout.SOUTH, southContainer);
		this.add(BorderLayout.NORTH, sv);
		this.add(BorderLayout.CENTER, mv);

		gw.setMapWidth(mv.getComponentForm().getWidth());
		gw.init();
		this.show();
	}
   //Provided code	
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
				if (!sCommand.isEmpty()) {
					switch (sCommand.charAt(0)) {
					case 'a':
						gw.increaseSpeed();
						System.out.println("increasing speed");
						break;
					case 'b':
						gw.applyBrake();
						System.out.println("apply break slowing");
						break;
					case 'l':
						gw.steeringDirectionLeft();
						System.out.println("turning left");
						break;
					case 'r':
						gw.steeringDirectionRight();
						System.out.println("turning right");
						break;
					case 'c': 
						gw.contactWithRobot();
						System.out.println("hit robot");
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
					case 'e':
						gw.ranOverEnergyStation();
						System.out.println("ran over energy station");
						break;
					case 'g':
						gw.contactWithDrone();
						System.out.println("hit drone");
						break;
					case 't':
						gw.clockTick();
						System.out.println("Clock Ticked");
						break;
					case 'd':
						gw.gameDisplay();
						System.out.println("game displayed");
						break;
					case 'm':
						gw.mapDisplay();
						System.out.println("map display");
						break;
					case 'x':
						gw.exit();
						System.out.println("game exit");

					}
				}
			}	
		});
					
	}
				
			
}
