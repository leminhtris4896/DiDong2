package com.example.trile.egame.Theme;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.trile.egame.Adapter.AdapterLearn;
import com.example.trile.egame.Models.mdLearn;
import com.example.trile.egame.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class Theme1 extends AppCompatActivity {

    private Button play;
    private RecyclerView recyclerLearn;
    private AdapterLearn adapterLearn;
    private ArrayList<mdLearn> arrayLearn;
    private DatabaseReference mData;
    private FirebaseAuth mAuth;
    private ImageView close;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.theme1);

        // FIREBASE
        mData = FirebaseDatabase.getInstance().getReference();
        mAuth = FirebaseAuth.getInstance();
        // INITVIEW
        initView();

        close = (ImageView) findViewById(R.id.closeClose);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        /// RecyclerView 1
        GridLayoutManager layoutManager = new GridLayoutManager(getApplicationContext(), 1);
        recyclerLearn.setHasFixedSize(true);
        recyclerLearn.setLayoutManager(layoutManager);
        ///
        // mData.child("Hello").setValue("sdsdsdsds");
        arrayLearn = new ArrayList<mdLearn>();
//        arrayLearn.add(new mdLearn("https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/ando.png?alt=media&token=5423477a-4c16-48e9-a0ed-5071784bd836", "https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/India.wav?alt=media&token=230b5273-7771-49f6-be21-51555282de5c", "India", "/ˈɪndɪə/ ", "Ấn Độ", "India is the second most populous country in the world \n Ấn độ đông dân thứ 2 thế giới"));
//        arrayLearn.add(new mdLearn("https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/ANh.png?alt=media&token=34cd77b0-50bf-4116-bb5c-dc65740011c3", "https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/England.wav?alt=media&token=e39fdf28-3e31-466a-a1f3-199bf4ff7596", "England ", "/ˈɪŋglənd/ ", "Anh", "English uses English \n Nước anh sử dụng tiếng anh"));
//        arrayLearn.add(new mdLearn("https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/cambodia.png?alt=media&token=cb697192-9a99-4ae1-8db4-e243a60b91c3", "https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/Cambodia.wav?alt=media&token=45c1716e-105a-46e0-951d-8b0fe65eaedf", "Combodia", "/ Combodia /", "Campuchia", "Cambodia is the country where the oranges are divided \n Campuchia là nước có trái cam được chia"));
//        mData.child("Learn").setValue(arrayLearn);

        adapterLearn = new AdapterLearn(arrayLearn, getApplicationContext());
        recyclerLearn.setAdapter(adapterLearn);

        mData.child("Learn").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(final DataSnapshot dataSnapshot, String s) {
                long n = dataSnapshot.getChildrenCount();
                final mdLearn learn = dataSnapshot.getValue(mdLearn.class);
                arrayLearn.add(new mdLearn(learn.getImg(), learn.getMp3(), learn.getEng(), learn.getWrite(), learn.getViet(), learn.getCau()));
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

    private void initView() {
        recyclerLearn = (RecyclerView) findViewById(R.id.recyclerLearn);
    }


}
