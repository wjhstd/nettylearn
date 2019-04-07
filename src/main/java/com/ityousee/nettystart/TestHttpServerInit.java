package com.ityousee.nettystart;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;

public class TestHttpServerInit extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pip = ch.pipeline();
        pip.addLast("httpServerCodec",new HttpServerCodec());
        pip.addLast("testHandler",new TestHttpServerHanlder());
    }
}
