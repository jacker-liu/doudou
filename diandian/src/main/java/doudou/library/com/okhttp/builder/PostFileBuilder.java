package doudou.library.com.okhttp.builder;

import java.io.File;

import doudou.library.com.okhttp.request.PostFileRequest;
import doudou.library.com.okhttp.request.RequestCall;
import okhttp3.MediaType;

/**
 *
 * @author lb
 * create at 16/7/7.上午11:18
 **/
public class PostFileBuilder extends OkHttpRequestBuilder<PostFileBuilder>
{
    private File file;
    private MediaType mediaType;


    public OkHttpRequestBuilder file(File file)
    {
        this.file = file;
        return this;
    }

    public OkHttpRequestBuilder mediaType(MediaType mediaType)
    {
        this.mediaType = mediaType;
        return this;
    }

    @Override
    public RequestCall build()
    {
        return new PostFileRequest(url, tag, params, headers, file, mediaType,id).build();
    }


}
