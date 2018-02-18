package com.example.android.nadiardhian.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private RadioGroup rg; //mengidentifikasi radiogrup pada class main activity dengan variabel rg
    private RadioButton rb1, rb2; //dan radio button rb1 dan rb2
    private Button btPesan; //variable button untuk memilih pesanan adalah btnpesan
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rg = (RadioGroup)findViewById(R.id.radioGroup); //get data dengan id dengan nama variable yang sudah di definisikan diatas
        rb1 = (RadioButton)findViewById(R.id.dineIn);
        rb2 = (RadioButton)findViewById(R.id.takeAway);
        btPesan = (Button)findViewById(R.id.pesanSekarang);

        btPesan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { //method untuk memerintahkan setelah button di klik apa yang terjadi
                int selectedItem = rg.getCheckedRadioButtonId(); //melakukan check radio button

                if(selectedItem == rb1.getId()){ //jika di klik rb 1 maka aktivitas selanjutnya adalah dine in
                    Intent intent = new Intent(MainActivity.this,DineInActivity.class); //perintah intent
                    startActivity(intent); //memulai intent
                    Toast.makeText(MainActivity.this,"Anda Memilih Dine In",Toast.LENGTH_LONG).show();//toast yang di tampilkan jika memilih dinein
                }else if(selectedItem == rb2.getId()){ //jika di klik rb2 maka aktivitas selanjutnya adalah take away
                    Intent intent2 = new Intent(MainActivity.this,TakeAwayActivity.class); //perintah intent
                    startActivity(intent2); //memulai intent
                    Toast.makeText(MainActivity.this,"Anda Memilih Take Away",Toast.LENGTH_LONG).show(); //toast yang akan di tampilkan jika memilih takeaway
                }
            }
        });
    }
}