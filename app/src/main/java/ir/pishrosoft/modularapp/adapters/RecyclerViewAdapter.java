package ir.pishrosoft.modularapp.adapters;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import ir.pishrosoft.modularapp.MainActivity;
import ir.pishrosoft.modularapp.Type1Activity;
import ir.pishrosoft.modularapp.models.Button;
import ir.pishrosoft.modularapp.R;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private List<Button> dataList;
    private Context context;
    private static final String URL = "http://79.175.151.185:89";


    public RecyclerViewAdapter(List<Button> dataList, Context context) {
        this.dataList = dataList;
        this.context = context;


    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.main_fragment_card, viewGroup, false);
        return new MyViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        holder.aTitle.setText(dataList.get(position).getTitle());


//        SvgLoader.pluck()
//                .with(context)
//                .setPlaceHolder(R.mipmap.ic_launcher, R.mipmap.ic_launcher)
//                .load(URL + dataList.get(position).getIcon(), holder.aIcon);

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (dataList.get(position).getType()) {
                    case "1":
//                        Bundle bundle = new Bundle();
//                        bundle.putString("title", dataList.get(position).getTitle());
//                        bundle.putString("urlMain", dataList.get(position).getApiUrl());
//                        MainFragment.navController.navigate(R.id.action_mainFragment_to_recyclerForType1, bundle);
                        Intent myIntent = new Intent(context, Type1Activity.class);
                        myIntent.putExtra("title", dataList.get(position).getTitle()); //Optional parameters
                        myIntent.putExtra("urlMain", dataList.get(position).getApiUrl()); //Optional parameters
                        Bundle bundle = ActivityOptionsCompat.makeCustomAnimation(context, R.anim.fade_in, R.anim.fade_out).toBundle();
                        context.startActivity(myIntent,bundle);
                        break;
                    case "2":
                        Bundle bundle2 = new Bundle();
                        bundle2.putString("title", dataList.get(position).getTitle());
                        bundle2.putString("url", dataList.get(position).getApiUrl());
                        break;
                    case "3":

                        break;
                    case "4":
                        Bundle bundle3 = new Bundle();
                        bundle3.putString("title", dataList.get(position).getTitle());
                        bundle3.putString("url", dataList.get(position).getApiUrl());
                        break;
                    default:
                        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
                        context.startActivity(browserIntent);
                        break;
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public ImageView aIcon;
        public TextView aTitle;
        public CardView cardView;
        private LinearLayout cardItem;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            cardItem = itemView.findViewById(R.id.card_item);
            aIcon = itemView.findViewById(R.id.menuIcon);
            aTitle = itemView.findViewById(R.id.menuTitle);
            cardView = itemView.findViewById(R.id.notifications);
        }
    }
    @Override
    public int getItemViewType(int position) {
        return (position==dataList.size()-1 && dataList.size()%2==1) ? 0 : 1; // If the item is last, `itemViewType` will be 0
    }



}
