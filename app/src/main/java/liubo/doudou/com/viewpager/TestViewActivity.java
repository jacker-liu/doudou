package liubo.doudou.com.viewpager;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import doudou.library.com.viewpager.SlidingViewPager;
import liubo.doudou.com.R;

/**
 * @author liubo
 *         Create at 16/7/11 10:11.
 */
public class TestViewActivity extends Activity {
//    @BindView(R.id.banner_2)
//    SlidingViewPager banner2;

    private String[] mImagesUrl = {
            "http://img4.imgtn.bdimg.com/it/u=2430963138,1300578556&fm=23&gp=0.jpg",
            "http://img1.imgtn.bdimg.com/it/u=2755648979,3568014048&fm=23&gp=0.jpg",
            "http://img0.imgtn.bdimg.com/it/u=2272739960,4287902102&fm=23&gp=0.jpg",
            "http://img3.imgtn.bdimg.com/it/u=1078051055,1310741362&fm=23&gp=0.jpg"
    };


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_viewpager);
//        ButterKnife.bind(this);

        SlidingViewPager banner2 = (SlidingViewPager) findViewById(R.id.banner_2);

        List<String> imageUrl = new ArrayList<>();
        for (int i = 0; i < mImagesUrl.length; i++) {
            imageUrl.add(mImagesUrl[i]);
        }
        banner2.setImagesUrl(imageUrl);

//        banner2.setOnItemClickListener(new SlidingViewPager.OnItemClickListener() {
//            public void onItemClick(int position) {
//                toast("点击了第" + position + "张图片");
//            }
//        });

    }
    private void toast(String str) {
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }
}
