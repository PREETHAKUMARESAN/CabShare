package com.example.preethakumaresan.cabshare;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by PREETHA KUMARESAN on 04-09-2016.
 */
public class ListViewAdapter extends BaseAdapter {

    Context mContext;
    LayoutInflater inflater;
    private List<cabdetails> cablist = null;
    private ArrayList<cabdetails> arraylist;





    public ListViewAdapter(Context context, ArrayList<cabdetails> cablist) {

        mContext = context;
        this.cablist = cablist;
        inflater = LayoutInflater.from(mContext);
        this.arraylist = new ArrayList<cabdetails>();
        this.arraylist.addAll(cablist);

    }

    public class ViewHolder {
        TextView dest;
        TextView date;
        TextView time;
    }

    @Override
    public int getCount() {
        return cablist.size();
    }

    @Override
    public Object getItem(int position) {
        return cablist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View view, ViewGroup parent) {

        final ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.singleitemview, null);
            holder.dest = (TextView) view.findViewById(R.id.destination);
            holder.date = (TextView) view.findViewById(R.id.date);
            holder.time = (TextView) view.findViewById(R.id.time);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        holder.dest.setText(cablist.get(position).getDestination());
        holder.date.setText(cablist.get(position).getDate());
        holder.time.setText(cablist.get(position).getTime());
        view.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // Send single item click data to SingleItemView Class
                Intent intent = new Intent(mContext, SingleItemView.class);
                intent.putExtra("dest",(cablist.get(position).getDestination()));
                // Pass all data country
                intent.putExtra("date",(cablist.get(position).getDate()));
                // Pass all data population
                intent.putExtra("time",(cablist.get(position).getTime()));
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                mContext.startActivity(intent);
            }

        });


        return view;
    }

    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        cablist.clear();
        if (charText.length() == 0) {
            cablist.addAll(arraylist);
        }
        else
        {
            for (cabdetails wp : arraylist)
            {
                if (wp.getDestination().toLowerCase(Locale.getDefault()).contains(charText))
                {
                    cablist.add(wp);
                }
            }
        }
        notifyDataSetChanged();
    }


}
