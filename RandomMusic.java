
import javax.sound.midi.*;

public class RandomMusic {

    public static void main(String[] args) {
        RandomMusic player = new RandomMusic();
        int instrument = (int) (Math.random() * 128);
        int note = (int) (Math.random() * 128);
        player.play(instrument, note);
    }

    public void play(int instrument, int note) {
        try {
            Sequencer player = MidiSystem.getSequencer();
            player.open();

            Sequence seq = new Sequence(Sequence.PPQ, 4);

            Track track = seq.createTrack();

            ShortMessage newInstrument = new ShortMessage();
            newInstrument.setMessage(192, 1, instrument, 0);
            MidiEvent ins = new MidiEvent(newInstrument, 1);
            track.add(ins);

            ShortMessage a = new ShortMessage();
            a.setMessage(144, 1, note, 100);
            MidiEvent ins1 = new MidiEvent(a, 1);
            track.add(ins1);

            ShortMessage b = new ShortMessage();
            b.setMessage(198, 1, note, 100);
            MidiEvent ins2 = new MidiEvent(b, 16);
            track.add(ins2);

            player.setSequence(seq);
            player.start();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
