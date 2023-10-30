package com.example.appgym;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.appgym.Objetos.AductoresO;
import com.example.appgym.Objetos.BicepsO;
import com.example.appgym.Objetos.EspaldaO;
import com.example.appgym.Objetos.FemoralO;
import com.example.appgym.Objetos.GemeloO;
import com.example.appgym.Objetos.HombroO;
import com.example.appgym.Objetos.PechoO;
import com.example.appgym.Objetos.PiernaO;
import com.example.appgym.Objetos.TrapecioO;
import com.example.appgym.Objetos.TricepsO;

import java.util.Date;

public class Modelo {

    Date fecha = new Date();

    SQLiteDatabase getConn(Context context){
    conexionSQLlite conn = new conexionSQLlite(context, "pesos", null, 1);
    SQLiteDatabase db = conn.getWritableDatabase();
    return db;
    }

    int insertaPesoPecho(Context context, PechoO p){
        int res=0;

        String sql = "INSERT INTO PECHO (id,pressPlanoMaquina,pressInclinado,contractora,flexiones) VALUES ('"+fecha+"','"+p.getPressPlanoMaquina()+"','"+p.getPressInclinado()+"'," +
                "'"+p.getContractora()+"','"+p.getFlexiones()+"')";
        SQLiteDatabase db = this.getConn(context);

        try {
            db.execSQL(sql);
            res = 1;
        }catch (Exception e){
            e.printStackTrace();
        }
        return res;
    }

    int insertaPesoEspalda(Context context, EspaldaO e){
        int res=0;

        String sql = "INSERT INTO ESPALDA (id,PullOver,RackPull,JalonPecho,RemoBarra,RemoT) VALUES ('"+fecha+"','"+e.getPullOver()+"','"+e.getRackPull()+"'," +
                "'"+e.getJalonPecho()+"','"+e.getRemoBarra()+"','"+e.getRemoT()+"')";
        SQLiteDatabase db = this.getConn(context);

        try {
            db.execSQL(sql);
            res = 1;
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return res;
    }

    int insertaPesoPierna(Context context, PiernaO p){
        int res=0;

        String sql = "INSERT INTO PIERNA (id,ExtensionCuádriceps,Prensa,PrensaUnaPierna) VALUES ('"+fecha+"','"+p.getExtensionCuádriceps()+"','"+p.getPrensa()+"'," +
                "'"+p.getPrensaUnaPierna()+"')";
        SQLiteDatabase db = this.getConn(context);

        try {
            db.execSQL(sql);
            res = 1;
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return res;
    }

    int insertaPesoAductores(Context context, AductoresO ad){
        int res=0;

        String sql = "INSERT INTO ADUCTORES (id,Aductores) VALUES ('"+fecha+"','"+ad.getAductores()+"')";
        SQLiteDatabase db = this.getConn(context);

        try {
            db.execSQL(sql);
            res = 1;
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return res;
    }

    int insertaPesoGemelo(Context context, GemeloO g){
        int res=0;

        String sql = "INSERT INTO GEMELO (id,GemeloEnPrensa,GemeloUnaPierna) VALUES ('"+fecha+"','"+g.getGemeloEnPrensa()+"','"+g.getGemeloUnaPierna()+"')";
        SQLiteDatabase db = this.getConn(context);

        try {
            db.execSQL(sql);
            res = 1;
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return res;
    }
    int insertaPesoFemoral(Context context, FemoralO f){
        int res=0;

        String sql = "INSERT INTO FEMORAL (id,FemoralTumbado) VALUES ('"+fecha+"','"+f.getFemoralTumbado()+"')";
        SQLiteDatabase db = this.getConn(context);

        try {
            db.execSQL(sql);
            res = 1;
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return res;
    }

    int insertaPesoHombro(Context context, HombroO h){
        int res=0;

        String sql = "INSERT INTO HOMBRO (id,ElevacionesLatMancuernas,Pajaro,PressMaquina,LateralesSentado,LateralesPolea) VALUES ('"+fecha+"','"+h.getElevacionesLatMancuernas()+"','"+h.getPajaro()+"'," +
                "'"+h.getPressMaquina()+"','"+h.getLateralesSentado()+"','"+h.getLateralesPolea()+"')";
        SQLiteDatabase db = this.getConn(context);

        try {
            db.execSQL(sql);
            res = 1;
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return res;
    }

    int insertaPesoTrapecio(Context context, TrapecioO t){
        int res=0;

        String sql = "INSERT INTO TRAPECIO (id,EncogimientoPesado) VALUES ('"+fecha+"','"+t.getEncogimientoPesado()+"')";
        SQLiteDatabase db = this.getConn(context);

        try {
            db.execSQL(sql);
            res = 1;
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return res;
    }

    int insertaPesoTriceps(Context context, TricepsO tr){
        int res=0;

        String sql = "INSERT INTO TRICEPS (id,PressFrancesTumbado,PressFrancesSentado,TironPoleaEncimaDeLaCabeza) VALUES ('"+fecha+"','"+tr.getPressFrancesTumbado()+"'," +
                "'"+tr.getPressFrancesSentado()+"','"+tr.getTironPoleaEncimaDeLaCabeza()+"')";
        SQLiteDatabase db = this.getConn(context);

        try {
            db.execSQL(sql);
            res = 1;
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return res;
    }

    int insertaPesoBiceps(Context context, BicepsO b){
        int res=0;

        String sql = "INSERT INTO BICEPS (id,CurlAlternoPie,CurlInvertido) VALUES ('"+fecha+"','"+b.getCurlAlternoPie()+"'," +
                "'"+b.getCurlInvertido()+"')";
        SQLiteDatabase db = this.getConn(context);

        try {
            db.execSQL(sql);
            res = 1;
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return res;
    }





}
