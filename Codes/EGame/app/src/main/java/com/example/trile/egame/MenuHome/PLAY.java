package com.example.trile.egame.MenuHome;

import android.app.Dialog;
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

import com.example.trile.egame.R;

import java.util.Locale;

public class PLAY extends AppCompatActivity {

    private TextView tvTime;
    private SeekBar seekBarTime;
    private static  final long STAR_TIME_IN_MILLIS = 600000;
    private CountDownTimer mCountDownTimer;
    private CountDownTimer mCountDownTimerSeekbar;
    private long TimeLeftInMillis = STAR_TIME_IN_MILLIS;
    private boolean mTimeRunning;
    private LinearLayout linearClose;
    private ImageView imgClose;

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
            }
        });
    }


    private void initView() {
        imgClose = (ImageView) findViewById(R.id.imgClose);
        tvTime = (TextView) findViewById(R.id.textTime);
    }

    private void starGame() {
        // STAR PLAY GAME
        mCountDownTimer = new CountDownTimer(TimeLeftInMillis,500) {
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
        String timeLeftFormatted = String.format(Locale.getDefault(),"%02d:%02d",minustes,seconds);
        tvTime.setText(timeLeftFormatted);
    }
}
