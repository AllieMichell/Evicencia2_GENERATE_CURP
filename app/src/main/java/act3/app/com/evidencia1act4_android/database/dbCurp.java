package act3.app.com.evidencia1act4_android.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

public final class dbCurp{
    public static final String SQL_CREATE_DB =
            "CREATE TABLE" + CreateCURP.TABLE_NAME +" (" +
                    CreateCURP._ID + "Primary key, " +
                    CreateCURP.COLUMN_PERSONA_NOMBRE + "TEXT, " +
                    CreateCURP.COLUMN_PERSONA_APELLIDOP + "TEXT, " +
                    CreateCURP.COLUMN_PERSONA_APELLIDOM + "TEXT, " +
                    CreateCURP.COLUMN_PERSONA_SEXO + "TEXT, " +
                    CreateCURP.COLUMN_PERSONA_FECHAD + "INTEGER, " +
                    CreateCURP.COLUMN_PERSONA_FECHAM + "INTEGER, " +
                    CreateCURP.COLUMN_PERSONA_FECHAA + "INTEGER, " +
                    CreateCURP.COLUMN_PERSONA_ENTIDADF + "TEXT";

    public static final String SQL_DELETE_DB =
            "En dado caso que exista eliminar" + CreateCURP.TABLE_NAME;

    private dbCurp()
    {

    }
    public static class CreateCURP implements BaseColumns {
        public static final String TABLE_NAME = "CURPS";
        public static final String COLUMN_PERSONA_NOMBRE = "nombre";
        public static final String COLUMN_PERSONA_APELLIDOP = "apellidop";
        public static final String COLUMN_PERSONA_APELLIDOM = "apellidom";
        public static final String COLUMN_PERSONA_SEXO = "sexo";
        public static final String COLUMN_PERSONA_FECHAD = "fechad";
        public static final String COLUMN_PERSONA_FECHAM = "fecham";
        public static final String COLUMN_PERSONA_FECHAA = "fechaa";
        public static final String COLUMN_PERSONA_ENTIDADF = "entidadf";
    }

}
