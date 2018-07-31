package com.khahani.app.whydatabasesample;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button addButton;
    EditText titleEditText, hoursEditText;
    TextView listTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addButton = findViewById(R.id.add);
        titleEditText = findViewById(R.id.title);
        hoursEditText = findViewById(R.id.hours);
        listTextView = findViewById(R.id.list);

        addButton.setOnClickListener(addListener);

        showData();
    }

    private View.OnClickListener addListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (titleEditText.getText().length() <= 0)
                return;

            listTextView.append(titleEditText.getText().toString() + "\n\n");

            String title = titleEditText.getText().toString();
            int hours = Integer.parseInt(hoursEditText.getText().toString());

            newCoures(title, hours);

            showData();
        }
    };

    private void newCoures(String title, int hours) {
        DbHelper dbHelper = new DbHelper(this);                 //SQLiteOpenHelper
        SQLiteDatabase db = dbHelper.getWritableDatabase();     // writable > database

        ContentValues contentValues = new ContentValues();      // contentValues
        contentValues.put(CoursesContract.CoursesEntry.COLUMN_TITLE, title);    //put
        contentValues.put(CoursesContract.CoursesEntry.COLUMN_HOURS, hours);    //put

        db.insert(CoursesContract.CoursesEntry.TABLE_NAME, null, contentValues);    //SQLiteDatabase.insert

        //db.execSQL("INSERT INTO courses (title, hours) VALUES ('"+title+"',"+hours+" );");
    }

    private void showData() {
        DbHelper dbHelper = new DbHelper(this);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query("courses", null, null, null, null, null, null);
        while(cursor.moveToNext()){
            Log.e("DATABASE", "TITLE: " + cursor.getString(0)+", HOURS: " + cursor.getString(1));
        }
        cursor.close();
    }
}
