package bug_catch;

import java.awt.*;
import java.awt.event.*;

import javax.swing.JPanel;

										//ItemListener!!!
public class CardTest extends Frame implements ItemListener {
	private Panel body, ps[]; //panel chioce시, index로 매칭하기 위해 배열객체로 설정
	private Choice choice;
	private CardLayout card;
	private int selected;
	JPanel main;
	
	
	// card layout 활용안! 메뉴선택과 같은 상황에 적용하기 좋은 방법!
	// tap과 달리 화면 구성이 깔끔하다는 장점.
	
	public CardTest() {
		super("카드 레이아웃");
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
	
	//window 닫히도록 추가해준 코드 - Swing에서는 디폴트로 있음
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
