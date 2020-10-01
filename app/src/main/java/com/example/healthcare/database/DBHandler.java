package com.example.healthcare.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.sql.Date;


public class DBHandler extends SQLiteOpenHelper {

    public static  final String database_name="UserInfo.db";

    public DBHandler(Context context){
        super(context,database_name, null,1);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String SQL_CREATE_ENTRIES_NOTES =
                "CREATE TABLE " + notesMaster.Notes.table1 + " (" +
                        notesMaster.Notes._ID + " INTEGER PRIMARY KEY," +
                        notesMaster.Notes.col1 + " TEXT," +
                        notesMaster.Notes.col2 + " TEXT," +
                        notesMaster.Notes.col3 + " TEXT)";


        sqLiteDatabase.execSQL(SQL_CREATE_ENTRIES_NOTES);


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public int addNotes(String note, String type, String date){

        SQLiteDatabase db=getWritableDatabase();
        ContentValues val=new ContentValues();

        val.put(notesMaster.Notes.col1,note);
        val.put(notesMaster.Notes.col2,type);
        val.put(notesMaster.Notes.col3,date);

        long newrowID = db.insert(notesMaster.Notes.table1,null,val);
        return 1;



    }
    public int UpdateNotes(String id,String note, String type, String date){

        SQLiteDatabase db=getWritableDatabase();
        ContentValues val=new ContentValues();

        val.put(notesMaster.Notes.col1,note);
        val.put(notesMaster.Notes.col2,type);
        val.put(notesMaster.Notes.col3,date);

        long newrowID = db.update(notesMaster.Notes.table1,val,"_id=?",new String[]{id});
        return 1;



    }


    public String[] displayNotesImportant(){

        String[] arr;
        SQLiteDatabase db=getReadableDatabase();

        Cursor cursor=db.rawQuery("select _id,note ,type,date from Notes where type='Important' ",null);
        int y=cursor.getCount();
        String id[]=new String[y];
        String note[]=new String[y];
        String type[]=new String[y];
        String date[]=new String[y];
        arr=new String[y];
        int i=0;
        while(cursor.moveToNext()){
            id[i]=cursor.getString(0);
            note[i]=cursor.getString(1);
            System.out.print("\noutput\t"+cursor.getString(1));
            type[i]=cursor.getString(2);
            date[i]=cursor.getString(3);

            arr[i]=id[i]+"   "+note[i]+"   "+type[i]+"   "+date[i];
            i++;
        }
        return arr;

    }
    public String[] displayNotesToDo(){

        String[] arr;
        SQLiteDatabase db=getReadableDatabase();

        Cursor cursor=db.rawQuery("select note ,type,date from Notes where type='To-do' ",null);
        int y=cursor.getCount();
        String note[]=new String[y];
        String type[]=new String[y];
        String date[]=new String[y];
        arr=new String[y];
        int i=0;
        while(cursor.moveToNext()){
            note[i]=cursor.getString(0);
            System.out.print("\noutput\t"+cursor.getString(1));
            type[i]=cursor.getString(1);
            date[i]=cursor.getString(2);

            arr[i]=note[i]+"   "+type[i]+"   "+date[i];
            i++;
        }
        return arr;

    }

}
