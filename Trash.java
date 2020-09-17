import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.Timer;
import java.util.TimerTask;

import static com.sun.javafx.css.SizeUnits.PC;

public class layout extends JPanel{
    static CardLayout card = new CardLayout();

    //�ʱ�ȭ��
    //JPanel start = new JPanel();
    //����ȭ��
    KillBug main = new KillBug(1);
    //���� ����ȭ��
    //JPanel success = new JPanel();

    //this Panel ����
    JPanel base = this;
    ImageIcon icon;
    ImageIcon icon2;
    ImageIcon icon3;
    ImageIcon success_icon;
    ImageIcon fail_icon;
    ImageIcon explain_icon;


    //���� ����ȭ��
    static JPanel fail;
    static JPanel success;

    //����ȭ��
    public layout() {
        this.setBackground(Color.white);

        icon = new ImageIcon("C:\\Users\\SM-PC\\Desktop\\maintitle.jpg");
        //icon2 = new ImageIcon("image/background2.png");


        //��� Panel ������ �������������� ����
        JPanel start = new JPanel(){
            public void paintComponent(Graphics g) {
                // Approach 1: Dispaly image at at full size
                g.drawImage(icon.getImage(), 150, 80, 900,700,null);

                setOpaque(false); //�׸��� ǥ���ϰ� ����,�����ϰ� ����
                super.paintComponent(g);

            }
        };


        //����ȭ��
        success_icon = new ImageIcon("C:\\Users\\SM-PC\\Desktop\\grass.jpg");

        //��� Panel ������ �������������� ����
        JPanel success = new JPanel(){
            public void paintComponent(Graphics g) {
                // Approach 1: Dispaly image at at full size
                g.drawImage(success_icon.getImage(), 0, 0, null);

                setOpaque(false); //�׸��� ǥ���ϰ� ����,�����ϰ� ����
                super.paintComponent(g);

            }
        };

        //����ȭ��
        fail_icon = new ImageIcon("C:\\Users\\SM-PC\\Desktop\\grass.jpg");

        //��� Panel ������ �������������� ����
        JPanel fail = new JPanel(){
            public void paintComponent(Graphics g) {
                // Approach 1: Dispaly image at at full size
                g.drawImage(fail_icon.getImage(), 0, 0, null);


                setOpaque(false); //�׸��� ǥ���ϰ� ����,�����ϰ� ����
                super.paintComponent(g);
            }


        };

        //���̾ƿ��� CardLayout


        //���̾ƿ� ����
        this.setLayout(card);

        start.setBackground(Color.green);
        //main.setBackground(Color.black);
        success.setBackground(Color.red);


        //MouseHandler handler = new MouseHandler();
        icon2 = new ImageIcon("C:\\Users\\SM-PC\\Desktop\\startButtonBasic.png");
        //��ư�� ����ϴ�.
        JButton start_button = new JButton("Start",icon2);
        //��ư�� �̺�Ʈ �߰�
        start_button.addActionListener(new MyEventListener());

        icon3 = new ImageIcon("C:\\Users\\SM-PC\\Desktop\\quitButtonBasic.png");
        //��ư�� ����ϴ�.
        JButton quit_button = new JButton("Quit",icon3);
        //��ư�� �̺�Ʈ �߰�
        quit_button.addActionListener(new MyEventListener());

        //�׽�Ʈ�� ���� ��ư
        JButton success_button = new JButton("Success");
        success_button.addActionListener(new MyEventListener());

        //�׽�Ʈ�� ���� ��ư
        JButton fail_button = new JButton("Fail");
        fail_button.addActionListener(new MyEventListener());


        //���� ��ư
        JButton guide_button = new JButton("����");
        guide_button.addActionListener(new MyEventListener());


        //success ȭ��� failȭ�鿡 ���ư��� ��ư�� �߰��մϴ�.
        JButton s_back_button = new JButton("���ư���");
        s_back_button.addActionListener(new MyEventListener());

        JButton f_back_button = new JButton("���ư���");
        f_back_button.addActionListener(new MyEventListener());

        success.add(s_back_button);
        fail.add(f_back_button);

        JPanel menu = new JPanel();
        menu.setBackground(Color.lightGray);

        BorderLayout border = new BorderLayout();
        menu.setLayout(border);

        JLabel blank_L1 = new JLabel("      ");
        JLabel blank_L2 = new JLabel("                  ");
        JLabel blank_L3 = new JLabel("                  ");
        JLabel blank_L4 = new JLabel("       ");

        /*

        menu.add(success_button);
        JLabel blank_L7 = new JLabel(" ");
        JLabel blank_L8 = new JLabel(" ");
        menu.add(fail_button);

         */

        GridLayout grid = new GridLayout(2,1);
        JPanel center = new JPanel();
        center.setLayout(grid);




        center.add(start_button);
        start_button.setBackground(Color.white);

        center.add(quit_button);
        quit_button.setBackground(Color.white);

        //center.add(guide_button);
        //guide_button.setBackground(Color.white);


        menu.add("East",blank_L1);
        menu.add("South",blank_L2);
        menu.add("North",blank_L3);
        menu.add("West",blank_L4);
        menu.add("Center",center);



        start.setLayout(null);
        start.add(menu);

        menu.setBounds(500, 500, 450, 300);
        //menu.setLocation(500,200);
        //menu.setSize(20,10);

        base.add("Start", start);
        base.add("Success", success);
        base.add("Main", main.contentPane);
        base.add("Fail", fail);


        card.show(this, "Start");

    }

