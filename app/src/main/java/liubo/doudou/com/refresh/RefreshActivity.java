package liubo.doudou.com.refresh;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import doudou.library.com.refresh.custom.CustomHeadViewRefreshViewHolder;
import doudou.library.com.refresh.custom.util.RefreshLayout;
import liubo.doudou.com.R;

/**
 * @author liubo
 *         Create at 16/7/11 14:38.
 */
public class RefreshActivity extends Activity implements RefreshLayout.BGARefreshLayoutDelegate {
//    @BindView(R.id.refresh_listView)
//    ListView refreshListView;
//    @BindView(R.id.refreshLayout)
//    RefreshLayout refreshLayout;
    private List<Integer> list = new ArrayList<>();
    NormalAdapterViewAdapter mAdapter;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refresh);
//        ButterKnife.bind(this);
        ListView refreshListView = (ListView) findViewById(R.id.refresh_listView);
        RefreshLayout refreshLayout = (RefreshLayout) findViewById(R.id.refreshLayout);
        for (int i = 0; i < 20; i++) {
            list.add(i);
        }
//        refreshLayout.setRefreshViewHolder(new NormalRefreshViewHolder(this,true));

        CustomHeadViewRefreshViewHolder meiTuanRefreshViewHolder = new CustomHeadViewRefreshViewHolder(this, true);
        meiTuanRefreshViewHolder.setPullDownImageResource(R.mipmap.bga_refresh_mt_pull_down);
        meiTuanRefreshViewHolder.setChangeToReleaseRefreshAnimResId(R.drawable.bga_refresh_mt_change_to_release_refresh);
        meiTuanRefreshViewHolder.setRefreshingAnimResId(R.drawable.bga_refresh_mt_refreshing);

        refreshLayout.setRefreshViewHolder(meiTuanRefreshViewHolder);
//        refreshLayout.setCustomHeaderView(DataEngine.getCustomHeaderView(mApp), true);

        mAdapter = new NormalAdapterViewAdapter(this, list);
        refreshListView.setAdapter(mAdapter);
//        refreshListView.setOnScrollListener(new AbsListView.OnScrollListener() {
//            public void onScrollStateChanged(AbsListView view, int scrollState) {
//                if (AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL == scrollState) {
//                    mAdapter.closeOpenedSwipeItemLayoutWithAnim();
//                }
//            }
//
//            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
//
//            }
//        });


        refreshLayout.setDelegate(this);
    }


    public void onBGARefreshLayoutBeginRefreshing(RefreshLayout refreshLayout) {
    }

    public boolean onBGARefreshLayoutBeginLoadingMore(RefreshLayout refreshLayout) {
        return true;
    }

     class  NormalAdapterViewAdapter extends BaseAdapter{
        private LayoutInflater mInflater;
         private List<Integer> list;
        public NormalAdapterViewAdapter(Context refreshActivity, List<Integer> list) {
           this.mInflater = LayoutInflater.from(refreshActivity);
            this.list = list;
            Log.e("数据:",list.size() + "");
        }

        public int getCount() {
            return list.size();
        }

        public Object getItem(int i) {
            return i;
        }

        public long getItemId(int i) {
            return list.get(i);
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            view = mInflater.inflate(R.layout.listview_item_refresh,viewGroup,false);
            TextView text = (TextView) view.findViewById(R.id.re_text);
            text.setText(list.get(i) + "");
            return view;
        }
    }
}
