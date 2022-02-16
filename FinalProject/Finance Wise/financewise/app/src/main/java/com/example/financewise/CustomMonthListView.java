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

public class CustomMonthListView extends ArrayAdapter<String> {
    private String[] mcategory;
    private String[] mcategitem;
    private String[] mamount;
    private String[] mmonth;
    private String[] mday;
    private String[] myear;
    private Activity mcontext;

    public CustomMonthListView(Activity mcontext, String[] mcategory, String[] mcategitem, String[] mamount,
                               String[] mmonth, String[] mday, String[] myear){
        super(mcontext, R.layout.layout_monthly,mcategory);
        this.mcontext=mcontext;
        this.mcategory=mcategory;
        this.mcategitem=mcategitem;
        this.mamount=mamount;
        this.mmonth=mmonth;
        this.mday=mday;
        this.myear=myear;

    }

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        View m = convertView;
        CustomMonthListView.ViewHolder viewHolder = null;
        if(m==null){
            LayoutInflater layoutInflater=mcontext.getLayoutInflater();
            m=layoutInflater.inflate(R.layout.layout_monthly, null, true);
            viewHolder=new ViewHolder(m);
            m.setTag(viewHolder);
        }
        else{
            viewHolder=(CustomMonthListView.ViewHolder)m.getTag();
        }

        viewHolder.m1.setText(mcategory[position]);
        viewHolder.m2.setText(mcategitem[position]);
        viewHolder.m3.setText(mamount[position]);
        viewHolder.m4.setText(mmonth[position]);
        viewHolder.m5.setText(mday[position]);
        viewHolder.m6.setText(myear[position]);

        return m;
    }

    public class ViewHolder {
        TextView m1;
        TextView m2;
        TextView m3;
        TextView m4;
        TextView m5;
        TextView m6;

        ViewHolder(View v){
            m1=(TextView)v.findViewById(R.id.lmcategory);
            m2=(TextView)v.findViewById(R.id.lmcategitem);
            m3=(TextView)v.findViewById(R.id.lmamount);
            m4=(TextView)v.findViewById(R.id.lmmonth);
            m5=(TextView)v.findViewById(R.id.lmday);
            m6=(TextView)v.findViewById(R.id.lmyear);


        }

    }
}
