package zjq.test.common;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * 
 * @author zhangjq
 * @date 2018年11月29日下午5:13:38
 *
 **/
public class ClassTest {
	public static void main(String[] args) throws Exception{
		//三种获取class的方法
		Class c = Date.class;
		Class c2 = new Date().getClass();
		Class c3 = Class.forName("java.util.Date");
		//获取类的变量
		Field[] f =  c.getDeclaredFields();
		for (Field field : f) {
			field.setAccessible(true);
			System.out.println(field.getName());
			System.out.println(field.getType().getTypeName());
		}
		System.out.println("-----------------------------------");
		//获取类的方法
		Method[] m = c.getDeclaredMethods();
		for(Method method : m){
			System.out.println(method.getName());
		}
	}

}
