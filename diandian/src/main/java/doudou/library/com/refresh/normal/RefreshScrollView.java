package doudou.library.com.refresh.normal;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

/**
 * ScrollView上拉刷新下拉加载
 * @author liubo
 * create at 16/7/11.下午2:31
 **/
public class RefreshScrollView extends ScrollView implements PullAble {

    public RefreshScrollView(Context context) {
        super(context);
    }

    public RefreshScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public RefreshScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public boolean canPullDown() {
        if (getScrollY() == 0)
            return true;
        else
            return false;
    }

    public boolean canPullUp() {
        if (getScrollY() >= (getChildAt(0).getHeight() - getMeasuredHeight()))
            return true;
        else
            return false;
    }
}
