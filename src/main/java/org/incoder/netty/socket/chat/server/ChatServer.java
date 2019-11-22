/*
 * Copyright (C) 2019 The Jerry xu Open Source Project
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

package org.incoder.netty.socket.chat.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * 一对多（一台服务，与 N 个客户端进行连接，且 N 个客户端直接可进行互相通信）
 * 1. 第一台客户端（A）与服务器（S）建立连接，未发生任何事情
 * 2. 第二台客户端（B）与服务器（S）建立连接后，S 打印：B 已上线，同时 S 通知 A : B 已上线【A在线情况下】
 * 3. 第三台客户端（C）与服务器（S）建立连接后，S 打印：C 已上线，同时 S 分别通知 A，B：C 已上线【A，B 都在线情况下】
 * <p>
 * A，B，C 与服务器（S）已建立连接，此时 A 发送了一条消息后，A，B，C 三个客户端都会收到 A 发送的消息
 * 对于 A：服务器会显示 自己发送消息
 * 对于 B：显示 A 发送的消息
 * 对于 C：显示 A 发送的消息
 *
 * @author : Jerry xu
 * @date : 2019/11/19  00:48
 */
public class ChatServer {

    public static void main(String[] args) throws InterruptedException {
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workGroup = new NioEventLoopGroup();

        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(bossGroup, workGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChatServerInitializer());
            ChannelFuture channelFuture = serverBootstrap.bind(1234).sync();
            channelFuture.channel().closeFuture().sync();
        } finally {
            bossGroup.shutdownGracefully();
            workGroup.shutdownGracefully();
        }
    }
}
