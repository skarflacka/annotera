package com.annotera.annotera;

import android.content.res.Configuration;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private String[] mDrawerListContent;
    private ActionBarDrawerToggle mDrawerToggle;

    private Toolbar material_toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Toolbar set
        material_toolbar = (Toolbar) findViewById(R.id.material_toolbar);
        setSupportActionBar(material_toolbar);
        material_toolbar.setTitleTextColor(0xFF2196F3);

        //DrawerLayout set
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.drawer_list);
        mDrawerListContent = getResources().getStringArray(R.array.drawer_list_content);


        mDrawerToggle = new ActionBarDrawerToggle(
                this,
                mDrawerLayout,
                material_toolbar,
                R.string.hello_world,
                R.string.hello_world)
        {
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                invalidateOptionsMenu();
                syncState();
            }

            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                invalidateOptionsMenu();
                syncState();
            }
        };

        mDrawerLayout.setDrawerListener(mDrawerToggle);

        mDrawerList.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_single_choice, mDrawerListContent));

        mDrawerList.setOnItemClickListener(null);



    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // This to ensure the navigation icon is displayed as
        // burger instead of arrow.
        // Call syncState() from your Activity's onPostCreate
        // to synchronize the indicator with the state of the
        // linked DrawerLayout after onRestoreInstanceState
        // has occurred.
        mDrawerToggle.syncState();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // This method should always be called by your Activity's
        // onConfigurationChanged method.
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
