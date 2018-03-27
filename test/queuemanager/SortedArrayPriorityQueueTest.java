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
public class SortedArrayPriorityQueueTest<T> {
    public SortedArrayPriorityQueue<T> instance;
    public SortedArrayPriorityQueueTest() {
    }
    /*
    This is our standard Ordered Array Priority Queue. Items are added and ordered
    and removed highest priority first     
    */
    @Before
    public void setUp() throws QueueOverflowException{
    instance = new SortedArrayPriorityQueue<>(8);
    
     Object name;
        T item = null;
         int priority = 0;
         
    name = "Bob"; //adds 2 names to the queue
        item = (T)name;
        priority = 5;
        instance.add(item, priority);
        
        name = "Shaun";
        item = (T)name;
        priority = 3;
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
        System.out.println("add");
        Object name = "Adrian";
        T item = (T)name;
        int priority = 1;
        
        String expResult = "[(Bob, 5), (Kevin, 4), (Shaun, 3), (Adrian, 1)]";
        
        
        instance.add(item, priority);
        
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
       

     @Test   
    public void testHead() throws Exception { //the head should show the highest priority item, so in this case it should return "Shaun"
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
        String expResult = "[(Bob, 5), (Kevin, 4), (Shaun, 3)]";
        assertEquals(expResult, result);
    }
    
}
