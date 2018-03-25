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
class Node
   {
   public Object itemS;
   public int priority;           // data item (key)
// -------------------------------------------------------------
   public Node(Object item, int key)           // constructor
      { 
       itemS = item;
       priority = key;
   
   }
// -------------------------------------------------------------
   public int getKey()
      { return priority; }
// -------------------------------------------------------------
   public void setKey(int id)
      { priority = id; }
   // -------------------------------------------------------------
   public Object getItem()
      { return itemS; }
// -------------------------------------------------------------
   public void setItem(Object nodeItem)
      { itemS = nodeItem; }
// -------------------------------------------------------------
   }  // end class Node
