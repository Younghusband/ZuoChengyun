package com.yangfan.test.stack;

import java.util.Stack;

import com.yangfan.chapter1.StackAndQueue5_SortByOtherStack;

/************************************************
    * Description: 
    * @author    杨帆  
    * @version  1.0
    * @date ：2017年1月13日 下午3:21:34 
**************************************************/
public class TestOrderStack {
      public static void main(String[] args) {
    	  Stack<Integer> stack = new Stack<Integer>();
    	  StackAndQueue5_SortByOtherStack sortStack = new StackAndQueue5_SortByOtherStack();
    	  stack.push(5);
    	  stack.push(2);
    	  stack.push(3);
    	  stack.push(4);
    	  stack.push(1);
    	  
    	  sortStack.sortTrue(stack);  
    	  System.out.println(stack);
    	  
	}
}
