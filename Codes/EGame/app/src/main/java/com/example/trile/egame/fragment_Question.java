package com.example.trile.egame;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;

import com.example.trile.egame.Models.mdQuestion;
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


        ArrayList<mdQuestion> mdQuestions = getActivity().getIntent().getParcelableArrayListExtra("random_question");

        ArrayList<mdQuestion> mdQuestions1 = mdQuestions;


           //String dem = bundle.getString("dem");
           //demint = Integer.parseInt(dem);
           Picasso.with(getContext()).load(mdQuestions1.get(luuDem.dem).getImgQuestion()).into(img_question);
           rdbA.setText(mdQuestions1.get(luuDem.dem).getArrayAnswer().get(0));
           rdbB.setText(mdQuestions1.get(luuDem.dem).getArrayAnswer().get(1));
           rdbC.setText(mdQuestions1.get(luuDem.dem).getArrayAnswer().get(2));
           rdbD.setText(mdQuestions1.get(luuDem.dem).getArrayAnswer().get(3));


        //intentarray = (Intent) ;

        return view;
    }
}
