package Devolop;

import java.awt.Font;
import java.awt.Graphics;

import Primary.Control;

public class Tutorial {

	
	public static void draw(Graphics g) {
		System.out.println("++++");
		g.setFont(new Font("Times New Roman",Font.BOLD,20));
		
		g.drawString("có 5 nguyên tố trong game gồm: lửa, nước, đất , điện , gió", 50, 50);
		g.drawString("tháp nguyên tố mạnh hơn mới phá được địch có nguyên tố yếu hơn tương ứng", 50, 100);
		g.drawString("chỉ có duy nhất một nguyên tố mới đánh được nguyên tố tương ứng yếu hơn", 50, 150);
		g.drawString("nhấn giữ và thả vào trong miền trò chơi để thêm tháp", 50, 200);
		g.drawString("ô nguyên tố sẽ rỗng nếu không đủ tiền để mua thêm tháp", 50, 250);
		g.drawString("chọn vào tháp để nâng cấp tháp", 50, 300);
		g.drawString("có thể nâng các thuộc tính của tháp gồm: sức công phá, tầm bắn, tốc độ bắn", 50, 350);
		g.drawString("ngoài ra tháp có thể dung hợp nguyên tố để tạo lên tháp có nhiều nguyên tố hơn", 50, 400);
		g.drawString("việc dung hợp cần có 1 tháp để dung hợp và các tháp hiến tế", 50, 450);
		g.drawString("các tháp được chọn làm vật hiến tế sẽ biến mất", 50, 500);
		g.drawString("và tháp được chọn để dung hợp sẽ được thêm nguyên tố từ các tháp hiến tế", 50, 550);
		g.drawString("chúc bạn chơi game vui vẻ =))",200,650);
		g.drawString("để khám phá trò chơi nhanh hơn có thể dùng phím D để hack xu",50,600);
		
		Control.draw5Element(g);
	}
}
