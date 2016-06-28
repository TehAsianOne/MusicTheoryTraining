package ruiz;

import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JRadioButton;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.JCheckBox;
import javax.naming.ldap.Rdn;
import javax.sound.midi.MidiUnavailableException;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class IntervalOptionsFrame extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private ArrayList<Integer> intervals = new ArrayList<Integer>();
	private String playType = "Melodic";
	private String playOrder = "Ascending";
	private String exerciseType;
	private int numberQuestions;
	private final ButtonGroup buttonGroup_2 = new ButtonGroup();
	private final ButtonGroup buttonGroup_3 = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IntervalOptionsFrame frame = new IntervalOptionsFrame();
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
	public IntervalOptionsFrame() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 571, 329);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);

		JLabel lblHarmonicOrMelodic = new JLabel("Harmonic or Melodic");
		GridBagConstraints gbc_lblHarmonicOrMelodic = new GridBagConstraints();
		gbc_lblHarmonicOrMelodic.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblHarmonicOrMelodic.insets = new Insets(0, 0, 5, 5);
		gbc_lblHarmonicOrMelodic.gridx = 0;
		gbc_lblHarmonicOrMelodic.gridy = 0;
		contentPane.add(lblHarmonicOrMelodic, gbc_lblHarmonicOrMelodic);

		JLabel lblNewLabel = new JLabel("Intervals");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 3;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 0;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);

		JRadioButton rdbtnMelodic = new JRadioButton("Melodic");
		buttonGroup.add(rdbtnMelodic);
		GridBagConstraints gbc_rdbtnMelodic = new GridBagConstraints();
		gbc_rdbtnMelodic.fill = GridBagConstraints.HORIZONTAL;
		gbc_rdbtnMelodic.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnMelodic.gridx = 0;
		gbc_rdbtnMelodic.gridy = 1;
		contentPane.add(rdbtnMelodic, gbc_rdbtnMelodic);

		JCheckBox chckbxMinorSecond = new JCheckBox("Minor Second");
		GridBagConstraints gbc_chckbxMinorSecond = new GridBagConstraints();
		gbc_chckbxMinorSecond.fill = GridBagConstraints.HORIZONTAL;
		gbc_chckbxMinorSecond.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxMinorSecond.gridx = 1;
		gbc_chckbxMinorSecond.gridy = 1;
		contentPane.add(chckbxMinorSecond, gbc_chckbxMinorSecond);

		JCheckBox chckbxPerfectFourth = new JCheckBox("Perfect Fourth");
		GridBagConstraints gbc_chckbxPerfectFourth = new GridBagConstraints();
		gbc_chckbxPerfectFourth.fill = GridBagConstraints.HORIZONTAL;
		gbc_chckbxPerfectFourth.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxPerfectFourth.gridx = 2;
		gbc_chckbxPerfectFourth.gridy = 1;
		contentPane.add(chckbxPerfectFourth, gbc_chckbxPerfectFourth);

		JCheckBox chckbxMajorSixth = new JCheckBox("Major Sixth");
		GridBagConstraints gbc_chckbxMajorSixth = new GridBagConstraints();
		gbc_chckbxMajorSixth.fill = GridBagConstraints.HORIZONTAL;
		gbc_chckbxMajorSixth.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxMajorSixth.gridx = 3;
		gbc_chckbxMajorSixth.gridy = 1;
		contentPane.add(chckbxMajorSixth, gbc_chckbxMajorSixth);

		JRadioButton rdbtnHarmonic = new JRadioButton("Harmonic");
		buttonGroup.add(rdbtnHarmonic);
		GridBagConstraints gbc_rdbtnHarmonic = new GridBagConstraints();
		gbc_rdbtnHarmonic.fill = GridBagConstraints.HORIZONTAL;
		gbc_rdbtnHarmonic.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnHarmonic.gridx = 0;
		gbc_rdbtnHarmonic.gridy = 2;
		contentPane.add(rdbtnHarmonic, gbc_rdbtnHarmonic);

		JCheckBox chckbxMajorSecond = new JCheckBox("Major Second");
		GridBagConstraints gbc_chckbxMajorSecond = new GridBagConstraints();
		gbc_chckbxMajorSecond.fill = GridBagConstraints.HORIZONTAL;
		gbc_chckbxMajorSecond.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxMajorSecond.gridx = 1;
		gbc_chckbxMajorSecond.gridy = 2;
		contentPane.add(chckbxMajorSecond, gbc_chckbxMajorSecond);

		JCheckBox chckbxTritone = new JCheckBox("Tritone");
		GridBagConstraints gbc_chckbxTritone = new GridBagConstraints();
		gbc_chckbxTritone.fill = GridBagConstraints.HORIZONTAL;
		gbc_chckbxTritone.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxTritone.gridx = 2;
		gbc_chckbxTritone.gridy = 2;
		contentPane.add(chckbxTritone, gbc_chckbxTritone);

		JCheckBox chckbxMinorSeventh = new JCheckBox("Minor Seventh");
		GridBagConstraints gbc_chckbxMinorSeventh = new GridBagConstraints();
		gbc_chckbxMinorSeventh.fill = GridBagConstraints.HORIZONTAL;
		gbc_chckbxMinorSeventh.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxMinorSeventh.gridx = 3;
		gbc_chckbxMinorSeventh.gridy = 2;
		contentPane.add(chckbxMinorSeventh, gbc_chckbxMinorSeventh);

		JCheckBox chckbxMinorThird = new JCheckBox("Minor Third");
		GridBagConstraints gbc_chckbxMinorThird = new GridBagConstraints();
		gbc_chckbxMinorThird.fill = GridBagConstraints.HORIZONTAL;
		gbc_chckbxMinorThird.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxMinorThird.gridx = 1;
		gbc_chckbxMinorThird.gridy = 3;
		contentPane.add(chckbxMinorThird, gbc_chckbxMinorThird);

		JCheckBox chckbxPerfectFifth = new JCheckBox("Perfect Fifth");
		GridBagConstraints gbc_chckbxPerfectFifth = new GridBagConstraints();
		gbc_chckbxPerfectFifth.fill = GridBagConstraints.HORIZONTAL;
		gbc_chckbxPerfectFifth.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxPerfectFifth.gridx = 2;
		gbc_chckbxPerfectFifth.gridy = 3;
		contentPane.add(chckbxPerfectFifth, gbc_chckbxPerfectFifth);

		JCheckBox chckbxMajorSeventh = new JCheckBox("Major Seventh");
		GridBagConstraints gbc_chckbxMajorSeventh = new GridBagConstraints();
		gbc_chckbxMajorSeventh.fill = GridBagConstraints.HORIZONTAL;
		gbc_chckbxMajorSeventh.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxMajorSeventh.gridx = 3;
		gbc_chckbxMajorSeventh.gridy = 3;
		contentPane.add(chckbxMajorSeventh, gbc_chckbxMajorSeventh);

		JCheckBox chckbxMajorThird = new JCheckBox("Major Third");
		GridBagConstraints gbc_chckbxMajorThird = new GridBagConstraints();
		gbc_chckbxMajorThird.fill = GridBagConstraints.HORIZONTAL;
		gbc_chckbxMajorThird.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxMajorThird.gridx = 1;
		gbc_chckbxMajorThird.gridy = 4;
		contentPane.add(chckbxMajorThird, gbc_chckbxMajorThird);

		JCheckBox chckbxMinorSixth = new JCheckBox("Minor Sixth");
		GridBagConstraints gbc_chckbxMinorSixth = new GridBagConstraints();
		gbc_chckbxMinorSixth.fill = GridBagConstraints.HORIZONTAL;
		gbc_chckbxMinorSixth.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxMinorSixth.gridx = 2;
		gbc_chckbxMinorSixth.gridy = 4;
		contentPane.add(chckbxMinorSixth, gbc_chckbxMinorSixth);

		JCheckBox chckbxPerfectOctave = new JCheckBox("Perfect Octave");
		GridBagConstraints gbc_chckbxPerfectOctave = new GridBagConstraints();
		gbc_chckbxPerfectOctave.fill = GridBagConstraints.HORIZONTAL;
		gbc_chckbxPerfectOctave.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxPerfectOctave.gridx = 3;
		gbc_chckbxPerfectOctave.gridy = 4;
		contentPane.add(chckbxPerfectOctave, gbc_chckbxPerfectOctave);

		JLabel lblAscendingOrDescending = new JLabel("Ascending or Descending");
		GridBagConstraints gbc_lblAscendingOrDescending = new GridBagConstraints();
		gbc_lblAscendingOrDescending.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblAscendingOrDescending.insets = new Insets(0, 0, 5, 5);
		gbc_lblAscendingOrDescending.gridx = 0;
		gbc_lblAscendingOrDescending.gridy = 6;
		contentPane.add(lblAscendingOrDescending, gbc_lblAscendingOrDescending);

		JLabel lblExerciseType = new JLabel("Exercise Type");
		GridBagConstraints gbc_lblExerciseType = new GridBagConstraints();
		gbc_lblExerciseType.insets = new Insets(0, 0, 5, 5);
		gbc_lblExerciseType.gridx = 1;
		gbc_lblExerciseType.gridy = 6;
		contentPane.add(lblExerciseType, gbc_lblExerciseType);

		JLabel lblNumberOfQuestions = new JLabel("Number of Questions");
		GridBagConstraints gbc_lblNumberOfQuestions = new GridBagConstraints();
		gbc_lblNumberOfQuestions.insets = new Insets(0, 0, 5, 5);
		gbc_lblNumberOfQuestions.gridx = 2;
		gbc_lblNumberOfQuestions.gridy = 6;
		contentPane.add(lblNumberOfQuestions, gbc_lblNumberOfQuestions);

		JRadioButton rdbtnAscending = new JRadioButton("Ascending");
		buttonGroup_1.add(rdbtnAscending);
		GridBagConstraints gbc_rdbtnAscending = new GridBagConstraints();
		gbc_rdbtnAscending.fill = GridBagConstraints.HORIZONTAL;
		gbc_rdbtnAscending.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnAscending.gridx = 0;
		gbc_rdbtnAscending.gridy = 7;
		contentPane.add(rdbtnAscending, gbc_rdbtnAscending);

		JRadioButton rdbtnAural = new JRadioButton("Aural");
		buttonGroup_2.add(rdbtnAural);
		GridBagConstraints gbc_rdbtnAural = new GridBagConstraints();
		gbc_rdbtnAural.anchor = GridBagConstraints.WEST;
		gbc_rdbtnAural.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnAural.gridx = 1;
		gbc_rdbtnAural.gridy = 7;
		contentPane.add(rdbtnAural, gbc_rdbtnAural);

		JRadioButton rdbtnDescending = new JRadioButton("Descending");
		buttonGroup_1.add(rdbtnDescending);
		GridBagConstraints gbc_rdbtnDescending = new GridBagConstraints();
		gbc_rdbtnDescending.fill = GridBagConstraints.HORIZONTAL;
		gbc_rdbtnDescending.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnDescending.gridx = 0;
		gbc_rdbtnDescending.gridy = 8;
		contentPane.add(rdbtnDescending, gbc_rdbtnDescending);

		JRadioButton rdbtnVisual = new JRadioButton("Visual");
		buttonGroup_2.add(rdbtnVisual);
		GridBagConstraints gbc_rdbtnVisual = new GridBagConstraints();
		gbc_rdbtnVisual.anchor = GridBagConstraints.WEST;
		gbc_rdbtnVisual.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnVisual.gridx = 1;
		gbc_rdbtnVisual.gridy = 8;
		contentPane.add(rdbtnVisual, gbc_rdbtnVisual);
		GridBagConstraints gbc_btnSubmit = new GridBagConstraints();
		gbc_btnSubmit.insets = new Insets(0, 0, 5, 5);
		gbc_btnSubmit.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnSubmit.gridx = 3;
		gbc_btnSubmit.gridy = 8;
		//contentPane.add(btnSubmit, gbc_btnSubmit);

		JRadioButton rdbtn5 = new JRadioButton("5");
		buttonGroup_3.add(rdbtn5);
		GridBagConstraints gbc_rdbtn5 = new GridBagConstraints();
		gbc_rdbtn5.anchor = GridBagConstraints.WEST;
		gbc_rdbtn5.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtn5.gridx = 2;
		gbc_rdbtn5.gridy = 7;
		contentPane.add(rdbtn5, gbc_rdbtn5);

		JRadioButton rdbtn10 = new JRadioButton("10");
		buttonGroup_3.add(rdbtn10);
		GridBagConstraints gbc_rdbtn10 = new GridBagConstraints();
		gbc_rdbtn10.anchor = GridBagConstraints.WEST;
		gbc_rdbtn10.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtn10.gridx = 2;
		gbc_rdbtn10.gridy = 8;
		contentPane.add(rdbtn10, gbc_rdbtn10);
		//contentPane.add(btnSubmit, gbc_btnSubmit);
		JRadioButton rdbtn15 = new JRadioButton("15");
		buttonGroup_3.add(rdbtn15);
		GridBagConstraints gbc_rdbtn15 = new GridBagConstraints();
		gbc_rdbtn15.anchor = GridBagConstraints.WEST;
		gbc_rdbtn15.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtn15.gridx = 2;
		gbc_rdbtn15.gridy = 9;
		contentPane.add(rdbtn15, gbc_rdbtn15);
		JRadioButton rdbtn20 = new JRadioButton("20");
		buttonGroup_3.add(rdbtn20);
		GridBagConstraints gbc_rdbtn20 = new GridBagConstraints();
		gbc_rdbtn20.anchor = GridBagConstraints.WEST;
		gbc_rdbtn20.insets = new Insets(0, 0, 0, 5);
		gbc_rdbtn20.gridx = 2;
		gbc_rdbtn20.gridy = 10;
		contentPane.add(rdbtn20, gbc_rdbtn20);

		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(rdbtnHarmonic.isSelected())
				{
					playType = "Harmonic";
				} else if(rdbtnMelodic.isSelected())
				{
					playType = "Melodic";
				}

				if(rdbtnDescending.isSelected())
				{
					playOrder = "Descending";
				}
				else if(rdbtnAscending.isSelected())
				{
					playOrder = "Ascending";
				}

				if(rdbtnAural.isSelected())
				{
					exerciseType = "Aural";
				}
				else if(rdbtnVisual.isSelected())
				{
					exerciseType = "Visual";
				}

				intervals.add(selectInterval(chckbxMinorSecond));
				intervals.add(selectInterval(chckbxMajorSecond));
				intervals.add(selectInterval(chckbxMinorThird));
				intervals.add(selectInterval(chckbxMajorThird));
				intervals.add(selectInterval(chckbxPerfectFourth));
				intervals.add(selectInterval(chckbxTritone));
				intervals.add(selectInterval(chckbxPerfectFifth));
				intervals.add(selectInterval(chckbxMinorSixth));
				intervals.add(selectInterval(chckbxMajorSixth));
				intervals.add(selectInterval(chckbxMinorSeventh));
				intervals.add(selectInterval(chckbxMajorSeventh));
				intervals.add(selectInterval(chckbxPerfectOctave));

				if(rdbtn5.isSelected())
					numberQuestions = 5;
				else if(rdbtn10.isSelected())
					numberQuestions = 10;
				else if(rdbtn15.isSelected())
					numberQuestions = 15;
				else if(rdbtn20.isSelected())
					numberQuestions = 20;

				//JOptionPane.showMessageDialog(null, "You will hear " + numberQuestions + " intervals. Pick the interval you think is correct. Good luck.");

				if(exerciseType == "Aural")
					try {
						new IntervalTrainerAural(playType, playOrder, intervals, numberQuestions).setVisible(true);
					} catch (MidiUnavailableException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}




				if(exerciseType == "Visual")
					try {
						new IntervalTrainerVisual(playType, intervals, numberQuestions).setVisible(true);
					} catch (MidiUnavailableException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				//JOptionPane.showMessageDialog(null, playType + " " + playOrder + " " + exerciseType + " " + intervals);
				intervals.clear();
				setVisible(false);
			}
		});contentPane.add(btnSubmit, gbc_btnSubmit);
	}

	private static int selectInterval(JCheckBox button)
	{
		if(button.isSelected())
		{
			return 1;
		}
		else
		{
			return 0;
		}
	}


}
