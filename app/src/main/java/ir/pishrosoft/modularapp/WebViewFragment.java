package ir.pishrosoft.modularapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class WebViewFragment extends Fragment {

    private Unbinder unbinder;
    public static NavController navController;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_webview, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
        titleMain.setText(getArguments().getString("title"));
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_webViewFragment_to_mainFragment);
            }
        });
    }


    @BindView(R.id.titleMain)
    TextView titleMain;
    @BindView(R.id.backBtnAn)
    TextView backBtn;
}
