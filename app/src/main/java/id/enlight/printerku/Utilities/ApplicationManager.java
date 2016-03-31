package id.enlight.printerku.Utilities;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.android.gms.maps.model.LatLng;
import com.google.gson.Gson;


/**
 * Created by User on 10/21/2015.
 */
public class ApplicationManager {
    private static ApplicationManager sInstance = null;

    private SharedPreferences mPref;
    private SharedPreferences.Editor mEditor;

    private static final int PRIVATE_MODE = 0;
    private static final String PREF_NAME = "PrinterkuApplication";

    private static final String KEY_REFRESH_TOKEN = "refreshToken";
    private static final String KEY_EXPIRED_ON = "expiredOn";
    private static final String KEY_USER_EMAIL = "userEmail";
    private static final String KEY_TOKEN = "token";
    private static final String KEY_ARRIVE = "isArrive";
    private static final String KEY_ACTIVITY = "activity";
    private static final String KEY_FROM = "userFrom";
    private static final String KEY_DESTINATION = "userDestination";
    private static final String KEY_DRIVER = "driverlocation";
    private static final String TAG = "ApplicationManager";
    private static final String KEY_ORDER = "order";
    private static final String KEY_TRIP = "trip";
    private static final String KEY_USER = "user";
    private static final String KEY_POS_DRIVER = "trip";
    private static final String KEY_MESSAGE = "messageinbox";
    private static final String KEY_ALAMAT = "alamat";
    private static final String KEY_WISHLIST = "wishlist";
    private Context mContext;


    public ApplicationManager(Context context){
        mContext = context;
        mPref = mContext.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        mEditor = mPref.edit();
    }

    public static ApplicationManager getInstance(Context ctx) {
        if (sInstance == null)
            sInstance = new ApplicationManager(ctx);
        return sInstance;
    }




}
