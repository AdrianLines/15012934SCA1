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
        public String itemString;

        public OrderedLinkedList next;
        
        public OrderedLinkedList(T item, int priority){
            this.priority = priority;
            this.item = item;
        }

    OrderedLinkedList() {
      
         
         
    }
    
//        public void display(){
//            System.out.println(item + ": " + priority);
//            
//        }
        
        public String toString(){
            String itemString = String.valueOf(item);
          return itemString;  
        }

    @Override
    public void add(T item, int priority) throws QueueOverflowException {
        
   
        
        theLinkedList.insertFirstLink(item,priority);
               theLinkedList.display();
       
        
    }

    @Override
    public T head() throws QueueUnderflowException {
     
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
        theLinkedList.display(); //outputs the current list because the "P" output doesn't work
        }else{
             throw new QueueUnderflowException();
        }
    }

    @Override
    public boolean isEmpty() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
        
        
       
        
        
class LinkList{
    public OrderedLinkedList firstLink;
     public Object PriorityItem = null;
    LinkList(){
        firstLink = null;
        
    }
    
    public boolean isEmpty(){
        return(firstLink == null);
    }
    
    public void insertFirstLink(T item, int priority){
         OrderedLinkedList pointerLink = firstLink; //creates a new link that is used to scroll through the list
         OrderedLinkedList newLink = new OrderedLinkedList(item, priority); //creates a new link that is set to be the newLink
        OrderedLinkedList prevLink = firstLink; //creates a new link that is set to be a link behind the current  link

        
        while(pointerLink != null){//while loop that looks for the highest priority link and removes it
            
                
                if(pointerLink.priority < newLink.priority){ //when the priority is the highest priority in the list
                    
      
                 
                 if(pointerLink == firstLink){
                   //  System.out.println("FIRST LINK ADDED");
                     
                     newLink.next = firstLink;
                     firstLink = newLink;
                 }else{
                     prevLink.next = newLink;
                    newLink.next = pointerLink;
                // System.out.println("link added break");
                 }
                    
                    break; // finish the loop
                    
                }else if (pointerLink.next == null){
                    pointerLink.next = newLink;
                //     System.out.println("link added");
             
                    break;
                    
                    
                }else{prevLink = pointerLink;
                    pointerLink = pointerLink.next;
                }
                
               
                
        }
                if(firstLink==null){
                    System.out.println("firstlink added");
                
                    firstLink = newLink;
                }

        
    } 
        
   
    public void removeFirst(){
        OrderedLinkedList linkReference = firstLink;
                if(!isEmpty()){
                    System.out.println("link removed");
        firstLink = firstLink.next;
    }else{
                    System.out.println("Empty List");
                }
                
               
    }
    
     
    
    public void display(){
        OrderedLinkedList theLink = firstLink;
        while(theLink != null){
            System.out.println("this Link: " + theLink +" "+theLink.priority);
            System.out.println("next Link: " + theLink.next);
            theLink = theLink.next;
            System.out.println("");
        }
    }
    
    
    
    public T find(T item, int priority){
        
        PriorityItem = new Object();
        //Object PriorityItem = newPriorityItem<>(item, priority);
        
        
        
       
       item = (T) firstLink.item;
        priority = firstLink.priority;
        
       PriorityItem =  new PriorityItem<>(item, priority); //the PriorityItem is created from the highLink 
        
        return ((PriorityItem<T>) PriorityItem).getItem(); //returns the item from priorityItem
    }
    
    
    public int highest(){
        int highest = 0;
                OrderedLinkedList theLink = firstLink;
        
        while(theLink != null){
           
            if(theLink.priority > highest){
                highest = theLink.priority;
            }
            theLink = theLink.next;
            
        }
        return highest;
        
    }
  }
}