package com.example.s10203953;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class vAdapt extends RecyclerView.Adapter<vHolder> {
    ArrayList<MainActivity.User> data;
    public vAdapt(ArrayList<MainActivity.User> data){
        this.data = data;
    }

    @NonNull
    @Override
    public vHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item = null;
        item = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycleview,null,false);
        return new vHolder(item);
    }

    @Override
    public void onBindViewHolder(@NonNull vHolder holder,int position) {
        //name
        String n = data.get(position).name;
        holder.name.setText(n);
        //description
        String de = data.get(position).description;
        holder.des.setText(de);

        ImageView logo = holder.logo;
        View gg = holder.itemView;
        logo.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Context pulld = v.getContext();
                AlertDialog.Builder alertn = new AlertDialog.Builder(pulld);
                alertn.setTitle("Profile")
                        .setMessage("MADness")
                        .setPositiveButton("close", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(pulld, "You closed the thingy", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("View", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent goNext = new Intent(pulld,MainActivity.class);

                                String name = data.get(position).name;

                                String d = data.get(position).description;

                                Bundle user = new Bundle();
                                user.putString("Name",name);
                                user.putString("Description",d);
                                goNext.putExtra("UserInfo",user);
                                pulld.startActivity(goNext);
                            }
                        }).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void alertDiaAdapt(View v){
        //Alert
        Context pulld = v.getContext();
        AlertDialog.Builder alertn = new AlertDialog.Builder(pulld);
        alertn.setTitle("Profile")
                .setMessage("MADness")
                .setPositiveButton("close", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(pulld, "You closed the thingy", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("View", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent goNext = new Intent(pulld,MainActivity.class);

                        /*String name = data.get(position).name;
                        String d = data.get(position).description;

                        Bundle user = new Bundle();
                        user.putString("Name",name);
                        user.putString("Description",d);
                        goNext.putExtra("UserInfo",user);
                        pulld.startActivity(goNext);*/
                    }
                }).show();
    }

}
