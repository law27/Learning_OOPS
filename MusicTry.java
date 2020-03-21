import javax.sound.midi.*;

public class MusicTry {
    public void play() {
        try {
            Sequencer player = MidiSystem.getSequencer();
            player.open();

            Sequence seq = new Sequence(Sequence.PPQ, 4);

            Track track = seq.createTrack();

            ShortMessage a = new ShortMessage();
            a.setMessage(144, 1, 40, 100);
            MidiEvent noteOn = new MidiEvent(a, 1);
            ShortMessage b = new ShortMessage();
            b.setMessage(128, 1, 40, 100);
            MidiEvent noteOff = new MidiEvent(b, 16);
            track.add(noteOn);
            track.add(noteOff);

            player.setSequence(seq);
            player.start();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        MusicTry mini = new MusicTry();
        mini.play();
    }
}
