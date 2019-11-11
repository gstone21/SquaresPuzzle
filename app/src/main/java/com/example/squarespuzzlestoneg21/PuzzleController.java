package com.example.squarespuzzlestoneg21;

import android.view.MotionEvent;
import android.view.View;

/**
 * --- PuzzleController Class ---
 * This is the controller class for making game
 * moves based on touch events.
 *
 * @author Grant Stone
 * November 10, 2019
 */

public class PuzzleController implements View.OnTouchListener {
    private PuzzleView puzzle;

    public PuzzleController(PuzzleView v){
        puzzle = v;
    }

    @Override
    public boolean onTouch (View v, MotionEvent event){
        float x = event.getX();
        float y = event.getY();

        for(Square square : puzzle.squares){
            if(square.getIntNum() != 16 && square.getLeft() <= x && square.getRight() >= x && square.getTop() <= y && square.getBottom() >= y){

                if(square.nextTo(puzzle.squares[15])){
                    float tempLeft = square.getLeft();
                    float tempTop = square.getTop();
                    square.setCord(puzzle.squares[15].getLeft(), puzzle.squares[15].getTop());
                    puzzle.squares[15].setCord(tempLeft, tempTop);
                    puzzle.invalidate();
                }
            }
        }
        return true;
    }


}
