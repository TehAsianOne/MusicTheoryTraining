package ruiz;

import java.awt.EventQueue;

import javax.swing.JFrame;

import org.omg.PortableServer.ServantRetentionPolicyValue;

import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Window.Type;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FirstMenu {

	private JFrame firstMenuFrame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FirstMenu window = new FirstMenu();
					window.firstMenuFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FirstMenu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		firstMenuFrame = new JFrame();
		firstMenuFrame.setTitle("Music Theory Trainer");
		firstMenuFrame.setBounds(100, 100, 450, 300);
		firstMenuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{217, 217, 0};
		gridBagLayout.rowHeights = new int[]{130, 130, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		firstMenuFrame.getContentPane().setLayout(gridBagLayout);
		
		JButton openIntervalExercise = new JButton("Interval Exercises");
		openIntervalExercise.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				new IntervalOptionsFrame().setVisible(true);
			}
		});
		GridBagConstraints gbc_openIntervalExercise = new GridBagConstraints();
		gbc_openIntervalExercise.fill = GridBagConstraints.BOTH;
		gbc_openIntervalExercise.insets = new Insets(0, 0, 5, 5);
		gbc_openIntervalExercise.gridx = 0;
		gbc_openIntervalExercise.gridy = 0;
		firstMenuFrame.getContentPane().add(openIntervalExercise, gbc_openIntervalExercise);
		
		JButton openTriadExercise = new JButton("Triad Exercises");
		openTriadExercise.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				new TriadsOptionsFrame().setVisible(true);
			}
		});
		GridBagConstraints gbc_openTriadExercise = new GridBagConstraints();
		gbc_openTriadExercise.insets = new Insets(0, 0, 5, 0);
		gbc_openTriadExercise.fill = GridBagConstraints.BOTH;
		gbc_openTriadExercise.gridx = 1;
		gbc_openTriadExercise.gridy = 0;
		firstMenuFrame.getContentPane().add(openTriadExercise, gbc_openTriadExercise);
		
		JButton openSeventhExercise = new JButton("7th Chord Exercises");
		openSeventhExercise.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				new SeventhOptionsFrame().setVisible(true);
			}
		});
		GridBagConstraints gbc_openSeventhExercise = new GridBagConstraints();
		gbc_openSeventhExercise.fill = GridBagConstraints.BOTH;
		gbc_openSeventhExercise.insets = new Insets(0, 0, 0, 5);
		gbc_openSeventhExercise.gridx = 0;
		gbc_openSeventhExercise.gridy = 1;
		firstMenuFrame.getContentPane().add(openSeventhExercise, gbc_openSeventhExercise);
		
		JButton openMiscOptions = new JButton("Misc. Items");
		GridBagConstraints gbc_openMiscOptions = new GridBagConstraints();
		gbc_openMiscOptions.fill = GridBagConstraints.BOTH;
		gbc_openMiscOptions.gridx = 1;
		gbc_openMiscOptions.gridy = 1;
		firstMenuFrame.getContentPane().add(openMiscOptions, gbc_openMiscOptions);
	}

}
