import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Knapsack {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int T,n,capacity;
        T = scn.nextInt();

        //loop through each testcase.
        for (int x=0; x<T; x++){
            n = scn.nextInt();
            capacity = scn.nextInt();
            int[] items = new int[n];
            for (int i=0; i < n; i++){
                items[i] = scn.nextInt();
            }

            int[] values = new int[capacity+1];


            //Calc max weight from bottom up.
            for (int weight=1; weight<= capacity; weight++){
                for (int j=0; j<items.length; j++){
                    //Only complete if values[j] <= weight
                    if (items[j] <= weight){
                        values[weight] = Math.max(values[weight], (items[j] + values[weight - items[j]]));

                    }
                }
            }

            System.out.println(values[capacity]);
        }
    }
}
