package bug_catch;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class timer extends JLabel implements Runnable{ 
	long start_time;
	long rest_time;
	JFrame app;
	int x, y;
	
	public timer (JFrame _app, int w, int h) {
		app = _app;
		this.setText("제한시간 : " + String.valueOf(rest_time));
		x = w;
		y = h;
	}
	
	public void run() {
		rest_time = 60;
		System.out.println(rest_time);
		while(61 > rest_time) {
			rest_time -= 1;
			System.out.println(rest_time+ "  "+ System.currentTimeMillis()+ "   " +start_time);
			
			this.setText("제한시간 : " +String.valueOf(rest_time));
			//this.setBounds(x,y,50,50);
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (rest_time <= 0) {
				JOptionPane.showConfirmDialog(null, "시간초과", "Lose.....", JOptionPane.CLOSED_OPTION);
				break;
			}
			
		}		
	}
	
}