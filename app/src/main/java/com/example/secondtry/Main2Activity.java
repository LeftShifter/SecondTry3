package com.example.secondtry;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainer;
import androidx.fragment.app.FragmentManager;

import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.DragEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;

public class Main2Activity extends AppCompatActivity {
    private Button buttonChubriki;
    private Button buttonExploring;
    private TextView Mch;
    private TextView Sch;
    private Timer mTimer;
    private TextView Money;
    private TextView Science;
protected static Player player;
    public Dialog technologies;
    private Dialog BuyGenDialog;
    public Button technologiesAlertButton;
    public Button technologiesCloseButton;
    public TextView DialogDescription;
    private FragmentContainer fragmentContainer;
    private BroadcastReceiver ExpbroadcastReceiver;
    private Dialog RabotyagaDialog;
    private TextView Task;
    private int researchNumb;
    private final int timerInterval = 3000;
    private FrameLayout frameLayout;
    public static final String KEY_FROM_FRAGMENT = "SecondTryKey";
    private ImageButton button5;
    private ImageButton button6;
    private ImageButton button7;
    private ImageButton button10;
    private int CurrentChubrik;
    private Button GenDialogCancelButton;
    private Button GenDialogBuyButton;
    private TextView GenCost;
    private TextView GenDescription;
    private Gen gens[] = new Gen[10];
    private int genNumb;
    private View dragedItem;
    private Bitmap genPicture;
    private ImageButton vButton;
    private TextView technologiesCost;


    FragmentManager fm = getSupportFragmentManager ( );
    Fragment science = fm.findFragmentById (R.id.fragmentContainer);
    Fragment chubriki = fm.findFragmentById (R.id.fragmentContainer);


    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main2);

        for (int i = 0; i < gens.length; i++) {
            gens[i] = new Gen (i);
        }

        Mch = (TextView) findViewById (R.id.Mch);
        Sch = (TextView) findViewById (R.id.Sch);
        Money = (TextView) findViewById (R.id.money);
        Science = (TextView) findViewById (R.id.sciensepoints);

        player = new Player ( );

        Mch.setText (String.valueOf ((player.getMch ( ))));
        Sch.setText (String.valueOf (player.getSch ( )));
        Money.setText (String.valueOf (player.getMoney ( )));
        Science.setText (String.valueOf (player.getScience ( )));


        science = new Exploration ( );
        chubriki = new ChubrikiFragment ( );

        RabotyagaDialog = new Dialog (Main2Activity.this);
        RabotyagaDialog.requestWindowFeature (Window.FEATURE_NO_TITLE);
        RabotyagaDialog.getWindow ( ).setBackgroundDrawable (new ColorDrawable (Color.TRANSPARENT));
        RabotyagaDialog.setContentView (R.layout.fragment_chubriki_opend);
        technologies = new Dialog (Main2Activity.this);
        technologies.requestWindowFeature (Window.FEATURE_NO_TITLE);
        technologies.getWindow ( ).setBackgroundDrawable (new ColorDrawable (Color.TRANSPARENT));
        technologies.setContentView (R.layout.research_dialog);


        BuyGenDialog = new Dialog (Main2Activity.this);
        BuyGenDialog.setContentView (R.layout.gen_buy);

        fm.beginTransaction ( ).add (R.id.fragmentContainer, chubriki).commit ( );
        fm.beginTransaction ( ).detach (chubriki).commit ( );
        fm.beginTransaction ( ).add (R.id.fragmentContainer, science).commit ( );
        fm.beginTransaction ( ).detach (science).commit ( );


        buttonChubriki = (Button) findViewById (R.id.button4);
        buttonExploring = (Button) findViewById (R.id.button3);
        Task = (TextView) findViewById (R.id.textView4);
        DialogDescription = (TextView) technologies.findViewById (R.id.description);
        technologiesAlertButton = (Button) technologies.findViewById (R.id.alert_btn);
        technologiesCloseButton = (Button) technologies.findViewById (R.id.close_btn);

        class Timer extends CountDownTimer {
            public Timer ( ) {
                super (Integer.MAX_VALUE, timerInterval);
            }     //таймер статы меняет

            @Override
            public void onTick ( long millisUntilFinished ) {

                player.setMoney (player.getMch ( ) + player.getMoney ( ));
                player.setScience (player.getSch ( ) + player.getScience ( ));
                Mch.setText (String.valueOf ((player.getMch ( ))));
                Sch.setText (String.valueOf (player.getSch ( )));
                Money.setText (String.valueOf (player.getMoney ( )));
                Science.setText (String.valueOf (player.getScience ( )));
            }

            @Override
            public void onFinish ( ) {
            }
        }
        Timer t = new Timer ( );
        t.start ( );


        //фрагмент с технологиями вызываем
        buttonExploring.setOnClickListener (new View.OnClickListener ( ) {
            @Override
            public void onClick ( View v ) {

                if ( chubriki.isDetached ( ) == false ) {
                    fm.beginTransaction ( ).detach (chubriki).commit ( );
                }

                if ( science.isDetached ( ) == true ) {
                    fm.beginTransaction ( )
                            .attach (science).commit ( );


                }
            }
        });


