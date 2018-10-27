package act3.app.com.evidencia1act4_android.Models;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

import act3.app.com.evidencia1act4_android.database.dbCurp;
import act3.app.com.evidencia1act4_android.database.dbCurpHelper;


public class Cliente_CURP implements Parcelable {
    private String codigo;
    private String apellidop;
    private String apellidom;
    private String nombre;
    private String sexo;
    private String fechanD;
    private String fechanM;
    private String fechanA;
    private String entidadf;

    public Cliente_CURP(String codigo, String apellidop, String apellidom, String nombre, String sexo, String fechanD, String fechanM, String fechanA, String entidadf){
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

    public String getFechanD() {
        return fechanD;
    }

    public String getFechanM() {
        return fechanM;
    }

    public String getFechanA() {
        return fechanA;
    }

    public String getEntidadf() {
        return entidadf;
    }

    protected Cliente_CURP(Parcel in) {
        codigo = in.readString();
        apellidop = in.readString();
        apellidom = in.readString();
        nombre = in.readString();
        sexo = in.readString();
        fechanD = in.readString();
        fechanM = in.readString();
        fechanA = in.readString();
        entidadf = in.readString();
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
        dest.writeString(fechanD);
        dest.writeString(fechanM);
        dest.writeString(fechanA);
        dest.writeString(entidadf);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Cliente_CURP> CREATOR = new Parcelable.Creator<Cliente_CURP>() {
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
        public static ArrayList<CURP> getCurps(Context context){
            String[] args = {};
            return getCurps(context, "", args, dbCurp.CreateCURP._ID + "ASC");
        }
        public static ArrayList<CURP> getCurps(Context context, String selection, String[] selectionArgs){
            return getCurps(context, selection, selectionArgs, dbCurp.CreateCURP._ID + "ASC");
        }
        public static ArrayList<CURP> getCurps(Context context, String selection, String[] selectionArgs, String sortOrder){
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
            Cursor cursor = database.query(
                    dbCurp.CreateCURP.TABLE_NAME,
                    projection,
                    selection,
                    selectionArgs,
                    null,
                    null,
                    sortOrder
            );
            ArrayList<CURP> items = new ArrayList<>();
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

                CURP curp = new CURP(curp_nombre, curp_apellidop, curp_apellidom, curp_sexo, curp_fechad, curp_fecham, curp_fechaa, curp_entidadf, curp_ID);
                items.add(curp);
            }
            cursor.close();
            return items;

        }
    }

}
