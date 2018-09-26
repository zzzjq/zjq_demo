package zjq.demo.model;

import java.io.Serializable;

/**
 * @author:zhangjq
 * @time:2017年5月9日 上午10:38:51
 * @version:v1.0
 */
public class Person implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1857055898919965864L;

	private String id;

	private String name;

	private Integer age;

	public Person() {
		super();
	}

	public Person(String name, Integer age) {
		this.setName(name);
		this.setAge(age);
	}

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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
