package zjq.test.data;

/**
 * 冒泡排序，时间复杂度O(n^2)
 * @author zhangjq
 *
 */
public class bubbleSort {
	
	public static int[] sort(int[] t) {
		int temp;
		for (int i = 0; i < t.length - 1; i++) {
			for (int j = i + 1; j < t.length; j++) {
				if (t[i] > t[j]) {
					temp = t[i];
					t[i] = t[j];
					t[j] = temp;
				}
			}
		}
		return t;
	}

	public static void main(String args[]) {
		int a[] = {2,1,5,9,7,6};
		sort(a);
		for(int l : a){
			System.out.print(l+" ");
		}
	}
	
}
