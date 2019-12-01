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

package org.incoder.netty.protobuf.single.client;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.incoder.netty.protobuf.NettyDataInfo;

/**
 * @author : Jerry xu
 * @date : 2019/11/30  14:56
 */
public class SingleClientHandler extends SimpleChannelInboundHandler<NettyDataInfo.Person> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, NettyDataInfo.Person msg) throws Exception {

    }

    /**
     * 客户端建立连接后发送消息给服务端
     *
     * @param ctx ctx
     * @throws Exception exception
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        NettyDataInfo.Person person = NettyDataInfo.Person.newBuilder()
                .setName("netty")
                .setAge(20)
                .setAddress("https://netty.io")
                .build();

        // 发送消息给服务器
        ctx.channel().writeAndFlush(person);
    }
}
