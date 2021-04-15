package com.example.travelblogapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TextView goodTitle, goodDescription, goodPrice;
    ImageView goodImage;
    Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        goodTitle = (TextView) findViewById(R.id.goodTitle);
        goodDescription = (TextView) findViewById(R.id.goodDescription);
        goodPrice = (TextView) findViewById(R.id.goodPrice);
        goodImage = (ImageView) findViewById(R.id.goodImage);

        DB.getOrders().add(new Order(R.drawable.travel, "Река Мртвица: каньон, Данилов Мост и сказочный лес", "Если честно, мы искали здесь подвесной мостик  А нашли вместо него слияние рек Морача и Мртвица, сказочный лес, Данилов Мост через каньон Мртвица и множество трекинговых троп для интересных пеших прогулок.", "500 USD", "https://diary.travel/marokko"));
        DB.getOrders().add(new Order(R.drawable.images1, "Река Мртвица: каньон, Данилов Мост и сказочный лес", "Если честно, мы искали здесь подвесной мостик  А нашли вместо него слияние рек Морача и Мртвица, сказочный лес, Данилов Мост через каньон Мртвица и множество трекинговых троп для интересных пеших прогулок.", "900 USD", "https://diary.travel/marokko"));
        DB.getOrders().add(new Order(R.drawable.images, "Река Мртвица: каньон, Данилов Мост и сказочный лес", "Если честно, мы искали здесь подвесной мостик  А нашли вместо него слияние рек Морача и Мртвица, сказочный лес, Данилов Мост через каньон Мртвица и множество трекинговых троп для интересных пеших прогулок.", "800 USD" , "https://diary.travel/marokko"));


        TravelAdapter travelAdapter = new TravelAdapter(DB.getOrders());
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        recyclerView.setAdapter(travelAdapter);



        travelAdapter.setItemClickListener(new TravelAdapter.ItemClickListener() {
            @Override
            public void ItemClick(int position) {
                intent = new Intent(MainActivity.this, Detail.class);
                intent.putExtra("goodTitle", goodTitle.getText().toString());
                startActivity(intent);
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id. hard:
                try {
                    Intent shareIntent = new Intent(Intent.ACTION_SEND);
                    shareIntent.setType("text/plain");
                    shareIntent.putExtra(Intent.EXTRA_SUBJECT, "My application name");
                    String shareMessage= "\nLet me recommend you this application\n\n";
                    shareMessage = shareMessage + "https://play.google.com/store/apps/details?id=" + BuildConfig.APPLICATION_ID +"\n\n";
                    shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage);
                    startActivity(Intent.createChooser(shareIntent, "choose one"));
                } catch(Exception e) {

                }

                break;
        }
        return super.onOptionsItemSelected(item);
    }

}
