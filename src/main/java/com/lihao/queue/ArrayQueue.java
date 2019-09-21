/**
 * 
 */
package com.lihao.queue;

/**
 * @author lihao
 *
 */
public class ArrayQueue {
	
	//数组
	private String[] items;
	
	//数组容量
	private int n = 0;
	
	//队列头
	private int head = 0;
	
	//队列尾
	private int tail = 0;
	
	public ArrayQueue(int capacity) {
		items = new String[capacity];
		n = capacity;
	}
	
	/**
	 * 入队列
	 * @param item
	 * @return
	 */
	public boolean enqueue(String item) {
		//tail == n表示队列末尾已经没有空间了
		if(tail == n) {
			//tail == n 并且 head == 0 表示整个队列都占满了
			if(head == 0) {
				return false;
			}
			//数据搬移
			for(int i = head; i < tail; ++i) {
				items[i - head] = items[i]; 
			}
			//数据搬移完之后更新head和tail
			tail = tail - head;
			head = 0;
		}
		items[tail] = item;
		++tail;
		return true;
	}
	
	public String dequeue() {
		if(head == tail) {
			return null;
		}
		String ret = items[head];
		++head;
		return ret;
	}

	@Override
	public String toString() {
		StringBuilder buffer = new StringBuilder();
		buffer.append("ArrayQueue capacity is : ").append(n)
			.append(", head is : ").append(head)
			.append(", tail is : ").append(tail);
		buffer.append("\n items is : [");
		for(int i = head; i < tail; i++) {
			buffer.append(" " + items[i] + " ");
		}
		buffer.append("]");
		return buffer.toString();
	}
	
	public static void main(String[] args) {
		ArrayQueue arrayQueue = new ArrayQueue(20);
		for(int i = 0; i < 15; i++) {
			arrayQueue.enqueue(i + "");
		}
		System.out.println(arrayQueue.toString());
		
		for(int i = 0; i < 10; i++) {
			System.out.println("dequeue " + i + " item is : " + arrayQueue.dequeue());
		}
		System.out.println(arrayQueue.toString());
	}
		
}
