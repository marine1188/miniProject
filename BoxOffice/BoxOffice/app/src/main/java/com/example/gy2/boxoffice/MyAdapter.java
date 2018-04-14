package com.example.gy2.boxoffice;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by gy2 on 2018-04-02.
 */

public class MyAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<TouristAttraction> ta;

    public MyAdapter(Context context, ArrayList<TouristAttraction> ta) {
        this.context = context;
        this.ta = ta;
    }

    @Override
    public int getCount() {
        return ta.size();
    }

    @Override
    public Object getItem(int pos) {
        return ta.get(pos).getTaName();
    }

    @Override
    public long getItemId(int pos) {
        return pos;
    }

    @Override
    public View getView(int pos, View convertView, ViewGroup parent) {
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();

        if(convertView == null) {
            convertView = inflater.inflate(R.layout.list_item, null);
        }

        final TouristAttraction taItem = ta.get(pos);

        TextView rank = (TextView) convertView.findViewById(R.id.rank);
        TextView movieNm = (TextView) convertView.findViewById(R.id.movieNm);
        TextView openDt = (TextView) convertView.findViewById(R.id.openDt);

        rank.setText(taItem.getTaRank());
        movieNm.setText(taItem.getTaName());
        openDt.setText(taItem.getTaOpen());

        return convertView;
    }
}
