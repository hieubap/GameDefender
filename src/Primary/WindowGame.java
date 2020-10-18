package Primary;

import java.awt.Color;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class WindowGame extends JFrame{
	public static Color[] colorElement = {Color.red,Color.blue,new Color(0x993300),Color.yellow,new Color(0x9400D3)};
	int a,b;
	float c;
	
	WindowGame(){
		add(new Control());
		
		setTitle("game phong thu");
		setSize(1000, 700);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		WindowGame m= new WindowGame();
		m.setVisible(true);
		
	}

}
