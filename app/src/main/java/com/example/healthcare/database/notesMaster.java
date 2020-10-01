package com.example.healthcare.database;

import android.provider.BaseColumns;

public class notesMaster {
    private notesMaster() {

    }
    protected  static  class Notes implements BaseColumns{
        public static final  String table1="Notes";


        //public static final  String col1_1="id";
        public static final  String col1="note";
        public static final  String col2="type";
        public static final  String col3="date";


    }
}
