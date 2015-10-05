package com.example.dongja94.samplecustomlist;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dongja94 on 2015-10-05.
 */
public class MyAdapter extends BaseAdapter implements  ItemView.OnImageClickListener {
    List<ItemData> items = new ArrayList<ItemData>();

    public interface OnAdapterImageListener {
        public void onAdapterImageClick(MyAdapter adapter, ItemView view, ItemData data);
    }
    OnAdapterImageListener mListener;
    public void setOnAdapterImageListener(OnAdapterImageListener listener) {
        mListener = listener;
    }

    ItemView.OnImageClickListener mImageClickListener;
    public void setOnImageClickListener(ItemView.OnImageClickListener listener) {
        mImageClickListener = listener;
        notifyDataSetChanged();
        notifyDataSetInvalidated();
    }

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
        ItemView view;
        if (convertView == null) {
            view =  new ItemView(parent.getContext());
            view.setOnImageClickListener(this);
        } else {
            view = (ItemView) convertView;
        }
//        view.setOnImageClickListener(mImageClickListener);
        view.setItemData(items.get(position));
        return view;
    }

    @Override
    public void onImageClick(ItemView view, ItemData data) {
        if (mListener != null) {
            mListener.onAdapterImageClick(this, view, data);
        }
    }
}
