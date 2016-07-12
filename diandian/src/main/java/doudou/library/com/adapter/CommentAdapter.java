package doudou.library.com.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * 通用的baseAdapter
 * @author liubo
 * Created at 2016/1/11 15:30.
 */
public abstract class CommentAdapter<T> extends BaseAdapter {
    private Context mContext;
    private LayoutInflater mInflater;
    private List<T> mData;
    private int layoutId;

    public CommentAdapter(Context mContext, int layoutId, List<T> mData){
        this.mContext = mContext;
        this.layoutId = layoutId;
        this.mData = mData;
        mInflater = LayoutInflater.from(mContext);
    }
    public int getCount() {
        return mData.size() == 0 ? 0: mData.size();
    }
    public Object getItem(int position) {
        return mData.get(position);
    }
    public long getItemId(int position) {
        return position;
    }
    public View getView(int position, View convertView, ViewGroup parent){
        ViewHolder holder = ViewHolder.get(mContext, convertView, parent, layoutId, position);
        // 回调
        getExView(holder, mData.get(position));

        return holder.getConvertView();
    }
    protected abstract void getExView(ViewHolder holder, T t);


    public void addNewDatas(List<T> datas) {
        if (datas != null) {
            this.mData.addAll(0, datas);
            this.notifyDataSetChanged();
        }
    }

    public void addMoreDatas(List<T> datas) {
        if(datas != null) {
            this.mData.addAll(this.mData.size(), datas);
            this.notifyDataSetChanged();
        }

    }

}
