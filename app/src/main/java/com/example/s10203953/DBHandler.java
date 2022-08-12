package com.example.s10203953;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.s10203953.MainActivity.User;

import java.util.ArrayList;

public class DBHandler extends SQLiteOpenHelper{
    public static final String TABLE_USERS = "Users";
    public static final String COLUMN_NAME = "Name";
    public static final String COLUMN_DESCRIPTION = "Description";
    public static final String COLUMN_ID = "Id";
    public static final String COLUMN_FOLLOWED = "Followed";

    public DBHandler(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public void onCreate(SQLiteDatabase db) {
        String CREATE = "CREATE TABLE Users (Id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "Name STRING, Description STRING, Followed BOOLEAN)";
        db.execSQL(CREATE);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
        onCreate(db);
    }

    public void insertMessage (User user){
        SQLiteDatabase db = this.getWritableDatabase();
        String INSERT = "INSERT INTO " + TABLE_USERS + " (" + COLUMN_NAME +  ", " +
                COLUMN_DESCRIPTION + ", " + COLUMN_FOLLOWED + ") VALUES (" + "\"" + user.name + "\", "
                + "\"" + user.description + "\", " +  "\"" + user.followed + "\"" + ")";
        System.out.println(INSERT);
        db.execSQL(INSERT);
        db.close();
    }

    public ArrayList<User> getUsers(){
        SQLiteDatabase db = getWritableDatabase();
        ArrayList<User> userList = new ArrayList<>();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_USERS, null);
        while (cursor.moveToNext()){
            String name = cursor.getString((int)cursor.getColumnIndex(COLUMN_NAME));
            String description = cursor.getString((int)cursor.getColumnIndex(COLUMN_DESCRIPTION));
            Integer id = cursor.getInt((int)cursor.getColumnIndex(COLUMN_ID));
            Boolean follow = Boolean.parseBoolean(cursor.getString((int)cursor.getColumnIndex(COLUMN_FOLLOWED)));
            User newer = new User(name, description, id, follow) ;
            userList.add(newer);
        }
        return userList;
    }

    public void updateUsers(User user){
        SQLiteDatabase db = getWritableDatabase();
        Boolean updateFollow = user.followed;
        Integer refId = user.id;
        String UPDATE = "UPDATE " + TABLE_USERS + " SET " + COLUMN_FOLLOWED  + " = \"" + updateFollow + "\" WHERE " +
                COLUMN_ID + " = \"" + refId + "\"";
        db.execSQL(UPDATE);
        db.close();
    }


    public void clear(){
        SQLiteDatabase db = getWritableDatabase();
        String delete = "DELETE FROM " + TABLE_USERS;
        db.execSQL(delete);
        db.close();
    }
}
