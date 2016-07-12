package doudou.library.com.refresh.normal;

import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebView;

/**
 * WebView上拉加载下拉刷新
 * @author liubo
 *         Create at 16/7/11 14:31.
 */
public class PullableWebView extends WebView implements PullAble
{

    public PullableWebView(Context context)
    {
        super(context);
    }

    public PullableWebView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
    }

    public PullableWebView(Context context, AttributeSet attrs, int defStyle)
    {
        super(context, attrs, defStyle);
    }

    @Override
    public boolean canPullDown()
    {
        if (getScrollY() == 0)
            return true;
        else
            return false;
    }

    @Override
    public boolean canPullUp()
    {
        if (getScrollY() >= getContentHeight() * getScale()
                - getMeasuredHeight())
            return true;
        else
            return false;
    }
}
