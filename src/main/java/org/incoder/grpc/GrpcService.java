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

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

/**
 * gRPC 服务端相关示例
 * 示例参考：https://github.com/grpc/grpc-java/blob/master/examples/src/main/java/io/grpc/examples/routeguide/RouteGuideServer.java
 *
 * @author : Jerry xu
 * @since : 2020/4/20  23:01
 */
public class GrpcService {

    private static final Logger logger = Logger.getLogger(GrpcService.class.getName());

    private Server server;

    public static void main(String[] args) throws IOException, InterruptedException {
        GrpcService server = new GrpcService();
        server.start();
        server.blockUntilShutdown();
    }

    private void start() throws IOException {
        int port = 8989;
        server = ServerBuilder.forPort(port).addService(new GrpcHelloImpl()).build().start();
        logger.info("Server started, listening on " + port);

        /*Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            // Use stderr here since the logger may have been reset by its JVM shutdown hook.
            System.err.println("*** shutting down gRPC server since JVM is shutting down");
            try {
                GrpcService.this.stop();
            } catch (InterruptedException e) {
                e.printStackTrace(System.err);
            }
            System.err.println("*** server shut down");
        }));*/

    }

    /**
     * Stop serving requests and shutdown resources.
     */
    public void stop() throws InterruptedException {
        if (server != null) {
            server.shutdown().awaitTermination(30, TimeUnit.SECONDS);
        }
    }

    /**
     * 服务启动之后就会立刻停止,awaitTermination会保持服务一直运行
     * Await termination on the main thread since the grpc library uses daemon threads.
     *
     * @throws InterruptedException exception
     */
    private void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }
}
