package com.example.anshulsharma.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int active=0;
    int[] unplayed={2,2,2,2,2,2,2,2,2};
    String y="Yellow player wins";
    String r="Red player wins";
    int[][] positions={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{2,4,7},{3,5,8},{0,4,8},{3,4,6}};
    public void dropin(View view) {

        ImageView counter = (ImageView) view;

        int attempted = Integer.parseInt(counter.getTag().toString());
        if (unplayed[attempted] == 2) {
            unplayed[attempted] = active;
            counter.setTranslationY(-1000);
            if (active == 0) {
                counter.setImageResource(R.drawable.yellow);
                active++;
            } else {
                counter.setImageResource(R.drawable.red);
                active--;
            }

            counter.animate().translationYBy(1000).rotation(360).setDuration(300);


            for (int[] winner : positions) {

                if (unplayed[winner[0]] == unplayed[winner[1]] && unplayed[winner[1]] == unplayed[winner[2]] && unplayed[winner[0]] != 2) {
                    TextView message=findViewById(R.id.winnerMessage);
                    if (unplayed[winner[0]] == 0)
                        message.setText(y);
                    else
                        message.setText(r);

                    LinearLayout vertical=findViewById(R.id.playAgain);
                    vertical.setVisibility(View.VISIBLE);
                }

            }
        }
    }


        public void reset(View view){

            LinearLayout vertical=findViewById(R.id.playAgain);
            vertical.setVisibility(View.INVISIBLE);
            active=0;
            for(int i=0;i<unplayed.length;i++){
                unplayed[i]=2;
            }
            GridLayout again=findViewById(R.id.grid);
            for(int i=0;i<again.getChildCount();i++) {
                ((ImageView) again.getChildAt(i)).setImageResource(0);
            }
            }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
