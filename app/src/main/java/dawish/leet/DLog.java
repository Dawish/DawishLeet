package dawish.leet;

import android.util.Log;

/**
 * debug log
 *
 * @author danxinxgi
 */
public final class DLog {
    private static boolean DEBUG = BuildConfig.DEBUG;

    public static void D (String tag, String msg) {
        if (DEBUG) {
            Log.d(tag, msg);
        }
    }

    public static void I (String tag, String msg) {
        if (DEBUG) {
            Log.i(tag, msg);
        }
    }

    public static void W (String tag, String msg) {
        if (DEBUG) {
            Log.w(tag, msg);
        }
    }

    public static void E (String tag, String msg) {
        if (DEBUG) {
            Log.e(tag, msg);
        }
    }

    public static void I (String tag, String msg, Throwable tr) {
        if (DEBUG) {
            Log.i(tag, msg, tr);
        }
    }

    public static void W (String tag, String msg, Throwable tr) {
        if (DEBUG) {
            Log.w(tag, msg, tr);
        }
    }

    public static void E (String tag, String msg, Throwable tr) {
        if (DEBUG) {
            Log.e(tag, msg, tr);
        }
    }
    
}
