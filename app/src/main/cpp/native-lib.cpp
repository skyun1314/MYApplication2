#include <jni.h>
#include <string>
#include <dlfcn.h>
#include "Object.h"
#include "base64.h"
# include <stdlib.h>
#include <zlib.h>
#include <android/log.h>
#include <sys/types.h>
#include <unistd.h>
#include<vector>
#include <fcntl.h>
#include <sys/mman.h>
#include <android/asset_manager.h>
#include <android/asset_manager_jni.h>
#include<cstring>
#include <pthread.h>　

MemMapping mappingxx;
using namespace std;
DexHeader *dexHeader;
static char szPathxx[100] = {0};
#define LOGD(...)  __android_log_print(ANDROID_LOG_DEBUG,"wodelog", __VA_ARGS__)
extern "C" {
void printDexHeader(DexFile *pDexFile);
void data(DexFile *pDexFile, MemMapping *mem);
char *mPackageName;
FILE dump_opcode;
FILE class_defs;
FILE class_data;
FILE fppart1;
FILE fp_data;
FILE dump_whole;
FILE hahahahah;


pthread_t mThread;
void *AlertThreadStub(void *lparam);


void *AlertThreadStub(void *lparam) {
    printDexHeader((DexFile *) lparam);
    //__android_log_print(ANDROID_LOG_INFO, "wodelog", "#Thread working#%lu", mThread);
    return 0;
}


void makeFile(FILE *xx, char *filename) {
    memset(szPathxx, 0, 100);
    sprintf(szPathxx, "/data/data/%s/cache/%s", mPackageName, filename);
    LOGD("创建文件：%s", szPathxx);
    FILE *xxx = fopen(szPathxx, "ab+");
    *xx = *xxx;
}


void writeFile(char *str) {
    memset(szPathxx, 0, 100);
    sprintf(szPathxx, "/data/data/%s/cache/%s", mPackageName, str);
    FILE *xx = fopen(szPathxx, "rb");
    fseek(xx, 0, SEEK_END);
    long file_len = ftell(xx);
    char *buf = (char *) malloc(file_len);
    fseek(xx, 0, SEEK_SET);
    /*read the data and display it*/
    fread(buf, 1, file_len, xx);
    fwrite(buf, 1, file_len, &dump_whole);
}


JNIEXPORT void JNICALL
haha(JNIEnv *env, jobject instance, jint cookie, jstring pact) {

    mPackageName = (char *) env->GetStringUTFChars(pact, 0);
    if (cookie == 0 || cookie == NULL) {
        LOGD("无效输入");
        return;
    }

    // TODO
    DexOrJar *pDexOrJar = (DexOrJar *) cookie;
    DvmDex *pDvmDex;
    printf("jni", pDexOrJar->fileName);
    if (pDexOrJar->isDex) {
        pDvmDex = pDexOrJar->pRawDexFile->pDvmDex;
    } else {
        pDvmDex = pDexOrJar->pJarFile->pDvmDex;
    }
    DexFile *dexFile = pDvmDex->pDexFile;
    MemMapping mapping = pDvmDex->memMap;
    mappingxx = mapping;
    LOGD("MemMapping:filename:%s  addr:%x length:%x baseAddr:%x baseLength:%x", pDexOrJar->fileName,
         mapping.addr, mapping.length, mapping.baseAddr, mapping.baseLength);

    LOGD("dexLength_dexlen:%d", dexFile->pOptHeader->dexLength);


    data(dexFile, &mapping);

    makeFile(&dump_whole, "dump_whole");
    makeFile(&dump_opcode, "dump_opcode");
    makeFile(&class_data, "class_data");
    makeFile(&class_defs, "class_defs");


    makeFile(&hahahahah, "hahahahah");
    fwrite(mapping.addr, mapping.length, 1, &hahahahah);
    fclose(&hahahahah);
    //保存三倍dex文件长度
    //printDexHeader(dexFile);
    pthread_create(&mThread, NULL, AlertThreadStub, dexFile);



    /*size_t dlen = mapping.length * 2.5;//base64以后肯定会变长

    unsigned char *dst = (unsigned char *) malloc(dlen);

    base64_encode(dst, &dlen, (const unsigned char *) mapping.addr, mapping.length);//保存三倍dex文件长度




    sprintf(szPathxx, "/data/data/%s/cache/hahahahaha%d", mPackageName, mapping.length);
    LOGD("创建文件：%s", szPathxx);

    FILE *file = fopen(szPathxx, "wb+");
    //fwrite(mapping.addr, mapping.length, 1, file);//保存三倍dex文件长度
     fwrite(dst, dlen, 1, file);
    fclose(file);*/



}


static JNINativeMethod method[] = {

        {"aaattachBaseContext",
                "(ILjava/lang/String;)V",
                (void *) haha
        }

};


jint JNI_OnLoad(JavaVM *vm, void *reserved) {

    JNIEnv *env = NULL;
    jint result = -1;
    if (vm->GetEnv((void **) &env, JNI_VERSION_1_6) != JNI_OK) {
        return result;
    }
    jclass jclass1 = env->FindClass("com/dexpaser/zk/myapplication/MainActivity");
    int ret = env->RegisterNatives(jclass1, method, 1);

    if (ret < 0) {
        return result;
    }
    return JNI_VERSION_1_6;

}

void data(DexFile *pDexFile, MemMapping *mem) {
    /* char *temp = new char[100];
     strcpy(temp, szPathxx);
     strcat(temp, "part1");
     FILE *fppart11 = fopen(temp, "wb+");*/


    makeFile(&fppart1, "part1");


    const u1 *addr = (const u1 *) mem->addr;
    //int length = int(pDexFile->baseAddr + pDexFile->pHeader->classDefsOff - addr);
    int length = (pDexFile->pHeader->classDefsOff + sizeof(DexOptHeader));
    fwrite(addr, 1, length, &fppart1);
    fflush(&fppart1);
    fclose(&fppart1);

    /* strcpy(temp, szPathxx);
     strcat(temp, "data");
     fp_data = *fopen(temp, "wb+");*/

    makeFile(&fp_data, "data");

    addr = pDexFile->baseAddr + pDexFile->pHeader->classDefsOff +
           (sizeof(DexClassDef) * pDexFile->pHeader->classDefsSize);
    // length = int((const u1 *) mem->addr + mem->length - addr);
    length = int((const u1 *) mem->addr + mem->length - addr);
    fwrite(addr, 1, length, &fp_data);
    fflush(&fp_data);
    fclose(&fp_data);

}
u1 *writeunsignedleb128(u1 *ptr, u4 data) {

    while (true) { //循环

        u1 out = data & 0x7f;; //跟7F进行与运算 得出最后7位

        if (out != data) {

            *ptr++ = out | 0x80; //80就等于10000000 也就是跟前面补1
            fwrite(ptr-1, sizeof(u1), 1, &class_data);
            data >>= 7;// 继续下个7个字节

        } else {

            *ptr++ = out;
            fwrite(ptr-1, sizeof(u1), 1, &class_data);
            break;

        }

    }

    return ptr;

}

int readunsignedleb128(const u1 **pStream) {
    const u1 *ptr = *pStream;
    int result = *(ptr++);
    if (result > 0x7f) {
        int cur = *(ptr++);
        result = (result & 0x7f) | ((cur & 0x7f) << 7);
        if (cur > 0x7f) {
            cur = *(ptr++);
            result |= (cur & 0x7f) << 14;
            if (cur > 0x7f) {
                cur = *(ptr++);
                result |= (cur & 0x7f) << 21;
                if (cur > 0x7f) {
                    cur = *(ptr++);
                    result |= cur << 28;
                }
            }
        }
    }
    *pStream = ptr;
    return result;
}


class CodeItem {


    int register_size = 0;
    int ins_size = 0;
    int outs_size = 0;
    int tries_size = 0;
    //int tries[];
    int debug_info_off = 0;
    int insns_size = 0;
    // vector<u2> insns;

public:


    void dump(const u1 *addr) {


        memcpy(&register_size, addr, 2);
        memcpy(&ins_size, addr += 2, 2);
        memcpy(&outs_size, addr += 2, 2);
        memcpy(&tries_size, addr += 2, 2);
        memcpy(&debug_info_off, addr += 2, 4);
        memcpy(&insns_size, addr += 4, 4);
        addr += 4;

        LOGD("---------------Code_start--------------------");

        /* for (int i = 0; i < insns_size; ++i) {
             u2 xx;
             memcpy(&xx, (const void *) addr, 2);
             LOGD("%x", xx);
             insns.push_back(xx);
             addr += 2;
         }*/

        int insns_len = sizeof(char) * 2 * insns_size;

        char *insns = (char *) malloc(insns_len);
        memset(insns, 0, insns_len);
        memcpy(insns, addr, insns_len);

        fwrite(insns, insns_len, 1, &dump_opcode);
        for (int i = 0; i < insns_size; ++i) {
            LOGD("opcode:%02x", *(insns + i));
        }


        free(insns);

        LOGD("----------------Code_end-------------------");

        /*
        if (tries_size != 0 and insns_size % 2 == 1) {
        }

        for (int i = 0; i < tries_size; ++i) {
           *//* TryItem tryitem = TryItem();
            tryitem.dump(addr + len + 8 * i);
            tries.append(tryitem);*//*
        }
        if (tries_size != 0) {
           *//* EncodedhandlerList handler = EncodedhandlerList();
            handler.dump((const u1 **) (addr + len));
            len += handler.len;*//*
        }*/
    }
};


class Encodedfield {
public:
    int field_idx_diff = 0;
    int access_flags = 0;

    void dump(const u1 **addr) {
        field_idx_diff = readunsignedleb128(addr);
        int xx00 = 0;

        writeunsignedleb128((u1 *) &xx00, field_idx_diff);

        //fwrite(&xx00, sizeof(int), 1, &class_data);
        access_flags = readunsignedleb128(addr);
        writeunsignedleb128((u1 *) &xx00, access_flags);
        //fwrite(&xx00, sizeof(int), 1, &class_data);
    }

};


class Encodedmethod {
public:
    int method_idx_diff = 0;
    int access_flags = 0;
    int code_off = 0;

    void dump(const u1 **addr, DexClassDef *pDef) {
        method_idx_diff = readunsignedleb128(addr);
        access_flags = readunsignedleb128(addr);
        code_off = readunsignedleb128(addr);

        int xx00 = 0;

        writeunsignedleb128((u1 *) &xx00, method_idx_diff);

        //fwrite(&xx00, sizeof(int), 1, &class_data);

        writeunsignedleb128((u1 *) &xx00, access_flags);
        //fwrite(&xx00, sizeof(int), 1, &class_data);
        int code_addr = code_off + (long) dexHeader;


        //读字节码文件长度确定偏移
        fseek(&dump_opcode, 0, SEEK_END);
        long file_len = ftell(&class_data);

        writeunsignedleb128((u1 *) &xx00, file_len + mappingxx.length+140957);

        //fwrite(&xx00, sizeof(int), 1, &class_data);//这里重写写入偏移

        CodeItem codeItem;
        LOGD("函数名字--（%d）-----函数偏移(%d)-----------文件偏移(%d)", method_idx_diff, code_off,
             dexHeader->fileSize);
        if (code_off == 0) {
            LOGD("------------------------这个函数（%d）没有opcode", method_idx_diff);
            return;
        }
        if (code_off > dexHeader->fileSize) {
            LOGD("函数偏移大于文件偏移(%d)需要修复", code_off - dexHeader->fileSize);
        }

        codeItem.dump((const u1 *) code_addr);

    }

};


class ClassdataItem {
public:
    int static_field_size = 0;
    int instance_fields_size = 0;
    int direct_methods_size = 0;
    int virtual_methods_size = 0;
    vector<Encodedfield> static_fields;
    vector<Encodedfield> instance_fields;
    vector<Encodedmethod> direct_methods;
    vector<Encodedmethod> virtual_methods;


    void dump(const u1 **addr, DexClassDef *pDef) {
        int yy=0x2edf90;
        static_field_size = readunsignedleb128(addr);
        instance_fields_size = readunsignedleb128(addr);
        direct_methods_size = readunsignedleb128(addr);
        virtual_methods_size = readunsignedleb128(addr);
        int xx00=0;

        writeunsignedleb128((u1 *) &xx00, static_field_size);
        //fwrite(&xx00, sizeof(u1), 1, &class_data);
        writeunsignedleb128((u1 *) &xx00, instance_fields_size);
        //fwrite(&xx00, sizeof(u1), 1, &class_data);
        writeunsignedleb128((u1 *) &xx00, direct_methods_size);
        //fwrite(&xx00, sizeof(u1), 1, &class_data);
        writeunsignedleb128((u1 *) &xx00, virtual_methods_size);
        //fwrite(&xx00, sizeof(u1), 1, &class_data);


        for (int i = 0; i < static_field_size; ++i) {
            Encodedfield encodedfield;
            encodedfield.dump(addr);
            static_fields.push_back(encodedfield);
        }

        for (int i = 0; i < instance_fields_size; ++i) {
            Encodedfield encodedfield;
            encodedfield.dump(addr);
            instance_fields.push_back(encodedfield);
        }

        for (int i = 0; i < direct_methods_size; ++i) {

            Encodedmethod encodedfield;
            encodedfield.dump(addr, pDef);
            direct_methods.push_back(encodedfield);
        }


        for (int i = 0; i < virtual_methods_size; ++i) {
            Encodedmethod encodedfield;
            encodedfield.dump(addr, pDef);
            virtual_methods.push_back(encodedfield);
        }


    }


};


void printDexHeader(DexFile *pDexFile) {
    dexHeader = (DexHeader *) pDexFile->pHeader;
    LOGD("string off;%d", dexHeader->stringIdsOff);
    LOGD("type off;%d", dexHeader->typeIdsOff);
    LOGD("proto off;%d", dexHeader->protoIdsOff);
    LOGD("field off;%d", dexHeader->fieldIdsOff);
    LOGD("method off;%d", dexHeader->methodIdsOff);
    LOGD("classdef off;%d", dexHeader->classDefsOff);
    LOGD("classdef size:%d", dexHeader->classDefsSize);

    LOGD("这个dex一共有 %d 个类", dexHeader->classDefsSize);


    if (dexHeader->classDefsSize == 1) {
        LOGD("这个dex类太少。不解析");

        return;
    }


    LOGD("类偏移(%d)-------dexHeader->fileSize(%d)", dexHeader->classDefsOff, dexHeader->fileSize);
    if (dexHeader->classDefsOff > dexHeader->fileSize) {
        LOGD("类偏移大于文件偏移(%d)需要修复", dexHeader->classDefsOff - dexHeader->fileSize);
    }


    int new_pDexFile_len = sizeof(DexClassDef) * (dexHeader->classDefsSize);
    DexClassDef *new_pDexFile = (DexClassDef *) malloc(new_pDexFile_len);
    memcpy(new_pDexFile, pDexFile->pClassDefs, new_pDexFile_len);

    //fwrite(new_pDexFile, new_pDexFile_len, 1, &class_defs);

    char*strm= (char *) malloc(40);
    memset(strm,0,40);
    fwrite(strm, 40, 1, &class_data);
    fwrite(strm, 40, 1, &dump_opcode);
    for (int i = 0; i < dexHeader->classDefsSize; ++i) {

        fseek(&class_data, 0, SEEK_END);
        long file_len = ftell(&class_data);
        //fclose(&class_data);


        new_pDexFile->classDataOff = file_len + mappingxx.length;
        fwrite(new_pDexFile, sizeof(DexClassDef), 1, &class_defs);

        new_pDexFile++;

        if (pDexFile->pClassDefs->classDataOff == 0) {
            LOGD("------------------------类（%d）没有opcode", i);
            (pDexFile->pClassDefs)++;
            continue;
        } else {
            //int classDate_addr = pDexFile->pClassDefs->classDataOff + (long) dexHeader;
            int classDate_addr = pDexFile->pClassDefs->classDataOff + (long) dexHeader;

            int *pClassDate_addr = &classDate_addr;

            ClassdataItem classdataItem;
            LOGD("------------------------类（%d）开始", i);
            classdataItem.dump((const u1 **) pClassDate_addr, new_pDexFile);
            LOGD("------------------------类(%d)结束", i);
            (pDexFile->pClassDefs)++;
        }


    }

    fclose(&class_defs);

    writeFile("part1");
    writeFile("class_defs");
    writeFile("data");
    writeFile("class_data");
    //writeFile("dump_opcode");
    fclose(&class_defs);
    fclose(&fppart1);
    fclose(&fp_data);
    fclose(&dump_whole);
    fclose(&dump_opcode);
}



/*

*/
/*方法三，调用C库函数,*//*

char *join3(char *s1, char *s2) {
    char *result = (char *) malloc(strlen(s1) + strlen(s2) + 1);//+1 for the zero-terminator
    //in real code you would check for errors in malloc here
    if (result == NULL) exit(1);

    strcpy(result, s1);
    strcat(result, s2);

    return result;
}




string slashtodot(string str) {//#change '/' to '.'


    while (str.find("@") != -1) {
        str = str.replace(str.find("/"), 1, ".");
    }

    return str;
}


string dexGetStringData(DexFile dexfile, u4 offset) {
    u4 addr = (u4) (dexfile.baseAddr + offset);
    while (Byte(addr) > 0x7f) { //# skip uleb len
        addr += 1;
    }
    addr += 1;
    char *str = "";
    Byte one = Byte(addr);
    while (one != 0) {
        str += (char) one;
        addr += 1;
        one = Byte(addr);
    }

    return str;


}


u4 dexGetStringId(DexFile dexfile, u4 idx) {
    return (u4) (dexfile.pStringIds + 4 * idx);
}


string dexStringById(DexFile dexfile, u4 idx) {
    u4 offset = dexGetStringId(dexfile, idx);
    return dexGetStringData(dexfile, offset);
}
u4 dexGetTypeId(DexFile dexfile, u4 idx) {
    return (u4) (dexfile.pTypeIds + 4 * idx);
}


string dexStringByTypeIdx(DexFile dexfile, u4 idx) {
    return dexStringById(dexfile, dexGetTypeId(dexfile, idx));
}


string dexGetClassDescriptor(DexFile dexfile, DexClassDef classdef) {
    return dexStringByTypeIdx(dexfile, classdef.classIdx);
}


class TryItem {
    int start = 0;
    int len = 8;
    int start_addr = 0;
    int insn_count = 0;
    int handler_off = 0;


    int copytofile(int file) {
        int wlen = 0;
        file.write( struct.pack("I", start_addr));
        file.write( struct.pack("H", insn_count));
        file.write( struct.pack("H", handler_off));
        wlen += 4 + 2 + 2;
        return wlen;
    }

public:
    void dump(int addr) {
        start = addr;
        start_addr = (addr);
        insn_count = (addr + 4);
        handler_off = (addr + 6);
    }
};


class EncodedTypeAddrPair {
    int type_idx = 0;
    int addr = 0;


    int copytofile(u4 file) {
        int wlen = 0;
        wlen += (int) writeunsignedleb128((u1 *) type_idx, file);
        wlen += (int) writeunsignedleb128((u1 *) addr, file);
        return wlen;
    }

public:
    void dump(int ddr) {
        int type_idx, length = readunsignedleb128((const u1 **) addr);
        len += length;
        addr, length = readunsignedleb128((const u1 **) (addr + length));
        len += length;
    }

    int len = 0;
};


class EncodedhandlerItem {
    int start = 0;
    int size = 0;
    int handlers[];
    int catch_all_addr = 0;


    int copytofile(int file) {
        int wlen = 0;
        wlen += (int)writeunsignedleb128((u1 *) size, file);

        for (int i = 0; i < abs(size); ++i) {
            wlen += handlers[i].copytofile(file);
        }


        if (size <= 0) {//:
            wlen += (int) writeunsignedleb128((u1 *) catch_all_addr, file);
        }

        return wlen;
    }

public:
    void dump(int addr) {
        start = addr;
       int size, length = readunsignedleb128((const u1 **) addr);
        len += length;

        for (int i = 0; i < abs(size); ++i) {
            EncodedTypeAddrPair pair = EncodedTypeAddrPair();
            pair.dump(addr + len);
            len += pair.len;
            handlers.append(pair);
        }


        if (size <= 0) {
            int catch_all_addr, length = readunsignedleb128((const u1 **) (addr + len));
            len += length;
        }

    }

    int len = 0;
};


class EncodedhandlerList {
    int start = 0;
    int size = 0;
    int list[];


    int copytofile(int file) {
        int wlen = 0;
        wlen += (int) writeunsignedleb128((u1 *) size, file);

        for (int i = 0; i < size; ++i) {
            wlen += list[i].copytofile(file);
        }


        return wlen;
    }


public:
    void dump(const u1 **addr) {
        start = (int) addr;
        int size, length = readunsignedleb128(addr);
        len += length;

        for (int i = 0; i < size; ++i) {
            EncodedhandlerItem handler = EncodedhandlerItem();
            handler.dump((int) (addr + len));
            len += handler.len;
            list.append(handler);
        }


    }

    int len = 0;
};







void copytofile(char *dump_dir, DexFile dexFile) {
    DexHeader *pDexHeader = (DexHeader *) dexFile.pHeader;
    FILE *classfile = fopen(join3(dump_dir, "classdef"), "wb+");
    FILE *extra = fopen(join3(dump_dir, "extra"), "wb+");
    FILE *logger = fopen(join3(dump_dir, "log.txt"), "w");

    u4 num_class_def = pDexHeader->classDefsSize;
    u4 total_point = pDexHeader->dataOff + pDexHeader->dataSize;
    u4 start = pDexHeader->dataOff;
    u4 end = total_point;
    while (total_point & 3) { //#Align 4
        total_point += 1;
    }

    LOGD("num class def:%d", num_class_def);
    for (int i = 0; i < num_class_def; ++i) {
        LOGD("cur class:%d,Total:%d", i, num_class_def);
        DexClassDef classdef = DexClassDef();
        DexClassDef_dump((int) (dexFile.pClassDefs + 32 * i), classdef);
        string descriptor = dexGetClassDescriptor(dexFile, classdef);
        bool need_extra = false;
        bool need_pass = false;
        string tmp = slashtodot(descriptor);
//# if descriptor.startswith("Landroid") or classdef.classDataOff == 0:        #skip class Landroid... anyway it can't be used...
//#     need_pass = True
//#     print "des:", tmp, "is passed"
        if (classdef.classDataOff == 0) {        //#skip class Landroid...
            bool need_pass = true;
            LOGD("des:%s is passed", tmp);

        } else {
            LOGD("des %s", tmp);

            if (classdef.classDataOff < start || classdef.classDataOff > end) {
                bool need_extra = true;
            }

            ClassdataItem classdata = ClassdataItem();
            classdata.dump((const u1 **) (dexFile.baseAddr + classdef.classDataOff));
            if (classdata.direct_methods_size) {

                for (int j = 0; j < classdata.direct_methods_size; ++j) {
                    method = classdata.direct_methods[j];
                    if (method.code_off == 0) {
                        continue;
                    }
                    if (method.access_flags & 0x100) {// # native func or ..
                        need_extra = true;
                        method.code_off = 0;
                        continue;
                    }

                    if (method.code_off < start or method.code_off > end) {
                        need_extra = true;
                        CodeItem codeitem = CodeItem();
                        codeitem.dump(int(self.baseAddr + method.code_off));
//#writefile(extra, int(self.baseAddr+method.code_off), codeitem.len)
                        wlen = codeitem.copytofile((int) extra);
                        method.code_off = total_point;
//# total_point += codeitem.len
                        total_point += wlen;
                        while (total_point & 3) {
                            extra.write(
                            struct.pack("B", 0));
                            total_point += 1;
                        }

                    }


                }


            }

            if (classdata.virtual_methods_size) {

                for (int j = 0; j < classdata.virtual_methods_size; ++j) {
                    method = classdata.virtual_methods[j];
                    if (method.code_off == 0) {
                        continue;
                    }
                    if (method.access_flags & 0x100) {//:     # native  func or ..
                        need_extra = true;
                        method.code_off = 0;
                        continue;
                    }

                    if (method.code_off < start or method.code_off > end) {//:
                        need_extra = true;
                        CodeItem codeitem = CodeItem();
                        codeitem.dump(int(self.baseAddr + method.code_off));
//# writefile(extra, int(self.baseAddr+method.code_off), codeitem.len)
                        wlen = codeitem.copytofile(extra);
                        method.code_off = total_point;
                        total_point += wlen;
//# total_point += codeitem.len
                        while (total_point & 3) {//:
                            extra.write(
                            struct.pack("B", 0));
                            total_point += 1;
                        }
                    }
                }


            }
        }


        if (need_extra) {
            classdef.classDataOff = total_point;
            wlen = classdata.copytofile(extra);
            total_point += wlen;
            while (total_point & 3) {//:
                extra.write(
                struct.pack("B", 0));
                total_point += 1;
            }

            classdef.copytofile(classfile);
            if (self.pOptHeader != 0) {
                LOGD("dump OptHeader");

                optdex = self.pOptHeader + self.OptHeader.depsOffset;        //    #get  opt table
                writefile(extra, optdex, self.OptHeader.optOffset - self.OptHeader.depsOffset +
                                         self.OptHeader.optLength);
                self.OptHeader.optOffset =
                        total_point + self.OptHeader.optOffset - self.OptHeader.depsOffset + 40;
                self.OptHeader.depsOffset = total_point + 40;
            }

        }

        extra.close();
        classfile.close();
        logger.close();

        self.saveHeaderandData();
        whole = open(dump_dir + "whole.dex", "wb+");
        with
                open(dump_dir + "header", "rb");
        as header:
        whole.writelines(header.readlines());
        with
                open(dump_dir + "classdef", "rb");
        as classfile:
        whole.writelines(classfile.readlines());
        with
                open(dump_dir + "data", "rb");
        as data:
        whole.writelines(data.readlines());
        with
                open(dump_dir + "extra", "rb");
        as extra:
        whole.writelines(extra.readlines())
        whole.close()
        print("DONE")
    }

*/

}
