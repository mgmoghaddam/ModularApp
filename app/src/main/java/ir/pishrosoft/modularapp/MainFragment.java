package ir.pishrosoft.modularapp;

import android.os.Build;
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
import android.widget.Toast;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import ir.pishrosoft.modularapp.adapters.RecyclerViewAdapter;
import ir.pishrosoft.modularapp.models.AppClient;
import ir.pishrosoft.modularapp.models.Button;
import ir.pishrosoft.modularapp.models.ModelMainItems;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainFragment extends Fragment {

    public static NavController navController;
    private Unbinder unbinder;
    RecyclerView mRecycler;
    ArrayList<Button> mItem = new ArrayList<>();
    RecyclerViewAdapter mAdapter;
    final GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 2);

    @Nullable
    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_fragment_recycler, container, false);
        unbinder = ButterKnife.bind(this, view);
        mRecycler = mainFRecycler;
        mAdapter = new RecyclerViewAdapter(mItem, getContext());
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            mRecycler.setLayoutDirection(View.LAYOUT_DIRECTION_RTL);
        }
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                if (mAdapter != null) {
                    switch (mAdapter.getItemViewType(position)) {
                        case 1:
                            return 1;
                        case 0:
                            return 2; //number of columns of the grid
                        default:
                            return -1;
                    }
                } else {
                    return -1;
                }
            }
        });
//        setData();

        mRecycler.setLayoutManager(layoutManager);
        mRecycler.setAdapter(mAdapter);
//        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getContext(), 2);
//        mRecycler.setLayoutManager(layoutManager);
//        mRecycler.setAdapter(mAdapter);
//        setData();
        return view;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);

    }


//    private void setData() {

//
//    }

    @BindView(R.id.mainFRecycler)
    RecyclerView mainFRecycler;



}
