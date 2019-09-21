/**
 * 
 */
package com.lihao.linkedList;

/**
 * @author lihao
 *
 */
public class LRUBaseLinkedList<T> {
	
	/**
	 * 链表默认容量
	 */
	private static final Integer DEFAULT_CAPACITY  = 10;
	
	/**
	 * 头结点
	 */
	private SNode<T> headNode;
	
	/**
	 * 链表长度
	 */
	private Integer length;
	
	/**
	 * 链表容量
	 */
	private Integer capacity;
	
	public LRUBaseLinkedList() {
		this.headNode = new SNode<>();
		this.capacity = DEFAULT_CAPACITY;
		this.length = 0;
	}

	public LRUBaseLinkedList(Integer capacity) {
		this.headNode = new SNode<>();
		this.capacity = capacity;
		this.length = 0;
	}
	
	public void add(T data) {
		SNode preNode = findPreNode(data);
		
		//链表中存在，删除原数据，在插入到链表头部
		if(preNode != null) {
			deleteElemOptim(preNode);
			insertElemAtBegin(data);
		}else {
			if(length >= this.capacity) {
				//删除尾节点
				deleteElemAtEnd();
			}
			insertElemAtBegin(data);
		}
	}
	
	/**
	 * 删除尾节点
	 */
	private void deleteElemAtEnd() {
		SNode ptr = headNode;
		//空链表直接返回
		if(ptr.getNext() == null) {
			return;
		}
		
		while(ptr.getNext().getNext() != null) {
			ptr = ptr.getNext();
		}
		
		SNode tmp = ptr.getNext();
		ptr.setNext(null);
		tmp = null;
		length--;
	}

	/**
	 * 链表头部插入节点
	 * @param data
	 */
	private void insertElemAtBegin(T data) {
		SNode next = headNode.getNext();
		headNode.setNext(new SNode(data, next));
		length++;
	}

	/**
	 * 删除preNode节点的下一个元素
	 * @param preNode
	 */
	private void deleteElemOptim(SNode preNode) {
		SNode temp = preNode.getNext();
		preNode.setNext(temp.getNext());
		temp = null;
		length--;
	}

	/**
	 * 获取查找到元素的前一个节点
	 * @param data
	 * @return
	 */
	private SNode findPreNode(T data) {
		SNode node = headNode;
		while(node.getNext() != null) {
			if(data.equals(node.getNext().getElement()))
			{
				return node;
			}
			node = node.getNext();
		}
		return null;
	}

	/**
	 * 链表节点
	 * @author lihao
	 *
	 * @param <T>
	 */
	public class SNode<T> {
		
		private T element;
		
		private SNode next;
		
		public SNode(T element) {
			this.element = element;
		}

		public SNode(T element, SNode next) {
			this.element = element;
			this.next = next;
		}
		
		public SNode() {
			this.next = null;
		}

		public T getElement() {
			return element;
		}

		public void setElement(T element) {
			this.element = element;
		}

		public SNode getNext() {
			return next;
		}

		public void setNext(SNode next) {
			this.next = next;
		}
		
		
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
