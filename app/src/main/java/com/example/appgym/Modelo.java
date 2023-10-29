package com.example.appgym;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.appgym.Objetos.AductoresO;
import com.example.appgym.Objetos.EspaldaO;
import com.example.appgym.Objetos.GemeloO;
import com.example.appgym.Objetos.PechoO;
import com.example.appgym.Objetos.PiernaO;

public class Modelo {
    double id;
    SQLiteDatabase getConn(Context context){
    conexionSQLlite conn = new conexionSQLlite(context, "pesos", null, 1);
    SQLiteDatabase db = conn.getWritableDatabase();
    return db;
    }

    int insertaPesoPecho(Context context, PechoO p){
        int res=0;
        id++;
        String sql = "INSERT INTO PECHO (id,pressPlanoMaquina,pressInclinado,contractora,flexiones) VALUES ('"+id+"','"+p.getPressPlanoMaquina()+"','"+p.getPressInclinado()+"'," +
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
        id++;
        String sql = "INSERT INTO ESPALDA (id,PullOver,RackPull,JalonPecho,RemoBarra,RemoT) VALUES ('"+id+"','"+e.getPullOver()+"','"+e.getRackPull()+"'," +
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
        id++;
        String sql = "INSERT INTO PIERNA (id,ExtensionCuádriceps,Prensa,PrensaUnaPierna) VALUES ('"+id+"','"+p.getExtensionCuádriceps()+"','"+p.getPrensa()+"'," +
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

    int insertaPesoAductores(Context context, AductoresO a){
        int res=0;
        id++;
        String sql = "INSERT INTO ADUCTORES (id,Aductores) VALUES ('"+id+"','"+a.getAductores()+"')";
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
        id++;
        String sql = "INSERT INTO GEMELO (id,GemeloEnPrensa,GemeloUnaPierna) VALUES ('"+id+"','"+g.getGemeloEnPrensa()+"','"+g.getGemeloUnaPierna()+"')";
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
