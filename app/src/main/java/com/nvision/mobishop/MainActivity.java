package com.nvision.mobishop;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;
import com.nvision.mobishop.fragments.ContactUsFragment;
import com.nvision.mobishop.fragments.HomeFragment;
import com.nvision.mobishop.fragments.ProfileFragment;
import com.nvision.mobishop.fragments.SettingsFragment;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private ActionBarDrawerToggle toggle;
    private DrawerLayout drawerLayout;
    private Toolbar toolbar;
    private NavigationView navigationView;

    private HomeFragment homeFragment;
    private ImageView deleteImg;
    private ImageView selectImg;
    private boolean isAllSelected = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        deleteImg = findViewById(R.id.delete);
        selectImg = findViewById(R.id.select_all);
        setSupportActionBar(toolbar);
        drawerLayout = findViewById(R.id.drawer_layout);
        // Before initialise ActionBarDrawerToggle initialise the toolbar and drawerLayout
        toggle = new ActionBarDrawerToggle(this, drawerLayout,toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        if (savedInstanceState == null) {
            homeFragment = new HomeFragment();
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, homeFragment).commit();
            navigationView.setCheckedItem(R.id.nav_home);
        }

        deleteImg.setOnClickListener(v -> {
            homeFragment.deleteSelectedItems();
            Toast.makeText(this, "Delete Selected Items", Toast.LENGTH_SHORT).show();
        });

        selectImg.setOnClickListener(v -> {
            if (isAllSelected) {
                homeFragment.unSelectAllItems();
                Toast.makeText(this, "Unelected All", Toast.LENGTH_SHORT).show();// Unselect all items
                isAllSelected = false;
            } else {
                homeFragment.selectAllItems();
                Toast.makeText(this, "Selected All", Toast.LENGTH_SHORT).show();// Select all items
                isAllSelected = true;
            }

        });

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_home:
                getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, new HomeFragment()).addToBackStack(null).commit();
                Toast.makeText(this, "Home Clicked!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_settings:
                getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, new SettingsFragment()).addToBackStack(null).commit();
                Toast.makeText(this, "Settings Clicked!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_profile:
                getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, new ProfileFragment()).addToBackStack(null).commit();
                Toast.makeText(this, "Profile Clicked!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_contact_us:
                getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, new ContactUsFragment()).addToBackStack(null).commit();
                Toast.makeText(this, "Contact Us Clicked!", Toast.LENGTH_SHORT).show();
                break;
            default:
                return true;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}