package info.androidhive.materialtabs.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by KBPark on 2016. 8. 13..
 */
public class ListDbHelper extends SQLiteOpenHelper
{

    private static final String CREATE_TABLE = "CREATE TABLE if not exists " + BasicInfo.TABLE_NAME + "("
            + "_id integer PRIMARY KEY autoincrement, "
            + "title text, "
            + "date text"
            + ")";

    private static final String DELETE_REC = "DELETE FROM " + BasicInfo.TABLE_NAME + " WHERE _id="; // 해당 record 하나 삭제
    private static final String DELETE_ALL_REC = "DELETE FROM " + BasicInfo.TABLE_NAME; // table의 entry를 다 삭제
    private static final String DROP_TABLE = "DROP TABLE if exists " + BasicInfo.TABLE_NAME; //table 자체를 삭제


    public ListDbHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

//------------------------------------------ implement ----------------------------------------------------

    @Override
    public void onOpen(SQLiteDatabase db) {
        Log.i("test", "db open!");
        createTable(db);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        createTable(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {

    }

//------------------------------------------ 내가 정의한 메소드들 ----------------------------------------------

    public void insertRec(SQLiteDatabase db, String title, String date)
    {
        db.execSQL("INSERT INTO " + BasicInfo.TABLE_NAME + "(title, date) VALUES "
                    + "('박경배', '2011-01-01')"
                    );

        Log.i("test", "insert 완료");
    }

    public void createTable(SQLiteDatabase db)
    {
        db.execSQL(CREATE_TABLE);
        Log.i("test", "table 생성 완료");
    }


    public void deleteRec(SQLiteDatabase db, int index)
    {
        db.execSQL(DELETE_REC + index);
        // DELETE FROM [TABLE] WHERE _id=[index]

        Log.i("test", "Row 삭제 완료");
    }

    public void deleteAllRec(SQLiteDatabase db)
    {
        db.execSQL(DELETE_ALL_REC);
    }


}
