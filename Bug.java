package bug_catch;

import javax.swing.*;
import java.awt.*;


public class Bug extends JButton implements Runnable{
	private ImageIcon name;
	JPanel pan = new JPanel();
	private int x, y; // 위치 값

	public Bug(ImageIcon name, int x, int y) {
		this.name = name;
		this.setIcon(name);
		this.setBackground(Color.pink);
		this.setOpaque(false);
		//this.setBounds(x, y, 130, 200);
	}	
	
	public void run() {
		// TODO x, y 값을 받아서 바꿔줘야함.
		// Car가 달리는 부분
		while (true) {
			int move = (int)(Math.random()%4);
			switch (move) {
			case 0 : x += 50;
			case 1 : x -= 50;
			case 2 : y += 50;
			case 3 : y -= 50;
			}

			//this.setBounds(x,y,130,200);
			
			// Car마다 서로 다른 임의의 인터벌을 가진다.
			try {
				Thread.sleep((int)(Math.random()));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}// Car 경기 종료
	}
}
