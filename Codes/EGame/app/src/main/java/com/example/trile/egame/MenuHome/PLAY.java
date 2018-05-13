package com.example.trile.egame.MenuHome;

import android.app.Dialog;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.trile.egame.Models.mdQuestion;
import com.example.trile.egame.Models.mdUsers;
import com.example.trile.egame.PlayMenuActivity;
import com.example.trile.egame.R;
import com.example.trile.egame.fragment_Question;
import com.example.trile.egame.luuDem;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Locale;

public class PLAY extends AppCompatActivity {

    private TextView tvTime;
    private SeekBar seekBarTime;
    private static final long STAR_TIME_IN_MILLIS = 68000;
    private CountDownTimer mCountDownTimer;
    private CountDownTimer mCountDownTimerSeekbar;
    private long TimeLeftInMillis = STAR_TIME_IN_MILLIS;
    private boolean mTimeRunning;
    private LinearLayout linearClose;
    private ImageView btn_Accept_Select;
    //
    private ImageView imgUserPlay;
    private TextView tvNameUserPlay;
    private TextView tvPointUserPlay;
    private TextView numberQuestion;
    //
    DatabaseReference mData;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.play_game);
        // Firebase
        mData = FirebaseDatabase.getInstance().getReference();
        mAuth = FirebaseAuth.getInstance();
        //
        initView();
        questionStar();
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

        DisplayInforUser();

        btn_Accept_Select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // SET number question after when click button accept , + 1
                numberQuestion.setText(luuDem.dem + 1 + "");
                // Music fire
                MediaPlayer mediaPlayer = new MediaPlayer();
                try {
                    mediaPlayer.setDataSource(String.valueOf(R.raw.mp3fire));
                    mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                        @Override
                        public void onPrepared(MediaPlayer mp) {
                            mp.start();
                        }
                    });
                    mediaPlayer.prepare();
                }catch (Exception e) {
                    e.printStackTrace();
                }

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
                    // Toast.makeText(PLAY.this,luuDem.Diem+ "",Toast.LENGTH_SHORT).show();
                    //
                    if (luuDem.Diem > 5) {

                        final Dialog dialog = new Dialog(PLAY.this);
                        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                        dialog.setCanceledOnTouchOutside(true);
                        dialog.setContentView(R.layout.dialog_win);
                        dialog.show();
                        // CALL ITEM FROM DIALOG
                        TextView tvAnswerTrue = (TextView) dialog.findViewById(R.id.answerTRUE);
                        TextView tvAnswerFalse = (TextView) dialog.findViewById(R.id.answerFALSE);
                        TextView btnCancelDialog = (TextView) dialog.findViewById(R.id.btnExitGame);
                        TextView btnNextGame = (TextView) dialog.findViewById(R.id.btnPlayNext);

                        tvAnswerTrue.setText(luuDem.Diem + "");
                        int KQ = 10 - luuDem.Diem;
                        tvAnswerFalse.setText(KQ + "");

                        mData.child("Users").addChildEventListener(new ChildEventListener() {
                            @Override
                            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                                mdUsers users = dataSnapshot.getValue(mdUsers.class);
                                if (users.getMail().equalsIgnoreCase(mAuth.getCurrentUser().getEmail())) {
                                    final String userID = mAuth.getCurrentUser().getUid();
                                    mData.child("Users").child(userID).child("point").setValue(users.getPoint() + 1);
                                }
                            }

                            @Override
                            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

                            }

                            @Override
                            public void onChildRemoved(DataSnapshot dataSnapshot) {

                            }

                            @Override
                            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

                            }

                            @Override
                            public void onCancelled(DatabaseError databaseError) {

                            }
                        });

                        btnCancelDialog.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                dialog.dismiss();
                                Intent intentCancel = new Intent(PLAY.this, HomeActivity.class);
                                startActivity(intentCancel);
                            }
                        });

                        btnNextGame.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Intent intent = new Intent(PLAY.this, PlayMenuActivity.class);
                                startActivity(intent);
                            }
                        });

                    }else {
                       GAMEOVER();
                    }

                    luuDem.arrayListReply.clear();
                    luuDem.Diem = 0;
                    luuDem.dem = 0;
                }
            }
        });
    }

    private void GAMEOVER(){
        final Dialog dialogGameOver = new Dialog(PLAY.this);
        dialogGameOver.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogGameOver.setCanceledOnTouchOutside(true);
        dialogGameOver.setContentView(R.layout.dialog_gameover);
        dialogGameOver.show();

        TextView btnPlayNext = (TextView) dialogGameOver.findViewById(R.id.btnPlayNextGameOver);
        TextView btnLearn = (TextView) dialogGameOver.findViewById(R.id.btnLearn);
        btnPlayNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PLAY.this, PlayMenuActivity.class);
                startActivity(intent);
            }
        });
        btnLearn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentLearn = new Intent(PLAY.this, Practice_Vocabulary_Activity.class);
                startActivity(intentLearn);
            }
        });
    }

    private void DisplayInforUser() {
        mData.child("Users").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                mdUsers users = dataSnapshot.getValue(mdUsers.class);
                if (users.getMail().equalsIgnoreCase(mAuth.getCurrentUser().getEmail())) {
                    final String userID = mAuth.getCurrentUser().getUid();
                        Picasso.with(PLAY.this).load(users.getImg()).into(imgUserPlay);
                        tvNameUserPlay.setText(users.getName());
                        tvPointUserPlay.setText(users.getPoint() + "");
                }
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }


    private void initView() {
        tvTime = (TextView) findViewById(R.id.textTime);
        btn_Accept_Select = (ImageView) findViewById(R.id.btn_Accept_Select);
        imgUserPlay = (ImageView) findViewById(R.id.imgUserPlay);
        tvNameUserPlay = (TextView) findViewById(R.id.nameUserPlay);
        tvPointUserPlay = (TextView) findViewById(R.id.pointUserPlay);
        numberQuestion = (TextView) findViewById(R.id.numberQuestion);
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
                GAMEOVER();
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
