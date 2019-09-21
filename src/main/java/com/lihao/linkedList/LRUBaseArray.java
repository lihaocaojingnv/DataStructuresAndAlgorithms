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

	//默认数组容量
	private static final int DEFAULT_CAPACITY = (1 << 3);

	//数组容量
	private int capacity;
	
	private int count;
	
	//换粗数组
	private T[] value;

	//值和索引之间的映射
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
	 * 模拟访问某个值
	 * @param object
	 */
	public void offer(T object) {
		if(null == object) {
			throw new IllegalArgumentException("该缓存容器不支持null!");
		}
		
		Integer index = holder.get(object);
		if(index == null) {
			if(isFull()) {
				//数组已满，将最后一个数据删除，将新数据置于数组头部
				removeAndCache(object);
			}else {
				//缓存未满，将已有的数据统一向右移一位，同时将新数据置于数组头部
				cache(object, count);
			}
		}else {
			//新数据已经在缓存中，将新数据之前的数据统一向右移一位，同时将新数据置于数组头部
			update(index);
		}
	}
	
	/**
	 * 若缓存中有指定位置，则更新位置
	 * @param index
	 */
	private void update(Integer end) {
		T target = value[end];
		rightShift(end);
		value[0] = target;
		holder.put(target, 0);
	}

	/**
	 * 缓存满的情况，先删除数组末尾的数据，在缓存到数组头部
	 * @param object
	 */
	private void removeAndCache(T object) {
		T key = value[--count];
		holder.remove(key);
		cache(object, count);
	}

	/**
	 * 缓存数据到头部，但是要先右移
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
	 * end以及end左边的数据统一右移一位
	 * @param end
	 */
	private void rightShift(int end) {
		for(int i = end - 1; i >= 0; i--) {
			value[i+1] = value[i];
			holder.put(value[i], i+1);
		}
		
	}

	/**
	 * 判断缓存容器是否为空
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
