package com.example.android.nadiardhian.test;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.nadiardhian.test.DetailMenuActivity;
import com.example.android.nadiardhian.test.R;

import java.util.List;



public class MenusAdapter extends RecyclerView.Adapter<MenusAdapter.MyViewHolder> {

    private List<Menu> menusList; //list menu yang akan di tampilkan dengan variabel menulist

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView photo; //deklarasi photo dengan yang akan di tampilkan
        public TextView nama, harga, tanda; //dan textview

        public MyViewHolder(View itemView) {
            super(itemView);
            photo = (ImageView) itemView.findViewById(R.id.photo); //get id
            nama = (TextView) itemView.findViewById(R.id.nama);
            harga = (TextView) itemView.findViewById(R.id.harga);
            tanda = (TextView) itemView.findViewById(R.id.tanda);
        }
    }


    public MenusAdapter(List<Menu> menusList) {

        this.menusList = menusList; //menampilkan list menu
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.menu_list_row, parent, false); //layout yang akan di gunakan adalah menu list row

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        Menu menu = menusList.get(position); //get data
        holder.tanda.setText(""+position);
        holder.photo.setImageResource(menu.getPhoto());
        holder.nama.setText(menu.getNama());
        holder.harga.setText(menu.getHarga());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String komp = holder.tanda.getText().toString();
                Log.d("ItemMenuCLICKED","ID:"+komp); //yang akan di tampilkan logcat ketika menu di klik
                Intent i = new Intent(view.getContext().getApplicationContext(), DetailMenuActivity.class); //intent ke aktivitas detail menu
                i.putExtra("MenuID",""+komp);
                view.getContext().startActivity(i); //memulai aktifitas
            }
        });

    }

    @Override
    public int getItemCount() {

        return menusList.size();
    }
}