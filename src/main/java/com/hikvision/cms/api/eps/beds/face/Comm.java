// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: comm.proto

package com.hikvision.cms.api.eps.beds.face;

public final class Comm {
  private Comm() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
  }
  public enum EventState
      implements com.google.protobuf.ProtocolMessageEnum {
    EVENT_STATE_INSTANT(0, 0),
    EVENT_STATE_START(1, 1),
    EVENT_STATE_STOP(2, 2),
    EVENT_STATE_PULSE(3, 3),
    EVENT_STATE_UPDATE(4, 4),
    ;
    
    
    public final int getNumber() { return value; }
    
    public static EventState valueOf(int value) {
      switch (value) {
        case 0: return EVENT_STATE_INSTANT;
        case 1: return EVENT_STATE_START;
        case 2: return EVENT_STATE_STOP;
        case 3: return EVENT_STATE_PULSE;
        case 4: return EVENT_STATE_UPDATE;
        default: return null;
      }
    }
    
    public static com.google.protobuf.Internal.EnumLiteMap<EventState>
        internalGetValueMap() {
      return internalValueMap;
    }
    private static com.google.protobuf.Internal.EnumLiteMap<EventState>
        internalValueMap =
          new com.google.protobuf.Internal.EnumLiteMap<EventState>() {
            public EventState findValueByNumber(int number) {
              return EventState.valueOf(number)
    ;        }
          };
    
    public final com.google.protobuf.Descriptors.EnumValueDescriptor
        getValueDescriptor() {
      return getDescriptor().getValues().get(index);
    }
    public final com.google.protobuf.Descriptors.EnumDescriptor
        getDescriptorForType() {
      return getDescriptor();
    }
    public static final com.google.protobuf.Descriptors.EnumDescriptor
        getDescriptor() {
      return com.hikvision.cms.api.eps.beds.face.Comm.getDescriptor().getEnumTypes().get(0);
    }
    
    private static final EventState[] VALUES = {
      EVENT_STATE_INSTANT, EVENT_STATE_START, EVENT_STATE_STOP, EVENT_STATE_PULSE, EVENT_STATE_UPDATE, 
    };
    public static EventState valueOf(
        com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
      if (desc.getType() != getDescriptor()) {
        throw new java.lang.IllegalArgumentException(
          "EnumValueDescriptor is not for this type.");
      }
      return VALUES[desc.getIndex()];
    }
    private final int index;
    private final int value;
    private EventState(int index, int value) {
      this.index = index;
      this.value = value;
    }
    
    static {
      com.hikvision.cms.api.eps.beds.face.Comm.getDescriptor();
    }
    
    // @@protoc_insertion_point(enum_scope:com.hikvision.cms.api.eps.beds.EventState)
  }
  
  public enum MsgCmdType
      implements com.google.protobuf.ProtocolMessageEnum {
    MSG_CMD_TYPE_MASK(0, 65280),
    MSG_CMD_MANUAL_EVENT(1, 257),
    MSG_CMD_CONFIRM_EVENT(2, 258),
    MSG_CMD_REPORT_EVENT(3, 513),
    MSG_CMD_SUBRECV_EVENT(4, 514),
    MSG_CMD_EVENT_NOTIFY_REQ(5, 769),
    MSG_CMD_EVENT_NOTIFY_RSP(6, 770),
    ;
    
    
    public final int getNumber() { return value; }
    
    public static MsgCmdType valueOf(int value) {
      switch (value) {
        case 65280: return MSG_CMD_TYPE_MASK;
        case 257: return MSG_CMD_MANUAL_EVENT;
        case 258: return MSG_CMD_CONFIRM_EVENT;
        case 513: return MSG_CMD_REPORT_EVENT;
        case 514: return MSG_CMD_SUBRECV_EVENT;
        case 769: return MSG_CMD_EVENT_NOTIFY_REQ;
        case 770: return MSG_CMD_EVENT_NOTIFY_RSP;
        default: return null;
      }
    }
    
    public static com.google.protobuf.Internal.EnumLiteMap<MsgCmdType>
        internalGetValueMap() {
      return internalValueMap;
    }
    private static com.google.protobuf.Internal.EnumLiteMap<MsgCmdType>
        internalValueMap =
          new com.google.protobuf.Internal.EnumLiteMap<MsgCmdType>() {
            public MsgCmdType findValueByNumber(int number) {
              return MsgCmdType.valueOf(number)
    ;        }
          };
    
    public final com.google.protobuf.Descriptors.EnumValueDescriptor
        getValueDescriptor() {
      return getDescriptor().getValues().get(index);
    }
    public final com.google.protobuf.Descriptors.EnumDescriptor
        getDescriptorForType() {
      return getDescriptor();
    }
    public static final com.google.protobuf.Descriptors.EnumDescriptor
        getDescriptor() {
      return com.hikvision.cms.api.eps.beds.face.Comm.getDescriptor().getEnumTypes().get(1);
    }
    
    private static final MsgCmdType[] VALUES = {
      MSG_CMD_TYPE_MASK, MSG_CMD_MANUAL_EVENT, MSG_CMD_CONFIRM_EVENT, MSG_CMD_REPORT_EVENT, MSG_CMD_SUBRECV_EVENT, MSG_CMD_EVENT_NOTIFY_REQ, MSG_CMD_EVENT_NOTIFY_RSP, 
    };
    public static MsgCmdType valueOf(
        com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
      if (desc.getType() != getDescriptor()) {
        throw new java.lang.IllegalArgumentException(
          "EnumValueDescriptor is not for this type.");
      }
      return VALUES[desc.getIndex()];
    }
    private final int index;
    private final int value;
    private MsgCmdType(int index, int value) {
      this.index = index;
      this.value = value;
    }
    
    static {
      com.hikvision.cms.api.eps.beds.face.Comm.getDescriptor();
    }
    
    // @@protoc_insertion_point(enum_scope:com.hikvision.cms.api.eps.beds.MsgCmdType)
  }
  
  public static final class TriggerResult extends
      com.google.protobuf.GeneratedMessage {
    // Use TriggerResult.newBuilder() to construct.
    private TriggerResult() {
      initFields();
    }
    private TriggerResult(boolean noInit) {}
    
    private static final TriggerResult defaultInstance;
    public static TriggerResult getDefaultInstance() {
      return defaultInstance;
    }
    
    public TriggerResult getDefaultInstanceForType() {
      return defaultInstance;
    }
    
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.hikvision.cms.api.eps.beds.face.Comm.internal_static_com_hikvision_cms_api_eps_beds_TriggerResult_descriptor;
    }
    
    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.hikvision.cms.api.eps.beds.face.Comm.internal_static_com_hikvision_cms_api_eps_beds_TriggerResult_fieldAccessorTable;
    }
    
    // required int32 trigger_type = 1;
    public static final int TRIGGER_TYPE_FIELD_NUMBER = 1;
    private boolean hasTriggerType;
    private int triggerType_ = 0;
    public boolean hasTriggerType() { return hasTriggerType; }
    public int getTriggerType() { return triggerType_; }
    
    // repeated int32 trigger_ret = 2;
    public static final int TRIGGER_RET_FIELD_NUMBER = 2;
    private java.util.List<java.lang.Integer> triggerRet_ =
      java.util.Collections.emptyList();
    public java.util.List<java.lang.Integer> getTriggerRetList() {
      return triggerRet_;
    }
    public int getTriggerRetCount() { return triggerRet_.size(); }
    public int getTriggerRet(int index) {
      return triggerRet_.get(index);
    }
    
    // required string trigger_time = 3;
    public static final int TRIGGER_TIME_FIELD_NUMBER = 3;
    private boolean hasTriggerTime;
    private java.lang.String triggerTime_ = "";
    public boolean hasTriggerTime() { return hasTriggerTime; }
    public java.lang.String getTriggerTime() { return triggerTime_; }
    
    // optional string trigger_info = 33;
    public static final int TRIGGER_INFO_FIELD_NUMBER = 33;
    private boolean hasTriggerInfo;
    private java.lang.String triggerInfo_ = "";
    public boolean hasTriggerInfo() { return hasTriggerInfo; }
    public java.lang.String getTriggerInfo() { return triggerInfo_; }
    
    // optional string err_msg = 34;
    public static final int ERR_MSG_FIELD_NUMBER = 34;
    private boolean hasErrMsg;
    private java.lang.String errMsg_ = "";
    public boolean hasErrMsg() { return hasErrMsg; }
    public java.lang.String getErrMsg() { return errMsg_; }
    
    private void initFields() {
    }
    public final boolean isInitialized() {
      if (!hasTriggerType) return false;
      if (!hasTriggerTime) return false;
      return true;
    }
    
    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      getSerializedSize();
      if (hasTriggerType()) {
        output.writeInt32(1, getTriggerType());
      }
      for (int element : getTriggerRetList()) {
        output.writeInt32(2, element);
      }
      if (hasTriggerTime()) {
        output.writeString(3, getTriggerTime());
      }
      if (hasTriggerInfo()) {
        output.writeString(33, getTriggerInfo());
      }
      if (hasErrMsg()) {
        output.writeString(34, getErrMsg());
      }
      getUnknownFields().writeTo(output);
    }
    
    private int memoizedSerializedSize = -1;
    public int getSerializedSize() {
      int size = memoizedSerializedSize;
      if (size != -1) return size;
    
      size = 0;
      if (hasTriggerType()) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(1, getTriggerType());
      }
      {
        int dataSize = 0;
        for (int element : getTriggerRetList()) {
          dataSize += com.google.protobuf.CodedOutputStream
            .computeInt32SizeNoTag(element);
        }
        size += dataSize;
        size += 1 * getTriggerRetList().size();
      }
      if (hasTriggerTime()) {
        size += com.google.protobuf.CodedOutputStream
          .computeStringSize(3, getTriggerTime());
      }
      if (hasTriggerInfo()) {
        size += com.google.protobuf.CodedOutputStream
          .computeStringSize(33, getTriggerInfo());
      }
      if (hasErrMsg()) {
        size += com.google.protobuf.CodedOutputStream
          .computeStringSize(34, getErrMsg());
      }
      size += getUnknownFields().getSerializedSize();
      memoizedSerializedSize = size;
      return size;
    }
    
    public static com.hikvision.cms.api.eps.beds.face.Comm.TriggerResult parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return newBuilder().mergeFrom(data).buildParsed();
    }
    public static com.hikvision.cms.api.eps.beds.face.Comm.TriggerResult parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return newBuilder().mergeFrom(data, extensionRegistry)
               .buildParsed();
    }
    public static com.hikvision.cms.api.eps.beds.face.Comm.TriggerResult parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return newBuilder().mergeFrom(data).buildParsed();
    }
    public static com.hikvision.cms.api.eps.beds.face.Comm.TriggerResult parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return newBuilder().mergeFrom(data, extensionRegistry)
               .buildParsed();
    }
    public static com.hikvision.cms.api.eps.beds.face.Comm.TriggerResult parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return newBuilder().mergeFrom(input).buildParsed();
    }
    public static com.hikvision.cms.api.eps.beds.face.Comm.TriggerResult parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return newBuilder().mergeFrom(input, extensionRegistry)
               .buildParsed();
    }
    public static com.hikvision.cms.api.eps.beds.face.Comm.TriggerResult parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      Builder builder = newBuilder();
      if (builder.mergeDelimitedFrom(input)) {
        return builder.buildParsed();
      } else {
        return null;
      }
    }
    public static com.hikvision.cms.api.eps.beds.face.Comm.TriggerResult parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      Builder builder = newBuilder();
      if (builder.mergeDelimitedFrom(input, extensionRegistry)) {
        return builder.buildParsed();
      } else {
        return null;
      }
    }
    public static com.hikvision.cms.api.eps.beds.face.Comm.TriggerResult parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return newBuilder().mergeFrom(input).buildParsed();
    }
    public static com.hikvision.cms.api.eps.beds.face.Comm.TriggerResult parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return newBuilder().mergeFrom(input, extensionRegistry)
               .buildParsed();
    }
    
    public static Builder newBuilder() { return Builder.create(); }
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder(com.hikvision.cms.api.eps.beds.face.Comm.TriggerResult prototype) {
      return newBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() { return newBuilder(this); }
    
    public static final class Builder extends
        com.google.protobuf.GeneratedMessage.Builder<Builder> {
      private com.hikvision.cms.api.eps.beds.face.Comm.TriggerResult result;
      
      // Construct using com.hikvision.cms.api.eps.beds.Comm.TriggerResult.newBuilder()
      private Builder() {}
      
      private static Builder create() {
        Builder builder = new Builder();
        builder.result = new com.hikvision.cms.api.eps.beds.face.Comm.TriggerResult();
        return builder;
      }
      
      protected com.hikvision.cms.api.eps.beds.face.Comm.TriggerResult internalGetResult() {
        return result;
      }
      
      public Builder clear() {
        if (result == null) {
          throw new IllegalStateException(
            "Cannot call clear() after build().");
        }
        result = new com.hikvision.cms.api.eps.beds.face.Comm.TriggerResult();
        return this;
      }
      
      public Builder clone() {
        return create().mergeFrom(result);
      }
      
      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return com.hikvision.cms.api.eps.beds.face.Comm.TriggerResult.getDescriptor();
      }
      
      public com.hikvision.cms.api.eps.beds.face.Comm.TriggerResult getDefaultInstanceForType() {
        return com.hikvision.cms.api.eps.beds.face.Comm.TriggerResult.getDefaultInstance();
      }
      
      public boolean isInitialized() {
        return result.isInitialized();
      }
      public com.hikvision.cms.api.eps.beds.face.Comm.TriggerResult build() {
        if (result != null && !isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return buildPartial();
      }
      
      private com.hikvision.cms.api.eps.beds.face.Comm.TriggerResult buildParsed()
          throws com.google.protobuf.InvalidProtocolBufferException {
        if (!isInitialized()) {
          throw newUninitializedMessageException(
            result).asInvalidProtocolBufferException();
        }
        return buildPartial();
      }
      
      public com.hikvision.cms.api.eps.beds.face.Comm.TriggerResult buildPartial() {
        if (result == null) {
          throw new IllegalStateException(
            "build() has already been called on this Builder.");
        }
        if (result.triggerRet_ != java.util.Collections.EMPTY_LIST) {
          result.triggerRet_ =
            java.util.Collections.unmodifiableList(result.triggerRet_);
        }
        com.hikvision.cms.api.eps.beds.face.Comm.TriggerResult returnMe = result;
        result = null;
        return returnMe;
      }
      
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof com.hikvision.cms.api.eps.beds.face.Comm.TriggerResult) {
          return mergeFrom((com.hikvision.cms.api.eps.beds.face.Comm.TriggerResult)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }
      
      public Builder mergeFrom(com.hikvision.cms.api.eps.beds.face.Comm.TriggerResult other) {
        if (other == com.hikvision.cms.api.eps.beds.face.Comm.TriggerResult.getDefaultInstance()) return this;
        if (other.hasTriggerType()) {
          setTriggerType(other.getTriggerType());
        }
        if (!other.triggerRet_.isEmpty()) {
          if (result.triggerRet_.isEmpty()) {
            result.triggerRet_ = new java.util.ArrayList<java.lang.Integer>();
          }
          result.triggerRet_.addAll(other.triggerRet_);
        }
        if (other.hasTriggerTime()) {
          setTriggerTime(other.getTriggerTime());
        }
        if (other.hasTriggerInfo()) {
          setTriggerInfo(other.getTriggerInfo());
        }
        if (other.hasErrMsg()) {
          setErrMsg(other.getErrMsg());
        }
        this.mergeUnknownFields(other.getUnknownFields());
        return this;
      }
      
      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        com.google.protobuf.UnknownFieldSet.Builder unknownFields =
          com.google.protobuf.UnknownFieldSet.newBuilder(
            this.getUnknownFields());
        while (true) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              this.setUnknownFields(unknownFields.build());
              return this;
            default: {
              if (!parseUnknownField(input, unknownFields,
                                     extensionRegistry, tag)) {
                this.setUnknownFields(unknownFields.build());
                return this;
              }
              break;
            }
            case 8: {
              setTriggerType(input.readInt32());
              break;
            }
            case 16: {
              addTriggerRet(input.readInt32());
              break;
            }
            case 18: {
              int length = input.readRawVarint32();
              int limit = input.pushLimit(length);
              while (input.getBytesUntilLimit() > 0) {
                addTriggerRet(input.readInt32());
              }
              input.popLimit(limit);
              break;
            }
            case 26: {
              setTriggerTime(input.readString());
              break;
            }
            case 266: {
              setTriggerInfo(input.readString());
              break;
            }
            case 274: {
              setErrMsg(input.readString());
              break;
            }
          }
        }
      }
      
      
      // required int32 trigger_type = 1;
      public boolean hasTriggerType() {
        return result.hasTriggerType();
      }
      public int getTriggerType() {
        return result.getTriggerType();
      }
      public Builder setTriggerType(int value) {
        result.hasTriggerType = true;
        result.triggerType_ = value;
        return this;
      }
      public Builder clearTriggerType() {
        result.hasTriggerType = false;
        result.triggerType_ = 0;
        return this;
      }
      
      // repeated int32 trigger_ret = 2;
      public java.util.List<java.lang.Integer> getTriggerRetList() {
        return java.util.Collections.unmodifiableList(result.triggerRet_);
      }
      public int getTriggerRetCount() {
        return result.getTriggerRetCount();
      }
      public int getTriggerRet(int index) {
        return result.getTriggerRet(index);
      }
      public Builder setTriggerRet(int index, int value) {
        result.triggerRet_.set(index, value);
        return this;
      }
      public Builder addTriggerRet(int value) {
        if (result.triggerRet_.isEmpty()) {
          result.triggerRet_ = new java.util.ArrayList<java.lang.Integer>();
        }
        result.triggerRet_.add(value);
        return this;
      }
      public Builder addAllTriggerRet(
          java.lang.Iterable<? extends java.lang.Integer> values) {
        if (result.triggerRet_.isEmpty()) {
          result.triggerRet_ = new java.util.ArrayList<java.lang.Integer>();
        }
        super.addAll(values, result.triggerRet_);
        return this;
      }
      public Builder clearTriggerRet() {
        result.triggerRet_ = java.util.Collections.emptyList();
        return this;
      }
      
      // required string trigger_time = 3;
      public boolean hasTriggerTime() {
        return result.hasTriggerTime();
      }
      public java.lang.String getTriggerTime() {
        return result.getTriggerTime();
      }
      public Builder setTriggerTime(java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  result.hasTriggerTime = true;
        result.triggerTime_ = value;
        return this;
      }
      public Builder clearTriggerTime() {
        result.hasTriggerTime = false;
        result.triggerTime_ = getDefaultInstance().getTriggerTime();
        return this;
      }
      
      // optional string trigger_info = 33;
      public boolean hasTriggerInfo() {
        return result.hasTriggerInfo();
      }
      public java.lang.String getTriggerInfo() {
        return result.getTriggerInfo();
      }
      public Builder setTriggerInfo(java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  result.hasTriggerInfo = true;
        result.triggerInfo_ = value;
        return this;
      }
      public Builder clearTriggerInfo() {
        result.hasTriggerInfo = false;
        result.triggerInfo_ = getDefaultInstance().getTriggerInfo();
        return this;
      }
      
      // optional string err_msg = 34;
      public boolean hasErrMsg() {
        return result.hasErrMsg();
      }
      public java.lang.String getErrMsg() {
        return result.getErrMsg();
      }
      public Builder setErrMsg(java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  result.hasErrMsg = true;
        result.errMsg_ = value;
        return this;
      }
      public Builder clearErrMsg() {
        result.hasErrMsg = false;
        result.errMsg_ = getDefaultInstance().getErrMsg();
        return this;
      }
      
      // @@protoc_insertion_point(builder_scope:com.hikvision.cms.api.eps.beds.TriggerResult)
    }
    
    static {
      defaultInstance = new TriggerResult(true);
      com.hikvision.cms.api.eps.beds.face.Comm.internalForceInit();
      defaultInstance.initFields();
    }
    
    // @@protoc_insertion_point(class_scope:com.hikvision.cms.api.eps.beds.TriggerResult)
  }
  
  public static final class CommEventTrig extends
      com.google.protobuf.GeneratedMessage {
    // Use CommEventTrig.newBuilder() to construct.
    private CommEventTrig() {
      initFields();
    }
    private CommEventTrig(boolean noInit) {}
    
    private static final CommEventTrig defaultInstance;
    public static CommEventTrig getDefaultInstance() {
      return defaultInstance;
    }
    
    public CommEventTrig getDefaultInstanceForType() {
      return defaultInstance;
    }
    
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.hikvision.cms.api.eps.beds.face.Comm.internal_static_com_hikvision_cms_api_eps_beds_CommEventTrig_descriptor;
    }
    
    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.hikvision.cms.api.eps.beds.face.Comm.internal_static_com_hikvision_cms_api_eps_beds_CommEventTrig_fieldAccessorTable;
    }
    
    // required int32 trigger_type = 1;
    public static final int TRIGGER_TYPE_FIELD_NUMBER = 1;
    private boolean hasTriggerType;
    private int triggerType_ = 0;
    public boolean hasTriggerType() { return hasTriggerType; }
    public int getTriggerType() { return triggerType_; }
    
    // required bytes trigger_info = 2;
    public static final int TRIGGER_INFO_FIELD_NUMBER = 2;
    private boolean hasTriggerInfo;
    private com.google.protobuf.ByteString triggerInfo_ = com.google.protobuf.ByteString.EMPTY;
    public boolean hasTriggerInfo() { return hasTriggerInfo; }
    public com.google.protobuf.ByteString getTriggerInfo() { return triggerInfo_; }
    
    private void initFields() {
    }
    public final boolean isInitialized() {
      if (!hasTriggerType) return false;
      if (!hasTriggerInfo) return false;
      return true;
    }
    
    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      getSerializedSize();
      if (hasTriggerType()) {
        output.writeInt32(1, getTriggerType());
      }
      if (hasTriggerInfo()) {
        output.writeBytes(2, getTriggerInfo());
      }
      getUnknownFields().writeTo(output);
    }
    
    private int memoizedSerializedSize = -1;
    public int getSerializedSize() {
      int size = memoizedSerializedSize;
      if (size != -1) return size;
    
      size = 0;
      if (hasTriggerType()) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(1, getTriggerType());
      }
      if (hasTriggerInfo()) {
        size += com.google.protobuf.CodedOutputStream
          .computeBytesSize(2, getTriggerInfo());
      }
      size += getUnknownFields().getSerializedSize();
      memoizedSerializedSize = size;
      return size;
    }
    
    public static com.hikvision.cms.api.eps.beds.face.Comm.CommEventTrig parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return newBuilder().mergeFrom(data).buildParsed();
    }
    public static com.hikvision.cms.api.eps.beds.face.Comm.CommEventTrig parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return newBuilder().mergeFrom(data, extensionRegistry)
               .buildParsed();
    }
    public static com.hikvision.cms.api.eps.beds.face.Comm.CommEventTrig parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return newBuilder().mergeFrom(data).buildParsed();
    }
    public static com.hikvision.cms.api.eps.beds.face.Comm.CommEventTrig parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return newBuilder().mergeFrom(data, extensionRegistry)
               .buildParsed();
    }
    public static com.hikvision.cms.api.eps.beds.face.Comm.CommEventTrig parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return newBuilder().mergeFrom(input).buildParsed();
    }
    public static com.hikvision.cms.api.eps.beds.face.Comm.CommEventTrig parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return newBuilder().mergeFrom(input, extensionRegistry)
               .buildParsed();
    }
    public static com.hikvision.cms.api.eps.beds.face.Comm.CommEventTrig parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      Builder builder = newBuilder();
      if (builder.mergeDelimitedFrom(input)) {
        return builder.buildParsed();
      } else {
        return null;
      }
    }
    public static com.hikvision.cms.api.eps.beds.face.Comm.CommEventTrig parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      Builder builder = newBuilder();
      if (builder.mergeDelimitedFrom(input, extensionRegistry)) {
        return builder.buildParsed();
      } else {
        return null;
      }
    }
    public static com.hikvision.cms.api.eps.beds.face.Comm.CommEventTrig parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return newBuilder().mergeFrom(input).buildParsed();
    }
    public static com.hikvision.cms.api.eps.beds.face.Comm.CommEventTrig parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return newBuilder().mergeFrom(input, extensionRegistry)
               .buildParsed();
    }
    
    public static Builder newBuilder() { return Builder.create(); }
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder(com.hikvision.cms.api.eps.beds.face.Comm.CommEventTrig prototype) {
      return newBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() { return newBuilder(this); }
    
    public static final class Builder extends
        com.google.protobuf.GeneratedMessage.Builder<Builder> {
      private com.hikvision.cms.api.eps.beds.face.Comm.CommEventTrig result;
      
      // Construct using com.hikvision.cms.api.eps.beds.Comm.CommEventTrig.newBuilder()
      private Builder() {}
      
      private static Builder create() {
        Builder builder = new Builder();
        builder.result = new com.hikvision.cms.api.eps.beds.face.Comm.CommEventTrig();
        return builder;
      }
      
      protected com.hikvision.cms.api.eps.beds.face.Comm.CommEventTrig internalGetResult() {
        return result;
      }
      
      public Builder clear() {
        if (result == null) {
          throw new IllegalStateException(
            "Cannot call clear() after build().");
        }
        result = new com.hikvision.cms.api.eps.beds.face.Comm.CommEventTrig();
        return this;
      }
      
      public Builder clone() {
        return create().mergeFrom(result);
      }
      
      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return com.hikvision.cms.api.eps.beds.face.Comm.CommEventTrig.getDescriptor();
      }
      
      public com.hikvision.cms.api.eps.beds.face.Comm.CommEventTrig getDefaultInstanceForType() {
        return com.hikvision.cms.api.eps.beds.face.Comm.CommEventTrig.getDefaultInstance();
      }
      
      public boolean isInitialized() {
        return result.isInitialized();
      }
      public com.hikvision.cms.api.eps.beds.face.Comm.CommEventTrig build() {
        if (result != null && !isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return buildPartial();
      }
      
      private com.hikvision.cms.api.eps.beds.face.Comm.CommEventTrig buildParsed()
          throws com.google.protobuf.InvalidProtocolBufferException {
        if (!isInitialized()) {
          throw newUninitializedMessageException(
            result).asInvalidProtocolBufferException();
        }
        return buildPartial();
      }
      
      public com.hikvision.cms.api.eps.beds.face.Comm.CommEventTrig buildPartial() {
        if (result == null) {
          throw new IllegalStateException(
            "build() has already been called on this Builder.");
        }
        com.hikvision.cms.api.eps.beds.face.Comm.CommEventTrig returnMe = result;
        result = null;
        return returnMe;
      }
      
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof com.hikvision.cms.api.eps.beds.face.Comm.CommEventTrig) {
          return mergeFrom((com.hikvision.cms.api.eps.beds.face.Comm.CommEventTrig)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }
      
      public Builder mergeFrom(com.hikvision.cms.api.eps.beds.face.Comm.CommEventTrig other) {
        if (other == com.hikvision.cms.api.eps.beds.face.Comm.CommEventTrig.getDefaultInstance()) return this;
        if (other.hasTriggerType()) {
          setTriggerType(other.getTriggerType());
        }
        if (other.hasTriggerInfo()) {
          setTriggerInfo(other.getTriggerInfo());
        }
        this.mergeUnknownFields(other.getUnknownFields());
        return this;
      }
      
      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        com.google.protobuf.UnknownFieldSet.Builder unknownFields =
          com.google.protobuf.UnknownFieldSet.newBuilder(
            this.getUnknownFields());
        while (true) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              this.setUnknownFields(unknownFields.build());
              return this;
            default: {
              if (!parseUnknownField(input, unknownFields,
                                     extensionRegistry, tag)) {
                this.setUnknownFields(unknownFields.build());
                return this;
              }
              break;
            }
            case 8: {
              setTriggerType(input.readInt32());
              break;
            }
            case 18: {
              setTriggerInfo(input.readBytes());
              break;
            }
          }
        }
      }
      
      
      // required int32 trigger_type = 1;
      public boolean hasTriggerType() {
        return result.hasTriggerType();
      }
      public int getTriggerType() {
        return result.getTriggerType();
      }
      public Builder setTriggerType(int value) {
        result.hasTriggerType = true;
        result.triggerType_ = value;
        return this;
      }
      public Builder clearTriggerType() {
        result.hasTriggerType = false;
        result.triggerType_ = 0;
        return this;
      }
      
      // required bytes trigger_info = 2;
      public boolean hasTriggerInfo() {
        return result.hasTriggerInfo();
      }
      public com.google.protobuf.ByteString getTriggerInfo() {
        return result.getTriggerInfo();
      }
      public Builder setTriggerInfo(com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  result.hasTriggerInfo = true;
        result.triggerInfo_ = value;
        return this;
      }
      public Builder clearTriggerInfo() {
        result.hasTriggerInfo = false;
        result.triggerInfo_ = getDefaultInstance().getTriggerInfo();
        return this;
      }
      
      // @@protoc_insertion_point(builder_scope:com.hikvision.cms.api.eps.beds.CommEventTrig)
    }
    
    static {
      defaultInstance = new CommEventTrig(true);
      com.hikvision.cms.api.eps.beds.face.Comm.internalForceInit();
      defaultInstance.initFields();
    }
    
    // @@protoc_insertion_point(class_scope:com.hikvision.cms.api.eps.beds.CommEventTrig)
  }
  
  private static com.google.protobuf.Descriptors.Descriptor
    internal_static_com_hikvision_cms_api_eps_beds_TriggerResult_descriptor;
  private static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_com_hikvision_cms_api_eps_beds_TriggerResult_fieldAccessorTable;
  private static com.google.protobuf.Descriptors.Descriptor
    internal_static_com_hikvision_cms_api_eps_beds_CommEventTrig_descriptor;
  private static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_com_hikvision_cms_api_eps_beds_CommEventTrig_fieldAccessorTable;
  
  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\ncomm.proto\022\036com.hikvision.cms.api.eps." +
      "beds\"w\n\rTriggerResult\022\024\n\014trigger_type\030\001 " +
      "\002(\005\022\023\n\013trigger_ret\030\002 \003(\005\022\024\n\014trigger_time" +
      "\030\003 \002(\t\022\024\n\014trigger_info\030! \001(\t\022\017\n\007err_msg\030" +
      "\" \001(\t\";\n\rCommEventTrig\022\024\n\014trigger_type\030\001" +
      " \002(\005\022\024\n\014trigger_info\030\002 \002(\014*\201\001\n\nEventStat" +
      "e\022\027\n\023EVENT_STATE_INSTANT\020\000\022\025\n\021EVENT_STAT" +
      "E_START\020\001\022\024\n\020EVENT_STATE_STOP\020\002\022\025\n\021EVENT" +
      "_STATE_PULSE\020\003\022\026\n\022EVENT_STATE_UPDATE\020\004*\321" +
      "\001\n\nMsgCmdType\022\027\n\021MSG_CMD_TYPE_MASK\020\200\376\003\022\031",
      "\n\024MSG_CMD_MANUAL_EVENT\020\201\002\022\032\n\025MSG_CMD_CON" +
      "FIRM_EVENT\020\202\002\022\031\n\024MSG_CMD_REPORT_EVENT\020\201\004" +
      "\022\032\n\025MSG_CMD_SUBRECV_EVENT\020\202\004\022\035\n\030MSG_CMD_" +
      "EVENT_NOTIFY_REQ\020\201\006\022\035\n\030MSG_CMD_EVENT_NOT" +
      "IFY_RSP\020\202\006"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
      new com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner() {
        public com.google.protobuf.ExtensionRegistry assignDescriptors(
            com.google.protobuf.Descriptors.FileDescriptor root) {
          descriptor = root;
          internal_static_com_hikvision_cms_api_eps_beds_TriggerResult_descriptor =
            getDescriptor().getMessageTypes().get(0);
          internal_static_com_hikvision_cms_api_eps_beds_TriggerResult_fieldAccessorTable = new
            com.google.protobuf.GeneratedMessage.FieldAccessorTable(
              internal_static_com_hikvision_cms_api_eps_beds_TriggerResult_descriptor,
              new java.lang.String[] { "TriggerType", "TriggerRet", "TriggerTime", "TriggerInfo", "ErrMsg", },
              com.hikvision.cms.api.eps.beds.face.Comm.TriggerResult.class,
              com.hikvision.cms.api.eps.beds.face.Comm.TriggerResult.Builder.class);
          internal_static_com_hikvision_cms_api_eps_beds_CommEventTrig_descriptor =
            getDescriptor().getMessageTypes().get(1);
          internal_static_com_hikvision_cms_api_eps_beds_CommEventTrig_fieldAccessorTable = new
            com.google.protobuf.GeneratedMessage.FieldAccessorTable(
              internal_static_com_hikvision_cms_api_eps_beds_CommEventTrig_descriptor,
              new java.lang.String[] { "TriggerType", "TriggerInfo", },
              com.hikvision.cms.api.eps.beds.face.Comm.CommEventTrig.class,
              com.hikvision.cms.api.eps.beds.face.Comm.CommEventTrig.Builder.class);
          return null;
        }
      };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
  }
  
  public static void internalForceInit() {}
  
  // @@protoc_insertion_point(outer_class_scope)
}
