package zjq.test.data;
/**
 * 插入排序
 * @author:zhangjq
 * @time:2017年11月1日 下午2:20:15
 * @version:v1.0
 */
public class InsertSort {

	public static int[] sort(int[] t){
		int temp;
		int n;
		for(int i=1; i<t.length; i++){
			n = i;
			temp = t[i];
			while(n>0 && t[n-1]>=temp){
				t[n] = t[n-1];
				n--;
			}
			t[n] = temp;
		}
		
		return t;
	}
	
	public static void main(String[] args){
		int[] t = {2,1,4,3,5,9,2,3};
		sort(t);
		for(int i : t){
			System.out.println(i);
		}
	}

}
