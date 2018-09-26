package zjq.test.http.io;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.Writer;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author:zhangjq
 * @time:2017年11月7日 下午1:42:51
 * @version:v1.0
 */
public class ReaderWriteTest {

	public static void Read(String filePath) throws Exception{
		Reader reader = new InputStreamReader(
					new FileInputStream(filePath), "UTF-8");
		int len;
		while((len = reader.read()) != -1){
			System.out.println((char)len);
		}
	}
	
	public static void Write(String filePath1, String filePath2) throws Exception{
		Reader reader = new FileReader(new File(filePath1));
		Writer writer = new FileWriter(new File(filePath2));
		int len;
		char[] ch = new char[512];
		while((len = reader.read(ch)) != -1){
			writer.write(ch, 0, len);
			writer.flush();
		}
		reader.close();
		writer.close();
	}
	
	public static void main(String[] args) throws Exception{
		File file = new File("/Users/idealife/2.txt");
		File file2 = new File("/Users/idealife/aa.txt");
		FileInputStream in = new FileInputStream(file);
		FileInputStream in2 = new FileInputStream(file2);
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		int len = 0;
		byte[] bt = new byte[1024];
		while ((len = in.read(bt)) != -1) {
			out.write(bt, 0, len);
		}
		ByteArrayOutputStream out2 = new ByteArrayOutputStream();
		int len2 = 0;
		byte[] bt2 = new byte[1024];
		while ((len2 = in2.read(bt2)) != -1) {
			out2.write(bt2, 0, len2);
		}
		String[] a = new String(out.toByteArray()).split(",");
		System.out.println(a.length);
		String[] b = new String(out2.toByteArray()).split(",");
		System.out.println(b.length);

		List<String> list1 = Arrays.asList(a);
		List<String> list2 = Arrays.asList(b);
		Set<String> set = new HashSet<>();
		
		for(String str : list1) {
			if(!set.add(str))
				System.out.println(str);
		}
	}
	
}
