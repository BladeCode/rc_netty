/*
 * Copyright (C) 2020 The Jerry xu Open Source Project
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

package org.incoder.grpc;

import io.grpc.stub.StreamObserver;
import org.incoder.grpc.gen.GrpcHelloServiceGrpc;
import org.incoder.grpc.gen.GrpcRequest;
import org.incoder.grpc.gen.GrpcResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author : Jerry xu
 * @since : 2020/4/20  23:03
 */
public class GrpcHelloImpl extends GrpcHelloServiceGrpc.GrpcHelloServiceImplBase {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void sayHelloForGrpcType(GrpcRequest request, StreamObserver<GrpcResponse> responseObserver) {
        logger.info("接收到客户端信息: " + request.getType());

        // 组装响应数据返回给客户端
        responseObserver.onNext(GrpcResponse.newBuilder()
                .setSayResult("java 服务端消息")
                .build());
        // 处理完成，通知客户端，onCompleted()方法只调用一次
        // responseObserver中 onNext()和 onError()是互斥的，这一点和 RxJava 很像
        responseObserver.onCompleted();
    }
}
