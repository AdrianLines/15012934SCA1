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
     
        return  theLinkedList.find(item,priority);

    }

    @Override
    public void remove() throws QueueUnderflowException { //removes the item with the highest priority
        theLinkedList.removeLink();
        theLinkedList.display(); //outputs the current list because the "P" output doesn't work
    }

    @Override
    public boolean isEmpty() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        //Object PriorityItem = newPriorityItem<>(item, priority);
        
        
        
        highest();
        if(!isEmpty()){
            while(theLink !=null){
                if(theLink.priority == highest()){
                  
                     highLink = theLink;
                } 
                  
                    theLink = theLink.next;
                
            }
        }else {
            System.out.println("Empty List");
        }
       item = (T) highLink.item;
        priority = highLink.priority;
        
       PriorityItem =  new PriorityItem<>(item, priority);
        
        return ((PriorityItem<T>) PriorityItem).getItem();
    }
    
    
    public int highest(){
        int highest = 0;
                UnorderedLinkedList theLink = firstLink;
        
        while(theLink != null){
           
            if(theLink.priority > highest){
                highest = theLink.priority;
            }
            theLink = theLink.next;
            
        }
        return highest;
        
    }
    public void removeLink(){
        UnorderedLinkedList currentLink = firstLink;
        UnorderedLinkedList previousLink = firstLink;
        int finished = 0;
        highest();
        
        while(currentLink != null){
            
                
                if(currentLink.priority == highest()){
                    previousLink.next= currentLink.next;
                    finished = 1;
                 
                    
                    break;
                    
                }
                if(finished != 1){
                previousLink = currentLink;
                currentLink = currentLink.next;
            
               }
        }
       
        if(currentLink == firstLink){
            firstLink = firstLink.next;
            
        }

    }
    }
        

}