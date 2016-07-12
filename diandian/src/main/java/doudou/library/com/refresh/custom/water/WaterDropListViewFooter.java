package doudou.library.com.refresh.custom.water;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import doudou.library.com.R;

public class WaterDropListViewFooter extends LinearLayout {
	private Context mContext;

	private View mContentView;
	private View mProgressBar;
	private TextView mHintView;
	private TextView txt_progresstext;
	private LinearLayout layout_progress;
	public enum STATE{
		normal,
		ready,
		loading
	}
	public WaterDropListViewFooter(Context context) {
		super(context);
		initView(context);
	}

	public WaterDropListViewFooter(Context context, AttributeSet attrs) {
		super(context, attrs);
		initView(context);
	}


	public void setState(STATE state) {
		mHintView.setVisibility(View.INVISIBLE);
		mProgressBar.setVisibility(View.INVISIBLE);
		mHintView.setVisibility(View.INVISIBLE);
         txt_progresstext.setVisibility(View.INVISIBLE);
         layout_progress.setVisibility(View.INVISIBLE);
		if (state == STATE.ready) {
			mHintView.setVisibility(View.VISIBLE);
			mHintView.setText(getResources().getString(R.string.listfooterview_ready));
		} else if (state == STATE.loading) {
			mProgressBar.setVisibility(View.VISIBLE);
             layout_progress.setVisibility(View.VISIBLE);
             txt_progresstext.setVisibility(View.VISIBLE);
		} else {
			mHintView.setVisibility(View.VISIBLE);
			mHintView.setText(getResources().getString(R.string.listfooterview_normal));
		}
	}

	public void setBottomMargin(int height) {
		if (height < 0) return ;
		LayoutParams lp = (LayoutParams)mContentView.getLayoutParams();
		lp.bottomMargin = height;
		mContentView.setLayoutParams(lp);
	}

	public int getBottomMargin() {
		LayoutParams lp = (LayoutParams)mContentView.getLayoutParams();
		return lp.bottomMargin;
	}

	/**
	 * normal status
	 */
	public void normal() {
		mHintView.setVisibility(View.VISIBLE);
		mProgressBar.setVisibility(View.GONE);
         layout_progress.setVisibility(View.GONE);
         txt_progresstext.setVisibility(View.GONE);
	}


	/**
	 * loading status
	 */
	public void loading() {
		mHintView.setVisibility(View.GONE);
		mProgressBar.setVisibility(View.VISIBLE);
        layout_progress.setVisibility(View.VISIBLE);
         txt_progresstext.setVisibility(View.VISIBLE);
	}

	/**
	 * hide footer when disable pull load more
	 */
	public void hide() {
		LayoutParams lp = (LayoutParams)mContentView.getLayoutParams();
		lp.height = 0;
		mContentView.setLayoutParams(lp);
	}

	/**
	 * show footer
	 */
	public void show() {
		LayoutParams lp = (LayoutParams)mContentView.getLayoutParams();
		lp.height = LayoutParams.WRAP_CONTENT;
		mContentView.setLayoutParams(lp);
	}

	private void initView(Context context) {
		mContext = context;
		LinearLayout moreView = (LinearLayout) LayoutInflater.from(mContext).inflate(R.layout.waterdroplistview_footer, null);
		addView(moreView);
		moreView.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));

		mContentView = moreView.findViewById(R.id.water_drop_listView_footer_content);
		mProgressBar = moreView.findViewById(R.id.water_drop_listView_footer_progressbar);
		mHintView = (TextView)moreView.findViewById(R.id.water_drop_listView_footer_textView);
         layout_progress=(LinearLayout)moreView.findViewById(R.id.progress_layout);
         txt_progresstext =(TextView)moreView.findViewById(R.id.txt_progress_text);
	}


}
