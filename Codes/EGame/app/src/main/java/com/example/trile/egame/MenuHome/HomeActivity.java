package com.example.trile.egame.MenuHome;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.trile.egame.PlayMenuActivity;
import com.example.trile.egame.R;
import com.example.trile.egame.RegisterLogin.LoginActivity;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.firebase.auth.FirebaseAuth;

public class HomeActivity extends AppCompatActivity {

    private Button btnPLAYGAME;
    private Button btnTOP;
    private Button btnTRAINGAME;
    private Button btnLOGOUT;
    //

    private GoogleApiClient mGoogleApiClient;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_layout);

        mAuth = FirebaseAuth.getInstance();
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

        btnLOGOUT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    mAuth.signOut();
                    Toast.makeText(HomeActivity.this, "Đăng xuất tài khoản thành công", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(HomeActivity.this, LoginActivity.class));
                }
        });
    }

    private void initView() {
        btnPLAYGAME = (Button) findViewById(R.id.btnPlayGame);
        btnTOP = (Button) findViewById(R.id.btnTopGame);
        btnTRAINGAME = (Button) findViewById(R.id.btnTrainGame);
        btnLOGOUT = (Button) findViewById(R.id.btnLogout);
    }


}
