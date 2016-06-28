package ruiz;

public class Node 
{
	protected String data;
    protected Node link;
 
    /*  Constructor  */
    public Node()
    {
        link = null;
        data = "";
    }    
    /*  Constructor  */
    public Node(String val,Node n)
    {
        data = val;
        link = n;
    }    
    /*  Function to set link to next Node  */
    public void setLink(Node n)
    {
        link = n;
    }    
    /*  Function to set data to current Node  */
    public void setData(String d)
    {
        data = d;
    }    
    /*  Function to get link to next node  */
    public Node getLink()
    {
        return link;
    }    
    /*  Function to get data from current Node  */
    public String getData()
    {
        return data;
    }
}
