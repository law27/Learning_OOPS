import javax.swing.*;
import java.awt.event.*;

class GUI implements ActionListener {
    JFrame frame;
    JButton button;

    public void go(String message) {
        frame = new JFrame();
        button = new JButton(message);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(button);
        button.addActionListener(this);
        frame.setSize(300, 300);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent event) {
        button.setText("You Pressed Me Bro");
    }
}

public class JavaSwing {
    public static void main(String[] args) {
        GUI simpleGUI = new GUI();
        simpleGUI.go("Hello Dear");
    }
}