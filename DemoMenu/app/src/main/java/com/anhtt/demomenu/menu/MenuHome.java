package com.anhtt.demomenu.menu;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.anhtt.demomenu.R;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;

/**
 * Created by Huu Duan on 6/14/2016.
 */
@EActivity(R.layout.activity_menu)
public class MenuHome extends Activity {

    @ViewById(R.id.navList)
    ListView mNavList;
    @ViewById(R.id.drawerPane)
    RelativeLayout mDrawerPane;
    @ViewById(R.id.drawerLayout)
    DrawerLayout mDrawerLayout;

    private ArrayList<NavItem> mNavItem = new ArrayList<>();
    private ActionBarDrawerToggle mDrawerToggle;
    private NavItem item;
    private MenuAdapter mAdapterMenu;

    @AfterViews
    void init(){
        item = new NavItem();
        item.setMTitle("Home");
        item.setMIcon(R.drawable.ic_launcher);
        mNavItem.add(item);
        item = new NavItem();
        item.setMTitle("Home");
        item.setMIcon(R.drawable.ic_launcher);
        mNavItem.add(item);
        item = new NavItem();
        item.setMTitle("Home");
        item.setMIcon(R.drawable.ic_launcher);
        mNavItem.add(item);
        initAdapter();
        eventClickMenu();
    }

    /**
     * adapter menu
     */
    private void initAdapter(){
        mAdapterMenu = new MenuAdapter(this,mNavItem);
        mNavList.setAdapter(mAdapterMenu);
        mNavList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                displayView(position);
            }
        });
    }

    /**
     * view sliding menu
     * @param position
     */
    private void displayView(int position){
        Fragment fragment = null;
        switch (position){
            case 0:
                fragment = new HomeFragment().newInstance();
                break;
            case 1:
                fragment = new SettingFragment().newInstance();
                break;
            case 2:
                break;
            case 3:
                break;
            default:
                break;
        }
        if (fragment != null) {
            FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.mainContent,fragment).commit();
            mNavList.setItemChecked(position,true);
            setTitle(mNavItem.get(position).getMTitle());
            mDrawerLayout.closeDrawer(mDrawerPane);
        }
    }

    /**
     * event click open and close
     */
    private void eventClickMenu(){
        mDrawerToggle = new ActionBarDrawerToggle(this,mDrawerLayout,R.drawable.ic_launcher,R.string.app_name,R.string.app_name){
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                invalidateOptionsMenu();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                invalidateOptionsMenu();
            }
        };
        mDrawerLayout.setDrawerListener(mDrawerToggle);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Pass the event to ActionBarDrawerToggle
        // If it returns true, then it has handled
        // the nav drawer indicator touch event
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        // Handle your other action bar items...

        return super.onOptionsItemSelected(item);
    }
}
