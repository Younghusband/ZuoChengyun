package com.yangfan.chapter1;

import java.util.LinkedList;
import java.util.Queue;

import com.tool.chapter1.Cat;
import com.tool.chapter1.Dog;
import com.tool.chapter1.Pet;

/************************************************
    * Description: 
    * 
    * ����Ŀ4��è������    pojo�����tool.chapter1�е� Pet Dog Cat��
    * 
    * Details:   �������¹���  
    *            add  poll pollDog pollCat isEmpty  isDogEmpty isCatEmpty
    * core:      ����  Queue --> LinkedList 
    *            ʵ�ֹ��ܿ϶����ܸĶ�pojo�࣬���������
    * 
    * method1:
    * 
    * @author    �  
    * @version  1.0
    * @date ��2017��1��12�� ����1:22:05 
**************************************************/

/**
 * ������
 *
 */
class PetEnter {
	private Pet pet;
	private long count;

	public PetEnter(Pet pet, long count) {
		this.pet = pet;
		this.count = count;
	}

	public Pet getPet() {
		return this.pet;
	}

	public long getCount() {
		return this.count;
	}

	public String getEnterPetType() {
		return this.pet.getPetType();
	}

}

public class StackAndQueue4_CatAndDog {
    
    long count;
    private Queue<PetEnter> DogQ ;   //��ʼ���������齻�����캯��   ����֮ǰ��Ҳ�͸�������������
    private Queue<PetEnter> CatQ ;
    
    public StackAndQueue4_CatAndDog (){
    	this.DogQ = new LinkedList<PetEnter>();
    	this.CatQ = new LinkedList<PetEnter>();
    	this.count = 0;
    }
	
	/**
	 * ��ӳ���
	 * @param pet
	 * @core
	 */
	public void add(Pet pet){
		if(pet.getPetType().equals("dog")){
           this.DogQ.add(new PetEnter(pet,this.count++));			
		}else if (pet.getPetType().equals("cat")){
		   this.CatQ.add(new PetEnter(pet,this.count++));
		}else
			throw new RuntimeException("not dog or cat!");
		
	}
	
	/**
	 * ����  ��˳��  �޲�𵯳�����
	 * @return
	 */
	public Pet poll(){
		
		if(!this.DogQ.isEmpty()&&!this.CatQ.isEmpty()){
		    if(this.DogQ.peek().getCount()>this.CatQ.peek().getCount()){
		    	return this.CatQ.poll().getPet();
		    }else
		    	return this.DogQ.poll().getPet();
			
		}else if(this.DogQ.isEmpty()){
			return this.CatQ.poll().getPet();
		}else if(this.CatQ.isEmpty()){
			return this.DogQ.poll().getPet();
		}else {
			throw new RuntimeException("err,queue is empty");
		}
	}
	
	
	/**
	 * ����  ��˳��  ����è
	 * @return
	 */
	public Cat pollCat(){
		if(!this.CatQ.isEmpty()){
			return (Cat)this.CatQ.poll().getPet();
		}else
			throw new RuntimeException("err,CatQ is empty!");
	}
	
	/**
	 * ����  ��˳��  ������
	 * @return
	 */
	public Dog pollDog(){
		if(!this.DogQ.isEmpty()){
			return (Dog)this.DogQ.poll().getPet();
		}else
			throw new RuntimeException("err,DogQ is empty!");
	}
	
	/**
	 * è�������Ƿ�Ϊ��
	 * @return
	 */
	public boolean isEmpty(){
		return this.DogQ.isEmpty()&&this.CatQ.isEmpty();
	}
	/**
	 * �Ƿ�èΪ��
	 * @return
	 */
	public boolean isCatEmpty(){
		return this.CatQ.isEmpty();
	}
	/**
	 * �Ƿ�Ϊ��
	 * @return
	 */
	public boolean isDogEmpty(){
		return this.DogQ.isEmpty();
	}
	

}


