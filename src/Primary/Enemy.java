package Primary;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;

import Devolop.Setup;
import Tower.Element;
import Tower.Tower;
/*
 * chu y clear array se clear ca aray nam trong mang 2 chieu
 * 
 */
@SuppressWarnings("serial")
public class Enemy extends JPanel{
	private int PIXEL = Map.PIXEL;
	private int sx,sy,x,y,w,t,k,gold;
	private double life,plife;
	private boolean dead,appear,stop;
	private Color cl;
	private ArrayList<Enemy> a1,a2,a3,a4,a5;//,a4,a5,a6,a7,a8,a9,a10,a11,a12,a13;
	private Element[] element;
	
	public void init() {
		
		a1 = new ArrayList<Enemy>();
		a2 = new ArrayList<Enemy>();
		a3 = new ArrayList<Enemy>();
		a4 = new ArrayList<Enemy>();
		a5 = new ArrayList<Enemy>();
		
		
		// lv1
//		Element[] ee = {Element.Water};
		for(int i=0;i<20;i++)
			{
			a1.add(new Enemy(PIXEL/2+50, PIXEL/2+PIXEL+50, getRandomElement(1)));
			}
		// lv2
		for(int i=0;i<20;i++)
			{
			a2.add(new Enemy(75,94,getRandomElement(2)));
			}
		for(int i=0;i<20;i++)
		{
		a3.add(new Enemy(75,94,getRandomElement(3)));
		}
		for(int i=0;i<20;i++)
		{
		a4.add(new Enemy(75,94,getRandomElement(4)));
		}
		for(int i=0;i<20;i++)
		{
		a5.add(new Enemy(75,94,getRandomElement(5)));
		}
	
	}
	public Element[] getElement() {
		return element;
	}
	public Element[] getRandomElement(int input){
		ArrayList<Integer> r = new ArrayList<Integer>();
		for(int i=0;i<5;i++)
			r.add(i);
		
		for(int i=0;i<5-input;i++)
			r.remove((int)(Math.random()*(r.size())));
		
		Element[] out = new Element[input];
		for(int i=0;i<input;i++) {
			out[i] = Tower.getElementOfPosition(r.get(i));
		}
		return out;
	}
	public Enemy(int a,int b,Element[] element) {
		
		k=0;
		x=a;
		y=b;
		sx=a;
		sy=b;
		this.element = element;
		appear=false;
		stop=false;
		
		w=PIXEL/2;
		life=100;
		cl= Setup.getColorFusion(element);
		gold=2;
		
		plife=life;//
		dead=false;
		t=1;
	}
	public void appear() {
		appear=true;
	}
	public void setk() {
		k++;
	}
	public int getk() {
		return k;
	}
	public void resetk() {
		k=0;
	}
	public int getGold() {
		return gold;
	}
	public void paint(Graphics g) {
		if(!appear) return;
		
		g.setColor(cl);
		g.fillRect(x-w/2, y-w/2, w, w);
		if(life>=0) {
		g.setColor(Color.red);
		double l = (life/plife)*(w);
		g.drawLine(x-w/2-2, y-w/2-4, (int)(x-w/2+l), y-w/2-4);
		}
	}
	public void reset() {
		x=sx;
		y=sy;
	}
	public boolean go(int a,int b) {
		if(life<0) dead=true;
		if(!appear||stop)
			return false;
		if(a==0) {
			reset();
			t=1;
			return true;
		}
		switch(t) {
		case 1: 
			x++;
			if(x==a) {
				if(y<b) t=2;
				else t=4;
				return true;
			}
			break;
		case 2: 
			y++;
			if(y==a) {
				if(x<b) t=1;
				else t=3;
				return true;
			}
			break;
		case 3: 
			x--;
			if(x==a) {
				if(y<b) t=2;
				else t=4;
				return true;
			}
			break;
		case 4: 
			y--;
			if(y==a) {
				if(x<b) t=1;
				else t=3;
				return true;
			}
			break;
		}
		return false;
	}
	public void decreaseLife(int a) {
		life-=a;
	}
	public void stop() {
		stop=true;
	}
	public boolean getDead() {
		return dead;
	}
	public int getX() {
		return x;
	}
	public void setT(int a) {
		t=a;
	}
	public int getY() {
		return y;
	}
	
	public ArrayList<Enemy> getAttack(int a){
		switch(a) {
		case 1: return a1;
		case 2: return a2;
		case 3: return a3;
		case 4: return a4;
		case 5: return a5;
		}
		return a1;
	}
	public Enemy getEnemy(int a,int b) {
		switch(a) {
		case 1: return a1.get(b);
		case 2: return a2.get(b);
		case 3: return a3.get(b);
		case 4: return a4.get(b);
		case 5: return a5.get(b);
		
		}
		return a3.get(b);
	}
}
