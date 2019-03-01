package com.mycompany.a1;
import com.codename1.charts.util.ColorUtil;

public class EnergyStation extends Fixed {
	
	private int capacity;
	
	public EnergyStation(float x, float y, int size) {
		super(x, y);
		this.setColor(ColorUtil.GREEN);
		this.setSize(size);
		this.setCapacity(size*1);
	}

	public int getCapacity()
	{
		return capacity;
	}
	
	
	public void setCapacity(int capacity)
	{
		this.capacity = capacity;
	}
	
	
	public String toString() 
	{
		String parentDesc = super.toString();
		String myDesc = "size= " + this.getSize() + "capacity= " + capacity;
		return "EnergyStation: " + parentDesc + myDesc;
	}
	
}
