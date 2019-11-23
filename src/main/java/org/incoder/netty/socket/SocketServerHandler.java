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

package org.incoder.netty.socket;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.UUID;

/**
 * 服务器端 Handler.
 *
 * @author : Jerry xu
 * @date : 7/16/2018 12:04 AM
 */
public class SocketServerHandler extends SimpleChannelInboundHandler<String> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        System.out.println("客户端远程地址：" + ctx.channel().remoteAddress());
        // 接收到客户端的消息 msg，这里是 String 类型
        System.out.println("接收到客户端的消息：" + msg);

        // 方法：writeAndFlush() = write() + flush()
        // write()：写
        // flush()：把缓冲清理掉
        // writeAndFlush()：写并且把缓冲清理掉，常用该方法
        ctx.channel().writeAndFlush("来之服务端的响应！" + UUID.randomUUID());
    }


    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
        ctx.close();
    }
}
