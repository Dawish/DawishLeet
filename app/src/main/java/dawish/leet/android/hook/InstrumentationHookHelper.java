package dawish.leet.android.hook;

import android.app.Instrumentation;

import java.lang.reflect.Field;

import dawish.leet.DLog;

public class InstrumentationHookHelper {
    private static final String TAG = "InstrumentationHookHelper";

    public static void hook() {

        try {
            // 主线程ActivityThread为单例，可以直接获取
            Class<?> ActivityThreadClazz = Class.forName("android.app.ActivityThread");
            // 获得当前主线程sCurrentActivityThread
            Field sCurrentActivityThreadField =
                    ActivityThreadClazz.getDeclaredField("sCurrentActivityThread");
            sCurrentActivityThreadField.setAccessible(true);
            // 静态变量的属性get不需要参数，传null即可.
            Object sCurrentActivityThreadObj = sCurrentActivityThreadField.get(null);
            // 获得mInstrumentation
            Field mInstrumentationField = ActivityThreadClazz.getDeclaredField("mInstrumentation");
            mInstrumentationField.setAccessible(true);
            Instrumentation base = (Instrumentation) mInstrumentationField.get(sCurrentActivityThreadObj);

            ProxyInstrumentation proxyInstrumentation = new ProxyInstrumentation(base);

            mInstrumentationField.set(sCurrentActivityThreadObj, proxyInstrumentation);

            DLog.D(TAG, "hook success!");
        } catch (ClassNotFoundException e) {
            DLog.E(TAG, "hook", e);
        } catch (NoSuchFieldException e) {
            DLog.E(TAG, "hook", e);
        } catch (IllegalAccessException e) {
            DLog.E(TAG, "hook", e);
        }

    }

}
