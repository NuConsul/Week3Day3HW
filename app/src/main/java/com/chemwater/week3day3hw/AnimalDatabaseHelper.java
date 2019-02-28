package com.chemwater.week3day3hw;

import android.content.ContentValues ;
import android.content.Context ;
import android.database.Cursor ;
import android.database.sqlite.SQLiteDatabase ;
import android.database.sqlite.SQLiteOpenHelper ;
import android.support.annotation.NonNull ;
import android.support.annotation.Nullable ;

import java.util.ArrayList ;
import java.util.Locale ;

import static com.chemwater.week3day3hw.AnimalDatabaseContract.COLUMN_ID;
import static com.chemwater.week3day3hw.AnimalDatabaseContract.COLUMN_NAME;
import static com.chemwater.week3day3hw.AnimalDatabaseContract.COLUMN_SOUND;
import static com.chemwater.week3day3hw.AnimalDatabaseContract.COLUMN_TYPE;
import static com.chemwater.week3day3hw.AnimalDatabaseContract.DATABASE_NAME;
import static com.chemwater.week3day3hw.AnimalDatabaseContract.DATABASE_VERSION;
import static com.chemwater.week3day3hw.AnimalDatabaseContract.TABLE_NAME;
import static com.chemwater.week3day3hw.AnimalDatabaseContract.getWhereClauseById;


public class AnimalDatabaseHelper extends SQLiteOpenHelper {

    //Constructor for
    public AnimalDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION) ;
    }

    //Create the tables(will run only once per install)
    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(AnimalDatabaseContract.createQuery()) ;
    }

    //If version database changes, make adjustments here
    @Override
    public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
        onCreate(database) ;
    }

    //Insert a car into the database
    public long insertAnimalIntoDatabase(@NonNull Animals animal) {
        SQLiteDatabase writeableDatabase = this.getWritableDatabase() ;
        //Data container used for database key value pairs
        ContentValues contentValues = new ContentValues() ;

        //insert key value pairs into the contentValues container
        contentValues.put(COLUMN_TYPE, animal.getAnimalType()) ;
        contentValues.put(COLUMN_NAME, animal.getAnimalName()) ;
        contentValues.put(COLUMN_SOUND, animal.getAnimalSound()) ;

        //insert the animal into the table using contentValues
        return writeableDatabase.insert(TABLE_NAME, null, contentValues) ;
    }

    //Get all Animals from Database and return an ArrayList
    public ArrayList<Animals> getAllAnimalsFromDatabase() {
        ArrayList<Animals> returnAnimalList = new ArrayList<>() ;
        SQLiteDatabase readableDatabase = this.getReadableDatabase() ;
        //Get results from query and hold in cursor(iterable object for database operations
        Cursor cursor = readableDatabase.rawQuery(AnimalDatabaseContract.getAllAnimalsQuery(), null) ;
        //Check to see if we have any results
        if(cursor.moveToFirst()) {
            //while we have results, get the values and place in list
            do {
                //get values
                int id = cursor.getInt(cursor.getColumnIndex(COLUMN_ID)) ;
                String type = cursor.getString(cursor.getColumnIndex(COLUMN_TYPE)) ;
                String name = cursor.getString(cursor.getColumnIndex(COLUMN_NAME)) ;
                String sound = cursor.getString(cursor.getColumnIndex(COLUMN_SOUND)) ;

                //add to list
                returnAnimalList.add(new Animals(type, name, sound, id)) ;
            } while (cursor.moveToNext()) ;
            //return the result in a list
        }
        cursor.close() ;
        return returnAnimalList ;
    }

    //Get one entry from database
    public Animals getAnimalById(int id) {
        SQLiteDatabase readableDatabase = this.getReadableDatabase() ;
        //Car to return
        Animals returnAnimal = new Animals() ;
        //cursor to hold results
        Cursor cursor = readableDatabase.rawQuery(AnimalDatabaseContract.getOneAnimalById(id), null) ;
        if(cursor.moveToFirst()) {
            int idFromDB = cursor.getInt(cursor.getColumnIndex(COLUMN_ID)) ;
            String type = cursor.getString(cursor.getColumnIndex(COLUMN_TYPE)) ;
            String name = cursor.getString(cursor.getColumnIndex(COLUMN_NAME)) ;
            String sound = cursor.getString(cursor.getColumnIndex(COLUMN_SOUND)) ;

            //set return animal
            returnAnimal = new Animals(type, name, sound, idFromDB) ;
        }
        cursor.close() ;
        return returnAnimal ;
    }

    //update an item in the database
    public long updateAnimalInDatabase(@NonNull Animals newAnimalInfo) {
        SQLiteDatabase writeableDatabase = this.getWritableDatabase() ;
        //Data container used for database key value pairs
        ContentValues contentValues = new ContentValues() ;

        //insert key value pairs into the contentValues container
        contentValues.put(COLUMN_TYPE, newAnimalInfo.getAnimalType()) ;
        contentValues.put(COLUMN_NAME, newAnimalInfo.getAnimalName()) ;
        contentValues.put(COLUMN_SOUND, newAnimalInfo.getAnimalSound()) ;

        return writeableDatabase.update(TABLE_NAME,
                contentValues,
                getWhereClauseById(),
                new String[]{String.valueOf(newAnimalInfo.getAnimalId())}) ;
    }

    //delete entry(ies) from the database
    public long deleteFromDatabaseById(String[] id) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase() ;
        return sqLiteDatabase.delete(TABLE_NAME, getWhereClauseById() + id[0], null) ;
    }


}