package com.example.android.nadiardhian.test;

import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TakeAwayActivity extends AppCompatActivity {
    private EditText name, phone, alamat, catatan; //deklarasi nama phone alamat dan catatan
    private Button pilih; //deklarasi button

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_away);

        name = (EditText)findViewById(R.id.name); //get id
        phone = (EditText)findViewById(R.id.phone);
        alamat = (EditText)findViewById(R.id.alamat);
        catatan = (EditText)findViewById(R.id.catatan);
        pilih = (Button)findViewById(R.id.pilihPesanan);

        pilih.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String a = name.getText().toString(); //variable yang sudah di get id nya di inisialkan dengan huruf
                String b = phone.getText().toString();
                String c = alamat.getText().toString();
                String d = catatan.getText().toString();

                if(a.isEmpty() || b.isEmpty() || c.isEmpty() || d.isEmpty()){ //jika semua kosong
                    Toast.makeText(TakeAwayActivity.this,"Isi Data dengan Lengkap", Toast.LENGTH_LONG).show(); //akan menampilkan toast ini
                    Intent intent = new Intent(TakeAwayActivity.this,TakeAwayActivity.class); //kembali lagi ke kelas take away
                    startActivity(intent); //memulai intent
                }else{ //jika semua terisi
                    Toast.makeText(TakeAwayActivity.this,"Silahkan Pilih Menu", Toast.LENGTH_LONG).show(); //akan menampilkan toast ini
                    Intent intent2 = new Intent(TakeAwayActivity.this,DaftarMenuActivity.class); //menuju ke kelas daftar menu
                    startActivity(intent2); //memulai intent
                }
            }
        });

    }
    public void showDatePickerDialog(View v) { //method untuk menampilkan kalender
        DialogFragment newFragment = new DatePickerFragment(); //menampilkan fragment yang sudah dibuat
        newFragment.show(getSupportFragmentManager(), getString(R.string.date_button));
    }

    public void showTimePickerDialog(View view) { //method untuk menampilkan time picker
        DialogFragment newFragment = new TimePickerFragment();
        newFragment.show(getSupportFragmentManager(), getString(R.string.time_button));
    }

    public void processDatePickerResult(int year, int month, int day) { //untuk menampilkan hasil datepicker bedasarkan tahun bulan hari
        // The month integer returned by the date picker starts counting at 0
        // for January, so you need to add 1 to show months starting at 1.
        String month_string = Integer.toString(month + 1);
        String day_string = Integer.toString(day);
        String year_string = Integer.toString(year);
        // Assign the concatenated strings to dateMessage.
        String dateMessage = (month_string + "/" + day_string + "/" + year_string);
        Toast.makeText(this, getString(R.string.date) + dateMessage, Toast.LENGTH_SHORT).show();
    }

    public void processTimePickerResult(int hourOfDay, int minute) { //untuk menampilkan hasil timepicker bedasarkan jam dan menit
        // Convert time elements into strings.
        String hour_string = Integer.toString(hourOfDay); //inisiasi jam dengan tipe data string
        String minute_string = Integer.toString(minute); //inisiasi menit dengan tipe data string
        // Assign the concatenated strings to timeMessage.
        String timeMessage = (hour_string + ":" + minute_string); //menampilkan jam dan menit
        Toast.makeText(this, getString(R.string.time) + timeMessage, Toast.LENGTH_SHORT).show(); //message yang ditampilkan
    }
}