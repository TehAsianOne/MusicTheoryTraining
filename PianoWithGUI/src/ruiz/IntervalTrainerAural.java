package ruiz;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import java.awt.GridBagLayout;

import javax.sound.midi.Instrument;
import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Synthesizer;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Window;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

public class IntervalTrainerAural extends JFrame {

	private JPanel contentPane;
	private ArrayList<Integer> intervals = new ArrayList<Integer>();
	private String playType;
	private String playOrder;
	private String exerciseType;
	private int numberQuestions;
	private static int firstNote;
	private static int secondNote;
	private static int interval;
	private static int answer;
	private static int questions = 0;
	private static int correct = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IntervalTrainerAural frame = new IntervalTrainerAural();
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
	public IntervalTrainerAural() throws MidiUnavailableException {

	}

	public IntervalTrainerAural(String playType, String playOrder, ArrayList<Integer> intervals, int numberQuestions) throws MidiUnavailableException {
		this.playType = playType;
		this.playOrder = playOrder;
		this.intervals = intervals;
		this.numberQuestions = numberQuestions;

		Synthesizer synth = MidiSystem.getSynthesizer();
		synth.open();

		Instrument[] instrument = synth.getDefaultSoundbank().getInstruments();
		synth.loadInstrument(instrument[90]);

		ArrayList<Integer> allowedIntervals = determineIntervals(intervals);	//Exclude non checked intervals

		setResizable(false);
		setTitle("Interval Trainer Aural");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 960, 540);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{472, 472, 0};
		gbl_contentPane.rowHeights = new int[]{71, 71, 71, 71, 71, 71, 71, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);

		JLabel lblListenToThe = new JLabel(" ");
		GridBagConstraints gbc_lblListenToThe = new GridBagConstraints();
		gbc_lblListenToThe.fill = GridBagConstraints.BOTH;
		gbc_lblListenToThe.insets = new Insets(0, 0, 5, 5);
		gbc_lblListenToThe.gridx = 0;
		gbc_lblListenToThe.gridy = 0;
		contentPane.add(lblListenToThe, gbc_lblListenToThe);

