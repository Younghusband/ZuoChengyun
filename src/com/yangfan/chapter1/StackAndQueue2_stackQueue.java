package com.yangfan.chapter1;

import java.util.Iterator;
import java.util.Stack;


/************************************************
    * Description: 
    * 
    * 【题目2】编写一个类，用两个栈实现队列，支持队列的基本操作(add,poll,peek)
    * 
    * Details:栈的特点是先进后出，而队列的特点是先进先出。我们用两个栈正好能把顺序反过来实现类似队列的操作。
    * 
    * core:  1.利用两个栈实现反转
    *        2.每次执行peek或者poll操作的时候都将pushStack的全部内容倒入popStack
    *        3.如果popStack不为空，那么绝对不将pushStack的内容倒入popStack
    * 
    * method1:
    * 
    * @author    杨帆  
    * @version  1.0
    * @date ：2016年12月15日 下午1:33:03 
**************************************************/
public class StackAndQueue2_stackQueue {
	
	 public static void main(String[] args) {
		 StackAndQueue2_stackQueue q = new StackAndQueue2_stackQueue();
			q.add(1);
			q.add(2);
			q.add(3);
			q.add(4);
			q.add(5);
			q.add(6);
			q.add(7);
			System.out.println(q);  //打印队列  此时为空
			q.poll();               
			System.out.println(q);  // 234567
			q.poll();               
			System.out.println(q);  //  34567
			System.out.println(q.peek());    //3
		
		}
    
	private Stack<Integer> pushStack;
	private Stack<Integer> popStack;
	
	public StackAndQueue2_stackQueue(){
		pushStack= new Stack<Integer>();
		popStack= new Stack<Integer>();
	}
	
	public void add(int item){
          pushStack.push(item);   //存的操作很单纯 只是往pushStack里面放元素		
	}
	
	public int peek(){
		if(popStack.isEmpty()&&pushStack.isEmpty()){
			throw new RuntimeException("your queue is empty");
		}else if (popStack.isEmpty()){
			while(!pushStack.isEmpty()){
               popStack.push(pushStack.pop());				
			}
		}
		return popStack.peek();
	}
	
	public int poll(){
		if(popStack.isEmpty()&&pushStack.isEmpty()){
			throw new RuntimeException("your queue is empty");
		}else if (popStack.isEmpty()){
			while(!pushStack.isEmpty()){
               popStack.push(pushStack.pop());				
			}
		}
		return popStack.pop();
	}
	
	public String toString(){
    	StringBuffer sb = new StringBuffer();
    	Iterator<Integer> i = popStack.iterator();
    	while(i.hasNext()){
    		sb.append(i.next()+", ");
    	}
    	return sb.toString();
    }
	
}