    /*
    //�׷���(�����̰� �� ���� ��)
    public void paint(Graphics g)
    {
        Image nunsong = Toolkit.getDefaultToolkit("C:\\Users\\SM-PC\\Documents\\�б�\\2019-1�б�\\��ü���α׷���\\Team Project-��������\\background.jpg");
    }
*/



    class MyEventListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("event ����");
            // ����ڰ� Load �޴��������� �����ϴ� ��� ó���� �۾� ����

            if (e.getActionCommand() == "Start")
            {

                card.show(base, "Success");
                card.show(base, "Main");
                //Bug_Catch_Main.count = 0;
                //Bug_Catch_Main.timeTh= new timerThread(timerThread.timerLabel);
                //Bug_Catch_Main.timeTh.start();
            }

            else if(e.getActionCommand() == "Success")
            {
                card.show(base, "Success");
            }

            else if(e.getActionCommand() == "Fail")
            {
                card.show(base, "Fail");
            }

            else if(e.getActionCommand() == "���ư���")
            {
                card.show(base, "Start");
            }

            else if(e.getActionCommand() == "����")
            {
                JFrame help_f = new JFrame();
                help_f.setTitle("����");
                // ����, ���⼭ setDefaultCloseOperation() ���Ǹ� ���� ���ƾ� �Ѵ�
                // �����ϰ� �Ǹ� �� â�� ������ ��� â�� ���α׷��� ���ÿ� ������




                explain_icon = new ImageIcon("image/explain2.png");
                //JLabel NewLabel = new JLabel("*IT Cafe ���ӹ��*");
                //NewLabel.setBackground(Color.white);
                JPanel NewWindowContainer = new JPanel() {
                    public void paintComponent(Graphics g) {
                        // Approach 1: Dispaly image at at full size
                        g.drawImage(explain_icon.getImage(), 0, 0, null);


                        setOpaque(false); //�׸��� ǥ���ϰ� ����,�����ϰ� ����
                        super.paintComponent(g);

                    }
                };

                NewWindowContainer.setBackground(Color.white);
                help_f.setContentPane(NewWindowContainer);


                //ta.append(text + newline);
                //ta.setCaretPosition(ta.getDocument().getLength());

                //NewWindowContainer.add(ta);

                help_f.setSize(1300, 700);
                help_f.setBackground(Color.white);
                help_f.setVisible(true);
            }
        }

    }
    class KillBug extends JFrame{

        ImageIcon[] originIcon = new ImageIcon[] {
                new ImageIcon("C:\\Users\\SM-PC\\Desktop\\mos.png"),
                new ImageIcon("C:\\Users\\SM-PC\\Desktop\\fly.png"),
                new ImageIcon("C:\\Users\\SM-PC\\Desktop\\ant.png"),
                // death Icon
                new ImageIcon("C:\\Users\\SM-PC\\Desktop\\death_mos.png"),
                new ImageIcon("C:\\Users\\SM-PC\\Desktop\\death_fly.png"),
                new ImageIcon("C:\\Users\\SM-PC\\Desktop\\death_ant.png"),
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
        // �ϴ� �ٴ��ʿ�
        int img_x = 800;
        int img_y = 800;
        Thread[] ths;
        int score;
        int level;


        public KillBug(int _level)
        {
            //super("Bug Catching Game");

            // Ÿ�̸� �����嵵 �߰�
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
                    back=new ImageIcon("C:\\Users\\SM-PC\\Desktop\\house.png");

                    g.drawImage(back.getImage(), 0, 0, 1000,800,null);
                    setOpaque(false);
                    super.paintComponent(g);
                }
            };

            scrollPane = new JScrollPane(centerPanel);
            menuPanel = new JPanel();
            menuPanel.setLayout(new GridLayout(1,4,5,5));
            //1�� 4�� 5���� ������
            startBt = new JButton(new ImageIcon("C:\\Users\\SM-PC\\Desktop\\play.png"));
            stopBt = new JButton(new ImageIcon("C:\\Users\\SM-PC\\Desktop\\stop.png"));
            suspendBt = new JButton(new ImageIcon("C:\\Users\\SM-PC\\Desktop\\suspend.png"));
            resumeBt = new JButton(new ImageIcon("C:\\Users\\SM-PC\\Desktop\\resume.png"));

            menuPanel.add(startBt);
            menuPanel.add(stopBt);
            menuPanel.add(suspendBt);
            menuPanel.add(resumeBt);

            contentPane.add("North", menuPanel);

            Toolkit tk = Toolkit.getDefaultToolkit();
            Image img = tk.getImage("C:\\Users\\SM-PC\\Desktop\\spiderweb1.png");
            Cursor mycursor = tk.createCustomCursor(img, new Point(10,10), "snow");
            centerPanel.setCursor(mycursor);

            //centerPanel.setBackground(Color.pink);
            //centerPanel.setSize(1000,800);
            //centerPanel.setOpaque(false);

            contentPane.add("Center", centerPanel);

            time_label.setFont(new Font("HY������M", Font.BOLD+Font.ITALIC,30));

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
                            for(Thread ts:ths){
                                ts.stop();
                            }
                            int answer=JOptionPane.showConfirmDialog(null, "���� �ܰ�� �Ѿ� ���ðڽ��ϱ�?", "Clear!! Congraturation!!", JOptionPane.YES_NO_OPTION);
                            if (answer==0){
                                level ++;
                                score = 0;
                                if (level == 4) {
                                    //ImageIcon success = new ImageIcon("C:\\Users\\admin\\eclipse-workspace\\HW\\src\\bug_catch\\grass.png");
                                    //JOptionPane.ICON_PROPERTY success = new JOptionPane.ICON_PROPERTY();

                                    JOptionPane.showConfirmDialog(null, "��� �ܰ踦 �����߽��ϴ�!", "Clear!! Congraturation!!", JOptionPane.CLOSED_OPTION);
                                    contentPane.setVisible(false);
                                    card.show(base, "Success");
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


    class timer extends JLabel implements Runnable{
        long start_time;
        long rest_time;
        JFrame app;
        int x, y;

        public timer (JFrame _app, int w, int h) {
            app = _app;
            this.setText("���ѽð� : " + String.valueOf(rest_time));
            x = w;
            y = h;
        }

        public void run() {
            rest_time = 60;
            System.out.println(rest_time);
            while(61 > rest_time) {
                rest_time -= 1;
                System.out.println(rest_time+ "  "+ System.currentTimeMillis()+ "   " +start_time);

                this.setText("���� �ð� : " +String.valueOf(rest_time));
                //this.setBounds(x,y,50,50);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                if (rest_time <= 0) {
                    JFXPanel panel2=new JFXPanel();

                    JFXPanel panel2=new JFXPanel();
                    Media m=new Media("C:\\Users\\SM-PC\\Desktop\\loose.mp3");
                    MediaPlayer p= new MediaPlayer(m);
                    p.play();
                    JOptionPane.showConfirmDialog(null, "�ð��ʰ�", "Lose.....", JOptionPane.CLOSED_OPTION);
                    card.show(base, "Fail");
                    break;
                }

            }
        }

    }
}




















package bug_catch;


import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Dimension;
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
	
	
	timer time_label = new timer(this, 0, 0, 300);


	JScrollPane scrollPane;
	ImageIcon back;
	JButton startBt, stopBt, pauseBt, suspendBt, resumeBt;
	
	JPanel contentPane;
	//ImagePanel contentPane;
	JPanel menuPanel;
	JPanel centerPanel;
   
	BufferedImage img = null;
	// �ϴ� �ٴ��ʿ�
	int img_x = 800;
	int img_y = 800;
	Thread[] ths;
	int score;
	int level;


	public KillBug(int _level)
	{
		super("Bug Catching Game");	
		
		// Ÿ�̸� �����嵵 �߰�
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

                g.drawImage(back.getImage(), 0, 0, 1900,850,null);
                setOpaque(false);
                super.paintComponent(g);
			}
		};
		
		scrollPane = new JScrollPane(centerPanel);
		menuPanel = new JPanel();
		menuPanel.setLayout(new GridLayout(1,4,5,5));
		//1�� 4�� 5���� ������
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
		
		startBt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int level_control = (bugs.length/3)*level;
				for (int i=0 ; i < level_control; i++) {
					bugs[i].setVisible(true);
					centerPanel.add(bugs[i]);
					centerPanel.add(death_bugs[i]);
				}
				//centerPanel.add(time_label);
				centerPanel.updateUI();
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
				for(int i=0; i<bugs.length; i++){
					ths[i].resume();
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
						int answer=JOptionPane.showConfirmDialog(null, "���� �ܰ�� �Ѿ� ���ðڽ��ϱ�?", "Clear!! Congraturation!!", JOptionPane.YES_NO_OPTION);
						if (answer==0){
							level ++;
							score = 0;
							if (level == 2) {
								//ImageIcon success = new ImageIcon("C:\\Users\\admin\\eclipse-workspace\\HW\\src\\bug_catch\\grass.png");  
								//JOptionPane.ICON_PROPERTY success = new JOptionPane.ICON_PROPERTY();
										
								JOptionPane.showConfirmDialog(null, "��� �ܰ踦 �����߽��ϴ�!", "Clear!! Congraturation!!", JOptionPane.CLOSED_OPTION);
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

