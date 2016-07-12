package doudou.library.com.okhttp.callback;

/**
 *
 * @author lb
 * create at 16/7/7.上午11:17
 **/
public interface IGenericsSerializator {
    <T> T transform(String response, Class<T> classOfT);
}
