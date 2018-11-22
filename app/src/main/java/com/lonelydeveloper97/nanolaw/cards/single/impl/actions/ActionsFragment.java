package com.lonelydeveloper97.nanolaw.cards.single.impl.actions;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.lonelydeveloper97.nanolaw.R;
import com.lonelydeveloper97.nanolaw.cards.single.impl.main.MainInfoItemViewHolder;
import com.lonelydeveloper97.nanolaw.generic.recycler.CompositeFillerImpl;
import com.lonelydeveloper97.nanolaw.generic.recycler.RecyclerViewFragment;
import com.lonelydeveloper97.nanolaw.generic.recycler.ViewHolderDataFiller;
import com.lonelydeveloper97.nanolaw.generic.recycler.ViewHolderFactory;

import java.util.Collections;
import java.util.List;

public class ActionsFragment extends RecyclerViewFragment {
    List<String> actions = Collections.emptyList();

    @Override
    protected ViewHolderFactory viewHolderFactory() {
        return new ViewHolderFactory() {
            @Override
            public RecyclerView.ViewHolder create(ViewGroup parent, int type) {
                return new ActionItemViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.single_card_action_item, null));
            }

            @Override
            public int typeByPosition(int position) {
                return 1;
            }
        };
    }

    @Override
    protected CompositeFillerImpl compositeFiller() {
        CompositeFillerImpl compositeFiller = new CompositeFillerImpl(ActionItemViewHolder.class, new ViewHolderDataFiller<ActionItemViewHolder>() {
            @Override
            public void fill(ActionItemViewHolder viewHolder, int position) {
                viewHolder.setData(position, actions.get(position));
            }

            @Override
            public int dataSize() {
                return actions.size();
            }
        });
        return compositeFiller;
    }

    public void setActions(List<String> actions) {
        this.actions = actions;
        tryUpdate();
    }
}
