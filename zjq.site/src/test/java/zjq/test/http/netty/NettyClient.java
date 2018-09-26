package zjq.test.http.netty;

import java.net.InetSocketAddress;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @author:zhangjq
 * @time:2017年12月21日 下午4:22:09
 * @version:v1.0
 */
public class NettyClient {
	
	public final String host;
	
	public final int port;
	
	public NettyClient(String host, int port){
		this.host = host;
		this.port = port;
	}
	
	public void start() {
		EventLoopGroup group = new NioEventLoopGroup();
		try{
			Bootstrap b = new Bootstrap();
			b.group(group)
				.channel(NioSocketChannel.class)
				.remoteAddress(new InetSocketAddress(host, port))
				.handler(new ChannelInitializer<SocketChannel>() {
					@Override
					protected void initChannel(SocketChannel ch)
							throws Exception {
						ch.pipeline().addLast(new ClientHandler());
					}
				});
			ChannelFuture f = b.connect().sync();
			f.channel().closeFuture().sync();
		}
		catch(Exception e){
			
		} 
		finally{
			try {
				group.shutdownGracefully().sync();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args){
		String host = "localhost";
		int port = 8090;
		new NettyClient(host, port).start();
	}

}
