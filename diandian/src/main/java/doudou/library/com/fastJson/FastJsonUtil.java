package doudou.library.com.fastJson;

import com.alibaba.fastjson.JSON;

import java.util.List;

import doudou.library.com.okhttp.OkHttpUtils;

/**
 * @author liubo
 *         Create at 16/7/6 11:52.
 */
public class FastJsonUtil<T> {
    private static FastJsonUtil mInstance;

    public static FastJsonUtil initFast()
    {
        if (mInstance == null)
        {
            synchronized (OkHttpUtils.class)
            {
                if (mInstance == null)
                {
                    mInstance = new FastJsonUtil();
                }
            }
        }
        return mInstance;
    }


    /**
     * fastJson 单个Object
     * @param result
     * @return list集合
     */
    public T getStringObject(String result, Class<T> tt){
        Object object = JSON.parseObject(result).getJSONObject("data");
        return  (T) JSON.parseObject(object + "",tt);
    }

    /**
     * fastJson 数组解析
     * @param result
     * @return
     */
    public List<T> getStringArray(String result, Class<T> tt){
        Object jsonArray = JSON.parseObject(result).getJSONArray("data");
        List<T> jsonList = JSON.parseArray(jsonArray + "", tt);
        return jsonList;
    }

}
