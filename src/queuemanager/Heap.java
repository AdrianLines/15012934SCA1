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

    
public Heap(int size) {          // heap Constructor
      
      maxSize = size;       //max size of array
      currentSize = 0;      //current size of array
      heapArray = new Node[maxSize];  //create heap array 
      }
    

      /*add Method*/
    @Override
    public void add(T item, int priority) throws QueueOverflowException { //this method adds items to the array and runs the "shiftItemsUp" method to sort them
        if(currentSize >= maxSize){//checks to see if the array is full or not
             throw new QueueOverflowException(); //if its full then an overflow exception is thrown         
        }else{
            Node newNode = new Node(item, priority);//creates a new node with the item and priority given
            heapArray[currentSize] = newNode; //inserts the new node at the last position in the array
            shiftItemsUp(currentSize++);    //runs the shift items up method to find the correct location for the node
           
        }
    }
    
    
    /*shiftItemsUp Method*/
    public void shiftItemsUp(int index){ // this method takes the priority of the item and shifts it up the arrray until it finds the correct position
      int parent = (index-1) / 2; //in a heap a parent items children are always equal to (position in the array * 2) + 1 and (position in the array * 2) + 2
                                    
      Node bottom = heapArray[index]; //the last node is equal to the node that was just added

      while( index > 0 && //while loop that runs whenever the priority of the parent node is lower than the node that was added,
             heapArray[parent].getKey() < bottom.getKey() )//while the new node is higher priority it will continue to move up
         {
         heapArray[index] = heapArray[parent];  //moves the new node downwards
         index = parent; //sets the next index position to be the parent position
         parent = (parent-1) / 2; //sets the parents position to be the old index position
         }  
      
      
      heapArray[index] = bottom; //sets the index to be the bottom node again

      
      }  
    
    
    
    /*head Method*/
    @Override
    public T head() throws QueueUnderflowException { // method used to output the highest node in the heap
        if(!isEmpty()){ //if the array isn't empty
       return (T)heapArray[0].itemS; //return the first array values item.
        }
        else{ //if the array is empty
                throw new QueueUnderflowException();
        }
    }

    
    
    /*remove Method*/
    @Override
    public void remove() throws QueueUnderflowException { //this method is used to remove the item at the top of the heap but if needed could be used to remove any item from the heap
         if(!isEmpty()){
      
      heapArray[0] = heapArray[--currentSize]; //sets a new first node and runs the shiftItemsDown method
      shiftItemsDown(0);
         }else{
                throw new QueueUnderflowException();
        }
    }
    
    
    
    /*isEmpty Method*/
      @Override
    public boolean isEmpty() {//checks if the array is empty
       return currentSize==0; //if the currentSize value is 0 then the array will be empty
    } 
  
    
    
    /*shiftItemsDown Method*/
    public void shiftItemsDown(int index) //this method is used to find an items proper location by checking if its smaller than the ones below it.
      {
      int largestChild; //creates variable for the largest child
      Node parent = heapArray[index];       // creates a node for the item in the "index" position in the array
      
      
      while(index < currentSize/2){      // while the node has a child
                                       
         int leftChild = 2*index+1; //creates 2 variables for left and right child, the left child is always = parent*2+1
         int rightChild = leftChild+1; //  right child is is 1 position farther in the array than the left one
                                         // find larger child
         if(rightChild < currentSize &&  // if the right echild exists
            heapArray[leftChild].getKey() <  heapArray[rightChild].getKey()){// and the left child priority is is smaller than the right child priority
            largestChild = rightChild; //the largestChild is the rightChild
         }else{
            largestChild = leftChild; //otherwise the leftChild is the largestChild
         }                                
         if( parent.getKey() >= heapArray[largestChild].getKey() ){// if the parent is bigger than the child
            break; //finish the loop
         }else{ 
                                        
         heapArray[index] = heapArray[largestChild]; // set the index value to be the largest child essentially moving the node downwards
         index = largestChild;  
         }         
         }  // end while
      heapArray[index] = parent;            // sets parent to index
      }  
    
    
    
    
    

  
   
    
  /*toString Method*/
 public String toString() { //this method creates a string value for the array to be displayed in but also outputs a binary tree representation of the heap
     String output; //creates a string value for the array to be displayed in
     output = "["; //starts string with a bracket
     
      for(int i=0; i<currentSize; i++) //for loop to create the string
         if(heapArray[i] != null){
             if(i == currentSize - 1){ //if the array item is the last item in the array it won't add a comma
               output = output+"("+heapArray[i].getItem() +", "+heapArray[i].getKey()+")";  //adds item to string
             }else{
                output = output+"("+heapArray[i].getItem() +", "+heapArray[i].getKey()+")" + ", "; //adds item to string  
             }      
         }
           output = output + "]"; //closes the string with another bracket
            

      /* BINARY TREE OUTPUT */
      //many ways of outputting a binary tree can be found on the internet
      
      int nBlanks = 32;
      int itemsPerRow = 1; 
      int column = 0;
      int j = 0;                          // current item
      String dottedLine = "...............................";
      System.out.println(dottedLine+dottedLine);      // dotted top line

      while(currentSize > 0)              // runs this while the currentSize is more than 0 
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
      System.out.println("\n"+dottedLine+dottedLine); // dotted bottom line
      return output;
      } 
   } 
    
    


