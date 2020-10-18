package Tower;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import Devolop.Menu;
import Devolop.Setup;
import Primary.WindowGame;
import Weapon.Laze;
import Weapon.Weapon;

public class Tower{
	private int x,y,w,range,damage,speed,sell,up1,up2,up3,maxRange=200,maxDamage=200,maxSpeed=2;
	private boolean[] element = new boolean[5];
	public Element[] elementn;
	
	public boolean shot = false;
	public Color color;
	private Weapon weapon;
	
	public Tower(int a,int b,Element[] tp) {
		this.x=a;
		this.y=b;
		elementn = tp;
		for(int i=0;i<element.length;i++)
			element[i] = false;
		
		for(int i=0;i<tp.length;i++)
			{
			if(getPosition(tp[i])!=-1)
			{
				element[getPosition(tp[i])] = true;
//				color= WindowGame.colorElement[getPosition(tp[i])];
				System.out.println("++++");
			}
			}
		for(int i=0;i<5;i++) 
			if(element[i]) System.out.print("  1");
			else System.out.print("  0");
		color = Setup.getColorFusion(tp);
		w=20;
		range=100;
		damage=20;
		speed=20;
		sell=2;
		up1=5;
		up2=5;
		up3=5;
		
		weapon = new Laze(x, y, speed,color);
	}
	
	public Weapon getWeapon() {
		return weapon;
	}
	public boolean canFightElement(Element[] target) {
		for(int i=0;i<target.length;i++) {
			if(getPosition(getFight(target[i]))!= -1 && !element[getPosition(getFight(target[i]))]) {
				return false;
			}
		}
		return true;
	}
	public static int getPosition(Element target) {
		switch(target) {
		case Fire: return 0;
		case Water: return 1;
		case Earth: return 2;
		case Thunder: return 3;
		case Wind: return 4;
		case none: break;
		}
		return -1;
	}
	public static Element getElementOfPosition(int target) {
		switch(target) {
		case 0: return Element.Fire;
		case 1: return Element.Water;
		case 2: return Element.Earth;
		case 3: return Element.Thunder;
		case 4: return Element.Wind;
		}
		return Element.none;
	}
	
	public Element getFight(Element target) {
		switch(target) {
		case Fire: return Element.Water;
		case Water: return Element.Earth;
		case Earth: return Element.Thunder;
		case Thunder: return Element.Wind;
		case Wind: return Element.Fire;
		case none: break;
		}
		return Element.none;
	}
	////////
	public boolean onRange(int u,int v) {
		if(Math.pow(u-x, 2)+Math.pow(v-y, 2)<=range*range) return true;
		
		return false;
	}
	
	public void draw(Graphics g) {
		g.setColor(color);
		g.fillOval(x-w/2, y-w/2, w,w);
	}
	public void drawRange(Graphics g) {
		g.setColor(Color.GRAY);
		g.drawOval(x-range, y-range, range*2, range*2);
		
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public int getSell() {
		return sell;
	}
	public boolean[] getElement() {
		return element;
	}
	public int getLevelElement() {
		int count = 0;
		for(int i=0;i<element.length;i++)
			if(element[i])
				count++;
		return count;
	}
	public int getRange() {
		return range;
	}
	public int getMaxRange() {
		return maxRange;
	}
	public int getDamage() {
		return damage;
	}
	public int getMaxDamage() {
		return maxDamage;
	}
	public int getSpeed() {
		return speed;
	}
	public int getMaxSpeed() {
		return maxSpeed;
	}
	public int getup1() {
		return up1;
	}
	public int getup2() {
		return up2;
	}
	public int getup3() {
		return up3;
	}
//	public int getsupport() {
//		return support;
//	}
	
	
	public void upDamage_Coin(int a,int b) {
		sell+=b/2;
		damage+=a;
		up1+=b;
	}
	public void upRange_Coin(int a,int b) {
		sell+=b/2;
		range+=a;
		up2+=b;
	}
	public void upSpeed_Coin(int a,int b) {
		sell+=b/2;
		speed-=a;
		up3+=b;
		weapon.setTimeload(a);
	}
	public void fusionElement(ArrayList<Element> element) {
		for(Element e : element)
			{
			int j=getPosition(e);
			this.element[j] = true;
			color = new Color(color.getRGB()+WindowGame.colorElement[j].getRGB());
			}
		
		w=10;
		range=100;
		damage=20;
		speed=20;
		sell=2;
		up1=5;
		up2=5;
		up3=5;
	}
	public void setup1(int a) {
		up1+=a;
	}
	public void setup2(int a) {
		up2+=a;
	}
	public void setup3(int a) {
		up3+=a;
	}
	
}
