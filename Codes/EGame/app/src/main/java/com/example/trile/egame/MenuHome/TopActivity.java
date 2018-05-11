package com.example.trile.egame.MenuHome;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.example.trile.egame.Adapter.AdapterTop;
import com.example.trile.egame.Models.mdTop;
import com.example.trile.egame.R;

import java.util.ArrayList;

public class TopActivity extends AppCompatActivity {


    private ImageView imgCLOSETOP;
    // Array of TopLocation
    private ArrayList<mdTop> arrTop;
    private AdapterTop adapterTop;
    private RecyclerView recyclerTop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.top_layout);
        // Ánh xạ
        init();
        imgCLOSETOP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentCloseTop = new Intent(TopActivity.this,HomeActivity.class);
                startActivity(intentCloseTop);
            }
        });
        // Danh sách
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL,false);
        recyclerTop.setHasFixedSize(true);
        recyclerTop.setLayoutManager(layoutManager);
        // Mảng
        array();
        // Set Adapter
        adapterTop = new AdapterTop(arrTop,getApplicationContext());
        recyclerTop.setAdapter(adapterTop);
        recyclerTop.addOnItemTouchListener(new RecyclerView.SimpleOnItemTouchListener());
    }

    private void array() {
        arrTop = new ArrayList<mdTop>();

        arrTop.add(new mdTop(R.mipmap.archibald,"Nguyễn Phúc Toàn","789"));
        arrTop.add(new mdTop(R.mipmap.layla,"Lay La","789"));
        arrTop.add(new mdTop(R.mipmap.alvar,"Hoàng Nhật Sơn","456"));
        arrTop.add(new mdTop(R.mipmap.flora,"Flora","456"));
        arrTop.add(new mdTop(R.mipmap.rose,"Rose","456"));
        arrTop.add(new mdTop(R.mipmap.azure,"Lê Thị Kim Ngân","123"));
        arrTop.add(new mdTop(R.mipmap.alger,"Lê Minh Trí","123"));
        arrTop.add(new mdTop(R.mipmap.lily,"Li Ly","123"));
    }

    private void init() {
        recyclerTop = (RecyclerView) findViewById(R.id.recyclerTop);
        imgCLOSETOP = (ImageView) findViewById(R.id.closeTOP);
    }
}
