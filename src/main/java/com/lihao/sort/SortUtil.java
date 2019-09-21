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
	 * ð������
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
			//��ǰ�˳�ð��ѭ���ı�־λ
			boolean flag = false;
			for(int j = 0; j < n - i - 1; ++j) {
				System.out.println("inner index is : " + j);
				if(array[j] > array[j + 1]) {
					//����λ��
					int tmp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = tmp;
					//��ʾ�����ݽ���
					flag = true;
					System.out.println("change index : " + j + " and index : " + (j+1));
				}
			}
			System.out.println(arrayToString(array));
			//û�����ݿɽ�����˵�����е������Ѿ�������
			if(!flag) {
				break;
			}
		}
	}
	
	/**
	 * ��������
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
			//���Ҳ����λ��
			for(; j >= 0; --j) {
				System.out.println("inner index is : " + j);
				if(array[j] > value) {
					//�����ƶ�
					array[j + 1] = array[j];
					System.out.println("move item : " + j + " to item : " + (j + 1));
				}else {
					break;
				}
			}
			System.out.println("final index is : " + j);
			//��������
			System.out.println("insert value : " + value + " to index : " + (j + 1));
			array[j + 1] = value;
			System.out.println(arrayToString(array));
		}
		
	}
	
	/**
	 * ѡ������
	 * @param array
	 */
	public static void selectSort(int[] array) {
		if(array.length <= 1) {
			return;
		}
		int n = array.length;
		for(int i = 0; i < n - 1; ++i) {
			//�ҵ�δ���򲿷�����С��Ԫ��
			int j = i + 1;
			int minIndex = i;
			for(; j < n; ++j) {
				if(array[minIndex] > array[j]) {
					minIndex = j;
				}
			}
			//����С��Ԫ�ظ��������򲿷ֺ���
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
	 * �鲢����
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
	 * �ݹ��������
	 * @param array
	 * @param p
	 * @param r
	 */
	private static void mergerSort(int[] array, int p, int r) {
		if(p >= r) {
			return;
		}
		int q = (p + r) / 2;
		//���εݹ�
		mergerSort(array, p, q);
		mergerSort(array, q + 1, r);
		//��array[p...q]��array[q+1...r]�ϲ�Ϊarray[p...r]
		merge(array, p, q, r);
		
		System.out.println(arrayToString(array));
	}
	
	/**
	 * �ϲ�����
	 * @param array
	 * @param p
	 * @param q
	 * @param r
	 */
	private static void merge(int[] array, int p, int q, int r) {
		//��ʼ����ʱ����
		int i = p;
		int j = q + 1;
		int k = 0;
		//������ʱ����
		int[] temp = new int[r - p + 1];
		while((i <= q) && (j <= r))
		{
			if(array[i] <= array[j]) {
				temp[k++] = array[i++];
			}else {
				temp[k++] = array[j++];
			}
		}
		//�ж��ĸ�����������ʣ�������
		int start = i;
		int end = q;
		if(j <= r) {
			start = j;
			end = r;
		}
		
		//��ʣ�����ݿ�������ʱ����
		while(start <= end) {
			temp[k++] = array[start++];
		}
		
		for(int n = 0; n <= (r - p); n++) {
			array[p+n] = temp[n];
		}
	}
	
	/**
	 * ��������
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
	 * �ݹ���ÿ���������
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
