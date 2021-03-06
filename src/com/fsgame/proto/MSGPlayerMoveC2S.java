// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: PlayerMoveC2S.proto

package com.fsgame.proto;

public final class MSGPlayerMoveC2S {
  private MSGPlayerMoveC2S() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface PlayerMoveC2SOrBuilder extends
      // @@protoc_insertion_point(interface_extends:Pro.PlayerMoveC2S)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>optional .Pro.PlayerCommon movebase = 1;</code>
     */
    boolean hasMovebase();
    /**
     * <code>optional .Pro.PlayerCommon movebase = 1;</code>
     */
    com.fsgame.proto.MSGPlayerCommon.PlayerCommon getMovebase();
    /**
     * <code>optional .Pro.PlayerCommon movebase = 1;</code>
     */
    com.fsgame.proto.MSGPlayerCommon.PlayerCommonOrBuilder getMovebaseOrBuilder();

    /**
     * <code>optional .Pro.MoveType moveop = 2;</code>
     */
    int getMoveopValue();
    /**
     * <code>optional .Pro.MoveType moveop = 2;</code>
     */
    com.fsgame.proto.MSGBaseCommon.MoveType getMoveop();
  }
  /**
   * <pre>
   *玩家坐标信息
   * </pre>
   *
   * Protobuf type {@code Pro.PlayerMoveC2S}
   */
  public  static final class PlayerMoveC2S extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:Pro.PlayerMoveC2S)
      PlayerMoveC2SOrBuilder {
    // Use PlayerMoveC2S.newBuilder() to construct.
    private PlayerMoveC2S(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private PlayerMoveC2S() {
      moveop_ = 0;
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
    }
    private PlayerMoveC2S(
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
            case 10: {
              com.fsgame.proto.MSGPlayerCommon.PlayerCommon.Builder subBuilder = null;
              if (movebase_ != null) {
                subBuilder = movebase_.toBuilder();
              }
              movebase_ = input.readMessage(com.fsgame.proto.MSGPlayerCommon.PlayerCommon.parser(), extensionRegistry);
              if (subBuilder != null) {
                subBuilder.mergeFrom(movebase_);
                movebase_ = subBuilder.buildPartial();
              }

              break;
            }
            case 16: {
              int rawValue = input.readEnum();

              moveop_ = rawValue;
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
      return com.fsgame.proto.MSGPlayerMoveC2S.internal_static_Pro_PlayerMoveC2S_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.fsgame.proto.MSGPlayerMoveC2S.internal_static_Pro_PlayerMoveC2S_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.fsgame.proto.MSGPlayerMoveC2S.PlayerMoveC2S.class, com.fsgame.proto.MSGPlayerMoveC2S.PlayerMoveC2S.Builder.class);
    }

    public static final int MOVEBASE_FIELD_NUMBER = 1;
    private com.fsgame.proto.MSGPlayerCommon.PlayerCommon movebase_;
    /**
     * <code>optional .Pro.PlayerCommon movebase = 1;</code>
     */
    public boolean hasMovebase() {
      return movebase_ != null;
    }
    /**
     * <code>optional .Pro.PlayerCommon movebase = 1;</code>
     */
    public com.fsgame.proto.MSGPlayerCommon.PlayerCommon getMovebase() {
      return movebase_ == null ? com.fsgame.proto.MSGPlayerCommon.PlayerCommon.getDefaultInstance() : movebase_;
    }
    /**
     * <code>optional .Pro.PlayerCommon movebase = 1;</code>
     */
    public com.fsgame.proto.MSGPlayerCommon.PlayerCommonOrBuilder getMovebaseOrBuilder() {
      return getMovebase();
    }

    public static final int MOVEOP_FIELD_NUMBER = 2;
    private int moveop_;
    /**
     * <code>optional .Pro.MoveType moveop = 2;</code>
     */
    public int getMoveopValue() {
      return moveop_;
    }
    /**
     * <code>optional .Pro.MoveType moveop = 2;</code>
     */
    public com.fsgame.proto.MSGBaseCommon.MoveType getMoveop() {
      com.fsgame.proto.MSGBaseCommon.MoveType result = com.fsgame.proto.MSGBaseCommon.MoveType.valueOf(moveop_);
      return result == null ? com.fsgame.proto.MSGBaseCommon.MoveType.UNRECOGNIZED : result;
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
      if (movebase_ != null) {
        output.writeMessage(1, getMovebase());
      }
      if (moveop_ != com.fsgame.proto.MSGBaseCommon.MoveType._RUN_.getNumber()) {
        output.writeEnum(2, moveop_);
      }
    }

    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (movebase_ != null) {
        size += com.google.protobuf.CodedOutputStream
          .computeMessageSize(1, getMovebase());
      }
      if (moveop_ != com.fsgame.proto.MSGBaseCommon.MoveType._RUN_.getNumber()) {
        size += com.google.protobuf.CodedOutputStream
          .computeEnumSize(2, moveop_);
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
      if (!(obj instanceof com.fsgame.proto.MSGPlayerMoveC2S.PlayerMoveC2S)) {
        return super.equals(obj);
      }
      com.fsgame.proto.MSGPlayerMoveC2S.PlayerMoveC2S other = (com.fsgame.proto.MSGPlayerMoveC2S.PlayerMoveC2S) obj;

      boolean result = true;
      result = result && (hasMovebase() == other.hasMovebase());
      if (hasMovebase()) {
        result = result && getMovebase()
            .equals(other.getMovebase());
      }
      result = result && moveop_ == other.moveop_;
      return result;
    }

    @java.lang.Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptorForType().hashCode();
      if (hasMovebase()) {
        hash = (37 * hash) + MOVEBASE_FIELD_NUMBER;
        hash = (53 * hash) + getMovebase().hashCode();
      }
      hash = (37 * hash) + MOVEOP_FIELD_NUMBER;
      hash = (53 * hash) + moveop_;
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static com.fsgame.proto.MSGPlayerMoveC2S.PlayerMoveC2S parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.fsgame.proto.MSGPlayerMoveC2S.PlayerMoveC2S parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.fsgame.proto.MSGPlayerMoveC2S.PlayerMoveC2S parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.fsgame.proto.MSGPlayerMoveC2S.PlayerMoveC2S parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.fsgame.proto.MSGPlayerMoveC2S.PlayerMoveC2S parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static com.fsgame.proto.MSGPlayerMoveC2S.PlayerMoveC2S parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static com.fsgame.proto.MSGPlayerMoveC2S.PlayerMoveC2S parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static com.fsgame.proto.MSGPlayerMoveC2S.PlayerMoveC2S parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static com.fsgame.proto.MSGPlayerMoveC2S.PlayerMoveC2S parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static com.fsgame.proto.MSGPlayerMoveC2S.PlayerMoveC2S parseFrom(
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
    public static Builder newBuilder(com.fsgame.proto.MSGPlayerMoveC2S.PlayerMoveC2S prototype) {
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
     *玩家坐标信息
     * </pre>
     *
     * Protobuf type {@code Pro.PlayerMoveC2S}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:Pro.PlayerMoveC2S)
        com.fsgame.proto.MSGPlayerMoveC2S.PlayerMoveC2SOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return com.fsgame.proto.MSGPlayerMoveC2S.internal_static_Pro_PlayerMoveC2S_descriptor;
      }

      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.fsgame.proto.MSGPlayerMoveC2S.internal_static_Pro_PlayerMoveC2S_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.fsgame.proto.MSGPlayerMoveC2S.PlayerMoveC2S.class, com.fsgame.proto.MSGPlayerMoveC2S.PlayerMoveC2S.Builder.class);
      }

      // Construct using com.fsgame.proto.MSGPlayerMoveC2S.PlayerMoveC2S.newBuilder()
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
        if (movebaseBuilder_ == null) {
          movebase_ = null;
        } else {
          movebase_ = null;
          movebaseBuilder_ = null;
        }
        moveop_ = 0;

        return this;
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return com.fsgame.proto.MSGPlayerMoveC2S.internal_static_Pro_PlayerMoveC2S_descriptor;
      }

      public com.fsgame.proto.MSGPlayerMoveC2S.PlayerMoveC2S getDefaultInstanceForType() {
        return com.fsgame.proto.MSGPlayerMoveC2S.PlayerMoveC2S.getDefaultInstance();
      }

      public com.fsgame.proto.MSGPlayerMoveC2S.PlayerMoveC2S build() {
        com.fsgame.proto.MSGPlayerMoveC2S.PlayerMoveC2S result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public com.fsgame.proto.MSGPlayerMoveC2S.PlayerMoveC2S buildPartial() {
        com.fsgame.proto.MSGPlayerMoveC2S.PlayerMoveC2S result = new com.fsgame.proto.MSGPlayerMoveC2S.PlayerMoveC2S(this);
        if (movebaseBuilder_ == null) {
          result.movebase_ = movebase_;
        } else {
          result.movebase_ = movebaseBuilder_.build();
        }
        result.moveop_ = moveop_;
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
        if (other instanceof com.fsgame.proto.MSGPlayerMoveC2S.PlayerMoveC2S) {
          return mergeFrom((com.fsgame.proto.MSGPlayerMoveC2S.PlayerMoveC2S)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(com.fsgame.proto.MSGPlayerMoveC2S.PlayerMoveC2S other) {
        if (other == com.fsgame.proto.MSGPlayerMoveC2S.PlayerMoveC2S.getDefaultInstance()) return this;
        if (other.hasMovebase()) {
          mergeMovebase(other.getMovebase());
        }
        if (other.moveop_ != 0) {
          setMoveopValue(other.getMoveopValue());
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
        com.fsgame.proto.MSGPlayerMoveC2S.PlayerMoveC2S parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (com.fsgame.proto.MSGPlayerMoveC2S.PlayerMoveC2S) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private com.fsgame.proto.MSGPlayerCommon.PlayerCommon movebase_ = null;
      private com.google.protobuf.SingleFieldBuilderV3<
          com.fsgame.proto.MSGPlayerCommon.PlayerCommon, com.fsgame.proto.MSGPlayerCommon.PlayerCommon.Builder, com.fsgame.proto.MSGPlayerCommon.PlayerCommonOrBuilder> movebaseBuilder_;
      /**
       * <code>optional .Pro.PlayerCommon movebase = 1;</code>
       */
      public boolean hasMovebase() {
        return movebaseBuilder_ != null || movebase_ != null;
      }
      /**
       * <code>optional .Pro.PlayerCommon movebase = 1;</code>
       */
      public com.fsgame.proto.MSGPlayerCommon.PlayerCommon getMovebase() {
        if (movebaseBuilder_ == null) {
          return movebase_ == null ? com.fsgame.proto.MSGPlayerCommon.PlayerCommon.getDefaultInstance() : movebase_;
        } else {
          return movebaseBuilder_.getMessage();
        }
      }
      /**
       * <code>optional .Pro.PlayerCommon movebase = 1;</code>
       */
      public Builder setMovebase(com.fsgame.proto.MSGPlayerCommon.PlayerCommon value) {
        if (movebaseBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          movebase_ = value;
          onChanged();
        } else {
          movebaseBuilder_.setMessage(value);
        }

        return this;
      }
      /**
       * <code>optional .Pro.PlayerCommon movebase = 1;</code>
       */
      public Builder setMovebase(
          com.fsgame.proto.MSGPlayerCommon.PlayerCommon.Builder builderForValue) {
        if (movebaseBuilder_ == null) {
          movebase_ = builderForValue.build();
          onChanged();
        } else {
          movebaseBuilder_.setMessage(builderForValue.build());
        }

        return this;
      }
      /**
       * <code>optional .Pro.PlayerCommon movebase = 1;</code>
       */
      public Builder mergeMovebase(com.fsgame.proto.MSGPlayerCommon.PlayerCommon value) {
        if (movebaseBuilder_ == null) {
          if (movebase_ != null) {
            movebase_ =
              com.fsgame.proto.MSGPlayerCommon.PlayerCommon.newBuilder(movebase_).mergeFrom(value).buildPartial();
          } else {
            movebase_ = value;
          }
          onChanged();
        } else {
          movebaseBuilder_.mergeFrom(value);
        }

        return this;
      }
      /**
       * <code>optional .Pro.PlayerCommon movebase = 1;</code>
       */
      public Builder clearMovebase() {
        if (movebaseBuilder_ == null) {
          movebase_ = null;
          onChanged();
        } else {
          movebase_ = null;
          movebaseBuilder_ = null;
        }

        return this;
      }
      /**
       * <code>optional .Pro.PlayerCommon movebase = 1;</code>
       */
      public com.fsgame.proto.MSGPlayerCommon.PlayerCommon.Builder getMovebaseBuilder() {
        
        onChanged();
        return getMovebaseFieldBuilder().getBuilder();
      }
      /**
       * <code>optional .Pro.PlayerCommon movebase = 1;</code>
       */
      public com.fsgame.proto.MSGPlayerCommon.PlayerCommonOrBuilder getMovebaseOrBuilder() {
        if (movebaseBuilder_ != null) {
          return movebaseBuilder_.getMessageOrBuilder();
        } else {
          return movebase_ == null ?
              com.fsgame.proto.MSGPlayerCommon.PlayerCommon.getDefaultInstance() : movebase_;
        }
      }
      /**
       * <code>optional .Pro.PlayerCommon movebase = 1;</code>
       */
      private com.google.protobuf.SingleFieldBuilderV3<
          com.fsgame.proto.MSGPlayerCommon.PlayerCommon, com.fsgame.proto.MSGPlayerCommon.PlayerCommon.Builder, com.fsgame.proto.MSGPlayerCommon.PlayerCommonOrBuilder> 
          getMovebaseFieldBuilder() {
        if (movebaseBuilder_ == null) {
          movebaseBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
              com.fsgame.proto.MSGPlayerCommon.PlayerCommon, com.fsgame.proto.MSGPlayerCommon.PlayerCommon.Builder, com.fsgame.proto.MSGPlayerCommon.PlayerCommonOrBuilder>(
                  getMovebase(),
                  getParentForChildren(),
                  isClean());
          movebase_ = null;
        }
        return movebaseBuilder_;
      }

      private int moveop_ = 0;
      /**
       * <code>optional .Pro.MoveType moveop = 2;</code>
       */
      public int getMoveopValue() {
        return moveop_;
      }
      /**
       * <code>optional .Pro.MoveType moveop = 2;</code>
       */
      public Builder setMoveopValue(int value) {
        moveop_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional .Pro.MoveType moveop = 2;</code>
       */
      public com.fsgame.proto.MSGBaseCommon.MoveType getMoveop() {
        com.fsgame.proto.MSGBaseCommon.MoveType result = com.fsgame.proto.MSGBaseCommon.MoveType.valueOf(moveop_);
        return result == null ? com.fsgame.proto.MSGBaseCommon.MoveType.UNRECOGNIZED : result;
      }
      /**
       * <code>optional .Pro.MoveType moveop = 2;</code>
       */
      public Builder setMoveop(com.fsgame.proto.MSGBaseCommon.MoveType value) {
        if (value == null) {
          throw new NullPointerException();
        }
        
        moveop_ = value.getNumber();
        onChanged();
        return this;
      }
      /**
       * <code>optional .Pro.MoveType moveop = 2;</code>
       */
      public Builder clearMoveop() {
        
        moveop_ = 0;
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


      // @@protoc_insertion_point(builder_scope:Pro.PlayerMoveC2S)
    }

    // @@protoc_insertion_point(class_scope:Pro.PlayerMoveC2S)
    private static final com.fsgame.proto.MSGPlayerMoveC2S.PlayerMoveC2S DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new com.fsgame.proto.MSGPlayerMoveC2S.PlayerMoveC2S();
    }

    public static com.fsgame.proto.MSGPlayerMoveC2S.PlayerMoveC2S getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<PlayerMoveC2S>
        PARSER = new com.google.protobuf.AbstractParser<PlayerMoveC2S>() {
      public PlayerMoveC2S parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
          return new PlayerMoveC2S(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<PlayerMoveC2S> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<PlayerMoveC2S> getParserForType() {
      return PARSER;
    }

    public com.fsgame.proto.MSGPlayerMoveC2S.PlayerMoveC2S getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Pro_PlayerMoveC2S_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Pro_PlayerMoveC2S_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\023PlayerMoveC2S.proto\022\003Pro\032\022PlayerCommon" +
      ".proto\032\020BaseCommon.proto\"S\n\rPlayerMoveC2" +
      "S\022#\n\010movebase\030\001 \001(\0132\021.Pro.PlayerCommon\022\035" +
      "\n\006moveop\030\002 \001(\0162\r.Pro.MoveTypeB$\n\020com.fsg" +
      "ame.protoB\020MSGPlayerMoveC2Sb\006proto3"
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
          com.fsgame.proto.MSGPlayerCommon.getDescriptor(),
          com.fsgame.proto.MSGBaseCommon.getDescriptor(),
        }, assigner);
    internal_static_Pro_PlayerMoveC2S_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_Pro_PlayerMoveC2S_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Pro_PlayerMoveC2S_descriptor,
        new java.lang.String[] { "Movebase", "Moveop", });
    com.fsgame.proto.MSGPlayerCommon.getDescriptor();
    com.fsgame.proto.MSGBaseCommon.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
