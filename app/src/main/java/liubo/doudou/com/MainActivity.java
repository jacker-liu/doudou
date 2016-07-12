package liubo.doudou.com;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.io.File;
import java.util.List;

import doudou.library.com.fastJson.FastJsonUtil;
import doudou.library.com.okhttp.OkHttpUtils;
import doudou.library.com.okhttp.callback.FileCallBack;
import doudou.library.com.okhttp.callback.StringCallback;
import okhttp3.Call;


public class MainActivity extends AppCompatActivity {
    private ProgressDialog mProgressBar;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mProgressBar = new ProgressDialog(this);
        mProgressBar.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        mProgressBar.setMessage("正在下载");
        mProgressBar.show();

        OkHttpUtils
                .get()
                .url("http://songhuolang.jnszkj.com/uploads/version/app-1.0.apk")
                .build()
                .execute(new FileCallBack(Environment.getExternalStorageDirectory().getAbsolutePath(),"送货郎.apk") {
            public void onError(Call call, Exception e, int id) {

            }

            public void onResponse(File file, int id) {
                Log.e("文件地址:",  file.getAbsolutePath());

            }
            public void inProgress(float progress, long total, int id) {
                super.inProgress(progress, total, id);
                mProgressBar.setProgress((int) (100 * progress));
            }
        });

        OkHttpUtils.get().url("http://jiuye.jnszkj.com/api/h-news/list/cate").build().execute(new StringCallback() {
            public void onError(Call call, Exception e, int id) {

            }


            public void onResponse(String response, int id) {
                List<NewsModel> list = FastJsonUtil.initFast().getStringArray(response,NewsModel.class);

                Log.e("我的数据id",list.get(0).getId());
            }
        });

    }
}
