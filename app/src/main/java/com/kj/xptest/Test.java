package com.kj.xptest;

import android.util.Log;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

import static de.robv.android.xposed.XposedHelpers.findAndHookMethod;

/**
 * Created by kangjie on 2018/12/12.
 */
public class Test implements IXposedHookLoadPackage {
    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam lpparam) throws Throwable {
        XposedBridge.log("Loaded Test app:_______________________________________________________________________________________________ " +
                lpparam.packageName);
        Log.e("aaa","___________________________________________");

        findAndHookMethod("com.meituan.banma.update.UpdateChecker", lpparam.classLoader, "b", String.class,
                String.class, new XC_MethodHook() {

                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        XposedBridge.log("开始劫持了~");
                        XposedBridge.log("参数1 = " + param.args[0]);
                        XposedBridge.log("参数2 = " + param.args[1]);
                    }

                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        XposedBridge.log("劫持结束了~");
                        XposedBridge.log("参数1 = " + param.args[0]);
                        XposedBridge.log("参数2 = " + param.args[1]);

                    }
                });
    }


    /**
     * 包加载时候的回调
     */
  /*  public void handleLoadPackage(final LoadPackageParam lpparam) throws Throwable {

        // 将包名不是 com.example.login 的应用剔除掉
        if (!lpparam.packageName.equals("com.example.login"))
            return;
        XposedBridge.log("Loaded app: " + lpparam.packageName);

        // Hook MainActivity中的isCorrectInfo(String,String)方法
        findAndHookMethod("com.example.login.MainActivity", lpparam.classLoader, "isCorrectInfo", String.class,
                String.class, new XC_MethodHook() {

                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        XposedBridge.log("开始劫持了~");
                        XposedBridge.log("参数1 = " + param.args[0]);
                        XposedBridge.log("参数2 = " + param.args[1]);
                    }

                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        XposedBridge.log("劫持结束了~");
                        XposedBridge.log("参数1 = " + param.args[0]);
                        XposedBridge.log("参数2 = " + param.args[1]);

                    }
                });
    }*/

}
