package dawish.leet;

import android.app.Application;
import android.content.res.Configuration;

import dawish.leet.android.MyUncaughtExceptionHandler;
import dawish.leet.android.hook.InstrumentationHookHelper;

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Thread.setDefaultUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
        InstrumentationHookHelper.hook();
    }
}
