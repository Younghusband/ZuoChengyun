package com.yangfan.chapter1;

import java.util.Stack;

/************************************************
    * Description: 
    * 【题目3】编写一个类，仅用递归函数和栈操作逆序一个栈
    * 
    * Details:
    * 
    * core:  
    * 
    * method1:
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
		//利用递归  从栈顶开始输出stack的值
		System.out.println("此时栈顶是  "+stack.peek());  //此时是6
		int x = StackAndQueue3_ReverseByRecurse.getLastElement(stack);
		//after getLast 
		System.out.println("栈底元素 "+x);  //此时是1
		System.out.println("此时栈顶依旧是   6");
		
		
		System.out.println(stack);
		
		//如果逆转正常  应该是几
//		int top = stack.peek();
//		System.out.println("经过逆转后的栈顶元素   "+top);
	}
     
     /**
      * 得到栈底  在不破坏栈内其他元素结构的情况下
     * @param stack
     * @return
     */
     public static int getLastElement(Stack<Integer> stack){
    	 int result = stack.pop();
    	 if(stack.isEmpty()){
    		 return result;
    	 }else{
             int last = getLastElement(stack);
             stack.push(result);
             return last;
    	 }
     }
     
    /**
     * 
     * @param stack
     */
    public static void reverse(Stack<Integer> stack){
    	if(stack.isEmpty()){
    		return;
    	}
    	int i = getLastElement(stack);
        reverse(stack);
        stack.push(i);    	
    }
    
     
}
