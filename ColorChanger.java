import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

class Changer extends JPanel
{
    public void paintComponent(Graphics g)
    {
        int red = (int) (Math.random() * 255);
        int green = (int) ( Math.random() * 255);
        int blue = (int) (Math.random() * 255);

        Color color = new Color(red,green,blue);
        g.setColor(color);
        g.fillOval(70, 70, 100, 100);
        System.out.println(g.getColor());   
    }
}

class DrawIt implements ActionListener
{
    private JFrame frame;

    

    public void run()
    {
        frame = new JFrame();
        JButton button = new JButton("Click Here");
        frame.setDefaultCloseOperation(3);
       Changer colorChanger = new Changer() ;
        frame.getContentPane().add(BorderLayout.SOUTH,button);
        frame.getContentPane().add(BorderLayout.CENTER,colorChanger);
        frame.setSize(300,300);
        frame.setVisible(true);
        button.addActionListener(this);
    }

    public void actionPerformed(ActionEvent event)
    {
        frame.repaint();
    }
}


public class ColorChanger
{
    public static void main(String[] args) {
        DrawIt draw = new DrawIt();
        draw.run();
    }
}