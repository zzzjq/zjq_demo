package zjq.test.http.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

/**
 * 客户端处理数据的Handler
 * 
 * @author:zhangjq
 * @time:2017年12月21日 下午3:34:44
 * @version:v1.0
 */
public class ClientHandler extends SimpleChannelInboundHandler<ByteBuf>{

	/**建立连接后调用**/
	@Override
	public void channelActive(ChannelHandlerContext ctx) {
		ctx.writeAndFlush(Unpooled
				.copiedBuffer("Netty test", CharsetUtil.UTF_8));
	}
	
	/**接受到消息的时候调用**/
	@Override
	protected void channelRead0(ChannelHandlerContext ctx, ByteBuf msg)
			throws Exception {
		System.out
				.println("Client received:" + msg.toString(CharsetUtil.UTF_8));
	}
	
	/**发生异常的时候调用**/
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx,
			Throwable cause){
		cause.printStackTrace();
		System.out.println("error");
		ctx.close();
	}
	
}
