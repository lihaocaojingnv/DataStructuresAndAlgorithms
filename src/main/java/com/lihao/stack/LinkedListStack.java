/**
 * 
 */
package com.lihao.stack;

/**
 * 基于链表实现的栈
 * @author lihao
 * @param <T>
 *
 */
public class LinkedListStack<T> {
	//链表容量
	private int capacity;
	
	//头结点
	private Node<T> head;
	
	//尾结点
	private Node<T> tail;
	
	//链表长度
	private int length;
	
	public LinkedListStack(int capacity) {
		this.capacity = capacity;
		this.length = 0;
	}
	
	/**
	 * 入栈
	 * @param data
	 * @return
	 */
	public boolean push(T data) {
		//栈已满
		if(length == capacity) {
			return false;
		}
		//栈为空
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
	 * 出栈
	 * @return
	 */
	public T pop() {
		if(length == 0) {
			return null;
		}
		T ret = tail.getElement();
		Node preNodeBeforeTail = findPreNode(tail);
		tail = preNodeBeforeTail;
		tail.setNext(null);
		length--;
		return ret;
	}
	
	/**
	 * 找到前一个结点
	 * @param tail2
	 * @return
	 */
	private Node findPreNode(Node end) {
		Node temp = head;
		while(temp != null) {
			if(temp.getNext() == tail) {
				return temp;
			}
			temp = temp.getNext();
		}
		return null;
	}
	
	@Override
	public String toString() {
		StringBuilder buffer = new StringBuilder();
		buffer.append("LinkedList Array Capacity is : ").append(capacity).append("\nitems is : [ ");
		Node node = head;
		while(node != null) {
			buffer.append(node.getElement()).append(" ");
			node = node.getNext();
		}
		buffer.append("]");
		return buffer.toString();
	}

	public static void main(String[] args) {
		LinkedListStack<String> stack = new LinkedListStack<String>(10);
		for(int i = 0; i < 10; i++) {
			stack.push(i + "");
		}
		System.out.println(stack.toString());
		for(int i = 0; i < 5; i++) {
			System.out.println(stack.pop());
		}
		System.out.println(stack.toString());
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
