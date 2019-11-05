package zjq.demo.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Base64;

import zjq.dao.model.Person;

/**
 * java 序列化工具
 * 
 * @author zhangjq
 * @date 2018年5月9日 下午5:07:10
 *
 **/
public class SerializeUtil {

	/****
	 * 序列化
	 * 
	 * @param object
	 * @return
	 */
	public static byte[] serialize(Object object) {
		try (ByteArrayOutputStream bout = new ByteArrayOutputStream();
				ObjectOutputStream out = new ObjectOutputStream(bout);) {
			out.writeObject(object);
			return bout.toByteArray();
		} catch (Exception e) {
			return null;
		}
	}

	/***
	 * 反序列化
	 * 
	 * @param bytes
	 * @return
	 */
	public static Object unserialize(byte[] bytes) {
		try(ByteArrayInputStream in = new ByteArrayInputStream(bytes);
				ObjectInputStream oin = new ObjectInputStream(in);) {
			return oin.readObject();
		} catch (Exception e) {
			return null;
		}
	}
	
	public static void main(String[] args) {
		Person p = new Person("zjq", 18);
		byte[] b = serialize(p);
		System.out.println(new String(Base64.getEncoder().encode(b)));
		System.out.println(unserialize(b).toString());
	}

}
