package Primary;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.Timer;

import Devolop.Setup;
import Devolop.Tutorial;
import Tower.Element;
import Tower.Tower;

@SuppressWarnings("serial")
public class Control extends JPanel implements ActionListener{
	private int init,// init chứa thuộc tính của tháp khi mua mới
			limittower,coin,mapgame,life,level,k,t,check,score,up;
	private ArrayList<Tower> tower;
	private ArrayList<Enemy> ennemy;
	private Enemy cons;
	private Map map; // bản đồ
//	private Menu menu;
	private Setup menu; // xử lý menu
	private Timer timer,time; // timer là vòng lặp game chính còn time tạo hiệu ứng di chuyển tháp mới khi dung hợp
	private Rectangle2D backmenu; // tạo nút trở về menu
	private boolean mn,mp,// chế độ menu
			tutorial = false, // chế độ hướng dẫn
			upgrade,// chế độ cập nhật
			fusion=false; // chế độ dung hợp

	public void drawScreen(Graphics g) { // vẽ nền
		Graphics2D g2d = (Graphics2D) g.create();

		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(10, 18, 300, 20);
		g.fillRect(400, 500, 20, 20);
		
		g2d.setColor(Color.pink);
		g2d.fill(backmenu);
		g2d.setColor(Color.cyan);
		g2d.fillRect(50, 490, life*30, 20);
		
		g.setColor(Color.black);
		g.drawString("coin : "+String.valueOf(coin), 10, 30);
		g.drawString("score : "+String.valueOf(score), 80, 30);
		g.drawString(String.valueOf(life)+"/30", 450, 505);
		g.drawString("LIFE", 10, 505);
		g.drawString("BACKMENU", 610, 30);
		
	}
	public static void draw5Element(Graphics g) { // vẽ ngôi sa
		g.setColor(WindowGame.colorElement[0]);
		g.fillOval(800, 100, 50, 50);
		
		g.setColor(WindowGame.colorElement[1]);
		g.fillOval(800-(int)(80*(1+Math.cos(72*Math.PI/180))), 100+(int)(80*Math.sin(72*Math.PI/180)), 50, 50);
		g.drawLine(800-(int)(80*(1+Math.cos(72*Math.PI/180)))+25, 100+(int)(80*Math.sin(72*Math.PI/180))+25,800+25,100+25);
		
		g.setColor(WindowGame.colorElement[2]);
		g.fillOval(800-(int)(160*(1+Math.cos(72*Math.PI/180))*Math.cos(72*Math.PI/180)), 100+(int)(160*(1+Math.cos(72*Math.PI/180))*Math.sin(72*Math.PI/180)), 50, 50);
		g.drawLine(25+800-(int)(160*(1+Math.cos(72*Math.PI/180))*Math.cos(72*Math.PI/180)),25+100+(int)(160*(1+Math.cos(72*Math.PI/180))*Math.sin(72*Math.PI/180)),
				800-(int)(80*(1+Math.cos(72*Math.PI/180)))+25, 100+(int)(80*Math.sin(72*Math.PI/180))+25);
		
		g.setColor(WindowGame.colorElement[3]);
		g.fillOval(800+(int)(160*(1+Math.cos(72*Math.PI/180))*Math.cos(72*Math.PI/180)), 100+(int)(160*(1+Math.cos(72*Math.PI/180))*Math.sin(72*Math.PI/180)), 50, 50);
		g.drawLine(800+(int)(160*(1+Math.cos(72*Math.PI/180))*Math.cos(72*Math.PI/180))+25, 100+(int)(160*(1+Math.cos(72*Math.PI/180))*Math.sin(72*Math.PI/180))+25,
				800-(int)(160*(1+Math.cos(72*Math.PI/180))*Math.cos(72*Math.PI/180))+25, 100+(int)(160*(1+Math.cos(72*Math.PI/180))*Math.sin(72*Math.PI/180))+25);
		
		g.setColor(WindowGame.colorElement[4]);
		g.fillOval(800+(int)(80*(1+Math.cos(72*Math.PI/180))), 100+(int)(80*Math.sin(72*Math.PI/180)), 50, 50);
		g.drawLine(800+(int)(80*(1+Math.cos(72*Math.PI/180)))+25, 100+(int)(80*Math.sin(72*Math.PI/180))+25,
				800+(int)(160*(1+Math.cos(72*Math.PI/180))*Math.cos(72*Math.PI/180))+25, 100+(int)(160*(1+Math.cos(72*Math.PI/180))*Math.sin(72*Math.PI/180))+25);
		
		g.setColor(WindowGame.colorElement[0]);
		g.drawLine(800+25, 100+25, 800+25+(int)(80*(1+Math.cos(72*Math.PI/180))), 100+(int)(80*Math.sin(72*Math.PI/180))+25);
		
		g.setColor(Color.gray);
		g.drawOval(800, 100, 50, 50);
		g.drawOval(800-(int)(80*(1+Math.cos(72*Math.PI/180))), 100+(int)(80*Math.sin(72*Math.PI/180)), 50, 50);
		g.drawOval(800+(int)(80*(1+Math.cos(72*Math.PI/180))), 100+(int)(80*Math.sin(72*Math.PI/180)), 50, 50);
		g.drawOval(800-(int)(160*(1+Math.cos(72*Math.PI/180))*Math.cos(72*Math.PI/180)), 100+(int)(160*(1+Math.cos(72*Math.PI/180))*Math.sin(72*Math.PI/180)), 50, 50);
		g.drawOval(800+(int)(160*(1+Math.cos(72*Math.PI/180))*Math.cos(72*Math.PI/180)), 100+(int)(160*(1+Math.cos(72*Math.PI/180))*Math.sin(72*Math.PI/180)), 50, 50);
		
	}
	public Control() {
		mn=true;
		mp=false;
		mapgame=2;
		score=0;
		t=1000;
		menu= new Setup(this);
		check=20;
		Element[] el = {Element.Fire};
		cons = new Enemy(-100,-100,el);
		cons.init();
		
		setFocusable(true);
		addMouseListener(new mouse());
		addKeyListener(new key());
	}
	public void initAttack(int h) {
//		System.out.println("size lv 2:  " +cons.getAttack(h).size());
		for(int i=0;i<cons.getAttack(h).size();i++) {
			ennemy.add(cons.getEnemy(h, i));
			
		}
	}
	public void start(int m) {
		tower = new ArrayList<Tower>();
		coin=50;
		limittower=10;
		life=30;
		upgrade=false;
		up=0;
		level=1;
		
		map= new Map(m);
		ennemy = new ArrayList<Enemy>();
		
		initAttack(level);
		k=ennemy.size();
		
		timer = new Timer(check,this);
		time = new Timer(4000,new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				k--;
				if(k==0) {
					time.stop();
				}
				ennemy.get(k).appear();
			}
		});
		
		time.start();
		timer.start();
		
		backmenu = new Rectangle2D.Float(600, 10, 100, 30);
	}
	public void actionPerformed(ActionEvent ae) {
		if(mn||mp) return;
		
		
		for(int j=0;j<ennemy.size();j++)
		if(!ennemy.isEmpty()&&ennemy.get(j).getDead()) {
			coin+=ennemy.get(j).getGold();
			score+=ennemy.get(j).getGold()*10;
			ennemy.remove(j);
			
		}
		
		if(ennemy.isEmpty()) {
			initAttack(level++);
			k=ennemy.size();
			time.restart();
		}
		
		// ennemy walk
		for(int i=0;i<ennemy.size();i++) {
			if(ennemy.get(i).go(map.take(ennemy.get(i).getk()), map.take(ennemy.get(i).getk()+1)))
				if(ennemy.get(i).getk()!=map.getWalk()) ennemy.get(i).setk();
				else {
					ennemy.get(i).resetk();
					life--;
				}
		}
		// tower attack ennemy
		for(int i=0;i<tower.size();i++)
		{
			tower.get(i).getWeapon().loadEnegy();
			for(int j=ennemy.size()-1;j>-1;j--)
			{
//				System.out.println("j=" +j + " size = " + ennemy.size());
				if(tower.get(i).onRange(ennemy.get(j).getX(), ennemy.get(j).getY())&&tower.get(i).canFightElement(ennemy.get(j).getElement()))
					{// error 4 out 4   1 out 1
					if(tower.get(i).getWeapon().fullEnegy())
						{
						tower.get(i).getWeapon().fire(ennemy.get(j).getX(), ennemy.get(j).getY());
						ennemy.get(j).decreaseLife(tower.get(i).getDamage());
						tower.get(i).shot = true;
						repaint();
						}
					break;
				}
				else {
					tower.get(i).shot = false;
				}
			}
		}
		if(menu.up) {
			tower.add(new Tower(towerUpgrade.getX(), towerUpgrade.getY(), menu.element));
			menu.up = false;
			upgrade = false;
			fusion = false;
			
		}
		
		repaint();	
	}
	public void paintComponent(Graphics g) {
		// xóa màn hình
		super.paintComponent(g);

		// kiểm tra chế độ để vẽ
		// menu
		if(mn) {
			menu.paint(g);
			return;
		}
		// hướng dẫn
		else if(tutorial) {
			menu.drawback(g);
			Tutorial.draw(g);
			return;
		}
		// chọn map
		else if(mp) {
			menu.paintmap(g);
			return;
		}

		// vẽ game chính
		map.paint(g,coin);
		drawScreen(g);

		// vẽ đối địch
		for(int i=0;i<ennemy.size();i++) {
			ennemy.get(i).paint(g);
		}

		// vẽ tháp
		for(int i=0;i<tower.size();i++) {
			tower.get(i).draw(g);
//			for(int j=0;j<ennemy.size();j++)
//				if(!ennemy.isEmpty()&&tower.get(i).onRange(ennemy.get(j).getX(), ennemy.get(j).getY()))
			// vẽ laze từ tháp nếu tháp bắn
			if(tower.get(i).shot)
			tower.get(i).getWeapon().paint(g);
			
		}

		// kiểm tra xem có ở chế độ nâng cấp không
		if(upgrade) {
			// trong chế độ nâng cấp chia làm 2 phần xử lý
			// kiểm tra có đang chế độ dung hợp không để vẽ
			if(fusion) {
				menu.drawFusion(g);
			}
			else
			// vẽ phần nâng cấp tầm bắn, sát thương và tốc độ
				menu.p_laze(g,tower.get(up));

			// trong chế độ nâng thì vẽ tần bắn của tháp
			tower.get(up).drawRange(g);
		}
		// nếu không phải nâng cấp thì vẽ hình ngũ hành cho đỡ trống trải =))
		else {
			draw5Element(g);
		}

		// vẽ phần hiệu ứng tháp khi dung hợp sẽ di chuyển
		if(menu.fusioning) {
			menu.paintUpTower(g);
		}
	}
	// sau khi nhấn nút fusion sẽ xóa hết tất cả các tháp đi thì tháp để để lưu lại tháp được chọn để nâng cấp
	public Tower towerUpgrade;
	class mouse extends MouseAdapter{
		public void mousePressed(MouseEvent e) {
			int x=e.getX();
			int y=e.getY();
			// xử lý chuột tại từng chế độ

			// chế độ hướng dẫn thì chỉ có quan tâm nút backmenu
			if(tutorial) {
				if(menu.removecontain(x, y)) {
					tutorial = false;
					mn = true;
					repaint();
				}
				return;
			}
			// nếu chế độ menu thì có 4 nút cần xử lý
			if(mn) {
				// bắt đầu chơi game
				if(menu.startcontain(x, y)) {
					start(mapgame);
					mn=false;
				}
				// chọn map
				else if(menu.mapcontain(x, y)) {
					mp=true;
					mn=false;
					repaint();
				}
				// hướng dẫn
				else if(menu.tutorialcontain(x, y)) {
					tutorial = true;
					mn = false;
					repaint();
				}
				// thoát
				else if(menu.exitcontain(x, y)) {
					System.exit(0);
				}
			}
			// nếu trong chế độ map thì lại có 2 nút cần xử lý
			else if(mp) {
				// chọn map 1
				if(menu.map1contain(x, y)) {
					mapgame=1;
					mn=true;
					mp=false;
					repaint();
				}
				// chọn map 2
				else if(menu.map2contain(x, y)) {
					mapgame=2;
					mn=true;
					mp=false;
					repaint();
				}
			}

			// tới đây là hết xử lý phần menu
			if(mp||mn||tutorial) return;

			// kiểm tra xem chuột có nằm trong miền chơi game
			if(x>=50&&y>=50&&map.checkarea((x-50)/31,(y-50)/31)
					&&map.getmap((y-50)/31,(x-50)/31)==2) {

				x=((x-50)/31)*31+65;
				y=((y-50)/31)*31+65;
				System.out.println("*********** 343 controler ****************");

				// kiểm tra tất cả các tháp hiện có trên vùng chơi game xem có tháp nào được chọn
				for(int i=0;i<tower.size();i++)
					if(tower.get(i).getX()==x&&tower.get(i).getY()==y) {

						// nếu tháp được chọn thì xem đang chế độ dung hợp không để xem có được chọn làm nguyên liệu
						if(upgrade && i!=up && fusion) {
							//xử lý tháp được chọn làm nguyên liệu dung hợp

							// thêm điều kiện số lượng tháp được chọn làm nguyên liệu
							// chưa sử dụng đến
							if( menu.sacrifice.size()>=tower.get(up).getLevelElement()+1)
								break;

							// add để xem có thể thêm được tháp vào dung hợp không
							boolean add = true;

							// xử lý tránh trường hợp chọn 2 tháp trùng thuộc tính
							for(Tower t1 : menu.sacrifice) {
								if(t1.color.getRGB() == tower.get(i).color.getRGB())
									{
									add = false;
									break;
									}
							}

							// nếu đủ điều kiện chọn làm nguyên liệu thì cho vào dánh sách sacritifice
							if(add)
								{
								menu.sacrifice.add(tower.get(i));
								if(menu.sacrifice.size()>= tower.get(up).getLevelElement()+1) {
									menu.canfusion = true;
								}
								}
							break;
						}
						// nếu ở chế độ nâng cấp hoặc dung hợp thì bỏ qua
						else if(upgrade && fusion) {
							break;
						}
						
						if(!menu.sacrifice.isEmpty())
							{
							menu.sacrifice.removeAll(menu.sacrifice);
							System.out.println(" -------- 388 --------- ");
							}
						up=i;
						upgrade=true;
						break;
					}
				return;
			}
			
			/// upgrade tower có 2 sự kiện là dung hợp và nâng cấp
			if(upgrade) 
			{
				// nếu không dung hợp thì sử lý nâng cấp tầm bắn, sát thương, tốc độ
				if(!fusion)
			{
					if(menu.up1contain(x, y)&&coin>=tower.get(up).getup1()&&tower.get(up).getDamage()<tower.get(up).getMaxDamage()) {
						coin-=tower.get(up).getup1();
						tower.get(up).upDamage_Coin(20,50);
					}
					else if(menu.up2contain(x, y)&&coin>=tower.get(up).getup2()&&tower.get(up).getRange()<tower.get(up).getMaxRange()) {
						coin-=tower.get(up).getup2();
						tower.get(up).upRange_Coin(20,10);
					}
					else if(menu.up3contain(x, y)&&coin>=tower.get(up).getup3()&&tower.get(up).getSpeed()>tower.get(up).getMaxSpeed()
							&&tower.get(up).getSpeed()>0) {
						coin-=tower.get(up).getup3();
						tower.get(up).upSpeed_Coin(1,10);
					}
					// bán tháp
					else if(menu.up4contain(x, y)) {
						coin+=tower.get(up).getSell();
						map.setmap((tower.get(up).getY()-50)/31, (tower.get(up).getX()-50)/31,1);
						tower.remove(up);
						upgrade=false;
					}
					// chuyển chế độ dung hợp
					else if(menu.fusionmodecontain(x, y)) {
						fusion = true;
						if (menu.sacrifice.isEmpty())
							menu.sacrifice.add(tower.get(up));
					}
					// nếu nhấn một vị trí bất kì thì tắt chế độ nâng cấp
					else {
						upgrade =false;
						fusion = false;
						menu.sacrifice.removeAll(tower);
						System.out.println(" ********** 434 controller************* ");
					}
			}
			// xử lý chế độ dung hợp
			else {
				// trở về nâng cấp
				if(menu.backcontain(x, y)) {
					fusion = false;
				}
				// loại bỏ tháp khỏi danh sách chọn làm nguyên liệu
				else if(menu.removecontain(x, y)) {
					menu.sacrifice.remove(menu.sacrifice.size()-1);
					if(menu.sacrifice.size()<tower.get(up).getLevelElement()+1) {
						menu.canfusion = false;
					}
				}
				// thực hiện dung hợp
				else if(menu.fusioncontain(x, y)&&menu.canfusion) {
					System.out.println(" ************** 452 controller ********* ");
					menu.startUp(tower.get(up).getX(), tower.get(up).getY());
					towerUpgrade = new Tower(tower.get(up).getX(), tower.get(up).getY(), tower.get(up).elementn);
					tower.removeAll(menu.sacrifice);
					menu.fusioning = true;
					upgrade = false;
				}
			}
		}
			///  add  tower
			//  set element for tower here
			if(tower.size()==limittower) {}
			else if(map.t1contain(x, y)&&coin>9) {
				init=1;
				
			}
			else if(map.t2contain(x, y)&&coin>10) {
				init=2;
				
			}
			else if(map.t3contain(x, y)&&coin>9) {
				init=3;
				
			}
			else if(map.t4contain(x, y)&&coin>10) {
				init=4;
				
			}
			else if(map.t5contain(x, y)&&coin>9) {
				init=5;
				
			}

			// xử lý quay lại menu
			if(backmenu.contains(x, y)) {
				timer.stop();
				mn=true;
				mp=false;
			}
			
			
			repaint();
			
		}
		public void mouseReleased(MouseEvent e) {
			if(mn||mp||tutorial) return;
			
			int x=e.getX();
			int y=e.getY();

			// chủ yếu xử lý khi nhả chuột để thêm tháp
			if(x>=50&&y>=50&&map.checkarea((x-50)/31,(y-50)/31)
					&&map.getmap((y-50)/31,(x-50)/31)==1) {
				x=((x-50)/31)*31+65;
				y=((y-50)/31)*31+65;
			
				switch(init) {
				case 5: {
					Element[] el = {Element.Wind};
					tower.add(new Tower(x,y,el));
					map.setmap((y-50)/31, (x-50)/31, 2);
					coin-=30;
					break;
				}	
				case 3: {
					Element[] el = {Element.Earth};
					tower.add(new Tower(x,y,el));
					map.setmap((y-50)/31, (x-50)/31, 2);
					coin-=10;
					break;
				}
				case 4: {
						Element[] el = {Element.Thunder}; 
						tower.add(new Tower(x,y,el));
						map.setmap((y-50)/31, (x-50)/31, 2);
						coin-=10;
						break;
					}
				case 2: {
						Element[] el = {Element.Water};
						tower.add(new Tower(x,y,el));
						map.setmap((y-50)/31, (x-50)/31, 2);
						coin-=5;
						break;
					}
				case 1: {
						Element[] el = {Element.Fire};
						tower.add(new Tower(x,y,el));
						map.setmap((y-50)/31, (x-50)/31, 2);
						coin-=20;
						break;
					}
				}
				if(init!=0) {
					upgrade =false;
					fusion = false;
					menu.sacrifice.removeAll(menu.sacrifice);
				}
			}
			init=0;
			repaint();

			System.out.println("***line 555 controler*** tower length = " + tower.size());
	}
	}
	class key extends KeyAdapter{
		public void keyPressed(KeyEvent p) {
			System.out.println("init key");
			if(mn||mp) return;
			int c= p.getKeyCode();
			
			if(c=='Q') System.exit(0);
			if(c=='R') timer.restart();
			if(c=='P') timer.stop();
			
//			if(c=='Z') {
//				ennemy.add(new Enemy(75,97,1));
//				ennemy.get(ennemy.size()-1).appear();
//			}
//			if(c=='X') {
//				ennemy.add(new Enemy(75,97,2));
//				ennemy.get(ennemy.size()-1).appear();
//			}
//			if(c=='C') {
//				ennemy.add(new Enemy(75,97,3));
//				ennemy.get(ennemy.size()-1).appear();
//			}
//			if(c=='V') {
//				ennemy.add(new Enemy(75,97,4));
//				ennemy.get(ennemy.size()-1).appear();
//			}
//			if(c=='B') {
//				ennemy.add(new Enemy(75,97,5));
//				ennemy.get(ennemy.size()-1).appear();
//			}
//			if(c=='N') {
//				ennemy.add(new Enemy(75,97,6));
//				ennemy.get(ennemy.size()-1).appear();
//			}
			
			if(c=='D') coin+=5000;
			
			
			if(c=='A') limittower++;
			if(c==' ') {
				upgrade=false;
				tower.clear();
			}
			
			repaint();
		}
	}
}
