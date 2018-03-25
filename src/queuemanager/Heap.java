/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queuemanager;


import java.util.*;

/**
 *
 * @author Adrian2018
*/

public class Heap<T> implements PriorityQueue<T>{
      
    
private Node[] heapArray;
   private int maxSize;           // size of array
   private int currentSize;       // number of nodes in array

    
public Heap(int size) {          // constructor
      
      maxSize = size;
      currentSize = 0;
      heapArray = new Node[maxSize];  // create array
      }
    

    @Override
    public void add(T item, int priority) throws QueueOverflowException {
        Node newNode = new Node(item, priority);
        heapArray[currentSize] = newNode;
        trickleUp(currentSize++);
        System.out.println("Node added to heap");
    }
    
    public void trickleUp(int index){
      int parent = (index-1) / 2;
      Node bottom = heapArray[index];

      while( index > 0 &&
             heapArray[parent].getKey() < bottom.getKey() )
         {
         heapArray[index] = heapArray[parent];  // move it down
         index = parent;
         parent = (parent-1) / 2;
         }  // end while
      heapArray[index] = bottom;
      }  // end trickleUp()
    
    
    

    @Override
    public T head() throws QueueUnderflowException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remove(){
        removeNode();
        
    }
    
    public Node removeNode()           // delete item with max key
      {                           // (assumes non-empty list)
      Node root = heapArray[0];
      heapArray[0] = heapArray[--currentSize];
      trickleDown(0);
      return root;
      }  // end remove()
    
    
    
    public void trickleDown(int index)
      {
      int largerChild;
      Node top = heapArray[index];       // save root
      while(index < currentSize/2)       // while node has at
         {                               //    least one child,
         int leftChild = 2*index+1;
         int rightChild = leftChild+1;
                                         // find larger child
         if(rightChild < currentSize &&  // (rightChild exists?)
                             heapArray[leftChild].getKey() <
                             heapArray[rightChild].getKey())
            largerChild = rightChild;
         else
            largerChild = leftChild;
                                         // top >= largerChild?
         if( top.getKey() >= heapArray[largerChild].getKey() )
            break;
                                         // shift child up
         heapArray[index] = heapArray[largerChild];
         index = largerChild;            // go down
         }  // end while
      heapArray[index] = top;            // root to index
      }  // end trickleDown()
    
    
    
    

    @Override
    public boolean isEmpty()
      { return currentSize==0; }
    


}
class Node
   {
   public Object itemS;
   public int priority;           // data item (key)
// -------------------------------------------------------------
   public Node(Object item, int key)           // constructor
      { 
       itemS = item;
       priority = key;
   
   }
// -------------------------------------------------------------
   public int getKey()
      { return priority; }
// -------------------------------------------------------------
   public void setKey(int id)
      { priority = id; }
   // -------------------------------------------------------------
   public Object getItem()
      { return itemS; }
// -------------------------------------------------------------
   public void setItem(Object nodeItem)
      { itemS = nodeItem; }
// -------------------------------------------------------------
   }  // end class Node