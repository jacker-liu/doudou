package doudou.library.com.okhttp.callback;

import java.io.IOException;

import okhttp3.Response;

/**
 *
 * @author lb
 * create at 16/7/7.上午11:18
 **/
public abstract class StringCallback extends Callback<String>
{
    @Override
    public String parseNetworkResponse(Response response, int id) throws IOException
    {
        return response.body().string();
    }
}
