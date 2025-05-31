import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class Toolbox 
{

  /**
   * Finds the length of a singly linked list given the head.
   *
   * @param head the head node of the singly linked list
   * @return the number of nodes in the list
   * @throws IllegalArgumentException if the head is null
   * for loops have an end. while loops dont have an end.
   * linkedlists have no indexes
   * length of the linked list 
   * how many times does 5 show up 
   * how many times the majority number is repeated
   * 
   * 
   * 
   * 
   */

  //one input named head, method named length returns int 
  public static int length(SingleNode head) 
  {
    //basecase
    if(head == null)
    {
      throw new IllegalArgumentException("head cannot be null");
    }

    //current is the variable to iterate through the list
    //it starts at head
    SingleNode current = head;
    //tracker that counts the nodes when we visit it
    int count = 0;

    //while current which is head is not null keep visiting
    while(current != null)
    {
      //move to the next node
      current = current.next;
      //add 1 to the counter because we just visited
      count++;
    }
    //return total count of nodes
    return count;


  }





  /**
   * Finds the tail of a singly linked list given the head.
   *
   * @param head the head node of the singly linked list
   * @return the tail node of the list, or null if the list is empty
   * @throws IllegalArgumentException if the head is null
   */
  public static SingleNode findTail(SingleNode head) 
  {
    //base case, if head is null dont move on
    if (head == null)
    {
      throw new IllegalArgumentException("Head cannot be null");
    }


    SingleNode current = head; //creating object to enter data with

    while(current.next != null) //while the next pointer is not null continue
    {
      current = current.next; //move to the next
    }

    return current; //move until the end is reached return

  }




  /** 
   * Finds the head of a doubly linked list given the tail.
   *
   * @param tail the tail node of the doubly linked list
   * @return the head node of the list, or null if the list is empty
   * @throws IllegalArgumentException if the tail is null
   */
  public static DoubleNode findHead(DoubleNode tail) 
  {
      if(tail==null)
      {
        throw new IllegalArgumentException("tail cannot be null");
      }

      DoubleNode current = tail;

      while(tail.prev != null)
      {
        current = current.prev;
      }

      return current;
  } 


  /**
   * Counts the occurrences of values in a linked list.
   *
   * @param head the head node of the linked list
   * @return a map where the keys are the values in the list, and the values are the counts of occurrences
   * @throws IllegalArgumentException if the head is null
   */
  public static Map<Integer, Integer> countOccurrences(SingleNode head) //always look into the datatype thats being returned and passed in, to create objects from.
  {
    if(head == null)
    {
      throw new IllegalArgumentException ("head cannot be null");
    }

    SingleNode current = head;
    Map<Integer, Integer> mapper = new HashMap<>();

    while(current != null)
    {
      int key = current.data; //key is the value. get data, number for the current code

      if(!mapper.containsKey(key))
      {
        mapper.put(key, 1); //1 is the first occurance since values are the counts
      }
      else//else will be prevalent with maps that count values
      {
        mapper.put(key, mapper.get(key) + 1); //if weve seen it then get it then plus one
      }
      current = current.next;
    }
    return mapper;

  }







  /**
   * Removes a node from a doubly linked list.
   *
   * @param node the node to remove
   * @throws IllegalArgumentException if the node is null
   */
  public static void removeNode(DoubleNode node) 
  {
    if(node == null)
    {
      throw new IllegalArgumentException("head cannot be null");
    }


    //this points b to a as prev and next is b to c  
    //c a no more b
    if (node.prev != null)
    {
      node.prev.next = node.next;
    }
    
    //c as next points to a which is prev c A
    if(node.next != null)
    {
      node.next.prev = node.prev;
    }

    node.prev = null;
    node.next = null;

    node = null;
  }


  /**
   * Finds the nth element in a singly linked list.
   *
   * @param head the head node of the singly linked list
   * @param n the index of the element to find (0-based)
   * @return the nth node, or null if the index is out of bounds
   * @throws IllegalArgumentException if the head is null or n is negative
   */
  public static SingleNode findNthElement(SingleNode head, int n) 
  {
    //is the list empty dont move on if so
    if(head == null)
    {
      throw new IllegalArgumentException("head cannot be null");
    }//check if n is negative..index
    if(n<0)
    {
      throw new IllegalArgumentException("index cannot be negative");
    }

    //currrent is head the start
    SingleNode current = head;

    //tracker called count to track moves
    int count = 0;

    //keep going until weve reached the nth node
    while(current != null && count < n)//do not move foward once you have reached n steps
{
  current = current.next;
  count++;
}
    return current;
    
  }






  /**
   * Inserts a new node into a singly linked list given a pointer to a node in the middle of the list.
   *
   * @param node the node after which the new node is to be inserted
   * @param newNode the new node to insert
   * @throws IllegalArgumentException if either node or newNode is null
   */
  public static void insertNode(SingleNode node, SingleNode newNode) //single node is just a pointer
  {
    //check if either is null
    if(node == null || newNode == null)
    {
      throw new IllegalArgumentException("head cannor be null");
    }

    //a points to b. new node and head points to b
    //1 node. node.next is 2.....123. we want new node 4 in between 1and 2 now
    newNode.next = node.next;

    //this makes the current one point to the newnode 1 to 4
    node.next = newNode;

  }







  /**
   * Removes all nodes that are strictly larger than their next neighbor in the original list, except for the head.
   * The head is never removed.
   * 
   * The removals are done in-place.
   * 
   * Example:
   * Input: 5 -> 7 -> 6 -> 20 -> 4 -> 4
   * Output: 5 -> 6 -> 4 -> 4
   * 
   * Explanation: 7 is greater than 6 and 20 is greater than 4, so these nodes are removed.
   *
   * @param head the head of the list
   * @throws IllegalArgumentException if the head is null
   */
  public static void removeGiants(SingleNode head) 
  {
    if(head == null)
    {
      throw new IllegalArgumentException("head cannot be null");
    }

    SingleNode current = head;

    //does this mean 5 and 6 isnt null?
    while(current != null && current.next.next != null)
    {
      if(current.next.data > current.next.next.data)
      {
        current.next = current.next.next;
      }
      current = current.next;
    }
    
  };


    /**
     * Triples the value of every element in a queue in-place.
     * 
     * Only O(1) space should be used.
     * 
     * You can assume the queue will have first-in-first-out behavior.
     *
     * Example:
     * Input: [5, 3, 2, 7] 
     * Result: [15, 9, 6, 21]
     *
     * @param queue the queue to modify
     * @throws IllegalArgumentException if the queue is null
     */
    public static void tripleValues(Queue<Integer> queue) 
    {
      if(queue == null)
      {
        throw new IllegalArgumentException("queue cannot be null");
      }

       // Get the number of elements currently in the queue
        int size = queue.size(); //creating size object as queue.size

      for(int i = 0; i < size; i++)
      {
        int value = queue.poll();// poll() removes and return the first item

        int tri = value * 3; //* by three 

        queue.offer(tri); //offer adds to the back of the queue
      }
      
    }


  /**
   * Rotates a queue to the left by the specified number of positions in-place.
   * 
   * The first k elements of the queue are moved to the end, preserving the order
   * of all elements.
   * 
   * Only O(1) space should be used.
   * 
   * You can assume the queue will have first-in-first-out behavior.
   *
   * Example:
   * Given a queue [1, 2, 3, 4, 5] and k = 2, the result will be [3, 4, 5, 1, 2].
   *
   * @param queue the queue to rotate
   * @param k the number of positions to rotate to the left
   * @throws IllegalArgumentException if the queue is null or k is negative
   */
  public static void rotateQueueLeft(Queue<Integer> queue, int k) 
  {
    if(queue == null || k < 0)
    {
      throw new IllegalArgumentException("Queue cannot be null and k cannot be negative");
    }

    int size = queue.size();

    for (int i = 0; i < k; i++) //iterates the loop stops at k
    {
     int value = queue.poll(); //remove from front
     int tri = value * 3;
     
      queue.offer(tri); //add to back 
    }

  }

  /**
   * Checks if a string has balanced parentheses using a stack.
   * 
   * A string is considered to have balanced parentheses if each opening parenthesis
   * '(' has a corresponding closing parenthesis ')', and the parentheses are correctly nested.
   *
   * Example:
   * - Input: "(()())" -> Returns true
   * - Input: "(()" -> Returns false
   * - Input: ")" -> Returns false
   *
   * @param input the string to check
   * @return true if the string has balanced parentheses, false otherwise
   * @throws IllegalArgumentException if the input string is null
   */
  //when using a pop in a list it will remove from the list size
  //use a while loop instead of a for each loop if you need to iterate through a string
  public static boolean hasBalancedParentheses(String input)  
  {
    //Check for null input
    if (input == null) 
    {
        throw new IllegalArgumentException("Input string cannot be null");
    }
    
    Stack<Character> stack = new Stack<>();
  
    //converts the string to a char array to iterate 
   for(char c : input.toCharArray()) //first time the loop runs the opeing (
   {
    if (c == '(')
    {
      stack.push(c); //push the opening ( into the stack 
    }
    else if (c == ')')
    {
      if (stack.isEmpty())
      {
        return false;
      }
      stack.pop();
    }
   }


  // Return true if all open parentheses were closed
  return stack.isEmpty();

  }

  /**
   * Returns the name of the person who has the highest score associated with them in a map.
   * 
   * The keys hold the names of the players and the values hold the scores. 
   * 
   * For example: 
   * {
   *  "Lewis": 20,
   *  "Yuki": 23,
   *  "Kimi": 16
   * }
   * 
   * Yuki has the highest score.
   * 
   * In the event of a tie, the person whose name comes first lexicographically (alphabetically) should
   * be returned.
   * 
   * @param scores
   * @return the person with the highest score, or the first person lexicographically if there is a tie
   * @throws IllegalArgumentException if the scores are null or empty
   */
  public static String topScorer(Map<String, Integer> scores) 
  {
    //determin the highest score in the map
    //keep track of who has the highest score in the map
    //for each loop
    //key object to get name
    //value object to get the highest score( in order to get a value use a key)

    String name = ""; //this will keep track of the high score name
    int maxScore = 0; //tracker for high score


    for(String entry : scores.keySet()) //score is the name and the key is a string
      {
        if(scores.get(entry) > maxScore || (scores.get(entry) == maxScore && entry.charAt(0) < name.charAt(0)))//entry is string of the map key set
        {
          maxScore = scores.get(entry); //save the highest score found
          name = entry;
        }

      }
   

  return name; // Return name
  
  }
}