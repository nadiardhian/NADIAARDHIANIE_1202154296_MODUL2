package com.example.android.nadiardhian.test;

/**
 * Created by user on 2/18/2018.
 */

public class Menu {
    int photo;
    private String nama, harga, komposisi;

    public Menu(int photo, String nama, String harga, String komposisi) {
        this.photo = photo;
        this.nama = nama;
        this.harga = harga;
        this.komposisi = komposisi;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public String getKomposisi() {
        return komposisi;
    }

    public void setKomposisi(String komposisi) {
        this.komposisi = komposisi;
    }
}

