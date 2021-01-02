package com.egglib.xpro.activity;

import android.os.Bundle;

import com.egglib.xpro.R;
import com.egglib.xpro.base.BaseCommonTitleActivity;
import com.egglib.xpro.util.LogUtil;

import org.apache.http.conn.ConnectTimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class NetTestActivity extends BaseCommonTitleActivity {

    @Override
    protected void init(Bundle savedInstanceState) {

    }

    @Override
    protected int getLayoutResId() {
        return R.layout.common_layout_title;
    }

    @Override
    protected int getLayoutRes() {
        return 0;
    }

    @Override
    protected void pageHandle() {
        super.pageHandle();

        try {
            OkHttpClient client = new OkHttpClient.Builder()
                    .connectTimeout(5, TimeUnit.SECONDS)
                    .readTimeout(5, TimeUnit.SECONDS)
                    .build();

            JSONObject jsonObject = new JSONObject();
            jsonObject.put("xxx", "xxx");
            jsonObject.put("xxx", "xxx");

            RequestBody requestBody = getRequestBody(jsonObject);

            String url = "";
            Request request = new Request.Builder().url(url).post(requestBody).build();
            Call call = client.newCall(request);
            Response response = call.execute();

            LogUtil.e("code===" + response.code());

        } catch (Exception e) {
            LogUtil.e("e===" + e.toString());
            if (e instanceof SocketTimeoutException
                    || e instanceof ConnectTimeoutException
                    || e instanceof SocketException) {
                LogUtil.e("time out");
            }
        }
    }


    public static RequestBody getRequestBody(JSONObject jsonObject) throws JSONException {
        JSONObject resultJsonData = new JSONObject();
        resultJsonData.put("xxx", "xxx");
        return RequestBody.create(MediaType.parse("application/json"), resultJsonData.toString());
    }
}
