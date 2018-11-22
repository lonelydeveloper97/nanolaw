package com.lonelydeveloper97.nanolaw;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.lonelydeveloper97.nanolaw.cards.single.SingleCardContract;
import com.lonelydeveloper97.nanolaw.cards.single.impl.SingleCardFragment;
import com.lonelydeveloper97.nanolaw.cards.single.impl.SingleCardPresenterImpl;
import com.lonelydeveloper97.nanolaw.cards.single.impl.model.Card;
import com.lonelydeveloper97.nanolaw.navigation.MainPageFragment;
import com.lonelydeveloper97.nanolaw.utills.Fragments;

import java.util.Arrays;
import java.util.Collections;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        MainPageFragment fragment = Fragments.getFragment(getSupportFragmentManager(), R.id.contentFrame, new MainPageFragment());
        Fragments.startFragment(getSupportFragmentManager(), R.id.contentFrame, fragment);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_license) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_main) {
            // Handle the camera action
        } else if (id == R.id.nav_card_list) {
            SingleCardContract.Presenter presenter = new SingleCardPresenterImpl();
            SingleCardFragment singleCardFragment = new SingleCardFragment();
            singleCardFragment.setPresenter(presenter);
            Fragments.startFragment(getSupportFragmentManager(), R.id.contentFrame, singleCardFragment);
            singleCardFragment.setCard(new Card("Карточка 1", Arrays.asList("1", "2", "Text text text"),Arrays.asList("aaaaaaaaa", "bbbbbbbbbbbbbbb"), Collections.<String>emptyList(), "", ""));
        } else if (id == R.id.nav_about) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
