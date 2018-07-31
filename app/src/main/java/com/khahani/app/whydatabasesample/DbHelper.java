package com.khahani.app.whydatabasesample;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.khahani.app.whydatabasesample.CoursesContract;
import com.khahani.app.whydatabasesample.CoursesContract.CoursesEntry;


public class DbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "bartar.db";
    private static final int DATABASE_VERSION = 1;

    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_TABLE_COURSES = "CREATE TABLE "+
                CoursesEntry.TABLE_NAME + "(" +
                CoursesEntry.COLUMN_TITLE + " TEXT," +
                CoursesEntry.COLUMN_HOURS +" INTEGER);";

        db.execSQL(SQL_CREATE_TABLE_COURSES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE " + CoursesEntry.TABLE_NAME + ";");
        onCreate(db);
    }
}
