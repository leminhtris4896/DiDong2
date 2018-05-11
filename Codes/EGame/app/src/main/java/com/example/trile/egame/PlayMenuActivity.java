package com.example.trile.egame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.trile.egame.MenuHome.PLAY;

public class PlayMenuActivity extends AppCompatActivity {

    private ImageView imgPlayKim;
    private ImageView imgPlayMoc;
    private ImageView imgPlayThuy;
    private ImageView imgPlayHoa;
    private ImageView imgPlayTho;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.play_menu_layout);
        init();
        // PLAY KIM
        imgPlayKim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(PlayMenuActivity.this, "Kim", Toast.LENGTH_SHORT).show();
                Intent intentKim = new Intent(PlayMenuActivity.this, PLAY.class);
                startActivity(intentKim);
            }
        });
        // PLAY MOC
        imgPlayMoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(PlayMenuActivity.this, "Mộc", Toast.LENGTH_SHORT).show();
            }
        });
        // PLAY THUY
        imgPlayThuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(PlayMenuActivity.this, "Thủy", Toast.LENGTH_SHORT).show();
            }
        });
        // PLAY HOA
        imgPlayHoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(PlayMenuActivity.this, "Hỏa", Toast.LENGTH_SHORT).show();
            }
        });
        // PLAY THO
        imgPlayTho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(PlayMenuActivity.this, "Thổ", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void init() {
        imgPlayKim = (ImageView) findViewById(R.id.playKim);
        imgPlayMoc = (ImageView) findViewById(R.id.playMoc);
        imgPlayThuy = (ImageView) findViewById(R.id.playThuy);
        imgPlayHoa = (ImageView) findViewById(R.id.playHoa);
        imgPlayTho = (ImageView) findViewById(R.id.playTho);
    }
}
