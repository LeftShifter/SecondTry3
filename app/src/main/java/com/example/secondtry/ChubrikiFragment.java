package com.example.secondtry;


import android.app.Dialog;
import android.content.ClipData;
import android.content.ClipDescription;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class ChubrikiFragment extends Fragment {

    public static final String KEY_FROM_EXPLORATION = "SecondTryKey";
    public static final String BROADCAST_ACTION_EXPLORATION = "SecondTry";


    private Player player;


    public ChubrikiFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        player = ((Main2Activity) getActivity()).getPlayer();
        View view = inflater.inflate(R.layout.fragment_chubriki, container, false);

        ChubrikiAdapter1 chubrikiAdapter = new ChubrikiAdapter1(getContext(), ((Main2Activity) getActivity()).getPlayer().getChubriki(), ((Main2Activity) getActivity()).getRabotyagaDialog());
        ListView lv = (ListView)view.findViewById(R.id.listview1);
        lv.setAdapter(chubrikiAdapter);

        // SoldierButton.setOnClickListener(new View.OnClickListener() {
        //   @Override
        //    public void onClick(View v) {
        //        IntentBox intentBox = new IntentBox(true, String.valueOf(3));
        //  Intent intent = new Intent(BROADCAST_ACTION_EXPLORATION);
        //       intent.putExtra(KEY_FROM_EXPLORATION, intentBox);
        //   getActivity().getApplicationContext().sendBroadcast(intent);
        //    }
        //  });


        return view;

    }



}
