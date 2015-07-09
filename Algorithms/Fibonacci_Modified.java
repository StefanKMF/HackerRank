import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Fibonacci_Modified {

    public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n0,n1,nth;

    n0 = scn.nextInt();
    n1 = scn.nextInt();
    nth = scn.nextInt();

    BigInteger[] series = new BigInteger[nth];
    series[0]=(new BigInteger(String.valueOf(n0)));
    series[1]=(new BigInteger(String.valueOf(n1)));

    for (int x = 2; x < nth; x++){
      series[x] = series[x-2].add(series[x-1].multiply(series[x-1]));
    }

    System.out.println(series[nth-1]);

    }
}
