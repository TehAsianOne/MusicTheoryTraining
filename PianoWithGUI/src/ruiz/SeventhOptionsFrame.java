package ruiz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import javax.swing.JRadioButton;
import java.awt.Insets;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

import javax.swing.ButtonGroup;

public class SeventhOptionsFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private final ButtonGroup buttonGroup_2 = new ButtonGroup();
	
	private ArrayList<Integer> sevenths = new ArrayList<Integer>();
	private String playType = "Melodic";
	private String exerciseType = "Harmonic";
	private int numberQuestions = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SeventhOptionsFrame frame = new SeventhOptionsFrame();
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
	public SeventhOptionsFrame() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 588, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblHarmonicOrMelodic = new JLabel("Harmonic Or Melodic");
		GridBagConstraints gbc_lblHarmonicOrMelodic = new GridBagConstraints();
		gbc_lblHarmonicOrMelodic.insets = new Insets(0, 0, 5, 5);
		gbc_lblHarmonicOrMelodic.gridx = 0;
		gbc_lblHarmonicOrMelodic.gridy = 0;
		contentPane.add(lblHarmonicOrMelodic, gbc_lblHarmonicOrMelodic);
		
		JLabel lblSeventhType = new JLabel("Seventh Type");
		GridBagConstraints gbc_lblSeventhType = new GridBagConstraints();
		gbc_lblSeventhType.insets = new Insets(0, 0, 5, 5);
		gbc_lblSeventhType.gridx = 2;
		gbc_lblSeventhType.gridy = 0;
		contentPane.add(lblSeventhType, gbc_lblSeventhType);
		
		JRadioButton rdbtnHarmonic = new JRadioButton("Harmonic");
		buttonGroup.add(rdbtnHarmonic);
		GridBagConstraints gbc_rdbtnHarmonic = new GridBagConstraints();
		gbc_rdbtnHarmonic.anchor = GridBagConstraints.WEST;
		gbc_rdbtnHarmonic.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnHarmonic.gridx = 0;
		gbc_rdbtnHarmonic.gridy = 1;
		contentPane.add(rdbtnHarmonic, gbc_rdbtnHarmonic);
		
		JCheckBox chckbxMajorSeventh = new JCheckBox("Major Seventh");
		GridBagConstraints gbc_chckbxMajorSeventh = new GridBagConstraints();
		gbc_chckbxMajorSeventh.anchor = GridBagConstraints.WEST;
		gbc_chckbxMajorSeventh.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxMajorSeventh.gridx = 2;
		gbc_chckbxMajorSeventh.gridy = 1;
		contentPane.add(chckbxMajorSeventh, gbc_chckbxMajorSeventh);
		
		JCheckBox chckbxDominantSeventh = new JCheckBox("Dominant Seventh");
		GridBagConstraints gbc_chckbxDominantSeventh = new GridBagConstraints();
		gbc_chckbxDominantSeventh.anchor = GridBagConstraints.WEST;
		gbc_chckbxDominantSeventh.insets = new Insets(0, 0, 5, 0);
		gbc_chckbxDominantSeventh.gridx = 3;
		gbc_chckbxDominantSeventh.gridy = 1;
		contentPane.add(chckbxDominantSeventh, gbc_chckbxDominantSeventh);
		
		JRadioButton rdbtnMelodic = new JRadioButton("Melodic");
		buttonGroup.add(rdbtnMelodic);
		GridBagConstraints gbc_rdbtnMelodic = new GridBagConstraints();
		gbc_rdbtnMelodic.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnMelodic.anchor = GridBagConstraints.WEST;
		gbc_rdbtnMelodic.gridx = 0;
		gbc_rdbtnMelodic.gridy = 2;
		contentPane.add(rdbtnMelodic, gbc_rdbtnMelodic);
		
		JCheckBox chckbxMinorSeventh = new JCheckBox("Minor Seventh");
		GridBagConstraints gbc_chckbxMinorSeventh = new GridBagConstraints();
		gbc_chckbxMinorSeventh.anchor = GridBagConstraints.WEST;
		gbc_chckbxMinorSeventh.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxMinorSeventh.gridx = 2;
		gbc_chckbxMinorSeventh.gridy = 2;
		contentPane.add(chckbxMinorSeventh, gbc_chckbxMinorSeventh);
		
		JCheckBox chckbxHalfdiminishedSeventh = new JCheckBox("Half-Diminished Seventh");
		GridBagConstraints gbc_chckbxHalfdiminishedSeventh = new GridBagConstraints();
		gbc_chckbxHalfdiminishedSeventh.anchor = GridBagConstraints.WEST;
		gbc_chckbxHalfdiminishedSeventh.insets = new Insets(0, 0, 5, 0);
		gbc_chckbxHalfdiminishedSeventh.gridx = 3;
		gbc_chckbxHalfdiminishedSeventh.gridy = 2;
		contentPane.add(chckbxHalfdiminishedSeventh, gbc_chckbxHalfdiminishedSeventh);
		
		JCheckBox chckbxFullydiminishedSeventh = new JCheckBox("Fully-Diminished Seventh");
		GridBagConstraints gbc_chckbxFullydiminishedSeventh = new GridBagConstraints();
		gbc_chckbxFullydiminishedSeventh.anchor = GridBagConstraints.WEST;
		gbc_chckbxFullydiminishedSeventh.insets = new Insets(0, 0, 5, 0);
		gbc_chckbxFullydiminishedSeventh.gridx = 3;
		gbc_chckbxFullydiminishedSeventh.gridy = 3;
		contentPane.add(chckbxFullydiminishedSeventh, gbc_chckbxFullydiminishedSeventh);
		
		JLabel lblExerciseType = new JLabel("Exercise Type");
		GridBagConstraints gbc_lblExerciseType = new GridBagConstraints();
		gbc_lblExerciseType.insets = new Insets(0, 0, 5, 5);
		gbc_lblExerciseType.gridx = 0;
		gbc_lblExerciseType.gridy = 4;
		contentPane.add(lblExerciseType, gbc_lblExerciseType);
		
		JLabel lblNumberOfQuestions = new JLabel("Number of Questions");
		GridBagConstraints gbc_lblNumberOfQuestions = new GridBagConstraints();
		gbc_lblNumberOfQuestions.insets = new Insets(0, 0, 5, 5);
		gbc_lblNumberOfQuestions.gridx = 1;
		gbc_lblNumberOfQuestions.gridy = 4;
		contentPane.add(lblNumberOfQuestions, gbc_lblNumberOfQuestions);
		
		JRadioButton rdbtnAural = new JRadioButton("Aural");
		buttonGroup_1.add(rdbtnAural);
		GridBagConstraints gbc_rdbtnAural = new GridBagConstraints();
		gbc_rdbtnAural.anchor = GridBagConstraints.WEST;
		gbc_rdbtnAural.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnAural.gridx = 0;
		gbc_rdbtnAural.gridy = 5;
		contentPane.add(rdbtnAural, gbc_rdbtnAural);
		
		JRadioButton rdbtn5 = new JRadioButton("5");
		buttonGroup_2.add(rdbtn5);
		GridBagConstraints gbc_rdbtn5 = new GridBagConstraints();
		gbc_rdbtn5.anchor = GridBagConstraints.WEST;
		gbc_rdbtn5.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtn5.gridx = 1;
		gbc_rdbtn5.gridy = 5;
		contentPane.add(rdbtn5, gbc_rdbtn5);
		
		JRadioButton rdbtnVisual = new JRadioButton("Visual");
		buttonGroup_1.add(rdbtnVisual);
		GridBagConstraints gbc_rdbtnVisual = new GridBagConstraints();
		gbc_rdbtnVisual.anchor = GridBagConstraints.WEST;
		gbc_rdbtnVisual.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnVisual.gridx = 0;
		gbc_rdbtnVisual.gridy = 6;
		contentPane.add(rdbtnVisual, gbc_rdbtnVisual);
		
		JRadioButton rdbtn10 = new JRadioButton("10");
		buttonGroup_2.add(rdbtn10);
		GridBagConstraints gbc_rdbtn10 = new GridBagConstraints();
		gbc_rdbtn10.anchor = GridBagConstraints.WEST;
		gbc_rdbtn10.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtn10.gridx = 1;
		gbc_rdbtn10.gridy = 6;
		contentPane.add(rdbtn10, gbc_rdbtn10);
		
		JRadioButton rdbtn15 = new JRadioButton("15");
		buttonGroup_2.add(rdbtn15);
		GridBagConstraints gbc_rdbtn15 = new GridBagConstraints();
		gbc_rdbtn15.anchor = GridBagConstraints.WEST;
		gbc_rdbtn15.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtn15.gridx = 1;
		gbc_rdbtn15.gridy = 7;
		contentPane.add(rdbtn15, gbc_rdbtn15);
		
		JRadioButton rdbtn20 = new JRadioButton("20");
		buttonGroup_2.add(rdbtn20);
		GridBagConstraints gbc_rdbtn20 = new GridBagConstraints();
		gbc_rdbtn20.anchor = GridBagConstraints.WEST;
		gbc_rdbtn20.insets = new Insets(0, 0, 0, 5);
		gbc_rdbtn20.gridx = 1;
		gbc_rdbtn20.gridy = 8;
		contentPane.add(rdbtn20, gbc_rdbtn20);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnHarmonic.isSelected())
				{
					playType = "Harmonic";
				} else if(rdbtnMelodic.isSelected())
				{
					playType = "Melodic";
				}
				
				if(rdbtnAural.isSelected())
				{
					exerciseType = "Aural";
				} else if(rdbtnVisual.isSelected())
				{
					exerciseType = "Visual";
				}
				
				if(rdbtn5.isSelected())
				{
					numberQuestions = 5;
				}
				else if(rdbtn10.isSelected())
				{
					numberQuestions = 10;
				}
				else if(rdbtn15.isSelected())
				{
					numberQuestions = 15;
				}
				else if(rdbtn20.isSelected())
				{
					numberQuestions = 20;
				}
				
				sevenths.add(selectSeventh(chckbxMajorSeventh));
				sevenths.add(selectSeventh(chckbxMinorSeventh));
				sevenths.add(selectSeventh(chckbxDominantSeventh));
				sevenths.add(selectSeventh(chckbxHalfdiminishedSeventh));
				sevenths.add(selectSeventh(chckbxFullydiminishedSeventh));
				
				//JOptionPane.showMessageDialog(null, "You will hear " + numberQuestions + " sevenths. Pick the chord type you think is correct. Good luck.");
				//JOptionPane.showMessageDialog(null, sevenths + " " + exerciseType + " " + playType);
				
				if(exerciseType == "Aural")
					new SeventhsTrainerAural(playType, sevenths, numberQuestions).setVisible(true);
				
				if(exerciseType == "Visual")
					new SeventhsTrainerVisual(sevenths, numberQuestions).setVisible(true);
			}
		});
		GridBagConstraints gbc_btnSubmit = new GridBagConstraints();
		gbc_btnSubmit.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnSubmit.insets = new Insets(0, 0, 5, 0);
		gbc_btnSubmit.gridx = 3;
		gbc_btnSubmit.gridy = 6;
		contentPane.add(btnSubmit, gbc_btnSubmit);
		
	}
	private static int selectSeventh(JCheckBox button)
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
