package zjq.test.leetcode.easy;

import java.util.Stack;

/**
 * leetcode-20 有效的括号
 * 
 * @author zhangjingqi
 * @date 2019年5月22日下午7:22:56
 *
 **/
public class IsValid {

	public static boolean isValid(String s) {
		Stack<Character> stack = new Stack<Character>();
		char[] cs = s.toCharArray();
		for(char c : cs) {
			if(stack.isEmpty()){
				stack.push(c);
			} else if((stack.peek() == '(' && c == ')') || (stack.peek() == '[' && c == ']') || (stack.peek() == '{' && c == '}')) {
				stack.pop();
			} else {
				stack.push(c);
			}	
		}
		return stack.isEmpty();
	}
	
	public static void main(String[] args) {
		System.out.println(isValid("{]}"));
		System.out.println(isValid("}{"));
		System.out.println(isValid("{[]}"));
	}
	
}
