package dawish.leet;

import android.app.Application;
import android.os.Process;

import dawish.leet.android.MyUncaughtExceptionHandler;
import dawish.leet.android.hook.InstrumentationHookHelper;

/**
 * 多进程会让同一个Application启动两次，onCreate方法执行两次
 *
 * @author danxingxi
 */
public class MyApplication extends Application {

    private static final String TAG = "MyApplication";

    @Override
    public void onCreate() {
        super.onCreate();

        DLog.D(TAG, "============================");
        DLog.D(TAG, "MyApplication:" + MyApplication.this);
        DLog.D(TAG, "pid:" + Process.myPid());
        DLog.D(TAG, "thread:" + Thread.currentThread());

        // handle exception
        Thread.setDefaultUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
        // hook
        InstrumentationHookHelper.hook();
    }
}
