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

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.incoder.grpc.gen.GrpcHelloServiceGrpc;
import org.incoder.grpc.gen.GrpcRequest;
import org.incoder.grpc.gen.GrpcResponse;

/**
 * gRPC 客户端相关示例
 * 示例参考：https://github.com/grpc/grpc-java/blob/master/examples/src/main/java/io/grpc/examples/routeguide/RouteGuideClient.java
 *
 * @author : Jerry xu
 * @since : 2020/4/20  23:00
 */
public class GrpcClient {

    public static void main(String[] args) {
        ManagedChannel managedChannel = ManagedChannelBuilder.forAddress("localhost", 8989)
                .usePlaintext().build();

        GrpcHelloServiceGrpc.GrpcHelloServiceBlockingStub blockingStub = GrpcHelloServiceGrpc.newBlockingStub(managedChannel);

        GrpcResponse grpcResponse = blockingStub
                .sayHelloForGrpcType(GrpcRequest.newBuilder().setType("java 客户端消息").build());
        System.out.println(grpcResponse.getSayResult());
    }
}
