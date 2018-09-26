package zjq.demo.service.rpcframework;

import java.net.InetSocketAddress;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import zjq.demo.service.rpcframework.web.RpcExporter;
import zjq.demo.service.rpcframework.web.RpcImporter;

/**
 * @author:zhangjq
 * @time:2017年5月25日 下午4:35:33
 * @version:v1.0
 */
public class RpcTest {

	public static void main(String[] args){
		Executor executor = Executors.newSingleThreadExecutor();
		executor.execute(new Runnable() {
			
			@Override
			public void run() {
				try{
					RpcExporter.exporter("localhost", 8088);
				}
				catch(Exception e){
					
				}
			}
		});
		
		RpcImporter<EchoService> importer = new RpcImporter<EchoService>();
		EchoService echo = importer.importer(EchoServiceImpl.class,
				new InetSocketAddress("localhost", 8088));
		System.out.println(echo.echo("Are you OK ?"));
	}
}
