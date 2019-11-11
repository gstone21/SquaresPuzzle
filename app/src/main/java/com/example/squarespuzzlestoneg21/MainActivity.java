package com.example.squarespuzzlestoneg21;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PuzzleView puzzle = (PuzzleView) findViewById(R.id.PuzzleView);
        PuzzleController puzzle_con = new PuzzleController(puzzle);

        puzzle.setOnTouchListener(puzzle_con);

    }
}
