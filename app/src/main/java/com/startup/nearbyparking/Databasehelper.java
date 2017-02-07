package com.startup.nearbyparking;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.Cursor;
/**
 * Created by Intakhab Ali on 25-01-2017.
 */

 class Databasehelper extends SQLiteOpenHelper {


    public static final String DATABASE_NAME ="NearbyParking.db";

    public static final String TABLE_NAME1 ="owner";
    public static final String TABLE_NAME2="user";
    public static final String TABLE_NAME3="address";
    public static final String TABLE_NAME4="fare";
    public static final String COL_1_1 ="ID";
    public static final String COL_1_2 ="NAME";
    public static final String COL_1_3 ="PASSWORD";
    public static final String COL_1_4 ="P_NUMBER";
    public static final String COL_1_5 ="EMAIL_ID";

    public static final String COL_1_6 ="PARKINGSPACENAME";
    public static final String COL_1_7 ="STREETNAME";
    public static final String COL_1_8 ="TOWN";
    public static final String COL_1_9 ="CITY";
    public static final String COL_1_10 ="LANDMARK";
    public static final String COL_1_11 ="DISTRICT";
    public static final String COL_1_12 ="STATE";
    public static final String COL_1_13 ="PINCODE";

   // public static final String COL_1_13 ="HV_PS_CAR";
    public static final String COL_1_14 ="FAREOFCAR";
    public static final String COL_1_15 ="NOfCAR";
   // public static final String COL_1_16 ="HV_PS_BIKE";
    public static final String COL_1_17 ="FAREOFBIKE";
    public static final String COL_1_18 ="NOfBIKE";


    public Databasehelper(Context context) {
        super(context, DATABASE_NAME, null, 2);
        //SQLiteDatabase db = this.getReadableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //    db.execSQL("create table"+TABLE_NAME1+"(ID INTEGER PRIMARY KEY AUTOINCREMENT , PS_NAME TEXT , O_PASSWORD TEXT,P_NUMBER INTEGER , EMAIL_ID TEXT , LANDMARK TEXT , STREET_NAME TEXT , CITY TEXT , DISTRIC TEXT , PINCODE INTEGER , NO_PS_CAR INTEGER , NO_PS_BIKE INTEGER , C_CAR INTEGER , C_BIKE INTEGER )");

        db.execSQL("create table " + TABLE_NAME1 +" (ID INTEGER PRIMARY KEY AUTOINCREMENT , NAME TEXT ,PASSWORD TEXT, P_NUMBER INTEGER , EMAIL_ID TEXT) ");
        db.execSQL("create table " + TABLE_NAME2 + " (ID INTEGER PRIMARY KEY AUTOINCREMENT , NAME TEXT ,PASSWORD TEXT, P_NUMBER INTEGER , EMAIL_ID TEXT) ");
        db.execSQL("create table " + TABLE_NAME3 + " (ID INTEGER PRIMARY KEY AUTOINCREMENT ,PARKINGSPACENAME TEXT ,  STREETNAME TEXT ,TOWN TEXT, CITY TEXT , LANDMARK TEXT , DISTRICT TEXT ,STATE TEXT,PINCODE TEXT) ");
        db.execSQL("create table " + TABLE_NAME4 + " (ID INTEGER PRIMARY KEY  AUTOINCREMENT , NOfCAR TEXT DEFAULT NOTAVAILABLE , FAREOFCAR TEXT DEFAULT NOTAVAILABLE,NOfBIKE TEXT DEFAULT NOTAVAILABLE, FAREOFBIKE TEXT DEFAULT NOTAVAILABLE) ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXITS "+TABLE_NAME1);
        db.execSQL("DROP TABLE IF EXITS "+TABLE_NAME2);
        db.execSQL("DROP TABLE IF EXITS "+TABLE_NAME3);
        db.execSQL("DROP TABLE IF EXITS "+TABLE_NAME4);
        onCreate(db);
    }


//insert data for parking space owner
    public boolean insertdataOwner(String name,String pnumber,String password,String email)
   {
       SQLiteDatabase db = this.getReadableDatabase();
       ContentValues contentValues = new ContentValues();
       contentValues.put(COL_1_2, name);
       contentValues.put(COL_1_4, pnumber);
       contentValues.put(COL_1_3, password);
       contentValues.put(COL_1_5, email);

      long re= db.insert(TABLE_NAME1,null,contentValues);

      if(re==-1) {
          return false;
      } else {
          return true;
      }
   }

//insert data form user

    public boolean insertdataUser(String name,String pnumber,String password,String email)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1_2,name);
        contentValues.put(COL_1_4, pnumber);
        contentValues.put(COL_1_3, password);
        contentValues.put(COL_1_5, email);

        long re= db.insert(TABLE_NAME2,null,contentValues);

        if(re==-1) {
            return false;
        } else {
            return true;
        }
    }

//insert address to the database
    public boolean address(String psname,String street,String town,String city,String landmark,String district,String state,String pincode )
    {
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1_6,psname);
        contentValues.put(COL_1_7, street);
        contentValues.put(COL_1_8, town);
        contentValues.put(COL_1_9, city);
        contentValues.put(COL_1_10, landmark);
        contentValues.put(COL_1_11, district);
        contentValues.put(COL_1_12, state);
        contentValues.put(COL_1_13, pincode);

        long re= db.insert(TABLE_NAME3,null,contentValues);

        if(re==-1) {
            return false;
        } else {
            return true;
        }
    }


//insert fair for parking the vehicle
    public boolean farePerHour(String f_car,String no_ps_car,String f_bike,String no_ps_bike )
    {
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1_14, f_car);
        contentValues.put(COL_1_15, no_ps_car);
        contentValues.put(COL_1_17, f_bike);
        contentValues.put(COL_1_18, no_ps_bike);

        long re= db.insert(TABLE_NAME4,null,contentValues);

        if(re==-1) {
            return false;
        } else {
            return true;
        }
    }











    //function for login to user
    public boolean getUser(String email, String pass){

        String selectQuery = "select * from  " + TABLE_NAME2 + " where " +
                COL_1_5 + " = " + "'"+email+"'" + " and " + COL_1_3 + " = " + "'"+pass+"'";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        // Move to first row
        cursor.moveToFirst();
        if (cursor.getCount() > 0) {

            return true;
        }
        cursor.close();
        db.close();

        return false;
    }






}
