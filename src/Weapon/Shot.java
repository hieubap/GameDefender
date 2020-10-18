package Weapon;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Shot extends Weapon{
	private int speedshot;
	private final Color cl= Color.black;
	private Vector v;
	private Point positionTower;
	
	public Shot(int a,int b,int ss) {
		speedshot=ss;
		
		position = new Point(a, b);
		positionTower = new Point(a, b);
		v = new Vector(0, 0,speedshot);
		
	}
	public void paint(Graphics g) {
		g.setColor(cl);
		g.fillOval(position.x,position.y, 5, 5);
	}
	
	public void reset() {
		position.setLocation(positionTower);
	}
	
	public boolean fire(int a,int b) {
		if(Math.abs(position.x-a)<=speedshot&&Math.abs(position.y-b)<=speedshot) {
			reset();
			return false;
		}
		v.updateVector(a-position.x, b-position.y,speedshot);
		position.setLocation((int)Math.round(position.x+v.x), (int)Math.round(position.y+v.y));
		
		return true;
	}
	public void setSpeed(int a) {
		speedshot+=a;
	}
}
