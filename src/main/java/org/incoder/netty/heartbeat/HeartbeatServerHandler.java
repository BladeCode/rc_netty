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

package org.incoder.netty.heartbeat;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleStateEvent;

/**
 * @author : Jerry xu
 * @date : 2019/11/19  14:21
 */
public class HeartbeatServerHandler extends ChannelInboundHandlerAdapter {

    /**
     * 触发某一个事件后被调用
     *
     * @param ctx 通道处理上下文
     * @param evt 事件
     * @throws Exception 异常
     */
    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if (evt instanceof IdleStateEvent) {
            IdleStateEvent event = (IdleStateEvent) evt;

            String eventType = null;
            switch (event.state()) {
                case READER_IDLE:
                    eventType = "读空闲（超过指定时间，客户端没有向服务器发送任何数据）";
                    break;
                case WRITER_IDLE:
                    eventType = "写空闲（超过指定时间，服务器没有写任何信息）";
                    break;
                case ALL_IDLE:
                    eventType = "读写空闲（超过指定时间，没有写或者没有读二者之一，即触发读写空闲）";
                    break;
                default:
                    break;
            }

            System.out.println(ctx.channel().remoteAddress() + "超时事件：" + eventType);
            ctx.channel().closeFuture();
        }
    }
}
