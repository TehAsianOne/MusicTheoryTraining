package ruiz;

import java.awt.EventQueue;
import java.util.ArrayList;

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

public class SeventhsTrainerAural extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String answer;
	private static String seventh;
	private static int questions;
	private static int correct = 0;
	
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SeventhsTrainerAural frame = new SeventhsTrainerAural();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SeventhsTrainerAural() {
	}
	
	public SeventhsTrainerAural(String playType, ArrayList<Integer> sevenths, int numberQuestions)
	{
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblPlaceholder = new JLabel("");
		contentPane.add(lblPlaceholder);
		
		ArrayList<String> allowedSevenths = determineSevenths(sevenths);
		//JOptionPane.showMessageDialog(null, allowedSevenths);
		
		JButton btnPlaySeventhChord = new JButton("Play Seventh Chord");
		
		btnPlaySeventhChord.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(questions > numberQuestions - 1)
				{
					setVisible(false);
					JOptionPane.showMessageDialog(null, displayResults());
				}
			}
		});
		
		btnPlaySeventhChord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
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
						playSeventh(1, allowedSevenths);
					} catch (MidiUnavailableException e1) {
						e1.printStackTrace();
					}
					break;
				case 2:
					if(questions > numberQuestions)
					{
						break;
					}
					try {
						playSeventh(2, allowedSevenths);
					} catch (MidiUnavailableException e1) {
						e1.printStackTrace();
					}
					break;
				}
			}
		});
		contentPane.add(btnPlaySeventhChord);
		
		JButton btnMajorSeventh = new JButton("Major Seventh");
		btnMajorSeventh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				questions++;
				answer = "Major Seventh";
				answerDisplay(lblPlaceholder, answer);
			}
		});
		btnMajorSeventh.setEnabled(false);
		contentPane.add(btnMajorSeventh);
		
		JButton btnMinorSeventh = new JButton("Minor Seventh");
		btnMinorSeventh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				questions++;
				answer = "Minor Seventh";
				answerDisplay(lblPlaceholder, answer);
			}
		});
		btnMinorSeventh.setEnabled(false);
		contentPane.add(btnMinorSeventh);
		
		JButton btnDominantSeventh = new JButton("Dominant Seventh");
		btnDominantSeventh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				questions++;
				answer = "Dominant Seventh";
				answerDisplay(lblPlaceholder, answer);
			}
		});
		btnDominantSeventh.setEnabled(false);
		contentPane.add(btnDominantSeventh);
		
		JButton btnHalfdiminishedSeventh = new JButton("Half-Diminished Seventh");
		btnHalfdiminishedSeventh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				questions++;
				answer = "Half Diminished Seventh";
				answerDisplay(lblPlaceholder, answer);
			}
		});
		btnHalfdiminishedSeventh.setEnabled(false);
		contentPane.add(btnHalfdiminishedSeventh);
		
		JButton btnFullyDiminishedSeventh = new JButton("Fully Diminished Seventh");
		btnFullyDiminishedSeventh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				questions++;
				answer = "Fully Diminished Seventh";
				answerDisplay(lblPlaceholder, answer);
			}
		});
		btnFullyDiminishedSeventh.setEnabled(false);
		contentPane.add(btnFullyDiminishedSeventh);
		
		for(int x = 0; x < allowedSevenths.size(); x++)
		{
			
			switch(allowedSevenths.get(x))
			{
			case "Major Seventh":
				enableButton(allowedSevenths.get(x), btnMajorSeventh);
				break;
			case "Minor Seventh":
				enableButton(allowedSevenths.get(x), btnMinorSeventh);
				break;
			case "Dominant Seventh":
				enableButton(allowedSevenths.get(x), btnDominantSeventh);
				break;
			case "Half Diminished Seventh":
				enableButton(allowedSevenths.get(x), btnHalfdiminishedSeventh);
				break;
			case "Fully Diminished Seventh":
				enableButton(allowedSevenths.get(x), btnFullyDiminishedSeventh);
				break;
			}
		}
	}
	
	public static ArrayList<String> determineSevenths(ArrayList<Integer> sevenths)
	{
		ArrayList<String> allowedSevenths = new ArrayList<>();

		for(int x = 0; x < sevenths.size(); x++)
		{
			if(sevenths.get(x) == 1)
			{
				switch(x)
				{
				case 0:
					allowedSevenths.add("Major Seventh");
					break;
				case 1:
					allowedSevenths.add("Minor Seventh");
					break;
				case 2:
					allowedSevenths.add("Dominant Seventh");
					break;
				case 3:
					allowedSevenths.add("Half Diminished Seventh");
					break;
				case 4:
					allowedSevenths.add("Fully Diminished Seventh");
					break;
				}
			}
		}
		return allowedSevenths;
	}
	
	private void enableButton(String string, JButton button) {
		if(string == "Major Seventh")
			button.setEnabled(true);
		if(string == "Minor Seventh")
			button.setEnabled(true);
		if(string == "Dominant Seventh")
			button.setEnabled(true);
		if(string == "Half Diminished Seventh")
			button.setEnabled(true);
		if(string == "Fully Diminished Seventh")
			button.setEnabled(true);
	}
	
	private static void playSeventh(int state, ArrayList<String> allowedSevenths) throws MidiUnavailableException
	{
		//Setup
		Synthesizer synth = MidiSystem.getSynthesizer();
		synth.open();

		final MidiChannel[] channel = synth.getChannels();
		Instrument[] instrument = synth.getDefaultSoundbank().getInstruments();
		synth.loadInstrument(instrument[90]);
		
		int firstNote = setFirstNote();
		int secondNote = 0 ,thirdNote = 0, fourthNote = 0;
		
		String playThis = allowedSevenths.get(SoundMidi.RandomInt(0, allowedSevenths.size() - 1));
		seventh = playThis;
		
		if(playThis == "Major Seventh")
		{
			secondNote = setNextNoteMajorThird(firstNote);
			thirdNote = setNextNoteMinorThird(secondNote);
			fourthNote = setNextNoteMajorThird(thirdNote);
		}
		else if(playThis == "Minor Seventh")
		{
			secondNote = setNextNoteMinorThird(firstNote);
			thirdNote = setNextNoteMajorThird(secondNote);
			fourthNote = setNextNoteMinorThird(thirdNote);
		}
		else if(playThis == "Dominant Seventh")
		{
			secondNote = setNextNoteMajorThird(firstNote);
			thirdNote = setNextNoteMinorThird(secondNote);
			fourthNote = setNextNoteMinorThird(thirdNote);
		}
		else if(playThis == "Half Diminished Seventh")
		{
			secondNote = setNextNoteMinorThird(firstNote);
			thirdNote = setNextNoteMinorThird(secondNote);
			fourthNote = setNextNoteMajorThird(thirdNote);
		}
		else if(playThis == "Fully Diminished Seventh")
		{
			secondNote = setNextNoteMinorThird(firstNote);
			thirdNote = setNextNoteMinorThird(secondNote);
			fourthNote = setNextNoteMinorThird(thirdNote);
		}
		
		if(state == 1)	//Harmonic
		{
			channel[1].noteOn(firstNote, 600);
			channel[1].noteOn(secondNote, 600);
			channel[1].noteOn(thirdNote, 600);
			channel[1].noteOn(fourthNote, 600);
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
			channel[1].noteOn(fourthNote, 600);
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
		if(answerString.equals(seventh))
		{
			label.setText("Correct!");
			correct++;
		}
		else
		{
			label.setText("Correct Answer: " + seventh);
		}
	}
	
	public String displayResults()
	{
		return correct + " out of " + questions + " correct";
	}
}
