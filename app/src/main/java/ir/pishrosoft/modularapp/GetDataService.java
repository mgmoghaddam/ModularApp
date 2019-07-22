package ir.pishrosoft.modularapp;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import java.util.List;

import ir.pishrosoft.modularapp.models.ModelMainItems;
import ir.pishrosoft.modularapp.models.Type1Data;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.Url;

public interface GetDataService{


    @GET("/settings/MobileAppSettings.json")
    Call<ModelMainItems> getJson();



    @GET()
    Call<List<Type1Data>> getType1Json(@Url String urlType1,@Header("Content-Type")String content_type);
}
