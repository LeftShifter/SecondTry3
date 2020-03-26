package com.example.secondtry;

import androidx.appcompat.app.AppCompatActivity;
import androidx.gridlayout.widget.GridLayout;

import android.app.Dialog;
import android.content.ClipData;
import android.content.ClipDescription;
import android.content.ContentValues;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.DragEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ChubrikCreationActivity extends AppCompatActivity implements View.OnLongClickListener,View.OnDragListener{

    private ArrayList<Gen> gens;
    private Dialog isCreated;
    private int genNumb;
    private View dragedItem;
    private ImageButton vButton;
    private Bitmap genPicture;
    private Dialog BuyGenDialog;
    private int CurrentChubrik;
    private Button GenDialogCancelButton;
    private Button GenDialogBuyButton;
    private TextView GenCost;
    private TextView GenDescription;
    private Player player;
    private Chubrik chubrik;


    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
       player=Main2Activity.player;
        BuyGenDialog = new Dialog(ChubrikCreationActivity.this);
        BuyGenDialog.setContentView(R.layout.gen_buy);
        gens = new ArrayList<> ();
        for (int i = 0; i < 8 ; i++) {
            gens.add (new Gen(i));
        }
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_chubrik_creation);
        isCreated = new Dialog (ChubrikCreationActivity.this);
         isCreated.setContentView (R.layout.is_chubrik_created);
        System.out.println (findViewById (R.id.chubrik_gens).getClass ());
       final GridLayout chubrikGens = (GridLayout)findViewById (R.id.chubrik_gens);
       for(int i = 0;i<chubrikGens.getChildCount ();i++){
           chubrikGens.getChildAt (i).setOnDragListener (this);
       }
        ImageButton imageButton1 = (ImageButton)findViewById(R.id.imageButton);
        ((ImageButton)findViewById(R.id.imageButton)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chubrik.setImageID(R.drawable.rabotyaga);
            }
        });
        ImageButton imageButton2 = (ImageButton)findViewById(R.id.imageButton);
        ((ImageButton)findViewById(R.id.imageButton)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chubrik.setImageID(R.drawable.umnik);
            }
        });
        ImageButton imageButton3 = (ImageButton)findViewById(R.id.imageButton);
        ((ImageButton)findViewById(R.id.imageButton)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chubrik.setImageID(R.drawable.soldier);
            }
        });


       chubrik = (Chubrik) (player.getChubriki()).get(CurrentChubrik);

        ((Button)findViewById (R.id.close_button)).setOnClickListener (new View.OnClickListener ( ) {
          @Override
           public void onClick ( View v ) {
                isCreated.show ();
            }
       });

        ((Button)isCreated.findViewById (R.id.cancel_create_chubrik)).setOnClickListener (new View.OnClickListener ( ) {
            @Override
            public void onClick ( View v ) {
                isCreated.cancel ();
                finish ();
            }
        });
        LinearLayout linearLayout = (LinearLayout)findViewById (R.id.gen_layout);
        for(int i = 0;i < gens.size();i++){
            ImageButton genButton = new ImageButton (this);
            genButton.setLayoutParams (new LinearLayout.LayoutParams (100,100));
            genButton.setImageResource (R.drawable.soldier2);
            genButton.setOnLongClickListener (this);
            genButton.setTag (String.valueOf (i));
            linearLayout.addView (genButton);
        }



    }

    public boolean onDrag(View v, DragEvent event) {
        int action = event.getAction();
        // Handles each of the expected events
        switch (action) {

            case DragEvent.ACTION_DRAG_STARTED:
                // Determines if this View can accept the dragged data
                if (event.getClipDescription().hasMimeType(ClipDescription.MIMETYPE_TEXT_PLAIN)) {
                    // if you want to apply color when drag started to your view you can uncomment below lines
                    // to give any color tint to the View to indicate that it can accept data.
                    // v.getBackground().setColorFilter(Color.BLUE, PorterDuff.Mode.SRC_IN);
                    // Invalidate the view to force a redraw in the new tint
                    //  v.invalidate();
                    // returns true to indicate that the View can accept the dragged data.
                    return true;
                }
                // Returns false. During the current drag and drop operation, this View will
                // not receive events again until ACTION_DRAG_ENDED is sent.
                return false;

            case DragEvent.ACTION_DRAG_ENTERED:
                // Applies a GRAY or any color tint to the View. Return true; the return value is ignored.

                // Invalidate the view to force a redraw in the new tint
                v.invalidate();
                return true;

            case DragEvent.ACTION_DRAG_LOCATION:
                // Ignore the event
                return true;

            case DragEvent.ACTION_DRAG_EXITED:
                // Re-sets the color tint to blue. Returns true; the return value is ignored.
                // view.getBackground().setColorFilter(Color.BLUE, PorterDuff.Mode.SRC_IN);
                //It will clear a color filter .

                // Invalidate the view to force a redraw in the new tint
                v.invalidate();
                return true;

            case DragEvent.ACTION_DROP:
                // Gets the item containing the dragged data
                ClipData.Item item = event.getClipData().getItemAt(0);
                genNumb = Integer.parseInt(item.getText().toString());
                // Gets the text data from the item.
                final String dragData = item.getText().toString();
                // Displays a message containing the dragged data.
                Toast.makeText(this, "Dragged data is " + dragData, Toast.LENGTH_SHORT).show();
                // Turns off any color tints

                // Invalidates the view to force a redraw
                v.invalidate();


                dragedItem = (View) event.getLocalState();
                vButton = (ImageButton) v;
                ImageButton imageButton2 = (ImageButton) dragedItem;
                genPicture = ((BitmapDrawable) imageButton2.getDrawable()).getBitmap();
                BuyGenDialog.show();
                GenDialogBuyButton = (Button) BuyGenDialog.findViewById(R.id.buy_button);
                GenDialogCancelButton = (Button) BuyGenDialog.findViewById(R.id.cancel_buy);
                GenDialogCancelButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        BuyGenDialog.cancel();
                    }
                });
                GenDescription = (TextView) BuyGenDialog.findViewById(R.id.description);
                GenCost = (TextView) BuyGenDialog.findViewById(R.id.gen_cost);
                GenDescription.setText(gens.get(genNumb).getDescritpion());
                GenDialogBuyButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                            buyGen(genNumb, 0);
                    }
                });





                return true;


            //  ViewGroup owner = (ViewGroup) vw.getParent();
            //  owner.removeView(vw); //remove the dragged view
            //caste the view into LinearLayout as our drag acceptable layout is LinearLayout


            case DragEvent.ACTION_DRAG_ENDED:
                // Turns off any color tinting

                // Invalidates the view to force a redraw
                v.invalidate();
                // Does a getResult(), and displays what happened.
                if (event.getResult())
                    Toast.makeText(this, "The drop was handled.", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(this, "The drop didn't work.", Toast.LENGTH_SHORT).show();
                // returns true; the value is ignored.
                return true;

            //LinearLayout container = (LinearLayout) v;
            //  container.addView(vw);//Add the dragged view

            // An unknown action type was received.
            default:
                Log.e("DragDrop Example", "Unknown action type received by OnDragListener.");
                break;
        }
        return false;
    }

    @Override
    public boolean onLongClick(View v) {
        ClipData.Item item = new ClipData.Item((CharSequence) v.getTag());
        // Create a new ClipData using the tag as a label, the plain text MIME type, and
        // the already-created item. This will create a new ClipDescription object within the
        // ClipData, and set its MIME type entry to "text/plain"
        String[] mimeTypes = {ClipDescription.MIMETYPE_TEXT_PLAIN};
        ClipData data = new ClipData(v.getTag().toString(), mimeTypes, item);
        // Instantiates the drag shadow builder.
        View.DragShadowBuilder dragshadow = new View.DragShadowBuilder(v);
        // Starts the drag
        v.startDrag(data        // data to be dragged
                , dragshadow   // drag shadow builder
                , v           // local data about the drag and drop operation
                , 0          // flags (not currently used, set to 0)
        );
        return true;
    }



    public void buyGen(int numb, int genNumb) {
        if (gens.get(genNumb).getCost() < player.getScience()) {
            chubrik.setGen(gens.get(genNumb),numb);
            player.setScience(player.getScience() - gens.get(genNumb).getCost());
            GenDescription.setText(gens.get(genNumb).getDescritpion());
            GenCost.setText(String.valueOf(gens.get(genNumb).getCost()));
            BuyGenDialog.cancel();
            vButton.setImageBitmap(genPicture);
            dragedItem.setVisibility(View.INVISIBLE);
            OpenHelper openHelper= new OpenHelper(this);
            openHelper.getWritableDatabase();
            ContentValues cv = new ContentValues();
            String name = String.valueOf((((EditText)findViewById(R.id.name)).getText()));
            cv.put("_id",chubrik.getId());
            cv.put("name",name);
            cv.put("image_id",chubrik.getImageID());
            cv.put("gen1",chubrik.getGen()[0].getId());
            cv.put("gen2",chubrik.getGen()[1].getId());
            cv.put("gen3",chubrik.getGen()[2].getId());
            cv.put("gen4",chubrik.getGen()[3].getId());
            cv.put("gen5",chubrik.getGen()[4].getId());
            cv.put("gen6",chubrik.getGen()[5].getId());
            finish ();
        }

    }

}
