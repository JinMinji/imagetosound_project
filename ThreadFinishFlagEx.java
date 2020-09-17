package bug_catch;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

class ThreadFinishFlagEx extends JFrame{
    ThreadFinishFlagEx(){
        this.setTitle("ThreadFinishFlag ����");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Container c = this.getContentPane();
        RandomThread rt = new RandomThread(c);//������ ����
        c.addMouseListener(new MouseListener(){//���콺 ������ ���
            @Override
            public void mouseClicked(MouseEvent me) {
            }

            @Override
            public void mousePressed(MouseEvent me) {
                rt.finish();//������ ���� ���
            }

            @Override
            public void mouseReleased(MouseEvent me) {
            }

            @Override
            public void mouseEntered(MouseEvent me) {
            }

            @Override
            public void mouseExited(MouseEvent me) {
            }
            
        });
        this.setLocationRelativeTo(this.getParent());
        this.setSize(300,200);
        this.setVisible(true);
        rt.start();//������ ����
    }
    class RandomThread extends Thread{
        Container cc;
        boolean flag =false;//�������� ���� ����� ���� �÷���
        RandomThread(Container cc){
            this.cc= cc;
        }
        
        void finish(){flag=true;}//������ ���Ḧ ���� �Լ�
        
        public void run(){
            while(true){
                int x=((int)(Math.random()*cc.getWidth()));
                int y=((int)(Math.random()*cc.getHeight()));
                JLabel la = new JLabel("Java");//�� ���̺� ����
                la.setBounds(x, y, 80, 30);//��ġ�� ũ�⸦ ����
                cc.add(la);//���̺� �߰�
                cc.repaint();//�ٽ� �׷� �߰��� ���̺� ���̱�
                try{
                    sleep(300);//0.3�ʵ��� ���� �ܴ�.
                    if(flag==true){
                        cc.removeAll();//��� ���̺� ����
                        la=new JLabel("Finish");
                        la.setBounds(x, y, 80, 30);//��ġ�� ũ�� ����
                        la.setForeground(Color.red);//���ڻ� ���������� ����
                        cc.add(la);//���̺� �߰�
                        cc.repaint();//Finish ���̺� ���̱�
                        return;//������ ����
                    }
                }
                catch(Exception e){return;}
            }
        }
    }
    public static void main(String[] args) {
        new ThreadFinishFlagEx();
    }
}
