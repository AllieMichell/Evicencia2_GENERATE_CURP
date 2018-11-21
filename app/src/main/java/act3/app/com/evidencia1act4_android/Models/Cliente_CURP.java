package act3.app.com.evidencia1act4_android.Models;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Parcel;
import android.os.Parcelable;

import java.lang.reflect.Array;
import java.util.ArrayList;

import act3.app.com.evidencia1act4_android.database.dbCurp;
import act3.app.com.evidencia1act4_android.database.dbCurp.CreateCURP;
import act3.app.com.evidencia1act4_android.database.dbCurpHelper;


public class Cliente_CURP implements Parcelable {
    private long id;
    private String codigo;
    private String apellidop;
    private String apellidom;
    private String nombre;
    private String sexo;
    private int fechanD;
    private int fechanM;
    private int fechanA;
    private String entidadf;

    public Cliente_CURP(){
        this.id = 0;
        this.codigo = "";
        this.apellidop = "";
        this.apellidom = "";
        this.nombre = "";
        this.sexo = "";
        this.fechanD = 1;
        this.fechanM = 1;
        this.fechanA = 1900;
        this.entidadf = "";
    }

    public Cliente_CURP(String codigo, String apellidop, String apellidom, String nombre, String sexo, int fechanD, int fechanM, int fechanA, String entidadf){
        this.codigo = codigo;
        this.apellidop = apellidop;
        this.apellidom = apellidom;
        this.nombre = nombre;
        this.sexo = sexo;
        this.fechanD = fechanD;
        this.fechanM = fechanM;
        this.fechanA = fechanA;
        this.entidadf = entidadf;
    }

    public Cliente_CURP(String codigo, String apellidop, String apellidom, String nombre, String sexo, int fechanD, int fechanM, int fechanA, String entidadf, long id){
        this.id = id;
        this.codigo = codigo;
        this.apellidop = apellidop;
        this.apellidom = apellidom;
        this.nombre = nombre;
        this.sexo = sexo;
        this.fechanD = fechanD;
        this.fechanM = fechanM;
        this.fechanA = fechanA;
        this.entidadf = entidadf;
    }

    protected Cliente_CURP(Parcel in) {
        codigo = in.readString();
        apellidop = in.readString();
        apellidom = in.readString();
        nombre = in.readString();
        sexo = in.readString();
        fechanD = in.readInt();
        fechanM = in.readInt();
        fechanA = in.readInt();
        entidadf = in.readString();
    }

    public long detId() {return id; }

    public String getCodigo() {
        return codigo;
    }

    public String getApellidop() {
        return apellidop;
    }

    public String getApellidom() {
        return apellidom;
    }

    public String getNombre() {
        return nombre;
    }

    public String getSexo() {
        return sexo;
    }

    public int getFechanD() {
        return fechanD;
    }

    public int getFechanM() {
        return fechanM;
    }

    public int getFechanA() {
        return fechanA;
    }

    public String getEntidadf() {
        return entidadf;
    }

    public void setApellidop (String apellidop){
        this.apellidop = apellidop;
    }

