import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Candies {

    public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int num_Children = scn.nextInt();
    int[] child = new int[num_Children];

    for (int i=0; i<num_Children; i++){
      child[i] = scn.nextInt();
    }
    System.out.println(new Candies().maxCandies(child));
    }

    public int maxCandies(int[] child){
      //Split problem into two section, determine how many candies based on going left-right & right-left and take the max.
      int size = child.length;
      int sumCandies = 0;


      int[] left = new int[size];
      int[] right = new int[size];

      //Base case is 1 candy per child;
      Arrays.fill(left,1);
      Arrays.fill(right,1);

      //Left to Right
      for (int i=1; i<size; i++){
        if (child[i - 1] < child[i]){
          left[i] = left[i-1] + 1;
        }
      }

      //Right to Left
      for (int i=size-2; i>=0; i--){
        if (child[i+1] < child[i]){
          right[i] = right[i+1] + 1;
        }
      }

      for (int i=0; i<size; i++){
        sumCandies += Math.max(left[i],right[i]);
      }

      return sumCandies;
    }

}
