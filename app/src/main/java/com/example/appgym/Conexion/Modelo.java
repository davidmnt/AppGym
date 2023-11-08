package com.example.appgym.Conexion;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.appgym.Conexion.conexionSQLlite;
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

import java.util.Calendar;

public class Modelo {

    Calendar calen = Calendar.getInstance();
    int mes = calen.get(Calendar.MONTH)+1;
    int dia = calen.get(Calendar.DAY_OF_MONTH);

    String fecha = mes + "/" + dia;

    SQLiteDatabase getConn(Context context) {
        conexionSQLlite conn = new conexionSQLlite(context, "pesos", null, 1);
        SQLiteDatabase db = conn.getWritableDatabase();
        return db;
    }

    public int insertaPesoPecho(Context context, PechoO p) {
        int res = 0;
        String sql = null;


        if(!p.getPressPlanoMaquina().isEmpty() && !p.getPressInclinado().isEmpty() && !p.getContractora().isEmpty() && !p.getFlexiones().isEmpty()) {

            sql = "INSERT INTO PECHO (id,pressPlanoMaquina,pressInclinado,contractora,flexiones) VALUES ('" + fecha + "','" + p.getPressPlanoMaquina() + "','" + p.getPressInclinado() + "'," +
                    "'" + p.getContractora() + "','" + p.getFlexiones() + "')";

        }else if(!p.getPressPlanoMaquina().isEmpty() && !p.getPressInclinado().isEmpty() && !p.getContractora().isEmpty() && p.getFlexiones().isEmpty()) {

            sql = "INSERT INTO PECHO (id,pressPlanoMaquina,pressInclinado,contractora) VALUES ('" + fecha + "','" + p.getPressPlanoMaquina() + "','" + p.getPressInclinado() + "'," +
                    "'" + p.getContractora() + "')";

        }else if(!p.getPressPlanoMaquina().isEmpty() && !p.getPressInclinado().isEmpty() && p.getContractora().isEmpty() && p.getFlexiones().isEmpty()) {

            sql = "INSERT INTO PECHO (id,pressPlanoMaquina,pressInclinado) VALUES ('" + fecha + "','" + p.getPressPlanoMaquina() + "','" + p.getPressInclinado() + "')";

        }else if(!p.getPressPlanoMaquina().isEmpty() && p.getPressInclinado().isEmpty() && p.getContractora().isEmpty() && p.getFlexiones().isEmpty()) {

            sql = "INSERT INTO PECHO (id,pressPlanoMaquina) VALUES ('" + fecha + "','" + p.getPressPlanoMaquina() + "')";
        }

        SQLiteDatabase db = this.getConn(context);

        try {
            db.execSQL(sql);
            res = 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    public int insertaPesoEspalda(Context context, EspaldaO e) {
        int res = 0;
        String sql = null;
        if(!e.getPullOver().isEmpty() && !e.getRackPull().isEmpty() && !e.getJalonPecho().isEmpty() && !e.getRemoBarra().isEmpty() && !e.getRemoT().isEmpty()) {
             sql = "INSERT INTO ESPALDA (id,PullOver,RackPull,JalonPecho,RemoBarra,RemoT) VALUES ('" + fecha + "','" + e.getPullOver() + "','" + e.getRackPull() + "'," +
                    "'" + e.getJalonPecho() + "','" + e.getRemoBarra() + "','" + e.getRemoT() + "')";

        }else if(!e.getPullOver().isEmpty() && !e.getRackPull().isEmpty() && !e.getJalonPecho().isEmpty() && !e.getRemoBarra().isEmpty() && e.getRemoT().isEmpty()) {
            sql = "INSERT INTO ESPALDA (id,PullOver,RackPull,JalonPecho,RemoBarra) VALUES ('" + fecha + "','" + e.getPullOver() + "','" + e.getRackPull() + "'," +
                    "'" + e.getJalonPecho() + "','" + e.getRemoBarra() + "')";

        }else if(!e.getPullOver().isEmpty() && !e.getRackPull().isEmpty() && !e.getJalonPecho().isEmpty() && e.getRemoBarra().isEmpty() && e.getRemoT().isEmpty()) {
            sql = "INSERT INTO ESPALDA (id,PullOver,RackPull,JalonPecho) VALUES ('" + fecha + "','" + e.getPullOver() + "','" + e.getRackPull() + "'," +
                    "'" + e.getJalonPecho() + "')";
        }
        else if(!e.getPullOver().isEmpty() && !e.getRackPull().isEmpty() && e.getJalonPecho().isEmpty() && e.getRemoBarra().isEmpty() && e.getRemoT().isEmpty()) {
            sql = "INSERT INTO ESPALDA (id,PullOver,RackPull) VALUES ('" + fecha + "','" + e.getPullOver() + "','" + e.getRackPull() + "')";
        }
        else if(!e.getPullOver().isEmpty() && e.getRackPull().isEmpty() && e.getJalonPecho().isEmpty() && e.getRemoBarra().isEmpty() && e.getRemoT().isEmpty()) {
            sql = "INSERT INTO ESPALDA (id,PullOver) VALUES ('" + fecha + "','" + e.getPullOver() + "')";
        }

        SQLiteDatabase db = this.getConn(context);

        try {
            db.execSQL(sql);
            res = 1;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return res;
    }

    public int insertaPesoPierna(Context context, PiernaO p) {
        int res = 0;
        String sql = null;

        if(!p.getExtensionCuádriceps().isEmpty() && !p.getHackSquad().isEmpty() && !p.getPrensa().isEmpty() && !p.getPrensaUnaPierna().isEmpty()) {
            sql = "INSERT INTO PIERNA (id,ExtensionCuádriceps,HackSquad,Prensa,PrensaUnaPierna) VALUES ('" + fecha + "','" + p.getExtensionCuádriceps() + "','" + p.getHackSquad() + "','" + p.getPrensa() + "'," +
                    "'" + p.getPrensaUnaPierna() + "')";
        }

        else if(!p.getExtensionCuádriceps().isEmpty()  && !p.getHackSquad().isEmpty() && !p.getPrensa().isEmpty() && p.getPrensaUnaPierna().isEmpty()) {
            sql = "INSERT INTO PIERNA (id,ExtensionCuádriceps,HackSquad,Prensa) VALUES ('" + fecha + "','" + p.getExtensionCuádriceps() + "','" + p.getHackSquad() + "','" + p.getPrensa() + "')";
        }

        else if(!p.getExtensionCuádriceps().isEmpty()  && !p.getHackSquad().isEmpty() && p.getPrensa().isEmpty() && !p.getPrensaUnaPierna().isEmpty()) {
            sql = "INSERT INTO PIERNA (id,ExtensionCuádriceps,HackSquad,PrensaUnaPierna) VALUES ('" + fecha + "','" + p.getExtensionCuádriceps() + "','" + p.getHackSquad() + "','" + p.getPrensaUnaPierna() + "')";
        }

        else if(!p.getExtensionCuádriceps().isEmpty()  && !p.getHackSquad().isEmpty() && p.getPrensa().isEmpty() && p.getPrensaUnaPierna().isEmpty()) {
            sql = "INSERT INTO PIERNA (id,ExtensionCuádriceps,HackSquad) VALUES ('" + fecha + "','" + p.getExtensionCuádriceps() + "','" + p.getHackSquad() + "')";
        }

        else if(!p.getExtensionCuádriceps().isEmpty()  && p.getHackSquad().isEmpty() && !p.getPrensa().isEmpty() && p.getPrensaUnaPierna().isEmpty()) {
            sql = "INSERT INTO PIERNA (id,ExtensionCuádriceps,Prensa) VALUES ('" + fecha + "','" + p.getExtensionCuádriceps() + "','" + p.getPrensa() + "')";
        }

        else if(!p.getExtensionCuádriceps().isEmpty()  && p.getHackSquad().isEmpty() && p.getPrensa().isEmpty() && !p.getPrensaUnaPierna().isEmpty()) {
            sql = "INSERT INTO PIERNA (id,ExtensionCuádriceps,PrensaUnaPierna) VALUES ('" + fecha + "','" + p.getExtensionCuádriceps() + "','" + p.getPrensaUnaPierna()  + "')";
        }

        else if(!p.getExtensionCuádriceps().isEmpty() && p.getPrensa().isEmpty() && p.getPrensaUnaPierna().isEmpty()) {
            sql = "INSERT INTO PIERNA (id,ExtensionCuádriceps) VALUES ('" + fecha + "','" + p.getExtensionCuádriceps() + "')";
        }

        SQLiteDatabase db = this.getConn(context);

        try {
            db.execSQL(sql);
            res = 1;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return res;
    }

    public int insertaPesoAductores(Context context, AductoresO ad) {
        int res = 0;

        String sql = "INSERT INTO ADUCTORES (id,Aductores) VALUES ('" + fecha + "','" + ad.getAductores() + "')";
        SQLiteDatabase db = this.getConn(context);

        try {
            db.execSQL(sql);
            res = 1;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return res;
    }

    public int insertaPesoGemelo(Context context, GemeloO g) {
        int res = 0;
        String sql = null;
        if(!g.getGemeloEnPrensa().isEmpty() && !g.getGemeloUnaPierna().isEmpty()) {
            sql = "INSERT INTO GEMELO (id,GemeloEnPrensa,GemeloUnaPierna) VALUES ('" + fecha + "','" + g.getGemeloEnPrensa() + "','" + g.getGemeloUnaPierna() + "')";
        }
        else if(!g.getGemeloEnPrensa().isEmpty() && g.getGemeloUnaPierna().isEmpty()) {
            sql = "INSERT INTO GEMELO (id,GemeloEnPrensa) VALUES ('" + fecha + "','" + g.getGemeloEnPrensa() + "')";
        }

        SQLiteDatabase db = this.getConn(context);

        try {
            db.execSQL(sql);
            res = 1;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return res;
    }

    public int insertaPesoFemoral(Context context, FemoralO f) {
        int res = 0;

        String sql = "INSERT INTO FEMORAL (id,FemoralTumbado) VALUES ('" + fecha + "','" + f.getFemoralTumbado() + "')";
        SQLiteDatabase db = this.getConn(context);

        try {
            db.execSQL(sql);
            res = 1;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return res;
    }

    public int insertaPesoHombro(Context context, HombroO h) {
        int res = 0;
        String sql = null;
        if(h.getElevacionesLatMancuernas().isEmpty() && !h.getPajaro().isEmpty() && !h.getPressMaquina().isEmpty() && !h.getLateralesSentado().isEmpty() && !h.getLateralesPolea().isEmpty()) {
            sql = "INSERT INTO HOMBRO (id,ElevacionesLatMancuernas,Pajaro,PressMaquina,LateralesSentado,LateralesPolea) VALUES ('" + fecha + "','" + h.getElevacionesLatMancuernas() + "','" + h.getPajaro() + "'," +
                    "'" + h.getPressMaquina() + "','" + h.getLateralesSentado() + "','" + h.getLateralesPolea() + "')";
        }
        else if(h.getElevacionesLatMancuernas().isEmpty() && !h.getPajaro().isEmpty() && !h.getPressMaquina().isEmpty() && !h.getLateralesSentado().isEmpty() && h.getLateralesPolea().isEmpty()) {
            sql = "INSERT INTO HOMBRO (id,ElevacionesLatMancuernas,Pajaro,PressMaquina,LateralesSentado) VALUES ('" + fecha + "','" + h.getElevacionesLatMancuernas() + "','" + h.getPajaro() + "'," +
                    "'" + h.getPressMaquina() + "','" + h.getLateralesSentado() + "')";
        }
        else if(h.getElevacionesLatMancuernas().isEmpty() && !h.getPajaro().isEmpty() && !h.getPressMaquina().isEmpty() && h.getLateralesSentado().isEmpty() && h.getLateralesPolea().isEmpty()) {
            sql = "INSERT INTO HOMBRO (id,ElevacionesLatMancuernas,Pajaro,PressMaquina) VALUES ('" + fecha + "','" + h.getElevacionesLatMancuernas() + "','" + h.getPajaro() + "'," +
                    "'" + h.getPressMaquina() + "')";
        }
        else if(h.getElevacionesLatMancuernas().isEmpty() && !h.getPajaro().isEmpty() && h.getPressMaquina().isEmpty() && h.getLateralesSentado().isEmpty() && h.getLateralesPolea().isEmpty()) {
            sql = "INSERT INTO HOMBRO (id,ElevacionesLatMancuernas,Pajaro) VALUES ('" + fecha + "','" + h.getElevacionesLatMancuernas() + "','" + h.getPajaro() + "')";
        }
        else if(h.getElevacionesLatMancuernas().isEmpty() && h.getPajaro().isEmpty() && h.getPressMaquina().isEmpty() && h.getLateralesSentado().isEmpty() && h.getLateralesPolea().isEmpty()) {
            sql = "INSERT INTO HOMBRO (id,ElevacionesLatMancuernas) VALUES ('" + fecha + "','" + h.getElevacionesLatMancuernas() + "')";
        }
        SQLiteDatabase db = this.getConn(context);

        try {
            db.execSQL(sql);
            res = 1;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return res;
    }

    public int insertaPesoTrapecio(Context context, TrapecioO t) {
        int res = 0;

        String sql = "INSERT INTO TRAPECIO (id,EncogimientoPesado) VALUES ('" + fecha + "','" + t.getEncogimientoPesado() + "')";
        SQLiteDatabase db = this.getConn(context);

        try {
            db.execSQL(sql);
            res = 1;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return res;
    }

    public int insertaPesoTriceps(Context context, TricepsO tr) {
        int res = 0;
        String sql = null;

        if(!tr.getPressFrancesTumbado().isEmpty() && !tr.getPressFrancesSentado().isEmpty() && !tr.getTironPoleaEncimaDeLaCabeza().isEmpty()) {
            sql = "INSERT INTO TRICEPS (id,PressFrancesTumbado,PressFrancesSentado,TironPoleaEncimaDeLaCabeza) VALUES ('" + fecha + "','" + tr.getPressFrancesTumbado() + "'," +
                    "'" + tr.getPressFrancesSentado() + "','" + tr.getTironPoleaEncimaDeLaCabeza() + "')";
        }
        else if(!tr.getPressFrancesTumbado().isEmpty() && !tr.getPressFrancesSentado().isEmpty() && tr.getTironPoleaEncimaDeLaCabeza().isEmpty()) {
            sql = "INSERT INTO TRICEPS (id,PressFrancesTumbado,PressFrancesSentado) VALUES ('" + fecha + "','" + tr.getPressFrancesTumbado() + "'," +
                    "'" + tr.getPressFrancesSentado() + "')";
        }
        else if(!tr.getPressFrancesTumbado().isEmpty() && tr.getPressFrancesSentado().isEmpty() && tr.getTironPoleaEncimaDeLaCabeza().isEmpty()) {
            sql = "INSERT INTO TRICEPS (id,PressFrancesTumbado) VALUES ('" + fecha + "','" + tr.getPressFrancesTumbado() + "')";
        }

        SQLiteDatabase db = this.getConn(context);

        try {
            db.execSQL(sql);
            res = 1;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return res;
    }

    public int insertaPesoBiceps(Context context, BicepsO b) {
        int res = 0;
        String sql = null;

        if(!b.getCurlAlternoPie().isEmpty() && !b.getCurlInvertido().isEmpty()) {
            sql = "INSERT INTO BICEPS (id,CurlAlternoPie,CurlInvertido) VALUES ('" + fecha + "','" + b.getCurlAlternoPie() + "'," +
                    "'" + b.getCurlInvertido() + "')";
        }
       else if(!b.getCurlAlternoPie().isEmpty() && b.getCurlInvertido().isEmpty()) {
            sql = "INSERT INTO BICEPS (id,CurlAlternoPie) VALUES ('" + fecha + "','" + b.getCurlAlternoPie() + "')";
        }

        SQLiteDatabase db = this.getConn(context);

        try {
            db.execSQL(sql);
            res = 1;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return res;
    }


}
