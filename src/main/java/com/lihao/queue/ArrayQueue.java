/**
 * 
 */
package com.lihao.queue;

/**
 * @author lihao
 *
 */
public class ArrayQueue {
	
	//����
	private String[] items;
	
	//��������
	private int n = 0;
	
	//����ͷ
	private int head = 0;
	
	//����β
	private int tail = 0;
	
	public ArrayQueue(int capacity) {
		items = new String[capacity];
		n = capacity;
	}
	
	/**
	 * �����
	 * @param item
	 * @return
	 */
	public boolean enqueue(String item) {
		//tail == n��ʾ����ĩβ�Ѿ�û�пռ���
		if(tail == n) {
			//tail == n ���� head == 0 ��ʾ�������ж�ռ����
			if(head == 0) {
				return false;
			}
			//���ݰ���
			for(int i = head; i < tail; ++i) {
				items[i - head] = items[i]; 
			}
			//���ݰ�����֮�����head��tail
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
