package liubo.doudou.com;

import android.app.Application;
import android.os.Build;
import android.os.StrictMode;

import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

import doudou.library.com.okhttp.OkHttpUtils;
import doudou.library.com.okhttp.https.HttpsUtils;
import doudou.library.com.okhttp.log.LoggerInterceptor;
import okhttp3.OkHttpClient;

/**
 * @author liubo
 *         Create at 16/7/7 10:27.
 */
public class myApplication extends Application {
    public void onCreate() {
        super.onCreate();

        enabledStrictMode();
//        LeakCanary.install(this);

        HttpsUtils.SSLParams sslParams = HttpsUtils.getSslSocketFactory(null, null, null);
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(10000L, TimeUnit.MILLISECONDS)
                .readTimeout(10000L, TimeUnit.MILLISECONDS)
                .addInterceptor(new LoggerInterceptor("TAG"))
                .hostnameVerifier(new HostnameVerifier()
                {
                    public boolean verify(String hostname, SSLSession session)
                    {
                        return true;
                    }
                })
                .sslSocketFactory(sslParams.sSLSocketFactory, sslParams.trustManager)
                .build();
        OkHttpUtils.initClient(okHttpClient);

    }

    private void enabledStrictMode() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD) {
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder() //
                    .detectAll() //
                    .penaltyLog() //
                    .penaltyDeath() //
                    .build());
        }
    }
}
