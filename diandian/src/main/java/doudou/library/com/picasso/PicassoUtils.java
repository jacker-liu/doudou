package doudou.library.com.picasso;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Transformation;

/**
 * 图片显示
 * @author liubo
 *         Create at 16/7/6 11:54.
 */
public class PicassoUtils {

    private static Context mContext;
    public PicassoUtils(Context mContext){
        this.mContext = mContext;
    }
    /**
     * crop image size
     * @param imageUrl image address
     * @param imageView control
     */
    public static void showImage(String imageUrl,int imageId, ImageView imageView){
        Picasso.with(mContext).
                load(imageUrl).
                transform(new CropImageView())
                .into(imageView);
    }

    /**
     * 加载有默认图片的
     * @param imageUrl
     * @param imageId 默认图片资源
     * @param imageView
     */
    public static void showImage(String imageUrl, int imageId, int errorId, ImageView imageView){
        Picasso.with(mContext)
                .load(imageUrl)
                .placeholder(imageId)
                .error(errorId)
                .fit()
                .into(imageView);
    }

    /**
     * 指定大小加载图片
     * @param height
     * @param width
     * @param imageUrl
     * @param imageView
     */
    public static void showImage(String imageUrl,int imageId, int errorId, int height, int width, ImageView imageView){
        Picasso.with(mContext)
                .load(imageUrl)
                .placeholder(imageId)
                .error(errorId)
                .resize(width,height)
                .centerCrop()
                .into(imageView);
    }


    /**
     * 自定义图片裁剪
     */
    private static class CropImageView implements Transformation {
        public Bitmap transform(Bitmap source) {
            int size = Math.min(source.getWidth(), source.getHeight());
            int x = (source.getWidth() - size) / 2;
            int y = (source.getHeight() - size) / 2;
            Bitmap newBitmap = Bitmap.createBitmap(source, x, y, size, size);

            if (newBitmap != null) {
                //内存回收
                source.recycle();
            }
            return newBitmap;
        }

        public String key() {
            return "lgl";
        }
    }
}
