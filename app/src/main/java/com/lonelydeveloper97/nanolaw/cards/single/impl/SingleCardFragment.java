package com.lonelydeveloper97.nanolaw.cards.single.impl;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lonelydeveloper97.nanolaw.R;
import com.lonelydeveloper97.nanolaw.cards.single.SingleCardContract;
import com.lonelydeveloper97.nanolaw.cards.single.impl.actions.ActionsFragment;
import com.lonelydeveloper97.nanolaw.cards.single.impl.main.MainInfoFragment;
import com.lonelydeveloper97.nanolaw.cards.single.impl.model.Card;
import com.lonelydeveloper97.nanolaw.generic.FragmentPagerAdapter;

import java.util.Arrays;
import java.util.List;

public class SingleCardFragment extends Fragment implements SingleCardContract.View {
    private SingleCardContract.Presenter presenter;
    private Card card;
    private MainInfoFragment mainInfoFragment;
    private ActionsFragment actionsFragment;

    @Override
    public void onResume() {
        super.onResume();
        presenter.subscribe(this);
        tryUpdateView();
    }

    private void tryUpdateView(){
        if(card == null || getActivity() == null)
            return;

        getActivity().setTitle(card.getName());
        mainInfoFragment.setMainInfo(card.getMainInformation());
        actionsFragment.setActions(card.getActions());
    }

    @Override
    public void onPause() {
        super.onPause();
        presenter.unsubscribe();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.single_card_fragment_layout, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.tabLayout);

        final ViewPager viewPager = (ViewPager) view.findViewById(R.id.pager);


        mainInfoFragment = new MainInfoFragment();
        actionsFragment = new ActionsFragment();


        FragmentPagerAdapter fragmentPagerAdapter = new FragmentPagerAdapter(getChildFragmentManager(), new FragmentPagerAdapter.FragmentPagerModel() {
            @Override
            public List<Pair<String, Fragment>> nameFragmentPairs() {
                return Arrays.asList(new Pair<String, Fragment>("Main info", mainInfoFragment), new Pair<String, Fragment>("Actions", actionsFragment));
            }

            @Override
            public int defaultPosition() {
                return 0;
            }
        });

        //Adding adapter to pager
        viewPager.setAdapter(fragmentPagerAdapter);


        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }

        });
    }


    @Override
    public void setPresenter(SingleCardContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void setCard(Card card) {
        this.card = card;
        tryUpdateView();
    }
}
