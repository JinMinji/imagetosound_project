package bug_catch;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Bug_Catch extends JFrame {
	JPanel contentPane;
	JPanel menuPanel;
	JPanel centerPanel;
	JButton startBt;
	Thread[] ths;
	
	ImageIcon originIcon = new ImageIcon("C:\\Users\\admin\\eclipse-workspace\\HW\\src\\bug_catch\\mos.png");
	Image originImg = originIcon.getImage();
	Image changedImg = originImg.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
	ImageIcon mosquito = new ImageIcon(changedImg);

	Bug[] bugs = new Bug[] {
		new Bug(mosquito,0,10),
		new Bug(mosquito,0,10),
		new Bug(mosquito,0,10),
	};
	
	
	public Bug_Catch() {
		super("Bug Cathing Game");
		ths = new Thread[bugs.length];
		// car의 갯수 만큼 Thread를 만들어라.
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 10, 1024, 700);
		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		menuPanel = new JPanel();
		//1행 4열 5개로 나눈다
		startBt = new JButton(new ImageIcon("C:\\Users\\admin\\eclipse-workspace\\HW\\src\\car\\play.png"));
		
		menuPanel.add(startBt);
		contentPane.add("North", menuPanel);
		
		centerPanel = new JPanel();
		contentPane.add("Center", centerPanel);
		
		startBt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				for (int i=0 ; i < bugs.length; i++) {
					centerPanel.add(bugs[i]);
				}
				centerPanel.updateUI();
				game_play();
			}
		});	
	}

	public void game_play(){
		makeThread();
		for(int i=0; i<bugs.length; i++){
			ths[i].start();
		}
	}

	public void makeThread(){
		for(int i=0; i<bugs.length;i++){
			ths[i] = new Thread(bugs[i]);

		}
	}
}


