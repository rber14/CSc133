package com.mycompany.a1;
import com.codename1.charts.util.ColorUtil;

/**
 * @author roberto campos
 */

public abstract class GameObject 
{
	
	/**
	 * GameObject variables
	 */
	
	private int color;
	private float xLocation;
	private float yLocation;
	private int size;
	
	/**
	 * setters and getters
	 * @param c
	 * @param r
	 */
	
	/*
	public GameObject(int size)
	{
		this.size = size;
	}
	*/
	
	public void setColor(int c)
	{
		this.color = c;
	}
	
	public int getColor()
	{
		return this.color;
	}
	
	public void setX(float d)
	{
		this.xLocation = d;
	}
	
	public float getX() 
	{
		return this.xLocation; 
	}
	
	public void setY(float y)
	{
		this.yLocation = y;
	}
	
	public float getY() 
	{
		return this.yLocation;
	}
	
	
	public int getSize()
	{
		return this.size; 
	}
	
	public void setSize(int size)
	{
		this.size = size;
	}
	
	//toString
	public String toString()
	{
		String myDesc =  "loc=" + Math.round(xLocation*10.0)/10.0 + "," + Math.round(yLocation*10.0)/10.0 + 
				" color=[" + ColorUtil.red(color) + "," + ColorUtil.green(color) + "," + ColorUtil.blue(color) + "]";
		
		return myDesc;
	}
	
	
}
