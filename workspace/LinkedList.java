/*
Problem:  Write a program that keeps and manipulates a linked list of
	    String data. The data will be provided by the user one item at a time.
      The user should be able to do the following operations:
                     -add "String"
                                adds an item to your list (maintaining alphabetical order)
                     -remove "String"
                                if the item exists removes the first instance of it
                     -show
                                should display all items in the linked list
                     -clear
                               should clear the list
	Input:  commands listed above
	Output:  the results to the screen of each menu
	    choice, and error messages where appropriate.
*/
public class LinkedList{

  //instance varialbes go here (think about what you need to keep track of!)
  
  private ListNode start;
  //constructors go here
  public LinkedList()
  {
    
  }

  //precondition: the list has been initialized
  //postcondition: the ListNode containing the appropriate value has been added and returned
  public ListNode addAValue(String line)
  {
    ListNode temp = start;
    if (start == null)
    {

      start = new ListNode(line, null);
      temp = start;
    }
    
    else
    {
      char firstLetter = line.charAt(0);
      
      while(temp.getNext() != null && (temp.getNext().getValue().charAt(0) < firstLetter))
      {
       
        temp = temp.getNext();
      
      }
    
      if (temp.getNext() == null)
      {
        System.out.println(temp.getValue() + "11");
        temp.setNext(new ListNode(line, null));
      }
      else
      {
        System.out.println(temp.getNext().getValue() + "12");
        temp.setNext(new ListNode(line, temp.getNext()));
      }

    }
    
    return temp;
  }

  //precondition: the list has been initialized
  //postcondition: the ListNode containing the appropriate value has been deleted and returned.
  //if the value is not in the list returns null
  public ListNode deleteAValue(String line)
  {
    ListNode temp = start;
    ListNode del;
    //if start contains value that should be deleted
    if (start.getValue().equals(line))
    {
      System.out.println(start.getValue());
      
      start = temp.getNext();
      return temp;
    }
    while(temp.getNext() != null && !(temp.getNext().getValue().equals(line)))
    {
      temp = temp.getNext();
    }

    if (temp.getNext() == null && !(temp.getValue().equals(line)))
    {
      return null;
    }
    else
    {
      System.out.println(start.getValue());
      del = temp.getNext();
      System.out.println(temp.getNext().getValue());
      temp.setNext(del.getNext());
    }
    return del;
  }


  //precondition: the list has been initialized
  //postconditions: returns a string containing all values appended together with spaces between.
  public String showValues()
  {
    String stuff = "";
    ListNode temp = start;
  
    while(temp != null)
    {
      stuff += " " + temp.getValue();
      temp = temp.getNext();
    }
    return stuff;
  }

  //precondition: the list has been initialized
  //postconditions: clears the list.
  public void clear()
  {
    start = null;
  }
}
