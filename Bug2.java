package bug_catch;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.Color;


public class Bug2 extends JButton implements Runnable{
	int x, y;
	int speed;
	public ImageIcon name;
	JFrame app;

   
	public Bug2(JFrame _app, ImageIcon _name, int w, int h)
	{
		app = _app;
		this.name = _name;
		x = w;
		y = h;
		this.setIcon(name);
		this.setBackground(Color.pink);
		this.setOpaque(false);
		this.setBounds(x, y, 50, 50);
	}
   
	public void run() {
		// TODO x, y 값을 받아서 바꿔줘야함
		// 움직이는 부분
		for (int i=0 ; i < 10000 ; i++) {
			// 여기서 반복문 break 조건을 시간제한으로 주면 될 듯
			speed = (int)(Math.random() * 50);
			int move = speed % 4;
			if (move == 0 ) {
				x += speed;
			} else if( move == 1) { 
				if(x > speed){x -= speed;} else {x += speed;}
			} else if (move == 2) {
				if(y < 1000){y += speed;} else {y -= speed;}
			} else if (move == 3) {
				if(y > speed){y -= speed;} else {y += speed;}			
			} else {
				x += speed;
				y += speed;
			}
			// 벌레 움직이게 하는 부분
			this.setBounds(x,y,50,50);
			// 벌레마다 서로 다른 임의의 인터벌을 가지게 한다.
			try {
				Thread.sleep((int)(Math.random()*400));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}// 잡지 못했을 때
	}
}