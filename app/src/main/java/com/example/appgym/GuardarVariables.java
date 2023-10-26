package com.example.appgym;


import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOError;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class GuardarVariables {
    public static void guardar() {


        EntrenamientoActivity e = new EntrenamientoActivity();
        PechoO dia17_04_2023 = new PechoO(e.PressPlanoMaquina, e.PressInclinado, e.Contractora, e.Flexiones);
















        /*File f = new File("FicheroPesos");
        try {

            f.createNewFile();

            FileOutputStream fs = new FileOutputStream(f);
            ObjectOutputStream os = new ObjectOutputStream(fs);

            os.writeObject(dia17_04_2023);

            os.close();
            fs.close();

            Log.e("Comprobacion de fichero","El fichero a sido completado correctamente");
        } catch (IOException ex) {
            System.out.println("Error al introducir");
            ex.printStackTrace();
        }*/



    }

}
