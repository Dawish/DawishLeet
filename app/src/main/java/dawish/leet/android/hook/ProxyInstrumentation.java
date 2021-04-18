package dawish.leet.android.hook;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;

import java.lang.reflect.Method;

import dawish.leet.DLog;

/**
 * 代理
 *
 * @author danxingxi
 */
public class ProxyInstrumentation extends Instrumentation {

    private static final String TAG = "ProxyInstrumentation";
    Instrumentation base;

    public ProxyInstrumentation(Instrumentation base) {
        this.base = base;
    }

    @Override
    public boolean onException(Object obj, Throwable e) {

        DLog.I(TAG, "onException obj:" + obj, e);

        return super.onException(obj, e);
    }


    public ActivityResult execStartActivity(
            Context who, IBinder contextThread, IBinder token, Activity target,
            Intent intent, int requestCode, Bundle options) {

        Log.d("ApplicationContextHook", "execStartActivity hook add log");

        //这里还要执行系统的原本逻辑，execStartActivity是@hide的，只能反射
        try {
            Class<?> InstrumentationClz = Class.forName("android.app.Instrumentation");
            Method execStartActivity = InstrumentationClz.getDeclaredMethod("execStartActivity",
                    Context.class,
                    IBinder.class,
                    IBinder.class,
                    Activity.class,
                    Intent.class,
                    int.class,
                    Bundle.class);

            return (ActivityResult) execStartActivity.invoke(base,
                    who,
                    contextThread,
                    token,
                    target,
                    intent,
                    requestCode,
                    options);
        } catch (Exception e) {
            DLog.E(TAG, "execStartActivity", e);
        }

        return null;
    }

}
