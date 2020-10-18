package Weapon;

import java.awt.Graphics;
import java.awt.Point;

public abstract class Weapon {
	public int time,timeLoad;
	public Point position;
	
	public abstract boolean fire(int a,int b);
	public abstract void paint(Graphics g);
	
	public boolean fullEnegy() {
//		System.out.println("time= "+timeLoad);
		if(timeLoad==time) {
			return true;
		}
		else 
		{
			return false;
		}
	}
	public void loadEnegy() {
		timeLoad--;
		if(timeLoad<=0)
			timeLoad = time;
	}
	public void setTimeload(int a) {
		if(time-a>=0)
		time-=a;
	}
}
