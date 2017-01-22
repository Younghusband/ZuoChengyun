package com.yangfan.test.permanent;

/************************************************
 * Description: 用java实现链表结构，为刷左程云那本书第二章热身
 * 
 * 
 * @author 杨帆 Copyright: Copyright (c) 2016
 * @version 1.0
 * @date ：2016年12月15日 下午4:43:38
 **************************************************/
public class LinkedList {
	
	public static void main(String []args)throws Exception{
		LinkedList ll = new LinkedList();  
		ll.insertFirst(4);  
		ll.insertFirst(3);  
		ll.insertFirst(2);  
		ll.insertFirst(1);  
		ll.display();  
		ll.deleteFirst();  
		ll.display();  
		ll.remove(3);  
		ll.display();  
		System.out.println(ll.find(1));  
		System.out.println(ll.find(4));  
	}

	private class Data {

		private Object obj;
		private Data next = null;

		Data(Object obj) {
			this.obj = obj;
		}

	}

	private Data first = null;

	public void insertFirst(Object obj) {
		Data data = new Data(obj);
		data.next = first; // 新的节点的next指向之前的第一个节点
		first = data; // first指向现在的节点
	}

	public Object deleteFirst() throws Exception {
		if (first == null) {
			throw new Exception("empty");
		}
		Data temp = first;
		first = first.next;
		return temp.obj;
	}

	public Object find(Object obj) throws Exception {
		if (first == null) {
			throw new Exception("empty");
		}

		Data cur = first;
		while (cur != null) {
			if (obj.equals(cur.obj)) {
				return cur.obj; // 传入obj 返回obj 意义何在？ 比如找一个数字1 找到了 给你返回一个1 意义何在？
			}
			cur = cur.next;
		}
		return null;
	}

	public void remove(Object obj) throws Exception {
		if (first == null) {
			throw new Exception("empty");
		}
		if (obj.equals(first.obj)) {
			first = first.next;
		} else {

			Data pre = first;
			Data cur = first.next;
			while (cur.next != null) {

				if (obj.equals(cur.obj)) {
					pre.next = cur.next;
				}
				pre = cur;
				cur = cur.next;
			}
		}
	}
	
	public boolean isEmpty(){
		return (first==null);
	}
	
	public void display(){
		if(first==null){
			System.out.println("empty");
		}
		Data cur = first;
		while(cur!=null){
            System.out.print(cur.obj);  			
 			if(cur.next!=null){
 				System.out.print("-->");
 			}
			cur=cur.next;
		}
		System.out.println();
	}

}
