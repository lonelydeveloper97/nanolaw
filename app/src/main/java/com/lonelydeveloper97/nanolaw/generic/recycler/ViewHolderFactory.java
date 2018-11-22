package com.lonelydeveloper97.nanolaw.generic.recycler;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

public interface ViewHolderFactory {
    RecyclerView.ViewHolder create(ViewGroup parent, int type);

    int typeByPosition(int position);
}