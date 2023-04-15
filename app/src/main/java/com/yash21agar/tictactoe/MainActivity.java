package com.yash21agar.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.alphamovie.lib.AlphaMovieView;

public class MainActivity extends AppCompatActivity {

    private AlphaMovieView alphaMovieView;
    boolean gameActive = true;

    int activePlayer = 0;
    int[] gameState = {2,2,2,2,2,2,2,2,2};
    int[][] winPositions = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};

    public static int counter = 0;

    public void playerTap(View view){
        ImageView img = (ImageView) view;
        int tappedImage = Integer.parseInt(img.getTag().toString());

        if(!gameActive){
            gameReset(view);
        }
        if(gameState[tappedImage]==2){
            counter++;

            if(counter==9){
                gameActive=false;
                TextView player = findViewById(R.id.textView2);
                player.setText("Match Draw");
            }

            gameState[tappedImage]=activePlayer;

            if(activePlayer==0){
                img.setImageResource(R.drawable.x);
                activePlayer = 1;
                TextView player = findViewById(R.id.textView2);
                player.setText("Player2's Turn");

            }

            else{
                img.setImageResource(R.drawable.o);
                activePlayer = 0;
                TextView player = findViewById(R.id.textView2);
                player.setText("Player1's Turn");
            }
        }

        int flag = 0;

        for(int[] winPosition:winPositions){
            if(gameState[winPosition[0]] == gameState[winPosition[1]] && gameState[winPosition[1]] == gameState[winPosition[2]] && gameState[winPosition[0]] != 2){
                flag = 1;
                String winnerStr;

                gameActive =false;

                if(gameState[winPosition[0]]==0){
                    winnerStr = "Player 1 has Won";
                }
                else{
                    winnerStr = "Player 2 has Won";
                }

                TextView player = findViewById(R.id.textView2);
                player.setText(winnerStr);
            }
        }

        if(counter == 9 && flag == 0){
            TextView player = findViewById(R.id.textView2);
            player.setText("Match draw");
        }

    }

    public void gameReset(View view){
        gameActive = true;
        activePlayer = 0;
//        for(int i = 0; 1<gameState.length;i++){
//            gameState[i] = 2;
//        }

        ((ImageView) findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView8)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView9)).setImageResource(0);

        for(int i = 0; i<gameState.length;i++){
            gameState[i] = 2;
        }

        TextView player = findViewById(R.id.textView2);
        player.setText("Tap to Play");

    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}