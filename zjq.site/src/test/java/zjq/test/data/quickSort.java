package zjq.test.data;
/**
 * @author:zhangjq
 * @time:2017年4月24日 下午4:35:47
 * @version:v1.0
 */
public class quickSort {

	public static int getMiddle(int[] a, int start, int end){
		
		int temp = a[start];
		
		while(start < end){
			//从后往前遍历，找比基准小的交换位置
			while(start < end && a[end] >= temp){
				end --;
			}
			a[start] = a[end];
			//从前往后遍历，找比基准大的交换位置
			while(start < end && a[start] <= temp){
				start ++;
			}
			a[end] = a[start];
		}
		a[start] = temp;
		return start;
	}
	
	public static void sort(int[] a, int start, int end){
		if(start < end){
			int mid = getMiddle(a, start, end);
			sort(a, 0, mid-1);
			sort(a, mid+1, end);
		}
	}
	
	public static void quick(int[] a){
		if(a.length>0){
			sort(a, 0, a.length-1);
		}
	}
	
	public static void main(String[] args){
		int[] a = {2,1,4,9,5};
		quick(a);
		for(int i=0;i<a.length;i++){
			System.out.println(a[i]);
		}
		
	}
	
}
