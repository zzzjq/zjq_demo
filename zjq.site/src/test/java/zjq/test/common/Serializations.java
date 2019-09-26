package zjq.test.common;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * java序列化和反序列化 transient关键字 ，不需要序列化的修饰
 * 
 * @author Administrator
 *
 */
public class Serializations {

	public static void serialize(String outPath, Object outObj) throws IOException {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(outPath));) {
			oos.writeObject(outObj);
			oos.flush();
		} catch (Exception e) {
		}
	}

	public static Object deserializle(String inPath) throws IOException, ClassNotFoundException {
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(inPath));) {
			return in.readObject();
		} catch (Exception e) {
		}
		return null;
	}

	public static void main(String[] args) throws Exception {
		Name name = new Name("张", "三");
		Serializations.serialize("/Users/idealife/zjq/aa.txt", name);
		Object obj = Serializations.deserializle("/Users/idealife/zjq/aa.txt");
		System.out.println(obj);
	}

	static class Name implements Serializable {
		/**
		 * 
		 */
		private static final long serialVersionUID = -3219431987270577466L;
		private String firstname;
		// transient关键词，不需要序列化的字段
		private transient String lastname;

		public Name() {
			System.out.println("无参构造器");
		}

		public Name(String firstname, String lastname) {
			System.out.println("全参构造器");
			this.firstname = firstname;
			this.lastname = lastname;
		}

		public String getFirstname() {
			return firstname;
		}

		public void setFirstname(String firstname) {
			this.firstname = firstname;
		}

		public String getLastname() {
			return lastname;
		}

		public void setLastname(String lastname) {
			this.lastname = lastname;
		}

		@Override
		public String toString() {
			return "我的名字是" + firstname + "，" + lastname;
		}

	}

}