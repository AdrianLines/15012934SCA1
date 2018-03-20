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
    
        public void display(){
            System.out.println(item + ": " + priority);
            
        }
        
        public String toString(){
            String itemString = String.valueOf(item);
          return itemString;  
        }

    @Override
    public void add(T item, int priority) throws QueueOverflowException {
        
   
        
        theLinkedList.insertFirstLink(item,priority);
       
        
    }

    @Override
    public T head() throws QueueUnderflowException {
     
        return  theLinkedList.find(item,priority);

    }

    @Override
    public void remove() throws QueueUnderflowException {
        theLinkedList.removeLink();
        theLinkedList.display();
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
        OrderedLinkedList newLink = new OrderedLinkedList(item, priority);
       
       newLink.next = firstLink;
        firstLink = newLink;
       
     
              
        
  
        
    } 
        
   
    public OrderedLinkedList removeFirst(){
        OrderedLinkedList linkReference = firstLink;
        
        
    
        
        
        
                if(!isEmpty()){
        firstLink = firstLink.next;
    }else{
                    System.out.println("Empty List");
                }
                
                return linkReference;
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
        OrderedLinkedList theLink = firstLink;
        OrderedLinkedList highLink = firstLink;
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
                OrderedLinkedList theLink = firstLink;
        
        while(theLink != null){
           
            if(theLink.priority > highest){
                highest = theLink.priority;
            }
            theLink = theLink.next;
            
        }
        return highest;
        
    }
    public void removeLink(){
        OrderedLinkedList currentLink = firstLink;
        OrderedLinkedList previousLink = firstLink;
        int finished = 0;
        highest();
        
        while(currentLink != null){
            
                
                if(currentLink.priority == highest()){
                    previousLink.next= currentLink.next;
                    finished = 1;
                 
                    display();
                    
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