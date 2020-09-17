package bug_catch;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.Graphics;

public class CursorFollow {
	
	BufferedImage img = null;
	int img_x = 100;
	int img_y = 100;
	
	public CursorFollow() {
		try {
			img = ImageIO.read(new File("C:\\Users\\admin\\eclipse-workspace\\HW\\src\\bug_catch\\swatter.png"));
		}	catch (IOException e) {
			System.out.println("no image");
			System.exit(1);
		}
		addMouseListener(new MouseListener() {
			public void mousePressed(MouseEvent e) {
				img_x = e.getX();
				img_y = e.getY();
				repaint();
			}
			public void mouseReleased(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
			public void mouseClicked(MouseEvent e) {}
		});
		
		addMouseMotionListener(new MouseMotionListener() {
			public void mouseDragged(MouseEvent me) {}
			public void mouseMoved(MouseEvent me) {
				img_x = me.getX()-50;
				img_y = me.getY()-50;
				repaint();
			}
		});
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(img, img_x, img_y, null);
	}

}
