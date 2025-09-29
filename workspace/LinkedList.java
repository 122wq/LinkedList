//Fnished by Jack Wang on 9/24/2025 
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
    //add at start
    if (start == null)
    {

      start = new ListNode(line, null);
      return start;
    }
    
    else
    {
      //adding a new value it is empty
      if (start.getValue().compareTo(line) > 0)
      {
        ListNode newStart = new ListNode(line, start);
        start = newStart;
        return start;
      }
      //adding to middle or end
      while(temp.getNext() != null && (temp.getNext().getValue().compareTo(line) < 0))
      {
        temp = temp.getNext();
      }
      temp.setNext(new ListNode(line, temp.getNext()));
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

      start = temp.getNext();
      return start;
    }

    while(temp.getNext() != null && !(temp.getNext().getValue().equals(line)))
    {
      temp = temp.getNext();
    }
    //if the list does not contain the value seeked
    if (temp.getNext() == null && !(temp.getValue().equals(line)))
    {
      return null;
    }
    else
    {
      del = temp.getNext();
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

  public void reverse()
  {
    ListNode curr = start;
    ListNode previous = null;
    ListNode next = null;

    while (curr != null)
    {
      next = curr.getNext();
      curr.setNext(previous);
      previous = curr;
      curr = next;
    }
    start = previous;
  }

  public void nReverse(int n)
  {
    ListNode curr = start;
    ListNode previous = null;
    ListNode next = null;
    ListNode newStart = null;
    ListNode tempEnd = null;
    ListNode tempStart = null;
    boolean firstPass = true;

    while (curr != null)
    {
      //start of the current n-group
      tempStart = curr;
      //reversing n nodes
      for (int i = 0; i < n && curr != null; i++)
      {
        next = curr.getNext();
        curr.setNext(previous);
        previous = curr;
        curr = next;
      }
      //if it is the first pass make the start the lst value reversed in the first group
      if (firstPass)
      {
        newStart = previous;
        firstPass = false;
      }
      //connect the end of next group to start of the next group (previous)
      if (tempEnd != null)
      {      
        tempEnd.setNext(previous);
      }
      //make the start of the next group the end of this group
      tempEnd = tempStart;
      //reset the reversing nodes
      previous = null; 
    }
    
    start = newStart; 
  }
  public static void linkTest()
  {
    LinkedList list = new LinkedList();
        list.addAValue("apple");
        list.addAValue("cherry");
        list.addAValue("grape");
        list.addAValue("banana");
        list.addAValue("date");
        list.addAValue("fig");
        list.addAValue("aa");
        list.addAValue("salmon");
        list.addAValue("kiwi");
        list.addAValue("orange");
        list.addAValue("pear");
        list.addAValue("watermelon");
        list.addAValue("mango");
        list.addAValue("blueberry");
        list.addAValue("raspberry");
       
        System.out.println("Original list: " + list.showValues());
        list.deleteAValue("cherry");
        list.deleteAValue("aa");
        list.deleteAValue("grape");
        System.out.println("After deleting 'cherry' and 'aa' and 'grape': " + list.showValues());
        list.nReverse(3);
        System.out.println("reverse: " + list.showValues());
  }
}


