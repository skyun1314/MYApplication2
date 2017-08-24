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

#include <fcntl.h>
#include <sys/mman.h>
#include <android/asset_manager.h>
#include <android/asset_manager_jni.h>

#define LOGD(...)  __android_log_print(ANDROID_LOG_DEBUG,"wodelog", __VA_ARGS__)
extern "C" {
JNIEXPORT void JNICALL
haha(JNIEnv *env, jobject instance, jint cookie,jstring pact) {


    if(cookie==0||cookie==NULL){
        LOGD( "无效输入");
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
    LOGD( "MemMapping:filename:%s  addr:%x length:%x baseAddr:%x baseLength:%x",pDexOrJar->fileName, mapping.addr,  mapping.length, mapping.baseAddr, mapping.baseLength);


   /* for (int i = 0; i < mapping.length; ++i) {
        LOGD("%x", mapping.addr[i]);
    }*/

    size_t dlen=mapping.length*2.5*3;//保存三倍dex文件长度

    unsigned char *dst=(unsigned char*)malloc(dlen);

    base64_encode(dst, &dlen, (const unsigned char *) mapping.addr, mapping.length);


   char* mPackageName = (char *) env->GetStringUTFChars(pact, 0);

    char szPathxx[260] = {0};
    sprintf(szPathxx, "/data/data/%s/cache/hahahahaha%d", mPackageName,cookie);
    LOGD( "创建文件：%s",szPathxx);

    FILE* file= fopen(szPathxx,"wb+");
    //  fwrite(mapping.addr,mapping.length*3,1,file);//保存三倍dex文件长度
   fwrite(dst, dlen, 1, file);
    fclose(file);
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
    jclass jclass1 = env->FindClass("com/example/zk/myapplication/MainActivity");
    int ret = env->RegisterNatives(jclass1, method, 1);

    if (ret < 0) {
        return result;
    }
    return JNI_VERSION_1_6;

}
}
