package com.greiner_co.habittrackerapp.data;

import android.provider.BaseColumns;

/**
 * Custom contract class to hold the database scheme
 * Created by Jens Greiner on 08.07.17.
 */

public final class HabitContract {
    private HabitContract() {
        // intentionally left blank to prevent other from instantiating the contract class
    }

    public static class HabitEntry implements BaseColumns {

        public static final String TABLE_NAME = "habits";

        // Unique row ID - INTEGER
        public static final String _ID = BaseColumns._ID;

        // Habit title - TEXT
        public static final String COLUMN_HABIT_TITLE = "title";

        // Habit description (optional) - TEXT
        public static final String COLUMN_HABIT_DESC = "description";

        // Habit achievement counter - INTEGER
        public static final String COLUMN_HABIT_COUNT = "counter";
    }
}
