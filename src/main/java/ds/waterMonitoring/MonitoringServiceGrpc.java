package ds.waterMonitoring;

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
    comments = "Source: waterMonitoring.proto")
public final class MonitoringServiceGrpc {

  private MonitoringServiceGrpc() {}

  public static final String SERVICE_NAME = "waterMonitoring.MonitoringService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<ds.waterMonitoring.AreaRequest,
      ds.waterMonitoring.AreaResponse> getMonitorAreaMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "MonitorArea",
      requestType = ds.waterMonitoring.AreaRequest.class,
      responseType = ds.waterMonitoring.AreaResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<ds.waterMonitoring.AreaRequest,
      ds.waterMonitoring.AreaResponse> getMonitorAreaMethod() {
    io.grpc.MethodDescriptor<ds.waterMonitoring.AreaRequest, ds.waterMonitoring.AreaResponse> getMonitorAreaMethod;
    if ((getMonitorAreaMethod = MonitoringServiceGrpc.getMonitorAreaMethod) == null) {
      synchronized (MonitoringServiceGrpc.class) {
        if ((getMonitorAreaMethod = MonitoringServiceGrpc.getMonitorAreaMethod) == null) {
          MonitoringServiceGrpc.getMonitorAreaMethod = getMonitorAreaMethod = 
              io.grpc.MethodDescriptor.<ds.waterMonitoring.AreaRequest, ds.waterMonitoring.AreaResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "waterMonitoring.MonitoringService", "MonitorArea"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.waterMonitoring.AreaRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.waterMonitoring.AreaResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new MonitoringServiceMethodDescriptorSupplier("MonitorArea"))
                  .build();
          }
        }
     }
     return getMonitorAreaMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ds.waterMonitoring.SensorDataRequest,
      ds.waterMonitoring.SensorDataResponse> getSendSensorDataMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SendSensorData",
      requestType = ds.waterMonitoring.SensorDataRequest.class,
      responseType = ds.waterMonitoring.SensorDataResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<ds.waterMonitoring.SensorDataRequest,
      ds.waterMonitoring.SensorDataResponse> getSendSensorDataMethod() {
    io.grpc.MethodDescriptor<ds.waterMonitoring.SensorDataRequest, ds.waterMonitoring.SensorDataResponse> getSendSensorDataMethod;
    if ((getSendSensorDataMethod = MonitoringServiceGrpc.getSendSensorDataMethod) == null) {
      synchronized (MonitoringServiceGrpc.class) {
        if ((getSendSensorDataMethod = MonitoringServiceGrpc.getSendSensorDataMethod) == null) {
          MonitoringServiceGrpc.getSendSensorDataMethod = getSendSensorDataMethod = 
              io.grpc.MethodDescriptor.<ds.waterMonitoring.SensorDataRequest, ds.waterMonitoring.SensorDataResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "waterMonitoring.MonitoringService", "SendSensorData"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.waterMonitoring.SensorDataRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.waterMonitoring.SensorDataResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new MonitoringServiceMethodDescriptorSupplier("SendSensorData"))
                  .build();
          }
        }
     }
     return getSendSensorDataMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static MonitoringServiceStub newStub(io.grpc.Channel channel) {
    return new MonitoringServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static MonitoringServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new MonitoringServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static MonitoringServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new MonitoringServiceFutureStub(channel);
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static abstract class MonitoringServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void monitorArea(ds.waterMonitoring.AreaRequest request,
        io.grpc.stub.StreamObserver<ds.waterMonitoring.AreaResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getMonitorAreaMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<ds.waterMonitoring.SensorDataRequest> sendSensorData(
        io.grpc.stub.StreamObserver<ds.waterMonitoring.SensorDataResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getSendSensorDataMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getMonitorAreaMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                ds.waterMonitoring.AreaRequest,
                ds.waterMonitoring.AreaResponse>(
                  this, METHODID_MONITOR_AREA)))
          .addMethod(
            getSendSensorDataMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                ds.waterMonitoring.SensorDataRequest,
                ds.waterMonitoring.SensorDataResponse>(
                  this, METHODID_SEND_SENSOR_DATA)))
          .build();
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class MonitoringServiceStub extends io.grpc.stub.AbstractStub<MonitoringServiceStub> {
    private MonitoringServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private MonitoringServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MonitoringServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new MonitoringServiceStub(channel, callOptions);
    }

    /**
     */
    public void monitorArea(ds.waterMonitoring.AreaRequest request,
        io.grpc.stub.StreamObserver<ds.waterMonitoring.AreaResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getMonitorAreaMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<ds.waterMonitoring.SensorDataRequest> sendSensorData(
        io.grpc.stub.StreamObserver<ds.waterMonitoring.SensorDataResponse> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getSendSensorDataMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class MonitoringServiceBlockingStub extends io.grpc.stub.AbstractStub<MonitoringServiceBlockingStub> {
    private MonitoringServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private MonitoringServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MonitoringServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new MonitoringServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public java.util.Iterator<ds.waterMonitoring.AreaResponse> monitorArea(
        ds.waterMonitoring.AreaRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getMonitorAreaMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class MonitoringServiceFutureStub extends io.grpc.stub.AbstractStub<MonitoringServiceFutureStub> {
    private MonitoringServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private MonitoringServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MonitoringServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new MonitoringServiceFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_MONITOR_AREA = 0;
  private static final int METHODID_SEND_SENSOR_DATA = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final MonitoringServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(MonitoringServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_MONITOR_AREA:
          serviceImpl.monitorArea((ds.waterMonitoring.AreaRequest) request,
              (io.grpc.stub.StreamObserver<ds.waterMonitoring.AreaResponse>) responseObserver);
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
        case METHODID_SEND_SENSOR_DATA:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.sendSensorData(
              (io.grpc.stub.StreamObserver<ds.waterMonitoring.SensorDataResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class MonitoringServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    MonitoringServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return ds.waterMonitoring.WaterMonitoringImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("MonitoringService");
    }
  }

  private static final class MonitoringServiceFileDescriptorSupplier
      extends MonitoringServiceBaseDescriptorSupplier {
    MonitoringServiceFileDescriptorSupplier() {}
  }

  private static final class MonitoringServiceMethodDescriptorSupplier
      extends MonitoringServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    MonitoringServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (MonitoringServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new MonitoringServiceFileDescriptorSupplier())
              .addMethod(getMonitorAreaMethod())
              .addMethod(getSendSensorDataMethod())
              .build();
        }
      }
    }
    return result;
  }
}
