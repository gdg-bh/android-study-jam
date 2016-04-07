package com.studyjams.android.coolstuff;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.studyjams.android.coolstuff.fragments.InfoFragment;
import com.studyjams.android.coolstuff.fragments.ContactFragment;
import com.studyjams.android.coolstuff.fragments.Tela1Fragment;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    private DrawerLayout mDrawerLayout;
    private NavigationView mNavigationView;
    private ActionBarDrawerToggle mToggle;
    private static int mCurrentId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linkViews();
        configureUi();
        startFirstMenu();
    }

    // Mapping views to global variables
    private void linkViews() {
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mNavigationView = (NavigationView) findViewById(R.id.nav_view);
    }

    // Configure User Interface
    private void configureUi() {
        // Setting ActionBar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Navigation Drawer
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();

        mNavigationView.setNavigationItemSelectedListener(this);

        configureMenuHeader();
    }

    private void startFirstMenu() {
        MenuItem item = mNavigationView.getMenu().getItem(0);
        if (mCurrentId != 0)
            item = mNavigationView.getMenu().findItem(mCurrentId);
        onNavigationItemSelected(item);
    }

    private void configureMenuHeader() {
        if (mNavigationView.getHeaderCount() > 0) {
            View headerView = mNavigationView.getHeaderView(0);

            CircleImageView profileView = (CircleImageView) headerView.findViewById(R.id.image_profile);
            ImageView imageCover = (ImageView) headerView.findViewById(R.id.image_cover);
            TextView textName = (TextView) headerView.findViewById(R.id.text_name);
            TextView textEmail = (TextView) headerView.findViewById(R.id.text_email);

            // Photos url address
            String avatar = "https://lh3.googleusercontent.com/A4KoFMSGUz6WxQwffxN4p6a6rcyVjMcSad6j2ER7glsZgbAbUo8olMuUdnjcSoEgDyVVvw=w1280-h800-rw-no";
            String cover = "https://lh3.googleusercontent.com/-G67OGhbHJwY/UZWs1O4wMcI/AAAAAAAAEeE/IPV2rEnCi2gSHCJmVnnszdWHYb7x3ImZA/s1000-fcrop64=1,000018f5ffffff48/Creative_Wallpaper_Boat_in_a_bottle_016449_.jpg";

            //Loading images to ImageViews
            Picasso.with(this).load(avatar).into(profileView);
            Picasso.with(this).load(cover).into(imageCover);

            //Setting user name and email
            textName.setText(R.string.name_jordan);
            textEmail.setText(R.string.mail_jordan);
        }
    }

    @Override
    public void onBackPressed() {
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        // Check if menu item clicked is different from current
        if (id != mCurrentId) {
            // New fragment
            Fragment fragment = null;
            mCurrentId = id;
            int title = R.string.app_name;

            // Verify which button was clicked and choose correct action for this
            switch (mCurrentId) {
                case R.id.nav_tela1:
                    fragment = Tela1Fragment.newInstance();
                    break;
                case R.id.nav_lista:
                    int columns = 1;

                    // Check orientation to set two columns (GridLayout)
                    if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE)
                        columns = 2;

                    fragment = ContactFragment.newInstance(columns);
                    break;
                case R.id.nav_info:
                    fragment = InfoFragment.newInstance();
                    title = R.string.sobre;
                    break;
                default:
                    fragment = Tela1Fragment.newInstance();
                    break;
            }

            // Changing activity content
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.frame_content, fragment).commit();

            // Set menu item checked
            mNavigationView.setCheckedItem(id);

            //Close navigation drawer (menu)
            mDrawerLayout.closeDrawer(GravityCompat.START);

            getSupportActionBar().setTitle(title);

            return true;
        } else {
            mDrawerLayout.closeDrawer(GravityCompat.START);
            return false;
        }
    }
}
