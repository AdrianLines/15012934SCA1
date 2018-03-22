/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queuemanager;
import java.util.*;
/**
 *
 * @author 15012934
 */
public class OrderedLinkedList<T> implements PriorityQueue<T> {
     LinkList theLinkedList = new LinkList();
        public int priority;
        public T item;
       

        public OrderedLinkedList next;
        
        public OrderedLinkedList(T item, int priority){
            this.priority = priority;
            this.item = item;
        }

    OrderedLinkedList() {
      
         
         
    }
    

        
        public String toString(){ //takes the object "item" and puts it to string
            String result = theLinkedList.theString(); //sets theLinkedList through theString method to get the string for it
           
          return result;  //returns the string
        }

    @Override
    public void add(T item, int priority) throws QueueOverflowException { //creates a new link using the item and priority variables
        
   
        
        theLinkedList.insertFirstLink(item,priority); //calls the "insertFirstLink" method 
            
       
        
    }

    @Override
    public T head() throws QueueUnderflowException { //returns the highest priority item, in the case of the ordered list it should always be the first item.
     
        if (!theLinkedList.isEmpty()){
    
      return  theLinkedList.find(item,priority);
        }else{
             throw new QueueUnderflowException();
        }
        
    }

    @Override
    public void remove() throws QueueUnderflowException { //removes the item with the highest priority
        if (!theLinkedList.isEmpty()){
        theLinkedList.removeFirst(); //runs the removeLink method
        
        }else{
             throw new QueueUnderflowException();
        }
    }

    @Override
    public boolean isEmpty() { //checks if the list is empty.
        return theLinkedList.isEmpty(); //basically just checks if the firstLink in the list is null or not.
    }
        
        
       
        
        
class LinkList{
    public OrderedLinkedList firstLink;
     public Object PriorityItem = null; //creates and object for the highest prio item, used in the remove method
    LinkList(){ //sets the list to be empty
        firstLink = null;
        
    }
    
    
    /*Checks if the list is empty*/
    public boolean isEmpty(){ //checks if the list is empty by checking the first link
        return(firstLink == null);
    }
    
    
    
    /*Inserts first Link*/
    public void insertFirstLink(T item, int priority){
         OrderedLinkedList pointerLink = firstLink; //creates a new link that is used to scroll through the list
         OrderedLinkedList newLink = new OrderedLinkedList(item, priority); //creates a new link that is set to be the newLink
        OrderedLinkedList prevLink = firstLink; //creates a new link that is set to be a link behind the current  link

        
        while(pointerLink != null){//while loop that looks for the highest priority link and removes it
            
                
                if(pointerLink.priority < newLink.priority){ //when the priority is the highest priority in the list
                    
      
                 
                 if(pointerLink == firstLink){
                        //adds link in the first position
                     
                     newLink.next = firstLink;
                     firstLink = newLink;
                 }else{
                     //adds link into anywhere that isn't the first link
                     prevLink.next = newLink;
                    newLink.next = pointerLink;

                 }
                    
                    break; // finish the loop
                    
                }else if (pointerLink.next == null){
                    //adds link to the end of the list
                    pointerLink.next = newLink;

             
                    break;
                    
                    
                }else{prevLink = pointerLink; // scrolls to the next link
                    pointerLink = pointerLink.next;
                }
                
               
                
        }
                if(firstLink==null){ //if the list is empty it creates a firstLink
                    System.out.println("firstlink added");
                
                    firstLink = newLink;
                }

        
    } 
        
   /* Removes the first Link from the list*/
    public void removeFirst(){
        
                if(!isEmpty()){
                    System.out.println("link removed");
        firstLink = firstLink.next; //sets the second link to be the first link, removing the first link.
    }else{
                    System.out.println("Empty List");
                }
                
               
    }
    
    
    /*Returns the string value for the list*/
     public String theString(){ //displays the contents of the linked list
        OrderedLinkedList theLink = firstLink;
        String result = "[";
        Object item;
     
        String priority;
        while(theLink != null){         //while loop that runs through the list outputting each item
            if(theLink != firstLink){
              result = result + ", ";  
            }
            priority = Integer.toString(theLink.priority); //sets priority value
            item =   (Object)theLink.item; //sets the item value
            
            
            result = result +item + ", " + priority; //adds the values to the string with a comma in between them
            
            theLink = theLink.next;
            
        }
        result = result +"]"; //closes the string with a bracket
        return result;
    }
    
     /*Method used during testing to help display the list*/
    public void display(){ //DISPLAY METHOD ENTIRELY USED FOR TESTING
        OrderedLinkedList theLink = firstLink;
        while(theLink != null){
            System.out.println("this Link: " + theLink +" "+theLink.priority);
            System.out.println("next Link: " + theLink.next);
            theLink = theLink.next;
            System.out.println("");
        }
    }
    
    
    /*Finds the highest priority item in the list, in this case it's always the first item*/
    public T find(T item, int priority){
        
        PriorityItem = new Object();
 
        
        
        
       
       item = (T) firstLink.item;
        priority = firstLink.priority;
        
       PriorityItem =  new PriorityItem<>(item, priority); //the PriorityItem is created from the firstLink
        
        return ((PriorityItem<T>) PriorityItem).getItem(); //returns the item from priorityItem
    }
    
    
    
  }
}