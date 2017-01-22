package com.yangfan.chapter1;

import java.util.Stack;

/************************************************
 * Description:
 * 
 * 【题目1】 设计一个有getMin功能的栈
 * 
 * Details: 在实现栈的基本功能的基础上，再实现返回栈中最小元素的操作
 * 
 * Method1: push省空间但费时间,pop费时间
 * 
 * Method2: push省时间但费空间，pop简单
 * 
 * @author 杨帆 
 * @version 1.0
 * @date ：2016年12月15日 上午11:44:28
 **************************************************/
public class StackAndQueue1_getMinStack {  //method 1
   
	/**
	 * 我在思考啊 他这一大堆"this."能不能去掉
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
			throw new RuntimeException("your stack is empty"); // 这里为什么用runtimeException
																// 而不是exception
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
