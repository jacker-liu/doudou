package doudou.library.com.adapter;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;


/**
 * 辅助baseAdapter 的 ViewHolder
 * @author liubo
 * Created at 2016/1/11 15:44.
 */
public class ViewHolder {
    private SparseArray<View> mView;
    private int mPosition;
    private View mConvertView;
    private Context mContext;

    public ViewHolder(Context context, ViewGroup parent, int layoutId,
                      int position) {
        this.mContext = context ;
        this.mPosition = position;
        mView = new SparseArray<>();
        mConvertView = LayoutInflater.from(context).inflate(layoutId, parent,
                false);

        mConvertView.setTag(this);
    }

    public static ViewHolder get(Context context, View convertView,
                                 ViewGroup parent, int layoutId, int position) {
        if (convertView == null) {
            return new ViewHolder(context, parent, layoutId, position);
        } else {
            ViewHolder holder = (ViewHolder) convertView.getTag();
            if (holder == null) return new ViewHolder(context, parent, layoutId, position);
            holder.mPosition = position;
            return holder;
        }
    }
    /**
     * viewId获取id
     * @param viewId
     * @return
     */
    public <T extends View> T getView(int viewId) {
        View view = mView.get(viewId);
        if (view == null) {
            view = mConvertView.findViewById(viewId);
            mView.put(viewId, view);
        }
        return (T) view;
    }

    public View getConvertView() {
        return mConvertView;
    }

    /**
     * 显示文本信息
     * @param viewId
     * @param text 内容显示
     * @return
     */
    public ViewHolder setAdapterText(int viewId,String text){
        TextView tv = getView(viewId);
        tv.setText(text);
        return this;
    }

    /**
     * view组件的显示、隐藏
     * @param viewId 控件
     * @param viewStatus 状态
     * @return
     */
    public  ViewHolder setAdapterVisibility(int viewId, int viewStatus){
        View view = getView(viewId);
        view.setVisibility(viewStatus);
        return this;
    }

    /**
     * 点击事件
     * @param viewId
     * @param listener
     * @return
     */
    public ViewHolder setAdapterClick(int viewId, View.OnClickListener listener){
        getView(viewId).setOnClickListener(listener);
        return this ;
    }

    /**
     * 获取点击的position
     * @return
     */
    public int getmPosition(){
        return mPosition;
    }

    /**
      * 设置切换型控件的标识、选中状态、控件背景
      * @param viewId
      * @param resourceSelected 选中状态下的背景资源
      * @param resourceNotSelected 未选中状态下的背景资源
      * @return
      */
    public ViewHolder setAdapterSwitchWidget(int viewId, Object model, boolean status,
                                             int resourceSelected, int resourceNotSelected){
        View v = getView(viewId);
        v.setSelected(status);
        v.setTag(model);
        if (resourceSelected != -1 && resourceNotSelected != -1)
            v.setBackgroundResource(status ? resourceSelected : resourceNotSelected);
        return this ;
    }

    /**
     * 显示网络图片
     * @param viewId
     * @param uri  图片地址
     * @return
     */
    public ViewHolder setAdapterImageView(int viewId, String uri) {
        ImageView image = getView(viewId);
        image.setTag(uri);
        Picasso.with(mContext)
                .load(uri)
                .into(image);
        return this;
    }

    /**
     * 设置背景
     * @param viewId
     * @param resource 本地资源
     * @return
     */
    public ViewHolder setAdapterWidgetBackground(int viewId, int resource){
        getView(viewId).setBackgroundResource(resource);
        return this;
    }

}
