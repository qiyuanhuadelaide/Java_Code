package main.im.qiyuanhu.homework;

import java.util.Arrays;

public class Hw4_p3 {

    /**
     * recursive method
     * the two methods named rearrange are different in parameter
     * @param stringArray an array of a fixed number of string values
     * @param x the length of the array which is being compared
     * @param l the leftmost one of array which is being compared
     * @param r the rightmost one of array which is being compared
     */
    public static void rearrange(String[] stringArray,int x,int l,int r){
        //to check whether the range is correct, if not the recursive is done, return false.
        if (l>r){
            return;
        }
        // if the length of rightmost one is less than x, swap current rightmost one to leftmost one.
        if (stringArray[r].length()<=x){
            // switch positions
            String temp=stringArray[l];
            stringArray[l]=stringArray[r];
            stringArray[r]=temp;
            // range become from [l,r] to [l+1,r] since the leftmost one is in correct position
            rearrange(stringArray,x,l+1,r);
        }
        else {

            // if the length of string is more than x, it will keep the same position
            rearrange(stringArray,x,l,r-1);
        }
    }

    /**
     * same method name as above but they have different parameter
     * @param stringArray an array of a fixed number of string values
     * @param x the length of the array which is being compared
     */
    public static void rearrange(String[] stringArray,int x){
        // initialized the leftmost and rightmost elements
        int l=0;
        int r=stringArray.length-1;
        //using recursive method to rearrange array
        rearrange(stringArray,x,l,r);
    }
    public static void main(String[] args) {

        String[] stringArray = {"data", "structures", "and", "algorithms", "in", "java"};

        System.out.println();
        int x = 4;
        System.out.println("Array before change: " + Arrays.toString(stringArray));
        rearrange(stringArray, x);// call the second rearrange method
        System.out.println("Array after change: " + Arrays.toString(stringArray));

    }
}
