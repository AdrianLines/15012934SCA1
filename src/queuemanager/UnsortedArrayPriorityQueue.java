
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queuemanager;

/**
 *
 * @author 15012934
 */
public class UnsortedArrayPriorityQueue<T> implements PriorityQueue<T>{
    
//    As this code is very similar to the SortedArrayPriorityQueue it will look very similar
    
    
    
    
      /**
     * Where the data is actually stored.
     */
    private final Object[] storage;

    /**
     * The size of the storage array.
     */
    private final int capacity;

    /**
     * The index of the last item stored.
     *
     * This is equal to the item count minus one.
     */
    private int tailIndex;
    
  
    
public UnsortedArrayPriorityQueue(int size) {
    storage = new Object[size];
    capacity = size;
    tailIndex = -1;
      
    }




/*Returns the highest priority item in the queue*/
    @Override
    public T head() throws QueueUnderflowException {
        int highestFound=0; // sets value for highest found priority
        int currentPri = 0; //sets value for current priority
        Object currentTI= 0; //creates an object for the currentitem if its the highest priority item
        int i = tailIndex;
  

     
  
            while (i > -1) { //while loop that changes the highestFound and currentTI values every time it finds a higher priority item
    
                
                currentPri = ((PriorityItem<T>) storage[i]).getPriority();
               if (currentPri > highestFound){
                   highestFound = currentPri;
                   currentTI = storage[i];
               }
            
                    i = i - 1; 
            }
       
        
        
        if (isEmpty()) {
            throw new QueueUnderflowException();
        } else {
            
            return ((PriorityItem<T>) currentTI).getItem(); //returns the priority item for currentTI
        }
    }

    
    /*Removes the highest priority item from the list*/
    @Override
    public void remove() throws QueueUnderflowException {
     int highestFound=0;
        int currentPri = 0;
        int shiftfromhere = 0; //creates a value that the array needs to shift from when the item is removed
        int q=0; //this is the value that will be removed
        int i = tailIndex;
  
        
     
  
            while (i > -1) { //while loop that finds the highest priority int
             

                
                currentPri = ((PriorityItem<T>) storage[i]).getPriority(); 
               if (currentPri > highestFound){
                   highestFound = currentPri;
                   q = i; 
                   
               }
               
     
            
       
                    i = i - 1; 
            }
       
        
        
        if (isEmpty()) {
            throw new QueueUnderflowException();
        } else {
            for (int j = 0; j < tailIndex; j++) { //runs for loop that when the storage[] item is the correct one it removes it and loewrs the tail index by 1;
                if (j == q){
      
                
                        
                    storage[j] = storage[j+1];
                    
                }
            }
            tailIndex = tailIndex - 1;
        }


    }
    
/*Inserts item to the top of the array*/
@Override
    public void add(T item, int priority) throws QueueOverflowException {
        tailIndex = tailIndex + 1;
        if (tailIndex >= capacity) { //checks if the queue is full or not
         
            tailIndex = tailIndex - 1;
            throw new QueueOverflowException();
            
        
    }else{ //moves all the items down a position and adds the new item
            int i = tailIndex;
            while (i > 0) {
                storage[i] = storage[i - 1];
                i = i - 1; 
            }
            storage[i] = new PriorityItem<>(item, priority); //adds the new item at the top of the queue 
        }
    }

/* Checks if the queue is empty or not*/
    @Override
public boolean isEmpty()   { return tailIndex < 0; }


/*Turns the queue into a string*/
@Override
    public String toString() {
        String result = "[";
        for (int i = 0; i <= tailIndex; i++) {
            if (i > 0) {
                result = result + ", ";
            }
            result = result + storage[i];
        }
        result = result + "]";
   
        return result;
    }


}


