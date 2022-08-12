package com.example.s10203953;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class ListActivity extends AppCompatActivity {
    ArrayList<MainActivity.User> USE = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ArrayList<MainActivity.User> users = Listgenerate(USE);

        RecyclerView rv = findViewById(R.id.rv);
        vAdapt adapt = new vAdapt(users);
        LinearLayoutManager layout = new LinearLayoutManager(this);

        rv.setLayoutManager(layout);
        rv.setAdapter(adapt);
    }

    public ArrayList<MainActivity.User> Listgenerate( ArrayList<MainActivity.User> dalist) {
        int random;
        for (int i = 0; i < 20; i++) {
            String name = "Name";
            String des = "Description ";
            boolean fol = false;
            int id = 0;
            random = 0;
            //name
            random = new Random().nextInt(99999);
            name = name + random;

            //description
            random = new Random().nextInt(99999);
            des = des + random;

            //id
            random = new Random().nextInt(99999);
            id = random;

            //follow status
            random = new Random().nextInt(2);
            if (random == 0) {
                fol = true;
            } else {
                fol = false;
            }
            MainActivity.User temp = new MainActivity.User(name, des, id, fol);
            dalist.add(temp);
        }
        return dalist;
    }

    public void alertDia(View v){
        //Alert
        AlertDialog.Builder alertn = new AlertDialog.Builder(this);
        alertn.setTitle("Profile")
        .setMessage("MADness")
        .setNegativeButton("close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(ListActivity.this, "You closed the thingy", Toast.LENGTH_SHORT).show();
            }
        })
        .setPositiveButton("View", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent goNext = new Intent(ListActivity.this,MainActivity.class);

                TextView name = findViewById(R.id.name);
                String n = name.getText().toString();

                TextView des = findViewById(R.id.descrip);
                String d = des.getText().toString();

                Bundle user = new Bundle();
                user.putString("Name",n);
                user.putString("Description",d);
                goNext.putExtra("UserInfo",user);
                startActivity(goNext);
            }
        }).show();
    }
}