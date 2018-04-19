package com.example.hyde.utsapi.adapter;

import android.support.v7.app.AlertDialog;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.hyde.utsapi.R;
import com.example.hyde.utsapi.activity.Main2Activity;
import com.example.hyde.utsapi.model.DataItem;

import java.util.List;

public class PelAdapter extends RecyclerView.Adapter<PelAdapter.MyHolder> {
    private List<DataItem> myData;
    private Main2Activity activity;


    public PelAdapter(Main2Activity mainActivity, List<DataItem> mData) {
        this.myData = mData;
        this.activity = mainActivity;
    }

    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView;
        itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_nama, parent, false);

        return new MyHolder(itemView);
    }

    public void onBindViewHolder(final MyHolder holder, final int position) {
        // Menampilkan String
        holder.id.setText("Id       : " + myData.get(position).id);
        holder.nama.setText("Nama     : " + myData.get(position).nama);
        holder.alamat.setText("Alamat   : " + myData.get(position).alamat);
        holder.tlp.setText("Telepon  : " + myData.get(position).noTlp);


//        holder.card.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });
    }

    public int getItemCount() {
        return myData.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        TextView id, nama, alamat, tlp;
        LinearLayout lin;
        CardView card;
        public MyHolder(View itemView) {
            super(itemView);
            id = (TextView) itemView.findViewById(R.id.idp);
            nama = (TextView) itemView.findViewById(R.id.nama);
            alamat = (TextView) itemView.findViewById(R.id.alamt);
            tlp = (TextView) itemView.findViewById(R.id.tlp);
            lin=(LinearLayout)itemView.findViewById(R.id.lin);
            card = (CardView)itemView.findViewById(R.id.car);

        }
    }
}
