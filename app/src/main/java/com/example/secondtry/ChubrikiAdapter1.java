package com.example.secondtry;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

import static com.example.secondtry.ChubrikiFragment.BROADCAST_ACTION_EXPLORATION;

public class ChubrikiAdapter1 extends ArrayAdapter {
    Dialog chubrikDialog;
    private String KEY_FROM_EXPLORATION;
    public static final String BROADCAST_ACTION_EXPLORATION = "SecondTry";
    private Button RabotyagaButton;
    private Button SoldierButton;
    private Button UmnikButoon;
    private View view;
    private ImageButton buttonClose;
    private View dragedItem;
    private Bitmap genPicture;
    private ImageButton vButton;
    private Dialog BuyGenDialog;
    private Button GenDialogBuyButton;
    private Button GenDialogCancelButton;
    private TextView GenDescription;
    private TextView GenCost;
    private int genNumb;
    private Player player;
    private Gen[] gens;
    private ImageButton button5;
    private ImageButton button6;
    private ImageButton button7;
    private ImageButton button10;
    private Dialog  RabotyagaDialog;





    public ChubrikiAdapter1(@NonNull Context context, ArrayList arr , Dialog chubrikDialog) {
        super(context,R.layout.adapter_chubrik,arr);
        this.chubrikDialog = chubrikDialog;
    }

    public View getView(final int position, View convertView, ViewGroup parent) {

        final Chubrik chubrik = (Chubrik) getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.adapter_chubrik, null);
        }

        ((Button) convertView.findViewById(R.id.button5)).setText(chubrik.getName());
        Drawable top = getContext ().getResources().getDrawable(chubrik.getImageID ());
        ((Button) convertView.findViewById(R.id.button5)).setCompoundDrawablesWithIntrinsicBounds(null, top , null, null);


// Выбираем картинку для месяца


        Button button = (Button) convertView.findViewById(R.id.button5);







        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                ((Main2Activity)getContext()).startChubrik(position);


            }
        });
        return convertView;

    }
}
