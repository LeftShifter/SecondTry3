package com.example.secondtry;

import android.app.Dialog;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;

import androidx.fragment.app.Fragment;

public class Exploration extends Fragment {

    private Button tech1;
    private Button tech2;
    private Button tech3;
    private Button tech4;
    private Button tech5;
    private Button tech6;
    private Button tech7;
    private Button tech8;
    private Button tech9;
    private Button tech10;
    private Button tech11;
    private Button tech12;

    public static final String KEY_FROM_EXPLORATION = "SecondTryKey";
    public static final String BROADCAST_ACTION_EXPLORATION = "SecondTry";

    public Exploration() {
        // Required empty public constructor
    }

    public void buyTry(int i) {


        IntentBox intentBox = new IntentBox(false,String.valueOf(i));

        Intent intent = new Intent(BROADCAST_ACTION_EXPLORATION);
        intent.putExtra(KEY_FROM_EXPLORATION,intentBox);
        getActivity().getApplicationContext().sendBroadcast(intent);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.exploration, container, false);

        tech1 = (Button) view.findViewById(R.id.tech1);
        tech2 = (Button) view.findViewById(R.id.tech2);
        tech3 = (Button) view.findViewById(R.id.tech3);
        tech4 = (Button) view.findViewById(R.id.tech4);
        tech5 = (Button) view.findViewById(R.id.tech5);
        tech6 = (Button) view.findViewById(R.id.tech6);
        tech7 = (Button) view.findViewById(R.id.tech7);
        tech8 = (Button) view.findViewById(R.id.tech8);
        tech9 = (Button) view.findViewById(R.id.tech9);
        tech10 = (Button) view.findViewById(R.id.tech10);
        tech11 = (Button) view.findViewById(R.id.tech11);
        tech12 = (Button) view.findViewById(R.id.tech12);


        {
            tech1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    buyTry(1);


                }
            });

            tech2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    buyTry(2);
                }
            });
            tech3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    buyTry(3);
                }
            });
            tech4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    buyTry(4);

                }
            });
            tech5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    buyTry(5);

                }
            });
            tech6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    buyTry(6);

                }
            });
            tech7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    buyTry(7);

                }
            });
            tech8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    buyTry(8);

                }
            });
            tech9.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    buyTry(9);

                }
            });
            tech10.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    buyTry(10);

                }
            });
            tech11.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    buyTry(11);

                }
            });
            tech12.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    buyTry(12);

                }
            });
            return view;
        }
    }


}

