package zjq.demo.service.rpcframework.web;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * RPC客户端 JDK动态代理实现远程接口调用
 * 
 * @author:zhangjq
 * @time:2017年5月25日 下午3:48:34
 * @version:v1.0
 */
public class RpcImporter<S> {
	@SuppressWarnings("unchecked")
	public S importer(final Class<?> serviceClass, final InetSocketAddress addr) {
		return (S) Proxy.newProxyInstance(serviceClass.getClassLoader(),
				new Class<?>[] { serviceClass.getInterfaces()[0] },
				new InvocationHandler() {

					@Override
					public Object invoke(Object proxy, Method method,
							Object[] args) throws Throwable {
						Socket socket = null;
						ObjectOutputStream out = null;
						ObjectInputStream in = null;
						try {
							socket = new Socket();
							socket.connect(addr);
							out = new ObjectOutputStream(socket.getOutputStream());
							out.writeUTF(serviceClass.getName());
							out.writeUTF(method.getName());
							out.writeObject(method.getParameterTypes());
							out.writeObject(args);
							in = new ObjectInputStream(socket.getInputStream());
							return in.readObject();
						} finally {

							if (out != null) {
								try {
									out.close();
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}

							if (in != null) {
								try {
									in.close();
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}

							if (socket != null) {
								try {
									socket.close();
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}

						}
					}
				});
	}
}
