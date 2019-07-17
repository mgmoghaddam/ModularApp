package ir.pishrosoft.modularapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

import ir.pishrosoft.modularapp.models.AppClient;
import ir.pishrosoft.modularapp.models.Button;
import ir.pishrosoft.modularapp.models.ModelMainItems;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity {

    Button buttons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        parseJson();

    }
    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
            getSupportFragmentManager().popBackStack();
        } else {
            this.finish();
        }
    }

    private void parseJson() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(AppClient.BaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        final AppClient request = retrofit.create(AppClient.class);
        Call<ModelMainItems> call1=request.getJson();
        call1.enqueue(new Callback<ModelMainItems>() {
            @Override
            public void onResponse(Call<ModelMainItems> call, Response<ModelMainItems> response) {
                response.body().setButtons(response.body().getButtons());

                Toast.makeText(MainActivity.this,"Success! response for first item >> \n car :" +buttons.getTitle()+"\ndesc :"+buttons.getApiUrl(),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<ModelMainItems> call, Throwable t) {
                Toast.makeText(MainActivity.this,"Failure",Toast.LENGTH_SHORT).show();
            }

        });
    }

}
