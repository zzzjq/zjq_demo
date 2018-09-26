package zjq.test.http.netty;

import java.net.InetSocketAddress;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @author:zhangjq
 * @time:2017年5月26日 下午1:50:08
 * @version:v1.0
 */
public class NettyServer {
	private final int port;
	
	public NettyServer(int port){
		this.port = port;
	}
	
	public void start(){
		final ServerHandler handler = new ServerHandler();
		EventLoopGroup group = new NioEventLoopGroup();
		try{
			ServerBootstrap b = new ServerBootstrap();
			b.group(group)
				.channel(NioServerSocketChannel.class)
				.localAddress(new InetSocketAddress(port))
				.childHandler(new ChannelInitializer<SocketChannel>() {
					@Override
					protected void initChannel(SocketChannel ch)
							throws Exception {
						ch.pipeline().addLast(handler);
					}
				});
			ChannelFuture f = b.bind().sync();
			f.channel().closeFuture().sync();
		}catch(Exception e){
			
		}finally{
			try {
				group.shutdownGracefully().sync();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args){
		new NettyServer(8090).start();
	}
	
}
