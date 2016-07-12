package doudou.library.com.okhttp.utils;

import android.util.Log;

/**
 *
 * @author lb
 * create at 16/7/7.上午11:21
 **/
public class L
{
    private static boolean debug = false;

    public static void e(String msg)
    {
        if (debug)
        {
            Log.e("OkHttp", msg);
        }
    }

}

