package doudou.library.com.refresh.normal;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;

/**
 * ListView上拉加载数据
 * @author liubo
 *         Create at 16/7/8 14:56.
 */
public class PullLoadDataListView extends ListView implements AbsListView.OnScrollListener {
    /**
     * 底部显示正在加载的页面
     */
    private View footerView = null;
    /**
     * 存储上下文
     */
    private Context context;
    /**
     * 上拉刷新的ListView的回调监听
     */
    private OnMoreDateListener onmoredata;

    public PullLoadDataListView(Context context) {
        super(context);
        this.context = context;
        init();
    }

    public PullLoadDataListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init();
    }

    private void init() {
        setOnScrollListener(this);
        setFooterDividersEnabled(false);
    }
    private int lastItemIndex;
    public void onScrollStateChanged(AbsListView view, int scrollState) {
        switch (scrollState) {
            case SCROLL_STATE_TOUCH_SCROLL:
                lastItemIndex = view.getLastVisiblePosition();
                break;
            case SCROLL_STATE_IDLE:
                int scrolled = view.getLastVisiblePosition();
                if (scrolled > lastItemIndex) { //向下滑
                    if (view.getLastVisiblePosition() == (view.getCount() - 1)) {
                        onMoreRefresh();
                    }
                }
                break;
        }
    }
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {}

    public interface OnMoreDateListener {
        void OnMoreFresh();
    }
    public void setOnMoreDateListener(OnMoreDateListener onmoredata ){
        this.onmoredata = onmoredata ;
    }

    private void onMoreRefresh() {
        if (onmoredata != null) {
            onmoredata.OnMoreFresh();
        }
    }
}

