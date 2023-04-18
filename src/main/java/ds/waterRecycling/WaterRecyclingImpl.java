// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: waterRecycling.proto

package ds.waterRecycling;

public final class WaterRecyclingImpl {
  private WaterRecyclingImpl() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_RecyclingService_TankRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_RecyclingService_TankRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_RecyclingService_TankResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_RecyclingService_TankResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_RecyclingService_MonitorLevels_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_RecyclingService_MonitorLevels_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_RecyclingService_LevelsResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_RecyclingService_LevelsResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_RecyclingService_RainwaterTank_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_RecyclingService_RainwaterTank_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_RecyclingService_RainwaterResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_RecyclingService_RainwaterResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\024waterRecycling.proto\022\020RecyclingService" +
      "\"\035\n\013TankRequest\022\016\n\006tankId\030\001 \001(\005\"!\n\014TankR" +
      "esponse\022\021\n\ttankLevel\030\001 \001(\005\"\037\n\rMonitorLev" +
      "els\022\016\n\006tankId\030\001 \001(\005\"6\n\016LevelsResponse\022\016\n" +
      "\006tankId\030\001 \001(\005\022\024\n\014currentLevel\030\002 \001(\005\"\037\n\rR" +
      "ainwaterTank\022\016\n\006tankId\030\001 \001(\005\"@\n\021Rainwate" +
      "rResponse\022\022\n\ntankLevels\030\001 \001(\005\022\027\n\017current" +
      "TankUsed\030\002 \001(\0052\242\002\n\016WaterRecycling\022Q\n\016Che" +
      "ckTankLevel\022\035.RecyclingService.TankReque" +
      "st\032\036.RecyclingService.TankResponse\"\000\022Z\n\021" +
      "MonitorTankLevels\022\037.RecyclingService.Mon" +
      "itorLevels\032 .RecyclingService.LevelsResp" +
      "onse\"\0000\001\022a\n\025SwitchToRainwaterTank\022\037.Recy" +
      "clingService.RainwaterTank\032#.RecyclingSe" +
      "rvice.RainwaterResponse\"\000(\001B)\n\021ds.waterR" +
      "ecyclingB\022WaterRecyclingImplP\001b\006proto3"
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
    internal_static_RecyclingService_TankRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_RecyclingService_TankRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_RecyclingService_TankRequest_descriptor,
        new java.lang.String[] { "TankId", });
    internal_static_RecyclingService_TankResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_RecyclingService_TankResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_RecyclingService_TankResponse_descriptor,
        new java.lang.String[] { "TankLevel", });
    internal_static_RecyclingService_MonitorLevels_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_RecyclingService_MonitorLevels_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_RecyclingService_MonitorLevels_descriptor,
        new java.lang.String[] { "TankId", });
    internal_static_RecyclingService_LevelsResponse_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_RecyclingService_LevelsResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_RecyclingService_LevelsResponse_descriptor,
        new java.lang.String[] { "TankId", "CurrentLevel", });
    internal_static_RecyclingService_RainwaterTank_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_RecyclingService_RainwaterTank_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_RecyclingService_RainwaterTank_descriptor,
        new java.lang.String[] { "TankId", });
    internal_static_RecyclingService_RainwaterResponse_descriptor =
      getDescriptor().getMessageTypes().get(5);
    internal_static_RecyclingService_RainwaterResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_RecyclingService_RainwaterResponse_descriptor,
        new java.lang.String[] { "TankLevels", "CurrentTankUsed", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}