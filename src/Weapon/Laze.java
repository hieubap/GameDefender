package Weapon;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Laze extends Weapon{
		public int mx,my;
		public Color color;
		public Laze(int a,int b,int c,Color cl) {
			position = new Point(a, b);
			time=c;
			timeLoad = time;
			color = cl;
		}
		public void paint(Graphics g) {
			g.setColor(color);
			if(timeLoad<time/2) {
				g.drawOval(position.x-15, position.y-15, 30, 30);
			}
			if(!(time == timeLoad)) return;
			
			g.drawLine(position.x, position.y, mx, my);
			g.drawLine(position.x-1, position.y, mx, my);
			g.drawLine(position.x+1, position.y, mx, my);
		
		}
		
		@Override
		public boolean fire(int a, int b) {
			mx=a;my=b;
			return true;
		}
}
