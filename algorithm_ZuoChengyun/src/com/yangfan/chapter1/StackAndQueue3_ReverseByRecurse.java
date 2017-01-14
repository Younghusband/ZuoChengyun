package com.yangfan.chapter1;

import java.util.Stack;

/************************************************
    * Description: 
    * ����Ŀ3����дһ���࣬���õݹ麯����ջ��������һ��ջ
    * 
    * Details:
    * 
    * core:  
    * 
    * method1:
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
		//���õݹ�  ��ջ����ʼ���stack��ֵ
		System.out.println("��ʱջ����  "+stack.peek());  //��ʱ��6
		int x = StackAndQueue3_ReverseByRecurse.getLastElement(stack);
		//after getLast 
		System.out.println("ջ��Ԫ�� "+x);  //��ʱ��1
		System.out.println("��ʱջ��������   6");
		
		
		System.out.println(stack);
		
		//�����ת����  Ӧ���Ǽ�
//		int top = stack.peek();
//		System.out.println("������ת���ջ��Ԫ��   "+top);
	}
     
     /**
      * �õ�ջ��  �ڲ��ƻ�ջ������Ԫ�ؽṹ�������
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
