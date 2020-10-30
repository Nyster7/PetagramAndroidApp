package com.facundogonzalez.petagramapp.modelo;

import android.content.ContentValues;
import android.content.Context;

import com.facundogonzalez.petagramapp.R;
import com.facundogonzalez.petagramapp.db.BaseDatos;
import com.facundogonzalez.petagramapp.db.ConstantesBaseDatos;

import java.util.ArrayList;

public class ConstructorMascotas {

    private static final int LIKE = 1;
    private Context context;
    private ArrayList<Mascota> mascotas;

    public ConstructorMascotas(Context context) {
        this.context = context;
    }

    public ArrayList<Mascota> obtenerDatos(){

        ArrayList<Mascota> mascotas = new ArrayList<>();
            mascotas.add(new Mascota(R.drawable.diana,"Diana",0));
            mascotas.add(new Mascota(R.drawable.luna,"Luna",0));
            mascotas.add(new Mascota(R.drawable.yoda,"Yoda",0));
            mascotas.add(new Mascota(R.drawable.tucky,"Tucky",0));
            mascotas.add(new Mascota(R.drawable.simon,"Simon",0));


        BaseDatos db = new BaseDatos(context);
        insertarTresMascotas(db);
        //return db.obtenerTodasMacotas();
        return mascotas;

    }

    public void insertarTresMascotas(BaseDatos db){

        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLA_MASCOTAS_NOMBRE,"Diana");
        contentValues.put(ConstantesBaseDatos.TABLA_MASCOTAS_FOTO, R.drawable.diana);

        db.insertarMascota(contentValues);

        contentValues = new ContentValues();

        contentValues.put(ConstantesBaseDatos.TABLA_MASCOTAS_NOMBRE,"Gemma");
        contentValues.put(ConstantesBaseDatos.TABLA_MASCOTAS_FOTO, R.drawable.diana);

        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLA_MASCOTAS_NOMBRE,"Diana");
        contentValues.put(ConstantesBaseDatos.TABLA_MASCOTAS_FOTO, R.drawable.diana);

        db.insertarMascota(contentValues);
    }

    public void darLikeMascota (Mascota mascota) {
        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLA_LIKES_MASCOTAS_ID_MASCOTA, mascota.getId());
        contentValues.put(ConstantesBaseDatos.TABLA_LIKES_MASCOTAS_NUMERO_LIKES, LIKE);
        db.insertarLikesMascota(contentValues);
    }

    public int obtenerLikesMascota (Mascota mascota) {
        BaseDatos db = new BaseDatos(context);
        return db.obtenerLikesMascotas(mascota);
    }
}
