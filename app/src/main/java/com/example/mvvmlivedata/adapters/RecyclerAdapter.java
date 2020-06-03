package com.example.mvvmlivedata.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.mvvmlivedata.R;
import com.example.mvvmlivedata.datamodels.Sweets;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    private List<Sweets> sweets = new ArrayList<>();
    private Context mContext;

    public RecyclerAdapter(Context context, List<Sweets> sweets) {
        this.sweets = sweets;
        this.mContext = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Sweets object = sweets.get(position);

        String title = object.getTitle();
        holder.mTextView.setText(title);

        int imageResourceId = object.getImageResourceId();
        //holder.mImageView.setImageResource(imageResourceId);

        // Set the image
        RequestOptions defaultOptions = new RequestOptions()
                .error(R.drawable.ic_launcher_background);
        Glide.with(mContext)
                .setDefaultRequestOptions(defaultOptions)
                .asBitmap()
                .load(imageResourceId)
                .into(holder.mImageView);
    }

    @Override
    public int getItemCount() {
        return sweets.size();
    }


    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        CircleImageView mImageView;
        TextView mTextView;


        MyViewHolder(View itemView) {
            super(itemView);

            mImageView = (CircleImageView) itemView.findViewById(R.id.avatar);
            mTextView = (TextView) itemView.findViewById(R.id.text1);

        }
    }
}
