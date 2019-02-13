package com.example.taufiq.pixabay.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.taufiq.pixabay.R;
import com.example.taufiq.pixabay.model.Hit;

import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.holder> {


    private List<Hit> list;
    private final onItemClickListener listener;

    public MainAdapter(List<Hit> list, onItemClickListener listener) {
        this.list = list;
        this.listener = listener;
    }

    // Interface that handle click action for each item
    public interface onItemClickListener {
        void onItemClick(Hit item);

    }


    @NonNull
    @Override
    public holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new holder(LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_raw, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull holder holder, int i) {
        Hit model = list.get(i);
        holder.bind(model,listener);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class holder extends RecyclerView.ViewHolder {

        // item (5 Views)
        ImageView largeImage;
        TextView likes,views,downloads,tags;



        public holder(@NonNull View itemView) {
            super(itemView);

            largeImage = itemView.findViewById(R.id.large_image);
            likes = itemView.findViewById(R.id.likes_id);
            views = itemView.findViewById(R.id.views_id);
            downloads = itemView.findViewById(R.id.download_id);
            tags = itemView.findViewById(R.id.tags_value_id);
        }

        public void bind(final Hit item, final onItemClickListener listener) {

            Glide.with(itemView.getContext())
                    .load(item.mLargeImageURL).into(largeImage);

            likes.setText(item.mLikes.toString());
            views.setText(item.mViews.toString());
            downloads.setText(item.mDownloads.toString());
            tags.setText(item.mTags);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onItemClick(item);
                }
            });
        }
    }
}
