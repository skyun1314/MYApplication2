package com.example;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zk on 2017/6/12.
 */


public class Header_Items {

    public static class Header_Strings {

        int off;
        int size;
        String str;

        @Override
        public String toString() {
            return "\nHeader_Strings{" +
                    "off=" + off +
                    ", size=" + size +
                    ", str='" + str + '\'' +
                    '}';
        }
    }

    public static class Header_Types {

        int off;
        String str;

        @Override
        public String toString() {
            return "Header_Strings{" +
                    "off=" + off +
                    ", str='" + str + '\'' +
                    '}';
        }
    }

    public static class Header_Proto {
        String shorty_idx;
        String return_type_idx;
        List<String> parameters_off;

        @Override
        public String toString() {
            return "Header_Proto{" +
                    "shorty_idx=" + shorty_idx +
                    ", return_type_idx=" + return_type_idx +
                    ", parameters_off=" + parameters_off +
                    '}';
        }
    }

    public static class Header_Field {
        String class_idx;
        String type_idx;
        String name_idx;

        @Override
        public String toString() {
            return "Header_Field{" +
                    "class_idx='" + class_idx + '\'' +
                    ", type_idx='" + type_idx + '\'' +
                    ", name_idx='" + name_idx + '\'' +
                    '}';
        }
    }

    public static class Header_Method {
        String class_idx;
        String proto_idx;
        String name_idx;

        @Override
        public String toString() {
            return "Header_Method{" +
                    "class_idx='" + class_idx + '\'' +
                    ", proto_idx='" + proto_idx + '\'' +
                    ", name_idx='" + name_idx + '\'' +
                    '}';
        }
    }


    public static class Header_Class {
        String class_idx;
        int ACCESS_FLAGS;
        String ACCESS_FLAGS_string;
        String superclass_idx;
        int interfaces_off;

        @Override
        public String toString() {
            return "Header_Class{" +
                    "\n\tclass_idx='" + class_idx + '\'' +
                    ", \n\tACCESS_FLAGS=" + ACCESS_FLAGS +
                    ", \n\tACCESS_FLAGS_string='" + ACCESS_FLAGS_string + '\'' +
                    ", \n\tsuperclass_idx='" + superclass_idx + '\'' +
                    ", \n\tinterfaces_off=" + interfaces_off +
                    ", \n\tsource_file_idx='" + source_file_idx + '\'' +
                    ", \n\tannotations_off=" + annotations_off +
                    ", \n\tclass_data_off=" + class_data_off +
                    ", \n\tvalues_off=" + values_off +
                    ", \n\tclass_data=" + class_data +
                    '}';
        }

        String source_file_idx;
        int annotations_off;
        int class_data_off;
        int values_off;
        Class_data class_data=new Class_data();


        public static class EncodedField {
            public int filed_idx_diff;
            public int access_flags;
            public String access_flags_string;

            @Override
            public String toString() {
                return "\nEncodedField{" +
                        "filed_idx_diff=" + filed_idx_diff +
                        ", access_flags=" + access_flags +
                        ", access_flags_string='" + access_flags_string + '\'' +
                        '}';
            }
        }


        public static class Code_item{
            public  int registers_size;
            public  int ins_size;
            public  int outs_size;
            public int tries_size;
            public int debug_info_off;
            public int insns_size;
            public List<Byte> insns=new ArrayList<>();
            public List<String> insns_string=new ArrayList<>();

            @Override
            public String toString() {
                return "\nCode_item{" +
                        "registers_size=" + registers_size +
                        ", ins_size=" + ins_size +
                        ", outs_size=" + outs_size +
                        ", tries_size=" + tries_size +
                        ", debug_info_off=" + debug_info_off +
                        ", insns_size=" + insns_size +
                        ", insns=" + insns +
                        ",\n\t insns_string=\n" + insns_string +
                        '}'+"\n";
            }
        }

        public static class EncodedMethod {

            public int method_idx_diff;
            public int access_flags;
            public String access_flags_string;
            public int code_off;
            public Code_item code;

            @Override
            public String toString() {
                return "\n\tEncodedMethod{" +
                        "\n\tmethod_idx_diff=" + method_idx_diff +
                        ", \n\taccess_flags=" + access_flags +
                        ", \n\taccess_flags_string=" + access_flags_string +
                        ", \n\tcode_off=" + code_off +
                        ", \n\tcode=" + code +
                        '}';
            }
        }


        class Class_data {
            int static_fields_size;
            int instance_fields_size;
            int direct_methods_size;
            int virtual_methods_size;

            public List<EncodedField> static_fields=new ArrayList<>();
            public List<EncodedField> instance_fields=new ArrayList<>();
            public List<EncodedMethod> direct_methods=new ArrayList<>();
            public List<EncodedMethod> virtual_methods=new ArrayList<>();

            @Override
            public String toString() {
                return "Class_data{" +
                        "\n\tstatic_fields_size=" + static_fields_size +
                        ", \n\tinstance_fields_size=" + instance_fields_size +
                        ", \n\tdirect_methods_size=" + direct_methods_size +
                        ", \n\tvirtual_methods_size=" + virtual_methods_size +
                        ", \n\tstatic_fields=" + static_fields +
                        ", \n\tinstance_fields=" + instance_fields +
                        ", \n\tdirect_methods=" + direct_methods +
                        ", \n\tvirtual_methods=" + virtual_methods +
                        '}';
            }
        }

    }
}