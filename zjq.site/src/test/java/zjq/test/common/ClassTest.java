package zjq.test.common;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
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
			for (Annotation a : field.getAnnotations()) {
				System.out.println(a.annotationType());
			}
			System.out.println(Modifier.toString(field.getModifiers()));
			System.out.println(field.getType().getSimpleName());
		}
		System.out.println("-----------------------------------");
		//获取类的方法
		Method[] m = c.getDeclaredMethods();
		for(Method method : m){
			method.getAnnotations();
			System.out.println(method.getName());
		}
		System.out.println("-----------------------------------");
		//获取类的构造器
		Constructor[] co = c.getConstructors();
		for(Constructor constructor : co){
			Date date = (Date) constructor.newInstance();
			System.out.println(date.getTime());
		}
	}
}
