/**
 * 
 */
package com.lihao.queue;

/**
 * ѭ������
 * @author lihao
 *
 */
public class CircularQueue {
	
	//����
	private String[] items;
	
	//��������
	private int n = 0;
	
	//����ͷ
	private int head = 0;
	
	//����β
	private int tail = 0;
	
	public CircularQueue(int capacity) {
		items = new String[capacity];
		n = capacity;
	}
	
	//���
	public boolean enqueue(String item)
	{
		//��������
		if((tail + 1)%n == head) {
			return false;
		}
		items[tail] = item;
		tail = (tail + 1)%n;
		return true;
	}
	
	public String dequeue() {
		//����Ϊ��
		if(head == tail) {
			return null;
		}
		String ret = items[head];
		head = (head + 1)%n;
		return ret;
	}
	
	@Override
	public String toString() {
		StringBuilder buffer = new StringBuilder();
		buffer.append("CircularQueue capacity is : ").append(n)
			.append(", head is : ").append(head)
			.append(", tail is : ").append(tail);
		buffer.append("\n items is : [");
		int i = head;
		while(i%n != tail) {
			buffer.append(" " + items[(i)%n] + " ");
			i++;
		}
		buffer.append("]");
		return buffer.toString();
	}
	
	public static void main(String[] args) {
		CircularQueue circularQueue = new CircularQueue(10);
		for(int i = 0; i < 15; i++) {
			circularQueue.enqueue(i + "");
		}
		System.out.println(circularQueue.toString());
		
		for(int i = 0; i < 5; i++) {
			System.out.println("dequeue " + i + " item is : " + circularQueue.dequeue());
		}
		System.out.println(circularQueue.toString());
	}
	
	
}
