package com.mycompany.a1;

public abstract class Fixed extends GameObject 
{	
	public Fixed(float x, float y)
	{
		//super(size);
		super.setX(x);
		super.setY(y);
	}
	
	public void setX(float x){}
	public void setY(float y){}
}
