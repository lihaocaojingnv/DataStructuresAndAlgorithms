/**
 * 
 */
package com.lihao.linkedList;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lihao
 *
 */
public class LRUBaseArray<T> {

	//Ĭ����������
	private static final int DEFAULT_CAPACITY = (1 << 3);

	//��������
	private int capacity;
	
	private int count;
	
	//��������
	private T[] value;

	//ֵ������֮���ӳ��
	private Map<T, Integer> holder;
	
	public LRUBaseArray() {
		this(DEFAULT_CAPACITY);
	}
	
	public LRUBaseArray(int capacity) {
		this.capacity = capacity;
		value = (T[]) new Object[capacity];
		count = 0;
		holder = new HashMap<T, Integer>(capacity);
	}
	
	/**
	 * ģ�����ĳ��ֵ
	 * @param object
	 */
	public void offer(T object) {
		if(null == object) {
			throw new IllegalArgumentException("�û���������֧��null!");
		}
		
		Integer index = holder.get(object);
		if(index == null) {
			if(isFull()) {
				//���������������һ������ɾ��������������������ͷ��
				removeAndCache(object);
			}else {
				//����δ���������е�����ͳһ������һλ��ͬʱ����������������ͷ��
				cache(object, count);
			}
		}else {
			//�������Ѿ��ڻ����У���������֮ǰ������ͳһ������һλ��ͬʱ����������������ͷ��
			update(index);
		}
	}
	
	/**
	 * ����������ָ��λ�ã������λ��
	 * @param index
	 */
	private void update(Integer end) {
		T target = value[end];
		rightShift(end);
		value[0] = target;
		holder.put(target, 0);
	}

	/**
	 * ���������������ɾ������ĩβ�����ݣ��ڻ��浽����ͷ��
	 * @param object
	 */
	private void removeAndCache(T object) {
		T key = value[--count];
		holder.remove(key);
		cache(object, count);
	}

	/**
	 * �������ݵ�ͷ��������Ҫ������
	 * @param object
	 * @param count2
	 */
	private void cache(T object, int end) {
		rightShift(end);
		value[0] = object;
		holder.put(object, 0);
		count++;
	}

	/**
	 * end�Լ�end��ߵ�����ͳһ����һλ
	 * @param end
	 */
	private void rightShift(int end) {
		for(int i = end - 1; i >= 0; i--) {
			value[i+1] = value[i];
			holder.put(value[i], i+1);
		}
		
	}

	/**
	 * �жϻ��������Ƿ�Ϊ��
	 * @return
	 */
	private boolean isFull() {
		return count == capacity;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
