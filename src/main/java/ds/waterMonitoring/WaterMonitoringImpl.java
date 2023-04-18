// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: waterMonitoring.proto

package ds.waterMonitoring;

public final class WaterMonitoringImpl {
  private WaterMonitoringImpl() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_waterMonitoring_AreaRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_waterMonitoring_AreaRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_waterMonitoring_AreaResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_waterMonitoring_AreaResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_waterMonitoring_SensorDataRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_waterMonitoring_SensorDataRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_waterMonitoring_SensorDataResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_waterMonitoring_SensorDataResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\025waterMonitoring.proto\022\017waterMonitoring" +
      "\"\037\n\013AreaRequest\022\020\n\010areaName\030\001 \001(\t\"2\n\014Are" +
      "aResponse\022\022\n\nwaterUsage\030\001 \001(\005\022\016\n\006issues\030" +
      "\002 \001(\t\"L\n\021SensorDataRequest\022\020\n\010areaName\030\001" +
      " \001(\t\022\022\n\nwaterUsage\030\002 \001(\005\022\021\n\twaterLeak\030\003 " +
      "\001(\t\";\n\022SensorDataResponse\022\r\n\005alert\030\001 \001(\t" +
      "\022\026\n\016recommendation\030\002 \001(\t2\304\001\n\021MonitoringS" +
      "ervice\022N\n\013MonitorArea\022\034.waterMonitoring." +
      "AreaRequest\032\035.waterMonitoring.AreaRespon" +
      "se\"\0000\001\022_\n\016SendSensorData\022\".waterMonitori" +
      "ng.SensorDataRequest\032#.waterMonitoring.S" +
      "ensorDataResponse\"\000(\0010\001B+\n\022ds.waterMonit" +
      "oringB\023WaterMonitoringImplP\001b\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_waterMonitoring_AreaRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_waterMonitoring_AreaRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_waterMonitoring_AreaRequest_descriptor,
        new java.lang.String[] { "AreaName", });
    internal_static_waterMonitoring_AreaResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_waterMonitoring_AreaResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_waterMonitoring_AreaResponse_descriptor,
        new java.lang.String[] { "WaterUsage", "Issues", });
    internal_static_waterMonitoring_SensorDataRequest_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_waterMonitoring_SensorDataRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_waterMonitoring_SensorDataRequest_descriptor,
        new java.lang.String[] { "AreaName", "WaterUsage", "WaterLeak", });
    internal_static_waterMonitoring_SensorDataResponse_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_waterMonitoring_SensorDataResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_waterMonitoring_SensorDataResponse_descriptor,
        new java.lang.String[] { "Alert", "Recommendation", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