		JButton btnPlayInterval = new JButton("Play Interval");
		btnPlayInterval.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				String go = "no";
				if(questions > numberQuestions - 1)
				{
					setVisible(false);
					JOptionPane.showMessageDialog(null, displayResults());
				}
			}
		});
		
		btnPlayInterval.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblListenToThe.setText("");
				
				int state = 0;
				if(playType == "Melodic")
				{
					if(playOrder == "Ascending")
					{
						state = 1;
					}
					if(playOrder == "Descending")
					{
						state = 2;
					}
				}
				else if(playType == "Harmonic")
				{
					state = 3;
				}

				switch(state)
				{
				case 0:
					JOptionPane.showMessageDialog(null, "Error");
					break;
				case 1:
					try {
						if(questions > numberQuestions)
						{
							break;
						}
						playInterval(1, allowedIntervals, playOrder);
						interval = Math.abs(secondNote - firstNote);
						
					} catch (MidiUnavailableException e) {
						e.printStackTrace();
					}
					break;
				case 2:
					try {
						if(questions > numberQuestions)
						{
							break;
						}
						playInterval(2, allowedIntervals, playOrder);
						interval = Math.abs(secondNote - firstNote);
						
					} catch (MidiUnavailableException e) {
						e.printStackTrace();
					}
					break;
				case 3: 
					try {
						if(questions > numberQuestions)
						{
							break;
						}
						playInterval(3, allowedIntervals, playType);
						interval = Math.abs(secondNote - firstNote);
						
					} catch (MidiUnavailableException e) {
						e.printStackTrace();
					}
					break;
				}

			}
		});
		GridBagConstraints gbc_btnPlayInterval = new GridBagConstraints();
		gbc_btnPlayInterval.fill = GridBagConstraints.BOTH;
		gbc_btnPlayInterval.insets = new Insets(0, 0, 5, 0);
		gbc_btnPlayInterval.gridx = 1;
		gbc_btnPlayInterval.gridy = 0;
		contentPane.add(btnPlayInterval, gbc_btnPlayInterval);

		JButton btnMinorSecond = new JButton("Minor Second");
		btnMinorSecond.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				questions++;
				answer = 1;
				answerDisplay(lblListenToThe, answer);
			}
		});
		GridBagConstraints gbc_btnMinorSecond = new GridBagConstraints();
		gbc_btnMinorSecond.fill = GridBagConstraints.BOTH;
		gbc_btnMinorSecond.insets = new Insets(0, 0, 5, 5);
		gbc_btnMinorSecond.gridx = 0;
		gbc_btnMinorSecond.gridy = 1;
		btnMinorSecond.setEnabled(false);
		contentPane.add(btnMinorSecond, gbc_btnMinorSecond);

		JButton btnPerfectFifth = new JButton("Perfect Fifth");
		btnPerfectFifth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				questions++;
				answer = 7;
				answerDisplay(lblListenToThe, answer);
			}
		});
		GridBagConstraints gbc_btnPerfectFifth = new GridBagConstraints();
		gbc_btnPerfectFifth.fill = GridBagConstraints.BOTH;
		gbc_btnPerfectFifth.insets = new Insets(0, 0, 5, 0);
		gbc_btnPerfectFifth.gridx = 1;
		gbc_btnPerfectFifth.gridy = 1;
		btnPerfectFifth.setEnabled(false);
		contentPane.add(btnPerfectFifth, gbc_btnPerfectFifth);

		JButton btnMajorSecond = new JButton("Major Second");
		btnMajorSecond.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				questions++;
				answer = 2;
				answerDisplay(lblListenToThe, answer);
			}
		});
		GridBagConstraints gbc_btnMajorSecond = new GridBagConstraints();
		gbc_btnMajorSecond.fill = GridBagConstraints.BOTH;
		gbc_btnMajorSecond.insets = new Insets(0, 0, 5, 5);
		gbc_btnMajorSecond.gridx = 0;
		gbc_btnMajorSecond.gridy = 2;
		btnMajorSecond.setEnabled(false);
		contentPane.add(btnMajorSecond, gbc_btnMajorSecond);

		JButton btnMinorSixth = new JButton("Minor Sixth");
		btnMinorSixth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				questions++;
				answer = 8;
				answerDisplay(lblListenToThe, answer);
			}
		});
		GridBagConstraints gbc_btnMinorSixth = new GridBagConstraints();
		gbc_btnMinorSixth.fill = GridBagConstraints.BOTH;
		gbc_btnMinorSixth.insets = new Insets(0, 0, 5, 0);
		gbc_btnMinorSixth.gridx = 1;
		gbc_btnMinorSixth.gridy = 2;
		btnMinorSixth.setEnabled(false);
		contentPane.add(btnMinorSixth, gbc_btnMinorSixth);

		JButton btnMinorThird = new JButton("Minor Third");
		btnMinorThird.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				questions++;
				answer = 3;
				answerDisplay(lblListenToThe, answer);
			}
		});
		GridBagConstraints gbc_btnMinorThird = new GridBagConstraints();
		gbc_btnMinorThird.fill = GridBagConstraints.BOTH;
		gbc_btnMinorThird.insets = new Insets(0, 0, 5, 5);
		gbc_btnMinorThird.gridx = 0;
		gbc_btnMinorThird.gridy = 3;
		btnMinorThird.setEnabled(false);
		contentPane.add(btnMinorThird, gbc_btnMinorThird);

		JButton btnMajorSixth = new JButton("Major Sixth");
		btnMajorSixth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				questions++;
				answer = 9;
				answerDisplay(lblListenToThe, answer);
			}
		});
		GridBagConstraints gbc_btnMajorSixth = new GridBagConstraints();
		gbc_btnMajorSixth.fill = GridBagConstraints.BOTH;
		gbc_btnMajorSixth.insets = new Insets(0, 0, 5, 0);
		gbc_btnMajorSixth.gridx = 1;
		gbc_btnMajorSixth.gridy = 3;
		btnMajorSixth.setEnabled(false);
		contentPane.add(btnMajorSixth, gbc_btnMajorSixth);

		JButton btnMajorThird = new JButton("Major Third");
		btnMajorThird.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				questions++;
				answer = 4;
				answerDisplay(lblListenToThe, answer);
			}
		});
		GridBagConstraints gbc_btnMajorThird = new GridBagConstraints();
		gbc_btnMajorThird.fill = GridBagConstraints.BOTH;
		gbc_btnMajorThird.insets = new Insets(0, 0, 5, 5);
		gbc_btnMajorThird.gridx = 0;
		gbc_btnMajorThird.gridy = 4;
		btnMajorThird.setEnabled(false);
		contentPane.add(btnMajorThird, gbc_btnMajorThird);

		JButton btnMinorSeventh = new JButton("Minor Seventh");
		btnMinorSeventh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				questions++;
				answer = 10;
				answerDisplay(lblListenToThe, answer);
			}
		});
		GridBagConstraints gbc_btnMinorSeventh = new GridBagConstraints();
		gbc_btnMinorSeventh.fill = GridBagConstraints.BOTH;
		gbc_btnMinorSeventh.insets = new Insets(0, 0, 5, 0);
		gbc_btnMinorSeventh.gridx = 1;
		gbc_btnMinorSeventh.gridy = 4;
		btnMinorSeventh.setEnabled(false);
		contentPane.add(btnMinorSeventh, gbc_btnMinorSeventh);

		JButton btnPerfectFourth = new JButton("Perfect Fourth");
		btnPerfectFourth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				questions++;
				answer = 5;
				answerDisplay(lblListenToThe, answer);
			}
		});
		GridBagConstraints gbc_btnPerfectFourth = new GridBagConstraints();
		gbc_btnPerfectFourth.fill = GridBagConstraints.BOTH;
		gbc_btnPerfectFourth.insets = new Insets(0, 0, 5, 5);
		gbc_btnPerfectFourth.gridx = 0;
		gbc_btnPerfectFourth.gridy = 5;
		btnPerfectFourth.setEnabled(false);
		contentPane.add(btnPerfectFourth, gbc_btnPerfectFourth);

		JButton btnMajorSeventh = new JButton("Major Seventh");
		btnMajorSeventh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				questions++;
				answer = 11;
				answerDisplay(lblListenToThe, answer);
			}
		});
		GridBagConstraints gbc_btnMajorSeventh = new GridBagConstraints();
		gbc_btnMajorSeventh.fill = GridBagConstraints.BOTH;
		gbc_btnMajorSeventh.insets = new Insets(0, 0, 5, 0);
		gbc_btnMajorSeventh.gridx = 1;
		gbc_btnMajorSeventh.gridy = 5;
		btnMajorSeventh.setEnabled(false);
		contentPane.add(btnMajorSeventh, gbc_btnMajorSeventh);

		JButton btnTriTone = new JButton("Tri Tone");
		btnTriTone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				questions++;
				answer = 6;
				answerDisplay(lblListenToThe, answer);
			}
		});
		GridBagConstraints gbc_btnTriTone = new GridBagConstraints();
		gbc_btnTriTone.fill = GridBagConstraints.BOTH;
		gbc_btnTriTone.insets = new Insets(0, 0, 0, 5);
		gbc_btnTriTone.gridx = 0;
		gbc_btnTriTone.gridy = 6;
		btnTriTone.setEnabled(false);
		contentPane.add(btnTriTone, gbc_btnTriTone);

		JButton btnPerfectOctave = new JButton("Perfect Octave");
		btnPerfectOctave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				questions++;
				answer = 12;
				answerDisplay(lblListenToThe, answer);
			}
		});
		GridBagConstraints gbc_btnPerfectOctave = new GridBagConstraints();
		gbc_btnPerfectOctave.fill = GridBagConstraints.BOTH;
		gbc_btnPerfectOctave.gridx = 1;
		gbc_btnPerfectOctave.gridy = 6;
		btnPerfectOctave.setEnabled(false);
		contentPane.add(btnPerfectOctave, gbc_btnPerfectOctave);

		for(int x = 0; x < allowedIntervals.size(); x++)
		{
			switch(allowedIntervals.get(x))
			{
			case 1:
				enableButton(allowedIntervals.get(x), btnMinorSecond);
				break;
			case 2:
				enableButton(allowedIntervals.get(x), btnMajorSecond);
				break;
			case 3:
				enableButton(allowedIntervals.get(x), btnMinorThird);
				break;
			case 4:
				enableButton(allowedIntervals.get(x), btnMajorThird);
				break;
			case 5:
				enableButton(allowedIntervals.get(x), btnPerfectFourth);
				break;
			case 6:
				enableButton(allowedIntervals.get(x), btnTriTone);
				break;
			case 7:
				enableButton(allowedIntervals.get(x), btnPerfectFifth);
				break;
			case 8:
				enableButton(allowedIntervals.get(x), btnMinorSixth);
				break;
			case 9:
				enableButton(allowedIntervals.get(x), btnMajorSixth);
				break;
			case 10:
				enableButton(allowedIntervals.get(x), btnMinorSeventh);
				break;
			case 11:
				enableButton(allowedIntervals.get(x), btnMajorSeventh);
				break;
			case 12:
				enableButton(allowedIntervals.get(x), btnPerfectOctave);
				break;
			}
		}
	}

	public static ArrayList<Integer> determineIntervals(ArrayList<Integer> intervals)
	{
		ArrayList<Integer> allowedIntervals = new ArrayList<>();

		for(int x = 0; x < intervals.size(); x++)
		{
			if(intervals.get(x) == 1)
			{
				switch(x)
				{
				case 0:
					allowedIntervals.add(1);
					break;
				case 1:
					allowedIntervals.add(2);
					break;
				case 2:
					allowedIntervals.add(3);
					break;
				case 3:
					allowedIntervals.add(4);
					break;
				case 4:
					allowedIntervals.add(5);
					break;
				case 5:
					allowedIntervals.add(6);
					break;
				case 6:
					allowedIntervals.add(7);
					break;
				case 7:
					allowedIntervals.add(8);
					break;
				case 8:
					allowedIntervals.add(9);
					break;
				case 9:
					allowedIntervals.add(10);
					break;
				case 10:
					allowedIntervals.add(11);
					break;
				case 11:
					allowedIntervals.add(12);
					break;
				case 12:
					allowedIntervals.add(13);
					break;
				}
			}
		}
		return allowedIntervals;
	}

	public static void playInterval(int state, ArrayList<Integer> allowedIntervals, String playOrder) throws MidiUnavailableException
	{
		//Setup
		Synthesizer synth = MidiSystem.getSynthesizer();
		synth.open();

		final MidiChannel[] channel = synth.getChannels();
		Instrument[] instrument = synth.getDefaultSoundbank().getInstruments();
		synth.loadInstrument(instrument[90]);

		if(state == 1)	//Melodic Ascend
		{
			int start = setFirstNote();
			int firstNote = start;
			channel[1].noteOn(firstNote, 600);	//Play first note
			try {							//Thread sleep because melodic interval
				Thread.sleep(500);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}

			start = setSecondNote(firstNote, allowedIntervals, playOrder);
			int secondNote = start;
			channel[1].noteOn(secondNote, 600);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			channel[1].allNotesOff();
		}
		if(state == 2)	//Melodic Descend
		{
			int start = setFirstNote();
			int firstNote = start;

			channel[1].noteOn(firstNote, 600);	//Play first note
			try {							//Thread sleep because melodic interval
				Thread.sleep(500);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}

			start = setSecondNote(firstNote, allowedIntervals, playOrder);
			int secondNote = start;
			channel[1].noteOn(secondNote, 600);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			channel[1].allNotesOff();
		}
		if(state == 3)	//Harmonic
		{
			int start = setFirstNote();
			int firstNote = start;

			channel[1].noteOn(firstNote, 600);	//Play first note

			start = setSecondNote(firstNote, allowedIntervals, playOrder);
			int secondNote = start;
			channel[1].noteOn(secondNote, 600);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}

			channel[1].allNotesOff();
		}

	}

	public static int setFirstNote()
	{
		Integer firstNote;
		int note = SoundMidi.RandomInt(40, 88);//Want a decent range without going too low or too high
		firstNote = note;
		IntervalTrainerAural.firstNote = firstNote;

		return firstNote;
	}

	public static int setSecondNote(int firstNote, ArrayList<Integer> allowedIntervals, String state)
	{
		int secondNote = 0;
		if(state == "Ascending" || state == "Harmonic")
		{
			secondNote = allowedIntervals.get(SoundMidi.RandomInt(0, allowedIntervals.size() - 1));
			int note = firstNote + secondNote;
			secondNote = note;

		}

		if(state == "Descending")
		{
			secondNote = allowedIntervals.get(SoundMidi.RandomInt(0, allowedIntervals.size() - 1));
			int note = firstNote - secondNote;
			secondNote = note;
		}

		IntervalTrainerAural.secondNote = Math.abs(secondNote);
		return secondNote;
	}

	public void answerDisplay(JLabel label, int answerInt)
	{
		if(answerInt == interval)
		{
			label.setText("Correct!");
			correct++;
		}
		else
		{
			label.setText("Correct Answer: " + determineAnswerString(interval));
		}
	}
	
	public String displayResults()
	{
		return correct + " out of " + questions + " correct";
	}
	
	public String determineAnswerString(int answer)
	{
		String intervalString = "";
		switch(answer)
		{
		case 1:
			intervalString = "Minor Second";
			break;
		case 2:
			intervalString = "Major Second";
			break;
		case 3:
			intervalString = "Minor Third";
			break;
		case 4:
			intervalString = "Major Third";
			break;
		case 5:
			intervalString = "Perfect Fourth";
			break;
		case 6:
			intervalString = "Tri Tone";
			break;
		case 7:
			intervalString = "Perfect Fifth";
			break;
		case 8:
			intervalString = "Minor Sixth";
			break;
		case 9:
			intervalString = "Major Sixth";
			break;
		case 10:
			intervalString = "Minor Seventh";
			break;
		case 11:
			intervalString = "Major Seventh";
			break;
		case 12:
			intervalString = "Perfect Octave";
			break;
		}
		
		return intervalString;
	}
	
	public static void enableButton(int intervals, JButton button)
	{
		if(intervals == 1)
		{
			button.setEnabled(true);
		}
		if(intervals == 2)
		{
			button.setEnabled(true);
		}
		if(intervals == 3)
		{
			button.setEnabled(true);
		}
		if(intervals == 4)
		{
			button.setEnabled(true);
		}
		if(intervals == 5)
		{
			button.setEnabled(true);
		}
		if(intervals == 6)
		{
			button.setEnabled(true);
		}
		if(intervals == 7)
		{
			button.setEnabled(true);
		}
		if(intervals == 8)
		{
			button.setEnabled(true);
		}
		if(intervals == 9)
		{
			button.setEnabled(true);
		}
		if(intervals == 10)
		{
			button.setEnabled(true);
		}
		if(intervals == 11)
		{
			button.setEnabled(true);
		}
		if(intervals == 12)
		{
			button.setEnabled(true);
		}
	}
}
