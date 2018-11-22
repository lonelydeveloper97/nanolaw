package com.lonelydeveloper97.nanolaw.cards.single.impl.main;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.lonelydeveloper97.nanolaw.R;

public class MainInfoItemViewHolder extends RecyclerView.ViewHolder {
    private final TextView textView;

    public MainInfoItemViewHolder(@NonNull View itemView) {
        super(itemView);
        textView = itemView.findViewById(R.id.textView);
    }

    public void setText(String text){
        textView.setText(text);
    }
}
