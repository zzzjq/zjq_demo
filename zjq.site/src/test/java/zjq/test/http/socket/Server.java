package zjq.test.http.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static final int PORT = 12345;//server端口号

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("服务端启动");
		Server server = new Server();
		server.init();
	}

	public void init(){
		try{
			ServerSocket serverSocket = new ServerSocket(PORT);
			while(true){
				// 一旦有堵塞, 则表示服务器与客户端获得了连接 
				Socket socket = serverSocket.accept();
				// 处理这次连接
				new Thread(new Handler(socket)).start();
			}
		}catch(Exception e){
			System.out.println("服务器异常: " + e.getMessage());
		}
	}
	
	private class Handler implements Runnable{
		private Socket socket;
		
		public Handler(Socket client){
			this.socket = client;
//			socket = client;
//			new Thread(this).start();
		}
		public void run(){
			try{
				DataInputStream input = new DataInputStream(socket.getInputStream());
				String clientString = input.readUTF();
				System.out.println("客户端发过来的内容:" + clientString);
				
				DataOutputStream output = new DataOutputStream(socket.getOutputStream());
				String serverString = new BufferedReader(new InputStreamReader(System.in)).readLine();
				output.writeUTF(serverString);
				
				output.close();
				input.close();
			}catch(Exception e){
				System.out.println("服务器 run 异常: " + e.getMessage());
			}finally{
				if(socket!=null){
					try{
						socket.close();
					}catch(IOException e){
						socket = null;
						System.out.println("服务端 finally 异常:" + e.getMessage()); 
					}
				}
			}
		}
	}
}
