package ir.pishrosoft.modularapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import ir.pishrosoft.modularapp.adapters.RecyclerAdapterType1;
import ir.pishrosoft.modularapp.models.Type1Data;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Type1Activity extends Activity {

    Unbinder unbinder;
    RecyclerView mRecycler;
    RecyclerAdapterType1 mAdapter;
    List<Type1Data> mItem = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_main);
        unbinder = ButterKnife.bind(this);

        String url;
        url = getIntent().getStringExtra("urlMain");
        GetDataService getDataService = RetrofitClientInstance.getApiService(this);
        Call<List<Type1Data>> call = getDataService.getType1Json(url, "application/json");
        call.enqueue(new Callback<List<Type1Data>>() {
            @Override
            public void onResponse(@NotNull Call<List<Type1Data>> call, @NotNull Response<List<Type1Data>> response) {
                mItem.clear();
                if (response.body() != null) {
                    mItem.addAll(response.body());
                }
//                mItem = response.body();
                mAdapter.notifyDataSetChanged();

//                generateDAtaList();
//                Toast.makeText(getApplicationContext(), "Secsessssss", Toast.LENGTH_LONG).show();

            }

            @Override
            public void onFailure(Call<List<Type1Data>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "ارتباط با سرور دچار خطا شده است.", Toast.LENGTH_LONG).show();

            }
        });

        titleMain.setText(getIntent().getStringExtra("title"));
        setRecycler();
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }


    private void setRecycler() {
        mRecycler = mRecyclerView;
        mRecycler.setHasFixedSize(true);
        mAdapter = new RecyclerAdapterType1(mItem, this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mRecycler.setLayoutManager(layoutManager);
        mRecycler.setAdapter(mAdapter);
    }


    @BindView(R.id.titleMain)
    TextView titleMain;
    @BindView(R.id.backBtnAn)
    TextView backBtn;
    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;
}
