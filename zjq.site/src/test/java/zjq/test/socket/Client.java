package zjq.test.socket;

import java.net.Socket;
import java.io.*;

public class Client {
	public static final String ADD = "localhost";//服务器地址 
	public static final int PORT = 12345;//服务器端口号
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("客户端启动...");
		System.out.println("当接收到服务器端字符为 \"OK\" 的时候, 客户端将终止\n"); 
		while(true){
			Socket socket = null;
			try{
				//创建一个流套接字并将其连接到指定主机上的指定端口号 
				socket = new Socket(ADD,PORT);
				DataInputStream input = new DataInputStream(socket.getInputStream()); //来自服务端的流
				DataOutputStream output = new DataOutputStream(socket.getOutputStream());//客户端发出去的流
				String reader = new BufferedReader(new InputStreamReader(System.in)).readLine();
				output.writeUTF(reader);
				
				String ret = input.readUTF();//从服务端读取的String
				System.out.println("服务端发送的数据"+ret);
				
				// 如接收到 "OK" 则断开连接    
                if ("OK".equals(ret)) {    
                    System.out.println("客户端将关闭连接");    
                    Thread.sleep(500);    
                    break;    
                }
                
				output.close();
				input.close();
			}catch(Exception e){
				System.out.println("异常"+e.getMessage());
			}finally{
				if(socket !=null){
					try{
						socket.close();
					}catch(IOException e){
						socket = null;
						System.out.println("socket异常"+e.getMessage());
					}
				}
			}
		}	
	}
}
