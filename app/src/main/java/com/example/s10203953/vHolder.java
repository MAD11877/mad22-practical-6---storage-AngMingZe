package com.example.s10203953;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class vHolder extends RecyclerView.ViewHolder{
    TextView name;
    TextView des;
    ImageView logo;

    public vHolder(@NonNull View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.name);
        des = itemView.findViewById(R.id.descrip);
        logo = itemView.findViewById(R.id.logorv);
    }
}
