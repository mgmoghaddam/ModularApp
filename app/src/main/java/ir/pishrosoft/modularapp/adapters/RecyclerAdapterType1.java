package ir.pishrosoft.modularapp.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import ir.pishrosoft.modularapp.R;
import ir.pishrosoft.modularapp.RecyclerForType1;
import ir.pishrosoft.modularapp.models.Button;
import ir.pishrosoft.modularapp.models.Type1Data;

public class RecyclerAdapterType1 extends RecyclerView.Adapter<RecyclerAdapterType1.MyViewHolderType1> {

    private List<Type1Data> itemList;
    Context context;
    private static final String BASE_URL = "http://79.175.151.185:89";

    public RecyclerAdapterType1(List<Type1Data> itemList, Context context) {
        this.itemList = itemList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolderType1 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View aView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cards_layout, parent, false);
        return new MyViewHolderType1(aView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolderType1 holder, int i) {

        Type1Data mItem = itemList.get(i);
        holder.uTitle.setText(mItem.getTitle());
        if (mItem.getDate() == null || mItem.getDate().equals("")) {
            holder.uData.setVisibility(View.INVISIBLE);
        } else {
            holder.uData.setText(mItem.getDate());
        }
        if (mItem.getAuthor() == null || mItem.getAuthor().equals("")) {
            holder.uAuthor.setVisibility(View.INVISIBLE);
            holder.uAuthorTitle.setVisibility(View.INVISIBLE);
        } else {
            holder.uAuthorTitle.setText("نویسنده");
            holder.uAuthor.setText(mItem.getAuthor());
        }
        Glide.with(context)
                .load(BASE_URL + mItem.getImageUrl())
                .into(holder.uIcon);

    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class MyViewHolderType1 extends RecyclerView.ViewHolder {

        public ImageView uIcon;
        public TextView uTitle;
        public TextView uData;
        public TextView uAuthor;
        public TextView uAuthorTitle;


        public MyViewHolderType1(@NonNull View itemView) {
            super(itemView);

            uIcon = itemView.findViewById(R.id.img_view);
            uTitle = itemView.findViewById(R.id.titleTextV);
            uData = itemView.findViewById(R.id.dateTextV);
            uAuthorTitle = itemView.findViewById(R.id.authorTitle);
            uAuthor = itemView.findViewById(R.id.author);
        }
    }

}
