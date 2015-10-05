package com.example.dongja94.samplecustomlist;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by dongja94 on 2015-10-05.
 */
public class ItemView extends RelativeLayout {

    public ItemView(Context context) {
        super(context);
        init();
    }

    public ItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    ImageView iconView;
    TextView titleView, descView;
    ItemData mData;

    public interface OnImageClickListener {
        public void onImageClick(ItemView view, ItemData data);
    }

    OnImageClickListener mListener;
    public void setOnImageClickListener(OnImageClickListener listener) {
        mListener = listener;
    }

    private void init() {
//        LayoutInflater.from(getContext()).inflate(R.layout.view_item, this);
        inflate(getContext(), R.layout.view_item, this);
        iconView = (ImageView)findViewById(R.id.image_icon);
        iconView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null) {
                    mListener.onImageClick(ItemView.this, mData);
                }
            }
        });

        titleView = (TextView)findViewById(R.id.text_title);
        descView = (TextView)findViewById(R.id.text_desc);

    }

    public void setItemData(ItemData data) {
        mData = data;
        if (data.icon != null) {
            iconView.setImageDrawable(data.icon);
        }
        titleView.setText(data.title);
        descView.setText(data.desc);
    }

    public void changeText() {
        if (mData == null) return;
        titleView.setText(mData.desc);
        descView.setText(mData.title);
    }

}
