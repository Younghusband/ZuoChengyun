package com.yangfan.chapter1;

import java.util.Stack;

/************************************************
    * Description: 
    *  ����Ŀ5����һ��ջʵ����һ��ջ������     
    *   Details:  һ��Ԫ������ΪInteger��ջ�������Ҫ���䰴�մӴ�С��˳����ջ����ջ�����С�
    *             ֻ������һ��ջ�����������µı������������������ݽṹ������������
    *             (��Ŀ������˵�ġ����� ������Щ���������˰�  ��˼���Ǵ������һ��ջ������֮���㻹��������һ��ջ����)
    *   core:     �������½����ݽṹ�����½����������洢
    * 
    *   method1:    
    * @author    �  
    * @version  1.0
    * @date ��2017��1��13�� ����2:59:09 
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
      * ˼·   Ҫ��stack Ϊ���ϵ����ɴ�С   ��ôhelp�Ͱ��մ��ϵ�����С���� 
      *     Ȼ���ٽ�help��ѹ��put��stack��
      * 
     * @param stack
     */
    public void sortTrue(Stack<Integer> stack){
    	   Stack<Integer> help = new Stack<Integer>();   
    	   while(!stack.isEmpty()){
                int cur = stack.pop();
                while(!help.isEmpty()&&cur>help.peek()){   //�����֮  ��֤helpջ��Ϊ���ֵ
                	stack.push(help.pop());
                }
                help.push(cur);
    	   }
    	   while(!help.isEmpty()){
    		   stack.push(help.pop());
    	   }
       }
       
       
       //stack  help   ���stackΪ��  helpΪ�ź����ջ     ��Ȼ�������  ����������Ҫ��
       public Stack<Integer> sortFalse(Stack<Integer> stack){
    	    Stack<Integer> help = new Stack<Integer>();
    	    if(!stack.isEmpty()){
    	    	help.push(stack.pop());   //help stackע���ʼֵ
    	    }
    	    while(!stack.isEmpty()){   //stack��Ϊ�յ�ʱ��ͣ�Ľ������в���
    	    	if(stack.peek()>help.peek()){
    	    		help.push(stack.pop());
    	    	}else {
    	    		int temp = stack.pop();  //�����Сֵ��stackȡ��
    	    		while(!help.isEmpty()){
    	    			stack.push(help.pop());
    	    		}
    	    		help.push(temp);   //��ʱhelp���ֽ�ʣһ��Ԫ����
    	    	}
    	    }
    	    return help;
       }
}
