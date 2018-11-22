package com.lonelydeveloper97.nanolaw.cards.single.impl.actions;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.lonelydeveloper97.nanolaw.R;

public class ActionItemViewHolder extends RecyclerView.ViewHolder {
    private final TextView position;
    private final TextView textView;


    public ActionItemViewHolder(@NonNull View itemView) {
        super(itemView);
        position = itemView.findViewById(R.id.position);
        textView = itemView.findViewById(R.id.textView);
    }

    public void setData(int pos, String text){
        position.setText(String.valueOf(pos));
        textView.setText(text);
    }
}
