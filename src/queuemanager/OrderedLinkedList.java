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
public class OrderedLinkedList {
  
        public int priority;
        public String item;
        public OrderedLinkedList next;
        
        public OrderedLinkedList(String item, int priority){
            this.priority = priority;
            this.item = item;
        }
    
        public void display(){
            System.out.println(item + ": " + priority);
        }
        
        public String toString(){
          return item;  
        }
        
        
class LinkList{
    public OrderedLinkedList firstLink;
    
    LinkList(){
        firstLink = null;
        
    }
    public boolean isEmpty(){
        return(firstLink == null);
    }
    
    public void insertFirstLink(String item, int priority){
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
}
        

}