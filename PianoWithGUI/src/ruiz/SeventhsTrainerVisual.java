package ruiz;

import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.GridBagLayout;
import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class SeventhsTrainerVisual extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Image treble;
	private Image sharp;
	private Image flat;
	private static int firstNote;
	private static int secondNote;
	private static int thirdNote;
	private static int fourthNote;
	private static String firstNoteNameSimple;
	private static String secondNoteNameSimple;
	private static String thirdNoteNameSimple;
	private static String fourthNoteNameSimple;
	private static String firstNoteName;
	private static String secondNoteName;
	private static String thirdNoteName;
	private static String fourthNoteName;
	private static String answer;
	private static String seventh;
	private static int questions = 0;
	private static int correct = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SeventhsTrainerVisual frame = new SeventhsTrainerVisual();
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
	public SeventhsTrainerVisual() {
		
	}
	
	public SeventhsTrainerVisual(ArrayList<Integer> sevenths, int numberQuestions)
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
		
		LinkedList orderOfThirdsLL = new LinkedList();
		orderOfThirdsLL.insertAtEnd("C");
		orderOfThirdsLL.insertAtEnd("E");
		orderOfThirdsLL.insertAtEnd("G");
		orderOfThirdsLL.insertAtEnd("B");
		orderOfThirdsLL.insertAtEnd("D");
		orderOfThirdsLL.insertAtEnd("F");
		orderOfThirdsLL.insertAtEnd("A");
		
		ArrayList<String> allowedSevenths = determineSevenths(sevenths);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 869, 486);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] {421, 421, 0};
		gbl_contentPane.rowHeights = new int[] {200, 80, 80, 80, 80};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JButton btnGenerateSeventh = new JButton("Generate Seventh");
		
		btnGenerateSeventh.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(questions > numberQuestions - 1)
				{
					setVisible(false);
					JOptionPane.showMessageDialog(null, displayResults());
				}
			}
		});
		
		btnGenerateSeventh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				firstNote = generateFirstNote();
				
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
				else if(playThis == "Half-Diminished Seventh")
				{
					secondNote = setNextNoteMinorThird(firstNote);
					thirdNote = setNextNoteMinorThird(secondNote);
					fourthNote = setNextNoteMajorThird(thirdNote);
				}
				else if(playThis == "Fully-Diminished Seventh")
				{
					secondNote = setNextNoteMinorThird(firstNote);
					thirdNote = setNextNoteMinorThird(secondNote);
					fourthNote = setNextNoteMinorThird(thirdNote);
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
				
				int x = 0;
				while(!firstNoteNameSimple.equals(orderOfThirdsLL.getElement(x)))
				{
					x++;
				}
				secondNoteNameSimple = (String) orderOfThirdsLL.getElement(x + 1);
				
				x = 0;
				while(!secondNoteNameSimple.equals(orderOfThirdsLL.getElement(x)))
				{
					x++;
				}
				thirdNoteNameSimple = (String) orderOfThirdsLL.getElement(x + 1);
				
				x = 0;
				while(!thirdNoteNameSimple.equals(orderOfThirdsLL.getElement(x)))
				{
					x++;
				}
				fourthNoteNameSimple = (String) orderOfThirdsLL.getElement(x + 1);
				
				for(int s = 0; s <= (secondNote - 60); s++)
				{
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
					}
				}
				
				for(int s = 0; s <= (thirdNote - 60); s++)
				{
					if(s == (thirdNote - 60))
					{
						String tempOne = notesList.get(s).cutName(notesList.get(s).returnOneNote(0));
						String tempTwo = notesList.get(s).cutName(notesList.get(s).returnOneNote(1));

						if(thirdNoteNameSimple.equals(tempOne))
						{
							thirdNoteName = notesList.get(s).returnOneNote(0);
						}
						else if(thirdNoteNameSimple.equals(tempTwo))
						{
							thirdNoteName = notesList.get(s).returnOneNote(1);
						}
					}
				}
				
				for(int s = 0; s <= (fourthNote - 60); s++)
				{
					if(s == (fourthNote - 60))
					{
						String tempOne = notesList.get(s).cutName(notesList.get(s).returnOneNote(0));
						String tempTwo = notesList.get(s).cutName(notesList.get(s).returnOneNote(1));

						if(fourthNoteNameSimple.equals(tempOne))
						{
							fourthNoteName = notesList.get(s).returnOneNote(0);
						}
						else if(fourthNoteNameSimple.equals(tempTwo))
						{
							fourthNoteName = notesList.get(s).returnOneNote(1);
						}
					}
				}
				
				repaint();
				
				//JOptionPane.showMessageDialog(null, playThis + "\n" + firstNoteName + " " + firstNoteNameSimple + "\n" + secondNoteName + " " + secondNoteNameSimple + "\n" + thirdNoteName + " " + thirdNoteNameSimple + "\n" + fourthNoteName + " " + fourthNoteNameSimple);
				//JOptionPane.showMessageDialog(null, playThis + "\n" + firstNoteName + " " + secondNoteName + " " + thirdNoteName + "\n" + firstNoteNameSimple + " " + secondNoteNameSimple + " " + thirdNoteNameSimple);
				//repaint();
			}
		});
		GridBagConstraints gbc_btnGenerateSeventh = new GridBagConstraints();
		gbc_btnGenerateSeventh.fill = GridBagConstraints.BOTH;
		gbc_btnGenerateSeventh.insets = new Insets(0, 0, 5, 0);
		gbc_btnGenerateSeventh.gridx = 1;
		gbc_btnGenerateSeventh.gridy = 0;
		contentPane.add(btnGenerateSeventh, gbc_btnGenerateSeventh);
		
		JButton btnMajorSeventh = new JButton("Major Seventh");
		btnMajorSeventh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				questions++;
				answer = "Major Seventh";
				answerDisplay(answer);
			}
		});
		GridBagConstraints gbc_btnMajorSeventh = new GridBagConstraints();
		gbc_btnMajorSeventh.fill = GridBagConstraints.BOTH;
		gbc_btnMajorSeventh.insets = new Insets(0, 0, 5, 5);
		gbc_btnMajorSeventh.gridx = 0;
		gbc_btnMajorSeventh.gridy = 1;
		btnMajorSeventh.setEnabled(false);
		contentPane.add(btnMajorSeventh, gbc_btnMajorSeventh);
		
		JButton btnMinorSeventh = new JButton("Minor Seventh");
		btnMinorSeventh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				questions++;
				answer = "Minor Seventh";
				answerDisplay(answer);
			}
		});
		GridBagConstraints gbc_btnMinorSeventh = new GridBagConstraints();
		gbc_btnMinorSeventh.fill = GridBagConstraints.BOTH;
		gbc_btnMinorSeventh.insets = new Insets(0, 0, 5, 0);
		gbc_btnMinorSeventh.gridx = 1;
		gbc_btnMinorSeventh.gridy = 1;
		btnMinorSeventh.setEnabled(false);
		contentPane.add(btnMinorSeventh, gbc_btnMinorSeventh);
		
		JButton btnDominantSeventh = new JButton("Dominant Seventh");
		btnDominantSeventh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				questions++;
				answer = "Dominant Seventh";
				answerDisplay(answer);
			}
		});
		GridBagConstraints gbc_btnDominantSeventh = new GridBagConstraints();
		gbc_btnDominantSeventh.fill = GridBagConstraints.BOTH;
		gbc_btnDominantSeventh.insets = new Insets(0, 0, 5, 5);
		gbc_btnDominantSeventh.gridx = 0;
		gbc_btnDominantSeventh.gridy = 2;
		btnDominantSeventh.setEnabled(false);
		contentPane.add(btnDominantSeventh, gbc_btnDominantSeventh);
		
		JButton btnHalfDiminishedSeventh = new JButton("Half-Diminished Seventh");
		btnHalfDiminishedSeventh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				questions++;
				answer = "Half-Diminished Seventh";
				answerDisplay(answer);
			}
		});
		GridBagConstraints gbc_btnHalfDiminishedSeventh = new GridBagConstraints();
		gbc_btnHalfDiminishedSeventh.fill = GridBagConstraints.BOTH;
		gbc_btnHalfDiminishedSeventh.insets = new Insets(0, 0, 5, 0);
		gbc_btnHalfDiminishedSeventh.gridx = 1;
		gbc_btnHalfDiminishedSeventh.gridy = 2;
		btnHalfDiminishedSeventh.setEnabled(false);
		contentPane.add(btnHalfDiminishedSeventh, gbc_btnHalfDiminishedSeventh);
		
		JButton btnFullyDiminishedSeventh = new JButton("Fully-Diminished Seventh");
		btnFullyDiminishedSeventh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				questions++;
				answer = "Fully-Diminished Seventh";
				answerDisplay(answer);
			}
		});
		GridBagConstraints gbc_btnFullyDiminishedSeventh = new GridBagConstraints();
		gbc_btnFullyDiminishedSeventh.fill = GridBagConstraints.BOTH;
		gbc_btnFullyDiminishedSeventh.insets = new Insets(0, 0, 0, 5);
		gbc_btnFullyDiminishedSeventh.gridx = 0;
		gbc_btnFullyDiminishedSeventh.gridy = 3;
		btnFullyDiminishedSeventh.setEnabled(false);
		contentPane.add(btnFullyDiminishedSeventh, gbc_btnFullyDiminishedSeventh);
		
		URL urlTreble = this.getClass().getResource("/res/trebleSmall.png");
		treble = Toolkit.getDefaultToolkit().getImage(urlTreble);
		URL urlSharp = this.getClass().getResource("/res/sharp.png");
		sharp = Toolkit.getDefaultToolkit().getImage(urlSharp);
		URL urlFlat = this.getClass().getResource("/res/flat.png");
		flat = Toolkit.getDefaultToolkit().getImage(urlFlat);
		
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
			case "Half-Diminished Seventh":
				enableButton(allowedSevenths.get(x), btnHalfDiminishedSeventh);
				break;
			case "Fully-Diminished Seventh":
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
					allowedSevenths.add("Half-Diminished Seventh");
					break;
				case 4:
					allowedSevenths.add("Fully-Diminished Seventh");
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
		if(string == "Half-Diminished Seventh")
			button.setEnabled(true);
		if(string == "Fully-Diminished Seventh")
			button.setEnabled(true);
	}

	public void paint(Graphics g)
	{
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
		paintNoteGeneral(thirdNote, thirdNoteName, g);
		paintNoteGeneral(fourthNote, fourthNoteName, g);
	}
	
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
		
	private int generateFirstNote()
	{
		int note = SoundMidi.RandomInt(60, 69);
		return note;
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
	
	public void answerDisplay(String answerString)
	{
		if(answerString.equals(seventh))
		{
			JOptionPane.showMessageDialog(null, "Correct!");
			correct++;
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Correct Answer:"  + seventh);
		}
	}
	
	public String displayResults()
	{
		return correct + " out of " + questions + " correct";
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
