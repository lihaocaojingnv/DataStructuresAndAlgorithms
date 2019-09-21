/**
 * 
 */
package com.lihao.stack;

/**
 * ��������ʵ�ֵ�˳��ջ
 * @author lihao
 *
 */
public class ArrayStack {

	//����
	private String[] items;
	
	//ջ��Ԫ�ظ���
	private int count;
	
	//ջ�Ĵ�С
	private int n;
	
	//��ʼ�����飬����һ����СΪn������ռ�
	public ArrayStack(int n) {
		this.items = new String[n];
		this.n = n;
		this.count = 0;
	}
	
	/**
	 * ��ջ����
	 * @param item
	 * @return
	 */
	public boolean push(String item) {
		//����ռ䲻�����ˣ�ֱ�ӷ���false����ջʧ��
		if(count == n) {
			return false;
		}
		items[count] = item;
		++count;
		return true;
	}
	
	/**
	 * ��ջ����
	 * @return
	 */
	public String pop() {
		//ջΪ�գ�ֱ�ӷ���null
		if(count == 0) {
			return null;
		}
		//�����±�Ϊcount-1������Ԫ�أ�����ջ�е�Ԫ�ظ���count��һ
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
