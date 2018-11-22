package com.lonelydeveloper97.nanolaw.cards.single.impl.main;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.lonelydeveloper97.nanolaw.R;
import com.lonelydeveloper97.nanolaw.cards.single.impl.model.Card;
import com.lonelydeveloper97.nanolaw.generic.recycler.CompositeFillerImpl;
import com.lonelydeveloper97.nanolaw.generic.recycler.RecyclerViewFragment;
import com.lonelydeveloper97.nanolaw.generic.recycler.ViewHolderDataFiller;
import com.lonelydeveloper97.nanolaw.generic.recycler.ViewHolderFactory;

import java.util.Collections;
import java.util.List;

public class MainInfoFragment extends RecyclerViewFragment {
    List<String> mainInfo = Collections.emptyList();

    @Override
    protected ViewHolderFactory viewHolderFactory() {
        return new ViewHolderFactory() {
            @Override
            public RecyclerView.ViewHolder create(ViewGroup parent, int type) {
                return new MainInfoItemViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.main_information_item, null));
            }

            @Override
            public int typeByPosition(int position) {
                return 1;
            }
        };
    }

    @Override
    protected CompositeFillerImpl compositeFiller() {
        CompositeFillerImpl compositeFiller = new CompositeFillerImpl(MainInfoItemViewHolder.class, new ViewHolderDataFiller<MainInfoItemViewHolder>() {
            @Override
            public void fill(MainInfoItemViewHolder viewHolder, int position) {
                viewHolder.setText(mainInfo.get(position));
            }

            @Override
            public int dataSize() {
                return mainInfo.size();
            }
        });
        return compositeFiller;
    }

    public void setMainInfo(List<String> mainInfo) {
        this.mainInfo = mainInfo;
        tryUpdate();
    }
}
