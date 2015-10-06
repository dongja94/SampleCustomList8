package com.example.dongja94.samplecustomlist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    MyAdapter mAdapter;

    int[] resIds = {R.drawable.a1439989229223, R.drawable.a1442124075796};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView)findViewById(R.id.listView);
        View headerView = getLayoutInflater().inflate(R.layout.view_header, null);
        mAdapter = new MyAdapter();
        listView.addHeaderView(headerView, "header", true);
        listView.setAdapter(mAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Object object = listView.getItemAtPosition(position);
                if (object instanceof  String) {
                    Toast.makeText(MainActivity.this, "Header...", Toast.LENGTH_SHORT).show();
                } else {
                    ItemData data = (ItemData) object;
                    Toast.makeText(MainActivity.this, "item : " + data.title, Toast.LENGTH_SHORT).show();
                }
            }
        });
        mAdapter.setOnAdapterImageListener(new MyAdapter.OnAdapterImageListener() {
            @Override
            public void onAdapterImageClick(MyAdapter adapter, ItemView view, ItemData data) {
                Toast.makeText(MainActivity.this, "ItemData : " + data.title, Toast.LENGTH_SHORT).show();
            }
        });
//        mAdapter.setOnImageClickListener(new ItemView.OnImageClickListener() {
//            @Override
//            public void onImageClick(ItemView view, ItemData data) {
//                Toast.makeText(MainActivity.this, "ItemData : " + data.title, Toast.LENGTH_SHORT).show();
//            }
//        });

        initData();
    }

    private void initData() {
        for (int i = 0; i < 20 ; i++) {
            ItemData d = new ItemData();
            d.title = "Item Title : " + i;
            d.desc = "Item Desc : " + i;
            d.icon = getResources().getDrawable(resIds[i % resIds.length]);
            mAdapter.add(d);
        }
    }
}
