package zjq.test.common;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * java序列化和反序列化
 * transient关键字 ，不需要序列化的修饰
 * @author Administrator
 *
 */
public class Serializations {

	public static void serialize(String outPath, Object outObj)
			throws IOException {
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(outPath));
			oos.writeObject(outObj);
			oos.flush();
		} finally {
			if (oos != null) {
				oos.close();
			}
		}
	}

	public static Object deserializle(String inPath) throws IOException,
			ClassNotFoundException {
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(new FileInputStream(inPath));
			return ois.readObject();
		} finally {
			if (ois != null)
				ois.close();
		}
	}
	
	public static void main(String[] args) throws Exception{
		Name name = new Name("张","三");
		Serializations.serialize("F:\\aa.txt",name);
		Object obj = Serializations.deserializle("F:\\aa.txt");
		System.out.println(obj);
	}
}

	class Name implements Serializable{
		/**
		 * 
		 */
		private static final long serialVersionUID = -3219431987270577466L;
		private String firstname;
		//transient关键词，不需要序列化的字段
		private  transient String lastname;
	
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
		public String toString(){
			return "我的名字是"+firstname+"，"+lastname;
		}
	
	}
