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
      
      
      displayHeap();
      
      }  // end trickleUp()
    
    
    

    @Override
    public T head() throws QueueUnderflowException {
       return (T)heapArray[0].itemS;
    }

    @Override
    public void remove(){
        removeNode();
        
    }
    
      @Override
    public boolean isEmpty()
      { return currentSize==0; }
    
    
    
    public void removeNode()           // delete item with max key
      {                           // (assumes non-empty list)
      Node root = heapArray[0];
      heapArray[0] = heapArray[--currentSize];
      trickleDown(0);
      
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
    
    
    public String toString(){
        
       
    String output = displayHeap();
        return output;
    }
    

  
   
    
    
 public String displayHeap() {
     String output;
     output = "heapArray: ";
      System.out.print("heapArray: ");    // array format
      for(int m=0; m<currentSize; m++)
         if(heapArray[m] != null)
            output = output+heapArray[m].getKey() + ". ";
         else
            System.out.print( "-- ");
      System.out.println();
                                          // heap format
      int nBlanks = 32;
      int itemsPerRow = 1;
      int column = 0;
      int j = 0;                          // current item
      String dots = "...............................";
      System.out.println(dots+dots);      // dotted top line

      while(currentSize > 0)              // for each heap item
         {
         if(column == 0)                  // first item in row?
            for(int k=0; k<nBlanks; k++)  // preceding blanks
               System.out.print(' ');
                                          // display item
         System.out.print(heapArray[j].getKey()+", "+heapArray[j].getItem());

         if(++j == currentSize)           // done?
            break;

         if(++column==itemsPerRow)        // end of row?
            {
            nBlanks /= 2;                 // half the blanks
            itemsPerRow *= 2;             // twice the items
            column = 0;                   // start over on
            System.out.println();         //    new row
            }
         else                             // next item on row
            for(int k=0; k<nBlanks*2-2; k++)
               System.out.print(' ');     // interim blanks
         }  // end for
      System.out.println("\n"+dots+dots); // dotted bottom line
      return output;
      }  // end displayHeap()
// -------------------------------------------------------------
   }  // end class Heap
    
    
    


