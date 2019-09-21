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
	 * ����Ĭ������
	 */
	private static final Integer DEFAULT_CAPACITY  = 10;
	
	/**
	 * ͷ���
	 */
	private SNode<T> headNode;
	
	/**
	 * ������
	 */
	private Integer length;
	
	/**
	 * ��������
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
		
		//�����д��ڣ�ɾ��ԭ���ݣ��ڲ��뵽����ͷ��
		if(preNode != null) {
			deleteElemOptim(preNode);
			insertElemAtBegin(data);
		}else {
			if(length >= this.capacity) {
				//ɾ��β�ڵ�
				deleteElemAtEnd();
			}
			insertElemAtBegin(data);
		}
	}
	
	/**
	 * ɾ��β�ڵ�
	 */
	private void deleteElemAtEnd() {
		SNode ptr = headNode;
		//������ֱ�ӷ���
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
	 * ����ͷ������ڵ�
	 * @param data
	 */
	private void insertElemAtBegin(T data) {
		SNode next = headNode.getNext();
		headNode.setNext(new SNode(data, next));
		length++;
	}

	/**
	 * ɾ��preNode�ڵ����һ��Ԫ��
	 * @param preNode
	 */
	private void deleteElemOptim(SNode preNode) {
		SNode temp = preNode.getNext();
		preNode.setNext(temp.getNext());
		temp = null;
		length--;
	}

	/**
	 * ��ȡ���ҵ�Ԫ�ص�ǰһ���ڵ�
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
	 * ����ڵ�
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
