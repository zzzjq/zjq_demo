package zjq.demo.service.rpcframework.web;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * RPC服务端
 * 
 * @author:zhangjq
 * @time:2017年5月25日 下午3:30:44
 * @version:v1.0
 */
public class RpcExporter {

	static 
	Executor executor = 
		Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
	
	public static void exporter(String host, int port) throws Exception{
		ServerSocket serverSocket = new ServerSocket();
		serverSocket.bind(new InetSocketAddress(host, port));
		try{
			while(true){
				executor.execute(new Task(serverSocket.accept()));
			}
		}
		finally{
			serverSocket.close();
		}
	}
	
	private static class Task implements Runnable{

		Socket socket = null;
		
		public Task(Socket socket){
			this.socket = socket;
		}
		
		@Override
		public void run() {
			ObjectOutputStream out = null;
			ObjectInputStream in = null;
			try{
				in = new ObjectInputStream(socket.getInputStream());
				String interfaceName = in.readUTF();
				//利用反射机制，获取接口
				Class<?> service = Class.forName(interfaceName);
				String methodName = in.readUTF();
				//利用反射机制，获取参数
				Class<?>[] parameterTypes = (Class<?>[]) in.readObject();
				Object[] arguments = (Object[]) in.readObject();
				
				Method method = service.getMethod(methodName, parameterTypes);
				Object result = method.invoke(service.newInstance(), arguments);
				
				out = new ObjectOutputStream(socket.getOutputStream());
				out.writeObject(result);
			}
			catch(Exception e){
				
			}
			finally{
				if(out != null){
					try {
						out.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				if(in != null){
					try {
						in.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				if(socket != null){
					try {
						socket.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}
}
