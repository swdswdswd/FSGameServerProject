// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: SkillS2C.proto

package com.fsgame.proto;

public final class MSGSkillS2C {
  private MSGSkillS2C() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface SkillS2COrBuilder extends
      // @@protoc_insertion_point(interface_extends:Pro.SkillS2C)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>optional int32 targetid = 1;</code>
     */
    int getTargetid();

    /**
     * <code>optional int32 attackerid = 2;</code>
     */
    int getAttackerid();

    /**
     * <code>optional .Pro.SkillType type = 3;</code>
     */
    int getTypeValue();
    /**
     * <code>optional .Pro.SkillType type = 3;</code>
     */
    com.fsgame.proto.MSGBaseCommon.SkillType getType();

    /**
     * <code>optional float damange = 4;</code>
     */
    float getDamange();
  }
  /**
   * <pre>
   *技能协议
   * </pre>
   *
   * Protobuf type {@code Pro.SkillS2C}
   */
  public  static final class SkillS2C extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:Pro.SkillS2C)
      SkillS2COrBuilder {
    // Use SkillS2C.newBuilder() to construct.
    private SkillS2C(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private SkillS2C() {
      targetid_ = 0;
      attackerid_ = 0;
      type_ = 0;
      damange_ = 0F;
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
    }
    private SkillS2C(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      this();
      int mutable_bitField0_ = 0;
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            default: {
              if (!input.skipField(tag)) {
                done = true;
              }
              break;
            }
            case 8: {

              targetid_ = input.readInt32();
              break;
            }
            case 16: {

              attackerid_ = input.readInt32();
              break;
            }
            case 24: {
              int rawValue = input.readEnum();

              type_ = rawValue;
              break;
            }
            case 37: {

              damange_ = input.readFloat();
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
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.fsgame.proto.MSGSkillS2C.internal_static_Pro_SkillS2C_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.fsgame.proto.MSGSkillS2C.internal_static_Pro_SkillS2C_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.fsgame.proto.MSGSkillS2C.SkillS2C.class, com.fsgame.proto.MSGSkillS2C.SkillS2C.Builder.class);
    }

    public static final int TARGETID_FIELD_NUMBER = 1;
    private int targetid_;
    /**
     * <code>optional int32 targetid = 1;</code>
     */
    public int getTargetid() {
      return targetid_;
    }

    public static final int ATTACKERID_FIELD_NUMBER = 2;
    private int attackerid_;
    /**
     * <code>optional int32 attackerid = 2;</code>
     */
    public int getAttackerid() {
      return attackerid_;
    }

    public static final int TYPE_FIELD_NUMBER = 3;
    private int type_;
    /**
     * <code>optional .Pro.SkillType type = 3;</code>
     */
    public int getTypeValue() {
      return type_;
    }
    /**
     * <code>optional .Pro.SkillType type = 3;</code>
     */
    public com.fsgame.proto.MSGBaseCommon.SkillType getType() {
      com.fsgame.proto.MSGBaseCommon.SkillType result = com.fsgame.proto.MSGBaseCommon.SkillType.valueOf(type_);
      return result == null ? com.fsgame.proto.MSGBaseCommon.SkillType.UNRECOGNIZED : result;
    }

    public static final int DAMANGE_FIELD_NUMBER = 4;
    private float damange_;
    /**
     * <code>optional float damange = 4;</code>
     */
    public float getDamange() {
      return damange_;
    }

    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      memoizedIsInitialized = 1;
      return true;
    }

    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      if (targetid_ != 0) {
        output.writeInt32(1, targetid_);
      }
      if (attackerid_ != 0) {
        output.writeInt32(2, attackerid_);
      }
      if (type_ != com.fsgame.proto.MSGBaseCommon.SkillType._SHOORTER_.getNumber()) {
        output.writeEnum(3, type_);
      }
      if (damange_ != 0F) {
        output.writeFloat(4, damange_);
      }
    }

    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (targetid_ != 0) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(1, targetid_);
      }
      if (attackerid_ != 0) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(2, attackerid_);
      }
      if (type_ != com.fsgame.proto.MSGBaseCommon.SkillType._SHOORTER_.getNumber()) {
        size += com.google.protobuf.CodedOutputStream
          .computeEnumSize(3, type_);
      }
      if (damange_ != 0F) {
        size += com.google.protobuf.CodedOutputStream
          .computeFloatSize(4, damange_);
      }
      memoizedSize = size;
      return size;
    }

    private static final long serialVersionUID = 0L;
    @java.lang.Override
    public boolean equals(final java.lang.Object obj) {
      if (obj == this) {
       return true;
      }
      if (!(obj instanceof com.fsgame.proto.MSGSkillS2C.SkillS2C)) {
        return super.equals(obj);
      }
      com.fsgame.proto.MSGSkillS2C.SkillS2C other = (com.fsgame.proto.MSGSkillS2C.SkillS2C) obj;

      boolean result = true;
      result = result && (getTargetid()
          == other.getTargetid());
      result = result && (getAttackerid()
          == other.getAttackerid());
      result = result && type_ == other.type_;
      result = result && (
          java.lang.Float.floatToIntBits(getDamange())
          == java.lang.Float.floatToIntBits(
              other.getDamange()));
      return result;
    }

    @java.lang.Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptorForType().hashCode();
      hash = (37 * hash) + TARGETID_FIELD_NUMBER;
      hash = (53 * hash) + getTargetid();
      hash = (37 * hash) + ATTACKERID_FIELD_NUMBER;
      hash = (53 * hash) + getAttackerid();
      hash = (37 * hash) + TYPE_FIELD_NUMBER;
      hash = (53 * hash) + type_;
      hash = (37 * hash) + DAMANGE_FIELD_NUMBER;
      hash = (53 * hash) + java.lang.Float.floatToIntBits(
          getDamange());
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static com.fsgame.proto.MSGSkillS2C.SkillS2C parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.fsgame.proto.MSGSkillS2C.SkillS2C parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.fsgame.proto.MSGSkillS2C.SkillS2C parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.fsgame.proto.MSGSkillS2C.SkillS2C parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.fsgame.proto.MSGSkillS2C.SkillS2C parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static com.fsgame.proto.MSGSkillS2C.SkillS2C parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static com.fsgame.proto.MSGSkillS2C.SkillS2C parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static com.fsgame.proto.MSGSkillS2C.SkillS2C parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static com.fsgame.proto.MSGSkillS2C.SkillS2C parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static com.fsgame.proto.MSGSkillS2C.SkillS2C parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }

    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(com.fsgame.proto.MSGSkillS2C.SkillS2C prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }
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
     * <pre>
     *技能协议
     * </pre>
     *
     * Protobuf type {@code Pro.SkillS2C}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:Pro.SkillS2C)
        com.fsgame.proto.MSGSkillS2C.SkillS2COrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return com.fsgame.proto.MSGSkillS2C.internal_static_Pro_SkillS2C_descriptor;
      }

      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.fsgame.proto.MSGSkillS2C.internal_static_Pro_SkillS2C_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.fsgame.proto.MSGSkillS2C.SkillS2C.class, com.fsgame.proto.MSGSkillS2C.SkillS2C.Builder.class);
      }

      // Construct using com.fsgame.proto.MSGSkillS2C.SkillS2C.newBuilder()
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
      public Builder clear() {
        super.clear();
        targetid_ = 0;

        attackerid_ = 0;

        type_ = 0;

        damange_ = 0F;

        return this;
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return com.fsgame.proto.MSGSkillS2C.internal_static_Pro_SkillS2C_descriptor;
      }

      public com.fsgame.proto.MSGSkillS2C.SkillS2C getDefaultInstanceForType() {
        return com.fsgame.proto.MSGSkillS2C.SkillS2C.getDefaultInstance();
      }

      public com.fsgame.proto.MSGSkillS2C.SkillS2C build() {
        com.fsgame.proto.MSGSkillS2C.SkillS2C result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public com.fsgame.proto.MSGSkillS2C.SkillS2C buildPartial() {
        com.fsgame.proto.MSGSkillS2C.SkillS2C result = new com.fsgame.proto.MSGSkillS2C.SkillS2C(this);
        result.targetid_ = targetid_;
        result.attackerid_ = attackerid_;
        result.type_ = type_;
        result.damange_ = damange_;
        onBuilt();
        return result;
      }

      public Builder clone() {
        return (Builder) super.clone();
      }
      public Builder setField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          Object value) {
        return (Builder) super.setField(field, value);
      }
      public Builder clearField(
          com.google.protobuf.Descriptors.FieldDescriptor field) {
        return (Builder) super.clearField(field);
      }
      public Builder clearOneof(
          com.google.protobuf.Descriptors.OneofDescriptor oneof) {
        return (Builder) super.clearOneof(oneof);
      }
      public Builder setRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          int index, Object value) {
        return (Builder) super.setRepeatedField(field, index, value);
      }
      public Builder addRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          Object value) {
        return (Builder) super.addRepeatedField(field, value);
      }
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof com.fsgame.proto.MSGSkillS2C.SkillS2C) {
          return mergeFrom((com.fsgame.proto.MSGSkillS2C.SkillS2C)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(com.fsgame.proto.MSGSkillS2C.SkillS2C other) {
        if (other == com.fsgame.proto.MSGSkillS2C.SkillS2C.getDefaultInstance()) return this;
        if (other.getTargetid() != 0) {
          setTargetid(other.getTargetid());
        }
        if (other.getAttackerid() != 0) {
          setAttackerid(other.getAttackerid());
        }
        if (other.type_ != 0) {
          setTypeValue(other.getTypeValue());
        }
        if (other.getDamange() != 0F) {
          setDamange(other.getDamange());
        }
        onChanged();
        return this;
      }

      public final boolean isInitialized() {
        return true;
      }

      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        com.fsgame.proto.MSGSkillS2C.SkillS2C parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (com.fsgame.proto.MSGSkillS2C.SkillS2C) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private int targetid_ ;
      /**
       * <code>optional int32 targetid = 1;</code>
       */
      public int getTargetid() {
        return targetid_;
      }
      /**
       * <code>optional int32 targetid = 1;</code>
       */
      public Builder setTargetid(int value) {
        
        targetid_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional int32 targetid = 1;</code>
       */
      public Builder clearTargetid() {
        
        targetid_ = 0;
        onChanged();
        return this;
      }

      private int attackerid_ ;
      /**
       * <code>optional int32 attackerid = 2;</code>
       */
      public int getAttackerid() {
        return attackerid_;
      }
      /**
       * <code>optional int32 attackerid = 2;</code>
       */
      public Builder setAttackerid(int value) {
        
        attackerid_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional int32 attackerid = 2;</code>
       */
      public Builder clearAttackerid() {
        
        attackerid_ = 0;
        onChanged();
        return this;
      }

      private int type_ = 0;
      /**
       * <code>optional .Pro.SkillType type = 3;</code>
       */
      public int getTypeValue() {
        return type_;
      }
      /**
       * <code>optional .Pro.SkillType type = 3;</code>
       */
      public Builder setTypeValue(int value) {
        type_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional .Pro.SkillType type = 3;</code>
       */
      public com.fsgame.proto.MSGBaseCommon.SkillType getType() {
        com.fsgame.proto.MSGBaseCommon.SkillType result = com.fsgame.proto.MSGBaseCommon.SkillType.valueOf(type_);
        return result == null ? com.fsgame.proto.MSGBaseCommon.SkillType.UNRECOGNIZED : result;
      }
      /**
       * <code>optional .Pro.SkillType type = 3;</code>
       */
      public Builder setType(com.fsgame.proto.MSGBaseCommon.SkillType value) {
        if (value == null) {
          throw new NullPointerException();
        }
        
        type_ = value.getNumber();
        onChanged();
        return this;
      }
      /**
       * <code>optional .Pro.SkillType type = 3;</code>
       */
      public Builder clearType() {
        
        type_ = 0;
        onChanged();
        return this;
      }

      private float damange_ ;
      /**
       * <code>optional float damange = 4;</code>
       */
      public float getDamange() {
        return damange_;
      }
      /**
       * <code>optional float damange = 4;</code>
       */
      public Builder setDamange(float value) {
        
        damange_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional float damange = 4;</code>
       */
      public Builder clearDamange() {
        
        damange_ = 0F;
        onChanged();
        return this;
      }
      public final Builder setUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return this;
      }

      public final Builder mergeUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return this;
      }


      // @@protoc_insertion_point(builder_scope:Pro.SkillS2C)
    }

    // @@protoc_insertion_point(class_scope:Pro.SkillS2C)
    private static final com.fsgame.proto.MSGSkillS2C.SkillS2C DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new com.fsgame.proto.MSGSkillS2C.SkillS2C();
    }

    public static com.fsgame.proto.MSGSkillS2C.SkillS2C getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<SkillS2C>
        PARSER = new com.google.protobuf.AbstractParser<SkillS2C>() {
      public SkillS2C parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
          return new SkillS2C(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<SkillS2C> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<SkillS2C> getParserForType() {
      return PARSER;
    }

    public com.fsgame.proto.MSGSkillS2C.SkillS2C getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Pro_SkillS2C_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Pro_SkillS2C_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\016SkillS2C.proto\022\003Pro\032\020BaseCommon.proto\"" +
      "_\n\010SkillS2C\022\020\n\010targetid\030\001 \001(\005\022\022\n\nattacke" +
      "rid\030\002 \001(\005\022\034\n\004type\030\003 \001(\0162\016.Pro.SkillType\022" +
      "\017\n\007damange\030\004 \001(\002B\037\n\020com.fsgame.protoB\013MS" +
      "GSkillS2Cb\006proto3"
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
          com.fsgame.proto.MSGBaseCommon.getDescriptor(),
        }, assigner);
    internal_static_Pro_SkillS2C_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_Pro_SkillS2C_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Pro_SkillS2C_descriptor,
        new java.lang.String[] { "Targetid", "Attackerid", "Type", "Damange", });
    com.fsgame.proto.MSGBaseCommon.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}