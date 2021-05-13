package com.example.projekat_3_boris_evetovic;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class FourthActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fourth_activity);
        Intent intent = getIntent();

        String name = intent.getStringExtra("name");
        String gender = intent.getStringExtra("gender");
        String phoneNumber= intent.getStringExtra("phoneNumber");
        String favoriteWeb = intent.getStringExtra("favoriteWeb");
        String place = intent.getStringExtra("place");

        TextView nameTV = findViewById(R.id.inic);
        TextView genderTv = findViewById(R.id.gender);
        TextView brojTv = findViewById(R.id.broj);
        TextView favoriteTv = findViewById(R.id.web);
        TextView choiceTv = findViewById(R.id.choice);

        String[] splitted = name.split("\\s");
        String toSetName = "";
        for(String s : splitted) {
            toSetName += s.charAt(0);
        }
        String toSetNumber = phoneNumber.substring(1,3);
        nameTV.setText(toSetName);
        genderTv.setText(gender);
        brojTv.setText(toSetNumber);
        favoriteTv.setText(favoriteWeb);
        choiceTv.setText(place);


    }

    public void openMap(View view) {
        TextView choiceTv = findViewById(R.id.choice);

        Intent i = new Intent(this,MapsActivity.class);
        i.putExtra("choice",String.valueOf(choiceTv.getText()));
        startActivity(i);
    }

    public void openSite(View view) {
        TextView favoriteTv = findViewById(R.id.web);
        Intent intent=new Intent(Intent.ACTION_VIEW);
        if(favoriteTv.getText().toString().contains("http://") || favoriteTv.getText().toString().contains("https://"))
            intent.setData(Uri.parse(favoriteTv.getText().toString()));
        else
            intent.setData(Uri.parse("http://" + favoriteTv.getText().toString()));
        startActivity(intent);
    }
}
