package com.lonelydeveloper97.nanolaw.generic.recycler;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

public class GenericRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ViewHolderFactory factory;
    private CompositeFillerImpl filler;

    public GenericRecyclerAdapter(ViewHolderFactory factory, CompositeFillerImpl filler) {
        this.factory = factory;
        this.filler = filler;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return factory.create(viewGroup, i);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        filler.fill(viewHolder, i);
    }

    @Override
    public int getItemViewType(int position) {
        return factory.typeByPosition(position);
    }


    @Override
    public int getItemCount() {
        return filler.dataSize();
    }
}
