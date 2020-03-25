import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

class movingGUI
{
    int x ;
    int y ;
    public void run()
    {
        JFrame frame = new JFrame();
        frame.setSize(300,300);
        frame.setDefaultCloseOperation(3);
        frame.setVisible(true);
        GUIHelper gui = new GUIHelper();
        frame.getContentPane().add(gui);
        x = 70;
        y = 70;
        for(int i = 0 ; i < 100 ; i++)
        {
            x++;
            y++;
            frame.repaint();
            try{
                Thread.sleep(50);
            } catch(Exception ex)
            {
                System.out.println("Oops");
            }
        }
    }
    class GUIHelper extends JPanel
    {
        public void paintComponent(Graphics g)
        {
            g.setColor(Color.white);
            g.fillRect(0,0,this.getWidth(),this.getHeight());
            g.setColor(Color.green); 
            g.fillOval(x,y,30,30);
        }
    }
}


public class MovingOval
{
    public static void main(String[] args)
    {
        movingGUI gui = new movingGUI();
        gui.run();
    }
}

