package zjq.test.leetcode.easy.array;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author zhangjingqi
 * @date 2019年7月22日下午8:24:31
 *
 **/
public class ContainsDuplicate {

	public boolean containsDuplicate(int[] nums) {
		Set<Integer> set = new HashSet<Integer>(nums.length);
		for(int i : nums) {
			if(!set.add(i)) return true;
		}
		return false;
	}

}
