package bug_catch;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.Color;


public class Death_bug extends JButton implements Runnable{
	int x,y;
	int speed;
	public ImageIcon name;
	JFrame app;

   
	public Death_bug(JFrame _app, ImageIcon _name, int w, int h)
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
		// TODO x, y ���� �޾Ƽ� �ٲ������.
		// ���Ͱ� �޸��� �κ�
		for (int i=0 ; i < 10000 ; i++) {
			// ���⼭ �ݺ��� break ������ �ð��������� �ָ� �� ��
			speed = (int)(Math.random() * 50);
			y += 10;
			// ���� �����̰� �ϴ� �κ�
			this.setBounds(x,y,50,50);
			// ���� ���� ���� �ٸ� ������ ���͹��� ������.
			try {
				Thread.sleep((int)(Math.random()*300));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}// ���� ������ �� 
	}
		   

}

