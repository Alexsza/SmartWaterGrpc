// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: waterRecycling.proto

package ds.waterRecycling;

/**
 * Protobuf type {@code RecyclingService.MonitorLevels}
 */
public  final class MonitorLevels extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:RecyclingService.MonitorLevels)
    MonitorLevelsOrBuilder {
private static final long serialVersionUID = 0L;
  // Use MonitorLevels.newBuilder() to construct.
  private MonitorLevels(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private MonitorLevels() {
    tankId_ = 0;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private MonitorLevels(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 8: {

            tankId_ = input.readInt32();
            break;
          }
          default: {
            if (!parseUnknownFieldProto3(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return ds.waterRecycling.WaterRecyclingImpl.internal_static_RecyclingService_MonitorLevels_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return ds.waterRecycling.WaterRecyclingImpl.internal_static_RecyclingService_MonitorLevels_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            ds.waterRecycling.MonitorLevels.class, ds.waterRecycling.MonitorLevels.Builder.class);
  }

  public static final int TANKID_FIELD_NUMBER = 1;
  private int tankId_;
  /**
   * <code>int32 tankId = 1;</code>
   */
  public int getTankId() {
    return tankId_;
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (tankId_ != 0) {
      output.writeInt32(1, tankId_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (tankId_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(1, tankId_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof ds.waterRecycling.MonitorLevels)) {
      return super.equals(obj);
    }
    ds.waterRecycling.MonitorLevels other = (ds.waterRecycling.MonitorLevels) obj;

    boolean result = true;
    result = result && (getTankId()
        == other.getTankId());
    result = result && unknownFields.equals(other.unknownFields);
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + TANKID_FIELD_NUMBER;
    hash = (53 * hash) + getTankId();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static ds.waterRecycling.MonitorLevels parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ds.waterRecycling.MonitorLevels parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ds.waterRecycling.MonitorLevels parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ds.waterRecycling.MonitorLevels parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ds.waterRecycling.MonitorLevels parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ds.waterRecycling.MonitorLevels parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ds.waterRecycling.MonitorLevels parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static ds.waterRecycling.MonitorLevels parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static ds.waterRecycling.MonitorLevels parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static ds.waterRecycling.MonitorLevels parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static ds.waterRecycling.MonitorLevels parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static ds.waterRecycling.MonitorLevels parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(ds.waterRecycling.MonitorLevels prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code RecyclingService.MonitorLevels}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:RecyclingService.MonitorLevels)
      ds.waterRecycling.MonitorLevelsOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return ds.waterRecycling.WaterRecyclingImpl.internal_static_RecyclingService_MonitorLevels_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return ds.waterRecycling.WaterRecyclingImpl.internal_static_RecyclingService_MonitorLevels_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              ds.waterRecycling.MonitorLevels.class, ds.waterRecycling.MonitorLevels.Builder.class);
    }

    // Construct using ds.waterRecycling.MonitorLevels.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      tankId_ = 0;

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return ds.waterRecycling.WaterRecyclingImpl.internal_static_RecyclingService_MonitorLevels_descriptor;
    }

    @java.lang.Override
    public ds.waterRecycling.MonitorLevels getDefaultInstanceForType() {
      return ds.waterRecycling.MonitorLevels.getDefaultInstance();
    }

    @java.lang.Override
    public ds.waterRecycling.MonitorLevels build() {
      ds.waterRecycling.MonitorLevels result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public ds.waterRecycling.MonitorLevels buildPartial() {
      ds.waterRecycling.MonitorLevels result = new ds.waterRecycling.MonitorLevels(this);
      result.tankId_ = tankId_;
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return (Builder) super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof ds.waterRecycling.MonitorLevels) {
        return mergeFrom((ds.waterRecycling.MonitorLevels)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(ds.waterRecycling.MonitorLevels other) {
      if (other == ds.waterRecycling.MonitorLevels.getDefaultInstance()) return this;
      if (other.getTankId() != 0) {
        setTankId(other.getTankId());
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      ds.waterRecycling.MonitorLevels parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (ds.waterRecycling.MonitorLevels) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private int tankId_ ;
    /**
     * <code>int32 tankId = 1;</code>
     */
    public int getTankId() {
      return tankId_;
    }
    /**
     * <code>int32 tankId = 1;</code>
     */
    public Builder setTankId(int value) {
      
      tankId_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 tankId = 1;</code>
     */
    public Builder clearTankId() {
      
      tankId_ = 0;
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFieldsProto3(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:RecyclingService.MonitorLevels)
  }

  // @@protoc_insertion_point(class_scope:RecyclingService.MonitorLevels)
  private static final ds.waterRecycling.MonitorLevels DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new ds.waterRecycling.MonitorLevels();
  }

  public static ds.waterRecycling.MonitorLevels getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<MonitorLevels>
      PARSER = new com.google.protobuf.AbstractParser<MonitorLevels>() {
    @java.lang.Override
    public MonitorLevels parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new MonitorLevels(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<MonitorLevels> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<MonitorLevels> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public ds.waterRecycling.MonitorLevels getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

