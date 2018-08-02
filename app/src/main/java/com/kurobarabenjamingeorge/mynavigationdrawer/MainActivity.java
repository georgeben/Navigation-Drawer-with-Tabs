package com.kurobarabenjamingeorge.mynavigationdrawer;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import com.kurobarabenjamingeorge.mynavigationdrawer.Utils.Utils;
import com.kurobarabenjamingeorge.mynavigationdrawer.adapters.PagerAdapter;

public class MainActivity extends AppCompatActivity implements
        NavigationView.OnNavigationItemSelectedListener{

    private DrawerLayout mDrawerLayout;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Set the toolbar as the app bar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar) ;
        setSupportActionBar(toolbar);

        //Display the menu toggle icon on the app bar
        ActionBar actionBar = getSupportActionBar();
        if(actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp);
        }

        mDrawerLayout =  (DrawerLayout) findViewById(R.id.drawer_layout);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);

        //Registers the NavigationItemSelectedListener to the navigation view
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggler = new ActionBarDrawerToggle(this, mDrawerLayout,
                R.string.open_nav, R.string.close_nav);
        mDrawerLayout.addDrawerListener(toggler);
        toggler.syncState();

        //Creates the tab layout from the layout and populates it with three tabs
        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText(R.string.top_grossing));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.new_movies));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.popular));

        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager =  (ViewPager) findViewById(R.id.pager);
        PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(pagerAdapter);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
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
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        item.setChecked(true);
        mDrawerLayout.closeDrawers();

        switch(item.getItemId()){
            case R.id.movies:
                Utils.makeToast(getString(R.string.movies_toast), MainActivity.this);
                return true;
            case R.id.books:
                Utils.makeToast(getString(R.string.books), MainActivity.this);
                return true;

            case R.id.music:
                Utils.makeToast(getString(R.string.music), MainActivity.this);
                return true;

            case R.id.favourites:
                Utils.makeToast(getString(R.string.favourites), MainActivity.this);
                return true;
        }
        return true;
    }


}
