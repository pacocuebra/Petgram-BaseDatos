package com.pacuebra.petgram;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        Bundle bundle = getIntent().getExtras();
        int imPerro = bundle.getInt("FOTO");
        String tPerro = bundle.getString("NOMBRE");

        ImageView imperro = (ImageView)findViewById(R.id.imPerro);
        TextView tvperro = (TextView)findViewById(R.id.tvperro);

        imperro.setImageResource(imPerro);
        tvperro.setText(tPerro);



        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
