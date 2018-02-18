package com.example.android.nadiardhian.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.android.nadiardhian.test.DaftarMenuActivity;
import com.example.android.nadiardhian.test.R;

public class DineInActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    String mSpinnerlabel = ""; //mendeklarasikan spinner dengan tipe data string dan variable mSpinnerlabel
    private EditText name; // mendeklarasikan name dengan edit text
    private Spinner meja; //yang menggunakan spinner adalah meja jadi di deklarasi juga
    private Button pilih; //deklarasi button dengan variable pilih
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dine_in);

        name = (EditText)findViewById(R.id.name); //get id name
        meja = (Spinner) findViewById(R.id.spinner); //get id spinner
        pilih = (Button) findViewById(R.id.pilih); //get id button pilih

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.meja, android.R.layout.simple_spinner_item); //array yang di gunakan untuk menampilkan dropdown meja
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        if (meja != null) { //ketika meja di klik
            meja.setAdapter(adapter); //arraylist akan di panggil dengan adapter
        }


    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        mSpinnerlabel = parent.getItemAtPosition(position).toString(); //jika sudah dipilih maka hasilnya akan di tampilkan
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public void pilih(View view) { //button pilih diklik
        String spinner = meja.getSelectedItem().toString(); //spinner yang sudah dipilih maka akan di tampilkan
        String a = name.getText().toString();//beri inisial name dengan a
        if(a.isEmpty() || spinner.isEmpty()){ //jika a kosong dan spinner tidak dipilih
            Toast.makeText(DineInActivity.this,"Silahkan Lengkapi Data Terlebih Dahulu",Toast.LENGTH_LONG).show();//akan menampilkan toast ini
        }else{ //jika sudah di isi
            Intent intent = new Intent(DineInActivity.this,DaftarMenuActivity.class); //intent ke activitas dinein
            startActivity(intent); //memulai intent
            Toast.makeText(DineInActivity.this,"Silahkan Pilih Menu untuk " + spinner,Toast.LENGTH_LONG).show();//akan menampilkan toast ini
        }
    }
}
