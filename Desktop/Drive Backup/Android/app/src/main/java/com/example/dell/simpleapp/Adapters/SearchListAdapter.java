package com.example.dell.simpleapp.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dell.simpleapp.R;

/**
 * Created by DELL on 20/09/2019.
 */

public class SearchListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public SearchListAdapter()
    {

    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.search_list_layout, parent, false);
        return new SearchHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    private class SearchHolder extends RecyclerView.ViewHolder{

        public SearchHolder(View itemView) {
            super(itemView);
        }
    }
}
