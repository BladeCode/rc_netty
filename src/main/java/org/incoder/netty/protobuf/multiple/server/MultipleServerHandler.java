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

package org.incoder.netty.protobuf.multiple.server;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.incoder.netty.protobuf.NettyMultipleDataInfo;

/**
 * @author : Jerry xu
 * @date : 2019/11/30  17:17
 */
public class MultipleServerHandler extends SimpleChannelInboundHandler<NettyMultipleDataInfo.MessageInfo> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, NettyMultipleDataInfo.MessageInfo msg) throws Exception {

        NettyMultipleDataInfo.MessageInfo.DataType dataType = msg.getMessageType();
        if (dataType == NettyMultipleDataInfo.MessageInfo.DataType.PersonType) {
            NettyMultipleDataInfo.Person person = msg.getPerson();
            System.out.println(person.getAge());
            System.out.println(person.getName());
        } else if (dataType == NettyMultipleDataInfo.MessageInfo.DataType.DogType) {
            NettyMultipleDataInfo.Dog dog = msg.getDog();
            System.out.println(dog.getName());
            System.out.println(dog.getCity());
        } else {
            NettyMultipleDataInfo.Cat cat = msg.getCat();
            System.out.println(cat.getName());
            System.out.println(cat.getBreed());
        }
    }
}
