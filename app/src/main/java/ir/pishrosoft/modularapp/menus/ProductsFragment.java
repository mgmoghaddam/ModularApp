//package ir.pishrosoft.modularapp.menus;
//
//import android.os.Bundle;
//import android.support.annotation.NonNull;
//import android.support.annotation.Nullable;
//import android.support.v4.app.Fragment;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.TextView;
//
//import butterknife.BindView;
//import butterknife.ButterKnife;
//import butterknife.Unbinder;
//import ir.pishrosoft.modularapp.R;
//
//public class ProductsFragment extends Fragment {
//    private Unbinder unbinder;
//
//    @Nullable
//    @Override
//    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.recycler_main, container, false);
//        unbinder = ButterKnife.bind(this, view);
//        return view;
//    }
//
//    @Override
//    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//        titleMain.setText("محصولات");
//        backBtnAn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                getActivity().onBackPressed();
//            }
//        });
//    }
//
//    @BindView(R.id.titleMain)
//    TextView titleMain;
//    @BindView(R.id.backBtnAn)
//    TextView backBtnAn;
//}
