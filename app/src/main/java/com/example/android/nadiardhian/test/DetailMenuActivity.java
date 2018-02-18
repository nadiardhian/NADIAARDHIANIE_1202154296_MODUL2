package com.example.android.nadiardhian.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class DetailMenuActivity extends AppCompatActivity {

    private ArrayList<Menu> menus; //deklarasi arraylist dengan variable menu
    private String tanda; //deklarasi tanda sebagai kata kunci di menu
    private TextView nama, harga, komposisi; //deklarasi nama harga dan komposisi
    private ImageView photo; //dan gambar juga di deklarasikan
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_menu);

        nama = (TextView)findViewById(R.id.tvMenu); //get id
        harga = (TextView)findViewById(R.id.tvHarga);
        komposisi = (TextView)findViewById(R.id.tvDetail);
        photo = (ImageView)findViewById(R.id.ivPhoto);

        menus = DaftarMenuActivity.menuList; //menampilkan menu yang ada di kelas daftar menu
        Intent c = getIntent(); //get intent dari class daftar menu
        tanda = c.getStringExtra("MenuID"); //tanda sebagai kata kunci menu id
        Menu menu = menus.get(Integer.parseInt(tanda)); //rubah menu dari tipe data string ke int
        nama.setText(menu.getNama()); //get id
        harga.setText(menu.getHarga());
        komposisi.setText(menu.getKomposisi());
        photo.setImageResource(menu.getPhoto());

    }

}