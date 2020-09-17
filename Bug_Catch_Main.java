package bug_catch;

import java.awt.*;
import javax.swing.*;


public class Bug_Catch_Main extends JPanel{

	public static void main(String args[]) {	
		EventQueue.invokeLater(new Runnable(){
			public void run(){
				
				try{
					KillBug frame = new KillBug(3);
					//Bug_Catch frame = new Bug_Catch();
					frame.setCursor(Cursor.HAND_CURSOR);
					frame.setVisible(true);
				} catch(Exception e){
					e.printStackTrace();
				}
			}
		});
	}
}
