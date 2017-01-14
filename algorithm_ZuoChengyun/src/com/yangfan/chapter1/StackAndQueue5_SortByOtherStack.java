package com.yangfan.chapter1;

import java.util.Stack;

/************************************************
    * Description: 
    *  【题目5】用一个栈实现另一个栈的排序     
    *   Details:  一个元素类型为Integer的栈，如今需要将其按照从大到小的顺序由栈顶至栈底排列。
    *             只许申请一个栈，可以申请新的变量不能申请额外的数据结构。如何完成排序？
    *             (题目是这样说的。。。 但是这些话严重误导人啊  意思就是待排序的一个栈，除此之外你还可以申请一个栈！！)
    *   core:     不允许新建数据结构，就新建个变量来存储
    * 
    *   method1:    
    * @author    杨帆  
    * @version  1.0
    * @date ：2017年1月13日 下午2:59:09 
    * 
    * |  5  |
    * |  4  |
    * |  3  |
    * |  2  |
    * |__1__|
    * 
    * 
**************************************************/
public class StackAndQueue5_SortByOtherStack {
       
       public StackAndQueue5_SortByOtherStack(){
       }
       
       
     /**
      * 思路   要求stack 为从上到下由大到小   那么help就按照从上到下由小到大 
      *     然后再将help无压力put进stack里
      * 
     * @param stack
     */
    public void sortTrue(Stack<Integer> stack){
    	   Stack<Integer> help = new Stack<Integer>();   
    	   while(!stack.isEmpty()){
                int cur = stack.pop();
                while(!help.isEmpty()&&cur>help.peek()){   //简而言之  保证help栈底为最大值
                	stack.push(help.pop());
                }
                help.push(cur);
    	   }
    	   while(!help.isEmpty()){
    		   stack.push(help.pop());
    	   }
       }
       
       
       //stack  help   最后stack为空  help为排好序的栈     虽然排序完成  但并不符合要求
       public Stack<Integer> sortFalse(Stack<Integer> stack){
    	    Stack<Integer> help = new Stack<Integer>();
    	    if(!stack.isEmpty()){
    	    	help.push(stack.pop());   //help stack注入初始值
    	    }
    	    while(!stack.isEmpty()){   //stack不为空的时候不停的进行所有操作
    	    	if(stack.peek()>help.peek()){
    	    		help.push(stack.pop());
    	    	}else {
    	    		int temp = stack.pop();  //将这个小值从stack取出
    	    		while(!help.isEmpty()){
    	    			stack.push(help.pop());
    	    		}
    	    		help.push(temp);   //此时help里又仅剩一个元素了
    	    	}
    	    }
    	    return help;
       }
}
