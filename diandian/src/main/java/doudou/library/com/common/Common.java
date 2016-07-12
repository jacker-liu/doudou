package doudou.library.com.common;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.widget.Toast;

/**
 * @author liubo
 *         Create at 16/7/7 13:37.
 */
public class Common {

    private static Context mContext; //上下文
    private static Activity activity;
    private SharedPreferences sp;


    public Common(Context mContext) {
        this.mContext = mContext;
        activity = (Activity) mContext;
    }

    public Common(Context mContext, String saveName) {
        this.mContext = mContext;
        activity = (Activity) mContext;
        sp = mContext.getSharedPreferences(saveName, mContext.MODE_PRIVATE);
    }

    /**
     * 清除记录的数据
     */
    public boolean cleanAllData(){
        SharedPreferences.Editor editor = sp.edit();
        editor.clear();
        return editor.commit();
    }

    /**
     * 删除某一项
     * @param key
     * @return
     */
    public boolean cleanOneData(String key){
        SharedPreferences.Editor editor = sp.edit();
        editor.remove(key);
        return editor.commit();
    }

    /**
     * 写进shared里面
     * @param key  主键
     * @param value 值
     */
    public void writeDate(String key, String value) {
        sp.edit().putString(key, value).commit();
    }

    /**
     * 读取保存的shared
     * @param key 主键
     * @return
     */
    public String readDate(String key) {
        return sp.getString(key, "");
    }

    /**
     * 显示toast信息
     * @param str 显示的信息内容
     */
    public void showStr(String str){
        Toast.makeText(mContext, str, Toast.LENGTH_SHORT).show();
    }

    /**
     * 显示没有网络的提示
     */
    public void showNoNet() {
        Toast.makeText(mContext, "请检查网络!", Toast.LENGTH_SHORT).show();
    }
    /**
     * 界面跳转
     * @param mClass
     */
    public void startActivityDemo(Class mClass){
        activity.startActivity(new Intent(activity,mClass));
        activity.finish();
    }

    /**
     * 跳转传值
     * @param mClass
     * @param key
     * @param value
     */
    public void startActivityDemo(Class mClass, String key, String value){
       Intent demo = new Intent(mContext,mClass);
        demo.putExtra(key,value);
        activity.startActivity(demo);
        activity.finish();
    }

    /**
     * 跳转传值
     * @param mClass
     * @param key1
     * @param value1
     * @param key2
     * @param value2
     */
    public void startActivityDemo2(Class mClass, String key1, String value1, String key2, String value2){
        Intent demo = new Intent(mContext,mClass);
        demo.putExtra(key1,value1);
        demo.putExtra(key2,value2);
        activity.startActivity(demo);
        activity.finish();
    }

    /**
     * 是否已经登录,没有跳转到登录界面
     * @param mClass
     */
    public void toLoginDialag(final Class mClass) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(mContext)
                .setMessage("您还没有登录，去登录?")
                .setPositiveButton("登录", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        activity.startActivity(new Intent(mContext, mClass));
                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        dialog.show();
    }
}
