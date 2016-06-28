package ruiz;

public class NoteClassification 
{
	private String noteOne;
	private String noteTwo;
	
	public NoteClassification(String noteOne, String noteTwo)
	{
		this.noteOne = noteOne;
		this.noteTwo = noteTwo;
	}
	
	public String returnTwoNotes()
	{
		return noteOne + "-" + noteTwo;
	}
	
	public String returnOneNote(int choice)
	{
		if(choice == 0)
		{
			return noteOne;
		}
		else if(choice == 1)
		{
			return noteTwo;
		}
		return null;
	}
	
	public String cutName(String note)
	{
		char trim = note.charAt(0);
		return String.valueOf(trim);
	}
	
	public String toString()
	{
		return returnTwoNotes();
	}
}
