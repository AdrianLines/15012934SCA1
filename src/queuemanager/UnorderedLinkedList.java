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
public class UnorderedLinkedList<T> implements PriorityQueue<T> {
     LinkList theLinkedList = new LinkList(); //create a new linked list
        public int priority;                  //creating a priority variable
        public T item;                        //creating item variable
        public String itemString;             //string value of the item

        public UnorderedLinkedList next;      //next link in the chain
        
        public UnorderedLinkedList(T item, int priority){ //creates link
            this.priority = priority;
            this.item = item;
        }

    UnorderedLinkedList() {
      
         
         
    }
    
        public void display(){ //displays an item from the list
            System.out.println(item + ": " + priority);
            
        }
        
        public String toString(){ //takes the object "item" and puts it to string
            String itemString = String.valueOf(item);
          return itemString;  
        }

    @Override
    public void add(T item, int priority) throws QueueOverflowException { //adds an item to the list (creates a link)
        
   
      
        theLinkedList.insertFirstLink(item,priority); //adds item to the front of the list
         
        
    }

    @Override
    public T head() throws QueueUnderflowException { //outputs the item with the highest priority
         if (!theLinkedList.isEmpty()){
                return  theLinkedList.find(item,priority);
        }else{
                throw new QueueUnderflowException();
        }
    }

    @Override
    public void remove() throws QueueUnderflowException { //removes the item with the highest priority
        if (!theLinkedList.isEmpty()){
        theLinkedList.removeLink(); //runs the removeLink method
        theLinkedList.display(); //outputs the current list because the "P" output doesn't work
        }else{
             throw new QueueUnderflowException();
        }
    }

    @Override
    public boolean isEmpty() { //checks if the q is empty
        return theLinkedList.isEmpty();
    }
        
        
       
        
        
class LinkList{
    public UnorderedLinkedList firstLink; //creates a link
     public Object PriorityItem = null; //creates and object for the highest prio item, used in the remove method
    LinkList(){
        firstLink = null;//clears the linked list
        
    }
    
    public boolean isEmpty(){
        return(firstLink == null); //checks if the list is empty
    }
    
    public void insertFirstLink(T item, int priority){ //inserts an item to the top of the list
        UnorderedLinkedList newLink = new UnorderedLinkedList(item, priority); //creates the link 
       
       newLink.next = firstLink; //moves the initial first link to be the new links next link
       
        firstLink = newLink; //sets the new link to be the first link
       
     
              
        
  
        
    } 
        

     
    
    public void display(){ //displays the contents of the linked list
        UnorderedLinkedList theLink = firstLink;
        while(theLink != null){         //while loop that runs through the list outputting each item
            System.out.println("this Link: " + theLink +" "+theLink.priority);
            System.out.println("next Link: " + theLink.next);
            theLink = theLink.next;
            System.out.println("");
        }
    }
    
    
    
    public T find(T item, int priority){ //finds the highest priority
        UnorderedLinkedList theLink = firstLink; //creates a link 
        UnorderedLinkedList highLink = firstLink; //creates a link that is the link behind the other 
        PriorityItem = new Object();
        
        
        
        
        highest(); //gets the int value for the highest priority link this is used in the remove function as well so
        if(!isEmpty()){
            while(theLink !=null){ //while loop to look for the highest priority link
                if(theLink.priority == highest()){ //if the priority of theLink is the same as the highetst priority in 
                                                    //the queue it will set the "highLink" to be the link"
                  
                     highLink = theLink;
                } 
                  
                    theLink = theLink.next;//sets theLink to the next one so it can run through the 
                
            }
        }else {
            System.out.println("Empty List"); //this happens if empty
        }
       item = (T) highLink.item;
        priority = highLink.priority;
        
       PriorityItem =  new PriorityItem<>(item, priority); //the PriorityItem is created from the highLink 
        
        return ((PriorityItem<T>) PriorityItem).getItem(); //returns the item from priorityItem
    }
    
    
    public int highest(){ //returns the priority of the highest value in the list
        int highest = 0; //int used whenever a new highest number is found it puts it here
                UnorderedLinkedList theLink = firstLink; //creates a new link
        
        while(theLink != null){ //while loop that checks each item in the list for the highest priority
           
            if(theLink.priority > highest){ 
                highest = theLink.priority;
            }
            theLink = theLink.next;
            
        }
        return highest;
        
    }
    public void removeLink(){ //method that removes the highest priority link in the list
        UnorderedLinkedList currentLink = firstLink; //creates a new link that is used to scroll through the list
        UnorderedLinkedList previousLink = firstLink; //creates a new link that is set to be a link behind the current  link
        int finished = 0; 
        highest(); //finds highest priority
        
        while(currentLink != null){//while loop that looks for the highest priority link and removes it
            
                
                if(currentLink.priority == highest()){ //when the priority is the highest priority in the list
                    previousLink.next= currentLink.next; //set the previouslink.next to the currentlink.next effectively removing the link
                    finished = 1;
                 
                    
                    break; // finish the loop
                    
                }
                if(finished != 1){
                previousLink = currentLink;
                currentLink = currentLink.next;
            
               }
        }
       
        if(currentLink == firstLink){ //if the link is the only link in the list then set the firstlink to be the second link which is null
            firstLink = firstLink.next;
            
        }

    }
    }
        

}