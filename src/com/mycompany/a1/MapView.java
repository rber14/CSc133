package com.mycompany.a1;

import java.util.Observable;
import java.util.Observer;

import com.codename1.ui.*;
import com.codename1.ui.plaf.Border;
import com.codename1.charts.util.ColorUtil;

public class MapView extends Container implements Observer {
	private GameWorld model;
	public MapView(Observable myModel)
	{
		model = (GameWorld) myModel;
		myModel.addObserver(this);
		this.getAllStyles().setBorder(Border.createLineBorder(4, ColorUtil.rgb(255,0,0)));
	}
	public MapView() {}
	@Override
	public void update(Observable observable, Object data) {
		// TODO Auto-generated method stub
		model.mapDisplay();

	}

}
