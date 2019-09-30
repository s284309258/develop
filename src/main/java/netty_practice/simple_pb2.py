# -*- coding: utf-8 -*-
# Generated by the protocol buffer compiler.  DO NOT EDIT!
# source: netty_studio/simple.proto

import sys
_b=sys.version_info[0]<3 and (lambda x:x) or (lambda x:x.encode('latin1'))
from google.protobuf import descriptor as _descriptor
from google.protobuf import message as _message
from google.protobuf import reflection as _reflection
from google.protobuf import symbol_database as _symbol_database
# @@protoc_insertion_point(imports)

_sym_db = _symbol_database.Default()




DESCRIPTOR = _descriptor.FileDescriptor(
  name='netty_studio/simple.proto',
  package='netty_studio',
  syntax='proto2',
  serialized_options=_b('\n\006protosB\014proto_simple'),
  serialized_pb=_b('\n\x19netty_studio/simple.proto\x12\x0cnetty_studio\"\x82\x02\n\x08MySimple\x12\x32\n\tdata_type\x18\x01 \x02(\x0e\x32\x1f.netty_studio.MySimple.DataType\x12\"\n\x02s1\x18\x02 \x01(\x0b\x32\x14.netty_studio.simpleH\x00\x12&\n\x02s2\x18\x03 \x01(\x0b\x32\x18.netty_studio.simple_no1H\x00\x12&\n\x02s3\x18\x04 \x01(\x0b\x32\x18.netty_studio.simple_no2H\x00\"B\n\x08\x44\x61taType\x12\x0e\n\nsimpleType\x10\x01\x12\x12\n\x0esimple_no1Type\x10\x02\x12\x12\n\x0esimple_no2Type\x10\x03\x42\n\n\x08\x64\x61taBody\"4\n\x06simple\x12\x0c\n\x04name\x18\x01 \x01(\t\x12\x0f\n\x07\x61\x64\x64ress\x18\x02 \x01(\t\x12\x0b\n\x03\x61ge\x18\x03 \x01(\x05\"+\n\nsimple_no1\x12\x0c\n\x04name\x18\x01 \x01(\t\x12\x0f\n\x07\x61\x64\x64ress\x18\x02 \x01(\t\"L\n\nsimple_no2\x12\r\n\x05mytel\x18\x01 \x01(\t\x12\x0c\n\x04name\x18\x02 \x01(\t\x12\x0f\n\x07\x61\x64\x64ress\x18\x03 \x01(\t\x12\x10\n\x08myheight\x18\x04 \x01(\tB\x16\n\x06protosB\x0cproto_simple')
)



_MYSIMPLE_DATATYPE = _descriptor.EnumDescriptor(
  name='DataType',
  full_name='netty_studio.MySimple.DataType',
  filename=None,
  file=DESCRIPTOR,
  values=[
    _descriptor.EnumValueDescriptor(
      name='simpleType', index=0, number=1,
      serialized_options=None,
      type=None),
    _descriptor.EnumValueDescriptor(
      name='simple_no1Type', index=1, number=2,
      serialized_options=None,
      type=None),
    _descriptor.EnumValueDescriptor(
      name='simple_no2Type', index=2, number=3,
      serialized_options=None,
      type=None),
  ],
  containing_type=None,
  serialized_options=None,
  serialized_start=224,
  serialized_end=290,
)
_sym_db.RegisterEnumDescriptor(_MYSIMPLE_DATATYPE)


