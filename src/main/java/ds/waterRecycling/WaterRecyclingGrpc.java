package ds.waterRecycling;

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
    comments = "Source: waterRecycling.proto")
public final class WaterRecyclingGrpc {

  private WaterRecyclingGrpc() {}

  public static final String SERVICE_NAME = "waterRecycling.WaterRecycling";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<ds.waterRecycling.TankRequest,
      ds.waterRecycling.TankResponse> getCheckTankLevelMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CheckTankLevel",
      requestType = ds.waterRecycling.TankRequest.class,
      responseType = ds.waterRecycling.TankResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ds.waterRecycling.TankRequest,
      ds.waterRecycling.TankResponse> getCheckTankLevelMethod() {
    io.grpc.MethodDescriptor<ds.waterRecycling.TankRequest, ds.waterRecycling.TankResponse> getCheckTankLevelMethod;
    if ((getCheckTankLevelMethod = WaterRecyclingGrpc.getCheckTankLevelMethod) == null) {
      synchronized (WaterRecyclingGrpc.class) {
        if ((getCheckTankLevelMethod = WaterRecyclingGrpc.getCheckTankLevelMethod) == null) {
          WaterRecyclingGrpc.getCheckTankLevelMethod = getCheckTankLevelMethod = 
              io.grpc.MethodDescriptor.<ds.waterRecycling.TankRequest, ds.waterRecycling.TankResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "waterRecycling.WaterRecycling", "CheckTankLevel"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.waterRecycling.TankRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.waterRecycling.TankResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new WaterRecyclingMethodDescriptorSupplier("CheckTankLevel"))
                  .build();
          }
        }
     }
     return getCheckTankLevelMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ds.waterRecycling.MonitorLevels,
      ds.waterRecycling.LevelsResponse> getMonitorTankLevelsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "MonitorTankLevels",
      requestType = ds.waterRecycling.MonitorLevels.class,
      responseType = ds.waterRecycling.LevelsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<ds.waterRecycling.MonitorLevels,
      ds.waterRecycling.LevelsResponse> getMonitorTankLevelsMethod() {
    io.grpc.MethodDescriptor<ds.waterRecycling.MonitorLevels, ds.waterRecycling.LevelsResponse> getMonitorTankLevelsMethod;
    if ((getMonitorTankLevelsMethod = WaterRecyclingGrpc.getMonitorTankLevelsMethod) == null) {
      synchronized (WaterRecyclingGrpc.class) {
        if ((getMonitorTankLevelsMethod = WaterRecyclingGrpc.getMonitorTankLevelsMethod) == null) {
          WaterRecyclingGrpc.getMonitorTankLevelsMethod = getMonitorTankLevelsMethod = 
              io.grpc.MethodDescriptor.<ds.waterRecycling.MonitorLevels, ds.waterRecycling.LevelsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "waterRecycling.WaterRecycling", "MonitorTankLevels"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.waterRecycling.MonitorLevels.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.waterRecycling.LevelsResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new WaterRecyclingMethodDescriptorSupplier("MonitorTankLevels"))
                  .build();
          }
        }
     }
     return getMonitorTankLevelsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ds.waterRecycling.RainwaterTank,
      ds.waterRecycling.RainwaterResponse> getSwitchToRainwaterTankMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SwitchToRainwaterTank",
      requestType = ds.waterRecycling.RainwaterTank.class,
      responseType = ds.waterRecycling.RainwaterResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<ds.waterRecycling.RainwaterTank,
      ds.waterRecycling.RainwaterResponse> getSwitchToRainwaterTankMethod() {
    io.grpc.MethodDescriptor<ds.waterRecycling.RainwaterTank, ds.waterRecycling.RainwaterResponse> getSwitchToRainwaterTankMethod;
    if ((getSwitchToRainwaterTankMethod = WaterRecyclingGrpc.getSwitchToRainwaterTankMethod) == null) {
      synchronized (WaterRecyclingGrpc.class) {
        if ((getSwitchToRainwaterTankMethod = WaterRecyclingGrpc.getSwitchToRainwaterTankMethod) == null) {
          WaterRecyclingGrpc.getSwitchToRainwaterTankMethod = getSwitchToRainwaterTankMethod = 
              io.grpc.MethodDescriptor.<ds.waterRecycling.RainwaterTank, ds.waterRecycling.RainwaterResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "waterRecycling.WaterRecycling", "SwitchToRainwaterTank"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.waterRecycling.RainwaterTank.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.waterRecycling.RainwaterResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new WaterRecyclingMethodDescriptorSupplier("SwitchToRainwaterTank"))
                  .build();
          }
        }
     }
     return getSwitchToRainwaterTankMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static WaterRecyclingStub newStub(io.grpc.Channel channel) {
    return new WaterRecyclingStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static WaterRecyclingBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new WaterRecyclingBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static WaterRecyclingFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new WaterRecyclingFutureStub(channel);
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static abstract class WaterRecyclingImplBase implements io.grpc.BindableService {

    /**
     */
    public void checkTankLevel(ds.waterRecycling.TankRequest request,
        io.grpc.stub.StreamObserver<ds.waterRecycling.TankResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getCheckTankLevelMethod(), responseObserver);
    }

    /**
     */
    public void monitorTankLevels(ds.waterRecycling.MonitorLevels request,
        io.grpc.stub.StreamObserver<ds.waterRecycling.LevelsResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getMonitorTankLevelsMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<ds.waterRecycling.RainwaterTank> switchToRainwaterTank(
        io.grpc.stub.StreamObserver<ds.waterRecycling.RainwaterResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getSwitchToRainwaterTankMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCheckTankLevelMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                ds.waterRecycling.TankRequest,
                ds.waterRecycling.TankResponse>(
                  this, METHODID_CHECK_TANK_LEVEL)))
          .addMethod(
            getMonitorTankLevelsMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                ds.waterRecycling.MonitorLevels,
                ds.waterRecycling.LevelsResponse>(
                  this, METHODID_MONITOR_TANK_LEVELS)))
          .addMethod(
            getSwitchToRainwaterTankMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                ds.waterRecycling.RainwaterTank,
                ds.waterRecycling.RainwaterResponse>(
                  this, METHODID_SWITCH_TO_RAINWATER_TANK)))
          .build();
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class WaterRecyclingStub extends io.grpc.stub.AbstractStub<WaterRecyclingStub> {
    private WaterRecyclingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private WaterRecyclingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WaterRecyclingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new WaterRecyclingStub(channel, callOptions);
    }

    /**
     */
    public void checkTankLevel(ds.waterRecycling.TankRequest request,
        io.grpc.stub.StreamObserver<ds.waterRecycling.TankResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCheckTankLevelMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void monitorTankLevels(ds.waterRecycling.MonitorLevels request,
        io.grpc.stub.StreamObserver<ds.waterRecycling.LevelsResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getMonitorTankLevelsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<ds.waterRecycling.RainwaterTank> switchToRainwaterTank(
        io.grpc.stub.StreamObserver<ds.waterRecycling.RainwaterResponse> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getSwitchToRainwaterTankMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class WaterRecyclingBlockingStub extends io.grpc.stub.AbstractStub<WaterRecyclingBlockingStub> {
    private WaterRecyclingBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private WaterRecyclingBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WaterRecyclingBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new WaterRecyclingBlockingStub(channel, callOptions);
    }

    /**
     */
    public ds.waterRecycling.TankResponse checkTankLevel(ds.waterRecycling.TankRequest request) {
      return blockingUnaryCall(
          getChannel(), getCheckTankLevelMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<ds.waterRecycling.LevelsResponse> monitorTankLevels(
        ds.waterRecycling.MonitorLevels request) {
      return blockingServerStreamingCall(
          getChannel(), getMonitorTankLevelsMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class WaterRecyclingFutureStub extends io.grpc.stub.AbstractStub<WaterRecyclingFutureStub> {
    private WaterRecyclingFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private WaterRecyclingFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WaterRecyclingFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new WaterRecyclingFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ds.waterRecycling.TankResponse> checkTankLevel(
        ds.waterRecycling.TankRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCheckTankLevelMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CHECK_TANK_LEVEL = 0;
  private static final int METHODID_MONITOR_TANK_LEVELS = 1;
  private static final int METHODID_SWITCH_TO_RAINWATER_TANK = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final WaterRecyclingImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(WaterRecyclingImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CHECK_TANK_LEVEL:
          serviceImpl.checkTankLevel((ds.waterRecycling.TankRequest) request,
              (io.grpc.stub.StreamObserver<ds.waterRecycling.TankResponse>) responseObserver);
          break;
        case METHODID_MONITOR_TANK_LEVELS:
          serviceImpl.monitorTankLevels((ds.waterRecycling.MonitorLevels) request,
              (io.grpc.stub.StreamObserver<ds.waterRecycling.LevelsResponse>) responseObserver);
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
        case METHODID_SWITCH_TO_RAINWATER_TANK:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.switchToRainwaterTank(
              (io.grpc.stub.StreamObserver<ds.waterRecycling.RainwaterResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class WaterRecyclingBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    WaterRecyclingBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return ds.waterRecycling.WaterRecyclingImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("WaterRecycling");
    }
  }

  private static final class WaterRecyclingFileDescriptorSupplier
      extends WaterRecyclingBaseDescriptorSupplier {
    WaterRecyclingFileDescriptorSupplier() {}
  }

  private static final class WaterRecyclingMethodDescriptorSupplier
      extends WaterRecyclingBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    WaterRecyclingMethodDescriptorSupplier(String methodName) {
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
      synchronized (WaterRecyclingGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new WaterRecyclingFileDescriptorSupplier())
              .addMethod(getCheckTankLevelMethod())
              .addMethod(getMonitorTankLevelsMethod())
              .addMethod(getSwitchToRainwaterTankMethod())
              .build();
        }
      }
    }
    return result;
  }
}
