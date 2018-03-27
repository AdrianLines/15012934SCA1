/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queuemanager;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Adrian2018
 */
public class UnsortedArrayPriorityQueueTest<T> {
    public UnsortedArrayPriorityQueue<T> instance;
    public UnsortedArrayPriorityQueueTest() {
    }
    /*
    This is the Unsorted Array Priority Queue, it differs from the ordered one 
    because the items are not ordered when they are inserted but the highest 
    priority item is still removed first. This means that the "toString" will 
    return an unordered version of the Sorted ones array.
    */
    
    
    @Before
    public void setUp() throws QueueOverflowException{
    instance = new UnsortedArrayPriorityQueue<>(8);
    
     Object name;
        T item = null;
         int priority = 0;
 
        
        name = "Shaun"; //adds 3 names to the queue
        item = (T)name;
        priority = 3;
        instance.add(item, priority); 
        
        
        name = "Bob";
        item = (T)name;
        priority = 5;
        instance.add(item, priority);

        name = "Kevin";
        item = (T)name;
        priority = 4;
        instance.add(item, priority);
        
    } 
    
   

    /**
     * Test of head method, of class SortedArrayPriorityQueue.
     */
    
    @Test
    public void testIsEmpty() { //array has just been created with 2 items added so it should not be empty
        System.out.println("isEmpty");       
        boolean expResult = false;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
        
    }
    
       @Test
    public void testAdd() throws Exception { //testing adding a bunch of items to the array
                                            //because this array is unsored the items will be listed in the order that they are added in
        System.out.println("add");
        Object name = "Adrian";
        T item = (T)name;
        int priority = 1;
        
        String expResult = "[(Adrian, 1), (Kevin, 4), (Bob, 5), (Shaun, 3)]"; //the expected list is in the order of insertion rather than order of priority
        
        
        instance.add(item, priority);
        
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
       

     @Test   
    public void testHead() throws Exception { //the head should show the highest priority item, so in this case it should return "Bob" even though he is not at the top of the array
       System.out.println("head");
        Object result = instance.head();
        Object expResult = "Bob";
        assertEquals(expResult, result);
        
       
    }
    @Test
    public void testRemove() throws QueueUnderflowException{ //this should remove the highest item on the array     
        System.out.println("remove");//to test this the item will be removed and the toString value will be checked again
        instance.remove();
        String result = instance.toString(); //if the highest item got removed properly there should only be Shaun left in the array
        String expResult = "[(Kevin, 4), (Shaun, 3)]";
        assertEquals(expResult, result);
    }
    
    @Test
    public void testToString(){ //the toString method just outputs the array 
        System.out.println("toString");
        String result = instance.toString();
        String expResult = "[(Kevin, 4), (Bob, 5), (Shaun, 3)]";
        assertEquals(expResult, result);
    }
    
}
