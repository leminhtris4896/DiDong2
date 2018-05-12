package com.example.trile.egame.Theme;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.trile.egame.Adapter.AdapterLearn;
import com.example.trile.egame.MenuHome.HomeActivity;
import com.example.trile.egame.MenuHome.Practice_Vocabulary_Activity;
import com.example.trile.egame.Models.mdLearn;
import com.example.trile.egame.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class Theme_Animal extends AppCompatActivity {

    private Button play;
    private RecyclerView recyclerLearn;
    private AdapterLearn adapterLearn;
    private ArrayList<mdLearn> arrayLearn;
    private DatabaseReference mData;
    private FirebaseAuth mAuth;
    private ImageView close;
    private ImageView imgCLodeThemDetail;
    Intent intent;
    Bundle bundle;

    private ArrayList<mdLearn> learnArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.theme_detail_all);

        // FIREBASE
        mData = FirebaseDatabase.getInstance().getReference();
        mAuth = FirebaseAuth.getInstance();
        // INITVIEW
        initView();

        intent = getIntent();
        bundle = intent.getBundleExtra("bundle");
        String key_theme = bundle.getString("theme_all");

        if (key_theme.equalsIgnoreCase("animal")) {
            LoadDataAnimal();
        } else if (key_theme.equalsIgnoreCase("study")) {
            LoadDataStudy();
        }
        else if (key_theme.equalsIgnoreCase("family")) {
            LoadDataFamily();
        }
        else if (key_theme.equalsIgnoreCase("object")) {
            LoadDataObject();
        }
        else if (key_theme.equalsIgnoreCase("country")) {
            LoadDataCountry();
        }
        else if (key_theme.equalsIgnoreCase("transport")) {
            LoadDataTransport();
        }


        imgCLodeThemDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentCloseTheme = new Intent(Theme_Animal.this, Practice_Vocabulary_Activity.class);
                startActivity(intentCloseTheme);
            }
        });
    }

    private void initView() {
        recyclerLearn = (RecyclerView) findViewById(R.id.recyclerLearn);
        imgCLodeThemDetail = (ImageView) findViewById(R.id.btn_Close_Theme_Detail);
    }

    public void LoadDataAnimal() {

        GridLayoutManager layoutManager = new GridLayoutManager(getApplicationContext(), 1);
        recyclerLearn.setHasFixedSize(true);
        recyclerLearn.setLayoutManager(layoutManager);

        learnArrayList = new ArrayList<>();
        adapterLearn = new AdapterLearn(learnArrayList, Theme_Animal.this);
        recyclerLearn.setAdapter(adapterLearn);

        mData.child("Animal").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                mdLearn mdLearn = dataSnapshot.getValue(com.example.trile.egame.Models.mdLearn.class);
                learnArrayList.add(new mdLearn(mdLearn.getImg(), mdLearn.getMp3(), mdLearn.getEng(), mdLearn.getWrite(), mdLearn.getViet(), mdLearn.getCau(), mdLearn.getType()));
                adapterLearn.notifyDataSetChanged();
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

    public void LoadDataStudy() {
        GridLayoutManager layoutManager = new GridLayoutManager(getApplicationContext(), 1);
        recyclerLearn.setHasFixedSize(true);
        recyclerLearn.setLayoutManager(layoutManager);

        learnArrayList = new ArrayList<>();
        adapterLearn = new AdapterLearn(learnArrayList, Theme_Animal.this);
        recyclerLearn.setAdapter(adapterLearn);

        mData.child("Study").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                mdLearn mdLearn = dataSnapshot.getValue(com.example.trile.egame.Models.mdLearn.class);
                learnArrayList.add(new mdLearn(mdLearn.getImg(), mdLearn.getMp3(), mdLearn.getEng(), mdLearn.getWrite(), mdLearn.getViet(), mdLearn.getCau(), mdLearn.getType()));
                adapterLearn.notifyDataSetChanged();
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

    public void LoadDataFamily() {
        GridLayoutManager layoutManager = new GridLayoutManager(getApplicationContext(), 1);
        recyclerLearn.setHasFixedSize(true);
        recyclerLearn.setLayoutManager(layoutManager);

        learnArrayList = new ArrayList<>();
        adapterLearn = new AdapterLearn(learnArrayList, Theme_Animal.this);
        recyclerLearn.setAdapter(adapterLearn);

        mData.child("Family").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                mdLearn mdLearn = dataSnapshot.getValue(com.example.trile.egame.Models.mdLearn.class);
                learnArrayList.add(new mdLearn(mdLearn.getImg(), mdLearn.getMp3(), mdLearn.getEng(), mdLearn.getWrite(), mdLearn.getViet(), mdLearn.getCau(), mdLearn.getType()));
                adapterLearn.notifyDataSetChanged();
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

    public void LoadDataObject() {
        GridLayoutManager layoutManager = new GridLayoutManager(getApplicationContext(), 1);
        recyclerLearn.setHasFixedSize(true);
        recyclerLearn.setLayoutManager(layoutManager);

        learnArrayList = new ArrayList<>();
        adapterLearn = new AdapterLearn(learnArrayList, Theme_Animal.this);
        recyclerLearn.setAdapter(adapterLearn);

        mData.child("Object").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                mdLearn mdLearn = dataSnapshot.getValue(com.example.trile.egame.Models.mdLearn.class);
                learnArrayList.add(new mdLearn(mdLearn.getImg(), mdLearn.getMp3(), mdLearn.getEng(), mdLearn.getWrite(), mdLearn.getViet(), mdLearn.getCau(), mdLearn.getType()));
                adapterLearn.notifyDataSetChanged();
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

    public void LoadDataCountry() {
        GridLayoutManager layoutManager = new GridLayoutManager(getApplicationContext(), 1);
        recyclerLearn.setHasFixedSize(true);
        recyclerLearn.setLayoutManager(layoutManager);

        learnArrayList = new ArrayList<>();
        adapterLearn = new AdapterLearn(learnArrayList, Theme_Animal.this);
        recyclerLearn.setAdapter(adapterLearn);

        mData.child("Country").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                mdLearn mdLearn = dataSnapshot.getValue(com.example.trile.egame.Models.mdLearn.class);
                learnArrayList.add(new mdLearn(mdLearn.getImg(), mdLearn.getMp3(), mdLearn.getEng(), mdLearn.getWrite(), mdLearn.getViet(), mdLearn.getCau(), mdLearn.getType()));
                adapterLearn.notifyDataSetChanged();
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

    public void LoadDataTransport() {
        GridLayoutManager layoutManager = new GridLayoutManager(getApplicationContext(), 1);
        recyclerLearn.setHasFixedSize(true);
        recyclerLearn.setLayoutManager(layoutManager);

        learnArrayList = new ArrayList<>();
        adapterLearn = new AdapterLearn(learnArrayList, Theme_Animal.this);
        recyclerLearn.setAdapter(adapterLearn);

        mData.child("Transport").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                mdLearn mdLearn = dataSnapshot.getValue(com.example.trile.egame.Models.mdLearn.class);
                learnArrayList.add(new mdLearn(mdLearn.getImg(), mdLearn.getMp3(), mdLearn.getEng(), mdLearn.getWrite(), mdLearn.getViet(), mdLearn.getCau(), mdLearn.getType()));
                adapterLearn.notifyDataSetChanged();
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
}

