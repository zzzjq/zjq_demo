package zjq.test.data.stack;
/**
 * 例如：(2007)10 = (3727)8，其运算过程如下：
 *	8 2007
 *	8 250 	7
 *	8 31 	2
 *	8 3 	7
 *	  0 	3 
 * @author:zhangjq
 * @time:2017年9月27日 下午3:18:31
 * @version:v1.0
 */
public class StackTest {

	//转换为8进制
	public static void con(int i) throws Exception{
		Stack s = new StackLink();
		while(i>0){
			s.push(i%8 + "");
			i=i/8;
		}
		while(!s.isEmpty()){
			System.out.println(s.pop());
		}
	}
	
	public static void main(String[] args) throws Exception{
		con(2007);
	}
}
