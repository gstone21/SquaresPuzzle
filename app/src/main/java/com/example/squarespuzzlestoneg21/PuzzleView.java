package com.example.squarespuzzlestoneg21;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceView;

import java.util.Random;

public class PuzzleView extends SurfaceView {


    Paint blackPaint = new Paint();
    Paint whitePaint = new Paint();
    Paint bluePaint = new Paint();

    Square squares[] = new Square[16];



    public PuzzleView(Context context, AttributeSet attrs){
        super(context, attrs);
        setWillNotDraw(false);
        //setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setBackgroundColor(Color.BLACK);

        blackPaint.setColor(Color.BLACK);
        whitePaint.setColor(Color.WHITE);
        bluePaint.setColor(Color.BLUE);

        for(int i = 0; i < 16; i++) {
            squares[i] = new Square();
            squares[i].setNum(i + 1);
        }

        getRandomPuzzle(squares);



    }


    public void drawSquare(Canvas canvas, Square square){
        canvas.drawRect(square.getLeft(), square.getTop(), square.getRight(), square.getBottom(), bluePaint);
        whitePaint.setTextSize(150);
        canvas.drawText(square.getNum(), square.getLeft()+5f, square.getTop()+146.875f, whitePaint);

    }

    public void getRandomPuzzle(Square[] squares) {  //no more canvas
        for (float y = 205; y < 1000; y = y + 198.75f) {
            for (float x = 205; x < 1000; x = x + 198.75f) {

                while(true) {
                     int rand = new Random().nextInt(16);
                     if(squares[rand].hasNoCord()) {
                         squares[rand].setCord(x, y);
                         break;
                     }
                     // loop until random square needs coord.


                }



            }
        }
    }

    public void drawWinPuzzle(Canvas canvas, Square[] squares) {
        int i = 0;

        for (float y = 205; y < 1000; y = y + 198.75f) {
            for (float x = 205; x < 1000; x = x + 198.75f) {
                if(i < 15) {
                    squares[i].setCord(x, y);
                    drawSquare(canvas, squares[i]);
                    i++;
                }
            }
        }


    }

    public void drawPuzzle(Canvas canvas, Square[] squares){
        for(int i = 0; i < 15; i++){
            drawSquare(canvas, squares[i]);
        }
    }


    @Override
    public void onDraw(Canvas canvas)
    {



        canvas.drawRect(200f, 200f, 1000f, 1000f, whitePaint);
        //squares[0].setCord(205, 205);
       // if(squares[0].hasNoCord()) drawSquare(canvas, squares[0]);


        drawPuzzle(canvas, squares);
        //drawWinPuzzle(canvas, squares);


    }



}
