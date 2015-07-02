package com.annotera.annotera;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

/**
 * Created by tony on 6/30/15.
 */
public class DrawerItemClickListener extends ListView.OnItemClickListener {
    @Override
    public void onItemClick(AdapterView parent, View view, int position, long id) {
        selectItem(position);
    }
}
