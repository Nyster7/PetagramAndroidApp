package com.facundogonzalez.petagramapp.vista.fragment;

import com.facundogonzalez.petagramapp.adapter.MascotaAdaptador;
import com.facundogonzalez.petagramapp.modelo.Mascota;

import java.util.ArrayList;

public interface IRecyclerViewFragmentView {

    public void generarLinearLayoutVertical();

    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas);

    public void inicializarAdaptadorRV(MascotaAdaptador adaptador);
}
