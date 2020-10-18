package Weapon;

public class Vector {
	public double x,y,length,phi;
	
	public Vector(double x,double y) {
		this.x = x;
		this.y = y;
		phi = Math.atan2(y, x);
		
		setlength(x, y);
	}
	public Vector(double x,double y,double l) {
		this.length = l;
		this.x = x;
		this.y = y;
		updateVector(l);
		
	}
	public void setlength(double x,double y) {
		length = Math.sqrt(Math.pow(x, 2)+ Math.pow(y, 2));
		this.x = x;
		this.y = y;
	}
	public void updateVector(double length) {
		double k = length/this.length;
		x*=k;
		y*=k;
		
		this.length = length;
	}
	public void updateVector(double x,double y) {
		this.x = x;
		this.y = y;
		phi = Math.atan2(y, x);
		setlength(x, y);
	}
	public void updateVector(double x,double y,double l) {
		this.x = x;
		this.y = y;
		setlength(x, y);
		this.phi = Math.atan2(y, x);
		
		updateVector(l);
	}
	public void rotate(double phi) {// phi rotote clockwise
		this.phi -= phi;
		x = length*Math.cos(phi);
		y = length*Math.sin(phi);
	}
	
	public void add(Vector a) {
		x = Math.round(x+a.x);
		y = Math.round(y+a.y);
		phi = Math.atan2(y, x);
		setlength(x, y);
	}
	public void mul(double a){
		x = Math.round(x*a);
		y = Math.round(y*a);
		setlength(x, y);
	}
	
	public void getReflex(Vector pp) {// pp là pháp tuyến
		Vector p = new Vector(pp.x, pp.y);
		double cos = (x*p.x + y*p.y)/(length*p.length);
		if(cos == 1) {
			this.mul(-1);
			return;
		}
		
		updateVector(length*cos*2);
		
		if(x*p.x + y*p.y>0)
		p.mul(-1);
		
		add(p);
	}
}
