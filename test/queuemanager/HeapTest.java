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
public class HeapTest<T> {
    public Heap<T> instance;
    public HeapTest() {
    }
    /*
    This is the Heap stack, it differs from the rest because instead of ordering
    it by first in, or highest priority. It orders it into a binary tree with
    the highest priority being at the top. Looking something like this 
    
                                    17, Jim
                8, Dave                              15, Carl
        3, Shaun              5, Bob              4, Kevin              11, Karen
    
    */
    @Before
    public void setUp() throws QueueOverflowException{
    instance = new Heap<>(8);
    
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
         
        name = "Dave";
        item = (T)name;
        priority = 8;
        instance.add(item, priority);
         
        name = "Mike";
        item = (T)name;
        priority = 32;
        instance.add(item, priority);
         
        name = "Jim";
        item = (T)name;
        priority = 17;
        instance.add(item, priority);
} 
    
   

    /**
     * Test of head method, of class SortedArrayPriorityQueue.
     */
    
    @Test
    public void testIsEmpty() { //Heap has just been created items added so it should not be empty
        System.out.println("isEmpty");       
        boolean expResult = false;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
        
    }
    
       @Test
    public void testAdd() throws Exception { //testing adding items to the Heap
        System.out.println("add");
        Object name = "Adrian";
        T item = (T)name;
        int priority = 1;
        String expResult = "[(Mike, 32), (Dave, 8), (Jim, 17), (Shaun, 3), (Bob, 5), (Kevin, 4), (Adrian, 1)]"; 
       //The heap will look somewhat unordered as its being output in an array form
       //The first item in the array will always be the highest priority item though
        
        
        instance.add(item, priority);
        
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
       

     @Test   
    public void testHead() throws Exception { //the head should show the highest priority item, so in this case it should return "Mike"
       System.out.println("head");
        Object result = instance.head();
        Object expResult = "Mike";
        assertEquals(expResult, result);
        
       
    }
    @Test
    public void testRemove() throws QueueUnderflowException{ //this should remove the highest item from the heap     
        System.out.println("remove");//to test this the item will be removed and the toString value will be checked again
        instance.remove();
        String result = instance.toString(); //if the highest item got removed properly there should be no Mike in the heap as his priority is highest
        String expResult = "[(Jim, 17), (Dave, 8), (Kevin, 4), (Shaun, 3), (Bob, 5)]";
        assertEquals(expResult, result);
    }
    
    @Test
    public void testToString(){ //the toString method just outputs the entire heap 
        System.out.println("toString");
        String result = instance.toString();
        String expResult = "[(Mike, 32), (Dave, 8), (Jim, 17), (Shaun, 3), (Bob, 5), (Kevin, 4)]";
        assertEquals(expResult, result);
        //because the toString() method simply outputs the array and not the binary tree form
        //the binary tree can't be seen here however in the application it can be seen because it gets outputted
    }
    
}
