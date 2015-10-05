package com.example.dongja94.samplecustomlist;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dongja94 on 2015-10-05.
 */
public class MyAdapter extends BaseAdapter {
    List<ItemData> items = new ArrayList<ItemData>();

    public void add(ItemData item) {
        items.add(item);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ItemView view = new ItemView(parent.getContext());
        view.setItemData(items.get(position));
        return view;
    }
}
