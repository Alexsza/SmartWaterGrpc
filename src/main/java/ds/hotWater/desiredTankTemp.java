// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: hotWaters.proto

package ds.hotWater;

/**
 * Protobuf type {@code hotWater.desiredTankTemp}
 */
public  final class desiredTankTemp extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:hotWater.desiredTankTemp)
    desiredTankTempOrBuilder {
private static final long serialVersionUID = 0L;
  // Use desiredTankTemp.newBuilder() to construct.
  private desiredTankTemp(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private desiredTankTemp() {
    desiredTemp_ = 0;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private desiredTankTemp(
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

            desiredTemp_ = input.readInt32();
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
    return ds.hotWater.hotWaterImpl.internal_static_hotWater_desiredTankTemp_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return ds.hotWater.hotWaterImpl.internal_static_hotWater_desiredTankTemp_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            ds.hotWater.desiredTankTemp.class, ds.hotWater.desiredTankTemp.Builder.class);
  }

  public static final int DESIREDTEMP_FIELD_NUMBER = 1;
  private int desiredTemp_;
  /**
   * <code>int32 desiredTemp = 1;</code>
   */
  public int getDesiredTemp() {
    return desiredTemp_;
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
    if (desiredTemp_ != 0) {
      output.writeInt32(1, desiredTemp_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (desiredTemp_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(1, desiredTemp_);
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
    if (!(obj instanceof ds.hotWater.desiredTankTemp)) {
      return super.equals(obj);
    }
    ds.hotWater.desiredTankTemp other = (ds.hotWater.desiredTankTemp) obj;

    boolean result = true;
    result = result && (getDesiredTemp()
        == other.getDesiredTemp());
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
    hash = (37 * hash) + DESIREDTEMP_FIELD_NUMBER;
    hash = (53 * hash) + getDesiredTemp();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static ds.hotWater.desiredTankTemp parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ds.hotWater.desiredTankTemp parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ds.hotWater.desiredTankTemp parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ds.hotWater.desiredTankTemp parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ds.hotWater.desiredTankTemp parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ds.hotWater.desiredTankTemp parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ds.hotWater.desiredTankTemp parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static ds.hotWater.desiredTankTemp parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static ds.hotWater.desiredTankTemp parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static ds.hotWater.desiredTankTemp parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static ds.hotWater.desiredTankTemp parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static ds.hotWater.desiredTankTemp parseFrom(
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
  public static Builder newBuilder(ds.hotWater.desiredTankTemp prototype) {
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
   * Protobuf type {@code hotWater.desiredTankTemp}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:hotWater.desiredTankTemp)
      ds.hotWater.desiredTankTempOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return ds.hotWater.hotWaterImpl.internal_static_hotWater_desiredTankTemp_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return ds.hotWater.hotWaterImpl.internal_static_hotWater_desiredTankTemp_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              ds.hotWater.desiredTankTemp.class, ds.hotWater.desiredTankTemp.Builder.class);
    }

    // Construct using ds.hotWater.desiredTankTemp.newBuilder()
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
      desiredTemp_ = 0;

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return ds.hotWater.hotWaterImpl.internal_static_hotWater_desiredTankTemp_descriptor;
    }

    @java.lang.Override
    public ds.hotWater.desiredTankTemp getDefaultInstanceForType() {
      return ds.hotWater.desiredTankTemp.getDefaultInstance();
    }

    @java.lang.Override
    public ds.hotWater.desiredTankTemp build() {
      ds.hotWater.desiredTankTemp result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public ds.hotWater.desiredTankTemp buildPartial() {
      ds.hotWater.desiredTankTemp result = new ds.hotWater.desiredTankTemp(this);
      result.desiredTemp_ = desiredTemp_;
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
      if (other instanceof ds.hotWater.desiredTankTemp) {
        return mergeFrom((ds.hotWater.desiredTankTemp)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(ds.hotWater.desiredTankTemp other) {
      if (other == ds.hotWater.desiredTankTemp.getDefaultInstance()) return this;
      if (other.getDesiredTemp() != 0) {
        setDesiredTemp(other.getDesiredTemp());
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
      ds.hotWater.desiredTankTemp parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (ds.hotWater.desiredTankTemp) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private int desiredTemp_ ;
    /**
     * <code>int32 desiredTemp = 1;</code>
     */
    public int getDesiredTemp() {
      return desiredTemp_;
    }
    /**
     * <code>int32 desiredTemp = 1;</code>
     */
    public Builder setDesiredTemp(int value) {
      
      desiredTemp_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 desiredTemp = 1;</code>
     */
    public Builder clearDesiredTemp() {
      
      desiredTemp_ = 0;
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


    // @@protoc_insertion_point(builder_scope:hotWater.desiredTankTemp)
  }

  // @@protoc_insertion_point(class_scope:hotWater.desiredTankTemp)
  private static final ds.hotWater.desiredTankTemp DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new ds.hotWater.desiredTankTemp();
  }

  public static ds.hotWater.desiredTankTemp getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<desiredTankTemp>
      PARSER = new com.google.protobuf.AbstractParser<desiredTankTemp>() {
    @java.lang.Override
    public desiredTankTemp parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new desiredTankTemp(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<desiredTankTemp> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<desiredTankTemp> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public ds.hotWater.desiredTankTemp getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

