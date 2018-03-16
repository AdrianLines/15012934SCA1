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
        public Object item;
        public Object theitem;
        public OrderedLinkedList next;
        
        public OrderedLinkedList(Object item, int priority){
            this.priority = priority;
            this.item = item;
        }

    OrderedLinkedList() {
      
         
         
    }
    
        public void display(){
            System.out.println(item + ": " + priority);
        }
        
        public String toString(){
          return (String) item;  
        }

    @Override
    public void add(Object item, int priority) throws QueueOverflowException {
        
   
        
        theLinkedList.insertFirstLink(item,priority);
        theLinkedList.display();
        
    }

    @Override
    public T head() throws QueueUnderflowException {
        theLinkedList.display();
        return (T) theLinkedList.firstLink;
    }

    @Override
    public void remove() throws QueueUnderflowException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isEmpty() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
        
        
       
        
        
class LinkList{
    public OrderedLinkedList firstLink;
    
    LinkList(){
        firstLink = null;
        
    }
    
    public boolean isEmpty(){
        return(firstLink == null);
    }
    
    public void insertFirstLink(Object item, int priority){
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
            theLink.display();
            System.out.println("next Link: " + theLink.next);
            theLink = theLink.next;
            System.out.println("");
        }
    }
    public OrderedLinkedList find(String item){
        OrderedLinkedList theLink = firstLink;
        if(!isEmpty()){
            while(theLink.item !=item){
                if(theLink.next == null){
                    return null;
                   
                } else {
                    theLink = theLink.next;
                }
            }
        }else {
            System.out.println("Empty List");
        }
        return theLink;
    }
    public OrderedLinkedList removeLink(String item){
        OrderedLinkedList currentLink = firstLink;
        OrderedLinkedList previousLink = firstLink;
        
        
        while(currentLink.item != item){
            if(currentLink.next == null){
                return null;
            }else{
                previousLink = currentLink;
                currentLink = currentLink.next;
            }
        }
        if(currentLink == firstLink){
            firstLink = firstLink.next;
            
        }else{
            previousLink.next = currentLink.next;
        }
        return currentLink;
    }
}
        

}