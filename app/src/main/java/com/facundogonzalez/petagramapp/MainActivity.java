package com.facundogonzalez.petagramapp;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toolbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaMascotas = (RecyclerView)findViewById(R.id.rvMascotas);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(llm);

        iniciarListaMascotas();
        inicializarAdaptador();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.itemStrella:
                Intent intent = new Intent(MainActivity.this, MascotasFavoritas.class);
                startActivity(intent);
                return true;
            default:
                final boolean b = super.onOptionsItemSelected(item);
                return b;
        }
    }

    public void inicializarAdaptador(){
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, this);
        listaMascotas.setAdapter(adaptador);
    }

    public void iniciarListaMascotas(){

        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota(R.drawable.diana,"Diana", 12));
        mascotas.add(new Mascota(R.drawable.luna,"Luna", 20));
        mascotas.add(new Mascota(R.drawable.yoda,"Yoda", 5));
        mascotas.add(new Mascota(R.drawable.tucky,"Tucky", 17));
        mascotas.add(new Mascota(R.drawable.simon,"Simon", 9));
    }


    public void incrementValue(View view){
        TextView tv = findViewById(R.id.tvLikes);
        int i = Integer.parseInt(tv.getText().toString());
        i++;
        tv.setText(i+"");

    }
}

