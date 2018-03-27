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
public class OrderedLinkedListTest<T> {
    public OrderedLinkedList<T> instance;
    public OrderedLinkedListTest() {
    }
    /*
    This is the Ordered Linked List Priority queue, the results will be the same
    as the Sorted Array one but the Linked list can have as many links as it 
    needs, to test this I will add in more than the 8 items that were given to
    the arrays.
    */
    @Before
    public void setUp() throws QueueOverflowException{
    instance = new OrderedLinkedList<>();
    
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
         
        name = "Carl";
        item = (T)name;
        priority = 15;
        instance.add(item, priority);
         
        name = "Karen";
        item = (T)name;
        priority = 11;
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
    public void testIsEmpty() { //List has just been created with 8 items added so it should not be empty
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
        String expResult = "[(Mike, 32), (Jim, 17), (Carl, 15), (Karen, 11), (Dave, 8), (Bob, 5), (Kevin, 4), (Shaun, 3), (Adrian, 1)]"; 
        //this List now contains more than 8 items which means its bigger than the assigned value for the arrays
        
        
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
    public void testRemove() throws QueueUnderflowException{ //this should remove the highest item on the array     
        System.out.println("remove");//to test this the item will be removed and the toString value will be checked again
        instance.remove();
        String result = instance.toString();//if the highest item got removed properly there should be no Mike in the array as his priority is highest
        String expResult = "[(Jim, 17), (Carl, 15), (Karen, 11), (Dave, 8), (Bob, 5), (Kevin, 4), (Shaun, 3)]";
        assertEquals(expResult, result);
    }
    
    @Test
    public void testToString(){ //the toString method just outputs the entire list 
        System.out.println("toString");
        String result = instance.toString();
        String expResult = "[(Mike, 32), (Jim, 17), (Carl, 15), (Karen, 11), (Dave, 8), (Bob, 5), (Kevin, 4), (Shaun, 3)]";
        assertEquals(expResult, result);
    }
    
}
