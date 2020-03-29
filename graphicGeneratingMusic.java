import javax.swing.*;
import java.awt.*;
import javax.sound.midi.*;

class MusicPlayer {

    static JFrame frame = new JFrame("My First Video");
    static Graphical graphical;

    private MidiEvent makeEvent(int command, int channel, int one, int two, int tick) {
        MidiEvent event = null;
        try {
            ShortMessage a = new ShortMessage();
            a.setMessage(command, channel, one, two);
            event = new MidiEvent(a, tick);
        } catch (Exception e) {

        }
        return event;
    }

    public void setupGUI() {
        graphical = new Graphical();
        frame.getContentPane().add(graphical, BorderLayout.CENTER);
        frame.setBounds(30, 30, 400, 400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void runPlayer() {
        setupGUI();
        try {
            Sequencer player = MidiSystem.getSequencer();
            player.open();
            Sequence seq = new Sequence(Sequence.PPQ, 4);
            Track track = seq.createTrack();
            player.addControllerEventListener(graphical, new int[] { 127 });
            int random = 0;
            for (int i = 0; i < 60; i += 4) {
                random = (int) (Math.random() * 50) + 1;
                track.add(makeEvent(144, 1, random, 100, i));
                track.add(makeEvent(176, 1, 127, 0, i));
                track.add(makeEvent(128, 1, random, 100, i + 2));
            }
            player.setSequence(seq);
            player.start();
            player.setTempoInBPM(120);
        } catch (Exception e) {

        }
    }

    class Graphical extends JPanel implements ControllerEventListener {
        /**
         *
         */
        private static final long serialVersionUID = 1L;
        boolean flag = false;

        public void controlChange(ShortMessage message) {
            flag = true;
            repaint();
        }

        public void paintComponent(Graphics graphics) {
            if (flag) {
                Graphics2D d2 = (Graphics2D) graphics;

                int red = (int) (Math.random() * 255);
                int blue = (int) (Math.random() * 255);
                int green = (int) (Math.random() * 255);

                d2.setColor(new Color(red, blue, green));

                int height = (int) ((Math.random() * 120) + 10);
                int width = (int) ((Math.random() * 120) + 10);

                int x = (int) ((Math.random() * 40) + 10);
                int y = (int) ((Math.random() * 40) + 10);
                d2.fillRect(x, y, height, width);
                flag = false;
            }
        }
    }

}

public class graphicGeneratingMusic {
    public static void main(String[] args) {
        MusicPlayer player = new MusicPlayer();
        player.runPlayer();
    }
}