package com.khahani.app.whydatabasesample;

import android.provider.BaseColumns;

/**
 * Created by dev on 7/31/2018.
 */

public class CoursesContract {

    public static class CoursesEntry implements BaseColumns{
        public static final String TABLE_NAME = "courses";
        public static final String COLUMN_TITLE = "title";
        public static final String COLUMN_HOURS = "hours";
    }
}
