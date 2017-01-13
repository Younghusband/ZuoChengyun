package com.yangfan.chapter1;

import java.util.Stack;

/************************************************
 * Description:
 * 
 * ����Ŀ1�� ���һ����getMin���ܵ�ջ
 * 
 * Details: ��ʵ��ջ�Ļ������ܵĻ����ϣ���ʵ�ַ���ջ����СԪ�صĲ���
 * 
 * Method1: pushʡ�ռ䵫��ʱ��,pop��ʱ��
 * 
 * Method2: pushʡʱ�䵫�ѿռ䣬pop��
 * 
 * @author � 
 * @version 1.0
 * @date ��2016��12��15�� ����11:44:28
 **************************************************/
public class StackAndQueue1_getMinStack {  //method 1
   
	/**
	 * ����˼���� ����һ���"this."�ܲ���ȥ��
	 * 
	 * */
	
	private Stack<Integer> dataStack;
	private Stack<Integer> minStack;

	public StackAndQueue1_getMinStack() {
		this.dataStack = new Stack<Integer>();
		this.minStack = new Stack<Integer>();
	}

	public void push(int newnum) {
		this.dataStack.push(newnum);
		if (this.minStack.isEmpty()) {
			this.minStack.push(newnum);
		} else if (newnum < this.getMin()) {
			this.minStack.push(newnum);
		}
	}

	public int pop() {
		if (this.dataStack.isEmpty()) {
			throw new RuntimeException("your stack is empty");
		}
		int value = this.dataStack.pop();
		if (value == this.getMin()) {
			this.minStack.pop();
		}
		return value;
	}

	public int getMin() {
		if (this.minStack.isEmpty()) {
			throw new RuntimeException("your stack is empty"); // ����Ϊʲô��runtimeException
																// ������exception
		} 
			return this.minStack.peek();
	}

}

class getMinStack1 {  //method 2
	private Stack<Integer> dataStack;
	private Stack<Integer> minStack;

	public getMinStack1() {
		this.dataStack = new Stack<Integer>();
		this.minStack = new Stack<Integer>();
	}

	public void push(int newnum) {
		this.dataStack.push(newnum);
		if (this.minStack.isEmpty()) {
			this.minStack.push(newnum);
		} else if (newnum < this.minStack.peek()) {
			this.minStack.push(newnum);
		} else  {
			this.minStack.push(this.getMin());
		}

	}

	public int pop() {
		if (this.dataStack.isEmpty()) {
			throw new RuntimeException("your stack is empty");
		}
		this.minStack.pop();
		return this.dataStack.pop();
	}

	public int getMin() {
		if (this.minStack.isEmpty()) {
			throw new RuntimeException("your stack is Empty");
		}
		return this.minStack.peek();
	}
}
