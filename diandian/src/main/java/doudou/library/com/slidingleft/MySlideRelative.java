package doudou.library.com.slidingleft;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;

/**
 * 侧滑菜单辅助类(可以看到的视图)
 * @author liubo
 *         Create at 16/7/11 13:35.
 */
public class MySlideRelative extends RelativeLayout {
    private DragLayout dl;

    public MySlideRelative(Context context) {
        super(context);
    }

    public MySlideRelative(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MySlideRelative(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public void setDragLayout(DragLayout dl) {
        this.dl = dl;
    }

    public boolean onInterceptTouchEvent(MotionEvent event) {
        if (dl.getStatus() != DragLayout.Status.Close) {
            return true;
        }
        return super.onInterceptTouchEvent(event);
    }

    public boolean onTouchEvent(MotionEvent event) {
        if (dl.getStatus() != DragLayout.Status.Close) {
            if (event.getAction() == MotionEvent.ACTION_UP) {
                dl.close();
            }
            return true;
        }
        return super.onTouchEvent(event);
    }

}


