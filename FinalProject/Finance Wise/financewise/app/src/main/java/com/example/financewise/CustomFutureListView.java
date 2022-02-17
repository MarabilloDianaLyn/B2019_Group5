package com.example.financewise;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class CustomFutureListView extends ArrayAdapter<String>{

    private String[] fcategory;
    private String[] fcategitem;
    private String[] famount;
    private String[] fmonth;
    private String[] fday;
    private String[] fyear;
    private Activity fcontext;

    public CustomFutureListView(Activity fcontext, String[] fcategory, String[] fcategitem, String[] famount,
                                String[] fmonth, String[] fday, String[] fyear){
        super(fcontext, R.layout.layout_future,fcategory);
        this.fcontext=fcontext;
        this.fcategory=fcategory;
        this.fcategitem=fcategitem;
        this.famount=famount;
        this.fmonth=fmonth;
        this.fday=fday;
        this.fyear=fyear;
    }

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        View f = convertView;
        CustomFutureListView.ViewHolder viewHolder = null;
        if(f==null){
            LayoutInflater layoutInflater=fcontext.getLayoutInflater();
            f=layoutInflater.inflate(R.layout.layout_future, null, true);
            viewHolder=new CustomFutureListView.ViewHolder(f);
            f.setTag(viewHolder);
        }
        else{
            viewHolder=(CustomFutureListView.ViewHolder)f.getTag();
        }

        viewHolder.f1.setText(fcategory[position]);
        viewHolder.f2.setText(fcategitem[position]);
        viewHolder.f3.setText(famount[position]);
        viewHolder.f4.setText(fmonth[position]);
        viewHolder.f5.setText(fday[position]);
        viewHolder.f6.setText(fyear[position]);

        return f;
    }

    class ViewHolder{
        TextView f1;
        TextView f2;
        TextView f3;
        TextView f4;
        TextView f5;
        TextView f6;

        ViewHolder(View v){
            f1=(TextView)v.findViewById(R.id.fecategory);
            f2=(TextView)v.findViewById(R.id.fecategitem);
            f3=(TextView)v.findViewById(R.id.feamount);
            f4=(TextView)v.findViewById(R.id.femonth);
            f5=(TextView)v.findViewById(R.id.feday);
            f6=(TextView)v.findViewById(R.id.feyear);
        }
    }

}
