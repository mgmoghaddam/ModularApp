package ir.pishrosoft.modularapp;

import android.content.Context;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

public class RetrofitClientInstanceHTML {
    private static Retrofit retrofit;
    private static final String BASE_URL = "http://79.175.151.185:89";
    private static OkHttpClient okhttpClient;

    private static Retrofit getRetrofitInstance(Context context) {
        if (okhttpClient == null) {
            okhttpClient = initOkHttp(context);
            if (retrofit == null) {
                retrofit = new Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .client(okhttpClient)
                        .addConverterFactory(SimpleXmlConverterFactory.create())
                        .build();
            }
        }
        return retrofit;

    }


    private static OkHttpClient initOkHttp(Context context) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(7, TimeUnit.MINUTES);
        if (BuildConfig.DEBUG) {
            builder.addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY));
        }
        return builder.build();

    }
    public static GetDataService getApiService(Context context) {
        return getRetrofitInstance(context).create(GetDataService.class);
    }


}
