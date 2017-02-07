package com.yangfan.test.permanent;
/************************************************
    * Description: 
    * @author    杨帆  
    * Copyright: Copyright (c) 2016
    * Company:   联动优势
    * @version  1.0
    * @date ：2016年12月19日 上午9:37:41 
**************************************************/
public class LinkedList1 {
	   
	   private class Data{
		   
		   private Object obj = null;
		   private Data next = null;
		   
		   Data (Object obj){
			   this.obj=obj;
		   }
	   }
	   
	   private Data first = null;
	
	   public void insertFirst(Object obj){
		   Data data = new Data(obj);
		   data.next = first;
		   first = data;
	   }
	   
	   public Object removeFirst(){
		   if(first==null){
			   throw new RuntimeException("empty");
		   }
		   Data temp = first;
		   first= first.next;
		   return temp.obj;    //返回temp毫无意义  返回temp.obj才有意义
	   }
	   
	   public Object findObj(Object obj){
		   if(first==null){
			   throw new RuntimeException("empty");
		   }
		   Data cur = first;
			   while(cur!=null){
				if(obj.equals(cur.obj)) {
					return cur.obj;
				}
				cur = cur.next;
			   }
		   return null;
	   }
	   
	   public void removeObj(Object obj){
		   if(first==null){
			   throw new RuntimeException("empty");
		   }
		   
		   if(obj.equals(first.obj)){
			   first = first.next;
		   }else{
               Data pre = first;
               Data cur = first.next;
               while(cur!=null){
            	   if(obj.equals(cur.obj)){
            		   pre.next = cur.next;
            	   }
            	   pre = cur;
            	   cur = cur.next;
               }
		   }
	   }
	   
	   public boolean isEmpty(){
		   return first==null;
	   }
	   
	   public void display(){
		   if(first==null){
			   System.out.println("empty");
		   }
		   Data cur = first;
		   while(cur!=null){
			   
			   System.out.print(cur.obj+"-->");
			   
			   cur=cur.next;
		   }
		   System.out.println();
	   }
	   
	   
	   
	   public static void main(String []args)throws Exception{
			LinkedList1 ll = new LinkedList1();  
			ll.insertFirst(4);  
			ll.insertFirst(3);  
			ll.insertFirst(2);  
			ll.insertFirst(1);  
			ll.display();  
			ll.removeFirst();  
			ll.display();  
			ll.removeObj(3);  
			ll.display();  
			System.out.println(ll.findObj(1));  
			System.out.println(ll.findObj(4));  
		}
	   
	
	
        
}
