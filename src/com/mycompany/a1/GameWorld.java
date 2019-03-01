package com.mycompany.a1;

import java.util.Iterator;
import java.util.Random;
import java.util.Vector;

import com.codename1.charts.util.ColorUtil;

public class GameWorld 
{
	
	//Fixed Game World Variables
	//Game World Stat
	//private int gwScore = 0;
	private int lives = 3; 
	private int timer = 0; 
	private int lastFlag = 4;
	
	private Vector<GameObject> WorldObjects;
	Iterator<GameObject> itr; 

	Robot robot = new Robot(50,50);
	public GameWorld() {}
	
	//GameWorld methods
	
	public void init()
    {
		WorldObjects = new Vector<GameObject>();
		itr = WorldObjects.iterator();
		//4 bases: between x_0-1024 & y_0-768
		WorldObjects.add(new Base(50,50,1));
		WorldObjects.add(new Base(150,150,2));
		WorldObjects.add(new Base(250,200,3));
		WorldObjects.add(new Base(450,450,4));
		
		//2 energy stations 
		WorldObjects.add(new EnergyStation(randomX(), randomY(), randomSize()));
		WorldObjects.add(new EnergyStation(randomX(), randomY(), randomSize()));
		
		//2 drones
		WorldObjects.add(new Drone(randomX(), randomY(), randomSize(), randomHeading(), randomSpeed()));
		WorldObjects.add(new Drone(randomX(), randomY(), randomSize(), randomHeading(), randomSpeed()));
		
		//robot
		WorldObjects.add(robot);
    }
	

	public static int rInt(int min, int max)
	{
		Random r = new Random();
		int randNum =  r.nextInt((max-min)+1)+min;
		
		return randNum;
	}
	
	/**
	 * Returns Random Size between indicated specifications
	 */
	public int randomSize()
	{
		return rInt(10,50);
	}
	
	/**
	 * Returns random x loc
	 */
	public float randomX()
	{
		return rInt(0, 1024);
	}
	
	/**
	 * Returns random y loc
	 */
	public float randomY()
	{
		return rInt(0, 768);
	}
	
	/**
	 * Returns random heading
	 */
	public int randomHeading() 
	{
		return rInt(0,359);
	}
	
	/**
	 * Returns random speed
	 */
	public int randomSpeed()
	{
		return rInt(5,10);
	}
	
	/**
	 * Increase speed of robot
	 */
	public void increaseSpeed()
	{
		int temp = robot.getSpeed();
		temp+=2;
		if(temp > 40)
		{
			temp = 40;
		}
		robot.setSpeed(temp);
	}
	
	/**
	 * Decrease speed of robot
	 */

	public void applyBrake()
	{
		int temp = robot.getSpeed();
		temp-=2;
		if(temp < 0)
		{
			temp = 0;
		}
		robot.setRobotSpeed(temp);
	}
	
	public void steeringDirectionLeft()
	{
		robot.turnLeft();
	}
	
	public void steeringDirectionRight()
	{
		robot.turnRight();
	}
	/**
	 * Check if base is ran over
	 * @param baseNumber
	 */
	public void ranOverBase(int baseNumber)
	{
		if((baseNumber) - robot.getLastBaseReached() == 1)
		{
			robot.setLastBaseReached(baseNumber);
		}
	}
	
	/**
	 * checks if energy has been ran over and spawns a new one
	 */
	public void ranOverEnergyStation()
	{
		itr = WorldObjects.iterator();
		while(itr.hasNext())
		{
			if(itr.next() instanceof EnergyStation)
			{
				if(((EnergyStation) itr.next()).getCapacity() != 0)
				{
					robot.setEnergyLevel(robot.getEnergyLevel() + ((EnergyStation) itr.next()).getCapacity() );
					((EnergyStation) itr.next()).setCapacity(0);
					((EnergyStation) itr.next()).setColor(ColorUtil.rgb(0,100,0));
					
				}
			}
		}
		WorldObjects.add(new EnergyStation(randomX(), randomY(), randomSize()));
	}
	
	/**
	 * Check if robot has made contact with drone
	 */
	public void contactWithDrone()
	{
		robot.hitDrone();
	}
	
	/**
	 * clock
	 */
	public void clockTick()
	{
		itr = WorldObjects.iterator();
		while(itr.hasNext())
		{
			if(itr.next() instanceof Drone)
			{
				((Drone) itr.next()).headingChange();
			}
			if(itr.next() instanceof Movable)
			{
				((Movable) itr.next()).move();
			}
		}
		
		robot.energyDrain();
		timer++;
		
		if(robot.getTheRobotIsDead())
		{
			lives = lives -1;
			if(lives == 0)
			{
				this.endGame();
			}
			else
			{
				this.finalGameOutput();
				this.init();
			}
		}
		
		if(robot.getLastBaseReached() == lastFlag)
		{
			this.winOutPut();
		}
	}
	
	/**
	 * game stat display according to specifications
	 */
	public void gameDisplay()
	{
		System.out.println("Number of lives: " + lives);
		System.out.println("Time: " + timer);
		System.out.println("Base number reached: "+ robot.getLastBaseReached());
		System.out.println("Energy Level: "+ robot.getEnergyLevel());
		System.out.println("Damage: "+ robot.getDamageLevel());
		
		
		
	}
	
	public void mapDisplay()
	{
		itr = WorldObjects.iterator();
		while(itr.hasNext())
		{
			System.out.println(itr.next().toString());
		}
		
		System.out.println("____\t____\t_____\t_____\t_____\t____\t_____\t____\t_____\t_____\t_____\t_____\t_____");
	}
			
	public void winOutPut()
	{
		System.out.print("You won"+ this.timer);
	}
	public void finalGameOutput()
	{
		System.out.print("Your Robot Died");
		this.init();
	}
	public void endGame()
	{
		System.out.print("Game Over");
	}
	public void exit()
	{
		System.out.println("Confirm: y or n");
		System.exit(0);
		

	}
	
	
	
	
	
}

