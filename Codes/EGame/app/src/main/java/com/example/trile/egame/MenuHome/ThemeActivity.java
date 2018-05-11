package com.example.trile.egame.MenuHome;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.trile.egame.R;

public class ThemeActivity extends AppCompatActivity {

    private ImageView imgCLOSETHEME;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.theme_layout);
        initView();
        imgCLOSETHEME.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentCloseTheme = new Intent(ThemeActivity.this,HomeActivity.class);
                startActivity(intentCloseTheme);
            }
        });
    }

    private void initView() {
        imgCLOSETHEME = (ImageView) findViewById(R.id.closeTheme);
    }


}
