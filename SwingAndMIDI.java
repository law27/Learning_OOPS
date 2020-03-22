import java.awt.event.*;
import javax.sound.midi.*;
import javax.swing.*;

class MusicPlayer {
    static public void play() {
        int note = (int) (Math.random() * 127);
        try {
            Sequencer player = MidiSystem.getSequencer();
            player.open();

            Sequence sequence = new Sequence(Sequence.PPQ, 4);
            Track track = sequence.createTrack();

            ShortMessage a = new ShortMessage();
            a.setMessage(144, 1, note, 100);
            MidiEvent eve1 = new MidiEvent(a, 1);
            track.add(eve1);

            ShortMessage b = new ShortMessage();
            b.setMessage(128, 1, note, 100);
            MidiEvent eve2 = new MidiEvent(b, 16);
            track.add(eve2);

            player.setSequence(sequence);
            player.start();
            while (player.isRunning()) {
                player.start();
            }
            player.close();

        } catch (Exception ex) {
            ex.getStackTrace();
        }
    }

}

class CreateGraphics implements ActionListener {
    public void run() {
        JFrame frame = new JFrame();
        JButton button = new JButton("Create Sound");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(button);
        frame.setSize(300, 300);
        frame.setVisible(true);
        button.addActionListener(this);
    }

    public void actionPerformed(ActionEvent event) {
        MusicPlayer.play();
    }
}

public class SwingAndMIDI {

    public static void main(String[] args) {
        CreateGraphics graphics = new CreateGraphics();
        graphics.run();
    }
}
