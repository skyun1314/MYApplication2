package com.example.zk.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import java.lang.ref.WeakReference;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.Map;

import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

/**
 * Created by zk on 2017/8/24.
 */

public class hookCookie {

    public static void replaceClassLoader(Context context, String my_packageName) {
        try {
            Class<?> aClass = Class.forName("android.app.ActivityThread");
            Class<?> aClass1 = Class.forName("android.app.LoadedApk");

            Object currentActivityThread = aClass.getMethod("currentActivityThread").invoke(new Object[]{});


            Field mPackages = aClass.getDeclaredField("mPackages");
            mPackages.setAccessible(true);
            Map map = (Map) mPackages.get(currentActivityThread);
            WeakReference o = (WeakReference) map.get(context.getPackageName());
            Object loadedapk = o.get();
            Field mClassLoader = aClass1.getDeclaredField("mClassLoader");
            mClassLoader.setAccessible(true);


            Object classLoader = mClassLoader.get(loadedapk);
            Class clzBaseDexClassLoader = Class.forName("dalvik.system.BaseDexClassLoader");
            Class clzDexPathList = Class.forName("dalvik.system.DexPathList");
            Field field_pathList = clzBaseDexClassLoader.getDeclaredField("pathList");
            field_pathList.setAccessible(true);
            Object dexPathList = field_pathList.get(classLoader);
            Field field_dexElements = clzDexPathList.getDeclaredField("dexElements");
            field_dexElements.setAccessible(true);
            Class clzElement = Class.forName("dalvik.system.DexPathList$Element");
            Object dexElemennts = field_dexElements.get(dexPathList);

            //int cookie=MmClassLoader.getcookie();
            int length = Array.getLength(dexElemennts);

            for (int i = 0; i < length; i++) {
                Object ele = Array.get(dexElemennts, i);

                try {
                    Field field_dexFile = clzElement.getDeclaredField("dexFile");
                    field_dexFile.setAccessible(true);
                    Object dexFile = field_dexFile.get(ele);

                    Class clzDexFile = Class.forName("dalvik.system.DexFile");
                    Field field_mcookie = clzDexFile.getDeclaredField("mCookie");
                    field_mcookie.setAccessible(true);
                    //field_mcookie.set(dexFile, mCookie);
                    int o1 = (int) field_mcookie.get(dexFile);
                    Log.e("wodelog","o1---- "+o1);
                    XposedBridge.log("cookie: "+o1);

                    MainActivity.aaattachBaseContext(o1,my_packageName);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void hookCookie(final XC_LoadPackage.LoadPackageParam lpparam) {
        // 判断是否是要Hook的包名
        final String packageName = lpparam.packageName;


       // final String my_packageName="com.example.haha";
        final String  my_packageName="com.zxjw.superinstaller";

        /*XposedHelpers.findAndHookMethod("android.app.Activity", lpparam.classLoader, "finish", new XC_MethodReplacement() {

            @Override
            protected Object replaceHookedMethod(MethodHookParam methodHookParam) throws Throwable {
                XposedBridge.log("阻止finish");
                return null;
            }
        });*/

        // 可以Hook了
        if(packageName.equals(my_packageName)){
            XposedBridge.log("可以 hook cookie");




            XposedHelpers.findAndHookMethod("com.bangcle.protect.ApplicationWrapper", lpparam.classLoader, "onCreate",  new XC_MethodHook() {
                @Override
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {

                    ClassLoader xx= (ClassLoader) XposedHelpers.getObjectField(param.thisObject,"cl");
                    Context context = (Context) param.thisObject;

                    ClassLoader classLoader =context.getClassLoader();
                    XposedHelpers.findAndHookMethod("com.zxjw.superinstaller.ui.InstallActivity", classLoader, "onCreate", Bundle.class, new XC_MethodHook() {
                        @Override
                        protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                            replaceClassLoader((Context) param.thisObject,my_packageName);

                        }
                    });

                }
            });


/*

            XposedHelpers.findAndHookMethod("com.example.haha.MainActivity", lpparam.classLoader, "onCreate", Bundle.class, new XC_MethodHook() {
                @Override
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    replaceClassLoader((Context) param.thisObject,my_packageName);

                }
            });
*/


        }

    }
    static {
        System.load("/data/data/com.example.zk.myapplication/lib/libzkjg-lib.so");
    }
}
