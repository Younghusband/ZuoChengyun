package com.yangfan.chapter1;

import java.util.Iterator;
import java.util.Stack;


/************************************************
    * Description: 
    * 
    * ����Ŀ2����дһ���࣬������ջʵ�ֶ��У�֧�ֶ��еĻ�������(add,poll,peek)
    * 
    * Details:ջ���ص����Ƚ�����������е��ص����Ƚ��ȳ�������������ջ�����ܰ�˳�򷴹���ʵ�����ƶ��еĲ�����
    * 
    * core:  1.��������ջʵ�ַ�ת
    *        2.ÿ��ִ��peek����poll������ʱ�򶼽�pushStack��ȫ�����ݵ���popStack
    *        3.���popStack��Ϊ�գ���ô���Բ���pushStack�����ݵ���popStack
    * 
    * method1:
    * 
    * @author    �  
    * @version  1.0
    * @date ��2016��12��15�� ����1:33:03 
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
			System.out.println(q);  //��ӡ����  ��ʱΪ��
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
          pushStack.push(item);   //��Ĳ����ܵ��� ֻ����pushStack�����Ԫ��		
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
