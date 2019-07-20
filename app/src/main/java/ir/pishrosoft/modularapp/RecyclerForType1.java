package ir.pishrosoft.modularapp;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import ir.pishrosoft.modularapp.adapters.RecyclerAdapterType1;
import ir.pishrosoft.modularapp.adapters.RecyclerViewAdapter;
import ir.pishrosoft.modularapp.models.Button;
import ir.pishrosoft.modularapp.models.ModelMainItems;
import ir.pishrosoft.modularapp.models.Type1Data;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.POST;

public class RecyclerForType1 extends Fragment implements UrlHandler {
    private Unbinder unbinder;
    public static NavController navController;
    RecyclerView mRecycler;
    RecyclerAdapterType1 mAdapter;
    List<Type1Data> mItem = new ArrayList<>();
    MainActivity activity;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.recycler_main, container, false);
        unbinder = ButterKnife.bind(this, view);



        Call<ModelMainItems> call = getDataService.getJson();
        call.enqueue(new Callback<ModelMainItems>() {
            @Override
            public void onResponse(Call<ModelMainItems> call, Response<ModelMainItems> response) {
                mItem = response.body().getButtons();

                Toast.makeText(getContext(), "Secsessssss", Toast.LENGTH_LONG).show();

            }

            @Override
            public void onFailure(Call<ModelMainItems> call, Throwable t) {
                Toast.makeText(getContext(), "", Toast.LENGTH_LONG).show();

            }
        });

        return view;

        return view;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
        titleMain.setText(getArguments().getString("title"));
        url = getArguments().getString("url");


        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { navController.navigate(R.id.action_recyclerForType12_to_mainFragment); }});

        mRecycler = mRecyclerView;
        mRecycler.setHasFixedSize(true);
        mAdapter = new RecyclerAdapterType1(mItem, getContext());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        mRecycler.setLayoutManager(layoutManager);
        mRecycler.setAdapter(mAdapter);



    }
    public interface YourEndpoints {

        @GET()
        Call<ModelMainItems> getJson();
    }


    @BindView(R.id.titleMain)
    TextView titleMain;
    @BindView(R.id.backBtnAn)
    TextView backBtn;
    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;
}
