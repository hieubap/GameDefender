package Primary;

import java.awt.Point;
import java.util.ArrayList;

public class Finder {
	private boolean[][] map;
	private int width,height;
	public ArrayList<Integer> wayx,wayy;
	
	public Finder(boolean[][] input) {
		width = input.length;
		height = input[0].length;
		map = new boolean[width][height];
		wayx = new ArrayList<Integer>();
		wayy = new ArrayList<Integer>();
		
		for(int x=0;x<width;x++)
			for(int y=0;y<height;y++)
			{
				if(!input[x][y]){
                    map[x][y] = false;
                }else{
                    map[x][y] = true;
                }
			}
		
		for(int x=0;x<width;x++)
			{for(int y=0;y<height;y++)
			{
				if(map[x][y]) System.out.print("1 ");
				else System.out.print("0 ");
                
			}
			System.out.println();
			}
		
		
	}
	
	public int getMove(int a,int b,int x,int y) {
		System.out.println("Finder");
		if(x==a && y==b){
            return 4;
        }
		
		boolean[][] valid = new boolean[31][29];
		
		for(int i=0;i<31;i++)
			for(int j=0;j<29;j++)
				valid[i][j]= map[i][j];
		valid[b][a] = true;
		
		Find[] Maze = new Find[500];
		
		int size = 1;
		int done=0;
		Find start = new Find(a, b, 0);
		Maze[0] = start;
		System.out.println("start: ");
		render(valid);
		
		for(int i=0;i< size ; i++)			
		{
			if(Maze[i].x==x&&Maze[i].y==y)
			{
			System.out.println("i= "+i);
			done=i;
			break;
			}
			if(Maze[i].x>0&&!valid[Maze[i].y][Maze[i].x-1])
			{
				valid[Maze[i].y][Maze[i].x-1]=true;
				Find m = new Find(Maze[i].x-1, Maze[i].y, i);
				Maze[size] = m;
				size++;
			}
			if(Maze[i].y>0&&!valid[Maze[i].y-1][Maze[i].x])
			{
				valid[Maze[i].y-1][Maze[i].x]=true;
				Find m = new Find(Maze[i].x, Maze[i].y-1, i);
				Maze[size] = m;
				size++;
			}
			if(Maze[i].x<28&&!valid[Maze[i].y][Maze[i].x+1])
			{
				valid[Maze[i].y][Maze[i].x+1]=true;
				Find m = new Find(Maze[i].x+1, Maze[i].y, i);
				Maze[size] = m;
				size++;
			}
			if(Maze[i].y<30&&!valid[Maze[i].y+1][Maze[i].x])
			{
				valid[Maze[i].y+1][Maze[i].x]=true;
				Find m = new Find(Maze[i].x, Maze[i].y+1, i);
				Maze[size] = m;
				size++;
			}
			System.out.println();
			if(i<5)
			{
				System.out.println("i= "+i);
			render(valid);
			}
		}
		render(valid);
		
		System.out.println("size : "+size);
		System.out.println(done);
		
		
		int xp = -1;
		int yp = -1;
		
		while(Maze[done].parent!=0) {
			wayx.add(Maze[done].x);
			wayx.add(Maze[done].y);
			done = Maze[done].parent;
			
			System.out.println(done);
		}
			xp = Maze[done].x;
			yp = Maze[done].y;
		
		if(xp == a - 1 && yp == b)
			return 2;
		if(xp == a + 1 && yp == b)
			return 0;
		if(xp == a && yp == b - 1)
			return 3;
		if(xp == a && yp == b + 1)
			return 1;
		return 4;
		
	}

	private class Find{
		public int x,y,parent;
		
		public Find(int a,int b,int c) {
			x=a;
			y=b;
			parent=c;
		}
	}
	public ArrayList<Integer> getWayX(){
		return wayx;
	}
	public ArrayList<Integer> getWayY(){
		return wayy;
	}
	
	public void render(boolean[][] a) {
		for(int x=0;x<31;x++)
		{for(int y=0;y<29;y++)
		{
			if(a[x][y]) System.out.print("1 ");
			else System.out.print("0 ");
            
		}
		System.out.println();
		}
	
	}
}
