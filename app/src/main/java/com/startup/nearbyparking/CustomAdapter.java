package com.startup.nearbyparking;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by Eftakhar on 30-01-2017.
 */
public class CustomAdapter extends BaseAdapter {



    String[] shopname;
    String[] costOfApple;
    String[] numberOfapple;
    String[] numberOfOrange;
    String[] CostOfOrange;






    String items[];

    List list;
    LayoutInflater layoutInflater=null;
    Context context;
    ArrayList<FareListItem> fareList;

   /* public CustomAdapter(List list,String shopname[],String costOfApple[],String numberOfapple[],String numberOfOrange[],String CostOfOrange[]){

        this.shopname=shopname;
        this.costOfApple=costOfApple;
        this.numberOfapple=numberOfapple;
        this.CostOfOrange=CostOfOrange;
        this.numberOfOrange=numberOfOrange;
        this.list=list;
        this.layoutInflater=(LayoutInflater)list.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
*/


    public CustomAdapter(List context, ArrayList<FareListItem> list) {

        this.context = context;
        fareList = list;
    }


    @Override
    public int getCount() {
        return shopname.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.listview_layout, null);

        }

       // View RowView = layoutInflater.inflate(R.layout.listview_layout,null);
        TextView textView = (TextView) convertView.findViewById(R.id.text_list);
        textView.setText(shopname[position]);
        TextView textView1 = (TextView) convertView.findViewById(R.id.cost_of_apple);
        textView1.setText(costOfApple[position]);
        TextView textView2 = (TextView) convertView.findViewById(R.id.no_of_apple);
        textView2.setText(numberOfapple[position]);
        TextView textView3 = (TextView) convertView.findViewById(R.id.cost_of_orange);
        textView3.setText(CostOfOrange[position]);
        TextView textView4 = (TextView) convertView.findViewById(R.id.no_of_orange);
        textView4.setText(numberOfapple[position]);
        return convertView;


    }
}
