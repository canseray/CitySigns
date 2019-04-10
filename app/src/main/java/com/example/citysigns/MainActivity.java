package com.example.citysigns;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    static Bitmap selectedImage;  //heryerden ulaşmak için static,diğer aktivityden mainacticity.se seklinde ulaşıcaz

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);



        /*ListViewde olacak elemanları bir Array içerisine atıyoruz*/
        final ArrayList<String> citySignsNames = new ArrayList<String>();
        citySignsNames.add("Taç Mahal");
        citySignsNames.add("Eiffel");
        citySignsNames.add("Keops Piramidi");
        citySignsNames.add("Ayasofya");



        /*ListView e görselleri atmak için,görselleri önce bitmap kıvamına getiriyoruz*/
        Bitmap tac = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.tac);
        Bitmap eiffel = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.eiffel);
        Bitmap keops = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.keops);
        Bitmap aya = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.aya);

        final ArrayList<Bitmap> citySignsImages = new ArrayList<>();
        citySignsImages.add(tac);
        citySignsImages.add(eiffel);
        citySignsImages.add(keops);
        citySignsImages.add(aya);



        /*ArrayAdapter ile ListView ve Arrayi bağlıyoruz*/
        ArrayAdapter arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,citySignsNames);
        listView.setAdapter(arrayAdapter);



        /*  ListViewin bir elemanına tıkladığımızda olacaklar,diğer activitye yönlendirme
          "name" adıyla stringleri al pozisyonuna göre -sırasına göre- diğer aktivitiye ver
           görsel için de selectedimage */
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(),DetailActivity.class);
                intent.putExtra("name",citySignsNames.get(position));
                selectedImage = citySignsImages.get(position);
                startActivity(intent);
            }
        });



    }
}