_MYSIMPLE = _descriptor.Descriptor(
  name='MySimple',
  full_name='netty_studio.MySimple',
  filename=None,
  file=DESCRIPTOR,
  containing_type=None,
  fields=[
    _descriptor.FieldDescriptor(
      name='data_type', full_name='netty_studio.MySimple.data_type', index=0,
      number=1, type=14, cpp_type=8, label=2,
      has_default_value=False, default_value=1,
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR),
    _descriptor.FieldDescriptor(
      name='s1', full_name='netty_studio.MySimple.s1', index=1,
      number=2, type=11, cpp_type=10, label=1,
      has_default_value=False, default_value=None,
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR),
    _descriptor.FieldDescriptor(
      name='s2', full_name='netty_studio.MySimple.s2', index=2,
      number=3, type=11, cpp_type=10, label=1,
      has_default_value=False, default_value=None,
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR),
    _descriptor.FieldDescriptor(
      name='s3', full_name='netty_studio.MySimple.s3', index=3,
      number=4, type=11, cpp_type=10, label=1,
      has_default_value=False, default_value=None,
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR),
  ],
  extensions=[
  ],
  nested_types=[],
  enum_types=[
    _MYSIMPLE_DATATYPE,
  ],
  serialized_options=None,
  is_extendable=False,
  syntax='proto2',
  extension_ranges=[],
  oneofs=[
    _descriptor.OneofDescriptor(
      name='dataBody', full_name='netty_studio.MySimple.dataBody',
      index=0, containing_type=None, fields=[]),
  ],
  serialized_start=44,
  serialized_end=302,
)


_SIMPLE = _descriptor.Descriptor(
  name='simple',
  full_name='netty_studio.simple',
  filename=None,
  file=DESCRIPTOR,
  containing_type=None,
  fields=[
    _descriptor.FieldDescriptor(
      name='name', full_name='netty_studio.simple.name', index=0,
      number=1, type=9, cpp_type=9, label=1,
      has_default_value=False, default_value=_b("").decode('utf-8'),
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR),
    _descriptor.FieldDescriptor(
      name='address', full_name='netty_studio.simple.address', index=1,
      number=2, type=9, cpp_type=9, label=1,
      has_default_value=False, default_value=_b("").decode('utf-8'),
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR),
    _descriptor.FieldDescriptor(
      name='age', full_name='netty_studio.simple.age', index=2,
      number=3, type=5, cpp_type=1, label=1,
      has_default_value=False, default_value=0,
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR),
  ],
  extensions=[
  ],
  nested_types=[],
  enum_types=[
  ],
  serialized_options=None,
  is_extendable=False,
  syntax='proto2',
  extension_ranges=[],
  oneofs=[
  ],
  serialized_start=304,
  serialized_end=356,
)


_SIMPLE_NO1 = _descriptor.Descriptor(
  name='simple_no1',
  full_name='netty_studio.simple_no1',
  filename=None,
  file=DESCRIPTOR,
  containing_type=None,
  fields=[
    _descriptor.FieldDescriptor(
      name='name', full_name='netty_studio.simple_no1.name', index=0,
      number=1, type=9, cpp_type=9, label=1,
      has_default_value=False, default_value=_b("").decode('utf-8'),
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR),
    _descriptor.FieldDescriptor(
      name='address', full_name='netty_studio.simple_no1.address', index=1,
      number=2, type=9, cpp_type=9, label=1,
      has_default_value=False, default_value=_b("").decode('utf-8'),
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR),
  ],
  extensions=[
  ],
  nested_types=[],
  enum_types=[
  ],
  serialized_options=None,
  is_extendable=False,
  syntax='proto2',
  extension_ranges=[],
  oneofs=[
  ],
  serialized_start=358,
  serialized_end=401,
)


