package zjq.test.common;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author  zhangjingqi
 * @version V1.0
 * @Date	2016年4月18日下午6:23:36
 */

public class ClassLoaderTest {

	public static void main(String []args) throws Exception{
		ClassLoader loader = new ClassLoader() {
			@Override
			public Class<?> loadClass(String name) throws ClassNotFoundException{
				try{
					String fileName = name.substring(name.lastIndexOf(".")+1)+".class";
					InputStream in = getClass().getResourceAsStream(fileName);
					if(in == null){
						return super.loadClass(name);
					}
					byte[] b = new byte[in.available()];
					in.read(b);
					return defineClass(name, b, 0, b.length);
				}catch(IOException e){
					throw new ClassNotFoundException(name);
				}
			}
		};
		//虚拟机存在两个zjq.demo.test.util.ClassLoaderTest类，一个由系统类加载器加载，一个由我们自定义类加载器加载，虽然属于
		//同一个class文件，但是是两个独立的类（类加载器不同），所以instanceof返回false；
		Object obj = loader.loadClass("zjq.test.common.ClassLoaderTest").newInstance();
		System.out.println(obj.getClass());
		System.out.println(obj instanceof zjq.test.common.ClassLoaderTest);
	}
}

