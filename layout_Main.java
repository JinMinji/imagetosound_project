package bug_catch;
import javax.swing.*;

import java.awt.*;

public class layout_Main {
    public static void main(String args[]){
        JFrame f = new JFrame("ButtonLabelO");
        f.setLayout(new CardLayout());
        f.add(new layout());
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        f.setSize(1000,800);
        
        f.setVisible(true);
    }
  
}
