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

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

/**
 * @author : Jerry xu
 * @date : 2019/11/19  10:33
 */
public class ChatServerHandler extends SimpleChannelInboundHandler<String> {

    /**
     * 保存所有与服务器端已建立好连接的客户端 channel 对象
     */
    private static ChannelGroup channelGroup = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    /**
     * 接收到客户端的消息
     *
     * @param ctx 通道处理上下文
     * @param msg 消息
     * @throws Exception 异常
     */
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        Channel channel = ctx.channel();
        channelGroup.forEach(ch -> {
            // 连接channel和发送channel不是同一个
            if (channel != ch) {
                ch.writeAndFlush("客户端 == " + channel.remoteAddress() + " 发送消息：" + msg + "\n");
            } else {
                // 连接channel和发送channel是同一个
                ch.writeAndFlush("【自己" + channel.remoteAddress() + "】" + msg + "\n");
            }
        });
    }

    /**
     * 只表示连接建立，并不携带任何消息
     *
     * @param ctx 通道处理上下文
     * @throws Exception 异常
     */
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        // 获取到连接对象
        Channel channel = ctx.channel();
        // 先广播 【第一客户端接入是不会打印该行】
        channelGroup.writeAndFlush("客户端 ======== " + channel.remoteAddress() + " 《加入》\n");
        // 再加入
        channelGroup.add(channel);
    }

    /**
     * 只表示连接断开，不携带任何消息
     *
     * @param ctx 通道处理上下文
     * @throws Exception 异常
     */
    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        channelGroup.writeAndFlush("客户端 ======== " + channel.remoteAddress() + " 《离开》\n");
        // 这行代码 Netty 会自定调用，可以省略
//        channelGroup.remove(channel);
        // 可以用 channelGroup.size(); 来表示保存的数量；
        // 可以看出，handlerRemoved()方法会自动执行 channelGroup.remove(channel);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        System.out.println("客户端 ======== " + channel.remoteAddress() + " 《上线》");
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        System.out.println("客户端 ======== " + channel.remoteAddress() + " 《下线》");
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
