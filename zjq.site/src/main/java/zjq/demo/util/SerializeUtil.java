package zjq.demo.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

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
		ObjectOutputStream out = null;
		ByteArrayOutputStream bout = null;
		try {
			bout = new ByteArrayOutputStream();
			out = new ObjectOutputStream(bout);
			out.writeObject(object);
			byte[] bytes = bout.toByteArray();
			return bytes;
		} catch (Exception e) {
		}
		return null;
	}

	/***
	 * 反序列化
	 * 
	 * @param bytes
	 * @return
	 */
	public static Object unserialize(byte[] bytes) {
		ByteArrayInputStream in = null;
		try {
			in = new ByteArrayInputStream(bytes);
			ObjectInputStream oin = new ObjectInputStream(in);
			return oin.readObject();
		} catch (Exception e) {
		}
		return null;
	}

}
