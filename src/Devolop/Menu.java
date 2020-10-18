package Devolop;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.JPanel;

import Primary.WindowGame;
import Tower.Element;
import Tower.Tower;

@SuppressWarnings("serial")
public class Menu extends JPanel{
	protected Rectangle start,map,exit,tutorial,map1,map2,up1,up2,up3,up4,fusionmode,back,remove,fusion;
	public ArrayList<Tower> sacrifice = new ArrayList<Tower>();
	
	public Menu() {
		start= new Rectangle(200, 100, 200, 100);
		map= new Rectangle(200, 210, 200, 100);
		tutorial = new Rectangle(200, 320, 200, 100);
		exit= new Rectangle(200, 430, 200, 100);
		
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
		
	}
	public void drawback(Graphics g) {
		Graphics2D g2d = (Graphics2D) g.create();
		g2d.fill(remove);
		g2d.setColor(Color.white);
		g2d.drawString("BACK", 850, 400);
	}
	
	
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g.create();
		g2d.setColor(Color.LIGHT_GRAY);
		g2d.fill(start);
		g2d.fill(map);
		g2d.fill(tutorial);
		g2d.fill(exit);
		
		
		g.setColor(Color.black);
		g.drawString("START", 480, 160);
		g.drawString("MAP", 480, 270);
		g.drawString("TUTORIAL", 480, 380);
		g.drawString("EXIT", 480, 490);
		
	}
	public void paintmap(Graphics g) {
		Graphics2D g2d= (Graphics2D) g.create();
		
		g2d.setColor(Color.LIGHT_GRAY);
		g2d.fill(map1);
		g2d.fill(map2);
		
		g.setColor(Color.black);
		g.drawString("MAP 1", 280, 150);
		g.drawString("MAP 2", 280, 300);
		
		
	}
	public boolean startcontain(int a,int b) {
		if(start.contains(a, b)) return true;
		return false;
	}
	public boolean mapcontain(int a,int b) {
		if(map.contains(a, b)) return true;
		return false;
	}
	public boolean tutorialcontain(int a,int b) {
		if(tutorial.contains(a, b)) return true;
		return false;
	}
	public boolean exitcontain(int a,int b) {
		return exit.contains(a, b);
	}
	public boolean map1contain(int a,int b) {
		if(map1.contains(a, b)) return true;
		return false;
	}
	public boolean map2contain(int a,int b) {
		if(map2.contains(a, b)) return true;
		return false;
	}	
}
