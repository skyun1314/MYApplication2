package com.example.zk.myapplication;

/**
 * Created by zk on 2017/6/10.
 */

import android.telephony.TelephonyManager;

import com.saurik.substrate.MS;

import java.lang.reflect.Method;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XC_MethodReplacement;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class Main implements IXposedHookLoadPackage {

    static void initialize(){
        // 1. hook 对应的类
        MS.hookClassLoad("android.content.res.Resources", new MS.ClassLoadHook() {
            @Override
            public void classLoaded(Class<?> Resources) {
                // 2. hook对应方法
                // 2.1 获取老的方法对象
                Method getColor = null;
                // public int getColor(@ColorRes int id) throws NotFoundException
                try {
                    getColor = Resources.getMethod("getColor", Integer.TYPE);
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                }

                if (getColor == null){
                    return;
                }

                // 2.2 指定新的方法
                final MS.MethodPointer old = new MS.MethodPointer();
                MS.hookMethod(Resources, getColor, new MS.MethodHook() {
                    @Override
                    public Object invoked(Object res, Object... args) throws Throwable {
                        // 调用原方法
                        int color = (int) old.invoke(res, args);
                        // 修改方法返回值，指定新的颜色
                        return color & ~0x0000ff00 | 0x00ff0000;
                    }
                }, old);
            }
        });



    }

    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam loadPackageParam) throws Throwable {
        hook1(loadPackageParam);
        hook2(loadPackageParam);
    }
    private void hook1(XC_LoadPackage.LoadPackageParam loadPackageParam) {
        // 判断是否是要Hook的包名
        String packageName = loadPackageParam.packageName;
        if (!packageName.equals("com.bluelesson.testphoneinfo")){
            return;
        }
        XposedBridge.log("可以 hook了");
        // 可以Hook了
        XposedHelpers.findAndHookMethod(TelephonyManager.class, "getDeviceId", new XC_MethodReplacement() {
            @Override
            protected Object replaceHookedMethod(MethodHookParam methodHookParam) throws Throwable {
                return "我的手机我说了算";
            }
        });
    }

    private void hook2(XC_LoadPackage.LoadPackageParam loadPackageParam) {
        // 判断是否是要Hook的包名
        String packageName = loadPackageParam.packageName;
        if (!packageName.equals("com15pb.crackme02")){
            return;
        }
        XposedBridge.log("可以 hook了");
        // 可以Hook了
        XposedHelpers.findAndHookMethod("com15pb.crackme02.MainActivity",
                loadPackageParam.classLoader,
                "CheckRegister", String.class, String.class,
                new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        super.beforeHookedMethod(param);
                        XposedBridge.log("arg1:" + param.args[0]);
                        XposedBridge.log("arg2:" + param.args[1]);
                    }

                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        super.afterHookedMethod(param);

                        param.setResult(true);

                    }
                }
        );
    }
}
