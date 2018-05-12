package com.example.trile.egame.MenuHome;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.trile.egame.PlayMenuActivity;
import com.example.trile.egame.R;

public class HomeActivity extends AppCompatActivity {

    private Button btnPLAYGAME;
    private Button btnTOP;
    private Button btnTRAINGAME;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_layout);
        initView();
        btnPLAYGAME.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent intentMenuGame = new Intent(HomeActivity.this,PlayMenuActivity.class);
               startActivity(intentMenuGame);
            }
        });
        btnTOP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentTop = new Intent(HomeActivity.this,TopActivity.class);
                startActivity(intentTop);
            }
        });
        btnTRAINGAME.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentTheme = new Intent(HomeActivity.this,Practice_Vocabulary_Activity.class);
                startActivity(intentTheme);
            }
        });
    }

    private void initView() {
        btnPLAYGAME = (Button) findViewById(R.id.btnPlayGame);
        btnTOP = (Button) findViewById(R.id.btnTopGame);
        btnTRAINGAME = (Button) findViewById(R.id.btnTrainGame);
    }


}
