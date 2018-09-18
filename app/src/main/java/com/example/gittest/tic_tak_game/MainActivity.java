package com.example.gittest.tic_tak_game;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageView red_end_2;
    Button playagain;
    TextView win;
    GridLayout myGridView;
    int[] state = {2, 2, 2, 2, 2, 2, 2, 2, 2};
    int[][] winningpositions = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}};
    boolean active = true;
    // yellow 0; red 1 , 2 empty;
    int activeplayer = 0;

    public void tap(View view) {

        ImageView count = (ImageView) view;
        count.setTranslationY(-1500);
        int tapcount = Integer.parseInt(count.getTag().toString());

        if (state[tapcount] == 2 && active) {
            state[tapcount] = activeplayer;

            count.setTranslationY(-1500);

        if (activeplayer == 0) {
            count.setImageResource(R.drawable.yellow);
            activeplayer = 1;
        } else {
            count.setImageResource(R.drawable.red);
            activeplayer = 0;
        }

        count.animate().translationYBy(1500).rotation(3600).setDuration(300);
        for (int[] winningpositions : winningpositions) {
            if (state[winningpositions[0]] == state[winningpositions[1]] &&
                    state[winningpositions[1]] == state[winningpositions[2]] && state[winningpositions[0]] != 2) {


                //someone has won
                active = false;
                String winner = " ";
                if (activeplayer == 1) {
                    winner = "Yellow";
                } else {
                    winner = "Red";
                }
                // Toast.makeText(this, winner+ "You Win!", Toast.LENGTH_SHORT).show();
                playagain = (Button) findViewById(R.id.bt_playagain);
                // red_end_2=findViewById(R.id.imageView_red_8);
                win = (TextView) findViewById(R.id.tv_win);
                win.setText(winner + " has won!");
                playagain.setVisibility(View.VISIBLE);
                win.setVisibility(View.VISIBLE);
            }
        }
    }

}
            public void playAgain(View view){

                playagain = (Button) findViewById(R.id.bt_playagain);
                win = (TextView) findViewById(R.id.tv_win);

                playagain.setVisibility(View.INVISIBLE);
                win.setVisibility(View.INVISIBLE);
                myGridView = (GridLayout) findViewById(R.id.gridLayout);
                for (int i = 0; i < myGridView.getChildCount(); i++) {

                    TextView child = (TextView) myGridView.getChildAt(i);
                    ImageView count = (ImageView) myGridView.getChildAt(i);
                    count.setImageDrawable(null);
                }


                for (int i = 0; i < state.length; i++) {

                    state[i] = 2;

                }

                activeplayer = 0;

                active = true;
            }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

    }
}
