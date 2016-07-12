package doudou.library.com.okhttp.builder;

import doudou.library.com.okhttp.request.PostStringRequest;
import doudou.library.com.okhttp.request.RequestCall;
import okhttp3.MediaType;

/**
 *
 * @author lb
 * create at 16/7/7.上午11:19
 **/
public class PostStringBuilder extends OkHttpRequestBuilder<PostStringBuilder>
{
    private String content;
    private MediaType mediaType;


    public PostStringBuilder content(String content)
    {
        this.content = content;
        return this;
    }

    public PostStringBuilder mediaType(MediaType mediaType)
    {
        this.mediaType = mediaType;
        return this;
    }

    @Override
    public RequestCall build()
    {
        return new PostStringRequest(url, tag, params, headers, content, mediaType,id).build();
    }


}
