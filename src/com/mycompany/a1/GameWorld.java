package com.mycompany.a1;

import java.util.Iterator;
import java.util.Random;
import java.util.Vector;
import java.util.Observable;

import com.codename1.charts.util.ColorUtil;

public class GameWorld extends Observable
{
	
	//Fixed Game World Variables
	//Game World Stat
	private int lives = 3; 
	private int timer = 0; 
	private int finalBase = 4;
	private int mapHeight;
	private int mapWidth;
	private boolean soundChecked = false;
	private GameObjectCollection theCollection;
	
	
	//initiate vector and iterator
	private Vector<GameObject> WorldObjects;
	//Iterator<GameObject> itr; 
	
	//robot begins where base one begins 50,50 
	Robot robot = new Robot(50,50);
	NonePlayerRobot npr = new NonePlayerRobot(50,50);
	public GameWorld() {
		theCollection = new GameObjectCollection();
	}
	
	//GameWorld methods	
	public void init()
    {
		Random r = new Random();
		theCollection = new GameObjectCollection();
		//WorldObjects = new Vector<GameObject>();
		//itr = WorldObjects.iterator();
		
		//4 bases: between x_0-1024 & y_0-768 *first base begins at 50,50*
		theCollection.add(new Base(50,50,1));
		theCollection.add(new Base(150,150,2));
		theCollection.add(new Base(250,200,3));
		theCollection.add(new Base(450,450,4));
		theCollection.add(new Base(500,500,5));
		theCollection.add(new Base(540,560,6));
		theCollection.add(new Base(610,600,7));
		theCollection.add(new Base(765,730,8));
		theCollection.add(new Base(800,832,9));
		
		//2 energy stations 
		theCollection.add(new EnergyStation(r.nextInt((1024 - 0)+1)+0, r.nextInt((768 - 0)+1)+0, r.nextInt((50 - 10 )+1) + 10));
		theCollection.add(new EnergyStation(r.nextInt((1024 - 0)+1)+0, r.nextInt((768 - 0)+1)+0, r.nextInt((50 - 10 )+1) + 10));
		
		//2 drones
		theCollection.add(new Drone(r.nextInt((1024 - 0)+1)+0, r.nextInt((768 - 0)+1)+0, r.nextInt((50 - 10 )+1) + 10, r.nextInt((359- 0 )+1) + 0,  r.nextInt((15 - 5 )+1) + 5));
		theCollection.add(new Drone(r.nextInt((1024 - 0)+1)+0, r.nextInt((768 - 0)+1)+0, r.nextInt((50 - 10 )+1) + 10, r.nextInt((359- 0 )+1) + 0,  r.nextInt((15 - 5 )+1) + 5));
		
		//robot
		theCollection.add(robot);
		theCollection.add(npr);
		this.setChanged();
		this.notifyObservers();
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
		this.setChanged();
		this.notifyObservers();
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
		this.setChanged();
		this.notifyObservers();
	}
	
	/**
	 * these methods call robot method to steer without this robot steering left/ right won't happen
	 */
	public void steeringDirectionLeft()
	{
		robot.turnLeft();
		this.setChanged();
		this.notifyObservers();
	}
	
	public void steeringDirectionRight()
	{
		robot.turnRight();
		this.setChanged();
		this.notifyObservers();
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
		this.setChanged();
		this.notifyObservers();
	}
	
	/**
	 * checks if energy has been ran over and spawns a new one
	 */
	public void ranOverEnergyStation()
	{
		Random r = new Random();
		//itr = WorldObjects.iterator();
		IIterator elements = theCollection.getIterator();
		while(elements.hasNext())
		{
			if(elements.getNext() instanceof EnergyStation)
			{
				if(((EnergyStation) elements.getNext()).getCapacity() != 0)
				{
					robot.setEnergyLevel(robot.getEnergyLevel() + ((EnergyStation) elements.getNext()).getCapacity() );
					((EnergyStation) elements.getNext()).setCapacity(0);
					((EnergyStation) elements.getNext()).setColor(ColorUtil.rgb(0,100,0));
					
				}
			}
		}
		theCollection.add(new EnergyStation(r.nextInt((1024 - 0)+1)+0, r.nextInt((768 - 0)+1)+0, r.nextInt((50 - 10 )+1) + 10));
		this.setChanged();
		this.notifyObservers();
	}
	
	/**
	 * Check if robot has made contact with drone/robot
	 */
	public void contactWithDrone()
	{
		robot.hitDrone();
		this.setChanged();
		this.notifyObservers();
	}
	
	public void contactWithRobot()
	{
		robot.hitRobot();
		this.setChanged();
		this.notifyObservers();
	}
	
	/**
	 * clock
	 */
	public void clockTick()
	{
		IIterator elements = theCollection.getIterator();
		

		timer++;
		robot.energyDrain();
		while(elements.hasNext())
		{
			if(elements.getNext() instanceof Drone || elements.getNext() instanceof Movable )
			{
				((Drone) elements.getNext()).headingChange();
				((Movable) elements.getNext()).move();
			}

		}
		
		if(robot.getTheRobotIsDead())
		{
			lives = lives -1;
			if(lives == 0)
			{
				//not true that the robot died but the lives reached 0
				System.out.print("No lives left, Game Over");
				this.init();
			}
			else
			{
				//if its true that the robot has died
				System.out.print("Your Robot Died");
				this.init();
			}
		}
		
		if(robot.getLastBaseReached() == finalBase)
		{
			System.out.println("You win" + this.timer);
		}
		this.setChanged();
		this.notifyObservers();
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
		System.out.println("____\t____\t_____\t_____\t_____\t____\t_____\t____\t_____\t_____\t_____\t_____\t_____");
		
	
		
	}
	
	/**
	 * map display
	 */
	public void mapDisplay()
	{
		//itr = WorldObjects.iterator();
		IIterator elements = theCollection.getIterator();
		
		System.out.println();
		while(elements.hasNext())
		{

			System.out.println(elements.getNext().toString());
		}
		
		System.out.println("____\t____\t_____\t_____\t_____\t____\t_____\t____\t_____\t_____\t_____\t_____\t_____");
	}
	
	/**
	 * 	exit of of the game
	 */
	public void exit()
	{
	
		System.exit(0);		

	}
	
	public int getLives()
	{
		return lives;
	}
	
	public int getTime()
	{
		return timer;
	}
	
	public int getLastBaseReached()
	{
		return robot.getLastBaseReached();
	}
	
	public int getRobotEnergyLevel()
	{
		return robot.getEnergyLevel();
	}

	public int getRobotDamageLevel()
	{
		return robot.getDamageLevel();
	}
	
	public String isSound()
	{
		if(this.soundChecked)
		{
			return "On";
		}
		else
		{
			return "Off";
		}
	}
	
	public void soundSetting() 
	{
		this.soundChecked = !(this.soundChecked);
		
		this.setChanged();
		this.notifyObservers();
	}
	
	public void setMapHeight(int height) 
	{
		this.mapHeight = height;
		
		System.out.println("" + height);
	}
	

	public void setMapWidth(int width) 
	{
		this.mapWidth = width;
		
		//System.out.println("" + width);
	}

	
}

