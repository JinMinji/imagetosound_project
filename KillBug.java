package bug_catch;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.*;
import java.awt.Color;



public class KillBug extends JFrame{
	
	ImageIcon[] originIcon = new ImageIcon[] {		
			new ImageIcon("C:\\Users\\admin\\eclipse-workspace\\HW\\src\\bug_catch\\mos.png"),
			new ImageIcon("C:\\Users\\admin\\eclipse-workspace\\HW\\src\\bug_catch\\fly.png"),
			new ImageIcon("C:\\Users\\admin\\eclipse-workspace\\HW\\src\\bug_catch\\ant.png"),
			// death Icon
			new ImageIcon("C:\\Users\\admin\\eclipse-workspace\\HW\\src\\bug_catch\\death_mos.png"),
			new ImageIcon("C:\\Users\\admin\\eclipse-workspace\\HW\\src\\bug_catch\\death_fly.png"),
			new ImageIcon("C:\\Users\\admin\\eclipse-workspace\\HW\\src\\bug_catch\\death_ant.png"),
	};
	
	Image[] originImg = {
			originIcon[0].getImage(),
			originIcon[1].getImage(),
			originIcon[2].getImage(),
			// death Icon
			originIcon[3].getImage(),
			originIcon[4].getImage(),
			originIcon[5].getImage(),
	};
	
	Image[] changedImg = {
			originImg[0].getScaledInstance(50, 50, Image.SCALE_SMOOTH),
			originImg[1].getScaledInstance(50, 50, Image.SCALE_SMOOTH),
			originImg[2].getScaledInstance(50, 50, Image.SCALE_SMOOTH),
			// death Icon
			originImg[3].getScaledInstance(50, 50, Image.SCALE_SMOOTH),
			originImg[4].getScaledInstance(50, 50, Image.SCALE_SMOOTH),
			originImg[5].getScaledInstance(50, 50, Image.SCALE_SMOOTH),
	};

	ImageIcon[] bugimg = new ImageIcon[] {
			new ImageIcon(changedImg[0]),
			new ImageIcon(changedImg[1]),
			new ImageIcon(changedImg[2]),
			// death Icon
			new ImageIcon(changedImg[3]),
			new ImageIcon(changedImg[4]),
			new ImageIcon(changedImg[5])
	};
	
	Bug2[] bugs = new Bug2[]{
		new Bug2(this, bugimg[0], 0, 100),
		new Bug2(this, bugimg[0], 300, 100),
		new Bug2(this, bugimg[0], 600, 100),
		
		new Bug2(this, bugimg[1], 0, 300),
		new Bug2(this, bugimg[1], 300, 300),
		new Bug2(this, bugimg[1], 600, 300),
		
		new Bug2(this, bugimg[2], 0, 600),
		new Bug2(this, bugimg[2], 300, 600),
		new Bug2(this, bugimg[2], 600, 600),

	};
	
	Death_bug[] death_bugs = new Death_bug[] {
			new Death_bug(this, bugimg[3], 1000, 1000),
			new Death_bug(this, bugimg[3], 1000, 1000),
			new Death_bug(this, bugimg[3], 1000, 1000),
			
			new Death_bug(this, bugimg[4], 1000, 1000),
			new Death_bug(this, bugimg[4], 1000, 1000),
			new Death_bug(this, bugimg[4], 1000, 1000),
			
			new Death_bug(this, bugimg[5], 1000, 1000),
			new Death_bug(this, bugimg[5], 1000, 1000),
			new Death_bug(this, bugimg[5], 1000, 1000),
			
	};
	
	
	timer time_label = new timer(this, 0, 0);


	JScrollPane scrollPane;
	ImageIcon back;
	JButton startBt, stopBt, pauseBt, suspendBt, resumeBt;
	
	JPanel contentPane;
	//ImagePanel contentPane;
	JPanel menuPanel;
	JPanel centerPanel;
   
	BufferedImage img = null;
	// 일단 바닥쪽에
	int img_x = 800;
	int img_y = 800;
	Thread[] ths;
	int score;
	int level;


