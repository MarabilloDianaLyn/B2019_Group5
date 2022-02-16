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

import java.util.Calendar;

public class CustomYearListView extends ArrayAdapter<String>{
    private String[] ycategory;
    private String[] ycategitem;
    private String[] yamount;
    private String[] ymonth;
    private String[] yday;
    private String[] yyear;
    private Activity ycontext;

    public CustomYearListView(Activity ycontext, String[] ycategory, String[] ycategitem, String[] yamount,
                              String[] ymonth, String[] yday, String[] yyear){
        super(ycontext, R.layout.layout_yearly,ycategory);
        this.ycontext=ycontext;
        this.ycategory=ycategory;
        this.ycategitem=ycategitem;
        this.yamount=yamount;
        this.ymonth=ymonth;
        this.yday=yday;
        this.yyear=yyear;
    }

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        View y = convertView;
        ViewHolder viewHolder = null;
        if(y==null){
            LayoutInflater layoutInflater=ycontext.getLayoutInflater();
            y=layoutInflater.inflate(R.layout.layout_monthly, null, true);
            viewHolder=new ViewHolder(y);
            y.setTag(viewHolder);
        }
        else{
            viewHolder=(ViewHolder)y.getTag();
        }

            viewHolder.y1.setText(ycategory[position]);
            viewHolder.y2.setText(ycategitem[position]);
            viewHolder.y3.setText(yamount[position]);
            viewHolder.y4.setText(ymonth[position]);
            viewHolder.y5.setText(yday[position]);
            viewHolder.y6.setText(yyear[position]);

        return y;
    }

    public class ViewHolder{
        TextView y1;
        TextView y2;
        TextView y3;
        TextView y4;
        TextView y5;
        TextView y6;

        ViewHolder(View v){
            y1=(TextView)v.findViewById(R.id.lycategory);
            y2=(TextView)v.findViewById(R.id.lycategitem);
            y3=(TextView)v.findViewById(R.id.lyamount);
            y4=(TextView)v.findViewById(R.id.lymonth);
            y5=(TextView)v.findViewById(R.id.lyday);
            y6=(TextView)v.findViewById(R.id.lyyear);

        }
    }
}
