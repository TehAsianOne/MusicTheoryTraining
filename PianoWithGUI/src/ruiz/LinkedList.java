package ruiz;

public class LinkedList 
{
	protected Node start ;
    protected Node end ;
    public int size ;
 
    /* Constructor */
    public LinkedList()
    {
        start = null;
        end = null;
        size = 0;
    }
    /* Function to check if list is empty */
    public boolean isEmpty()
    {
        return start == null;
    }
    /* Function to get size of the list */
    public int getSize()
    {
        return size;
    }
    /* Function to insert element at the beginning */
    public void insertAtStart(String val)
    {
        Node nptr = new Node(val,null);    
        nptr.setLink(start);
        if(start == null)
        {            
            start = nptr;
            nptr.setLink(start);
            end = start;            
        }
        else
        {
            end.setLink(nptr);
            start = nptr;        
        }
        size++ ;
    }
    /* Function to insert element at end */
    public void insertAtEnd(String val)
    {
        Node nptr = new Node(val,null);    
        nptr.setLink(start);
        if(start == null)
        {            
            start = nptr;
            nptr.setLink(start);
            end = start;            
        }
        else
        {
            end.setLink(nptr);
            end = nptr;            
        }
        size++ ;
    }
    /* Function to insert element at position */
    public void insertAtPos(String val , int pos) 
    {
        Node nptr = new Node(val,null);                
        Node ptr = start;
        pos = pos - 1 ;
        for (int i = 1; i < size - 1; i++) 
        {
            if (i == pos) 
            {
                Node tmp = ptr.getLink() ;
                ptr.setLink( nptr );
                nptr.setLink(tmp);
                break;
            }
            ptr = ptr.getLink();
        }
        size++ ;
    }
    /* Function to delete element at position */
    public void deleteAtPos(int pos)
    {    
        if (size == 1 && pos == 1)
        {
            start = null;
            end = null;
            size = 0;
            return ;
        }        
        if (pos == 1) 
        {
            start = start.getLink();
            end.setLink(start);
            size--; 
            return ;
        }
        if (pos == size) 
        {
            Node s = start;
            Node t = start;
            while (s != end)
            {
                t = s;
                s = s.getLink();
            }
            end = t;
            end.setLink(start);
            size --;
            return;
        }
        Node ptr = start;
        pos = pos - 1 ;
        for (int i = 1; i < size - 1; i++) 
        {
            if (i == pos) 
            {
                Node tmp = ptr.getLink();
                tmp = tmp.getLink();
                ptr.setLink(tmp);
                break;
            }
            ptr = ptr.getLink();
        }
        size-- ;
    }
    /* Function to get an element with a specified index */
    public Object getElement(int index)
    {
    	if(index < 0)
    	{
    		return null;
    	}
    	Node ptr = end.getLink();
    	
    	
    	while(index > 0)
    	{
    		ptr = ptr.getLink();
    		index--;
    	}
    	return ptr.getData();
    }
    
    /* Function to display contents */
    public void display()
    {
        System.out.print("\nCircular Singly Linked List = ");
        Node ptr = start;
        if (size == 0) 
        {
            System.out.print("empty\n");
            return;
        }
        if (start.getLink() == start) 
        {
            System.out.print(start.getData()+ "->"+ptr.getData()+ "\n");
            return;
        }
        System.out.print(start.getData()+ "->");
        ptr = start.getLink();
        while (ptr.getLink() != start) 
        {
            System.out.print(ptr.getData()+ "->");
            ptr = ptr.getLink();
        }
        System.out.print(ptr.getData()+ "->");
        ptr = ptr.getLink();
        System.out.print(ptr.getData()+ "\n");
    }
}
