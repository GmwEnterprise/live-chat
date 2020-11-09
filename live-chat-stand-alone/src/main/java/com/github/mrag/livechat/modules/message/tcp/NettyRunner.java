package com.github.mrag.livechat.modules.message.tcp;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.net.InetSocketAddress;

@Component
@ConfigurationProperties(prefix = "config.netty")
public final class NettyRunner implements InitializingBean, DisposableBean {
    private static final Logger log = LoggerFactory.getLogger(NettyRunner.class);

    private InetSocketAddress addr;

    private final NioEventLoopGroup executors = new NioEventLoopGroup();

    @Override
    public void afterPropertiesSet() throws Exception {
        ServerBootstrap bootstrap = new ServerBootstrap().group(executors)
                .localAddress(addr).channel(NioServerSocketChannel.class)
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        ch.pipeline().addLast(new FirstChannelHandler());
                    }
                });
        bootstrap.bind().addListener((ChannelFutureListener) future -> {
            if (future.isSuccess()) log.debug("Netty service successfully started.");
        });
    }

    @Override
    public void destroy() throws Exception {
        this.executors.shutdownGracefully();
    }

    public void setPort(int port) {
        addr = new InetSocketAddress(port);
    }
}
