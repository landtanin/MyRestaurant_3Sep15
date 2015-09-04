package appewtc.masterung.myrestaurant;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by masterUNG on 9/3/15 AD.
 */
public class FoodTABLE {

    //Explicit
    private MyOpenHelper objMyOpenHelper;
    private SQLiteDatabase writeSqLiteDatabase, readSqLiteDatabase;

    public static final String FOOD_TABLE = "foodTABLE";
    public static final String COLUMN_ID_FOOD = "_id";
    public static final String COLUMN_FOOD = "Food";
    public static final String COLUMN_SOURCE = "Source";
    public static final String COLUMN_PRICE = "Price";


    public FoodTABLE(Context context) {
        objMyOpenHelper = new MyOpenHelper(context);
        writeSqLiteDatabase = objMyOpenHelper.getWritableDatabase();
        readSqLiteDatabase = objMyOpenHelper.getReadableDatabase();
    }   // Constructor

    public String[] readAllFood() {

        String[] strFood = null;
        Cursor objCursor = readSqLiteDatabase.query(FOOD_TABLE,
                new String[]{COLUMN_ID_FOOD, COLUMN_FOOD},
                null, null, null, null, null);
        if (objCursor != null) {
            objCursor.moveToFirst();
            strFood = new String[objCursor.getCount()];
            for (int i = 0; i < objCursor.getCount(); i++) {
                strFood[i] = objCursor.getString(objCursor.getColumnIndex(COLUMN_FOOD));
                objCursor.moveToNext();
            }   //for
        }   // if
        objCursor.close();
        return strFood;
    }   // readAll



    public String[] readAllSource() {

        String[] strFood = null;
        Cursor objCursor = readSqLiteDatabase.query(FOOD_TABLE,
                new String[]{COLUMN_ID_FOOD, COLUMN_SOURCE},
                null, null, null, null, null);
        if (objCursor != null) {
            objCursor.moveToFirst();
            strFood = new String[objCursor.getCount()];
            for (int i = 0; i < objCursor.getCount(); i++) {
                strFood[i] = objCursor.getString(objCursor.getColumnIndex(COLUMN_SOURCE));
                objCursor.moveToNext();
            }   //for
        }   // if
        objCursor.close();
        return strFood;
    }   // readAll

    public String[] readAllPrice() {

        String[] strFood = null;
        Cursor objCursor = readSqLiteDatabase.query(FOOD_TABLE,
                new String[]{COLUMN_ID_FOOD, COLUMN_PRICE},
                null, null, null, null, null);
        if (objCursor != null) {
            objCursor.moveToFirst();
            strFood = new String[objCursor.getCount()];
            for (int i = 0; i < objCursor.getCount(); i++) {
                strFood[i] = objCursor.getString(objCursor.getColumnIndex(COLUMN_PRICE));
                objCursor.moveToNext();
            }   //for
        }   // if
        objCursor.close();
        return strFood;
    }   // readAll






    public long addFood(String strFood, String strSource, String strPrice) {

        ContentValues objContentValues = new ContentValues();
        objContentValues.put(COLUMN_FOOD, strFood);
        objContentValues.put(COLUMN_SOURCE, strSource);
        objContentValues.put(COLUMN_PRICE, strPrice);
        return writeSqLiteDatabase.insert(FOOD_TABLE, null, objContentValues);
    }

}   // Main Class
