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





    @Override
    public T head() throws QueueUnderflowException {
        int highestFound=0;
        int i = tailIndex;
        String storageString;
        int storageInt;
        int x =333;
     
  
            while (i > 0) {
                storage[i] = storage[i - 1];
                storageString = storage[i].toString();
               
               x = Integer.parseInt(storageString);
               
                if(x > highestFound){
                     System.out.println(highestFound+" wow");
                     System.out.println(x);
                }
                    i = i - 1; 
            }
         System.out.println(x);
        System.out.println(highestFound);
        
        if (isEmpty()) {
            throw new QueueUnderflowException();
        } else {
            return ((PriorityItem<T>) storage[0]).getItem();
        }
    }

    @Override
    public void remove() throws QueueUnderflowException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
// insert an item to the end of the array
@Override
    public void add(T item, int priority) throws QueueOverflowException {
        tailIndex = tailIndex + 1;
        if (tailIndex >= capacity) { 
         
            tailIndex = tailIndex - 1;storage[1] = new PriorityItem<>(item, priority);
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

// Is the queue empty?
    @Override
public boolean isEmpty()   { return tailIndex < 0; }

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