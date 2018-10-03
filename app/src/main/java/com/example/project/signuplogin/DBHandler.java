package com.example.project.signuplogin;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by ASUS on 3/26/2017.
 */

    public class DBHandler extends SQLiteOpenHelper {
    public static final String TAG = DBHandler.class.getSimpleName();
    public static final String DB_NAME = "registration.db";
    public static final int DB_VERSION = 1;

    public static final int LOGGEDIN = 1;
    public static final int NOTLOGGEDIN = 0;

    public static final String USER_TABLE = "users";
    public static final String SESSION_TABLE = "session";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_EMAIL = "email";
    public static final String COLUMN_PASS = "password";
    public static final String COLUMN_SESSION = "session";


    /* Create table users     */
    public static final String CREATE_TABLE_USERS = "CREATE TABLE IF NOT EXISTS " + USER_TABLE + "(" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_EMAIL + " TEXT, " + COLUMN_PASS + " TEXT);";
    public static final String CREATE_TABLE_SESSION = "CREATE TABLE IF NOT EXISTS " + SESSION_TABLE + "(" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_SESSION + " INTEGER);";

    public DBHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_USERS);
        db.execSQL(CREATE_TABLE_SESSION);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS" + USER_TABLE);
        db.execSQL("DROP TABLE IF EXISTS" + SESSION_TABLE);
        onCreate(db);
    }

    public void addUser(String email, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_EMAIL, email);
        values.put(COLUMN_PASS, password);

        long id = db.insert(USER_TABLE, null, values);
        db.close();

        Log.d(TAG, "user inserted" + id);
    }

    public void updateSession(int status) {
        SQLiteDatabase db = this.getReadableDatabase();
        SQLiteDatabase db1 = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_SESSION, status);

        String selectQuery = "select "+COLUMN_SESSION+" from " + SESSION_TABLE + ";";
        Cursor cursor = db.rawQuery(selectQuery, null);

        if(cursor.getCount()<1){
            long id = db1.insert(SESSION_TABLE, null, values);
        }else {
            int id = db1.update(SESSION_TABLE, values, COLUMN_ID+"=?", new String[]{"1"});
        }


        db.close();
        db1.close();
        cursor.close();
    }

    public boolean checkSession() {
        SQLiteDatabase db = this.getReadableDatabase();

        String selectQuery = "select "+COLUMN_SESSION+" from " + SESSION_TABLE + ";";
        Cursor cursor = db.rawQuery(selectQuery, null);

        cursor.moveToFirst();
        if (cursor.getCount() > 0) {
            int session = cursor.getInt(0);
            db.close();
            cursor.close();
            if(session == NOTLOGGEDIN) return false;
            else return true;

        }else {
            db.close();
            cursor.close();
            return false;
        }

    }

    public boolean getUser(String email, String pass) {
        String selectQuery = "select * from " + USER_TABLE + " where " + COLUMN_EMAIL + "=" + "'" + email + "'" + " and " + COLUMN_PASS + "=" + "'" + pass + "';";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        cursor.moveToFirst();
        if (cursor.getCount() > 0) {
            cursor.close();
            db.close();
            return true;
        }
        cursor.close();
        db.close();
        return false;
    }
}
