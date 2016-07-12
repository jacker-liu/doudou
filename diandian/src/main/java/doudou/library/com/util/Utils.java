package doudou.library.com.util;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 日期时间转化
 * 手机号\邮箱验证
 * 读取本地资源
 * 集合\字符相互转化
 * 判断网络
 * @author liubo
 *         Create at 16/7/6 14:26.
 */
public class Utils {

    /**
     * 转化日期时间格式
     * @param Str  日期时间
     * @param originalStr 原先的格式(比如:2012-10-18)
     * @param wantStr   想要的格式(比如:2012年10月18日)
     * @return
     */
    public static String formatDateToString(String Str, String originalStr, String wantStr){
        String dateString = null;
        SimpleDateFormat original = new SimpleDateFormat(originalStr);
        SimpleDateFormat want = new SimpleDateFormat(wantStr);
        try {
            dateString = want.format(original.parse(Str));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dateString;
    }

    /**
     * 验证手机号是否正确
     * @param tel
     * @return
     */
    public static boolean telphoneNumber(String tel){
        Pattern p = Pattern
                .compile("^((13[0-9])|14(7)|(15[^4,\\D])|(17[0,8])|(18[0-3,5-9]))\\d{8}$");
        Matcher m = p.matcher(tel);
        return m.matches();
    }

    /**
     * 验证邮箱
     * @param email
     * @return
     */
    public static boolean checkEmail(String email){
        boolean flag = false;
        try{
            String check = "^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
            Pattern regex = Pattern.compile(check);
            Matcher matcher = regex.matcher(email);
            flag = matcher.matches();
        }catch(Exception e){
            flag = false;
        }
        return flag;
    }

    /**
     * 从指定资源读取内容，默认为UTF-8
     * @param context
     * @param rawResourceId
     * @return
     */
    public static String getContentFromResource(Context context, int rawResourceId) {
        String content = null;
        try {
            InputStream in = context.getResources().openRawResource(rawResourceId);
            byte[] buffer = new byte[in.available()];
            in.read(buffer);
            content = new String(buffer, "utf-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }

    /**
     * 集合转换为字符串
     * @param stringList 字符集合
     * @param delimiter 字符隔断点
     * @return
     */
    public static String arrayToString(List<String> stringList, String delimiter){
        if (stringList == null)
            return null;
        StringBuilder builder = new StringBuilder();
        boolean isFirst = true;
        for (String item: stringList) {
            builder.append(isFirst ? "" : delimiter);
            if (isFirst) isFirst = false;
            builder.append(item.trim());
        }
        return builder.toString();
    }

    /**
     * 字符串转换为集合
     * @param str
     * @param delimiter
     * @return
     */
    public static List<String> stringToArray(String str, String delimiter)
    {
        List<String> list = new ArrayList<>();
        String[] itemArray = str.split(delimiter);
        for (String item : itemArray) {
            if (!"".equals(item.trim())) list.add(item.trim());
        }
        return list;
    }

    /**
     * 判断是否有网络
     * @param activity
     * @return
     */
    public static boolean isNetWorkAvailabe(Activity activity){
        Context context = activity.getApplicationContext();
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager==null)
            return false;
        else {
            // 获取NetworkInfo对象
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
            if (networkInfo != null && networkInfo.isConnected()) {
                // 判断当前网络状态是否为连接状态
                if (networkInfo.getState() == NetworkInfo.State.CONNECTED)
                    return true;
            }
        }
        return false;
    }

}
