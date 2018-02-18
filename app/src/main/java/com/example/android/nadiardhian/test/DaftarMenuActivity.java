package com.example.android.nadiardhian.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class DaftarMenuActivity extends AppCompatActivity {

    public static ArrayList<Menu> menuList = new ArrayList<>(); //untuk menampilkan menu menggunakan array

    private RecyclerView recyclerView; //deklarasi recyclerview yang sudah di buat di xml
    private MenusAdapter mAdapter; //dan adapternya untuk menampilkan array

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_menu);

        menuList = isiMenu(); //list menu yang akan ditampilkan
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view); //get data dari recyclerview

        mAdapter = new MenusAdapter(menuList); //agar adapter bisa menampilkan menu
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

    }

    public ArrayList<Menu> isiMenu(){ //isi menu dengan arraylist
        ArrayList<Menu> data = new ArrayList<>();

        data.add(new Menu(R.drawable.nasigoreng,"Nasi Goreng", "Harga : Rp 10.000", "Nasi,telor dan olahan bumbu yang nikmat"));

        data.add(new Menu(R.drawable.nasipecel,"Nasi Pecel", "Harga : Rp 10.000","Nasi dengan sayuran segar dibumbui dengan sambal kacang"));

        data.add(new Menu(R.drawable.nasilemak,"Nasi Lemak", "Harga : Rp 15.000","nasi gurih dan harum yang dimasak dengan santan, disajikan dengan sambal cumi, sambal teri, teri kacang, separuh telur ayam rebus, irisan mentimun."));

        data.add(new Menu(R.drawable.miegoreng,"Mie Goreng Telor", "Harga : Rp 12.000","Mie,telor dengan kecap dan sambel sesuai selera"));

        data.add(new Menu(R.drawable.ayamgoreng,"Nasi Ayam Goreng", "Harga : Rp 17.000","Nasi,ayam goreng dengan lalapan segar dan tidak lupa sambalnya"));

        data.add(new Menu(R.drawable.semurjengkol,"Semur Jengkol", "Harga : Rp 20.000","Nasi dan jengkol dengan bumbu turun temurun"));

        data.add(new Menu(R.drawable.nasirendang,"Nasi Rendang", "Harga : Rp 20.000","Nasi dan daging rendang yang dimasak empuk"));


        return data;

    }
}