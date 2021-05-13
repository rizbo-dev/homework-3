package com.example.projekat_3_boris_evetovic;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ThirdActivity extends AppCompatActivity {

    String choice;
    String place;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_activity);
    }

    public void toggleFemale(View view) {

        ImageView femalePic = findViewById(R.id.femalePic);
        ImageView malePic = findViewById(R.id.malePic);
        femalePic.setImageResource(R.drawable.femalecolor);
        malePic.setImageResource(R.drawable.male);
        choice = "Female";

   }

    public void toggleMale(View view) {
        ImageView femalePic = findViewById(R.id.femalePic);
        ImageView malePic = findViewById(R.id.malePic);
        femalePic.setImageResource(R.drawable.female);
        malePic.setImageResource(R.drawable.malecolor);
        choice = "Male";
    }

    public void openFourth(View view) {
        EditText name = findViewById(R.id.name);
        EditText phoneNumber = findViewById(R.id.phoneNumber);
        EditText favoriteWeb = findViewById(R.id.favoriteWeb);
        RadioButton kizurRb = (RadioButton)findViewById(R.id.kizur);
        RadioButton mescRb = (RadioButton)findViewById(R.id.mesc);
        RadioButton vtsRb = (RadioButton)findViewById(R.id.vts);
        RadioButton velebitRb = (RadioButton)findViewById(R.id.velebit);
        boolean isValid = true;

        if (kizurRb.isChecked()) {
            place = "www.kizur.edu.rs";
        }

        if (mescRb.isChecked()) {
            place = "www.tsis.edu.rs";
        }

        if (vtsRb.isChecked()) {
            place = "www.vts.su.ac.rs";
        }

        if (velebitRb.isChecked()) {
            place = "www.velebit.carp";
        }

        if (choice == null) {
          choice = "Neodredjen";
        }

            Intent intent = new Intent(this, FourthActivity.class);
            intent.putExtra("name", String.valueOf(name.getText()));
            intent.putExtra("gender", choice);
            intent.putExtra("phoneNumber", String.valueOf(phoneNumber.getText()));
            intent.putExtra("favoriteWeb", String.valueOf(favoriteWeb.getText()));
            intent.putExtra("place", place);

            startActivity(intent);

    }
}
