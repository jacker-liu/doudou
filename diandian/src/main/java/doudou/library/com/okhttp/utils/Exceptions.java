package doudou.library.com.okhttp.utils;

/**
 * 异常
 * @author lb
 * create at 16/7/7.上午11:21
 **/
public class Exceptions
{
    public static void illegalArgument(String msg, Object... params)
    {
        throw new IllegalArgumentException(String.format(msg, params));
    }


}