    public void setApellidom (String apellidom){
        this.apellidom = apellidom;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void setFechanD(int fechanD){
        this.fechanD = fechanD;
    }

    public void setFechanM(int fechanM){
        this.fechanM = fechanM;
    }

    public void setFechanA(int fechanA){
        this.fechanA = fechanA;
    }

    public void setEntidadf(String entidadf){
        this.entidadf = entidadf;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(codigo);
        dest.writeString(apellidop);
        dest.writeString(apellidom);
        dest.writeString(nombre);
        dest.writeString(sexo);
        dest.writeInt(fechanD);
        dest.writeInt(fechanM);
        dest.writeInt(fechanA);
        dest.writeString(entidadf);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Cliente_CURP> CREATOR = new Parcelable.Creator<Cliente_CURP>() {
        public Cliente_CURP CreateFormParcel(Parcel in){
            return new Cliente_CURP(in);
        }
        @Override
        public Cliente_CURP createFromParcel(Parcel in) {
            return new Cliente_CURP(in);
        }

        @Override
        public Cliente_CURP[] newArray(int size) {
            return new Cliente_CURP[size];
        }
    };

    public String getCurp(){

        apellidop = apellidop.toUpperCase();
        apellidom = apellidom.toUpperCase();
        nombre = nombre.toUpperCase();


        //Primera Letra de apellido paterno y vocal del apellido
        char ch1 = apellidop.charAt(0);
        char ch2 = 0;
        for (int i = 1; i < apellidop.length(); i++) {
            char vocales = apellidop.charAt(i);
            if (vocales == 'A' || vocales == 'E' || vocales == 'I' || vocales == 'O' || vocales == 'U') {
                ch2 = vocales;
                break;
            }
        }
        //Primera letra de apellido materno
        char ch3 = apellidom.charAt(0);
        //Primera letra de nombre
        char ch4 = nombre.charAt(0);
        //Digitos del año nacimiento
        String anio = String.valueOf(getFechanA());
        char ch5 = anio.charAt(2);
        char ch6 = anio.charAt(3);
        //Digitos del mes de nacimiento
        String mes = String.valueOf(getFechanM());
        char ch7;
        char ch8;
        ch7 = mes.charAt(0);
        ch8 = mes.charAt(1);

        //Digito del dia de nacimiento
        String dia = String.valueOf(getFechanD());
        char ch9;
        char ch10;
        ch9 = dia.charAt(0);
        ch10 = dia.charAt(1);

        return (ch1+""+ch2+""+ch3+""+ch4+""+ch5+""+ch6+""+ch7+""+ch8+""+ch9+""+ch10);
    }

    public void saveCURP (Context context) {
        dbCurpHelper dbCurphelper = new dbCurpHelper(context);
        SQLiteDatabase database = dbCurphelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(dbCurp.CreateCURP.COLUMN_PERSONA_NOMBRE, nombre);
        values.put(dbCurp.CreateCURP.COLUMN_PERSONA_APELLIDOP, apellidop);
        values.put(dbCurp.CreateCURP.COLUMN_PERSONA_APELLIDOM, apellidom);
        values.put(dbCurp.CreateCURP.COLUMN_PERSONA_SEXO, sexo);
        values.put(dbCurp.CreateCURP.COLUMN_PERSONA_FECHAD, fechanD);
        values.put(dbCurp.CreateCURP.COLUMN_PERSONA_FECHAM, fechanM);
        values.put(dbCurp.CreateCURP.COLUMN_PERSONA_FECHAA, fechanA);
        values.put(dbCurp.CreateCURP.COLUMN_PERSONA_ENTIDADF, entidadf);

        if(this.id ==0){
            Long id = database.insert(dbCurp.CreateCURP.TABLE_NAME, dbCurp.CreateCURP._ID, values);
            this.id = id;
        }else{
            String[] selectionArgs = {
                    String.valueOf(this.id);
                    database.update(dbCurp.CreateCURP.TABLE_NAME, values, dbCurp.CreateCURP._ID + " = ? ", selectionArgs);
            }
        }
        public void save(Context context){
            SaveDatabase saveDatabase = new SaveDatabase(context);
            new SaveDatabase().execute(saveDatabase);
        }
        public static ArrayList<Cliente_CURP> getCurps(Context context){
            SelectDatabase databaseS = new SelectDatabase(context);
            ArrayList<Cliente_CURP> curps = new getCurpsDatabase().doInBackground(databaseS);
            return curps;
        }
        public static ArrayList<Cliente_CURP> getCurps(Context context, String selection, String[] selectionArgs){
            SelectDatabase databaseS = new SelectDatabase(context, selection, selectionArgs);
            ArrayList<Cliente_CURP> curps = getCurpsDatabase().doInBackground(databaseS);
            return curps;
        }
        public static ArrayList<Cliente_CURP> getCurps(Context context, String selection, String[] selectionArgs, String order)
        {
            SelectDatabase databaseS = new SelectDatabase(context, selection, selectionArgs, order);
            ArrayList<Cliente_CURP> curps = new getCurpsDatabase().doInBackground(databaseS);
            return curps;
        }

        class SaveDatabase {
            private Context context;

            public SaveDatabase(Context c){
                this.context = c;
            }

            public Context getContext(){
                return context;
            }

        }

        private static class SelectDatabase {
            private Context context;
            private  String selection;
            private String[] selectionArgs;
            private String order;

            public final String ASC = CreateCURP.COLUMN_PERSONA_NOMBRE + "ASC";
            public final String DESC = CreateCURP.COLUMN_PERSONA_NOMBRE + "DESC";

            public SelectDatabase (Context context) {
                this.context = context;
                this.selection = "";
                String[] x = {};
                this.selectionArgs = x;
                this.order = this.ASC;
            }
            public SelectDatabase(Context context, String selection, String[] selectionArgs) {
                this.context = context;
                this.selection = selection;
                this.selectionArgs = selectionArgs;
                this.order = this.ASC;
            }
            public SelectDatabase(Context context, String selection, String[] selectionArgs, String order) {
                this.context = context;
                this.selection = selection;
                this.selectionArgs = selectionArgs;
                this.order = order;
            }

            public Context getContext() {
                return context;
            }

            public String getSelection() {
                return selection;
            }

            public String[] getSelectionArgs() {
                return selectionArgs;
            }

            public String getOrder() {
                return order;
            }
        }

        private class SaveDAtabase extends AsyncTask<SaveDatabase, Void, Void> {
            @Override
            protected  Void doInBackground(SaveDatabase... saveDatabases){
                Context context = saveDatabases[0].getContext();
                dbCurpHelper dbCurphelper = new dbCurpHelper(context);
                SQLiteDatabase database =dbCurphelper.getWritableDatabase();
                ContentValues values = new ContentValues();
                Values.put
        }














            dbCurpHelper dbCurphelper = new dbCurpHelper(context);
            SQLiteDatabase database = dbCurpHelper.getWriteDatabase();

            String[] projection = {
                    dbCurp.CreateCURP._ID,
                    dbCurp.CreateCURP.COLUMN_PERSONA_NOMBRE,
                    dbCurp.CreateCURP.COLUMN_PERSONA_APELLIDOP,
                    dbCurp.CreateCURP.COLUMN_PERSONA_APELLIDOM,
                    dbCurp.CreateCURP.COLUMN_PERSONA_SEXO,
                    dbCurp.CreateCURP.COLUMN_PERSONA_FECHAD,
                    dbCurp.CreateCURP.COLUMN_PERSONA_FECHAM,
                    dbCurp.CreateCURP.COLUMN_PERSONA_FECHAA,
                    dbCurp.CreateCURP.COLUMN_PERSONA_ENTIDADF
            };
            Cursor cursor = database.qumery(
                    dbCurp.CreateCURP.TABLE_NAME,
                    projection,
                    selection,
                    selectionArgs,
                    null,
                    null,
                    sortOrder
            );
            ArrayList<Cliente_CURP> items = new ArrayList<>();
            while (cursor.moveToNext()){
                long curp_ID = cursor.getLong(cursor.getColumnIndexOrThrow(dbCurp.CreateCURP._ID));
                String curp_nombre = cursor.getString(cursor.getColumnIndexOrThrow(dbCurp.CreateCURP.COLUMN_PERSONA_NOMBRE));
                String curp_apellidop = cursor.getString(cursor.getColumnIndexOrThrow(dbCurp.CreateCURP.COLUMN_PERSONA_APELLIDOP));
                String curp_apellidom = cursor.getString(cursor.getColumnIndexOrThrow(dbCurp.CreateCURP.COLUMN_PERSONA_APELLIDOM));
                String curp_sexo = cursor.getString(cursor.getColumnIndexOrThrow(dbCurp.CreateCURP.COLUMN_PERSONA_SEXO));
                int curp_fechad = cursor.getInt(cursor.getColumnIndexOrThrow(dbCurp.CreateCURP.COLUMN_PERSONA_FECHAD));
                int curp_fecham = cursor.getInt(cursor.getColumnIndexOrThrow(dbCurp.CreateCURP.COLUMN_PERSONA_FECHAM));
                int curp_fechaa = cursor.getInt(cursor.getColumnIndexOrThrow(dbCurp.CreateCURP.COLUMN_PERSONA_FECHAA));
                String curp_entidadf = cursor.getString(cursor.getColumnIndexOrThrow(dbCurp.CreateCURP.COLUMN_PERSONA_ENTIDADF));

                Cliente_CURP curp = new Cliente_CURP(curp_nombre, curp_apellidop, curp_apellidom, curp_sexo, curp_fechad, curp_fecham, curp_fechaa, curp_entidadf, curp_ID);
                items.add(curp);
            }
            cursor.close();
            return items;

        }
    }

}
