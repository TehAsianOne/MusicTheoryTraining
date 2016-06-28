package ruiz;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.swing.JOptionPane;

public class SoundMidi 
{
	private int min;
	private int max;
	private static Integer interval;
	private static Map<Integer, String> intervalMap = new HashMap();

	public SoundMidi()
	{
		loadIntervalMap();
	}

	public SoundMidi(int min, int max, int interval)
	{
		this.min = min;
		this.max = max;
		this.interval = interval;
		loadIntervalMap();
	}

	private void loadIntervalMap()
	{
		intervalMap.put(-12, "Pefect Octave");
		intervalMap.put(-11, "Major Seventh");
		intervalMap.put(-10, "Minor Seventh");
		intervalMap.put(-9, "Major Sixth");
		intervalMap.put(-8, "Minor Sixth");
		intervalMap.put(-7, "Perfect Fifth");
		intervalMap.put(-6, "Tritone");
		intervalMap.put(-5, "Perfect Fourth");
		intervalMap.put(-4, "Major Third");
		intervalMap.put(-3, "Minor Third");
		intervalMap.put(-2, "Major Second");
		intervalMap.put(-1, "Minor Second");
		intervalMap.put(0, "Unison");
		intervalMap.put(1, "Minor Second");
		intervalMap.put(2, "Major Second");
		intervalMap.put(3, "Minor Third");
		intervalMap.put(4, "Major Third");
		intervalMap.put(5, "Perfect Fourth");
		intervalMap.put(6, "Tritone");
		intervalMap.put(7, "Perfect Fifth");
		intervalMap.put(8, "Minor Sixth");
		intervalMap.put(9, "Major Sixth");
		intervalMap.put(10, "Minor Seventh");
		intervalMap.put(11, "Major Seventh");
		intervalMap.put(12, "Perfect Octave");
	}
	
	public static int RandomInt(int min, int max)
	{
		Random r = new Random();

		int randomInt = r.nextInt((max - min) + 1) + min;

		return randomInt;
	}

	public static String GetInterval(int min, int max)	//Legacy Method
	{
		String result = "";
		int x = 0;
		interval = max - min;
		
		do
		{
			//JOptionPane.showMessageDialog(null, "Interval is: " + interval + ". Checking: " + intervalMap.get(x));
			if(intervalMap.containsKey(x))
			{
				result = result.concat(intervalMap.get(result));
				JOptionPane.showMessageDialog(null, "Interval is: " + interval + ". Checking: " + intervalMap.get(x));
				break;
			}
			x++;
		}
		while(x < 13);
		
		return result;
	}
}
