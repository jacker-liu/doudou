package doudou.library.com.okhttp.builder;

import doudou.library.com.okhttp.OkHttpUtils;
import doudou.library.com.okhttp.request.OtherRequest;
import doudou.library.com.okhttp.request.RequestCall;

/**
 *
 * @author lb
 * create at 16/7/7.上午11:16
 **/
public class HeadBuilder extends GetBuilder
{
    @Override
    public RequestCall build()
    {
        return new OtherRequest(null, null, OkHttpUtils.METHOD.HEAD, url, tag, params, headers,id).build();
    }
}
