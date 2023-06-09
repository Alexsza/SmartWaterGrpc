// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: waterMonitoring.proto

package ds.waterMonitoring;

/**
 * Protobuf type {@code waterMonitoring.SensorDataResponse}
 */
public  final class SensorDataResponse extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:waterMonitoring.SensorDataResponse)
    SensorDataResponseOrBuilder {
private static final long serialVersionUID = 0L;
  // Use SensorDataResponse.newBuilder() to construct.
  private SensorDataResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private SensorDataResponse() {
    alert_ = "";
    recommendation_ = "";
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private SensorDataResponse(
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
          case 10: {
            java.lang.String s = input.readStringRequireUtf8();

            alert_ = s;
            break;
          }
          case 18: {
            java.lang.String s = input.readStringRequireUtf8();

            recommendation_ = s;
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
    return ds.waterMonitoring.WaterMonitoringImpl.internal_static_waterMonitoring_SensorDataResponse_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return ds.waterMonitoring.WaterMonitoringImpl.internal_static_waterMonitoring_SensorDataResponse_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            ds.waterMonitoring.SensorDataResponse.class, ds.waterMonitoring.SensorDataResponse.Builder.class);
  }

  public static final int ALERT_FIELD_NUMBER = 1;
  private volatile java.lang.Object alert_;
  /**
   * <code>string alert = 1;</code>
   */
  public java.lang.String getAlert() {
    java.lang.Object ref = alert_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      alert_ = s;
      return s;
    }
  }
  /**
   * <code>string alert = 1;</code>
   */
  public com.google.protobuf.ByteString
      getAlertBytes() {
    java.lang.Object ref = alert_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      alert_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int RECOMMENDATION_FIELD_NUMBER = 2;
  private volatile java.lang.Object recommendation_;
  /**
   * <code>string recommendation = 2;</code>
   */
  public java.lang.String getRecommendation() {
    java.lang.Object ref = recommendation_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      recommendation_ = s;
      return s;
    }
  }
  /**
   * <code>string recommendation = 2;</code>
   */
  public com.google.protobuf.ByteString
      getRecommendationBytes() {
    java.lang.Object ref = recommendation_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      recommendation_ = b;
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
    if (!getAlertBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, alert_);
    }
    if (!getRecommendationBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, recommendation_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getAlertBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, alert_);
    }
    if (!getRecommendationBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, recommendation_);
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
    if (!(obj instanceof ds.waterMonitoring.SensorDataResponse)) {
      return super.equals(obj);
    }
    ds.waterMonitoring.SensorDataResponse other = (ds.waterMonitoring.SensorDataResponse) obj;

    boolean result = true;
    result = result && getAlert()
        .equals(other.getAlert());
    result = result && getRecommendation()
        .equals(other.getRecommendation());
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
    hash = (37 * hash) + ALERT_FIELD_NUMBER;
    hash = (53 * hash) + getAlert().hashCode();
    hash = (37 * hash) + RECOMMENDATION_FIELD_NUMBER;
    hash = (53 * hash) + getRecommendation().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static ds.waterMonitoring.SensorDataResponse parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ds.waterMonitoring.SensorDataResponse parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ds.waterMonitoring.SensorDataResponse parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ds.waterMonitoring.SensorDataResponse parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ds.waterMonitoring.SensorDataResponse parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ds.waterMonitoring.SensorDataResponse parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ds.waterMonitoring.SensorDataResponse parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static ds.waterMonitoring.SensorDataResponse parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static ds.waterMonitoring.SensorDataResponse parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static ds.waterMonitoring.SensorDataResponse parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static ds.waterMonitoring.SensorDataResponse parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static ds.waterMonitoring.SensorDataResponse parseFrom(
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
  public static Builder newBuilder(ds.waterMonitoring.SensorDataResponse prototype) {
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
   * Protobuf type {@code waterMonitoring.SensorDataResponse}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:waterMonitoring.SensorDataResponse)
      ds.waterMonitoring.SensorDataResponseOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return ds.waterMonitoring.WaterMonitoringImpl.internal_static_waterMonitoring_SensorDataResponse_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return ds.waterMonitoring.WaterMonitoringImpl.internal_static_waterMonitoring_SensorDataResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              ds.waterMonitoring.SensorDataResponse.class, ds.waterMonitoring.SensorDataResponse.Builder.class);
    }

    // Construct using ds.waterMonitoring.SensorDataResponse.newBuilder()
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
      alert_ = "";

      recommendation_ = "";

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return ds.waterMonitoring.WaterMonitoringImpl.internal_static_waterMonitoring_SensorDataResponse_descriptor;
    }

    @java.lang.Override
    public ds.waterMonitoring.SensorDataResponse getDefaultInstanceForType() {
      return ds.waterMonitoring.SensorDataResponse.getDefaultInstance();
    }

    @java.lang.Override
    public ds.waterMonitoring.SensorDataResponse build() {
      ds.waterMonitoring.SensorDataResponse result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public ds.waterMonitoring.SensorDataResponse buildPartial() {
      ds.waterMonitoring.SensorDataResponse result = new ds.waterMonitoring.SensorDataResponse(this);
      result.alert_ = alert_;
      result.recommendation_ = recommendation_;
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
      if (other instanceof ds.waterMonitoring.SensorDataResponse) {
        return mergeFrom((ds.waterMonitoring.SensorDataResponse)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(ds.waterMonitoring.SensorDataResponse other) {
      if (other == ds.waterMonitoring.SensorDataResponse.getDefaultInstance()) return this;
      if (!other.getAlert().isEmpty()) {
        alert_ = other.alert_;
        onChanged();
      }
      if (!other.getRecommendation().isEmpty()) {
        recommendation_ = other.recommendation_;
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
      ds.waterMonitoring.SensorDataResponse parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (ds.waterMonitoring.SensorDataResponse) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private java.lang.Object alert_ = "";
    /**
     * <code>string alert = 1;</code>
     */
    public java.lang.String getAlert() {
      java.lang.Object ref = alert_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        alert_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string alert = 1;</code>
     */
    public com.google.protobuf.ByteString
        getAlertBytes() {
      java.lang.Object ref = alert_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        alert_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string alert = 1;</code>
     */
    public Builder setAlert(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      alert_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string alert = 1;</code>
     */
    public Builder clearAlert() {
      
      alert_ = getDefaultInstance().getAlert();
      onChanged();
      return this;
    }
    /**
     * <code>string alert = 1;</code>
     */
    public Builder setAlertBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      alert_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object recommendation_ = "";
    /**
     * <code>string recommendation = 2;</code>
     */
    public java.lang.String getRecommendation() {
      java.lang.Object ref = recommendation_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        recommendation_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string recommendation = 2;</code>
     */
    public com.google.protobuf.ByteString
        getRecommendationBytes() {
      java.lang.Object ref = recommendation_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        recommendation_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string recommendation = 2;</code>
     */
    public Builder setRecommendation(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      recommendation_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string recommendation = 2;</code>
     */
    public Builder clearRecommendation() {
      
      recommendation_ = getDefaultInstance().getRecommendation();
      onChanged();
      return this;
    }
    /**
     * <code>string recommendation = 2;</code>
     */
    public Builder setRecommendationBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      recommendation_ = value;
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


    // @@protoc_insertion_point(builder_scope:waterMonitoring.SensorDataResponse)
  }

  // @@protoc_insertion_point(class_scope:waterMonitoring.SensorDataResponse)
  private static final ds.waterMonitoring.SensorDataResponse DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new ds.waterMonitoring.SensorDataResponse();
  }

  public static ds.waterMonitoring.SensorDataResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<SensorDataResponse>
      PARSER = new com.google.protobuf.AbstractParser<SensorDataResponse>() {
    @java.lang.Override
    public SensorDataResponse parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new SensorDataResponse(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<SensorDataResponse> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<SensorDataResponse> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public ds.waterMonitoring.SensorDataResponse getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

