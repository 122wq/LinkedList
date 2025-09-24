//This file contains an example of how to read user input. Use this in conjunction with your linked list class to test your program.
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main{
    public static void main(String[] args)
        throws IOException
    {
        /*Enter data using BufferReader
        BufferedReader reader = new BufferedReader(
            new InputStreamReader(System.in));

        // Reading data using readLine
        LinkedList list = new LinkedList();
        String input= reader.readLine();
        while(!input.equals("exit"))
        {
          if(input.length()>3 && input.substring(0, 3).equals("add"))
          {
            System.out.println(list.addAValue(input.substring(4)).getValue());
          }
          else if(input.equals("show"))
          {
            System.out.println(list.showValues());
          }
          else if(input.length() > 7 && input.substring(0, 6).equals("remove")){
              System.out.println("removing "+input.substring(7));
              System.out.println(list.deleteAValue(input.substring(7)).getValue());
          }
          else if(input.equals("clear"))
          {
            list.clear();
          }
          else if(!input.equals("exit")){
              System.out.println("I don't know how to "+input);
          }
          input= reader.readLine();
        }
 
        // Printing the read line
        System.out.println("thanks for playing!");
        */
        LinkedList list = new LinkedList();
        list.addAValue("apple");
        list.addAValue("cherry");
        list.addAValue("grape");
        list.addAValue("banana");
        list.addAValue("date");
        list.addAValue("fig");
        list.addAValue("ct");
       
        System.out.println("Original list: " + list.showValues());
        list.deleteAValue("cherry");
        list.deleteAValue("apple");
        System.out.println("After deleting 'cherry' and 'apple': " + list.showValues());
        list.reverse();
        System.out.println("reverse: " + list.showValues());
    }
    
  }
