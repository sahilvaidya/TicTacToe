package com.example.sahil.ticedtacedtoed;

import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public String turn;
    int[] arr={0,0,0,0,0,0,0,0,0};
    public boolean canClick;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        turn="red";
        canClick=true;

    }
    public void onClick(View view){
        restart();
        canClick=true;
        LinearLayout gameOver = (LinearLayout) findViewById(R.id.playAgainLayout);

        gameOver.setVisibility(View.INVISIBLE);


    }
    public void myOnClickMethod(View view){
        if(canClick) {
            ImageView myPiece = (ImageView) view;
            int myTag = Integer.parseInt(myPiece.getTag().toString());
            if (arr[myTag] == 0) {
                myPiece.setTranslationY(-1000);

                if (turn.equals("yellow")) {
                    arr[myTag] = 2;
                    myPiece.setImageResource(R.drawable.yellow);
                    turn = "red";
                } else if (turn.equals("red")) {
                    arr[myTag] = 1;
                    myPiece.setImageResource(R.drawable.red);
                    turn = "yellow";
                }
                myPiece.animate().translationYBy(1000).rotation(180f).setDuration(1000);
            }
        }
        TextView overMessage = (TextView) findViewById(R.id.overMessage);
        final LinearLayout gameOver = (LinearLayout) findViewById(R.id.playAgainLayout);

        if(checkWin()==1){
            overMessage.setText("Red Won");
            gameOver.setBackgroundColor(Color.RED);
            canClick=false;
                        final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Do something after 5s = 5000ms
                    gameOver.setVisibility(View.VISIBLE);
                }
            }, 1000);

        }
        if(checkWin()==2){
            overMessage.setText("Yellow Won");
            gameOver.setBackgroundColor(Color.YELLOW);

            canClick=false;
            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Do something after 5s = 5000ms
                    gameOver.setVisibility(View.VISIBLE);
                }
            }, 1000);
        }
        if(checkTie()){
            overMessage.setText("TIEEEEE");
            gameOver.setBackgroundColor(Color.GREEN);

            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Do something after 5s = 5000ms
                    gameOver.setVisibility(View.VISIBLE);
                }
            }, 1000);
        }

    }
    public int checkWin(){
        for(int x=1; x<3; x++){
            if((arr[0]==x&&arr[1]==x&&arr[2]==x)||(arr[3]==x&&arr[4]==x&&arr[5]==x)||(arr[6]==x&&arr[7]==x&&arr[8]==x)||(arr[0]==x&&arr[3]==x&&arr[6]==x)||(arr[1]==x&&arr[4]==x&&arr[7]==x)||(arr[2]==x&&arr[5]==x&&arr[8]==x)||(arr[0]==x&&arr[4]==x&&arr[8]==x)||(arr[2]==x&&arr[4]==x&&arr[6]==x)){
                return x;
            }

        }
        return 0;
    }
    public boolean checkTie(){
        for(int x=0;x<9;x++){
            if(arr[x]==0){
                return false;
            }
        }
        return true;
    }
    public void restart(){
        for(int x=0; x<9;x++) {
            arr[x]=0;

        }
        ImageView piece = findViewById(R.id.r0);
        piece.setImageResource(0);
        piece = findViewById(R.id.r1);
        piece.setImageResource(0);
        piece = findViewById(R.id.r2);
        piece.setImageResource(0);
        piece = findViewById(R.id.r3);
        piece.setImageResource(0);
        piece = findViewById(R.id.r4);
        piece.setImageResource(0);
        piece = findViewById(R.id.r5);
        piece.setImageResource(0);
        piece = findViewById(R.id.r6);
        piece.setImageResource(0);
        piece = findViewById(R.id.r7);
        piece.setImageResource(0);
        piece = findViewById(R.id.r8);
        piece.setImageResource(0);
        turn="red";

    }
}
