package ir.pishrosoft.modularapp;

import android.app.Activity;
import android.content.Context;
import android.media.Image;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class DetailFragmentType1 extends Activity {

    private Unbinder unbinder;
    private static final String BASE_URL = "http://79.175.151.185:89";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        unbinder = ButterKnife.bind(DetailFragmentType1.this);
        setContentView(R.layout.description_type1);
        TextView titleDes = findViewById(R.id.titleDes);
        TextView desDes = findViewById(R.id.desDes);
        ImageView imageView = findViewById(R.id.imageView);
        TextView backBtn = findViewById(R.id.backBtnAn);


        titleDes.setText(getIntent().getStringExtra("title"));
        String urlImage = getIntent().getStringExtra("url");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            desDes.setText(Html.fromHtml(getIntent().getStringExtra("des"), Html.FROM_HTML_MODE_COMPACT));
        } else {
            desDes.setText(Html.fromHtml(getIntent().getStringExtra("des")));
        }
        Glide.with(this)
                .load(BASE_URL + urlImage)
                .into(imageView);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }
}
