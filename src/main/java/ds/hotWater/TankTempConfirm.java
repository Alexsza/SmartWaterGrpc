// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: hotWaters.proto

package ds.hotWater;

/**
 * Protobuf type {@code hotWater.TankTempConfirm}
 */
public  final class TankTempConfirm extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:hotWater.TankTempConfirm)
    TankTempConfirmOrBuilder {
private static final long serialVersionUID = 0L;
  // Use TankTempConfirm.newBuilder() to construct.
  private TankTempConfirm(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private TankTempConfirm() {
    currentTankTemp_ = 0;
    confirmation_ = "";
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private TankTempConfirm(
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

            currentTankTemp_ = input.readInt32();
            break;
          }
          case 18: {
            java.lang.String s = input.readStringRequireUtf8();

            confirmation_ = s;
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
    return ds.hotWater.hotWaterImpl.internal_static_hotWater_TankTempConfirm_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return ds.hotWater.hotWaterImpl.internal_static_hotWater_TankTempConfirm_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            ds.hotWater.TankTempConfirm.class, ds.hotWater.TankTempConfirm.Builder.class);
  }

  public static final int CURRENTTANKTEMP_FIELD_NUMBER = 1;
  private int currentTankTemp_;
  /**
   * <code>int32 currentTankTemp = 1;</code>
   */
  public int getCurrentTankTemp() {
    return currentTankTemp_;
  }

  public static final int CONFIRMATION_FIELD_NUMBER = 2;
  private volatile java.lang.Object confirmation_;
  /**
   * <code>string confirmation = 2;</code>
   */
  public java.lang.String getConfirmation() {
    java.lang.Object ref = confirmation_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      confirmation_ = s;
      return s;
    }
  }
  /**
   * <code>string confirmation = 2;</code>
   */
  public com.google.protobuf.ByteString
      getConfirmationBytes() {
    java.lang.Object ref = confirmation_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      confirmation_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
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
    if (currentTankTemp_ != 0) {
      output.writeInt32(1, currentTankTemp_);
    }
    if (!getConfirmationBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, confirmation_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (currentTankTemp_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(1, currentTankTemp_);
    }
    if (!getConfirmationBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, confirmation_);
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
    if (!(obj instanceof ds.hotWater.TankTempConfirm)) {
      return super.equals(obj);
    }
    ds.hotWater.TankTempConfirm other = (ds.hotWater.TankTempConfirm) obj;

    boolean result = true;
    result = result && (getCurrentTankTemp()
        == other.getCurrentTankTemp());
    result = result && getConfirmation()
        .equals(other.getConfirmation());
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
    hash = (37 * hash) + CURRENTTANKTEMP_FIELD_NUMBER;
    hash = (53 * hash) + getCurrentTankTemp();
    hash = (37 * hash) + CONFIRMATION_FIELD_NUMBER;
    hash = (53 * hash) + getConfirmation().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static ds.hotWater.TankTempConfirm parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ds.hotWater.TankTempConfirm parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ds.hotWater.TankTempConfirm parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ds.hotWater.TankTempConfirm parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ds.hotWater.TankTempConfirm parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ds.hotWater.TankTempConfirm parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ds.hotWater.TankTempConfirm parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static ds.hotWater.TankTempConfirm parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static ds.hotWater.TankTempConfirm parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static ds.hotWater.TankTempConfirm parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static ds.hotWater.TankTempConfirm parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static ds.hotWater.TankTempConfirm parseFrom(
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
  public static Builder newBuilder(ds.hotWater.TankTempConfirm prototype) {
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
   * Protobuf type {@code hotWater.TankTempConfirm}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:hotWater.TankTempConfirm)
      ds.hotWater.TankTempConfirmOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return ds.hotWater.hotWaterImpl.internal_static_hotWater_TankTempConfirm_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return ds.hotWater.hotWaterImpl.internal_static_hotWater_TankTempConfirm_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              ds.hotWater.TankTempConfirm.class, ds.hotWater.TankTempConfirm.Builder.class);
    }

    // Construct using ds.hotWater.TankTempConfirm.newBuilder()
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
      currentTankTemp_ = 0;

      confirmation_ = "";

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return ds.hotWater.hotWaterImpl.internal_static_hotWater_TankTempConfirm_descriptor;
    }

    @java.lang.Override
    public ds.hotWater.TankTempConfirm getDefaultInstanceForType() {
      return ds.hotWater.TankTempConfirm.getDefaultInstance();
    }

    @java.lang.Override
    public ds.hotWater.TankTempConfirm build() {
      ds.hotWater.TankTempConfirm result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public ds.hotWater.TankTempConfirm buildPartial() {
      ds.hotWater.TankTempConfirm result = new ds.hotWater.TankTempConfirm(this);
      result.currentTankTemp_ = currentTankTemp_;
      result.confirmation_ = confirmation_;
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
      if (other instanceof ds.hotWater.TankTempConfirm) {
        return mergeFrom((ds.hotWater.TankTempConfirm)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(ds.hotWater.TankTempConfirm other) {
      if (other == ds.hotWater.TankTempConfirm.getDefaultInstance()) return this;
      if (other.getCurrentTankTemp() != 0) {
        setCurrentTankTemp(other.getCurrentTankTemp());
      }
      if (!other.getConfirmation().isEmpty()) {
        confirmation_ = other.confirmation_;
        onChanged();
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
      ds.hotWater.TankTempConfirm parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (ds.hotWater.TankTempConfirm) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private int currentTankTemp_ ;
    /**
     * <code>int32 currentTankTemp = 1;</code>
     */
    public int getCurrentTankTemp() {
      return currentTankTemp_;
    }
    /**
     * <code>int32 currentTankTemp = 1;</code>
     */
    public Builder setCurrentTankTemp(int value) {
      
      currentTankTemp_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 currentTankTemp = 1;</code>
     */
    public Builder clearCurrentTankTemp() {
      
      currentTankTemp_ = 0;
      onChanged();
      return this;
    }

    private java.lang.Object confirmation_ = "";
    /**
     * <code>string confirmation = 2;</code>
     */
    public java.lang.String getConfirmation() {
      java.lang.Object ref = confirmation_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        confirmation_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string confirmation = 2;</code>
     */
    public com.google.protobuf.ByteString
        getConfirmationBytes() {
      java.lang.Object ref = confirmation_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        confirmation_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string confirmation = 2;</code>
     */
    public Builder setConfirmation(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      confirmation_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string confirmation = 2;</code>
     */
    public Builder clearConfirmation() {
      
      confirmation_ = getDefaultInstance().getConfirmation();
      onChanged();
      return this;
    }
    /**
     * <code>string confirmation = 2;</code>
     */
    public Builder setConfirmationBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      confirmation_ = value;
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


    // @@protoc_insertion_point(builder_scope:hotWater.TankTempConfirm)
  }

  // @@protoc_insertion_point(class_scope:hotWater.TankTempConfirm)
  private static final ds.hotWater.TankTempConfirm DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new ds.hotWater.TankTempConfirm();
  }

  public static ds.hotWater.TankTempConfirm getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<TankTempConfirm>
      PARSER = new com.google.protobuf.AbstractParser<TankTempConfirm>() {
    @java.lang.Override
    public TankTempConfirm parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new TankTempConfirm(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<TankTempConfirm> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<TankTempConfirm> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public ds.hotWater.TankTempConfirm getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

