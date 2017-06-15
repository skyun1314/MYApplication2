package com.example;

/**
 * Created by zk on 2017/6/12.
 */

public class Header {


    byte[] dex_magic=new byte[8];;
    int checksum;
    byte[]MSHA1=new byte[20];
    int file_size;
    int header_size ;
    int endian_tag ;
    int link_size ;
    int link_off;
    int map_off ;
    int string_ids_size ;
    int string_ids_off ;
    int type_ids_size ;
    int type_ids_off;
    int proto_ids_size ;
    int proto_ids_off ;
    int field_ids_size;
    int field_ids_off;
    int method_ids_size;
    int method_ids_off ;
    int class_defs_size;
    int class_defs_off ;
    int data_size ;
    int data_off;


    @Override
    public String toString() {
        return "Header{" +
                "dex_magic=" + PaserUtil.byteArray2String(dex_magic) +
                ", checksum=" + checksum +
                ", MSHA1=" + PaserUtil.byteArray2String(MSHA1) +
                ", file_size=" + file_size +
                ", header_size=" + header_size +
                ", endian_tag=" + Integer.toHexString(endian_tag)  +
                ", link_size=" + link_size +
                ", link_off=" + link_off +
                ", map_off=" + map_off +
                ", string_ids_size=" + string_ids_size +
                ", string_ids_off=" + string_ids_off +
                ", type_ids_size=" + type_ids_size +
                ", type_ids_off=" + type_ids_off +
                ", proto_ids_size=" + proto_ids_size +
                ", proto_ids_off=" + proto_ids_off +
                ", field_ids_size=" + field_ids_size +
                ", field_ids_off=" + field_ids_off +
                ", method_ids_size=" + method_ids_size +
                ", method_ids_off=" + method_ids_off +
                ", class_defs_size=" + class_defs_size +
                ", class_defs_off=" + class_defs_off +
                ", data_size=" + data_size +
                ", data_off=" + data_off +
                '}';
    }



}
