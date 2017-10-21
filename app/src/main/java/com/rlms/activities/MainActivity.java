package com.rlms.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.rlms.R;
import com.rlms.core.LocationService;
import com.rlms.fragments.ComplainHomeFragment;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    ComplainHomeFragment complainHomeFragment = new ComplainHomeFragment();
    FragmentManager fragmentManager;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowTitleEnabled(true);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        fragmentManager = getSupportFragmentManager();
        navigationView.setCheckedItem(R.id.nav_complaints);
        loadComplaintsFragment();
        startService(new Intent(getBaseContext(), LocationService.class));
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_complaints) {

        } else if (id == R.id.nav_lift_config) {

        } else if (id == R.id.nav_update_params) {

        } else if (id == R.id.nav_upload_photos) {
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void loadComplaintsFragment() {
        getSupportActionBar().setTitle(getString(R.string.complaints_toolbar));
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        if (!complainHomeFragment.isAdded() && !complainHomeFragment.isVisible()) {
            fragmentTransaction.add(R.id.fragment_home, complainHomeFragment, "0");
            fragmentTransaction.commit();
        } else {
            fragmentTransaction.show(complainHomeFragment);
            fragmentTransaction.commit();
        }
    }

}
