package com.pacuebra.petgram.Menu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.pacuebra.petgram.R;

public class Acerca extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acerca);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_acerca);
        setSupportActionBar(toolbar);
        if(getSupportActionBar() != null)
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
