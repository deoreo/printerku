package id.enlight.printerku.Database;

/**
 * Created by ModelUser on 8/3/2015.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.Collections;

public class DatabaseHandler extends SQLiteOpenHelper {

    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 6;
    // Database Name
    private static final String DATABASE_NAME = "db_printerku";
    // ModelUser table name
    private static final String T_USER = "t_user";
    private static final String T_ALAMAT = "t_alamat";
    private static final String T_MESSAGE = "t_message";

    private static final String KEY_USER_ID = "id_user";
    private static final String KEY_USER_NAME = "name_user";
    private static final String KEY_TRUSTED = "trusted_user";
    private static final String KEY_USER_PHONE = "phone_user";
    private static final String KEY_USER_EMAIL = "email_user";

    private static final String KEY_ALAMAT_ID = "id_alamat";
    private static final String KEY_ALAMAT_NAME = "name_alamat";
    private static final String KEY_ALAMAT_DETAIL = "detail_alamat";

    private static final String KEY_MESSAGE_ID = "id_message";
    private static final String KEY_MESSAGE_NAME = "name_message";
    private static final String KEY_MESSAGE_DATE = "date_message";



    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_TABLE_USER = "CREATE TABLE " + T_USER + "("
                + KEY_USER_ID + " TEXT PRIMARY KEY,"
                + KEY_USER_NAME + " TEXT,"
                + KEY_USER_PHONE + " TEXT,"
                + KEY_USER_EMAIL + " TEXT,"
                + KEY_TRUSTED + " TEXT"
                + ")";

        String CREATE_TABLE_ALAMAT = "CREATE TABLE " + T_ALAMAT + "("
                + KEY_ALAMAT_ID + " TEXT PRIMARY KEY,"
                + KEY_ALAMAT_NAME + " TEXT,"
                + KEY_ALAMAT_DETAIL + " TEXT"
                + ")";

        String CREATE_TABLE_MESSAGE = "CREATE TABLE " + T_MESSAGE + "("
                + KEY_MESSAGE_ID + " TEXT PRIMARY KEY,"
                + KEY_MESSAGE_NAME + " TEXT,"
                + KEY_MESSAGE_DATE + " TEXT"
                + ")";


        db.execSQL(CREATE_TABLE_USER);
        db.execSQL(CREATE_TABLE_ALAMAT);
        db.execSQL(CREATE_TABLE_MESSAGE);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + T_USER);
        db.execSQL("DROP TABLE IF EXISTS " + T_ALAMAT);
        db.execSQL("DROP TABLE IF EXISTS " + T_MESSAGE);
        // Create tables again
        onCreate(db);
    }

    /**
     * All CRUD(Create, Read, Update, Delete) Operations
     */



}
