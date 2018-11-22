package com.lonelydeveloper97.nanolaw.generic.recycler;

public interface ViewHolderDataFiller<T> {
    void fill(T viewHolder, int position);

    int dataSize();
}
