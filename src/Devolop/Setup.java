package Devolop;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import javax.swing.Timer;

import Primary.Control;
import Primary.WindowGame;
import Tower.Element;
import Tower.Tower;
import Weapon.Vector;

public class Setup extends Menu{
	public Timer movetomap;
	public Control control;
	
	public Setup(Control control) {
		this.control = control;
		start= new Rectangle(400, 100, 200, 100);
		map= new Rectangle(400, 210, 200, 100);
		tutorial = new Rectangle(400, 320, 200, 100);
		exit= new Rectangle(400, 430, 200, 100);
		
		
		map1= new Rectangle(200, 100, 200, 100);
		map2= new Rectangle(200, 250, 200, 100);
		up1= new Rectangle(800, 50, 150, 50);
		up2= new Rectangle(810, 110, 150, 50);
		up3= new Rectangle(820, 170, 150, 50);
		up4= new Rectangle(730, 230, 185, 50);
		fusionmode = new Rectangle(730, 290, 250, 50);
		back = new Rectangle(720, 370, 100, 50);
		remove = new Rectangle(830, 370, 100, 50);
		fusion = new Rectangle(780, 430, 100, 50);
		
		movetomap = new Timer(20, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				upTower.setRect(upTower.getX()+vectormove.x, upTower.getY()+vectormove.y, 20, 20);
				
				control.repaint();
				if(Math.abs(upTower.getX() - sx) <= 0.1 || Math.abs(upTower.getY() - sy) <= 0.1) {
					movetomap.stop();
					up = true;
					fusioning = false;
					upTower.setRect(800,210,20,20);
				}
			}
		});
	}
	public boolean up1contain(int a,int b) {
		if(up1.contains(a, b)) return true;
		return false;
	}
	public boolean up2contain(int a,int b) {
		if(up2.contains(a, b)) return true;
		return false;
	}
	public boolean up3contain(int a,int b) {
		if(up3.contains(a, b)) return true;
		return false;
	}
	public boolean up4contain(int a,int b) {
		if(up4.contains(a, b)) return true;
		return false;
	}
	public boolean fusionmodecontain(int a,int b) {
		if(fusionmode.contains(a, b)) return true;
		return false;
	}
	public boolean backcontain(int a,int b) {
		if(back.contains(a, b)) return true;
		return false;
	}
	public boolean removecontain(int a,int b) {
		if(remove.contains(a, b)) return true;
		return false;
	}
	public boolean fusioncontain(int a,int b) {
		if(fusion.contains(a, b)) return true;
		return false;
	}
	
	public ArrayList<Element> getElement(){
		ArrayList<Element> e = new ArrayList<Element>();
		
		
		return e;
	}
	public void p_coin(Graphics g,int a,int b,int c,int d,int e) {
		Graphics2D g2d = (Graphics2D) g.create();
		g2d.setColor(Color.darkGray);
		g2d.fill(up1);
		g2d.fill(up2);
		g2d.fill(up4);
		g2d.setColor(Color.gray);
		g2d.fillRect(730, 50, 65, 50);
		g2d.fillRect(730, 110, 75, 50);
		g2d.fillRect(920, 230, 60, 50);
		
		g2d.fillRect(50, 520, 400, 50);
		
		g.setColor(Color.white);
		g.drawString("coin: "+String.valueOf(a), 740, 80);
		g.drawString("coin: "+String.valueOf(b), 740, 140);
		g.drawString(String.valueOf(e)+" coin", 930, 260);
		g.drawString("UPGRADE COIN", 820,80);
		g.drawString("UPGRADE SPEED", 830,140);
		g.drawString("SELL", 750,260);
		g.setColor(Color.BLACK);
		g.drawString("Coin/s:  "+String.valueOf(c), 70, 550);
		g.drawString("Speed:  "+String.valueOf(d), 370, 550);
		
	}
	public void p_gun(Graphics g,int a,int b,int c,int d,int e,int f,int h) {
		Graphics2D g2d = (Graphics2D) g.create();
		g2d.setColor(Color.darkGray);
		g2d.fill(up1);
		g2d.fill(up2);
		g2d.fill(up3);
		g2d.fill(up4);
		
		g2d.setColor(Color.gray);
		g2d.fillRect(730, 50, 65, 50);
		g2d.fillRect(730, 110, 75, 50);
		g2d.fillRect(730, 170, 85, 50);
		g2d.fillRect(920, 230, 60, 50);
		
		g2d.fillRect(50, 520, 800, 50);
		
		g.setColor(Color.white);
		g.drawString("coin: "+String.valueOf(a), 740, 80);
		g.drawString("coin: "+String.valueOf(b), 740, 140);
		g.drawString("coin: "+String.valueOf(c), 740, 200);
		g.drawString(String.valueOf(h)+" coin", 930, 260);
		g.drawString("UPGRADE DAMAGE", 820,80);
		g.drawString("UPGRADE RANGE", 830,140);
		g.drawString("UPGRADE SPEED", 840,200);
		g.drawString("SELL", 750,260);
		
		g.setColor(Color.BLACK);
		g.drawString("Damage:  "+String.valueOf(d), 70, 550);
		g.drawString("Range:  "+String.valueOf(e), 220, 550);
		g.drawString("Speed:  "+String.valueOf(f), 370, 550);
		
	}
	public void p_ice(Graphics g,int a,int b,int c,int d,int e,int f,int h) {
		Graphics2D g2d = (Graphics2D) g.create();
		g2d.setColor(Color.darkGray);
		g2d.fill(up1);
		g2d.fill(up2);
		g2d.fill(up3);
		g2d.fill(up4);
		g2d.setColor(Color.gray);
		g2d.fillRect(730, 50, 65, 50);
		g2d.fillRect(730, 110, 75, 50);
		g2d.fillRect(730, 170, 85, 50);
		g2d.fillRect(920, 230, 60, 50);
		
		g2d.fillRect(50, 520, 400, 50);
		
		g.setColor(Color.white);
		g.drawString("coin: "+String.valueOf(a), 740, 80);
		g.drawString("coin: "+String.valueOf(b), 740, 140);
		g.drawString("coin: "+String.valueOf(c), 740, 200);
		g.drawString(String.valueOf(h)+" coin", 930, 260);
		g.drawString("UPGRADE ENEMY", 820,80);
		g.drawString("UPGRADE RANGE", 830,140);
		g.drawString("UPGRADE SPEED", 840,200);
		g.drawString("SELL", 750,260);
		g.setColor(Color.BLACK);
		g.drawString("Enemy:  "+String.valueOf(d), 70, 550);
		g.drawString("Range:  "+String.valueOf(e), 220, 550);
		g.drawString("Speed:  "+String.valueOf(f), 370, 550);
		
	}
	public void p_laze(Graphics g,Tower tower) {
		
		Graphics2D g2d = (Graphics2D) g.create();
		g2d.setColor(Color.darkGray);
		g2d.fill(up1);
		g2d.fill(up2);
		g2d.fill(up3);
		g2d.fill(up4);
		g2d.fill(fusionmode);
		
		g2d.setColor(Color.gray);
		g2d.fillRect(730, 50, 65, 50);
		g2d.fillRect(730, 110, 75, 50);
		g2d.fillRect(730, 170, 85, 50);
		g2d.fillRect(920, 230, 60, 50);
		
		g2d.fillRect(50, 520, 800, 50);
		
		g.setColor(Color.white);
		g.drawString("coin: "+String.valueOf(tower.getup1()), 740, 80);
		g.drawString("coin: "+String.valueOf(tower.getup2()), 740, 140);
		g.drawString("coin: "+String.valueOf(tower.getup3()), 740, 200);
		g.drawString(String.valueOf(tower.getSell())+" coin", 930, 260);
		g.drawString("UPGRADE DAMAGE", 820,80);
		g.drawString("UPGRADE RANGE", 830,140);
		g.drawString("UPGRADE SPEED", 840,200);
		g.drawString("SELL", 750,260);
		g.drawString("FUSION ELEMENT", 800,320);
		
		g.setColor(Color.BLACK);
		g.drawString("Damage:  "+String.valueOf(tower.getDamage()), 70, 550);
		g.drawString("Range:  "+String.valueOf(tower.getRange()), 220, 550);
		g.drawString("Speed:  "+String.valueOf(tower.getSpeed()), 370, 550);
		g.drawString("Element:  ", 520, 550);
		
		for(int i=0;i<5;i++) {
			if(tower.getElement()[i]) {
				g2d.translate(600+i*50, 540);
				g2d.rotate(Math.PI/4);
				
				g2d.setColor(WindowGame.colorElement[i]);
				g2d.fillRect(-10,-10, 20, 20);
				
				g2d.rotate(-Math.PI/4);
				g2d.translate(-600-i*50, -540);
			}
		}
		
		if(tower.getSpeed()<=tower.getMaxSpeed()) {
			g2d.fillRect(730, 170, 240, 50);
			g.setColor(Color.white);
			g.drawString("MAX", 840, 200);
		}
		if(tower.getRange()>=tower.getMaxRange()) {
			g2d.fillRect(730,110,240,50);
			g.setColor(Color.white);
			g.drawString("MAX", 840, 140);
		}
		if(tower.getDamage()>=tower.getMaxDamage()) {
			g2d.fillRect(730,50,240,50);
			g.setColor(Color.white);
			g.drawString("MAX", 840, 80);
		}
		
	}
	public boolean canfusion = false,fusioning = false;
	public void drawFusion(Graphics g) {
		Font f = g.getFont();
		Graphics2D g2d = (Graphics2D) g.create();
		g2d.setColor(Color.DARK_GRAY);
		g2d.fill(back);
		g2d.fill(remove);
		
		g.setColor(Color.white);
		g.drawString("BACK", 750, 400);
		g.drawString("REMOVE", 850, 400);
		
		g.setFont(new Font("Times New Roman", Font.BOLD, 20));
		g.setColor(Color.DARK_GRAY);
		g.drawString("Fusion",790, 80);
		
		if(sacrifice.size() == 0) System.exit(0);
		g.setColor(sacrifice.get(0).color);
		
		g.fillOval(800, 100, 50, 50);
		if(sacrifice.size()>=2)
		{
			g.setColor(sacrifice.get(1).color);
			g.fillOval(800-(int)(80*(1+Math.cos(72*Math.PI/180))), 100+(int)(80*Math.sin(72*Math.PI/180)), 50, 50);
		}
		if(sacrifice.size()>=3)
		{
			g.setColor(sacrifice.get(2).color);
			g.fillOval(800+(int)(80*(1+Math.cos(72*Math.PI/180))), 100+(int)(80*Math.sin(72*Math.PI/180)), 50, 50);
		}
		if(sacrifice.size()>=4)
		{
			g.setColor(sacrifice.get(3).color);
			g.fillOval(800-(int)(160*(1+Math.cos(72*Math.PI/180))*Math.cos(72*Math.PI/180)), 100+(int)(160*(1+Math.cos(72*Math.PI/180))*Math.sin(72*Math.PI/180)), 50, 50);
		}
		if(sacrifice.size()>=5) {
			g.setColor(sacrifice.get(4).color);
			g.fillOval(800+(int)(160*(1+Math.cos(72*Math.PI/180))*Math.cos(72*Math.PI/180)), 100+(int)(160*(1+Math.cos(72*Math.PI/180))*Math.sin(72*Math.PI/180)), 50, 50);
		}
		g.setColor(Color.gray);
		g.drawOval(800, 100, 50, 50);
		g.drawOval(800-(int)(80*(1+Math.cos(72*Math.PI/180))), 100+(int)(80*Math.sin(72*Math.PI/180)), 50, 50);
		g.drawOval(800+(int)(80*(1+Math.cos(72*Math.PI/180))), 100+(int)(80*Math.sin(72*Math.PI/180)), 50, 50);
		g.drawOval(800-(int)(160*(1+Math.cos(72*Math.PI/180))*Math.cos(72*Math.PI/180)), 100+(int)(160*(1+Math.cos(72*Math.PI/180))*Math.sin(72*Math.PI/180)), 50, 50);
		g.drawOval(800+(int)(160*(1+Math.cos(72*Math.PI/180))*Math.cos(72*Math.PI/180)), 100+(int)(160*(1+Math.cos(72*Math.PI/180))*Math.sin(72*Math.PI/180)), 50, 50);
		g.fillRect(800, 210, 50, 50);
		
		if(canfusion)
		{
			drawColorFusion(g2d);
		}
		g.setFont(f);
	}
	public void drawColorFusion(Graphics g) {
		Graphics2D g2d = (Graphics2D)g.create();
		int r = 0,gr=0,b=0,size = sacrifice.size();
		for(Tower t: sacrifice) {
			r = (r+t.color.getRed());
			gr = (gr+t.color.getGreen());
			b += (b+t.color.getBlue());
		}
		r = r/size;
		gr = gr/size;
		b = b/size;
		
		colorfusion = new Color(r%256,gr%256,b%256); 
		g.setColor(colorfusion);
		g.fillRect(800, 210, 50, 50);

		
		g2d.fill(fusion);
		g2d.setColor(Color.white);
		g2d.drawString("FUSION", 800, 460);
		
	}
	public Element[] getElementFusion() {
		Element[] out = new Element[5];
		for(int i =0;i<5;i++) out[i] = Element.none;
		boolean[] process = new boolean[5];
		for(int i=0;i<5;i++) process[i] = false;
		
		for(Tower t : sacrifice) {
			for(int j=0;j<5;j++)
				if(t.getElement()[j])
				process[j] = true;
		}
		for(int j=0;j<5;j++) {
			if(process[j]) {
				out[j] = Tower.getElementOfPosition(j);
			}
		}
		
		return out;
	}
	public static Color getColorFusion(Element[] element) {
		int r=0,g=0,b=0,count =0;
		for(int i=0;i<element.length;i++) {
			if(Tower.getPosition(element[i])!=-1)
			{
				r += WindowGame.colorElement[Tower.getPosition(element[i])].getRed();
				g += WindowGame.colorElement[Tower.getPosition(element[i])].getGreen();
				b += WindowGame.colorElement[Tower.getPosition(element[i])].getBlue();
				count ++;
			}
			}
		r= (r/count)%256;
		g= (g/count)%256;
		b= (b/count)%256;
		return new Color(r,g,b);
	}
	public Rectangle2D upTower;
	public Color colorfusion;
	public int sx,sy;
	public Vector vectormove;
	public Element[] element;
	public boolean up = false;
	public void startUp(int x,int y) {
		upTower = new Rectangle2D.Float(800,210,20,20);
		vectormove = new Vector((x-upTower.getX())/30, (y - upTower.getY())/30, 10);
		sx = x;
		sy = y;
		element = getElementFusion();
		
		movetomap.start();
		
	}
	public void paintUpTower(Graphics g) {
		Graphics2D g2d = (Graphics2D) g.create();
		
		g2d.setColor(colorfusion);
		if(upTower != null)
		g2d.fillOval((int)upTower.getX()-(int)upTower.getWidth()/2,(int)upTower.getY()-(int)upTower.getHeight()/2
				,(int)upTower.getWidth(),(int)upTower.getHeight());
		
	}
}