//вызываем фрагмент с чубриками
        buttonChubriki.setOnClickListener (new View.OnClickListener ( ) {
            @Override
            public void onClick ( View v ) {

                FragmentManager fm = getSupportFragmentManager ( );

                if ( science.isDetached ( ) == false ) {
                    fm.beginTransaction ( ).detach (science).commit ( );
                }

                if ( chubriki.isDetached ( ) == true ) {
                    fm.beginTransaction ( )
                            .attach (chubriki)
                            .commit ( );


                }
            }
        });


//отлавливаем запрос на изучение технологиии
        ExpbroadcastReceiver = new BroadcastReceiver ( ) {
            @Override
            public void onReceive ( Context context, Intent intent ) {
                IntentBox researchBox = (IntentBox) intent.getSerializableExtra (KEY_FROM_FRAGMENT);
                if ( researchBox.fromChubriki == false ) {
                    researchNumb = Integer.parseInt (researchBox.stroka);
                    technologies.show ( );
                }


            }

        };
        IntentFilter Expfilter = new IntentFilter (Exploration.BROADCAST_ACTION_EXPLORATION);
        this.registerReceiver (ExpbroadcastReceiver, Expfilter);


//что то связанное с покупкой технологий и диаолгом

        DialogDescription.setText (player.getTechnologies (researchNumb).getDescription ( ));
        technologiesCost = (TextView) technologies.findViewById (R.id.technologies_cost);
        technologiesCost.setText (String.valueOf (player.getTechnologies (researchNumb).getCost ( )));
        technologiesCloseButton.setOnClickListener (new View.OnClickListener ( ) {
            @Override
            public void onClick ( View v ) {
                technologies.cancel ( );
            }
        });

        technologiesAlertButton.setOnClickListener (new View.OnClickListener ( ) {
            @Override
            public void onClick ( View v ) {


                if ( player.getScience ( ) > player.getTechnologies (researchNumb).getCost ( ) &&
                        player.getTechnologies (researchNumb).getResearched ( ) == false ) {
                    int playerCurs = player.getScience ( ) - player.getTechnologies (researchNumb).getCost ( );
                    player.setScience (playerCurs);
                    player.getTechnologies (researchNumb).setResearched (true);
                    Science.setText (String.valueOf (player.getScience ( )));
                    technologies.cancel ( );
                }
            }
        });
//тут уже ап чубриков и вся связанное с их модификацией


        button5 = (ImageButton) RabotyagaDialog.findViewById (R.id.button5);
        button6 = (ImageButton) RabotyagaDialog.findViewById (R.id.button6);
        button7 = (ImageButton) RabotyagaDialog.findViewById (R.id.button7);
        button10 = (ImageButton) RabotyagaDialog.findViewById (R.id.button10);


    }


    public void onDestroy ( ) {
        super.onDestroy ( );
        this.unregisterReceiver (this.ExpbroadcastReceiver);

    }


    public Player getPlayer ( ) {
        return player;
    }

    public Gen[] getGens ( ) {
        return gens;
    }

    public void setGens ( Gen[] gens ) {
        this.gens = gens;
    }

    public Dialog getRabotyagaDialog ( ) {
        return RabotyagaDialog;
    }

    public void setRabotyagaDialog ( Dialog rabotyagaDialog ) {
        RabotyagaDialog = rabotyagaDialog;
    }

    public Dialog getBuyGenDialog ( ) {
        return BuyGenDialog;
    }

    public void setBuyGenDialog ( Dialog buyGenDialog ) {
        BuyGenDialog = buyGenDialog;
    }


    public void startChubrik ( int CurrentChubrikNumb ) {

        CurrentChubrik = CurrentChubrikNumb;

        Intent intent = new Intent (Main2Activity.this, ChubrikCreationActivity.class);
        intent.putExtra ("player", player);
        startActivityForResult(intent,1);


//       ImageView picture = (ImageView)RabotyagaDialog.findViewById(R.id.chubric_picture);
//       picture.setImageResource(((Chubrik)player.getChubriki().get(CurrentChubrik)).getImageID());
//        TextView cost = (TextView)RabotyagaDialog.findViewById(R.id.cost);
//        TextView intelligence = (TextView)RabotyagaDialog.findViewById(R.id.intelligence);
//        TextView physycal = (TextView)RabotyagaDialog.findViewById(R.id.physical);
//        TextView loyalty = (TextView)RabotyagaDialog.findViewById(R.id.loyalty);
//        cost.setText("цена: "+String.valueOf(((Chubrik)player.getChubriki().get(CurrentChubrik)).getCost()));
//        intelligence.setText("умность: "+String.valueOf(((Chubrik)player.getChubriki().get(CurrentChubrik)).getIntelligence()));
//        loyalty.setText("верность: "+String.valueOf(((Chubrik)player.getChubriki().get(CurrentChubrik)).getLoyalt()));
//        physycal.setText("выносливость: "+String.valueOf(((Chubrik)player.getChubriki().get(CurrentChubrik)).getLoyalt()));
//        RabotyagaDialog.show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        Toast.makeText(this ,"куплено",Toast.LENGTH_LONG).show();
        Science.setText(String.valueOf(player.getScience()));
    }
}




