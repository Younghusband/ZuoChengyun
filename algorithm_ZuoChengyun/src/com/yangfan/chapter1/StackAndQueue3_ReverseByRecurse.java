package com.yangfan.chapter1;

import java.util.Stack;

/************************************************
    * Description: 
    *    只利用递归函数来实现stack的逆序
    * 
    * @author    杨帆  
    * @version  1.0
    * @date ：2017年1月5日 下午1:31:15 
**************************************************/
public class StackAndQueue3_ReverseByRecurse {
	
	//test method 
     public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.add(1);
		stack.add(2);
		stack.add(3);
		stack.add(4);
		stack.add(5);
		stack.add(6);
		System.out.println(stack.peek());  //此时是6
		//逆转后
		System.out.println(stack.peek());  //此时是1
		
	}
     
     
     
     
     
     
}
