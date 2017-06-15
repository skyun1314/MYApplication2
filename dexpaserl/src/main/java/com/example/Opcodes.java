package com.example;

import com.sun.org.apache.bcel.internal.generic.GOTO;
import com.sun.org.apache.bcel.internal.generic.RETURN;

/**
 * Created by zk on 2017/6/15.
 */

public class Opcodes {

    enum Opcode {

       



        // BEGIN(libdex-opcode-enum); GENERATED AUTOMATICALLY BY opcode-gen
        OP_NOP                          ( 0x00),
        OP_MOVE                         ( 0x01),
        OP_MOVE_FROM16                  ( 0x02),
        OP_MOVE_16                      ( 0x03),
        OP_MOVE_WIDE                    ( 0x04),
        OP_MOVE_WIDE_FROM16             ( 0x05),
        OP_MOVE_WIDE_16                 ( 0x06),
        OP_MOVE_OBJECT                  ( 0x07),
        OP_MOVE_OBJECT_FROM16           ( 0x08),
        OP_MOVE_OBJECT_16               ( 0x09),
        OP_MOVE_RESULT                  ( 0x0a),
        OP_MOVE_RESULT_WIDE             ( 0x0b),
        OP_MOVE_RESULT_OBJECT           ( 0x0c),
        OP_MOVE_EXCEPTION               ( 0x0d),
        OP_RETURN_VOID                  ( 0x0e,
        OP_RETURN                       ( 0x0f,
        OP_RETURN_WIDE                  ( 0x10,
        OP_RETURN_OBJECT                ( 0x11,
        OP_CONST_4                      ( 0x12,
        OP_CONST_16                     ( 0x13,
        OP_CONST                        ( 0x14,
        OP_CONST_HIGH16                 ( 0x15,
        OP_CONST_WIDE_16                ( 0x16,
        OP_CONST_WIDE_32                ( 0x17,
        OP_CONST_WIDE                   ( 0x18,
        OP_CONST_WIDE_HIGH16            ( 0x19,
        OP_CONST_STRING                 ( 0x1a,
        OP_CONST_STRING_JUMBO           ( 0x1b,
        OP_CONST_CLASS                  ( 0x1c,
        OP_MONITOR_ENTER                ( 0x1d,
        OP_MONITOR_EXIT                 ( 0x1e,
        OP_CHECK_CAST                   ( 0x1f,
        OP_INSTANCE_OF                  ( 0x20,
        OP_ARRAY_LENGTH                 ( 0x21,
        OP_NEW_INSTANCE                 ( 0x22,
        OP_NEW_ARRAY                    ( 0x23,
        OP_FILLED_NEW_ARRAY             ( 0x24,
        OP_FILLED_NEW_ARRAY_RANGE       ( 0x25,
        OP_FILL_ARRAY_DATA              ( 0x26,
        OP_THROW                        ( 0x27,
        OP_GOTO                         ( 0x28,
        OP_GOTO_16                      ( 0x29,
        OP_GOTO_32                      ( 0x2a,
        OP_PACKED_SWITCH                ( 0x2b,
        OP_SPARSE_SWITCH                ( 0x2c,
        OP_CMPL_FLOAT                   ( 0x2d,
        OP_CMPG_FLOAT                   ( 0x2e,
        OP_CMPL_DOUBLE                  ( 0x2f,
        OP_CMPG_DOUBLE                  ( 0x30,
        OP_CMP_LONG                     ( 0x31,
        OP_IF_EQ                        ( 0x32,
        OP_IF_NE                        ( 0x33,
        OP_IF_LT                        ( 0x34,
        OP_IF_GE                        ( 0x35,
        OP_IF_GT                        ( 0x36,
        OP_IF_LE                        ( 0x37,
        OP_IF_EQZ                       ( 0x38,
        OP_IF_NEZ                       ( 0x39,
        OP_IF_LTZ                       ( 0x3a,
        OP_IF_GEZ                       ( 0x3b,
        OP_IF_GTZ                       ( 0x3c,
        OP_IF_LEZ                       ( 0x3d,
        OP_UNUSED_3E                    ( 0x3e,
        OP_UNUSED_3F                    ( 0x3f,
        OP_UNUSED_40                    ( 0x40,
        OP_UNUSED_41                    ( 0x41,
        OP_UNUSED_42                    ( 0x42,
        OP_UNUSED_43                    ( 0x43,
        OP_AGET                         ( 0x44,
        OP_AGET_WIDE                    ( 0x45,
        OP_AGET_OBJECT                  ( 0x46,
        OP_AGET_BOOLEAN                 ( 0x47,
        OP_AGET_BYTE                    ( 0x48,
        OP_AGET_CHAR                    ( 0x49,
        OP_AGET_SHORT                   ( 0x4a,
        OP_APUT                         ( 0x4b,
        OP_APUT_WIDE                    ( 0x4c,
        OP_APUT_OBJECT                  ( 0x4d,
        OP_APUT_BOOLEAN                 ( 0x4e,
        OP_APUT_BYTE                    ( 0x4f,
        OP_APUT_CHAR                    ( 0x50,
        OP_APUT_SHORT                   ( 0x51,
        OP_IGET                         ( 0x52,
        OP_IGET_WIDE                    ( 0x53,
        OP_IGET_OBJECT                  ( 0x54,
        OP_IGET_BOOLEAN                 ( 0x55,
        OP_IGET_BYTE                    ( 0x56,
        OP_IGET_CHAR                    ( 0x57,
        OP_IGET_SHORT                   ( 0x58,
        OP_IPUT                         ( 0x59,
        OP_IPUT_WIDE                    ( 0x5a,
        OP_IPUT_OBJECT                  ( 0x5b,
        OP_IPUT_BOOLEAN                 ( 0x5c,
        OP_IPUT_BYTE                    ( 0x5d,
        OP_IPUT_CHAR                    ( 0x5e,
        OP_IPUT_SHORT                   ( 0x5f,
        OP_SGET                         ( 0x60,
        OP_SGET_WIDE                    ( 0x61,
        OP_SGET_OBJECT                  ( 0x62,
        OP_SGET_BOOLEAN                 ( 0x63,
        OP_SGET_BYTE                    ( 0x64,
        OP_SGET_CHAR                    ( 0x65,
        OP_SGET_SHORT                   ( 0x66,
        OP_SPUT                         ( 0x67,
        OP_SPUT_WIDE                    ( 0x68,
        OP_SPUT_OBJECT                  ( 0x69,
        OP_SPUT_BOOLEAN                 ( 0x6a,
        OP_SPUT_BYTE                    ( 0x6b,
        OP_SPUT_CHAR                    ( 0x6c,
        OP_SPUT_SHORT                   ( 0x6d,
        OP_INVOKE_VIRTUAL               ( 0x6e,
        OP_INVOKE_SUPER                 ( 0x6f,
        OP_INVOKE_DIRECT                ( 0x70,
        OP_INVOKE_STATIC                ( 0x71,
        OP_INVOKE_INTERFACE             ( 0x72,
        OP_UNUSED_73                    ( 0x73,
        OP_INVOKE_VIRTUAL_RANGE         ( 0x74,
        OP_INVOKE_SUPER_RANGE           ( 0x75,
        OP_INVOKE_DIRECT_RANGE          ( 0x76,
        OP_INVOKE_STATIC_RANGE          ( 0x77,
        OP_INVOKE_INTERFACE_RANGE       ( 0x78,
        OP_UNUSED_79                    ( 0x79,
        OP_UNUSED_7A                    ( 0x7a,
        OP_NEG_INT                      ( 0x7b,
        OP_NOT_INT                      ( 0x7c,
        OP_NEG_LONG                     ( 0x7d,
        OP_NOT_LONG                     ( 0x7e,
        OP_NEG_FLOAT                    ( 0x7f,
        OP_NEG_DOUBLE                   ( 0x80,
        OP_INT_TO_LONG                  ( 0x81,
        OP_INT_TO_FLOAT                 ( 0x82,
        OP_INT_TO_DOUBLE                ( 0x83,
        OP_LONG_TO_INT                  ( 0x84,
        OP_LONG_TO_FLOAT                ( 0x85,
        OP_LONG_TO_DOUBLE               ( 0x86,
        OP_FLOAT_TO_INT                 ( 0x87,
        OP_FLOAT_TO_LONG                ( 0x88,
        OP_FLOAT_TO_DOUBLE              ( 0x89,
        OP_DOUBLE_TO_INT                ( 0x8a,
        OP_DOUBLE_TO_LONG               ( 0x8b,
        OP_DOUBLE_TO_FLOAT              ( 0x8c,
        OP_INT_TO_BYTE                  ( 0x8d,
        OP_INT_TO_CHAR                  ( 0x8e,
        OP_INT_TO_SHORT                 ( 0x8f,
        OP_ADD_INT                      ( 0x90,
        OP_SUB_INT                      ( 0x91,
        OP_MUL_INT                      ( 0x92,
        OP_DIV_INT                      ( 0x93,
        OP_REM_INT                      ( 0x94,
        OP_AND_INT                      ( 0x95,
        OP_OR_INT                       ( 0x96,
        OP_XOR_INT                      ( 0x97,
        OP_SHL_INT                      ( 0x98,
        OP_SHR_INT                      ( 0x99,
        OP_USHR_INT                     ( 0x9a,
        OP_ADD_LONG                     ( 0x9b,
        OP_SUB_LONG                     ( 0x9c,
        OP_MUL_LONG                     ( 0x9d,
        OP_DIV_LONG                     ( 0x9e,
        OP_REM_LONG                     ( 0x9f,
        OP_AND_LONG                     ( 0xa0,
        OP_OR_LONG                      ( 0xa1,
        OP_XOR_LONG                     ( 0xa2,
        OP_SHL_LONG                     ( 0xa3,
        OP_SHR_LONG                     ( 0xa4,
        OP_USHR_LONG                    ( 0xa5,
        OP_ADD_FLOAT                    ( 0xa6,
        OP_SUB_FLOAT                    ( 0xa7,
        OP_MUL_FLOAT                    ( 0xa8,
        OP_DIV_FLOAT                    ( 0xa9,
        OP_REM_FLOAT                    ( 0xaa,
        OP_ADD_DOUBLE                   ( 0xab,
        OP_SUB_DOUBLE                   ( 0xac,
        OP_MUL_DOUBLE                   ( 0xad,
        OP_DIV_DOUBLE                   ( 0xae,
        OP_REM_DOUBLE                   ( 0xaf,
        OP_ADD_INT_2ADDR                ( 0xb0,
        OP_SUB_INT_2ADDR                ( 0xb1,
        OP_MUL_INT_2ADDR                ( 0xb2,
        OP_DIV_INT_2ADDR                ( 0xb3,
        OP_REM_INT_2ADDR                ( 0xb4,
        OP_AND_INT_2ADDR                ( 0xb5,
        OP_OR_INT_2ADDR                 ( 0xb6,
        OP_XOR_INT_2ADDR                ( 0xb7,
        OP_SHL_INT_2ADDR                ( 0xb8,
        OP_SHR_INT_2ADDR                ( 0xb9,
        OP_USHR_INT_2ADDR               ( 0xba,
        OP_ADD_LONG_2ADDR               ( 0xbb,
        OP_SUB_LONG_2ADDR               ( 0xbc,
        OP_MUL_LONG_2ADDR               ( 0xbd,
        OP_DIV_LONG_2ADDR               ( 0xbe,
        OP_REM_LONG_2ADDR               ( 0xbf,
        OP_AND_LONG_2ADDR               ( 0xc0,
        OP_OR_LONG_2ADDR                ( 0xc1,
        OP_XOR_LONG_2ADDR               ( 0xc2,
        OP_SHL_LONG_2ADDR               ( 0xc3,
        OP_SHR_LONG_2ADDR               ( 0xc4,
        OP_USHR_LONG_2ADDR              ( 0xc5,
        OP_ADD_FLOAT_2ADDR              ( 0xc6,
        OP_SUB_FLOAT_2ADDR              ( 0xc7,
        OP_MUL_FLOAT_2ADDR              ( 0xc8,
        OP_DIV_FLOAT_2ADDR              ( 0xc9,
        OP_REM_FLOAT_2ADDR              ( 0xca,
        OP_ADD_DOUBLE_2ADDR             ( 0xcb,
        OP_SUB_DOUBLE_2ADDR             ( 0xcc,
        OP_MUL_DOUBLE_2ADDR             ( 0xcd,
        OP_DIV_DOUBLE_2ADDR             ( 0xce,
        OP_REM_DOUBLE_2ADDR             ( 0xcf,
        OP_ADD_INT_LIT16                ( 0xd0,
        OP_RSUB_INT                     ( 0xd1,
        OP_MUL_INT_LIT16                ( 0xd2,
        OP_DIV_INT_LIT16                ( 0xd3,
        OP_REM_INT_LIT16                ( 0xd4,
        OP_AND_INT_LIT16                ( 0xd5,
        OP_OR_INT_LIT16                 ( 0xd6,
        OP_XOR_INT_LIT16                ( 0xd7,
        OP_ADD_INT_LIT8                 ( 0xd8,
        OP_RSUB_INT_LIT8                ( 0xd9,
        OP_MUL_INT_LIT8                 ( 0xda,
        OP_DIV_INT_LIT8                 ( 0xdb,
        OP_REM_INT_LIT8                 ( 0xdc,
        OP_AND_INT_LIT8                 ( 0xdd,
        OP_OR_INT_LIT8                  ( 0xde,
        OP_XOR_INT_LIT8                 ( 0xdf,
        OP_SHL_INT_LIT8                 ( 0xe0,
        OP_SHR_INT_LIT8                 ( 0xe1,
        OP_USHR_INT_LIT8                ( 0xe2,
        OP_IGET_VOLATILE                ( 0xe3,
        OP_IPUT_VOLATILE                ( 0xe4,
        OP_SGET_VOLATILE                ( 0xe5,
        OP_SPUT_VOLATILE                ( 0xe6,
        OP_IGET_OBJECT_VOLATILE         ( 0xe7,
        OP_IGET_WIDE_VOLATILE           ( 0xe8,
        OP_IPUT_WIDE_VOLATILE           ( 0xe9,
        OP_SGET_WIDE_VOLATILE           ( 0xea,
        OP_SPUT_WIDE_VOLATILE           ( 0xeb,
        OP_BREAKPOINT                   ( 0xec,
        OP_THROW_VERIFICATION_ERROR     ( 0xed,
        OP_EXECUTE_INLINE               ( 0xee,
        OP_EXECUTE_INLINE_RANGE         ( 0xef,
        OP_INVOKE_OBJECT_INIT_RANGE     ( 0xf0,
        OP_RETURN_VOID_BARRIER          ( 0xf1,
        OP_IGET_QUICK                   ( 0xf2,
        OP_IGET_WIDE_QUICK              ( 0xf3,
        OP_IGET_OBJECT_QUICK            ( 0xf4,
        OP_IPUT_QUICK                   ( 0xf5,
        OP_IPUT_WIDE_QUICK              ( 0xf6,
        OP_IPUT_OBJECT_QUICK            ( 0xf7,
        OP_INVOKE_VIRTUAL_QUICK         ( 0xf8,
        OP_INVOKE_VIRTUAL_QUICK_RANGE   ( 0xf9,
        OP_INVOKE_SUPER_QUICK           ( 0xfa,
        OP_INVOKE_SUPER_QUICK_RANGE     ( 0xfb,
        OP_IPUT_OBJECT_VOLATILE         ( 0xfc,
        OP_SGET_OBJECT_VOLATILE         ( 0xfd,
        OP_SPUT_OBJECT_VOLATILE         ( 0xfe,
        OP_UNUSED_FF                    ( 0xff,
        // END(libdex-opcode-enum)
    };


    // BEGIN(opcodes); GENERATED AUTOMATICALLY BY opcode-gen
    public static final int NOP ( 0x00;
    public static final int MOVE ( 0x01;
    public static final int MOVE_FROM16 ( 0x02;
    public static final int MOVE_16 ( 0x03;
    public static final int MOVE_WIDE ( 0x04;
    public static final int MOVE_WIDE_FROM16 ( 0x05;
    public static final int MOVE_WIDE_16 ( 0x06;
    public static final int MOVE_OBJECT ( 0x07;
    public static final int MOVE_OBJECT_FROM16 ( 0x08;
    public static final int MOVE_OBJECT_16 ( 0x09;
    public static final int MOVE_RESULT ( 0x0a;
    public static final int MOVE_RESULT_WIDE ( 0x0b;
    public static final int MOVE_RESULT_OBJECT ( 0x0c;
    public static final int MOVE_EXCEPTION ( 0x0d;
    public static final int RETURN_VOID ( 0x0e;
    public static final int RETURN( 0x0f;
    public static final int RETURN_WIDE ( 0x10;
    public static final int RETURN_OBJECT ( 0x11;
    public static final int CONST_4 ( 0x12;
    public static final int CONST_16 ( 0x13;
    public static final int CONST ( 0x14;
    public static final int CONST_HIGH16 ( 0x15;
    public static final int CONST_WIDE_16 ( 0x16;
    public static final int CONST_WIDE_32 ( 0x17;
    public static final int CONST_WIDE ( 0x18;
    public static final int CONST_WIDE_HIGH16 ( 0x19;
    public static final int CONST_STRING ( 0x1a;
    public static final int CONST_STRING_JUMBO ( 0x1b;
    public static final int CONST_CLASS ( 0x1c;
    public static final int MONITOR_ENTER ( 0x1d;
    public static final int MONITOR_EXIT ( 0x1e;
    public static final int CHECK_CAST ( 0x1f;
    public static final int INSTANCE_OF ( 0x20;
    public static final int ARRAY_LENGTH ( 0x21;
    public static final int NEW_INSTANCE ( 0x22;
    public static final int NEW_ARRAY ( 0x23;
    public static final int FILLED_NEW_ARRAY ( 0x24;
    public static final int FILLED_NEW_ARRAY_RANGE ( 0x25;
    public static final int FILL_ARRAY_DATA ( 0x26;
    public static final int THROW ( 0x27;
    public static final int GOTO( 0x28;
    public static final int GOTO_16 ( 0x29;
    public static final int GOTO_32 ( 0x2a;
    public static final int PACKED_SWITCH ( 0x2b;
    public static final int SPARSE_SWITCH ( 0x2c;
    public static final int CMPL_FLOAT ( 0x2d;
    public static final int CMPG_FLOAT ( 0x2e;
    public static final int CMPL_DOUBLE ( 0x2f;
    public static final int CMPG_DOUBLE ( 0x30;
    public static final int CMP_LONG ( 0x31;
    public static final int IF_EQ ( 0x32;
    public static final int IF_NE ( 0x33;
    public static final int IF_LT ( 0x34;
    public static final int IF_GE ( 0x35;
    public static final int IF_GT ( 0x36;
    public static final int IF_LE ( 0x37;
    public static final int IF_EQZ ( 0x38;
    public static final int IF_NEZ ( 0x39;
    public static final int IF_LTZ ( 0x3a;
    public static final int IF_GEZ ( 0x3b;
    public static final int IF_GTZ ( 0x3c;
    public static final int IF_LEZ ( 0x3d;
    public static final int AGET ( 0x44;
    public static final int AGET_WIDE ( 0x45;
    public static final int AGET_OBJECT ( 0x46;
    public static final int AGET_BOOLEAN ( 0x47;
    public static final int AGET_BYTE ( 0x48;
    public static final int AGET_CHAR ( 0x49;
    public static final int AGET_SHORT ( 0x4a;
    public static final int APUT ( 0x4b;
    public static final int APUT_WIDE ( 0x4c;
    public static final int APUT_OBJECT ( 0x4d;
    public static final int APUT_BOOLEAN ( 0x4e;
    public static final int APUT_BYTE ( 0x4f;
    public static final int APUT_CHAR ( 0x50;
    public static final int APUT_SHORT ( 0x51;
    public static final int IGET ( 0x52;
    public static final int IGET_WIDE ( 0x53;
    public static final int IGET_OBJECT ( 0x54;
    public static final int IGET_BOOLEAN ( 0x55;
    public static final int IGET_BYTE ( 0x56;
    public static final int IGET_CHAR ( 0x57;
    public static final int IGET_SHORT ( 0x58;
    public static final int IPUT ( 0x59;
    public static final int IPUT_WIDE ( 0x5a;
    public static final int IPUT_OBJECT ( 0x5b;
    public static final int IPUT_BOOLEAN ( 0x5c;
    public static final int IPUT_BYTE ( 0x5d;
    public static final int IPUT_CHAR ( 0x5e;
    public static final int IPUT_SHORT ( 0x5f;
    public static final int SGET ( 0x60;
    public static final int SGET_WIDE ( 0x61;
    public static final int SGET_OBJECT ( 0x62;
    public static final int SGET_BOOLEAN ( 0x63;
    public static final int SGET_BYTE ( 0x64;
    public static final int SGET_CHAR ( 0x65;
    public static final int SGET_SHORT ( 0x66;
    public static final int SPUT ( 0x67;
    public static final int SPUT_WIDE ( 0x68;
    public static final int SPUT_OBJECT ( 0x69;
    public static final int SPUT_BOOLEAN ( 0x6a;
    public static final int SPUT_BYTE ( 0x6b;
    public static final int SPUT_CHAR ( 0x6c;
    public static final int SPUT_SHORT ( 0x6d;
    public static final int INVOKE_VIRTUAL ( 0x6e;
    public static final int INVOKE_SUPER ( 0x6f;
    public static final int INVOKE_DIRECT ( 0x70;
    public static final int INVOKE_STATIC ( 0x71;
    public static final int INVOKE_INTERFACE ( 0x72;
    public static final int INVOKE_VIRTUAL_RANGE ( 0x74;
    public static final int INVOKE_SUPER_RANGE ( 0x75;
    public static final int INVOKE_DIRECT_RANGE ( 0x76;
    public static final int INVOKE_STATIC_RANGE ( 0x77;
    public static final int INVOKE_INTERFACE_RANGE ( 0x78;
    public static final int NEG_INT ( 0x7b;
    public static final int NOT_INT ( 0x7c;
    public static final int NEG_LONG ( 0x7d;
    public static final int NOT_LONG ( 0x7e;
    public static final int NEG_FLOAT ( 0x7f;
    public static final int NEG_DOUBLE ( 0x80;
    public static final int INT_TO_LONG ( 0x81;
    public static final int INT_TO_FLOAT ( 0x82;
    public static final int INT_TO_DOUBLE ( 0x83;
    public static final int LONG_TO_INT ( 0x84;
    public static final int LONG_TO_FLOAT ( 0x85;
    public static final int LONG_TO_DOUBLE ( 0x86;
    public static final int FLOAT_TO_INT ( 0x87;
    public static final int FLOAT_TO_LONG ( 0x88;
    public static final int FLOAT_TO_DOUBLE ( 0x89;
    public static final int DOUBLE_TO_INT ( 0x8a;
    public static final int DOUBLE_TO_LONG ( 0x8b;
    public static final int DOUBLE_TO_FLOAT ( 0x8c;
    public static final int INT_TO_BYTE ( 0x8d;
    public static final int INT_TO_CHAR ( 0x8e;
    public static final int INT_TO_SHORT ( 0x8f;
    public static final int ADD_INT ( 0x90;
    public static final int SUB_INT ( 0x91;
    public static final int MUL_INT ( 0x92;
    public static final int DIV_INT ( 0x93;
    public static final int REM_INT ( 0x94;
    public static final int AND_INT ( 0x95;
    public static final int OR_INT ( 0x96;
    public static final int XOR_INT ( 0x97;
    public static final int SHL_INT ( 0x98;
    public static final int SHR_INT ( 0x99;
    public static final int USHR_INT ( 0x9a;
    public static final int ADD_LONG ( 0x9b;
    public static final int SUB_LONG ( 0x9c;
    public static final int MUL_LONG ( 0x9d;
    public static final int DIV_LONG ( 0x9e;
    public static final int REM_LONG ( 0x9f;
    public static final int AND_LONG ( 0xa0;
    public static final int OR_LONG ( 0xa1;
    public static final int XOR_LONG ( 0xa2;
    public static final int SHL_LONG ( 0xa3;
    public static final int SHR_LONG ( 0xa4;
    public static final int USHR_LONG ( 0xa5;
    public static final int ADD_FLOAT ( 0xa6;
    public static final int SUB_FLOAT ( 0xa7;
    public static final int MUL_FLOAT ( 0xa8;
    public static final int DIV_FLOAT ( 0xa9;
    public static final int REM_FLOAT ( 0xaa;
    public static final int ADD_DOUBLE ( 0xab;
    public static final int SUB_DOUBLE ( 0xac;
    public static final int MUL_DOUBLE ( 0xad;
    public static final int DIV_DOUBLE ( 0xae;
    public static final int REM_DOUBLE ( 0xaf;
    public static final int ADD_INT_2ADDR ( 0xb0;
    public static final int SUB_INT_2ADDR ( 0xb1;
    public static final int MUL_INT_2ADDR ( 0xb2;
    public static final int DIV_INT_2ADDR ( 0xb3;
    public static final int REM_INT_2ADDR ( 0xb4;
    public static final int AND_INT_2ADDR ( 0xb5;
    public static final int OR_INT_2ADDR ( 0xb6;
    public static final int XOR_INT_2ADDR ( 0xb7;
    public static final int SHL_INT_2ADDR ( 0xb8;
    public static final int SHR_INT_2ADDR ( 0xb9;
    public static final int USHR_INT_2ADDR ( 0xba;
    public static final int ADD_LONG_2ADDR ( 0xbb;
    public static final int SUB_LONG_2ADDR ( 0xbc;
    public static final int MUL_LONG_2ADDR ( 0xbd;
    public static final int DIV_LONG_2ADDR ( 0xbe;
    public static final int REM_LONG_2ADDR ( 0xbf;
    public static final int AND_LONG_2ADDR ( 0xc0;
    public static final int OR_LONG_2ADDR ( 0xc1;
    public static final int XOR_LONG_2ADDR ( 0xc2;
    public static final int SHL_LONG_2ADDR ( 0xc3;
    public static final int SHR_LONG_2ADDR ( 0xc4;
    public static final int USHR_LONG_2ADDR ( 0xc5;
    public static final int ADD_FLOAT_2ADDR ( 0xc6;
    public static final int SUB_FLOAT_2ADDR ( 0xc7;
    public static final int MUL_FLOAT_2ADDR ( 0xc8;
    public static final int DIV_FLOAT_2ADDR ( 0xc9;
    public static final int REM_FLOAT_2ADDR ( 0xca;
    public static final int ADD_DOUBLE_2ADDR ( 0xcb;
    public static final int SUB_DOUBLE_2ADDR ( 0xcc;
    public static final int MUL_DOUBLE_2ADDR ( 0xcd;
    public static final int DIV_DOUBLE_2ADDR ( 0xce;
    public static final int REM_DOUBLE_2ADDR ( 0xcf;
    public static final int ADD_INT_LIT16 ( 0xd0;
    public static final int RSUB_INT ( 0xd1;
    public static final int MUL_INT_LIT16 ( 0xd2;
    public static final int DIV_INT_LIT16 ( 0xd3;
    public static final int REM_INT_LIT16 ( 0xd4;
    public static final int AND_INT_LIT16 ( 0xd5;
    public static final int OR_INT_LIT16 ( 0xd6;
    public static final int XOR_INT_LIT16 ( 0xd7;
    public static final int ADD_INT_LIT8 ( 0xd8;
    public static final int RSUB_INT_LIT8 ( 0xd9;
    public static final int MUL_INT_LIT8 ( 0xda;
    public static final int DIV_INT_LIT8 ( 0xdb;
    public static final int REM_INT_LIT8 ( 0xdc;
    public static final int AND_INT_LIT8 ( 0xdd;
    public static final int OR_INT_LIT8 ( 0xde;
    public static final int XOR_INT_LIT8 ( 0xdf;
    public static final int SHL_INT_LIT8 ( 0xe0;
    public static final int SHR_INT_LIT8 ( 0xe1;
    public static final int USHR_INT_LIT8 ( 0xe2;
    // END(opcodes)

    public static String gOpNames[] ( {
        // BEGIN(libdex-opcode-names); GENERATED AUTOMATICALLY BY opcode-gen
                "nop",
                "move",
                "move/from16",
                "move/16",
                "move-wide",
                "move-wide/from16",
                "move-wide/16",
                "move-object",
                "move-object/from16",
                "move-object/16",
                "move-result",
                "move-result-wide",
                "move-result-object",
                "move-exception",
                "return-void",
                "return",
                "return-wide",
                "return-object",
                "const/4",
                "const/16",
                "const",
                "const/high16",
                "const-wide/16",
                "const-wide/32",
                "const-wide",
                "const-wide/high16",
                "const-string",
                "const-string/jumbo",
                "const-class",
                "monitor-enter",
                "monitor-exit",
                "check-cast",
                "instance-of",
                "array-length",
                "new-instance",
                "new-array",
                "filled-new-array",
                "filled-new-array/range",
                "fill-array-data",
                "throw",
                "goto",
                "goto/16",
                "goto/32",
                "packed-switch",
                "sparse-switch",
                "cmpl-float",
                "cmpg-float",
                "cmpl-double",
                "cmpg-double",
                "cmp-long",
                "if-eq",
                "if-ne",
                "if-lt",
                "if-ge",
                "if-gt",
                "if-le",
                "if-eqz",
                "if-nez",
                "if-ltz",
                "if-gez",
                "if-gtz",
                "if-lez",
                "unused-3e",
                "unused-3f",
                "unused-40",
                "unused-41",
                "unused-42",
                "unused-43",
                "aget",
                "aget-wide",
                "aget-object",
                "aget-boolean",
                "aget-byte",
                "aget-char",
                "aget-short",
                "aput",
                "aput-wide",
                "aput-object",
                "aput-boolean",
                "aput-byte",
                "aput-char",
                "aput-short",
                "iget",
                "iget-wide",
                "iget-object",
                "iget-boolean",
                "iget-byte",
                "iget-char",
                "iget-short",
                "iput",
                "iput-wide",
                "iput-object",
                "iput-boolean",
                "iput-byte",
                "iput-char",
                "iput-short",
                "sget",
                "sget-wide",
                "sget-object",
                "sget-boolean",
                "sget-byte",
                "sget-char",
                "sget-short",
                "sput",
                "sput-wide",
                "sput-object",
                "sput-boolean",
                "sput-byte",
                "sput-char",
                "sput-short",
                "invoke-virtual",
                "invoke-super",
                "invoke-direct",
                "invoke-static",
                "invoke-interface",
                "unused-73",
                "invoke-virtual/range",
                "invoke-super/range",
                "invoke-direct/range",
                "invoke-static/range",
                "invoke-interface/range",
                "unused-79",
                "unused-7a",
                "neg-int",
                "not-int",
                "neg-long",
                "not-long",
                "neg-float",
                "neg-double",
                "int-to-long",
                "int-to-float",
                "int-to-double",
                "long-to-int",
                "long-to-float",
                "long-to-double",
                "float-to-int",
                "float-to-long",
                "float-to-double",
                "double-to-int",
                "double-to-long",
                "double-to-float",
                "int-to-byte",
                "int-to-char",
                "int-to-short",
                "add-int",
                "sub-int",
                "mul-int",
                "div-int",
                "rem-int",
                "and-int",
                "or-int",
                "xor-int",
                "shl-int",
                "shr-int",
                "ushr-int",
                "add-long",
                "sub-long",
                "mul-long",
                "div-long",
                "rem-long",
                "and-long",
                "or-long",
                "xor-long",
                "shl-long",
                "shr-long",
                "ushr-long",
                "add-float",
                "sub-float",
                "mul-float",
                "div-float",
                "rem-float",
                "add-double",
                "sub-double",
                "mul-double",
                "div-double",
                "rem-double",
                "add-int/2addr",
                "sub-int/2addr",
                "mul-int/2addr",
                "div-int/2addr",
                "rem-int/2addr",
                "and-int/2addr",
                "or-int/2addr",
                "xor-int/2addr",
                "shl-int/2addr",
                "shr-int/2addr",
                "ushr-int/2addr",
                "add-long/2addr",
                "sub-long/2addr",
                "mul-long/2addr",
                "div-long/2addr",
                "rem-long/2addr",
                "and-long/2addr",
                "or-long/2addr",
                "xor-long/2addr",
                "shl-long/2addr",
                "shr-long/2addr",
                "ushr-long/2addr",
                "add-float/2addr",
                "sub-float/2addr",
                "mul-float/2addr",
                "div-float/2addr",
                "rem-float/2addr",
                "add-double/2addr",
                "sub-double/2addr",
                "mul-double/2addr",
                "div-double/2addr",
                "rem-double/2addr",
                "add-int/lit16",
                "rsub-int",
                "mul-int/lit16",
                "div-int/lit16",
                "rem-int/lit16",
                "and-int/lit16",
                "or-int/lit16",
                "xor-int/lit16",
                "add-int/lit8",
                "rsub-int/lit8",
                "mul-int/lit8",
                "div-int/lit8",
                "rem-int/lit8",
                "and-int/lit8",
                "or-int/lit8",
                "xor-int/lit8",
                "shl-int/lit8",
                "shr-int/lit8",
                "ushr-int/lit8",
                "+iget-volatile",
                "+iput-volatile",
                "+sget-volatile",
                "+sput-volatile",
                "+iget-object-volatile",
                "+iget-wide-volatile",
                "+iput-wide-volatile",
                "+sget-wide-volatile",
                "+sput-wide-volatile",
                "^breakpoint",
                "^throw-verification-error",
                "+execute-inline",
                "+execute-inline/range",
                "+invoke-object-init/range",
                "+return-void-barrier",
                "+iget-quick",
                "+iget-wide-quick",
                "+iget-object-quick",
                "+iput-quick",
                "+iput-wide-quick",
                "+iput-object-quick",
                "+invoke-virtual-quick",
                "+invoke-virtual-quick/range",
                "+invoke-super-quick",
                "+invoke-super-quick/range",
                "+iput-object-volatile",
                "+sget-object-volatile",
                "+sput-object-volatile",
                "unused-ff",
        // END(libdex-opcode-names)
    };

}
