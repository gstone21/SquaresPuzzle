package com.example.squarespuzzlestoneg21;

import static java.sql.Types.NULL;

public class Square {
    private int num;
    private float left;
    private float top;
    private float right;
    private float bottom;


            // constructors

             public Square(){

             }




             //  getters

             public String getNum(){
                 return ""+num;

             }

             public int getIntNum(){
                 return num;
             }

             public float getLeft(){
                 return left;
             }

             public float getTop(){
                 return top;
             }

             public float getRight(){
                 return right;
             }

             public float getBottom(){
                 return bottom;
             }

             // booleans

             public boolean hasNoCord() {
                 return left == NULL;
             }

             public boolean nextTo(Square square){
                 if((this.left == square.left+198.75 || this.left == square.left-198.75) && this.top == square.top) {
                    return true;
                 }else if((this.top == square.top+198.75 || this.top == square.top-198.75) && this.left == square.left){
                         return true;
                 }else {
                     return false;
                 }

             }

             //  setters

            public void setNum(int number){
                 num = number;
            }

            public void setCord(float x, float y){
                 left = x;
                 right = left+193.75f;
                top = y;
                bottom = top+193.75f;
             }







}
