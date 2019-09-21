/**
 * 
 */
package com.lihao.sort;

/**
 * @author lihao
 *
 */
public class SortUtil {
	
	/**
	 * 冒泡排序
	 * @param array
	 * @param n
	 */
	public static void bubbleSort(int[] array) {
		if(array.length <= 0) {
			return;
		}
		int n = array.length;
		for(int i = 0; i < n; ++i) {
			System.out.println("outer index is : " + i);
			//提前退出冒泡循环的标志位
			boolean flag = false;
			for(int j = 0; j < n - i - 1; ++j) {
				System.out.println("inner index is : " + j);
				if(array[j] > array[j + 1]) {
					//交换位置
					int tmp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = tmp;
					//表示有数据交换
					flag = true;
					System.out.println("change index : " + j + " and index : " + (j+1));
				}
			}
			System.out.println(arrayToString(array));
			//没有数据可交换，说明所有的数据已经有序了
			if(!flag) {
				break;
			}
		}
	}
	
	/**
	 * 插入排序
	 * @param array
	 */
	public static void insertionSort(int[] array) {
		if(array.length <= 1) {
			return;
		}
		int n = array.length;
		for(int i = 1; i < n; ++i) {
			System.out.println("outer index is : " + i);
			int value = array[i];
			int j = i - 1;
			//查找插入的位置
			for(; j >= 0; --j) {
				System.out.println("inner index is : " + j);
				if(array[j] > value) {
					//数据移动
					array[j + 1] = array[j];
					System.out.println("move item : " + j + " to item : " + (j + 1));
				}else {
					break;
				}
			}
			System.out.println("final index is : " + j);
			//插入数据
			System.out.println("insert value : " + value + " to index : " + (j + 1));
			array[j + 1] = value;
			System.out.println(arrayToString(array));
		}
		
	}
	
	/**
	 * 选择排序
	 * @param array
	 */
	public static void selectSort(int[] array) {
		if(array.length <= 1) {
			return;
		}
		int n = array.length;
		for(int i = 0; i < n - 1; ++i) {
			//找到未排序部分中最小的元素
			int j = i + 1;
			int minIndex = i;
			for(; j < n; ++j) {
				if(array[minIndex] > array[j]) {
					minIndex = j;
				}
			}
			//将最小的元素负载已排序部分后面
			if(minIndex != i) {
				System.out.println("switch index : " + i + " and " + minIndex);
				int tmp = array[i];
				array[i] = array[minIndex];
				array[minIndex] = tmp;			
			}
			System.out.println(arrayToString(array));
		}
	}
	
	/**
	 * 归并排序
	 * @param array
	 */
	public static void mergerSort(int[] array) {
		int n = array.length;
		if(n <= 1) {
			return;
		}
		
		mergerSort(array, 0, n-1);
		
		//System.out.println(arrayToString(array));
	}
	
	/**
	 * 递归调用排序
	 * @param array
	 * @param p
	 * @param r
	 */
	private static void mergerSort(int[] array, int p, int r) {
		if(p >= r) {
			return;
		}
		int q = (p + r) / 2;
		//分治递归
		mergerSort(array, p, q);
		mergerSort(array, q + 1, r);
		//将array[p...q]和array[q+1...r]合并为array[p...r]
		merge(array, p, q, r);
		
		System.out.println(arrayToString(array));
	}
	
	/**
	 * 合并数组
	 * @param array
	 * @param p
	 * @param q
	 * @param r
	 */
	private static void merge(int[] array, int p, int q, int r) {
		//初始化临时变量
		int i = p;
		int j = q + 1;
		int k = 0;
		//申请临时数组
		int[] temp = new int[r - p + 1];
		while((i <= q) && (j <= r))
		{
			if(array[i] <= array[j]) {
				temp[k++] = array[i++];
			}else {
				temp[k++] = array[j++];
			}
		}
		//判断哪个子数组中有剩余的数据
		int start = i;
		int end = q;
		if(j <= r) {
			start = j;
			end = r;
		}
		
		//将剩余数据拷贝到临时数组
		while(start <= end) {
			temp[k++] = array[start++];
		}
		
		for(int n = 0; n <= (r - p); n++) {
			array[p+n] = temp[n];
		}
	}
	
	/**
	 * 快速排序
	 * @param array
	 */
	public static void quickSort(int[] array) {
		int n = array.length;
		if(n <= 1) {
			return;
		}
		
		quickSort(array, 0, n - 1);
	}

	/**
	 * 递归调用快速排序函数
	 * @param array
	 * @param i
	 * @param j
	 */
	private static void quickSort(int[] array, int p, int r) {
		if(p >= r) {
			return;
		}
		
		int q = partition(array, p, r);
		quickSort(array, p, q - 1);
		quickSort(array, q + 1, r);
	}

	/**
	 * 
	 * @param array
	 * @param p
	 * @param r
	 * @return
	 */
	private static int partition(int[] array, int p, int r) {
		int pivot = array[r];
		int i = p;
		for(int j = p; j < r; j++) {
			if(array[j] < pivot) {
				int tmp = array[i];
				array[i] = array[j];
				array[j] = tmp;
				i++;
			}
		}
		int tmp = array[i];
		array[i] = array[r];
		array[r] = tmp;
		
		System.out.println(arrayToString(array));
		return i;
		
	}

	public static void main(String[] args) {
		int[] array = {11,8,3,9,7,1,2,5};
		//bubbleSort(array);
		//insertionSort(array);
		//selectSort(array);
		//mergerSort(array);
		quickSort(array);
	}
	
	public static String arrayToString(int[] array) {
		if(array.length <= 0) {
			return null;
		}
		StringBuilder buffer = new StringBuilder();
		buffer.append("array is : [ ");
		for(int i = 0; i < array.length; i++) {
			buffer.append(array[i]).append(" ");
		}
		buffer.append("]");
		return buffer.toString();
	}
	
}
