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

package org.incoder.protobuf;

import com.google.protobuf.InvalidProtocolBufferException;

/**
 * @author : Jerry xu
 * @date : 2019/11/30  14:33
 */
public class HelloProtobufTest {

    public static void main(String[] args) throws InvalidProtocolBufferException {
        ///////////////////////////////////////////////////////////////////////////
        // 把下面的这个过程等同到 RPC 的过程
        ///////////////////////////////////////////////////////////////////////////

        // A机器上构建了World对象
        HelloProtobuf.World world = HelloProtobuf.World.newBuilder()
                .setName("China")
                .setAddress("处于地球东半球")
                .build();

        // A 机器构建的对象转换成字节数组
        // 字节数组通过网络传输（Netty 等方式） A 机器传输到 B 机器
        byte[] world2ByteArray = world.toByteArray();

        // B 机器上把字节数转换成对象（取决于在 B 机器上的使用语言），并把数据打印出来
        HelloProtobuf.World worlds = HelloProtobuf.World.parseFrom(world2ByteArray);
        System.out.println(worlds);
    }
}
