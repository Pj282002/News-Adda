package com.example.newsadda;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.view.LayoutInflaterFactory;
import androidx.lifecycle.ViewTreeViewModelKt;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class
CategoryRVAdapter extends RecyclerView.Adapter<CategoryRVAdapter.ViewHolder> {
    private ArrayList<CategoryRVModel> categoryRVModels;
    private Context context;
    private CategoryClickInterface categoryClickInterface;

    public CategoryRVAdapter(ArrayList<CategoryRVModel> categoryRVModels, Context context, CategoryClickInterface categoryClickInterface)
    {
        this.categoryRVModels = categoryRVModels;
        this.context = context;
        this.categoryClickInterface = categoryClickInterface;
    }

    public CategoryRVAdapter(ArrayList<CategoryRVModel> categoryRVModels, Context context)
    {
        this.categoryRVModels = categoryRVModels;
        this.context = context;
    }

        @NonNull
        @Override
        public CategoryRVAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate
                    (R.layout.categories_rv_item, parent, false);
            return new CategoryRVAdapter.ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull CategoryRVAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position)
        {
            CategoryRVModel categoryRVModel = categoryRVModels.get(position);
            holder.categoryTV.setText(categoryRVModel.getCategory());
    //     Picasso.get().load(categoryRVModel.getCategoryImageUrl()).into(holder.categoryIV);
            holder.itemView.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v) {
                    categoryClickInterface.onCategoryClick(position);
                }
            });
    }


    @Override
    public int getItemCount() {
        return categoryRVModels.size();
            }

            public interface CategoryClickInterface{
            void onCategoryClick(int position);
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView categoryTV;
        private ImageView categoryIV;
        public ViewHolder (@NonNull View itemView) {
            super(itemView);
            categoryTV = itemView.findViewById(R.id.idTVCategory);
            categoryTV = itemView.findViewById(R.id.idTVCategory);
        }
    }
}