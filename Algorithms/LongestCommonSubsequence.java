import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class LongestCommonSubsequence {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n, m;
        n = scn.nextInt();
        m = scn.nextInt();

        //read in n line;
        int[] nArray = readLine(scn,n);
        int[] mArray = readLine(scn,m);

          System.out.println(solveProblem(nArray,mArray,n,m));
        }//end main

    //Helper function to read in line of integers to array.
    public static int[] readLine(Scanner input, int size){
      int[] output = new int[size];
      for (int x=0; x<size; x++){
        output[x] = input.nextInt();
      }

    return output;
    }


    public static StringBuffer solveProblem(int[] nArray, int[] mArray, int n, int m){

      //Solve problem by using an alignment table.
      int[][] alignment = new int[n+1][m+1];

      for (int row=1; row <=n; row++){
        for (int col=1; col <=m; col++){
          if (nArray[row-1] == mArray[col-1]){
            alignment[row][col] = alignment[row-1][col-1] + 1;
          }
          else {
            alignment[row][col] = Math.max(alignment[row-1][col-1], Math.max(alignment[row-1][col],alignment[row][col-1]));
          }
        }
      }

      //Get the sequence by back tracking through the alignment table
      StringBuffer seq = new StringBuffer();

      for (int x=n, y=m; x!=0 && y!=0;){
        if (alignment[x][y] == alignment[x-1][y]){
          x--;
        }
        else if (alignment[x][y] == alignment[x][y-1]){
          y--;
        }
        else if (nArray[x-1] == mArray[y-1]){
          seq.insert(0,(Integer.toString(nArray[x-1]) + " "));
          x--;
          y--;
        }
        else {
          throw new IllegalArgumentException();
        }

      }

      return seq;
    }




}//end LongestCommonSubsequence
