package com.ityousee.nettystart;

import io.netty.bootstrap.Bootstrap;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.DefaultEventLoop;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

public class TestServer {
  public static void main(String args[]) throws Exception{
      EventLoopGroup bossGroup = new NioEventLoopGroup();
      EventLoopGroup workGroup = new NioEventLoopGroup();
      try{
          ServerBootstrap serverBootstrap = new ServerBootstrap();
          serverBootstrap.group(bossGroup,workGroup).channel(NioServerSocketChannel.class).childHandler(new TestHttpServerInit());
          ChannelFuture future = serverBootstrap.bind(8899).sync();
          future.channel().closeFuture().sync();
      }finally {
          bossGroup.shutdownGracefully();
          workGroup.shutdownGracefully();
      }


  }

}
