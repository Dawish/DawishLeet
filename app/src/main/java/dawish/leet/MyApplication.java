package dawish.leet;

import android.app.Application;
import android.content.res.Configuration;

import dawish.leet.Solution.android.MyUncaughtExceptionHandler;

public class MyApplication extends Application {


    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Thread.setDefaultUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
    }
}
