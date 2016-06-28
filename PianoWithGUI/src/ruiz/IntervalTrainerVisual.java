package ruiz;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.imageio.ImageIO;
import javax.print.DocFlavor.INPUT_STREAM;
import javax.sound.midi.MidiUnavailableException;
import javax.swing.ImageIcon;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class IntervalTrainerVisual extends JFrame {

	private JPanel contentPane;
	private Image treble;
	private Image sharp;
	private Image flat;
	private static int firstNote;
	private static int secondNote;
	private static String firstNoteNameSimple;
	private static String secondNoteNameSimple;
	private static String firstNoteName;
	private static String secondNoteName;
	private static String tableLookup;
	private static int halfSteps;
	private static int answer;
	private static String interval;
	private static int questions = 0;
	private static int correct = 0;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IntervalTrainerVisual frame = new IntervalTrainerVisual();
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
	public IntervalTrainerVisual() {
	}

	public IntervalTrainerVisual(String playType, ArrayList<Integer> intervals, int numberQuestions) throws MidiUnavailableException
	{
		super();

		ArrayList<NoteClassification> notesList = new ArrayList<>();
		notesList.add(new NoteClassification("B#", "C"));
		notesList.add(new NoteClassification("C#", "Db"));
		notesList.add(new NoteClassification("D", "D"));
		notesList.add(new NoteClassification("D#", "Eb"));
		notesList.add(new NoteClassification("E", "Fb"));
		notesList.add(new NoteClassification("E#", "F"));
		notesList.add(new NoteClassification("F#", "Gb"));
		notesList.add(new NoteClassification("G", "G"));
		notesList.add(new NoteClassification("G#", "Ab"));
		notesList.add(new NoteClassification("A", "A"));
		notesList.add(new NoteClassification("A#", "Bb"));
		notesList.add(new NoteClassification("B", "Cb"));
		notesList.add(new NoteClassification("B#", "C"));
		notesList.add(new NoteClassification("C#", "Db"));
		notesList.add(new NoteClassification("D", "D"));
		notesList.add(new NoteClassification("D#", "Eb"));
		notesList.add(new NoteClassification("E", "Fb"));
		notesList.add(new NoteClassification("E#", "F"));
		notesList.add(new NoteClassification("F#", "Gb"));
		notesList.add(new NoteClassification("G", "G"));
		notesList.add(new NoteClassification("G#", "Ab"));
		notesList.add(new NoteClassification("A", "A"));

		ArrayList<String> intervalsList = new ArrayList<>();
		intervalsList.add("Second");
		intervalsList.add("Second");
		intervalsList.add("Third");
		intervalsList.add("Third");
		intervalsList.add("Fourth");
		intervalsList.add("TriTone");
		intervalsList.add("Fifth");
		intervalsList.add("Sixth");
		intervalsList.add("Sixth");
		intervalsList.add("Seventh");
		intervalsList.add("Seventh");
		intervalsList.add("Eighth");

		LinkedList orderOfSecondsLL = new LinkedList();
		orderOfSecondsLL.insertAtEnd("C");
		orderOfSecondsLL.insertAtEnd("D");
		orderOfSecondsLL.insertAtEnd("E");
		orderOfSecondsLL.insertAtEnd("F");
		orderOfSecondsLL.insertAtEnd("G");
		orderOfSecondsLL.insertAtEnd("A");
		orderOfSecondsLL.insertAtEnd("B");

		LinkedList orderOfThirdsLL = new LinkedList();
		orderOfThirdsLL.insertAtEnd("C");
		orderOfThirdsLL.insertAtEnd("E");
		orderOfThirdsLL.insertAtEnd("G");
		orderOfThirdsLL.insertAtEnd("B");
		orderOfThirdsLL.insertAtEnd("D");
		orderOfThirdsLL.insertAtEnd("F");
		orderOfThirdsLL.insertAtEnd("A");

		LinkedList orderOfFourthsLL = new LinkedList();
		orderOfFourthsLL.insertAtEnd("C");
		orderOfFourthsLL.insertAtEnd("F");
		orderOfFourthsLL.insertAtEnd("B");
		orderOfFourthsLL.insertAtEnd("E");
		orderOfFourthsLL.insertAtEnd("A");
		orderOfFourthsLL.insertAtEnd("D");
		orderOfFourthsLL.insertAtEnd("G");

		LinkedList orderOfFifthsLL = new LinkedList();
		orderOfFifthsLL.insertAtEnd("C");
		orderOfFifthsLL.insertAtEnd("G");
		orderOfFifthsLL.insertAtEnd("D");
		orderOfFifthsLL.insertAtEnd("A");
		orderOfFifthsLL.insertAtEnd("E");
		orderOfFifthsLL.insertAtEnd("B");
		orderOfFifthsLL.insertAtEnd("F");

		LinkedList orderOfSixthsLL = new LinkedList();
		orderOfSixthsLL.insertAtEnd("C");
		orderOfSixthsLL.insertAtEnd("A");
		orderOfSixthsLL.insertAtEnd("F");
		orderOfSixthsLL.insertAtEnd("D");
		orderOfSixthsLL.insertAtEnd("B");
		orderOfSixthsLL.insertAtEnd("G");
		orderOfSixthsLL.insertAtEnd("E");

		LinkedList orderOfSeventhsLL = new LinkedList();
		orderOfSeventhsLL.insertAtEnd("C");
		orderOfSeventhsLL.insertAtEnd("B");
		orderOfSeventhsLL.insertAtEnd("A");
		orderOfSeventhsLL.insertAtEnd("G");
		orderOfSeventhsLL.insertAtEnd("F");
		orderOfSeventhsLL.insertAtEnd("E");
		orderOfSeventhsLL.insertAtEnd("D");

		int randomNoteForm = SoundMidi.RandomInt(0, 1);
		int i = 0;
		String testNote = String.valueOf(notesList.get(0).returnOneNote(randomNoteForm).charAt(i));

		while(!testNote.equals(orderOfSecondsLL.getElement(i)))
		{
			i++;
		}

		ArrayList<Integer> allowedIntervals = IntervalTrainerAural.determineIntervals(intervals);
		int restriction = allowedIntervals.get(allowedIntervals.size() - 1);

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 869, 715);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] {421, 421, 0};
		gbl_contentPane.rowHeights = new int[] {200, 80, 80, 80, 80, 80, 80};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);

		JButton btnGenerateInterval = new JButton("Generate Interval");

		btnGenerateInterval.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(questions > numberQuestions - 1)
				{
					setVisible(false);
					JOptionPane.showMessageDialog(null, displayResults());
				}
			}
		});

		btnGenerateInterval.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int answer = 0;
				setFirstNote(restriction);
				setSecondNote(firstNote, allowedIntervals);
				halfSteps = secondNote - firstNote;
				switch(halfSteps)
				{
				case 1:
					interval = "Minor Second";
					break;
				case 2:
					interval = "Major Second";
					break;
				case 3:
					interval = "Minor Third";
					break;
				case 4:
					interval = "Major Third";
					break;
				case 5:
					interval = "Perfect Fourth";
					break;
				case 6:
					interval = "TriTone";
					break;
				case 7:
					interval = "Perfect Fifth";
					break;
				case 8:
					interval = "Minor Sixth";
					break;
				case 9:
					interval = "Major Sixth";
					break;
				case 10:
					interval = "Minor Seventh";
					break;
				case 11:
					interval = "Major Seventh";
					break;
				case 12:
					interval = "Perfect Octave";
					break;
				}

				int randomInt = SoundMidi.RandomInt(0, 1);

				for(int x = 0; x <= (firstNote - 60); x++)
				{
					if(x == (firstNote - 60))
					{
						firstNoteName = notesList.get(x).returnOneNote(randomInt);
						firstNoteNameSimple = notesList.get(x).cutName(notesList.get(x).returnOneNote(randomInt));
					}
				}

				for(int x = 0; x < intervalsList.size() + 1; x++)
				{
					if(x == halfSteps)
					{
						tableLookup = intervalsList.get(x - 1);
						break;
					}
				}

				int x = 0;
				switch(tableLookup)
				{
				case "Second":
					x = 0;
					while(!firstNoteNameSimple.equals(orderOfSecondsLL.getElement(x)))
					{
						x++;
					}
					secondNoteNameSimple = (String) orderOfSecondsLL.getElement(x + 1);
					break;
				case "Third":
					x = 0;
					while(!firstNoteNameSimple.equals(orderOfThirdsLL.getElement(x)))
					{
						x++;
					}
					secondNoteNameSimple = (String) orderOfThirdsLL.getElement(x + 1);
					break;
				case "Fourth":
					x = 0;
					while(!firstNoteNameSimple.equals(orderOfFourthsLL.getElement(x)))
					{
						x++;
					}
					secondNoteNameSimple = (String) orderOfFourthsLL.getElement(x + 1);
					break;
				case "TriTone":
					x = 0;
					while(!firstNoteNameSimple.equals(orderOfFourthsLL.getElement(x)))
					{
						x++;
					}
					secondNoteNameSimple = (String) orderOfFourthsLL.getElement(x + 1);
					break;
				case "Fifth":
					x = 0;
					while(!firstNoteNameSimple.equals(orderOfFifthsLL.getElement(x)))
					{
						x++;
					}
					secondNoteNameSimple = (String) orderOfFifthsLL.getElement(x + 1);
					break;
				case "Sixth":
					x = 0;
					while(!firstNoteNameSimple.equals(orderOfSixthsLL.getElement(x)))
					{
						x++;
					}
					secondNoteNameSimple = (String) orderOfSixthsLL.getElement(x + 1);
					break;
				case "Seventh":
					x = 0;
					while(!firstNoteNameSimple.equals(orderOfSeventhsLL.getElement(x)))
					{
						x++;
					}
					secondNoteNameSimple = (String) orderOfSeventhsLL.getElement(x + 1);
					break;
				case "Eighth":
					x = 0;
					JOptionPane.showMessageDialog(null, firstNoteName);
					secondNoteName = firstNoteName;
					break;
				default:
					break;
				}



				for(int s = 0; s <= (secondNote - 60); s++)
				{
					if(halfSteps == 12)
					{
						break;
					}
					if(s == (secondNote - 60))
					{
						String tempOne = notesList.get(s).cutName(notesList.get(s).returnOneNote(0));
						String tempTwo = notesList.get(s).cutName(notesList.get(s).returnOneNote(1));

						if(secondNoteNameSimple.equals(tempOne))
						{
							secondNoteName = notesList.get(s).returnOneNote(0);
						}
						else if(secondNoteNameSimple.equals(tempTwo))
						{
							secondNoteName = notesList.get(s).returnOneNote(1);
						}
						else
						{
							JOptionPane.showMessageDialog(null, "No match");

							tempOne = notesList.get(s - 1).cutName(notesList.get(s - 1).returnOneNote(0));
							tempTwo = notesList.get(s - 1).cutName(notesList.get(s - 1).returnOneNote(1));

							if(secondNoteNameSimple.equals(tempOne))
							{
								secondNoteName = notesList.get(s - 1).returnOneNote(0);
							}
							else if(secondNoteNameSimple.equals(tempTwo))
							{
								secondNoteName = notesList.get(s - 1).returnOneNote(1);
							}	
						}
					}
				}

				//JOptionPane.showMessageDialog(null, "Generated Num: " + randomInt + "\nFirst Note: " + firstNote + "\nSecond Note: " + secondNote + "\nFirst Note Name: " + firstNoteName + "\nSecond Note Name: " + secondNoteName + "\nHalf Steps: " + halfSteps + "\nTable Used: " + tableLookup + "\nInterval" + interval);
				repaint();
			}
		});

		GridBagConstraints gbc_btnGenerateInterval = new GridBagConstraints();
		gbc_btnGenerateInterval.fill = GridBagConstraints.BOTH;
		gbc_btnGenerateInterval.insets = new Insets(0, 0, 5, 0);
		gbc_btnGenerateInterval.gridx = 1;
		gbc_btnGenerateInterval.gridy = 0;
		contentPane.add(btnGenerateInterval, gbc_btnGenerateInterval);

		JButton btnMinorSecond = new JButton("Minor Second");
		btnMinorSecond.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				questions++;
				answer = 1;
				answerDisplay(answer);
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
				answerDisplay(answer);
			}
		});
		GridBagConstraints gbc_btnPerfectFifth = new GridBagConstraints();
		gbc_btnPerfectFifth.insets = new Insets(0, 0, 5, 0);
		gbc_btnPerfectFifth.fill = GridBagConstraints.BOTH;
		gbc_btnPerfectFifth.gridx = 1;
		gbc_btnPerfectFifth.gridy = 1;
		btnPerfectFifth.setEnabled(false);
		contentPane.add(btnPerfectFifth, gbc_btnPerfectFifth);

		JButton btnMajorSecond = new JButton("Major Second");
		btnMajorSecond.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				questions++;
				answer = 2;
				answerDisplay(answer);
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
				answerDisplay(answer);
			}
		});
		GridBagConstraints gbc_btnMinorSixth = new GridBagConstraints();
		gbc_btnMinorSixth.insets = new Insets(0, 0, 5, 0);
		gbc_btnMinorSixth.fill = GridBagConstraints.BOTH;
		gbc_btnMinorSixth.gridx = 1;
		gbc_btnMinorSixth.gridy = 2;
		btnMinorSixth.setEnabled(false);
		contentPane.add(btnMinorSixth, gbc_btnMinorSixth);

		JButton btnMinorThird = new JButton("Minor Third");
		btnMinorThird.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				questions++;
				answer = 3;
				answerDisplay(answer);
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
				answerDisplay(answer);
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
				answerDisplay(answer);
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
				answerDisplay(answer);
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
				answerDisplay(answer);
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
				answerDisplay(answer);
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
				answerDisplay(answer);
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
				answerDisplay(answer);
			}
		});
		GridBagConstraints gbc_btnPerfectOctave = new GridBagConstraints();
		gbc_btnPerfectOctave.fill = GridBagConstraints.BOTH;
		gbc_btnPerfectOctave.gridx = 1;
		gbc_btnPerfectOctave.gridy = 6;
		btnPerfectOctave.setEnabled(false);
		contentPane.add(btnPerfectOctave, gbc_btnPerfectOctave);

		URL urlTreble = this.getClass().getResource("/res/trebleSmall.png");
		treble = Toolkit.getDefaultToolkit().getImage(urlTreble);
		URL urlSharp = this.getClass().getResource("/res/sharp.png");
		sharp = Toolkit.getDefaultToolkit().getImage(urlSharp);
		URL urlFlat = this.getClass().getResource("/res/flat.png");
		flat = Toolkit.getDefaultToolkit().getImage(urlFlat);
		
		setBackground(Color.WHITE);

		for(int x = 0; x < allowedIntervals.size(); x++)
		{
			switch(allowedIntervals.get(x))
			{
			case 1:
				IntervalTrainerAural.enableButton(allowedIntervals.get(x), btnMinorSecond);
				break;
			case 2:
				IntervalTrainerAural.enableButton(allowedIntervals.get(x), btnMajorSecond);
				break;
			case 3:
				IntervalTrainerAural.enableButton(allowedIntervals.get(x), btnMinorThird);
				break;
			case 4:
				IntervalTrainerAural.enableButton(allowedIntervals.get(x), btnMajorThird);
				break;
			case 5:
				IntervalTrainerAural.enableButton(allowedIntervals.get(x), btnPerfectFourth);
				break;
			case 6:
				IntervalTrainerAural.enableButton(allowedIntervals.get(x), btnTriTone);
				break;
			case 7:
				IntervalTrainerAural.enableButton(allowedIntervals.get(x), btnPerfectFifth);
				break;
			case 8:
				IntervalTrainerAural.enableButton(allowedIntervals.get(x), btnMinorSixth);
				break;
			case 9:
				IntervalTrainerAural.enableButton(allowedIntervals.get(x), btnMajorSixth);
				break;
			case 10:
				IntervalTrainerAural.enableButton(allowedIntervals.get(x), btnMinorSeventh);
				break;
			case 11:
				IntervalTrainerAural.enableButton(allowedIntervals.get(x), btnMajorSeventh);
				break;
			case 12:
				IntervalTrainerAural.enableButton(allowedIntervals.get(x), btnPerfectOctave);
				break;
			}
		}
	}

	public void paint(Graphics g)
	{
		int width = getWidth();
		int height = getHeight();

		super.paintComponents(g);

		//Draw sheet music lines
		g.fillRect(20, 75, 400, 3);
		g.fillRect(20, 100, 400, 3);
		g.fillRect(20, 125, 400, 3);
		g.fillRect(20, 150, 400, 3);
		g.fillRect(20, 175, 400, 3);

		//Draw treble clef
		g.drawImage(treble, 0, 10, null);

		//Main Notes

		paintNoteGeneral(firstNote, firstNoteName, g);
		paintNoteGeneral(secondNote, secondNoteName, g);
	}

	////////////////////////Start of Note Printing//////////////////////////////////	

	public void paintNote60(Graphics g, int choice)
	{
		revalidate();
		if(choice == 0)	//B#
		{
			g.fillOval(150, 199, 23, 17);
			g.fillRect(146, 197, 32, 3);
			g.drawImage(sharp, 115, 183, null);	
		}

		if(choice == 1)//C
		{
			g.fillOval(150, 192, 23, 17);
			g.fillRect(146, 199, 32, 3);
		}
	}

	public void paintNote61(Graphics g, int choice)
	{
		revalidate();
		if(choice == 0)//C#
		{
			g.fillOval(150, 192, 23, 17);
			g.fillRect(146, 199, 32, 3);
			g.drawImage(sharp, 115, 177, null);
		}
		if(choice == 1)//Db
		{
			g.fillOval(150, 180, 23, 17);
			g.drawImage(flat, 117, 158, null);
		}
	}

	public void paintNote62(Graphics g)
	{
		revalidate();
		//D
		g.fillOval(150, 180, 23, 17);
	}

	public void paintNote63(Graphics g, int choice)
	{
		revalidate();
		if(choice == 0)//D#
		{
			g.fillOval(150, 180, 23, 17);
			g.drawImage(sharp, 115, 165, null);
		}

		if(choice == 1)//Eb
		{
			g.fillOval(150, 168, 23, 17);
			g.drawImage(flat, 115, 147, null);
		}
	}

	public void paintNote64(Graphics g, int choice)
	{
		revalidate();
		if(choice == 0)//E
		{
			g.fillOval(150, 168, 23, 17);
		}


		if(choice == 1)//Fb
		{
			g.fillOval(150, 155, 23, 17);
			g.drawImage(flat, 115, 134, null);
		}

	}

	public void paintNote65(Graphics g, int choice)
	{
		revalidate();
		if(choice == 0)//E#
		{
			g.fillOval(150, 168, 23, 17);
			g.drawImage(sharp, 115, 153, null);
		}

		if(choice == 1)//F
		{
			g.fillOval(150, 155, 23, 17);
		}

	}

	public void paintNote66(Graphics g, int choice)
	{
		revalidate();
		if(choice == 0)//F#
		{
			g.fillOval(150, 155, 23, 17);
			g.drawImage(sharp, 115, 140, null);
		}

		if(choice == 1)//Gb
		{
			g.fillOval(150, 143, 23, 17);
			g.drawImage(flat, 115, 123, null);
		}

	}

	public void paintNote67(Graphics g)
	{
		revalidate();
		//G
		g.fillOval(150, 143, 23, 17);
	}

	public void paintNote68(Graphics g, int choice)
	{
		revalidate();
		if(choice == 0)//G#
		{
			g.fillOval(150, 143, 23, 17);
			g.drawImage(sharp, 115, 125, null);
		}


		if(choice == 1)//Ab
		{
			g.fillOval(150, 130, 23, 17);
			g.drawImage(flat, 115, 111, null);
		}

	}

	public void paintNote69(Graphics g)
	{
		revalidate();
		//A
		g.fillOval(150, 130, 23, 17);
	}

	public void paintNote70(Graphics g, int choice)
	{
		revalidate();
		if(choice == 0)//A#
		{
			g.fillOval(150, 130, 23, 17);
			g.drawImage(sharp, 115, 115, null);
		}

		if(choice == 1)//Bb
		{
			g.fillOval(150, 118, 23, 17);
			g.drawImage(flat, 115, 98, null);
		}
	}

	public void paintNote71(Graphics g, int choice)
	{
		revalidate();
		if(choice == 0)//B
		{
			g.fillOval(150, 118, 23, 17);
		}

		if(choice == 1)//Cb
		{
			g.fillOval(150, 105, 23, 17);
			g.drawImage(flat, 115, 84, null);
		}
	}

	public void paintNote72(Graphics g, int choice)
	{
		revalidate();
		if(choice == 0)//B#
		{
			g.fillOval(150, 118, 23, 17);
			g.drawImage(sharp, 115, 101, null);
		}

		if(choice == 1)//C
		{
			g.fillOval(150, 105, 23, 17);
		}


	}

	public void paintNote73(Graphics g, int choice)
	{
		revalidate();
		if(choice == 0)//C#
		{
			g.fillOval(150, 105, 23, 17);
			g.drawImage(sharp, 115, 89, null);
		}

		if(choice == 1)//Db
		{
			g.fillOval(150, 93, 23, 17);
			g.drawImage(flat, 115, 73, null);
		}
	}


	public void paintNote74(Graphics g)
	{
		revalidate();
		//D
		g.fillOval(150, 93, 23, 17);
	}

	public void paintNote75(Graphics g, int choice)
	{
		revalidate();
		if(choice == 0)//D#
		{
			g.fillOval(150, 93, 23, 17);
			g.drawImage(sharp, 115, 76, null);
		}

		if(choice == 1)//Eb
		{
			g.fillOval(150, 80, 23, 17);
			g.drawImage(flat, 115, 60, null);
		}
	}

	public void paintNote76(Graphics g, int choice)
	{
		revalidate();
		if(choice == 0)//E
		{
			g.fillOval(150, 80, 23, 17);
		}

		if(choice == 1)//Fb
		{
			g.fillOval(150, 68, 23, 17);
			g.drawImage(flat, 115, 48, null);
		}
	}

	public void paintNote77(Graphics g, int choice)
	{
		revalidate();
		if(choice == 0)//E#
		{
			g.fillOval(150, 80, 23, 17);
			g.drawImage(sharp, 115, 65, null);
		}

		if(choice == 1)//F
		{
			g.fillOval(150, 68, 23, 17);
		}
	}

	public void paintNote78(Graphics g, int choice)
	{
		revalidate();
		if(choice == 0)//F#
		{
			g.fillOval(150, 68, 23, 17);
			g.drawImage(sharp, 115, 49, null);
		}

		if(choice == 1)//Gb 
		{
			g.fillOval(150, 56, 23, 17);
			g.drawImage(flat, 115, 36, null);
		}
	}

	public void paintNote79(Graphics g)
	{
		revalidate();
		//G
		g.fillOval(150, 56, 23, 17);
	}

	public void paintNote80(Graphics g, int choice)
	{
		revalidate();
		if(choice == 0)//G#
		{
			g.fillOval(150, 56, 23, 17);
			g.drawImage(sharp, 115, 38, null);
		}


		if(choice == 1)//Ab
		{
			g.fillOval(150, 45, 23, 17);
			g.fillRect(146, 52, 32, 3);
			g.drawImage(flat, 115, 24, null);
		}
	}

	public void paintNote81(Graphics g)
	{
		revalidate();
		//A
		g.fillOval(150, 45, 23, 17);
		g.fillRect(146, 52, 32, 3);
	}

	//////////////////////End of Note Print///////////////////////////////////	

	public static int setFirstNote(int restriction)
	{
		int firstNote = 0;
		int note = 0;

		switch(restriction)
		{
		case 1:
			note = SoundMidi.RandomInt(60, 80);
			firstNote = note;
			IntervalTrainerVisual.firstNote = firstNote;
			break;
		case 2:
			note = SoundMidi.RandomInt(60, 79);
			firstNote = note;
			IntervalTrainerVisual.firstNote = firstNote;
			break;
		case 3:
			note = SoundMidi.RandomInt(60, 78);
			firstNote = note;
			IntervalTrainerVisual.firstNote = firstNote;
			break;
		case 4:
			note = SoundMidi.RandomInt(60, 77);
			firstNote = note;
			IntervalTrainerVisual.firstNote = firstNote;
			break;
		case 5:
			note = SoundMidi.RandomInt(60, 76);
			firstNote = note;
			IntervalTrainerVisual.firstNote = firstNote;
			break;
		case 6:
			note = SoundMidi.RandomInt(60, 75);
			firstNote = note;
			IntervalTrainerVisual.firstNote = firstNote;
			break;
		case 7:
			note = SoundMidi.RandomInt(60, 74);
			firstNote = note;
			IntervalTrainerVisual.firstNote = firstNote;
			break;
		case 8:
			note = SoundMidi.RandomInt(60, 73);
			firstNote = note;
			IntervalTrainerVisual.firstNote = firstNote;
			break;
		case 9:
			note = SoundMidi.RandomInt(60, 72);
			firstNote = note;
			IntervalTrainerVisual.firstNote = firstNote;
			break;
		case 10:
			note = SoundMidi.RandomInt(60, 71);
			firstNote = note;
			IntervalTrainerVisual.firstNote = firstNote;
			break;
		case 11:
			note = SoundMidi.RandomInt(60, 70);
			firstNote = note;
			IntervalTrainerVisual.firstNote = firstNote;
			break;
		case 12:
			note = SoundMidi.RandomInt(60, 69);
			firstNote = note;
			IntervalTrainerVisual.firstNote = firstNote;
			break;
		}
		/*int note = SoundMidi.RandomInt(60, 81);//Default Middle C to A an octave above
		firstNote = note;
		IntervalTrainerVisual.firstNote = firstNote;*/
		return firstNote;
	}

	public static int setSecondNote(int firstNote, ArrayList<Integer> allowedIntervals)
	{
		int secondNote = 0;
		secondNote = allowedIntervals.get(SoundMidi.RandomInt(0, allowedIntervals.size() - 1));
		int note = firstNote + secondNote;
		secondNote = note;

		IntervalTrainerVisual.secondNote = Math.abs(secondNote);
		return secondNote;
	}
	
	public void answerDisplay(int answer)
	{
		if(answer == halfSteps)
		{
			JOptionPane.showMessageDialog(null, "Correct");
			correct++;
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Correct Answer:" + determineAnswerString(halfSteps));
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
	
	public void paintNoteGeneral(int noteInt, String noteString, Graphics g)
	{
		switch(noteInt)
		{
		case 60:
			if(noteString.equals("B#"))
			{
				paintNote60(g, 0);
			}
			else if(noteString.equals("C"))
			{
				paintNote60(g, 1);
			}
			break;
		case 61:
			if(noteString.equals("C#"))
			{
				paintNote61(g, 0);
			}
			else if(noteString.equals("Db"))
			{
				paintNote61(g, 1);
			}
			break;
		case 62:
			paintNote62(g);
			break;
		case 63:
			if(noteString.equals("D#"))
			{
				paintNote63(g, 0);
			}
			else if(noteString.equals("Eb"))
			{
				paintNote63(g, 1);
			}
			break;
		case 64:
			if(noteString.equals("E"))
			{
				paintNote64(g, 0);
			}
			else if(noteString.equals("Fb"))
			{
				paintNote64(g, 1);
			}
			break;
		case 65:
			if(noteString.equals("E#"))
			{
				paintNote65(g, 0);
			}
			else if(noteString.equals("F"))
			{
				paintNote65(g, 1);
			}
			break;
		case 66:
			if(noteString.equals("F#"))
			{
				paintNote66(g, 0);
			}
			else if(noteString.equals("Gb"))
			{
				paintNote66(g, 1);
			}
			break;
		case 67:
			paintNote67(g);
			break;
		case 68:
			if(noteString.equals("G#"))
			{
				paintNote68(g, 0);
			}
			else if(noteString.equals("Ab"))
			{
				paintNote68(g, 1);
			}
			break;
		case 69:
			paintNote69(g);
			break;
		case 70:
			if(noteString.equals("A#"))
			{
				paintNote70(g, 0);
			}
			else if(noteString.equals("Bb"))
			{
				paintNote70(g, 1);
			}
			break;
		case 71:
			if(noteString.equals("B"))
			{
				paintNote71(g, 0);
			}
			else if(noteString.equals("Cb"))
			{
				paintNote71(g, 1);
			}
			break;
		case 72:
			if(noteString.equals("B"))
			{
				paintNote72(g, 0);
			}
			else if(noteString.equals("Cb"))
			{
				paintNote72(g, 1);
			}
			break;
		case 73:
			if(noteString.equals("C#"))
			{
				paintNote73(g, 0);
			}
			else if(noteString.equals("Db"))
			{
				paintNote73(g, 1);
			}
			break;
		case 74:
			paintNote74(g);
			break;
		case 75:
			if(noteString.equals("D#"))
			{
				paintNote75(g, 0);
			}
			else if(noteString.equals("Eb"))
			{
				paintNote75(g, 1);
			}
			break;
		case 76:
			if(noteString.equals("E"))
			{
				paintNote76(g, 0);
			}
			else if(noteString.equals("Fb"))
			{
				paintNote76(g, 1);
			}
			break;
		case 77:
			if(noteString.equals("E#"))
			{
				paintNote77(g, 0);
			}
			else if(noteString.equals("F"))
			{
				paintNote77(g, 1);
			}
			break;
		case 78:
			if(noteString.equals("F#"))
			{
				paintNote78(g, 0);
			}
			else if(noteString.equals("Gb"))
			{
				paintNote78(g, 1);
			}
			break;
		case 79:
			paintNote79(g);
			break;
		case 80:
			if(noteString.equals("G#"))
			{
				paintNote80(g, 0);
			}
			else if(noteString.equals("Ab"))
			{
				paintNote80(g, 1);
			}
			break;
		case 81:
			paintNote81(g);
			break;
		default:
			break;
		}
	}
}
