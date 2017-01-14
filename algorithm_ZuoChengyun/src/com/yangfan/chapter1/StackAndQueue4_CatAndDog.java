package com.yangfan.chapter1;

import java.util.LinkedList;
import java.util.Queue;

import com.tool.chapter1.Cat;
import com.tool.chapter1.Dog;
import com.tool.chapter1.Pet;

/************************************************
    * Description: 
    * 
    * 【题目4】猫狗队列    pojo类详见tool.chapter1中的 Pet Dog Cat类
    * 
    * Details:   具有如下功能  
    *            add  poll pollDog pollCat isEmpty  isDogEmpty isCatEmpty
    * core:      队列  Queue --> LinkedList 
    *            实现功能肯定不能改动pojo类，这点是铁则
    * 
    * method1:
    * 
    * @author    杨帆  
    * @version  1.0
    * @date ：2017年1月12日 下午1:22:05 
**************************************************/

/**
 * 辅助类
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
    private Queue<PetEnter> DogQ ;   //初始化这种事情交给构造函数   构造之前的也就给个声明就行了
    private Queue<PetEnter> CatQ ;
    
    public StackAndQueue4_CatAndDog (){
    	this.DogQ = new LinkedList<PetEnter>();
    	this.CatQ = new LinkedList<PetEnter>();
    	this.count = 0;
    }
	
	/**
	 * 添加宠物
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
	 * 单次  按顺序  无差别弹出宠物
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
	 * 单次  按顺序  弹出猫
	 * @return
	 */
	public Cat pollCat(){
		if(!this.CatQ.isEmpty()){
			return (Cat)this.CatQ.poll().getPet();
		}else
			throw new RuntimeException("err,CatQ is empty!");
	}
	
	/**
	 * 单次  按顺序  弹出狗
	 * @return
	 */
	public Dog pollDog(){
		if(!this.DogQ.isEmpty()){
			return (Dog)this.DogQ.poll().getPet();
		}else
			throw new RuntimeException("err,DogQ is empty!");
	}
	
	/**
	 * 猫狗队列是否为空
	 * @return
	 */
	public boolean isEmpty(){
		return this.DogQ.isEmpty()&&this.CatQ.isEmpty();
	}
	/**
	 * 是否猫为空
	 * @return
	 */
	public boolean isCatEmpty(){
		return this.CatQ.isEmpty();
	}
	/**
	 * 是否狗为空
	 * @return
	 */
	public boolean isDogEmpty(){
		return this.DogQ.isEmpty();
	}
	

}


