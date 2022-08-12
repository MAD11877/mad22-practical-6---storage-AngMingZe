package com.example.s10203953;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static class User{
        //Attr
        String name;
        String description;
        int id;
        boolean followed;
        //Constructor
        public User(String n,String des,int ID,boolean Followed){
            name = n;
            description = des;
            id = ID;
            followed = Followed;
        };
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent receivingEnd = getIntent();
        Bundle test = receivingEnd.getBundleExtra("UserInfo");
        String n = test.getString("Name");
        String des = test.getString("Description");

        TextView name = findViewById(R.id.hworld);
        name.setText(n);

        TextView descrip = findViewById(R.id.text1);
        descrip.setText(des);

        User u1 = new User(n,des,01,false);
        if (u1.followed == true){
            Button b1 = findViewById(R.id.follow);
            b1.setText("Unfollow");
        }
    }

    public void followBut(View v){
        //Event handler
        Button b1 = findViewById(R.id.follow);
        String text = b1.getText().toString();//Text of follow button
        if (text == "Follow"){
            b1.setText("Unfollow");
            Toast.makeText(getApplicationContext(),"Followed",Toast.LENGTH_SHORT).show();
            // Toast.makeText(getApplicationContext(), <Text>, <Duration Visible>).show();
        }
        else{
            b1.setText("Follow");
            Toast.makeText(getApplicationContext(),"Unfollowed",Toast.LENGTH_SHORT).show();
        }
    }


}