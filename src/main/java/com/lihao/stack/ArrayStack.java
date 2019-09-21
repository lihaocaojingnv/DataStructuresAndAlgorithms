/**
 * 
 */
package com.lihao.stack;

/**
 * 基于数组实现的顺序栈
 * @author lihao
 *
 */
public class ArrayStack {

	//数组
	private String[] items;
	
	//栈中元素个数
	private int count;
	
	//栈的大小
	private int n;
	
	//初始化数组，申请一个大小为n的数组空间
	public ArrayStack(int n) {
		this.items = new String[n];
		this.n = n;
		this.count = 0;
	}
	
	/**
	 * 入栈操作
	 * @param item
	 * @return
	 */
	public boolean push(String item) {
		//数组空间不够用了，直接返回false，入栈失败
		if(count == n) {
			return false;
		}
		items[count] = item;
		++count;
		return true;
	}
	
	/**
	 * 出栈操作
	 * @return
	 */
	public String pop() {
		//栈为空，直接返回null
		if(count == 0) {
			return null;
		}
		//返回下标为count-1的数组元素，并且栈中的元素个数count减一
		String tmp = items[count - 1];
		--count;
		return tmp;
	}

	@Override
	public String toString() {
		StringBuilder buffer = new StringBuilder();
		buffer.append("Array Stack capacity is : ").append(n).append("\nitems is : [ ");
		for(int i = 0; i < count; i++) {
			buffer.append(items[i]).append(" ");
		}
		buffer.append("]");
		return buffer.toString();
	}
	
	public static void main(String[] args) {
		ArrayStack stack = new ArrayStack(10);
		for(int i = 0; i < 10; i++) {
			stack.push(i + "");
		}
		System.out.println(stack.toString());
		for(int i = 0; i < 5; i++) {
			System.out.println(stack.pop());
		}
		System.out.println(stack.toString());
	}
	
	
	
	
	
	
	
	
	
	
}
