package liubo.doudou.com.listview;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import doudou.library.com.refresh.custom.water.WaterDropListView;
import liubo.doudou.com.R;

/**
 * @author liubo
 *         Create at 16/7/7 16:26.
 */
public class WaterListView extends Activity implements WaterDropListView.IWaterDropListViewListener{
    private WaterDropListView waterDropListView;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 1:
                    waterDropListView.stopRefresh();
                    break;
                case 2:
                    waterDropListView.stopLoadMore();
                    break;
            }

        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        waterDropListView = (WaterDropListView) findViewById(R.id.waterdrop_listview);
        waterDropListView.setAdapter(new ArrayAdapter<Integer>(this, android.R.layout.simple_expandable_list_item_1, getData()));
        waterDropListView.setWaterDropListViewListener(this);
        waterDropListView.setPullLoadEnable(true);
    }

    private List<Integer> getData(){

        List<Integer> data = new ArrayList<>();
        for (int i = 0; i < 17; i++) {
            data.add(i);
        }

        return data;
    }
    public void onRefresh() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                    handler.sendEmptyMessage(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

    }

    public void onLoadMore() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                    handler.sendEmptyMessage(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
