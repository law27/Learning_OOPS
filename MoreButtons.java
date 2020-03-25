import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class SimpleGUI extends JPanel {
    public void paintComponent(Graphics g) {
        int red = (int) (Math.random() * 255);
        int blue = (int) (Math.random() * 255);
        int green = (int) (Math.random() * 255);
        Color color = new Color(red, blue, green);
        g.setColor(color);
        g.fillOval(80, 80, 100, 100);
    }
}

class TwoButtons {
    JFrame frame;
    JLabel label;
    SimpleGUI gui;
    JButton guiButton;
    JButton labelButton;

    public void run() {
        frame = new JFrame();
        label = new JLabel("See here");
        guiButton = new JButton("Click Here");
        labelButton = new JButton("Click Here too");
        gui = new SimpleGUI();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(400, 400);
        frame.getContentPane().add(BorderLayout.CENTER, gui);
        frame.getContentPane().add(BorderLayout.SOUTH, guiButton);
        frame.getContentPane().add(BorderLayout.WEST, label);
        frame.getContentPane().add(BorderLayout.EAST, labelButton);
        guiButton.addActionListener(new guiListener());
        labelButton.addActionListener(new labelListener());
    }

    class guiListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            frame.repaint();
        }
    }

    class labelListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            label.setText("You Just Clicked it");
        }
    }
}

public class MoreButtons {
    public static void main(String[] args) {
        TwoButtons buttons = new TwoButtons();
        buttons.run();
    }
}
