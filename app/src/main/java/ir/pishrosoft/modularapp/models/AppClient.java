package ir.pishrosoft.modularapp.models;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface AppClient {

    String BaseUrl = "http://79.175.151.185:89";

    @GET("/settings/MobileAppSettings.json")
    Call<ModelMainItems> getJson();
}
