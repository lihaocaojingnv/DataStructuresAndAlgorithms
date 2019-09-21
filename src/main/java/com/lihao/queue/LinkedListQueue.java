/**
 * 
 */
package com.lihao.queue;

/**
 * 基于链表实现的队列
 * @author lihao
 * @param <T>
 *
 */
public class LinkedListQueue<T> {
	
	//链表容量
	private int capacity;
	
	//头结点
	private Node<T> head;
	
	//尾节点
	private Node<T> tail;
	
	//链表长度
	private int length;
	
	public LinkedListQueue(int capacity) {
		this.capacity = capacity;
		length = 0;
	}

	//入队列
	public boolean enqueue(T data) {
		//链表已满
		if(length == capacity) {
			return false;
		}
		//队列为空
		if(length == 0) {
			head = new Node(data, null);
			tail = head;
		}else {
			tail.setNext(new Node(data, null));
			tail = tail.getNext();
		}
		length++;
		return true;
	}
	
	/**
	 * 出队列
	 * @return
	 */
	public T dequeue() {
		if(length == 0) {
			return null;
		}
		T ret = head.getElement();
		head = head.getNext();
		length--;
		return ret;
	}

	@Override
	public String toString() {
		StringBuilder buffer = new StringBuilder();
		buffer.append("Queue length is : " + length).append("\nitems is [ ");
		Node node = head;
		while(node != null) {
			buffer.append(node.getElement()).append(" ");
			node = node.getNext();
		}
		buffer.append("]");
		return buffer.toString();
	}

	public static void main(String[] args) {
		LinkedListQueue<String> queue = new LinkedListQueue<String>(10);
		for(int i = 0; i < 10; i++) {
			queue.enqueue(i + "");
		}
		System.out.println(queue.toString());
		for(int i = 0; i < 5; i++) {
			System.out.println(queue.dequeue());
		}
		System.out.println(queue.toString());
	}

	public class Node<T>{
		
		private T element;
		
		private Node next;

		public T getElement() {
			return element;
		}

		public void setElement(T element) {
			this.element = element;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}

		public Node(T element, Node next) {
			this.element = element;
			this.next = next;
		}

		public Node() {
			this.next = null;
		}
		
		
	}
		
}
