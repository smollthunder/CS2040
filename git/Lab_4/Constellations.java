/**
 * Name: 
 * Matric. No: 
 */

import java.io.*;
import java.lang.*;

public class Constellations {
  public static void main(String args[]) {
    Kattio io = new Kattio(System.in, System.out);
    long n, a, b;
    n = io.getLong();
    a = io.getLong();
    b = io.getLong();

    System.out.println(recursionCall(n, a, b));
    io.close();
  }
  static long gcd(long n1, long n2){
    long gcdenom = 1;
    for (int i = 1; i<= n1 && i <= n2; ++i){
      if(n1 % i == 0 && n2 % i == 0){
        gcdenom = i;
      }
    }
    return gcdenom;
  }
  //combinations, nCr = factorial(n) / factorial(n - r) * factorial(r) 
  static long ncr(long n, long r){
    long m = 1000000007;
    long a = 1, b = 1;
    if (n - r < r){ 
      r = n - r;
    }
    if (r != 0){
      while (r > 0){
        a = a * n; //sum of n factorial
        b = b * r; //sum of r factorial

        long c = gcd(a, b);
        
        a /= c;
        b /= c;

        n--;
        r--;
      }
    }
    else{
      a = 1;
    }
    return a;
  }
  static long recursionCall(long n,long a, long b){
    long total = 0;
    long m = 1000000007;
    long combinations, ways;
    if (n < 0){
      return 0;
    }
    if(n < a){
      return  1;
    }
    for(long i = a; i <= b; i++){
      combinations = ncr(n, i)%m;
      ways = recursionCall(n-i, a, b)%m;
      total = (total + combinations*ways) % m;
      // System.out.println("total is" + total);
    }
    return total;
  }
}
