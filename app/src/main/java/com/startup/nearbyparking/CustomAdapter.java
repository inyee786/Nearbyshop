package com.startup.nearbyparking;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by Eftakhar on 30-01-2017.
 */

public class CustomAdapter extends BaseAdapter {



   //String[] shopname;
/*    String[] costOfApple;
    String[] numberOfapple;
    String[] numberOfOrange;
    String[] CostOfOrange;






    String items[];

    ListVeiw list;
    LayoutInflater layoutInflater=null;
  */
    Context context;
    ArrayList<FareListItem> fareList;

    public CustomAdapter(Context context, ArrayList<FareListItem> fareList) {
        this.context = context;
        this.fareList = fareList;
    }





   /* public CustomAdapter(ListVeiw list,String shopname[],String costOfApple[],String numberOfapple[],String numberOfOrange[],String CostOfOrange[]){

        this.shopname=shopname;
        this.costOfApple=costOfApple;
        this.numberOfapple=numberOfapple;
        this.CostOfOrange=CostOfOrange;
        this.numberOfOrange=numberOfOrange;
        this.list=list;
        this.layoutInflater=(LayoutInflater)list.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
*/




    @Override
    public int getCount() {
        return fareList.size();
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









        View v = View.inflate(context, R.layout.listview_layout, null);
        TextView carPrice = (TextView)v.findViewById(R.id.cost_of_car);
        TextView  nocar= (TextView)v.findViewById(R.id.no_of_car);
        TextView bikePrice = (TextView)v.findViewById(R.id.cost_of_bike);
        TextView  nobike= (TextView)v.findViewById(R.id.no_of_bike);
        //TextView  parname= (TextView)v.findViewById(R.id.parkingname);
        carPrice.setText(fareList.get(position).getFcar());
        nocar.setText(fareList.get(position).getNcar());
        bikePrice.setText(fareList.get(position).getFbike());
        nobike.setText(fareList.get(position).getNbike());
        //parname.setText(shopname[position]);

        return v;






       /* View RowView = layoutInflater.inflate(R.layout.listview_layout,null);
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
        return convertView;*/


    }
}
