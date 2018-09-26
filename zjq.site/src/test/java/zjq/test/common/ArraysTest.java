package zjq.test.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * @author:zhangjq
 * @time:2017年9月27日 下午2:15:00
 * @version:v1.0
 */
public class ArraysTest{

	public static void main(String[] args){
		String[] str = {"bbb","aa","BBb","Aa","bBb","bcb","bba"};
		Arrays.sort(str);
		Collections.sort(new ArrayList<String>());
		for(String s:str){
		System.out.println(s);
		}
	}
}

