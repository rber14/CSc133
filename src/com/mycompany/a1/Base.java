package com.mycompany.a1;
import com.codename1.charts.util.ColorUtil;

public class Base extends Fixed 
{
	//private Random rd = new Random();
	private final int baseSize = 10;
	private int baseSeq;

	public Base(float x, float y, int seqN)
	{
		super(x, y);
		this.setSize(baseSize);
		this.setColor(ColorUtil.BLUE);
		this.baseSeq = seqN;
	}
	
	
	
	public int getBaseSeq()
	{
		return this.baseSeq;
	}
	
	//
	public String toString()
	{
		String parentDesc = super.toString();
		String myDesc = " size="+ this.baseSize + " seqNum="+this.baseSeq;
		return "Base: "+ parentDesc + myDesc;
		
	}


}
