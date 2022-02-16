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

public class CustomListView extends ArrayAdapter<String> {

    private String[] category;
    private String[] categitem;
    private String[] amount;
    private String[] month;
    private String[] day;
    private String[] year;
    private Activity context;


    public CustomListView(Activity context, String[] category, String[] categitem, String[] amount,
                          String[] month, String[] day, String[] year) {
        super(context, R.layout.layout,category);
        this.context=context;
        this.category=category;
        this.categitem=categitem;
        this.amount=amount;
        this.month=month;
        this.day=day;
        this.year=year;

    }

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        View r=convertView;
        ViewHolder viewHolder = null;
        if(r==null){
            LayoutInflater layoutInflater=context.getLayoutInflater();
            r=layoutInflater.inflate(R.layout.layout, null, true);
            viewHolder=new ViewHolder(r);
            r.setTag(viewHolder);
        }
        else{
            viewHolder=(ViewHolder)r.getTag();
        }

        viewHolder.tvw1.setText(category[position]);
        viewHolder.tvw2.setText(categitem[position]);
        viewHolder.tvw3.setText(amount[position]);
        viewHolder.tvw4.setText(month[position]);
        viewHolder.tvw5.setText(day[position]);
        viewHolder.tvw6.setText(year[position]);


        return r;
    }

    class ViewHolder{
        TextView tvw1;
        TextView tvw2;
        TextView tvw3;
        TextView tvw4;
        TextView tvw5;
        TextView tvw6;

        ViewHolder(View v){
            tvw1=(TextView)v.findViewById(R.id.tvcategory);
            tvw2=(TextView)v.findViewById(R.id.tvcategitem);
            tvw3=(TextView)v.findViewById(R.id.tvamount);
            tvw4=(TextView)v.findViewById(R.id.tvmonth);
            tvw5=(TextView)v.findViewById(R.id.tvday);
            tvw6=(TextView)v.findViewById(R.id.tvyear);

        }

    }
}