_SIMPLE_NO2 = _descriptor.Descriptor(
  name='simple_no2',
  full_name='netty_studio.simple_no2',
  filename=None,
  file=DESCRIPTOR,
  containing_type=None,
  fields=[
    _descriptor.FieldDescriptor(
      name='mytel', full_name='netty_studio.simple_no2.mytel', index=0,
      number=1, type=9, cpp_type=9, label=1,
      has_default_value=False, default_value=_b("").decode('utf-8'),
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR),
    _descriptor.FieldDescriptor(
      name='name', full_name='netty_studio.simple_no2.name', index=1,
      number=2, type=9, cpp_type=9, label=1,
      has_default_value=False, default_value=_b("").decode('utf-8'),
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR),
    _descriptor.FieldDescriptor(
      name='address', full_name='netty_studio.simple_no2.address', index=2,
      number=3, type=9, cpp_type=9, label=1,
      has_default_value=False, default_value=_b("").decode('utf-8'),
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR),
    _descriptor.FieldDescriptor(
      name='myheight', full_name='netty_studio.simple_no2.myheight', index=3,
      number=4, type=9, cpp_type=9, label=1,
      has_default_value=False, default_value=_b("").decode('utf-8'),
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR),
  ],
  extensions=[
  ],
  nested_types=[],
  enum_types=[
  ],
  serialized_options=None,
  is_extendable=False,
  syntax='proto2',
  extension_ranges=[],
  oneofs=[
  ],
  serialized_start=403,
  serialized_end=479,
)

_MYSIMPLE.fields_by_name['data_type'].enum_type = _MYSIMPLE_DATATYPE
_MYSIMPLE.fields_by_name['s1'].message_type = _SIMPLE
_MYSIMPLE.fields_by_name['s2'].message_type = _SIMPLE_NO1
_MYSIMPLE.fields_by_name['s3'].message_type = _SIMPLE_NO2
_MYSIMPLE_DATATYPE.containing_type = _MYSIMPLE
_MYSIMPLE.oneofs_by_name['dataBody'].fields.append(
  _MYSIMPLE.fields_by_name['s1'])
_MYSIMPLE.fields_by_name['s1'].containing_oneof = _MYSIMPLE.oneofs_by_name['dataBody']
_MYSIMPLE.oneofs_by_name['dataBody'].fields.append(
  _MYSIMPLE.fields_by_name['s2'])
_MYSIMPLE.fields_by_name['s2'].containing_oneof = _MYSIMPLE.oneofs_by_name['dataBody']
_MYSIMPLE.oneofs_by_name['dataBody'].fields.append(
  _MYSIMPLE.fields_by_name['s3'])
_MYSIMPLE.fields_by_name['s3'].containing_oneof = _MYSIMPLE.oneofs_by_name['dataBody']
DESCRIPTOR.message_types_by_name['MySimple'] = _MYSIMPLE
DESCRIPTOR.message_types_by_name['simple'] = _SIMPLE
DESCRIPTOR.message_types_by_name['simple_no1'] = _SIMPLE_NO1
DESCRIPTOR.message_types_by_name['simple_no2'] = _SIMPLE_NO2
_sym_db.RegisterFileDescriptor(DESCRIPTOR)

MySimple = _reflection.GeneratedProtocolMessageType('MySimple', (_message.Message,), {
  'DESCRIPTOR' : _MYSIMPLE,
  '__module__' : 'netty_studio.simple_pb2'
  # @@protoc_insertion_point(class_scope:netty_studio.MySimple)
  })
_sym_db.RegisterMessage(MySimple)

simple = _reflection.GeneratedProtocolMessageType('simple', (_message.Message,), {
  'DESCRIPTOR' : _SIMPLE,
  '__module__' : 'netty_studio.simple_pb2'
  # @@protoc_insertion_point(class_scope:netty_studio.simple)
  })
_sym_db.RegisterMessage(simple)

simple_no1 = _reflection.GeneratedProtocolMessageType('simple_no1', (_message.Message,), {
  'DESCRIPTOR' : _SIMPLE_NO1,
  '__module__' : 'netty_studio.simple_pb2'
  # @@protoc_insertion_point(class_scope:netty_studio.simple_no1)
  })
_sym_db.RegisterMessage(simple_no1)

simple_no2 = _reflection.GeneratedProtocolMessageType('simple_no2', (_message.Message,), {
  'DESCRIPTOR' : _SIMPLE_NO2,
  '__module__' : 'netty_studio.simple_pb2'
  # @@protoc_insertion_point(class_scope:netty_studio.simple_no2)
  })
_sym_db.RegisterMessage(simple_no2)


DESCRIPTOR._options = None
# @@protoc_insertion_point(module_scope)