import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class SimpleGUI extends JPanel {
    public void paintComponent(Graphics g) {
        g.setColor(Color.PINK);
        int randomWidth = (int) (Math.random() * 100);
        int randomHeight = (int) (Math.random() * 100);
        g.fillRect(75, 75, randomWidth, randomHeight);
    }
}

class CreateGUI implements ActionListener {
    JFrame frame;

    public void run() {
        frame = new JFrame();
        frame.setSize(300, 300);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(3);
        JButton button = new JButton("Click here");
        frame.getContentPane().add(BorderLayout.SOUTH, button);
        SimpleGUI gui = new SimpleGUI();
        frame.getContentPane().add(BorderLayout.CENTER, gui);
        button.addActionListener(this);
    }

    public void actionPerformed(ActionEvent event) {
        frame.repaint();
    }
}

public class shapeChanger {
    public static void main(String[] args) {
        CreateGUI gui = new CreateGUI();
        gui.run();
    }
}

