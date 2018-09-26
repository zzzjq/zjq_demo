package zjq.test.http.io;

import java.io.*;
import java.util.List;

public class CopyFile {
	
	public static List<File> get(String filepath , List<File> list){
			File file = new File(filepath);
			if(file.isDirectory()){
				File[] files = file.listFiles();
				for(File f : files){
					if(f.isDirectory()){
						get(f.getAbsolutePath() , list);
					}else{
						list.add(f);
					}
				}
			}
			return list;
	}
	
	public static void readFile(String path) throws Exception{
		File file = new File(path);
		FileInputStream in = new FileInputStream(file);
		FileOutputStream out = new FileOutputStream(new File("/Users/idealife/txt.txt"));
		int length = 0;
		byte[] bt = new byte[1024];
		while((length = in.read(bt))!= -1){
			out.write(bt, 0, length);
			out.flush();
		}
		in.close();
		out.close();
	}

	public static void main(String args[]) throws IOException{	
		//先写一个文件，写完关闭流
		File file = new File("/Users/idealife/1.txt");
		FileOutputStream out = new FileOutputStream(file);
		out.write("写一个文件".getBytes("utf-8"));
		out.close();
		//创建副本
		File file2 = new File("/Users/idealife/2.txt");
		FileOutputStream out2 = new FileOutputStream(file2);
		//将被复制的文件放入输入流
		FileInputStream in = new FileInputStream(file);
		//以byte[]缓存的形式读取被复制的文件，并以byte缓存写入另一个文件
		byte[] bt = new byte[1024];
		int length = 0;
		while((length = in.read(bt)) != -1){
			out2.write(bt, 0, length);
			out2.flush();
		}
		//关闭流
		in.close();
		out2.close();
	}
}
