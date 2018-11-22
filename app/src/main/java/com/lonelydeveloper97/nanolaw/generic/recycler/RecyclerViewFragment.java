package com.lonelydeveloper97.nanolaw.generic.recycler;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lonelydeveloper97.nanolaw.R;

public abstract class RecyclerViewFragment extends Fragment {
    private GenericRecyclerAdapter adapter;

    @Override
    public void onResume() {
        super.onResume();
        tryUpdate();
    }

    protected void tryUpdate() {
        if (adapter != null)
            adapter.notifyDataSetChanged();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.generic_recyclervie_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        adapter = new GenericRecyclerAdapter(viewHolderFactory(), compositeFiller());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    protected abstract ViewHolderFactory viewHolderFactory();

    protected abstract CompositeFillerImpl compositeFiller();
}
