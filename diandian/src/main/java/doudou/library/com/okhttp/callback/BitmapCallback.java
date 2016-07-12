package doudou.library.com.okhttp.callback;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import okhttp3.Response;


/**
 * 图片异步回调
 * @author lb
 * create at 16/7/7.上午11:17
 **/
public abstract class BitmapCallback extends Callback<Bitmap>
{
    public Bitmap parseNetworkResponse(Response response , int id) throws Exception
    {
        return BitmapFactory.decodeStream(response.body().byteStream());
    }

}
