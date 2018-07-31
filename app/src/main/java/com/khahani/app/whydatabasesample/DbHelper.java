package com.khahani.app.whydatabasesample;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.khahani.app.whydatabasesample.CoursesContract;
import com.khahani.app.whydatabasesample.CoursesContract.CoursesEntry;


/*.open bartar.db

        CREATE TABLE courses(
        title	TEXT,
        hours	INTEGER);

        INSERT INTO courses
        (title, hours)
        VALUES
        ('Android', 60);

        INSERT INTO courses
        (title)
        VALUES
        ('Java');

        UPDATE courses
        SET hours = 30
        WHERE title = 'Java';

        DELETE FROM courses
        WHERE title = 'Java';

        CREATE TABLE test(
        name TEXT);

        DROP TABLE test;



        .databases
        .mod column
        .header on*/


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
