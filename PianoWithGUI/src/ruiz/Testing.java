package ruiz;

import javax.swing.JOptionPane;

public class Testing 
{
	public static void main(String[] args)
	{
		/*NoteClassification A = new NoteClassification("B#", "C");
		//System.out.println(A.cutName(A.noteOne));
		//System.out.println(A.cutName(A.noteTwo));
		System.out.println(A.returnTwoNotes());
		System.out.println(A.returnOneNote(0));
		System.out.println(A.returnOneNote(1));*/
		
		LinkedList orderOfSeconds = new LinkedList();
		orderOfSeconds.insertAtStart("1");
		orderOfSeconds.insertAtEnd("2");
		orderOfSeconds.insertAtEnd("3");
		orderOfSeconds.insertAtEnd("4");
		orderOfSeconds.insertAtEnd("5");
		orderOfSeconds.insertAtEnd("6");
		orderOfSeconds.insertAtEnd("7");
		orderOfSeconds.insertAtEnd("8");
		orderOfSeconds.insertAtEnd("9");
		orderOfSeconds.insertAtEnd("10");
		orderOfSeconds.insertAtEnd("11");

		
		System.out.println(orderOfSeconds);
		System.out.println(orderOfSeconds.getSize());
		orderOfSeconds.display();
	}
}
