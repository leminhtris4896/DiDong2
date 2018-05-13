package com.example.trile.egame;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.trile.egame.MenuHome.PLAY;
import com.example.trile.egame.Models.mdQuestion;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

public class PlayMenuActivity extends AppCompatActivity implements Serializable {

    private ImageView imgPlayKim;
    private ImageView imgPlayMoc;
    private ImageView imgPlayThuy;
    private ImageView imgPlayHoa;
    private ImageView imgPlayTho;
    private DatabaseReference mData;
    private ArrayList<mdQuestion> questions;
    private ArrayList<mdQuestion> arrayListQuetionRandom;
    private Parcelable Parcels;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.play_menu_layout);

        questions = new ArrayList<>();
        arrayListQuetionRandom = new ArrayList<>();

        mData = FirebaseDatabase.getInstance().getReference();
        init();
        // PLAY KIM
        luuDem.dem = 0;
        imgPlayKim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mData.child("Question").addChildEventListener(new ChildEventListener() {
                    @Override
                    public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                        mdQuestion mdQuestion = dataSnapshot.getValue(com.example.trile.egame.Models.mdQuestion.class);
                        questions.add(mdQuestion);
                        if (questions.size() == 50) {
                            while (arrayListQuetionRandom.size() < 10) {
                                mdQuestion mdQuestionRanDom = questions.get(new Random().nextInt(questions.size()));
                                if (ktTrung(arrayListQuetionRandom, mdQuestionRanDom.getAnswer()) == false) {
                                    arrayListQuetionRandom.add(mdQuestionRanDom);
                                    //Toast.makeText(PlayMenuActivity.this, mdQuestionRanDom.getAnswer(), Toast.LENGTH_SHORT).show();
                                }
                            }
                            Intent intentKim = new Intent(PlayMenuActivity.this, PLAY.class);
                            intentKim.putParcelableArrayListExtra("random_question",  arrayListQuetionRandom);
                            startActivity(intentKim);
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
        });
        // PLAY MOC
        imgPlayMoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mData.child("Question").addChildEventListener(new ChildEventListener() {
                    @Override
                    public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                        mdQuestion mdQuestion = dataSnapshot.getValue(com.example.trile.egame.Models.mdQuestion.class);
                        questions.add(mdQuestion);
                        if (questions.size() == 50) {
                            while (arrayListQuetionRandom.size() < 10) {
                                mdQuestion mdQuestionRanDom = questions.get(new Random().nextInt(questions.size()));
                                if (ktTrung(arrayListQuetionRandom, mdQuestionRanDom.getAnswer()) == false) {
                                    arrayListQuetionRandom.add(mdQuestionRanDom);
                                    //Toast.makeText(PlayMenuActivity.this, mdQuestionRanDom.getAnswer(), Toast.LENGTH_SHORT).show();
                                }
                            }
                            Intent intentKim = new Intent(PlayMenuActivity.this, PLAY.class);
                            intentKim.putParcelableArrayListExtra("random_question",  arrayListQuetionRandom);
                            startActivity(intentKim);
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
        });
        // PLAY THUY
        imgPlayThuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mData.child("Question").addChildEventListener(new ChildEventListener() {
                    @Override
                    public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                        mdQuestion mdQuestion = dataSnapshot.getValue(com.example.trile.egame.Models.mdQuestion.class);
                        questions.add(mdQuestion);
                        if (questions.size() == 50) {
                            while (arrayListQuetionRandom.size() < 10) {
                                mdQuestion mdQuestionRanDom = questions.get(new Random().nextInt(questions.size()));
                                if (ktTrung(arrayListQuetionRandom, mdQuestionRanDom.getAnswer()) == false) {
                                    arrayListQuetionRandom.add(mdQuestionRanDom);
                                    //Toast.makeText(PlayMenuActivity.this, mdQuestionRanDom.getAnswer(), Toast.LENGTH_SHORT).show();
                                }
                            }
                            Intent intentKim = new Intent(PlayMenuActivity.this, PLAY.class);
                            intentKim.putParcelableArrayListExtra("random_question",  arrayListQuetionRandom);
                            startActivity(intentKim);
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
        });
        // PLAY HOA
        imgPlayHoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mData.child("Question").addChildEventListener(new ChildEventListener() {
                    @Override
                    public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                        mdQuestion mdQuestion = dataSnapshot.getValue(com.example.trile.egame.Models.mdQuestion.class);
                        questions.add(mdQuestion);
                        if (questions.size() == 50) {
                            while (arrayListQuetionRandom.size() < 10) {
                                mdQuestion mdQuestionRanDom = questions.get(new Random().nextInt(questions.size()));
                                if (ktTrung(arrayListQuetionRandom, mdQuestionRanDom.getAnswer()) == false) {
                                    arrayListQuetionRandom.add(mdQuestionRanDom);
                                    //Toast.makeText(PlayMenuActivity.this, mdQuestionRanDom.getAnswer(), Toast.LENGTH_SHORT).show();
                                }
                            }
                            Intent intentKim = new Intent(PlayMenuActivity.this, PLAY.class);
                            intentKim.putParcelableArrayListExtra("random_question",  arrayListQuetionRandom);
                            startActivity(intentKim);
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
        });
        // PLAY THO
        imgPlayTho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mData.child("Question").addChildEventListener(new ChildEventListener() {
                    @Override
                    public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                        mdQuestion mdQuestion = dataSnapshot.getValue(com.example.trile.egame.Models.mdQuestion.class);
                        questions.add(mdQuestion);
                        if (questions.size() == 50) {
                            while (arrayListQuetionRandom.size() < 10) {
                                mdQuestion mdQuestionRanDom = questions.get(new Random().nextInt(questions.size()));
                                if (ktTrung(arrayListQuetionRandom, mdQuestionRanDom.getAnswer()) == false) {
                                    arrayListQuetionRandom.add(mdQuestionRanDom);
                                    //Toast.makeText(PlayMenuActivity.this, mdQuestionRanDom.getAnswer(), Toast.LENGTH_SHORT).show();
                                }
                            }
                            Intent intentKim = new Intent(PlayMenuActivity.this, PLAY.class);
                            intentKim.putParcelableArrayListExtra("random_question",  arrayListQuetionRandom);
                            startActivity(intentKim);
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
        });
    }

    private void init() {
        imgPlayKim = (ImageView) findViewById(R.id.playKim);
        imgPlayMoc = (ImageView) findViewById(R.id.playMoc);
        imgPlayThuy = (ImageView) findViewById(R.id.playThuy);
        imgPlayHoa = (ImageView) findViewById(R.id.playHoa);
        imgPlayTho = (ImageView) findViewById(R.id.playTho);
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
