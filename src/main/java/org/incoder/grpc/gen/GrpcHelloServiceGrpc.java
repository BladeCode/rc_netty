package org.incoder.grpc.gen;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.28.1)",
    comments = "Source: GrpcHello.proto")
public final class GrpcHelloServiceGrpc {

  private GrpcHelloServiceGrpc() {}

  public static final String SERVICE_NAME = "org.incoder.grpc.gen.GrpcHelloService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<org.incoder.grpc.gen.GrpcRequest,
      org.incoder.grpc.gen.GrpcResponse> getSayHelloForGrpcTypeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SayHelloForGrpcType",
      requestType = org.incoder.grpc.gen.GrpcRequest.class,
      responseType = org.incoder.grpc.gen.GrpcResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.incoder.grpc.gen.GrpcRequest,
      org.incoder.grpc.gen.GrpcResponse> getSayHelloForGrpcTypeMethod() {
    io.grpc.MethodDescriptor<org.incoder.grpc.gen.GrpcRequest, org.incoder.grpc.gen.GrpcResponse> getSayHelloForGrpcTypeMethod;
    if ((getSayHelloForGrpcTypeMethod = GrpcHelloServiceGrpc.getSayHelloForGrpcTypeMethod) == null) {
      synchronized (GrpcHelloServiceGrpc.class) {
        if ((getSayHelloForGrpcTypeMethod = GrpcHelloServiceGrpc.getSayHelloForGrpcTypeMethod) == null) {
          GrpcHelloServiceGrpc.getSayHelloForGrpcTypeMethod = getSayHelloForGrpcTypeMethod =
              io.grpc.MethodDescriptor.<org.incoder.grpc.gen.GrpcRequest, org.incoder.grpc.gen.GrpcResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SayHelloForGrpcType"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.incoder.grpc.gen.GrpcRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.incoder.grpc.gen.GrpcResponse.getDefaultInstance()))
              .setSchemaDescriptor(new GrpcHelloServiceMethodDescriptorSupplier("SayHelloForGrpcType"))
              .build();
        }
      }
    }
    return getSayHelloForGrpcTypeMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static GrpcHelloServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GrpcHelloServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<GrpcHelloServiceStub>() {
        @java.lang.Override
        public GrpcHelloServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new GrpcHelloServiceStub(channel, callOptions);
        }
      };
    return GrpcHelloServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static GrpcHelloServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GrpcHelloServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<GrpcHelloServiceBlockingStub>() {
        @java.lang.Override
        public GrpcHelloServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new GrpcHelloServiceBlockingStub(channel, callOptions);
        }
      };
    return GrpcHelloServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static GrpcHelloServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GrpcHelloServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<GrpcHelloServiceFutureStub>() {
        @java.lang.Override
        public GrpcHelloServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new GrpcHelloServiceFutureStub(channel, callOptions);
        }
      };
    return GrpcHelloServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class GrpcHelloServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * 可参考官方提供的四种模式：https://grpc.io/docs/tutorials/basic/java/#defining-the-service
     *  rpc SayHelloForGrpcType(stream GrpcRequest) returns (stream GrpcResponse){}
     * </pre>
     */
    public void sayHelloForGrpcType(org.incoder.grpc.gen.GrpcRequest request,
        io.grpc.stub.StreamObserver<org.incoder.grpc.gen.GrpcResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSayHelloForGrpcTypeMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSayHelloForGrpcTypeMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.incoder.grpc.gen.GrpcRequest,
                org.incoder.grpc.gen.GrpcResponse>(
                  this, METHODID_SAY_HELLO_FOR_GRPC_TYPE)))
          .build();
    }
  }

  /**
   */
  public static final class GrpcHelloServiceStub extends io.grpc.stub.AbstractAsyncStub<GrpcHelloServiceStub> {
    private GrpcHelloServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GrpcHelloServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GrpcHelloServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * 可参考官方提供的四种模式：https://grpc.io/docs/tutorials/basic/java/#defining-the-service
     *  rpc SayHelloForGrpcType(stream GrpcRequest) returns (stream GrpcResponse){}
     * </pre>
     */
    public void sayHelloForGrpcType(org.incoder.grpc.gen.GrpcRequest request,
        io.grpc.stub.StreamObserver<org.incoder.grpc.gen.GrpcResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSayHelloForGrpcTypeMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class GrpcHelloServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<GrpcHelloServiceBlockingStub> {
    private GrpcHelloServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GrpcHelloServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GrpcHelloServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * 可参考官方提供的四种模式：https://grpc.io/docs/tutorials/basic/java/#defining-the-service
     *  rpc SayHelloForGrpcType(stream GrpcRequest) returns (stream GrpcResponse){}
     * </pre>
     */
    public org.incoder.grpc.gen.GrpcResponse sayHelloForGrpcType(org.incoder.grpc.gen.GrpcRequest request) {
      return blockingUnaryCall(
          getChannel(), getSayHelloForGrpcTypeMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class GrpcHelloServiceFutureStub extends io.grpc.stub.AbstractFutureStub<GrpcHelloServiceFutureStub> {
    private GrpcHelloServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GrpcHelloServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GrpcHelloServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * 可参考官方提供的四种模式：https://grpc.io/docs/tutorials/basic/java/#defining-the-service
     *  rpc SayHelloForGrpcType(stream GrpcRequest) returns (stream GrpcResponse){}
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<org.incoder.grpc.gen.GrpcResponse> sayHelloForGrpcType(
        org.incoder.grpc.gen.GrpcRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSayHelloForGrpcTypeMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SAY_HELLO_FOR_GRPC_TYPE = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final GrpcHelloServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(GrpcHelloServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SAY_HELLO_FOR_GRPC_TYPE:
          serviceImpl.sayHelloForGrpcType((org.incoder.grpc.gen.GrpcRequest) request,
              (io.grpc.stub.StreamObserver<org.incoder.grpc.gen.GrpcResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class GrpcHelloServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    GrpcHelloServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return org.incoder.grpc.gen.GrpcHello.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("GrpcHelloService");
    }
  }

  private static final class GrpcHelloServiceFileDescriptorSupplier
      extends GrpcHelloServiceBaseDescriptorSupplier {
    GrpcHelloServiceFileDescriptorSupplier() {}
  }

  private static final class GrpcHelloServiceMethodDescriptorSupplier
      extends GrpcHelloServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    GrpcHelloServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (GrpcHelloServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new GrpcHelloServiceFileDescriptorSupplier())
              .addMethod(getSayHelloForGrpcTypeMethod())
              .build();
        }
      }
    }
    return result;
  }
}
