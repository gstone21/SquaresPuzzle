package com.example.squarespuzzlestoneg21;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceView;

import java.util.Random;

/**
 * --- PuzzleView Class ---
 * This class contains the set of squares that are
 * represented on the puzzle it draws.
 *
 * @author Grant Stone
 * November 10, 2019
 */


public class PuzzleView extends SurfaceView {


    Paint blackPaint = new Paint();
    Paint whitePaint = new Paint();
    Paint bluePaint = new Paint();
    Paint somePaint = new Paint();

    Square squares[] = new Square[16];



    public PuzzleView(Context context, AttributeSet attrs){
        super(context, attrs);
        setWillNotDraw(false);
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


    public void drawSquare(Canvas canvas, Square square, Paint paint){
        canvas.drawRect(square.getLeft(), square.getTop(), square.getRight(), square.getBottom(), paint);
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

    public void getWinPuzzle(Square[] squares) {
        int i = 0;

        for (float y = 205; y < 1000; y = y + 198.75f) {
            for (float x = 205; x < 1000; x = x + 198.75f) {
                if(i < 15) {
                    squares[i].setCord(x, y);
                    i++;
                }
            }
        }


    }

    public void drawPuzzle(Canvas canvas, Square[] squares){
        int i = 0;

        for (float y = 205; y < 1000; y = y + 198.75f) {
            for (float x = 205; x < 1000; x = x + 198.75f) {
                if(squares[i].getLeft() == x && squares[i].getTop() == y) {
                    somePaint.setColor(Color.GREEN);
                }else {
                    somePaint.setColor(Color.BLUE);
                }
                if(i < 15) {
                    drawSquare(canvas, squares[i], somePaint);
                }
                i++;
            }
        }


    }


    @Override
    public void onDraw(Canvas canvas)
    {
        canvas.drawRect(200f, 200f, 1000f, 1000f, whitePaint);
        drawPuzzle(canvas, squares);
    }



}
