package ruiz;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.sound.midi.Instrument;
import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Synthesizer;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TriadsTrainerAural extends JFrame {

	private ArrayList<Integer> triads = new ArrayList<Integer>();
	private String playType;
	private String playOrder;
	private String exerciseType;
	private int numberQuestions;
	private JPanel contentPane;
	private String answer;
	private static String triad;
	private static int questions;
	private static int correct = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TriadsTrainerAural frame = new TriadsTrainerAural();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws MidiUnavailableException 
	 */
	public TriadsTrainerAural() throws MidiUnavailableException {

	}

	public TriadsTrainerAural(String playType, ArrayList<Integer> triads, int numberQuestions) throws MidiUnavailableException
	{
		this.exerciseType = exerciseType;
		this.playType = playType;
		this.numberQuestions = numberQuestions;

		Random r = new Random();	

		Synthesizer synth = MidiSystem.getSynthesizer();
		synth.open();

		final MidiChannel[] channel = synth.getChannels();
		Instrument[] instrument = synth.getDefaultSoundbank().getInstruments();
		synth.loadInstrument(instrument[90]);

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(3, 0, 0, 0));

		ArrayList<String> allowedTriads = determineTriads(triads);

		JLabel lblPlaceholder = new JLabel("");
		contentPane.add(lblPlaceholder);

		JButton btnPlayTriad = new JButton("Play Triad");
		
		btnPlayTriad.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(questions > numberQuestions - 1)
				{
					setVisible(false);
					JOptionPane.showMessageDialog(null, displayResults());
				}
			}
		});
		
		btnPlayTriad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblPlaceholder.setText("");
				int state = 0;
				if(playType == "Harmonic")
				{
					state = 1;
				}
				if(playType == "Melodic")
				{
					state = 2;
				}

				switch(state)
				{
				case 0:
					JOptionPane.showMessageDialog(null, "Error");
					break;
				case 1:
					if(questions > numberQuestions)
					{
						break;
					}
					try {
						playTriad(1, allowedTriads);
					} catch (MidiUnavailableException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case 2:
					if(questions > numberQuestions)
					{
						break;
					}
					try {
						playTriad(2, allowedTriads);
					} catch (MidiUnavailableException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				}
			}
		});
		contentPane.add(btnPlayTriad);

		JButton btnMajor = new JButton("Major");
		contentPane.add(btnMajor);
		btnMajor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				questions++;
				answer = "Major";
				answerDisplay(lblPlaceholder, answer);
			}
		});
		btnMajor.setEnabled(false);

		JButton btnMinor = new JButton("Minor");
		contentPane.add(btnMinor);
		btnMinor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				questions++;
				answer = "Minor";
				answerDisplay(lblPlaceholder, answer);
			}
		});
		btnMinor.setEnabled(false);

		JButton btnAugmented = new JButton("Augmented");
		contentPane.add(btnAugmented);
		btnAugmented.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				questions++;
				answer = "Augmented";
				answerDisplay(lblPlaceholder, answer);
			}
		});
		btnAugmented.setEnabled(false);

		JButton btnDiminished = new JButton("Diminished");
		contentPane.add(btnDiminished);
		btnDiminished.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				questions++;
				answer = "Diminished";
				answerDisplay(lblPlaceholder, answer);
			}
		});
		btnDiminished.setEnabled(false);

		for(int x = 0; x < allowedTriads.size(); x++)
		{
			switch(allowedTriads.get(x))
			{
			case "Major":
				enableButton(allowedTriads.get(x), btnMajor);
				break;
			case "Minor":
				enableButton(allowedTriads.get(x), btnMinor);
				break;
			case "Augmented":
				enableButton(allowedTriads.get(x), btnAugmented);
				break;
			case "Diminished":
				enableButton(allowedTriads.get(x), btnDiminished);
				break;
			}
		}
	}


	public static ArrayList<String> determineTriads(ArrayList<Integer> triads)
	{
		ArrayList<String> allowedTriads = new ArrayList<>();

		for(int x = 0; x < triads.size(); x++)
		{
			if(triads.get(x) == 1)
			{
				switch(x)
				{
				case 0:
					allowedTriads.add("Major");
					break;
				case 1:
					allowedTriads.add("Minor");
					break;
				case 2:
					allowedTriads.add("Augmented");
					break;
				case 3:
					allowedTriads.add("Diminished");
					break;
				}
			}
		}
		return allowedTriads;
	}


	private void enableButton(String string, JButton button) {
		if(string == "Major")
			button.setEnabled(true);
		if(string == "Minor")
			button.setEnabled(true);
		if(string == "Augmented")
			button.setEnabled(true);
		if(string == "Diminished")
			button.setEnabled(true);
	}

	private static void playTriad(int state, ArrayList<String> allowedTriads) throws MidiUnavailableException
	{
		//Setup
		Synthesizer synth = MidiSystem.getSynthesizer();
		synth.open();

		final MidiChannel[] channel = synth.getChannels();
		Instrument[] instrument = synth.getDefaultSoundbank().getInstruments();
		synth.loadInstrument(instrument[90]);
		
		int firstNote = setFirstNote();
		int secondNote = 0 ,thirdNote = 0;
		
		String playThis = allowedTriads.get(SoundMidi.RandomInt(0, allowedTriads.size() - 1));
		triad = playThis;
		
		if(playThis == "Major")
		{
			secondNote = setNextNoteMajorThird(firstNote);
			thirdNote = setNextNoteMinorThird(secondNote);
		}
		else if(playThis == "Minor")
		{
			secondNote = setNextNoteMinorThird(firstNote);
			thirdNote = setNextNoteMajorThird(secondNote);
		}
		else if(playThis == "Augmented")
		{
			secondNote = setNextNoteMajorThird(firstNote);
			thirdNote = setNextNoteMajorThird(secondNote);
		}
		else if(playThis == "Diminished")
		{
			secondNote = setNextNoteMinorThird(firstNote);
			thirdNote = setNextNoteMinorThird(secondNote);
		}
		
		if(state == 1)	//Harmonic
		{
			channel[1].noteOn(firstNote, 600);
			channel[1].noteOn(secondNote, 600);
			channel[1].noteOn(thirdNote, 600);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			channel[1].allNotesOff();
		}

		if(state == 2)	//Melodic
		{
			channel[1].noteOn(firstNote, 600);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			channel[1].noteOn(secondNote, 600);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			channel[1].noteOn(thirdNote, 600);
			try {
				Thread.sleep(600);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			channel[1].allNotesOff();
		}
	}
	
	private static int setFirstNote()
	{
		Integer firstNote;
		int note = SoundMidi.RandomInt(40, 88);//Want a decent range without going too low or too high
		firstNote = note;
		//IntervalTrainerAural.firstNote = firstNote;

		return firstNote;
	}
	
	private static int setNextNoteMajorThird(int startNote)
	{
		int nextNote = 0;
		
		nextNote = startNote + 4;
		return nextNote;
	}
	
	private static int setNextNoteMinorThird(int startNote)
	{
		int nextNote = 0;
		
		nextNote = startNote + 3;
		return nextNote;
	}
	
	public void answerDisplay(JLabel label, String answerString)
	{
		if(answerString.equals(triad))
		{
			label.setText("Correct!");
			correct++;
		}
		else
		{
			label.setText("Correct Answer:" + triad);
		}
	}
	
	public String displayResults()
	{
		return correct + " out of " + questions + " correct";
	}
}
