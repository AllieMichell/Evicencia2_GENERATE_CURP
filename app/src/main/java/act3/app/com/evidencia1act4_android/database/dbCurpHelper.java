package act3.app.com.evidencia1act4_android.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class dbCurpHelper extends SQLiteOpenHelper {

    public static final int DB_VER = 1;
    public static final String DB_NAME= "Create_CURP.db";

    public dbCurpHelper(Context context) {
        super (context, DB_NAME, null, DB_VER);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(dbCurp.SQL_CREATE_DB);
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, int oldVer, int newVer){
        database.execSQL(dbCurp.SQL_DELETE_DB);
    }

    @Override
    public void onDowngrade(SQLiteDatabase database, int oldVer, int newVer) {
        onDowngrade(database, oldVer, newVer);
    }
}
