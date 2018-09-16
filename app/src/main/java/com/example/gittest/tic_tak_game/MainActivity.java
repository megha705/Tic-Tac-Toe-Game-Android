package com.example.gittest.tic_tak_game;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageView red_end_2;

    int [] state= {2,2,2,2,2,2,2,2,2};
    int [][] winningpositions= {{1,2,3},{4,5,6},{7,8,9},{1,5,9},{3,5,7},{1,4,7},{3,6,9}};
    boolean active= true;
    // yellow 0; red 1 , 2 empty;
    int activeplayer = 0;
    public void tap(View view) {

        ImageView count = (ImageView) view;
        count.setTranslationY(-1500);
        int tapcount=Integer.parseInt(count.getTag().toString());
        if(state[tapcount] == 2 && active){
            state[tapcount] =activeplayer;
            count.setTranslationY(-1500);
        }
        if (activeplayer == 0) {
            count.setImageResource(R.drawable.yellow);
            activeplayer = 1;
        } else {
            count.setImageResource(R.drawable.red);
            activeplayer = 0;
        }

        count.animate().translationYBy(1500).rotation(3600).setDuration(300);
        for( int [] winningpositions : winningpositions){
            if (state[winningpositions[0]] == state[winningpositions[1]] &&
                     state[winningpositions[1]]== state[winningpositions[2]] && state[winningpositions[0]]!=2);

            //someone has won
            active =false;
            String winner="";
            if(activeplayer == 1){
                winner ="Yellow";
            }
            else {
                winner ="Red";
            }
            Toast.makeText(this, winner+ "You Win!", Toast.LENGTH_SHORT).show();

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        red_end_2=findViewById(R.id.imageView_red_8);

    }
}
