package com.example.appgym;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class conexionSQLlite extends SQLiteOpenHelper {

    final String TBL_PECHO = "CREATE TABLE if not EXISTS PECHO(" +
            "id varchar(40)," +
            "pressPlanoMaquina varchar(40)," +
            "pressInclinado varchar(40)," +
            "contractora varchar(40)," +
            "flexiones varchar(40))";
    final String TBL_BICEPS = "CREATE TABLE if not EXISTS BICEPS(" +
            "id varchar(40)," +
            "CurlAlternoPie varchar(40)," +
            "CurlInvertido varchar(40))";

    final String TBL_FEMORAL = "CREATE TABLE if not EXISTS FEMORAL(" +
            "id varchar(40)," +
            "FemoralTumbado varchar(40))";

    final String TBL_ADUCTORES = "CREATE TABLE if not EXISTS ADUCTORES(" +
            "id varchar(40)," +
            "Aductores varchar(40))";

    final String TBL_GEMELO = "CREATE TABLE if not EXISTS GEMELO(" +
            "id varchar(40)," +
            "GemeloEnPrensa varchar(40)," +
            "GemeloUnaPierna varchar(40))";

    final String TBL_HOMBRO = "CREATE TABLE if not EXISTS HOMBRO(" +
            "id varchar(40)," +
            "ElevacionesLatMancuernas varchar(40)," +
            "Pajaro varchar(40)," +
            "PressMaquina varchar(40)," +
            "LateralesSentado varchar(40)," +
            "LateralesPolea varchar(40))";

    final String TBL_TRAPECIO = "CREATE TABLE if not EXISTS TRAPECIO(" +
            "id varchar(40)," +
            "EncogimientoPesado varchar(40))";

    final String TBL_TRICEPS = "CREATE TABLE if not EXISTS TRICEPS(" +
            "id varchar(40)," +
            "PressFrancesTumbado varchar(40)," +
            "PressFrancesSentado varchar(40)," +
            "TironPoleaEncimaDeLaCabeza varchar(40))";

    final String TBL_PIERNA= "CREATE TABLE if not EXISTS PIERNA(" +
            "id varchar(40)," +
            "ExtensionCuádriceps varchar(40)," +
            "Prensa varchar(40)," +
            "PrensaUnaPierna varchar(40))";

    final String TBL_ESPALDA = "CREATE TABLE if not EXISTS ESPALDA(" +
            "id varchar(40)," +
            "PullOver varchar(40)," +
            "RackPull varchar(40)," +
            "JalonPecho varchar(40)," +
            "RemoBarra varchar(40)," +
            "RemoT varchar(40))";


    public conexionSQLlite(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TBL_PECHO);
        db.execSQL(TBL_BICEPS);
        db.execSQL(TBL_FEMORAL);
        db.execSQL(TBL_ADUCTORES);
        db.execSQL(TBL_GEMELO);
        db.execSQL(TBL_HOMBRO);
        db.execSQL(TBL_TRAPECIO);
        db.execSQL(TBL_TRICEPS);
        db.execSQL(TBL_PIERNA);
        db.execSQL(TBL_ESPALDA);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
