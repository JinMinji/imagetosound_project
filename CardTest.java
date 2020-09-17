package bug_catch;

import java.awt.*;
import java.awt.event.*;

import javax.swing.JPanel;

										//ItemListener!!!
public class CardTest extends Frame implements ItemListener {
	private Panel body, ps[]; //panel chioce��, index�� ��Ī�ϱ� ���� �迭��ü�� ����
	private Choice choice;
	private CardLayout card;
	private int selected;
	JPanel main;
	
	
	// card layout Ȱ���! �޴����ð� ���� ��Ȳ�� �����ϱ� ���� ���!
	// tap�� �޸� ȭ�� ������ ����ϴٴ� ����.
	
	public CardTest() {
		super("ī�� ���̾ƿ�");
		body = new Panel();
		body.setLayout(card = new CardLayout());
		MouseHandler handler = new MouseHandler();

		main = new JPanel();
		KillBug bug_game = new KillBug(3);
		main.addMouseListener(handler);
		
		main.add(bug_game.contentPane);
		
		body.add("1", bug_game.contentPane);
		
		card.show(body, "0");
		selected = 0;
		
		choice = new Choice();
		choice.addItemListener(this);

		choice.add(String.valueOf(1));

		
		add(choice, "East");
		add(body, "Center");
		addWindowListener(new WindowHandler());
		setSize(1000,800);
		setVisible(true);
	}
	
	public void itemStateChanged (ItemEvent e) {
		Object o = e.getSource();
		if(o == choice) {
			int index = choice.getSelectedIndex();
			card.show(body,  String.valueOf(index));
			selected = index;
		}
	}
	
	public class MouseHandler extends MouseAdapter {
		public void mouseClicked(MouseEvent e) {
			card.next(body);
			selected = (selected + 1) % ps.length;
			choice.select(selected);
		}
	}
	
	//window �������� �߰����� �ڵ� - Swing������ ����Ʈ�� ����
	public class WindowHandler extends WindowAdapter {
		public void windowClosing(WindowEvent e) {
			setVisible(false);
			dispose();
			System.exit(0);
		}
	}
	
	public static void main (String args[]) {
		new CardTest();
	}
}
