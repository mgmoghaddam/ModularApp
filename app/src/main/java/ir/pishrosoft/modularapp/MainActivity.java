package ir.pishrosoft.modularapp;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.ahmadrosid.svgloader.SvgLoader;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import ir.pishrosoft.modularapp.adapters.RecyclerViewAdapter;
import ir.pishrosoft.modularapp.models.Button;
import ir.pishrosoft.modularapp.models.ModelMainItems;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {
    private Unbinder unbinder;
    RecyclerView mRecycler;
    List<Button> mItem = new ArrayList<>();
    RecyclerViewAdapter mAdapter;
    final GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
    Button buttons;
    private static final String BASE_URL = "http://79.175.151.185:89";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_fragment_recycler);
        unbinder = ButterKnife.bind(this);


        GetDataService getDataService = RetrofitClientInstance.getApiService(this);
        Call<ModelMainItems> call = getDataService.getJson();
        call.enqueue(new Callback<ModelMainItems>() {
            @Override
            public void onResponse(Call<ModelMainItems> call, Response<ModelMainItems> response) {
                mItem = response.body().getButtons();



                //TODO application icon
                SvgLoader.pluck()
                        .with(MainActivity.this)
                        .setPlaceHolder(R.mipmap.ic_launcher, R.mipmap.ic_launcher)
                        .load(BASE_URL + response.body().getLogoUrl(), mainIcon);



                generateDAtaList();
                Toast.makeText(getApplicationContext(), "Secsessssss", Toast.LENGTH_LONG).show();

            }

            @Override
            public void onFailure(Call<ModelMainItems> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "", Toast.LENGTH_LONG).show();

            }
        });
    }

    private void generateDAtaList() {
        mRecycler = mainFRecycler;
        mAdapter = new RecyclerViewAdapter(mItem, this);
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
        mRecycler.setLayoutManager(layoutManager);
        mRecycler.setAdapter(mAdapter);
    }

    @BindView(R.id.mainFRecycler)
    RecyclerView mainFRecycler;
    @BindView(R.id.mainIcon)
    ImageView mainIcon;

}
