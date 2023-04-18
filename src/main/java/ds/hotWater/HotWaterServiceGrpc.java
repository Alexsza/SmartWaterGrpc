package ds.hotWater;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 * <pre>
 * Interface exported by the server.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: hotWaters.proto")
public final class HotWaterServiceGrpc {

  private HotWaterServiceGrpc() {}

  public static final String SERVICE_NAME = "hotWater.HotWaterService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<ds.hotWater.desiredTankTemp,
      ds.hotWater.TankTempConfirm> getSetTankTemperatureMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SetTankTemperature",
      requestType = ds.hotWater.desiredTankTemp.class,
      responseType = ds.hotWater.TankTempConfirm.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ds.hotWater.desiredTankTemp,
      ds.hotWater.TankTempConfirm> getSetTankTemperatureMethod() {
    io.grpc.MethodDescriptor<ds.hotWater.desiredTankTemp, ds.hotWater.TankTempConfirm> getSetTankTemperatureMethod;
    if ((getSetTankTemperatureMethod = HotWaterServiceGrpc.getSetTankTemperatureMethod) == null) {
      synchronized (HotWaterServiceGrpc.class) {
        if ((getSetTankTemperatureMethod = HotWaterServiceGrpc.getSetTankTemperatureMethod) == null) {
          HotWaterServiceGrpc.getSetTankTemperatureMethod = getSetTankTemperatureMethod = 
              io.grpc.MethodDescriptor.<ds.hotWater.desiredTankTemp, ds.hotWater.TankTempConfirm>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "hotWater.HotWaterService", "SetTankTemperature"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.hotWater.desiredTankTemp.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.hotWater.TankTempConfirm.getDefaultInstance()))
                  .setSchemaDescriptor(new HotWaterServiceMethodDescriptorSupplier("SetTankTemperature"))
                  .build();
          }
        }
     }
     return getSetTankTemperatureMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ds.hotWater.UsageDataRequest,
      ds.hotWater.UsageDataResponse> getSendUsageDataMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SendUsageData",
      requestType = ds.hotWater.UsageDataRequest.class,
      responseType = ds.hotWater.UsageDataResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<ds.hotWater.UsageDataRequest,
      ds.hotWater.UsageDataResponse> getSendUsageDataMethod() {
    io.grpc.MethodDescriptor<ds.hotWater.UsageDataRequest, ds.hotWater.UsageDataResponse> getSendUsageDataMethod;
    if ((getSendUsageDataMethod = HotWaterServiceGrpc.getSendUsageDataMethod) == null) {
      synchronized (HotWaterServiceGrpc.class) {
        if ((getSendUsageDataMethod = HotWaterServiceGrpc.getSendUsageDataMethod) == null) {
          HotWaterServiceGrpc.getSendUsageDataMethod = getSendUsageDataMethod = 
              io.grpc.MethodDescriptor.<ds.hotWater.UsageDataRequest, ds.hotWater.UsageDataResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "hotWater.HotWaterService", "SendUsageData"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.hotWater.UsageDataRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.hotWater.UsageDataResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new HotWaterServiceMethodDescriptorSupplier("SendUsageData"))
                  .build();
          }
        }
     }
     return getSendUsageDataMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static HotWaterServiceStub newStub(io.grpc.Channel channel) {
    return new HotWaterServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static HotWaterServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new HotWaterServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static HotWaterServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new HotWaterServiceFutureStub(channel);
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static abstract class HotWaterServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void setTankTemperature(ds.hotWater.desiredTankTemp request,
        io.grpc.stub.StreamObserver<ds.hotWater.TankTempConfirm> responseObserver) {
      asyncUnimplementedUnaryCall(getSetTankTemperatureMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<ds.hotWater.UsageDataRequest> sendUsageData(
        io.grpc.stub.StreamObserver<ds.hotWater.UsageDataResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getSendUsageDataMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSetTankTemperatureMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                ds.hotWater.desiredTankTemp,
                ds.hotWater.TankTempConfirm>(
                  this, METHODID_SET_TANK_TEMPERATURE)))
          .addMethod(
            getSendUsageDataMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                ds.hotWater.UsageDataRequest,
                ds.hotWater.UsageDataResponse>(
                  this, METHODID_SEND_USAGE_DATA)))
          .build();
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class HotWaterServiceStub extends io.grpc.stub.AbstractStub<HotWaterServiceStub> {
    private HotWaterServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private HotWaterServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HotWaterServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new HotWaterServiceStub(channel, callOptions);
    }

    /**
     */
    public void setTankTemperature(ds.hotWater.desiredTankTemp request,
        io.grpc.stub.StreamObserver<ds.hotWater.TankTempConfirm> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSetTankTemperatureMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<ds.hotWater.UsageDataRequest> sendUsageData(
        io.grpc.stub.StreamObserver<ds.hotWater.UsageDataResponse> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getSendUsageDataMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class HotWaterServiceBlockingStub extends io.grpc.stub.AbstractStub<HotWaterServiceBlockingStub> {
    private HotWaterServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private HotWaterServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HotWaterServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new HotWaterServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public ds.hotWater.TankTempConfirm setTankTemperature(ds.hotWater.desiredTankTemp request) {
      return blockingUnaryCall(
          getChannel(), getSetTankTemperatureMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class HotWaterServiceFutureStub extends io.grpc.stub.AbstractStub<HotWaterServiceFutureStub> {
    private HotWaterServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private HotWaterServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HotWaterServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new HotWaterServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ds.hotWater.TankTempConfirm> setTankTemperature(
        ds.hotWater.desiredTankTemp request) {
      return futureUnaryCall(
          getChannel().newCall(getSetTankTemperatureMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SET_TANK_TEMPERATURE = 0;
  private static final int METHODID_SEND_USAGE_DATA = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final HotWaterServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(HotWaterServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SET_TANK_TEMPERATURE:
          serviceImpl.setTankTemperature((ds.hotWater.desiredTankTemp) request,
              (io.grpc.stub.StreamObserver<ds.hotWater.TankTempConfirm>) responseObserver);
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
        case METHODID_SEND_USAGE_DATA:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.sendUsageData(
              (io.grpc.stub.StreamObserver<ds.hotWater.UsageDataResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class HotWaterServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    HotWaterServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return ds.hotWater.hotWaterImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("HotWaterService");
    }
  }

  private static final class HotWaterServiceFileDescriptorSupplier
      extends HotWaterServiceBaseDescriptorSupplier {
    HotWaterServiceFileDescriptorSupplier() {}
  }

  private static final class HotWaterServiceMethodDescriptorSupplier
      extends HotWaterServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    HotWaterServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (HotWaterServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new HotWaterServiceFileDescriptorSupplier())
              .addMethod(getSetTankTemperatureMethod())
              .addMethod(getSendUsageDataMethod())
              .build();
        }
      }
    }
    return result;
  }
}
