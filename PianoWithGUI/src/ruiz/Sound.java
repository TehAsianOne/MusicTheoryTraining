package ruiz;

import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JOptionPane;

public class Sound 
{
	static void ChooseNote(String location)
	{
		File sound = new File(location);
		PlaySound(sound);
	}
	
	static void PlaySound(File sound)
	{
		try
		{
			Clip clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(sound));
			clip.start();
			
			Thread.sleep(clip.getMicrosecondLength() / 1000);
		}
		catch(Exception e)
		{
			JOptionPane.showConfirmDialog(null, "Check Sound Class");
		}
	}
}
