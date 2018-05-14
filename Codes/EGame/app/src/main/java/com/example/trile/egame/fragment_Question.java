package com.example.trile.egame;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;

import com.example.trile.egame.Models.mdQuestion;
import com.example.trile.egame.Theme.MyRadioGroup;
import com.squareup.picasso.Picasso;

import java.io.Serializable;
import java.util.ArrayList;

public class fragment_Question extends android.support.v4.app.Fragment implements Serializable {

    Intent intent;
    Bundle bundle;
    private ImageView img_question;
    private RadioButton rdbA, rdbB, rdbC, rdbD;

    public fragment_Question() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_question_layout, container, false);

        img_question = view.findViewById(R.id.img_question);
        rdbA = view.findViewById(R.id.radA);
        rdbB = view.findViewById(R.id.radB);
        rdbC = view.findViewById(R.id.radC);
        rdbD = view.findViewById(R.id.radD);

        MyRadioGroup myRadioGroup = new MyRadioGroup(rdbA,rdbB,rdbC,rdbD);


        ArrayList<mdQuestion> mdQuestions = getActivity().getIntent().getParcelableArrayListExtra("random_question");

        Picasso.with(getContext()).load(mdQuestions.get(luuDem.dem).getImgQuestion()).into(img_question);
        rdbA.setText(mdQuestions.get(luuDem.dem).getArrayAnswer().get(0));
        rdbB.setText(mdQuestions.get(luuDem.dem).getArrayAnswer().get(1));
        rdbC.setText(mdQuestions.get(luuDem.dem).getArrayAnswer().get(2));
        rdbD.setText(mdQuestions.get(luuDem.dem).getArrayAnswer().get(3));

        rdbA.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (luuDem.arrayListReply.size() == 0)
                {
                    luuDem.arrayListReply.add(rdbA.getText().toString());
                }
                else if(ktTrung(luuDem.arrayListReply,rdbA.getText().toString()) == false)
                {
                    luuDem.arrayListReply.add(rdbA.getText().toString());
                }
            }
        });
        rdbB.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (luuDem.arrayListReply.size() == 0)
                {
                    luuDem.arrayListReply.add(rdbB.getText().toString());
                }
                else if(ktTrung(luuDem.arrayListReply,rdbB.getText().toString()) == false)
                {
                    luuDem.arrayListReply.add(rdbB.getText().toString());
                }
            }
        });
        rdbC.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (luuDem.arrayListReply.size() == 0)
                {
                    luuDem.arrayListReply.add(rdbC.getText().toString());
                }
                else if(ktTrung(luuDem.arrayListReply,rdbC.getText().toString()) == false)
                {
                    luuDem.arrayListReply.add(rdbC.getText().toString());
                }
            }
        });
        rdbD.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (luuDem.arrayListReply.size() == 0)
                {
                    luuDem.arrayListReply.add(rdbD.getText().toString());
                }
                else if(ktTrung(luuDem.arrayListReply,rdbD.getText().toString()) == false)
                {
                    luuDem.arrayListReply.add(rdbD.getText().toString());
                }
            }
        });

        if ( luuDem.dem == 9)
        {

        }
        return view;
    }

    public boolean ktTrung(ArrayList<String> strings, String chuoi) {
        boolean kt = false;
        for (int i = 0; i < strings.size(); i++) {
            if (strings.get(i).equalsIgnoreCase(chuoi)) {
                kt = true;
            }
        }
        return kt;
    }
}
