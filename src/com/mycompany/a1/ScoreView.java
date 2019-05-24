package com.mycompany.a1;

import com.codename1.ui.*;

import java.util.Observable;
import java.util.Observer;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.layouts.BoxLayout;


public class ScoreView extends Container implements Observer 
{
	private GameWorld model;
	
	private Label timeLabel;
	private Label timeValue;
	private Label liveLabel;
	private Label liveValue;
	private Label lastBaseLabel;
	private Label lastBaseValue;
	private Label energyLevelLabel;
	private Label energyLevelValue;
	private Label damageLevelLabel;
	private Label damageLevelValue;
	private Label soundLabel;
	private Label soundValue;
	
	public ScoreView(Observable myModel)
	{
		model = (GameWorld) myModel;
		myModel.addObserver(this);
		this.setLayout(new FlowLayout(Component.CENTER));
		this.getAllStyles().setBorder(Border.createLineBorder(4, ColorUtil.GRAY));
		
		this.setupLabels();
		
		this.add(timeLabel);
		this.add(timeValue);
		this.add(liveLabel);
		this.add(liveValue);
		this.add(lastBaseLabel);
		this.add(lastBaseValue);
		this.add(energyLevelLabel);
		this.add(energyLevelValue);
		this.add(damageLevelLabel);
		this.add(damageLevelValue);
		this.add(soundLabel);
		this.add(soundValue);
		
	}		
		
		public void setupLabels()
		{
			timeLabel = new Label("Time:");
			timeValue = new Label(""+ model.getTime());
			timeLabel.getAllStyles().setFgColor(ColorUtil.BLUE);
			timeValue.getAllStyles().setFgColor(ColorUtil.BLUE);
			
			liveLabel = new Label("Lives left:");
			liveValue = new Label(""+ model.getLives());
			liveLabel.getAllStyles().setFgColor(ColorUtil.BLUE);
			liveValue.getAllStyles().setFgColor(ColorUtil.BLUE);
			
		    lastBaseLabel = new Label("Player last base reached:");
			lastBaseValue = new Label(""+ model.getLastBaseReached());
			lastBaseLabel.getAllStyles().setFgColor(ColorUtil.BLUE);
		    lastBaseValue.getAllStyles().setFgColor(ColorUtil.BLUE);
			
			energyLevelLabel = new Label("Player energy level:");
			energyLevelValue = new Label(""+ model.getRobotEnergyLevel());
			energyLevelLabel.getAllStyles().setFgColor(ColorUtil.BLUE);
			energyLevelValue.getAllStyles().setFgColor(ColorUtil.BLUE);
			
			damageLevelLabel = new Label("Player damage level:");
			damageLevelValue = new Label(""+model.getRobotDamageLevel());
			damageLevelLabel.getAllStyles().setFgColor(ColorUtil.BLUE);
			damageLevelValue.getAllStyles().setFgColor(ColorUtil.BLUE);
			
			soundLabel = new Label("Sound:");
			soundValue = new Label(model.isSound());
			soundLabel.getAllStyles().setFgColor(ColorUtil.BLUE);
			soundValue.getAllStyles().setFgColor(ColorUtil.BLUE);
			
		
			
			
		}
		
		public void updateLabels() {
			

			timeValue.setText("" + model.getTime());
			timeValue.getParent().revalidate(); //Re-layout the container, this is useful when we modify the container hierarchy and need to redo the layout
			liveValue.setText("" + model.getLives());
			liveValue.getParent().revalidate();
			lastBaseValue.setText("" + model.getLastBaseReached());
			lastBaseValue.getParent().revalidate();
			energyLevelValue.setText("" + model.getRobotDamageLevel());
			energyLevelValue.getParent().revalidate();
			damageLevelValue.setText("" + model.getRobotDamageLevel());
			damageLevelValue.getParent().revalidate();
			soundValue.setText("" + model.isSound());
			soundValue.getParent().revalidate();
		}
		
		public void update (Observable o, Object arg) {
			this.updateLabels();
			
		}
	
	
}
