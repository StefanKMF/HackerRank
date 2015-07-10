import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Maximum_Subarray{

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int num_Cases = scn.nextInt();
        int n;
        for (int x = 0; x < num_Cases; x++){
          n = scn.nextInt();
          int[] series = new int[n];
          for (int i = 0; i < n; i++){
            series[i] = scn.nextInt();
          }

          System.out.println((new Maximum_Subarray().max_contin(series)) + " " + (new Maximum_Subarray().max_noncontin(series)));

        }


    }
    public int max_contin(int[] input){
      int current_max, max_here;
      current_max = max_here = input[0];

      for (int x = 1; x < input.length; x++){
        max_here = Math.max(input[x],max_here + input[x]);
        current_max = Math.max(max_here, current_max);
      }

      return current_max;
    }

    public int max_noncontin(int[] input){
      int current_max = 0;
      int max = input[0];
      boolean isNeg = true;

      for (int x = 0; x < input.length; x++){
        if (input[x] >= 0){
          current_max += input[x];
          isNeg = false;
        }
        max = Math.max(max, input[x]);
      }

      if (isNeg == true){
        return max;
      } else {
        return current_max;
      }
}

}
