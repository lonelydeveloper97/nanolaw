package com.lonelydeveloper97.nanolaw.generic.recycler;

import android.support.v7.widget.RecyclerView;

import java.util.Collections;
import java.util.Map;

public class CompositeFillerImpl implements ViewHolderDataFiller<RecyclerView.ViewHolder> {
    Map<Class, ViewHolderDataFiller> classViewHolderDataFillerMap;

    public CompositeFillerImpl(Map<Class, ViewHolderDataFiller> classViewHolderDataFillerMap) {
        this.classViewHolderDataFillerMap = classViewHolderDataFillerMap;
    }

    public CompositeFillerImpl(Class clazz, ViewHolderDataFiller filler) {
        this(Collections.singletonMap(clazz, filler));
    }


    @Override
    public void fill(RecyclerView.ViewHolder viewHolder, int position) {
        for (ViewHolderDataFiller viewHolderDataFiller : classViewHolderDataFillerMap.values()){
            if(position - viewHolderDataFiller.dataSize() >= 0){
                position = position - viewHolderDataFiller.dataSize();
            }
        }
        classViewHolderDataFillerMap.get(viewHolder.getClass()).fill(viewHolder, position);
    }

    @Override
    public int dataSize() {
        int size = 0;
        for (ViewHolderDataFiller viewHolderDataFiller : classViewHolderDataFillerMap.values()) {
            size += viewHolderDataFiller.dataSize();
        }
        return size;
    }
}
