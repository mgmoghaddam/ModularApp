package ir.pishrosoft.modularapp;

import java.util.List;

import ir.pishrosoft.modularapp.models.ModelMainItems;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GetDataService {

    @GET("/settings/MobileAppSettings.json")
    Call<ModelMainItems> getJson();

}
