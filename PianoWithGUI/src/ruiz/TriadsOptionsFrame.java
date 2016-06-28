package ruiz;

import java.awt.BorderLayout;
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
import javax.sound.midi.MidiUnavailableException;
import javax.swing.ButtonGroup;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TriadsOptionsFrame extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private final ButtonGroup buttonGroup_2 = new ButtonGroup();
	
	private ArrayList<Integer> triads = new ArrayList<Integer>();
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
					TriadsOptionsFrame frame = new TriadsOptionsFrame();
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
	public TriadsOptionsFrame() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblHarmonicOrMelodic = new JLabel("Harmonic Or Melodic");
		GridBagConstraints gbc_lblHarmonicOrMelodic = new GridBagConstraints();
		gbc_lblHarmonicOrMelodic.insets = new Insets(0, 0, 5, 5);
		gbc_lblHarmonicOrMelodic.gridx = 0;
		gbc_lblHarmonicOrMelodic.gridy = 0;
		contentPane.add(lblHarmonicOrMelodic, gbc_lblHarmonicOrMelodic);
		
		JLabel lblTriadType = new JLabel("Triad Type");
		GridBagConstraints gbc_lblTriadType = new GridBagConstraints();
		gbc_lblTriadType.insets = new Insets(0, 0, 5, 5);
		gbc_lblTriadType.gridx = 2;
		gbc_lblTriadType.gridy = 0;
		contentPane.add(lblTriadType, gbc_lblTriadType);
		
		JRadioButton rdbtnHarmonic = new JRadioButton("Harmonic");
		buttonGroup.add(rdbtnHarmonic);
		GridBagConstraints gbc_rdbtnHarmonic = new GridBagConstraints();
		gbc_rdbtnHarmonic.anchor = GridBagConstraints.WEST;
		gbc_rdbtnHarmonic.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnHarmonic.gridx = 0;
		gbc_rdbtnHarmonic.gridy = 1;
		contentPane.add(rdbtnHarmonic, gbc_rdbtnHarmonic);
		
		JCheckBox chckbxMajor = new JCheckBox("Major");
		GridBagConstraints gbc_chckbxMajor = new GridBagConstraints();
		gbc_chckbxMajor.anchor = GridBagConstraints.WEST;
		gbc_chckbxMajor.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxMajor.gridx = 2;
		gbc_chckbxMajor.gridy = 1;
		contentPane.add(chckbxMajor, gbc_chckbxMajor);
		
		JCheckBox chckbxDiminished = new JCheckBox("Diminished");
		GridBagConstraints gbc_chckbxDiminished = new GridBagConstraints();
		gbc_chckbxDiminished.anchor = GridBagConstraints.WEST;
		gbc_chckbxDiminished.insets = new Insets(0, 0, 5, 0);
		gbc_chckbxDiminished.gridx = 3;
		gbc_chckbxDiminished.gridy = 1;
		contentPane.add(chckbxDiminished, gbc_chckbxDiminished);
		
		JRadioButton rdbtnMelodic = new JRadioButton("Melodic");
		buttonGroup.add(rdbtnMelodic);
		GridBagConstraints gbc_rdbtnMelodic = new GridBagConstraints();
		gbc_rdbtnMelodic.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnMelodic.anchor = GridBagConstraints.WEST;
		gbc_rdbtnMelodic.gridx = 0;
		gbc_rdbtnMelodic.gridy = 2;
		contentPane.add(rdbtnMelodic, gbc_rdbtnMelodic);
		
		JCheckBox chckbxMinor = new JCheckBox("Minor");
		GridBagConstraints gbc_chckbxMinor = new GridBagConstraints();
		gbc_chckbxMinor.anchor = GridBagConstraints.WEST;
		gbc_chckbxMinor.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxMinor.gridx = 2;
		gbc_chckbxMinor.gridy = 2;
		contentPane.add(chckbxMinor, gbc_chckbxMinor);
		
		JCheckBox chckbxAugmented = new JCheckBox("Augmented");
		GridBagConstraints gbc_chckbxAugmented = new GridBagConstraints();
		gbc_chckbxAugmented.anchor = GridBagConstraints.WEST;
		gbc_chckbxAugmented.insets = new Insets(0, 0, 5, 0);
		gbc_chckbxAugmented.gridx = 3;
		gbc_chckbxAugmented.gridy = 2;
		contentPane.add(chckbxAugmented, gbc_chckbxAugmented);
		
		JLabel label = new JLabel("");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 0;
		gbc_label.gridy = 4;
		contentPane.add(label, gbc_label);
		
		JLabel label_1 = new JLabel("");
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.gridx = 2;
		gbc_label_1.gridy = 5;
		contentPane.add(label_1, gbc_label_1);
		
		JLabel label_2 = new JLabel("Exercise Type");
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.insets = new Insets(0, 0, 5, 5);
		gbc_label_2.gridx = 0;
		gbc_label_2.gridy = 6;
		contentPane.add(label_2, gbc_label_2);
		
		JLabel label_3 = new JLabel("Number of Questions");
		GridBagConstraints gbc_label_3 = new GridBagConstraints();
		gbc_label_3.insets = new Insets(0, 0, 5, 5);
		gbc_label_3.gridx = 1;
		gbc_label_3.gridy = 6;
		contentPane.add(label_3, gbc_label_3);
		
		JRadioButton rdbtnAural = new JRadioButton("Aural");
		buttonGroup_1.add(rdbtnAural);
		GridBagConstraints gbc_rdbtnAural = new GridBagConstraints();
		gbc_rdbtnAural.anchor = GridBagConstraints.WEST;
		gbc_rdbtnAural.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnAural.gridx = 0;
		gbc_rdbtnAural.gridy = 7;
		contentPane.add(rdbtnAural, gbc_rdbtnAural);
		
		JRadioButton rdbtn5 = new JRadioButton("5");
		buttonGroup_2.add(rdbtn5);
		GridBagConstraints gbc_rdbtn5 = new GridBagConstraints();
		gbc_rdbtn5.anchor = GridBagConstraints.WEST;
		gbc_rdbtn5.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtn5.gridx = 1;
		gbc_rdbtn5.gridy = 7;
		contentPane.add(rdbtn5, gbc_rdbtn5);
		
		JRadioButton rdbtnVisual = new JRadioButton("Visual");
		buttonGroup_1.add(rdbtnVisual);
		GridBagConstraints gbc_rdbtnVisual = new GridBagConstraints();
		gbc_rdbtnVisual.anchor = GridBagConstraints.WEST;
		gbc_rdbtnVisual.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnVisual.gridx = 0;
		gbc_rdbtnVisual.gridy = 8;
		contentPane.add(rdbtnVisual, gbc_rdbtnVisual);
		
		JRadioButton rdbtn10 = new JRadioButton("10");
		buttonGroup_2.add(rdbtn10);
		GridBagConstraints gbc_rdbtn10 = new GridBagConstraints();
		gbc_rdbtn10.anchor = GridBagConstraints.WEST;
		gbc_rdbtn10.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtn10.gridx = 1;
		gbc_rdbtn10.gridy = 8;
		contentPane.add(rdbtn10, gbc_rdbtn10);
		
		JRadioButton rdbtn15 = new JRadioButton("15");
		buttonGroup_2.add(rdbtn15);
		GridBagConstraints gbc_rdbtn15 = new GridBagConstraints();
		gbc_rdbtn15.anchor = GridBagConstraints.NORTHWEST;
		gbc_rdbtn15.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtn15.gridx = 1;
		gbc_rdbtn15.gridy = 9;
		contentPane.add(rdbtn15, gbc_rdbtn15);
		
		JRadioButton rdbtn20 = new JRadioButton("20");
		buttonGroup_2.add(rdbtn20);
		GridBagConstraints gbc_rdbtn20 = new GridBagConstraints();
		gbc_rdbtn20.anchor = GridBagConstraints.WEST;
		gbc_rdbtn20.insets = new Insets(0, 0, 0, 5);
		gbc_rdbtn20.gridx = 1;
		gbc_rdbtn20.gridy = 10;
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
				
				triads.add(selectTriad(chckbxMajor));
				triads.add(selectTriad(chckbxMinor));
				triads.add(selectTriad(chckbxAugmented));
				triads.add(selectTriad(chckbxDiminished));
				
				JOptionPane.showMessageDialog(null, "You will hear " + numberQuestions + " triads. Pick the chord type you think is correct. Good luck.");
				//JOptionPane.showMessageDialog(null, triads + " " + exerciseType + " " + playType);
				
				if(exerciseType == "Aural")
					try {
						new TriadsTrainerAural(playType, triads, numberQuestions).setVisible(true);
					} catch (MidiUnavailableException e1) {
						e1.printStackTrace();
					}
				
				if(exerciseType == "Visual")
					new TriadsTrainerVisual(triads, numberQuestions).setVisible(true);
			}
		});
		
		GridBagConstraints gbc_btnSubmit = new GridBagConstraints();
		gbc_btnSubmit.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnSubmit.insets = new Insets(0, 0, 5, 5);
		gbc_btnSubmit.gridx = 2;
		gbc_btnSubmit.gridy = 8;
		contentPane.add(btnSubmit, gbc_btnSubmit);
		
		
	}
	
	private static int selectTriad(JCheckBox button)
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
