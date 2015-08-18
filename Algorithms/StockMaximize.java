import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class StockMaximize {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int num_Cases = scn.nextInt();
        int n;

        for (int x = 0; x < num_Cases; x++){ //Loop through each test Case
          n = scn.nextInt();
          long[] prices = new long[n];

          for (int i = 0; i < n; i++){ //Fill array with each daily stock price.
            prices[i] = scn.nextInt();
          }//end for loop

          System.out.println(solve(prices,n)); //Call the solve function and print the results.
        }//end for loop


    }//end main

    //General logic for solution. Working backwards find local maximums and mark these as days to sell stocks.
    //Buy stocks on all the days leading up to these local maximums.
    public static long solve(long[] prices, int n){
      Boolean[] sellDays = new Boolean[n];
      Arrays.fill(sellDays, false);

      long localMax = 0; //Lowest possible value is 1, this will set the last day to always be a sell date.


      for (int day = n-1; day>=0; day--){ //Find Local Maximums.
          if (prices[day] > localMax){
            localMax = prices[day];
            sellDays[day] = true;
          }
      }//end for loop

      long profit = 0;
      int currentStocks = 0;
      long cost = 0;

      for (int day = 0; day < n; day++){ //Loop through each day, either buy or sell.
        if (sellDays[day] == false){ //Buy stock
          cost += prices[day];
          currentStocks += 1;
        } else if (sellDays[day] == true){//Sell Stock
          profit += currentStocks * prices[day] - cost;
          currentStocks = 0;
          cost = 0;
        }

      }//end for loop

      return profit;
    }//end solve
}//end class
