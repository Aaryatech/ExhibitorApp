package com.ats.exhibitorapp.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.ats.exhibitorapp.R;
import com.ats.exhibitorapp.constant.Constant;
import com.ats.exhibitorapp.fragment.EnquiryFragment;
import com.ats.exhibitorapp.fragment.EventInfoFragment;
import com.ats.exhibitorapp.fragment.EventsFragment;
import com.ats.exhibitorapp.fragment.FeedbackFragment;
import com.ats.exhibitorapp.fragment.HomeFragment;
import com.ats.exhibitorapp.fragment.PortfolioFragment;
import com.ats.exhibitorapp.fragment.ProductsFragment;
import com.ats.exhibitorapp.fragment.VisitorSearchFragment;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.content_frame, new HomeFragment(), "Home");
        ft.commit();
    }

    @Override
    public void onBackPressed() {

        Fragment home = getSupportFragmentManager().findFragmentByTag(Constant.home);
        Fragment homeFragment = getSupportFragmentManager().findFragmentByTag(Constant.homeFragment);

        Fragment eventsFragment = getSupportFragmentManager().findFragmentByTag(Constant.eventFragment);
        Fragment eventDetailFragment = getSupportFragmentManager().findFragmentByTag(Constant.eventInfoFragment);

        DrawerLayout drawer =  findViewById(R.id.drawer_layout);

        if (drawer.isDrawerOpen(GravityCompat.START)) {

            drawer.closeDrawer(GravityCompat.START);

        } else if (home instanceof HomeFragment && home.isVisible()) {

            AlertDialog.Builder builder = new AlertDialog.Builder(HomeActivity.this);
            builder.setTitle("Confirm Action");
            builder.setMessage("Do you want to exit?");
            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });
            builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });

            AlertDialog dialog = builder.create();
            dialog.show();

        } else if (eventsFragment instanceof EventInfoFragment && eventsFragment.isVisible()) {

            Fragment fragment = new EventsFragment();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_frame, fragment, Constant.home);
            ft.commit();

        } else if (eventDetailFragment instanceof VisitorSearchFragment && eventDetailFragment.isVisible() ||
                eventDetailFragment instanceof EnquiryFragment && eventDetailFragment.isVisible() ||
                eventDetailFragment instanceof FeedbackFragment && eventDetailFragment.isVisible()) {

            Fragment fragment = new EventInfoFragment();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_frame, fragment, Constant.eventFragment);
            ft.commit();

        } else if (homeFragment instanceof ProductsFragment && homeFragment.isVisible() || homeFragment instanceof PortfolioFragment && homeFragment.isVisible()) {

            Fragment fragment = new HomeFragment();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_frame, fragment, Constant.home);
            ft.commit();

        } else {
            super.onBackPressed();
        }

    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_products) {

            Fragment fragment = new ProductsFragment();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_frame, fragment, Constant.homeFragment);
            ft.commit();

        } else if (id == R.id.nav_portfolio) {

            Fragment fragment = new PortfolioFragment();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_frame, fragment, Constant.homeFragment);
            ft.commit();

        } else if (id == R.id.nav_visits) {

            startActivity(new Intent(getApplicationContext(),MapsActivity.class));

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
