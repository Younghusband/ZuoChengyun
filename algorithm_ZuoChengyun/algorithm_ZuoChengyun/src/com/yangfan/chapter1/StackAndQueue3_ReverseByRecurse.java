package com.yangfan.chapter1;

import java.util.Stack;

/************************************************
    * Description: 
    *    ֻ���õݹ麯����ʵ��stack������
    * 
    * @author    �  
    * @version  1.0
    * @date ��2017��1��5�� ����1:31:15 
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
		System.out.println(stack.peek());  //��ʱ��6
		//��ת��
		System.out.println(stack.peek());  //��ʱ��1
		
	}
     
     
     
     
     
     
}
