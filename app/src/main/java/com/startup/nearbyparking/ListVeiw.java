package com.startup.nearbyparking;

import android.app.Activity;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.List;
import java.util.ArrayList;
import android.content.Context;

public class ListVeiw extends AppCompatActivity {
    private String[] shopname={"intakhab","warish","ajeet","rustam"};
    private String[] costOfApple={"intakhab","warish","ajeet","rustam"};
    private String[] numberOfapple={"intakhab","warish","ajeet","rustam"};
    private String[] numberOfOrange={"intakhab","warish","ajeet","rustam"};
    private String[] CostOfOrange={"intakhab","warish","ajeet","rustam"};
    private int[] img={R.drawable.bike,R.drawable.car,R.drawable.cars,R.drawable.location};

    Databasehelper mydb;
    TextView shname,cscar,cobike,nocar,nobike;
    String DATABASE_NAME="owner";
    SQLiteDatabase sqlDatabase;

    private ListView lvProduct;
    private CustomAdapter adapter;
    private List <FareListItem> fList;
    private Databasehelper mDBHelper;

   Context context;


    ListView lvCustomList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);


        ListView listView = (ListView) findViewById(R.id.list);
       // listView.setAdapter(new CustomAdapter(this,shopname,costOfApple,numberOfapple,CostOfOrange,numberOfOrange));
//   showlist();

//  context=this;
        fList = mDBHelper.getList();
        //Init adapter
        adapter = new CustomAdapter(this, fList);
        //Set adapter for listview
        lvProduct.setAdapter(adapter);
        //listView.setAdapter(new CustomAdapter(this,fList));


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),"the position "+position+1,Toast.LENGTH_SHORT).show();
            }
        });
    }













/*
    //function to display in listview
    private void showlist() {

        ArrayList<FareListItem> fareList = new ArrayList<FareListItem>();
        fareList.clear();
        String query = "SELECT * FROM owner ";

        //Cursor c1 = sqlHandler.selectQuery(query);

        Cursor c1 = null;
        try {

            if (sqlDatabase.isOpen()) {
                sqlDatabase.close();

            }
            sqlDatabase = mydb.getWritableDatabase();
            c1 = sqlDatabase.rawQuery(query, null);

        } catch (Exception e) {

            System.out.println("DATABASE ERROR " + e);

        }


        if (c1 != null && c1.getCount() != 0) {
            if (c1.moveToFirst()) {
                do {
                    FareListItem fareListItems = new FareListItem();

                    fareListItems.setPsname(c1.getString(c1
                            .getColumnIndex("slno")));
                    fareListItems.setFcar(c1.getString(c1
                            .getColumnIndex("FAREOFCAR")));
                    fareListItems.setNcar(c1.getString(c1
                            .getColumnIndex("NOfCAR")));

                    fareListItems.setFbike(c1.getString(c1
                            .getColumnIndex("FAREOFBIKE")));

                    fareListItems.setNbike(c1.getString(c1
                            .getColumnIndex("NOfBIKE")));
                    fareList.add(fareListItems);

                } while (c1.moveToNext());
            }
        }
        c1.close();

        CustomAdapter fListAdapter = new CustomAdapter(
                ListVeiw.this, fareList);
        lvCustomList.setAdapter(fListAdapter);

    }

*/




}
