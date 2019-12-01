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

package org.incoder.netty.protobuf.multiple.client;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.incoder.netty.protobuf.NettyMultipleDataInfo;

import java.util.Random;

/**
 * @author : Jerry xu
 * @date : 2019/11/30  17:17
 */
public class MultipleClientHandler extends SimpleChannelInboundHandler<NettyMultipleDataInfo.MessageInfo> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, NettyMultipleDataInfo.MessageInfo msg) throws Exception {

    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        NettyMultipleDataInfo.MessageInfo messageInfo;
        // 生成 0.1.2 随机数
        int randomInt = new Random().nextInt(3);
        if (0 == randomInt) {
            messageInfo = NettyMultipleDataInfo.MessageInfo.newBuilder()
                    .setMessageType(NettyMultipleDataInfo.MessageInfo.DataType.PersonType)
                    .setPerson(NettyMultipleDataInfo.Person.newBuilder()
                            .setName("张三")
                            .setAge(20)
                            .build()
                    ).build();
        } else if (1 == randomInt) {
            messageInfo = NettyMultipleDataInfo.MessageInfo.newBuilder()
                    .setMessageType(NettyMultipleDataInfo.MessageInfo.DataType.DogType)
                    .setDog(NettyMultipleDataInfo.Dog.newBuilder()
                            .setName("这是一条狗")
                            .setCity("杭州")
                            .build()
                    ).build();
        } else {
            messageInfo = NettyMultipleDataInfo.MessageInfo.newBuilder()
                    .setMessageType(NettyMultipleDataInfo.MessageInfo.DataType.CatType)
                    .setCat(NettyMultipleDataInfo.Cat.newBuilder()
                            .setName("这是一只猫")
                            .setBreed("波米拉")
                            .build()
                    ).build();
        }
        ctx.writeAndFlush(messageInfo);
    }
}
