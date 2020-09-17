package bug_catch;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Monster_Main {

	public static void main(String args[]) {
		JButton home, next, finish;
		
		EventQueue.invokeLater(new Runnable(){
			public void run(){
				try{
					Monster_Go frame = new Monster_Go();
					frame.setVisible(true);
				} catch(Exception e){
					e.printStackTrace();
				}
			}
		});
	}
}