	public KillBug(int _level)
	{
		super("Bug Catching Game");	
		
		// 타이머 스레드도 추가
		//ths = new Thread[bugs.length*2];
		ths = new Thread[bugs.length*2 + 1];
		
		level = _level;

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(100, 10, 1300, 800);
		
		//back = new ImageIcon("C:\\Users\\admin\\eclipse-workspace\\HW\\src\\bug_catch\\grass.png");
		//contentPane = new ImagePanel("C:\\Users\\admin\\eclipse-workspace\\HW\\src\\bug_catch\\house.png");

		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		centerPanel = new JPanel() {
			public void paintComponent(Graphics g){
                back=new ImageIcon("C:\\Users\\admin\\eclipse-workspace\\HW\\src\\bug_catch\\house.png");

                g.drawImage(back.getImage(), 0, 0, 1000,800,null);
                setOpaque(false);
                super.paintComponent(g);
			}
		};
		
		scrollPane = new JScrollPane(centerPanel);
		menuPanel = new JPanel();
		menuPanel.setLayout(new GridLayout(1,4,5,5));
		//1행 4열 5개로 나눈다.
		startBt = new JButton(new ImageIcon("C:\\Users\\admin\\eclipse-workspace\\HW\\src\\car\\play.png"));
		stopBt = new JButton(new ImageIcon("C:\\Users\\admin\\eclipse-workspace\\HW\\src\\car\\stop.png"));
		suspendBt = new JButton(new ImageIcon("C:\\Users\\admin\\eclipse-workspace\\HW\\src\\car\\suspend.png"));
		resumeBt = new JButton(new ImageIcon("C:\\Users\\admin\\eclipse-workspace\\HW\\src\\car\\resume.png"));
      
		menuPanel.add(startBt);
		menuPanel.add(stopBt);
		menuPanel.add(suspendBt);
		menuPanel.add(resumeBt);
				
		contentPane.add("North", menuPanel);
		
		Toolkit tk = Toolkit.getDefaultToolkit();
		Image img = tk.getImage("C:\\Users\\admin\\eclipse-workspace\\HW\\src\\bug_catch\\spiderweb1.png");
		Cursor mycursor = tk.createCustomCursor(img, new Point(10,10), "snow");
		centerPanel.setCursor(mycursor);
		
		//centerPanel.setBackground(Color.pink);
		//centerPanel.setSize(1000,800);
		//centerPanel.setOpaque(false);

		contentPane.add("Center", centerPanel);
		
		time_label.setFont(new Font("HY헤드라인M", Font.BOLD+Font.ITALIC,30));
		
		centerPanel.add(time_label);
		time_label.setBackground(Color.pink);
		time_label.setOpaque(true);
		
		startBt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int level_control = (bugs.length/3)*level;
				for (int i=0 ; i < level_control; i++) {
					bugs[i].setVisible(true);
					centerPanel.add(bugs[i]);
					centerPanel.add(death_bugs[i]);
				}
				centerPanel.updateUI();
				time_label.start_time = System.currentTimeMillis()/1000;
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
				for(Thread t:ths){
					t.resume();
				}
			}
		});		
	}

	public void game_play(){
		makeThread();
		for(int i=0; i<bugs.length*2+1; i++){
			ths[i].start();
		}
	}

	public void makeThread(){
		for(int i=0; i<bugs.length;i++){
			ths[i] = new Thread(bugs[i]);
			score = 0;
			bugs[i].addActionListener(attack);
		}
		for(int i=0; i<bugs.length;i++){
			ths[bugs.length+i] = new Thread(death_bugs[i]);
		}
		ths[bugs.length*2] = new Thread(time_label);
	}
	
	ActionListener attack = new ActionListener() { 
		public void actionPerformed(ActionEvent e){
			int level_control = (bugs.length/3)*level;
			for (int i=0 ; i<bugs.length;i++) {
				if( e.getSource() == bugs[i]) {
					Thread t = ths[i];
					t.stop();
					death_bugs[i].x = bugs[i].x; 
					death_bugs[i].y = bugs[i].y;
					score += 1;
					bugs[i].setVisible(false);
					if (score == level_control*level) {
						int answer=JOptionPane.showConfirmDialog(null, "다음 단계로 넘어가시겠습니까?", "Clear!! Congraturation!!", JOptionPane.YES_NO_OPTION);
						if (answer==0){
							level ++;
							score = 0;
							if (level == 3) {
								//ImageIcon success = new ImageIcon("C:\\Users\\admin\\eclipse-workspace\\HW\\src\\bug_catch\\grass.png");  
								//JOptionPane.ICON_PROPERTY success = new JOptionPane.ICON_PROPERTY();
										
								JOptionPane.showConfirmDialog(null, "모든 단계를 성공했습니다!", "Clear!! Congraturation!!", JOptionPane.CLOSED_OPTION);
								contentPane.setVisible(false);
								level = 1;
								
							} 
						break;
						}
					}
				}			
			}
		}
	};
	
	class ImagePanel extends JPanel {
		private Image img;

		public ImagePanel(String img) {
			this(new ImageIcon(img).getImage());
		  }
		
		  public ImagePanel(Image img) {
		    this.img = img;
		    Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
		    setPreferredSize(size);
		    setMinimumSize(size);
		    setMaximumSize(size);
		    setSize(size);
		    setLayout(null);
		  }
		
		  public void paintComponent(Graphics g) {
		    g.drawImage(img, 0, 0, null);
		  }
	}

   
}

