package doudou.library.com.okhttp.builder;

import java.util.LinkedHashMap;
import java.util.Map;
import doudou.library.com.okhttp.request.RequestCall;

/**
 *
 * @author lb
 * create at 16/7/7.上午11:18
 **/
public abstract class OkHttpRequestBuilder<T extends OkHttpRequestBuilder>
{
    protected String url;
    protected Object tag;
    protected Map<String, String> headers;
    protected Map<String, String> params;
    protected int id;

    public T id(int id)
    {
        this.id = id;
        return (T) this;
    }

    public T url(String url)
    {
        this.url = url;
        return (T) this;
    }


    public T tag(Object tag)
    {
        this.tag = tag;
        return (T) this;
    }

    public T headers(Map<String, String> headers)
    {
        this.headers = headers;
        return (T) this;
    }

    public T addHeader(String key, String val)
    {
        if (this.headers == null)
        {
            headers = new LinkedHashMap<>();
        }
        headers.put(key, val);
        return (T) this;
    }

    public abstract RequestCall build();
}
