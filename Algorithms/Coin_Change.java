import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Coin_Change {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int value = scn.nextInt();
        int n = scn.nextInt();

        int[] coins = new int[n];

        for (int i=0; i<n; i++){
          coins[i] = scn.nextInt();
        }

        System.out.println(new Coin_Change().changeCalc(coins, value));

    }

    public long changeCalc(int[] coins, int value){
      long[] changeTable = new long[value + 1];

      changeTable[0] = 1;

      for (int x = 0; x < coins.length; x++){ //loop through each coin
        for (int y = coins[x]; y <= value; y++){ //loop through table starting at coin value untill we reach the target value.
          changeTable[y] += changeTable[y-coins[x]]; //Add number of permutations of previously calculated indices.
        }
      }

      return changeTable[value];
    }
}
