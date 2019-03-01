package com.mycompany.a1;

import com.codename1.charts.util.ColorUtil;

public class Robot extends Movable implements ISteerable{
	private final int robotSize = 40;
	
	private int steeringDirection = 0;
	private int maximumSpeed = 40;
	private int energyLevel = 20;
	private int energyConsumtionRate = 1;
	private int damageLevel = 0;
	private int lastBaseReached = 1;
	
	private boolean theRobotIsDead = false;
	
	private int maxDamage = 15;
	
	public Robot(float x, float y)
	{
		super(0);
		this.setX(x);
		this.setY(y);
		this.setSpeed(0);
		this.setSize(robotSize);
		
		this.setColor(ColorUtil.rgb(255,0,0));
		
	}
	
	public int getMaximumSpeed()
	{
		return maximumSpeed;
	}
	
	public void setMaximumSpeed(int maximumSpeed)
	{
		this.maximumSpeed = maximumSpeed;
	}
	
	public int getEnergyLevel()
	{
		return energyLevel;
	}
	
	public void setEnergyLevel(int energyLevel)
	{
		this.energyLevel = energyLevel;
	}
	
	public int getEnergyConsumptionRate()
	{
		return energyConsumtionRate;
	}
	
	public void setEnergyConsumptionRate(int energyConsumtion )
	{
		this.energyConsumtionRate = energyConsumtion;
	}
	
	public int getDamageLevel()
	{
		return damageLevel;
	}
	
	public void setDamageLevel(int damage)
	{
		if(damage < maxDamage)
		{
			this.damageLevel = damage;
		}else {
			this.damageLevel = maxDamage;
		}
			
	}
	
	public int getLastBaseReached()
	{
		return lastBaseReached;
	}
	
	public void setLastBaseReached(int lastBase)
	{
		this.lastBaseReached = lastBase;
	}
	
	public boolean getTheRobotIsDead()
	{
		return theRobotIsDead;
	}
	
	public void setTheRobotIsDead(boolean dead)
	{
		this.theRobotIsDead = dead;
	}
	
	public void turnRight()
	{
		if(steeringDirection <= 40)
		{
			steeringDirection += 5;
		}
	}
	public void turnLeft()
	{
		if(steeringDirection >=-40)
		{
			steeringDirection -= 5;
		}
	}
	
	public void setSteeringDirection(int direction)
	{
		this.steeringDirection = direction;
	}
	public int getSteeringDirection()
	{
		return steeringDirection;
	}
	
	
	public void steerHeading(int heading)
	{
		setHeading(heading);
	}
	
	public void setRobotSpeed(int speed)
	{
		if(speed < 0)
		{
			this.setSpeed(0);
		}
		if(speed < this.getMaximumSpeed() * this.getEnergyLevel() + .1)
		{
			this.setSpeed(speed);
		}
		else
		{
			this.setSpeed((int)(this.getMaximumSpeed() * this.getEnergyLevel() + .1));
		}
		this.isRobotDead();
	}
	
	public void updateRobotSpeed()
	{
		if(this.getSpeed() < this.getMaximumSpeed()*this.getEnergyLevel()*this.getEnergyLevel() * 0.1)
		{
			
		}else {
			this.setSpeed((int)(this.getMaximumSpeed() * this.getEnergyLevel() * .1));
		}
	}
	
	public void hitDrone()
	{
		this.energyLevel = this.energyLevel - 1;
		this.updateRobotSpeed();
		this.setColor(ColorUtil.rgb(255,(10 * (20 - this.getEnergyLevel())),0));
		if(this.getEnergyLevel() <= 0)
		{
				this.energyLevel = 0;
				this.setTheRobotIsDead(true);
		}
		
	}
	
	public void isRobotDead()
	{
		if(this.getEnergyLevel() <= 0)
		{
			this.setSpeed(0);
		}
		if(this.damageLevel >= maxDamage)
		{
			this.setSpeed(0);
		}
		if(this.getSpeed() == 0)
		{
			this.theRobotIsDead = true;
		}
	}
	
	public void energyDrain()
	{
		energyLevel -= energyConsumtionRate;
		if(energyLevel <= 0) {
			this.setSpeed(0);
		}
	}
	
	public void reset()
	{
		this.setColor(ColorUtil.rgb(255,0,0));
		this.setX(50);
		this.setY(50);
		this.setSpeed(0);
		this.setLastBaseReached(1);
		this.setEnergyLevel(20);
		this.setDamageLevel(0);
		this.setSteeringDirection(0);
		this.setTheRobotIsDead(false);
		
		
	}
	
	public String toString() 
	{
		String parentDesc = super.toString();
		String myDesc = " heading=" + this.getHeading() + " speed=" + this.getSpeed() + " size=" + this.getSize()
		+ " maxspeed=" + this.getMaximumSpeed() + " steeringDirection=" + this.getSteeringDirection() + " energyLevel=" + this.getEnergyLevel() + " damageLevel=" + this.getDamageLevel(); 
		return "Robot: " + parentDesc + myDesc ;
	}
	

	
	
	
	
	
	
	
	
	
	
}
