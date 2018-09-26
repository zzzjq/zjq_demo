package zjq.test.common;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author:zhangjq
 * @time:2017年5月9日 上午10:38:51
 * @version:v1.0
 */
@Controller
public class Person implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1857055898919965864L;
	
	@Autowired
	private String id;

	private String name;

	private Integer age;

//	public Person() {
//		super();
//	}

	
	public Person(String name, Integer age) {
		this.setName(name);
		this.setAge(age);
	}

	@RequestMapping("/")
	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

//	public String getId() {
//		return id;
//	}
//
//	public void setId(String id) {
//		this.id = id;
//	}
	
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		//三种获取class的方法
		Class c = Person.class;
//		Class c2 = new Person().getClass();
		Class c3 = Class.forName("zjq.test.reflect.Person");
		//获取类的变量
		Field[] f =  c.getDeclaredFields();
		for(Field field : f){
			
			for(Annotation a:field.getAnnotations()){
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
			Person person = (Person) constructor.newInstance(new Object[]{"张三",18});
			System.out.println(person.getName());
			System.out.println(person.getAge());
			System.out.println(constructor.getName());
		}
	}

}
