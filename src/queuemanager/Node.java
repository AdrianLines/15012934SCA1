/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queuemanager;

/**
 *
 * @author Adrian2018
 */
class Node //basic Node class used in the Heap class
   {
   public Object itemS;             //item variable
   public int priority;           // the priority value

   public Node(Object item, int key){            // constructor
      
       itemS = item; //sets item
       priority = key;//sets priority
   
   }

   public int getKey(){// returns the priority
       return priority; 
   }

   public void setKey(int id){ //sets the priority
   priority = id; 
   }

   public Object getItem(){ //returns item
       return itemS;
   }

   public void setItem(Object nodeItem){ //sets item
       itemS = nodeItem; 
   }

   } 
