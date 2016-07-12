package doudou.library.com.okhttp.builder;

import java.util.Map;

/**
 *
 * @author lb
 * create at 16/7/7.上午11:18
 **/
public interface HasParamsable
{
    OkHttpRequestBuilder params(Map<String, String> params);
    OkHttpRequestBuilder addParams(String key, String val);
}
