package bug_catch;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Monster_Go extends JFrame {
	JPanel contentPane;
	JPanel menuPanel;
	JPanel centerPanel;
	JPanel character;
	JButton startBt, stopBt, pauseBt, suspendBt, resumeBt;
	Thread[] ths;
	int[] death_point; 
	
	ImageIcon back;
	BufferedImage img = null;
	int img_x = 800;
	int img_y = 800;
	
	ImageIcon[] originIcon = new ImageIcon[] {
			new ImageIcon("C:\\Users\\admin\\eclipse-workspace\\HW\\src\\bug_catch\\mos.png"),
			new ImageIcon("C:\\Users\\admin\\eclipse-workspace\\HW\\src\\bug_catch\\mos.png"),
			new ImageIcon("C:\\Users\\admin\\eclipse-workspace\\HW\\src\\bug_catch\\fly.png"),
			new ImageIcon("C:\\Users\\admin\\eclipse-workspace\\HW\\src\\bug_catch\\fly.png"),
			new ImageIcon("C:\\Users\\admin\\eclipse-workspace\\HW\\src\\bug_catch\\mos.png")
	};

	Image[] originImg = {
			originIcon[0].getImage(),
			originIcon[1].getImage(),
			originIcon[2].getImage(),
			originIcon[3].getImage(),
			originIcon[4].getImage(),
	};
		
	Image[] changedImg = {
			originImg[0].getScaledInstance(50, 50, Image.SCALE_SMOOTH),
			originImg[1].getScaledInstance(50, 50, Image.SCALE_SMOOTH),
			originImg[2].getScaledInstance(50, 50, Image.SCALE_SMOOTH),
			originImg[3].getScaledInstance(50, 50, Image.SCALE_SMOOTH),
			originImg[4].getScaledInstance(50, 50, Image.SCALE_SMOOTH),
	};

	
	ImageIcon[] monster = new ImageIcon[] {
			new ImageIcon(changedImg[0]),
			new ImageIcon(changedImg[1]),
			new ImageIcon(changedImg[2]),
			new ImageIcon(changedImg[3]),
			new ImageIcon(changedImg[4]),
	};
	
	
	Monster[] monsters = new Monster[] {
		new Monster(monster[0],0,10),
		new Monster(monster[1],0,10),
		new Monster(monster[2],0,10),
		new Monster(monster[3],0,10),
		new Monster(monster[4],0,10),
	};
	
	
	public Monster_Go() {
		super("Runnable Test");
		ths = new Thread[monsters.length];
		death_point = new int[monsters.length];
		// car의 갯수 만큼 Thread를 만들어라.
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 10, 1300, 800);
		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout(0, 0));
		//contentPane.setBackground(new Color(255, 0, 0, 0));
		setContentPane(contentPane);
		
		menuPanel = new JPanel();
		menuPanel.setLayout(new GridLayout(1,4,5,5));
		//1행 4열 5개로 나눈다
		startBt = new JButton(new ImageIcon("C:\\Users\\admin\\eclipse-workspace\\HW\\src\\car\\play.png"));
		stopBt = new JButton(new ImageIcon("C:\\Users\\admin\\eclipse-workspace\\HW\\src\\car\\stop.png"));
		suspendBt = new JButton(new ImageIcon("C:\\Users\\admin\\eclipse-workspace\\HW\\src\\car\\suspend.png"));
		resumeBt = new JButton(new ImageIcon("C:\\Users\\admin\\eclipse-workspace\\HW\\src\\car\\resume.png"));
		
		menuPanel.add(startBt);
		menuPanel.add(stopBt);
		menuPanel.add(suspendBt);
		menuPanel.add(resumeBt);
		//menuPanel.setBackground(new Color(255, 0, 0, 0));
		contentPane.add("North", menuPanel);
		
		centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout(monsters.length, 1,5,5));
		//centerPanel.setBackground(new Color(255, 0, 0, 0));
		contentPane.add("Center", centerPanel);
		Toolkit tk = Toolkit.getDefaultToolkit();
		Image img = tk.getImage("C:\\Users\\admin\\eclipse-workspace\\HW\\src\\bug_catch\\snowflake.png");
		Cursor mycursor = tk.createCustomCursor(img, new Point(10,10), "snow");
		centerPanel.setCursor(mycursor);
		
		character = new JPanel();
		ImageIcon nunsong = new ImageIcon("C:\\Users\\admin\\eclipse-workspace\\HW\\src\\bug_catch\\it_nun.png");
		
		//ImageIcon it_nunsong = new ImageIcon("C:\\Users\\admin\\eclipse-workspace\\HW\\src\\bug_catch\\SM22.png");
		//JLabel imagelabel = new JLabel(grass_nunsong, JLabel.CENTER);
		
		JLabel imagelabel = new JLabel(nunsong, JLabel.CENTER);
		character.setLayout(new GridLayout(3,1));
		JPanel empty = new JPanel();
		//empty.setBackground(Color.pink);
		empty.setOpaque(false);
		imagelabel.setOpaque(false);
		
		character.add(empty);
		character.add(imagelabel);
		character.setBackground(Color.pink);
		character.setOpaque(false);
		
		//character.setBackground(new Color(255, 0, 0, 0));
		contentPane.add("East", character);
		
		startBt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				for (int i=0 ; i < monsters.length; i++) {
					centerPanel.add(monsters[i].lane);
				}
				centerPanel.updateUI();
				Monster.score1 = 0;
				game_play();
			}
		});
		
		stopBt.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				for(Thread t:ths){
					t.stop();

				}
			}
		});
		
		suspendBt.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				for(Thread t:ths){
					t.suspend();
				}
			}
		});
		
		resumeBt.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				for(int i=0; i<monsters.length; i++){
					ths[i].resume();
				}
			}
		});
	}

	public void game_play(){
		makeThread();
		for(int i=0; i<monsters.length; i++){
			ths[i].start();
		}
	}

	public void makeThread(){
		for(int i=0; i<monsters.length;i++){
			ths[i] = new Thread(monsters[i]);
			death_point[i] = 0;
			monsters[i].addActionListener(attack);
			
			/*
			monsters[i].addMouseListener(new MouseListener() { 
				public void mousePressed(MouseEvent me){
					if(death_point[i] == 5){
						ths[i].stop();
						}
					else { death_point[i] += 1;}
				}
			});
			*/
		}
	}
	
	ActionListener attack = new ActionListener() { 
		public void actionPerformed(ActionEvent e){
			for (int i=0 ; i<monsters.length;i++) {
				if( e.getSource() == monsters[i]) {
					if(death_point[i] == 5){
						Thread t = ths[i];
						t.stop();
					}
					else { death_point[i] += 1;
					System.out.println("Monster" +i+ " attack " + death_point[i] + " times" );
					}
				}
			}
		}
	};
	
	
	public void popupButton() {
		JPanel popclear = new JPanel();
		JButton re_bt = new JButton();
		re_bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int i=0; i<bugs.length; i++){
					bugs[i].setVisible(true);
					ths[i].resume();
				}
			}
		});
		
		JButton next = new JButton();
		next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (level < 3) {level += 1;}
				else {
					// 마지막창. 다음으로 넘겨야 함.
					}
			}
		});
		
		
		JLabel clear_text = new JLabel("Clear! Restart? or Next!");
		popclear.setLayout(new BorderLayout());
		popclear.add("North", clear_text);
		popclear.add("West", re_bt);
		popclear.add("East", next);
		
	}
	
//JOptionPane.showMessageDialog(null, "눈송이 구하기 성공!!!");

	
	public void paint (Graphics g1){

		   ImageIcon originIcon = new ImageIcon("C:\\Users\\admin\\eclipse-workspace\\HW\\src\\bug_catch\\background.png");
		   Image originImg = originIcon.getImage();
		   Image changedImg = originImg.getScaledInstance(5000, 3000, Image.SCALE_SMOOTH);
		   ImageIcon back = new ImageIcon(changedImg);
	
		   g1.drawImage(back.getImage(), 0, 0, 2000,1000,null);
	}

}
