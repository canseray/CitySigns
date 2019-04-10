package com.example.citysigns;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ImageView imageView = findViewById(R.id.imageView);
        TextView textView = findViewById(R.id.textView);


        Intent intent = getIntent();                                    //intent al
        String name = intent.getStringExtra("name");            //name isminde intenti al
        textView.setText(name);                                       //aldığın namei texte set et


        imageView.setImageBitmap(MainActivity.selectedImage);
    }
}
