package bug_catch;

import java.awt.*;
import javax.swing.*;

public class DefineCursor extends JFrame {
    Cursor cursor;
    Image img;
   
    public DefineCursor(){
        super("User Defined Cursor");
       
        Toolkit tk = Toolkit.getDefaultToolkit();
        img = tk.getImage("roman.jpg");
        Point point = new Point(0,0);
        cursor = tk.createCustomCursor(img,point,"roman");
        setCursor(cursor);
       
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400,300);
        setVisible(true);
    }
    
    public static void main(String args[]){
        new DefineCursor();
    }
}