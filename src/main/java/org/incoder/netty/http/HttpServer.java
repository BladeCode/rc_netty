/*
 * Copyright (C) 2018 Jerry xu Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.incoder.netty.http;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * Description.
 *
 * @author : Jerry xu
 * @date : 7/10/2018 10:01 PM
 */
public class HttpServer {

    public static void main(String[] args) throws InterruptedException {
        // 事件循环组
        // bossGroup接收客户端的连接，但不对连接做任何处理，接收到的连接转给workerGroup
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        // workerGroup连接的后续处理，如：获取连接的参数，进行业务处理，返回给客户端
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            // Netty启动服务端的类
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    // 自定义的处理器
                    .childHandler(new HttpServerInitializer());
            ChannelFuture channelFuture = serverBootstrap.bind(2222).sync();
            channelFuture.channel().closeFuture().sync();
        } finally {
            // 关闭
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}
