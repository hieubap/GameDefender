package Primary;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import javax.swing.JPanel;


@SuppressWarnings("serial")
public class Map extends JPanel{
	public static int PIXEL = 30;
	private int map[][];
	private Rectangle2D t1,t2,t3,t4,t5;
	private int w=20,h=11,walk_ennemy;
	private int attack[];
	public ArrayList<Integer> way;
	
	public Map(int lv) {
		map = new int[h][w];
		
		
		t1=new Rectangle2D.Float(40f, 600f, 60f, 50f);
		t2=new Rectangle2D.Float(110f, 600f, 60f, 50f);
		t3=new Rectangle2D.Float(180f, 600f, 60f, 50f);
		t4=new Rectangle2D.Float(250f, 600f, 60f, 50f);
		t5=new Rectangle2D.Float(320f, 600f, 60f, 50f);
		
		
		if(lv==1) {
			walk_ennemy=9;
			attack= new int[walk_ennemy+2];
			int atk[]= {
				624,159,97,221,624,283,97,345,621,0,0
			};
			for(int i=0;i<walk_ennemy+2;i++)
				attack[i]=atk[i];
			int mp1[][]= {
				{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
				{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1},
				{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
				{1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
				{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
				{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1},
				{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
				{1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
				{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
				
			};

			for(int i=0;i<h;i++) 
				for(int j=0;j<w;j++) 
					map[i][j]=mp1[i][j];
		}
		else if(lv==2) {
			walk_ennemy=17;
			attack= new int[walk_ennemy+2];
			int atk[]= {
					314,159,97,221,314,283,97,345,624,283,376,221,624,159,376,97,666,0,0
				};
				for(int i=0;i<walk_ennemy+2;i++)
					attack[i]=atk[i];
			int mp2[][]= {
					{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
					{0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0},
					{1,1,1,1,1,1,1,1,0,1,0,1,1,1,1,1,1,1,1,1},
					{1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,1},
					{1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1},
					{1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,1},
					{1,1,1,1,1,1,1,1,0,1,0,1,1,1,1,1,1,1,1,1},
					{1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,1},
					{1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1},
					{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
					{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
			};

			for(int i=0;i<h;i++) 
				for(int j=0;j<w;j++) 
					map[i][j]=mp2[i][j];
		}
	}
	public int take(int a) {
		return attack[a];
	}
	public int getWalk() {
		return walk_ennemy;
	}
	public void paint(Graphics g,int coin) {
		Graphics2D g2d = (Graphics2D) g.create();

		g2d.setColor(WindowGame.colorElement[0]);
		g2d.draw(t1);
		if(coin>9) g2d.fill(t1);
		g2d.setColor(WindowGame.colorElement[1]);
		g2d.draw(t2);
		if(coin>10) g2d.fill(t2);
		g2d.setColor(WindowGame.colorElement[2]);
		g2d.draw(t3);
		if(coin>9) g2d.fill(t3);
		g2d.setColor(WindowGame.colorElement[3]);
		g2d.draw(t4);
		if(coin>10) g2d.fill(t4);
		g2d.setColor(WindowGame.colorElement[4]);
		g2d.draw(t5);
		if(coin>9) g2d.fill(t5);
		
		g2d.setColor(Color.lightGray);
		g.setColor(Color.black);
		
		g.drawString("FIRE", 57, 630);
		g.drawString("WATER", 117, 630);
		g.drawString("EARTH", 190, 630);
		g.drawString("THUNDER", 252, 630);
		g.drawString("WIND", 335, 630);
		
		
		for(int i=0;i<h;i++) {
			for(int j=0;j<w;j++) {
				//System.out.print(map[i][j]+" ");
				if(map[i][j]!=0) {
				g2d.fillRect(50+j*(PIXEL+1), 50+i*(PIXEL+1), PIXEL, PIXEL);
				g.drawRect(50+j*(PIXEL+1), 50+i*(PIXEL+1), (PIXEL+1), (PIXEL+1));
				}
			}
			//System.out.println();
		}
	}
	
	public boolean t1contain(int x,int y) {
		if(t1.contains(x, y)) return true;
		return false;
	}
	public boolean t2contain(int x,int y) {
		if(t2.contains(x, y)) return true;
		return false;
	}
	public boolean t3contain(int x,int y) {
		if(t3.contains(x, y)) return true;
		return false;
	}
	public boolean t4contain(int x,int y) {
		if(t4.contains(x, y)) return true;
		return false;
	}
	public boolean t5contain(int x,int y) {
		if(t5.contains(x, y)) return true;
		return false;
	}
	
	public int getmap(int a,int b) {
		return map[a][b];
	}
	public void setmap(int a,int b,int c) {
		map[a][b]=c;
	}
	public boolean checkarea(int a,int b) {
		if(0<=a&&a<=w-1&&0<=b&&b<=h-1) return true;
		return false;
	}
}
