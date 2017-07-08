package com.greiner_co.habittrackerapp;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.greiner_co.habittrackerapp.data.HabitContract.HabitEntry;
import com.greiner_co.habittrackerapp.data.HabitDbHelper;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    private static final String HABIT_STRING_DIVIDER = " - ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Insert dummy records
        HabitDbHelper mDbHelper = new HabitDbHelper(this);

        mDbHelper.insertNewRecord(
                "Drink glass of water",
                "Drink enough water during the day",
                0
        );

        mDbHelper.insertNewRecord(
                "Stand 2 minutes",
                "Stand up for a certain amount of time during the day"
        );

        mDbHelper.insertNewRecord("Have a walk with the dog");

        // Query all records
        Cursor cursor = mDbHelper.queryAllRecords();

        // Get index of each column
        int idColumnIndex = cursor.getColumnIndex(HabitEntry._ID);
        int titleColumnIndex = cursor.getColumnIndex(HabitEntry.COLUMN_HABIT_TITLE);
        int descColumnIndex = cursor.getColumnIndex(HabitEntry.COLUMN_HABIT_DESC);
        int countColumnIndex = cursor.getColumnIndex(HabitEntry.COLUMN_HABIT_COUNT);

        try {
            while (cursor.moveToNext()) {
                String habitString = "Habit No: " +
                        cursor.getInt(idColumnIndex) +
                        HABIT_STRING_DIVIDER +
                        cursor.getString(titleColumnIndex) +
                        HABIT_STRING_DIVIDER +
                        cursor.getString(descColumnIndex) +
                        HABIT_STRING_DIVIDER +
                        "Count: " +
                        cursor.getInt(countColumnIndex);

                Log.v(LOG_TAG, habitString);
            }
        } finally {
            cursor.close();
        }
    }
}
