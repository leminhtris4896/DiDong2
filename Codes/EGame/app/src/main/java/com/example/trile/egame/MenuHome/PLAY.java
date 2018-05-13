package com.example.trile.egame.MenuHome;

import android.app.Dialog;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.trile.egame.Models.mdQuestion;
import com.example.trile.egame.PlayMenuActivity;
import com.example.trile.egame.R;
import com.example.trile.egame.fragment_Question;
import com.example.trile.egame.luuDem;

import java.util.ArrayList;
import java.util.Locale;

public class PLAY extends AppCompatActivity {

    private TextView tvTime;
    private SeekBar seekBarTime;
    private static final long STAR_TIME_IN_MILLIS = 600000;
    private CountDownTimer mCountDownTimer;
    private CountDownTimer mCountDownTimerSeekbar;
    private long TimeLeftInMillis = STAR_TIME_IN_MILLIS;
    private boolean mTimeRunning;
    private LinearLayout linearClose;
    private ImageView imgClose;
    private ImageView btn_Accept_Select;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.play_game);
        initView();
        questionStar();
        imgClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                linearClose.setVisibility(View.VISIBLE);
            }
        });

    }

    // Dialog "star playing game" question
    private void questionStar() {
        final Dialog dialog = new Dialog(PLAY.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_star);
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();

        TextView tvSTAR = (TextView) dialog.findViewById(R.id.tvSTAR);
        tvSTAR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
                starGame();
                fragment_Question fragment_question = new fragment_Question();
                android.support.v4.app.FragmentTransaction fragmentTransaction1 = getSupportFragmentManager().beginTransaction();
                fragmentTransaction1.replace(R.id.frame_question, fragment_question, "Fragment");
                fragmentTransaction1.commit();
            }
        });

        btn_Accept_Select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (luuDem.dem < 9) {
                    luuDem.dem = luuDem.dem + 1;
                    fragment_Question fragment_question = new fragment_Question();
                    android.support.v4.app.FragmentTransaction fragmentTransaction1 = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction1.replace(R.id.frame_question, fragment_question, "Fragment");
                    fragmentTransaction1.commit();
                } else if (luuDem.dem >= 9) {
                    ArrayList<mdQuestion> mdQuestions = getIntent().getParcelableArrayListExtra("random_question");
                    for (int i = 0; i < luuDem.arrayListReply.size(); i++) {
                       if (ktTrung(mdQuestions,luuDem.arrayListReply.get(i)) == true)
                                luuDem.Diem = luuDem.Diem + 1;
                    }
                    Toast.makeText(PLAY.this,luuDem.Diem+ "",Toast.LENGTH_SHORT).show();
                    luuDem.arrayListReply.clear();
                    luuDem.Diem = 0;
                    luuDem.dem = 0;
                    Intent intent = new Intent(PLAY.this, PlayMenuActivity.class);
                    startActivity(intent);
                }
            }
        });
    }


    private void initView() {
        imgClose = (ImageView) findViewById(R.id.imgClose);
        tvTime = (TextView) findViewById(R.id.textTime);
        btn_Accept_Select = (ImageView) findViewById(R.id.btn_Accept_Select);
    }

    private void starGame() {
        // STAR PLAY GAME
        mCountDownTimer = new CountDownTimer(TimeLeftInMillis, 500) {
            @Override
            public void onTick(long millisUltilFinish) {
                TimeLeftInMillis = millisUltilFinish;
                updateCountTime();
            }

            @Override
            public void onFinish() {
                Toast.makeText(PLAY.this, "THUA MẤT RỒI", Toast.LENGTH_SHORT).show();
            }
        }.start();
        mTimeRunning = true;
    }

    private void updateCountTime() {
        int minustes = (int) (TimeLeftInMillis / 1000) / 60;
        int seconds = (int) (TimeLeftInMillis / 1000) % 60;
        String timeLeftFormatted = String.format(Locale.getDefault(), "%02d:%02d", minustes, seconds);
        tvTime.setText(timeLeftFormatted);
    }

    public boolean ktTrung(ArrayList<mdQuestion> strings, String chuoi) {
        boolean kt = false;
        for (int i = 0; i < strings.size(); i++) {
            if (strings.get(i).getAnswer().equalsIgnoreCase(chuoi)) {
                kt = true;
            }
        }
        return kt;
    }
}
