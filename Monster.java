package bug_catch;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class Monster extends JButton implements Runnable{
	public static int score1;
	private int score2;
	private ImageIcon name;
	//public ImagePanel lane = new ImagePanel("C:\\Users\\admin\\eclipse-workspace\\HW\\src\\bug_catch\\grass12.png");
	public JPanel lane = new JPanel();
	private int x, y; // car ��ġ ��
	
	BufferedImage img = null;
	   // �ϴ� �ٴ��ʿ�
	int img_x = 800;
	int img_y = 800;

	public Monster(ImageIcon name, int x, int y) {
		lane.setLayout(null);
		lane.setFont(new Font("HY������M", Font.BOLD+Font.ITALIC,20));

	    //ImageIcon backimg = new ImageIcon("C:\\Users\\admin\\eclipse-workspace\\HW\\src\\bug_catch\\grass.jpg");
	    //lane.setIcon(backimg);
		
		//lane.setBackground(Color.BLACK);
		this.name = name;
		this.setIcon(name);
		this.setBackground(Color.pink);
		this.setOpaque(false);
		this.setBounds(x, y, 50, 50);
		lane.setOpaque(false);
		lane.add(this);
	}

	
	public void run() {
		// TODO x, y ���� �޾Ƽ� �ٲ������.
		// ���Ͱ� �޸��� �κ�
		for (int i=0 ; i < 1000 ; i++) {
			x = i;
			if (i%30 == 0) {
				y = i % (((int)(Math.random()*80))+1);
			}
			// ���� �����̰� �ϴ� �κ�
			this.setBounds(x,y,50,50);
			// ���� ���� ���� �ٸ� ������ ���͹��� ������.
			try {
				Thread.sleep((int)(Math.random()*20));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}// ���� ������ �� 
		score1++;
		score2 = score1;
		(lane.getGraphics()).drawString("��� ����", 900, 30);

	}
	
	
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