package ruiz;

import java.awt.EventQueue;

import javax.sound.midi.*;

import javax.swing.JFrame;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
public class Keyboard {

	private JFrame frmKeyboard;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Keyboard window = new Keyboard();
					window.frmKeyboard.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws MidiUnavailableException 
	 * @throws InterruptedException 
	 */
	public Keyboard() throws MidiUnavailableException, InterruptedException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws MidiUnavailableException 
	 */
	private void initialize() throws MidiUnavailableException {
		frmKeyboard = new JFrame();
		frmKeyboard.setTitle("Keyboard");
		frmKeyboard.setResizable(false);
		frmKeyboard.setBounds(100, 100, 1366, 768);
		frmKeyboard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Synthesizer synth = MidiSystem.getSynthesizer();
		synth.open();
		
		final MidiChannel[] channel = synth.getChannels();
		Instrument[] instrument = synth.getDefaultSoundbank().getInstruments();
		synth.loadInstrument(instrument[90]);
		frmKeyboard.getContentPane().setLayout(null);
		
		
		
		JLabel lblIntervalPlayed = new JLabel("Interval Played");
		lblIntervalPlayed.setBounds(152, 17, 84, 16);
		frmKeyboard.getContentPane().add(lblIntervalPlayed);
		
		JButton btnNewButton = new JButton("Play Interval");
		btnNewButton.setBounds(12, 13, 128, 25);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Integer firstNote, secondNote, interval;
				int start = SoundMidi.RandomInt(32, 96);	//Want a decent range without going too low or too high
				firstNote = start/* - 12*/;
				channel[1].noteOn(start, 600);
				try {
					Thread.sleep(500);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				
				start = SoundMidi.RandomInt(firstNote - 12, firstNote + 12);	//60, 72 default. +- 12 to account for above/below by an octave
				secondNote = start/* - 12*/;
				channel[1].noteOn(start, 600);
				try {
					Thread.sleep(500);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				channel[1].allNotesOff();
				interval = secondNote - firstNote;
				
				lblIntervalPlayed.setText(interval.toString());
				lblIntervalPlayed.setText(SoundMidi.GetInterval(firstNote, secondNote));
			}
		});
		frmKeyboard.getContentPane().add(btnNewButton);
		
		
	}
}
