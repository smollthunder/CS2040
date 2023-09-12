/**
 * Name: Toh Xiao Lei
 * Matric. No: 
 */
import java.util.*;
import java.lang.*;

public class Friends {
  public static void main(String args[]) {
    Kattio io = new Kattio(System.in, System.out);
    int n = io.getInt();
    long m = io.getLong();
    long a, b;
    int i, j, v;
    int maxfriends = 0;
    String cafe;
    long[] in, out;
    ArrayList<Integer> visitors = new ArrayList<>();
    ArrayList<String> cafes = new ArrayList<>();
    ArrayList<String> maxcafes = new ArrayList<>();

    for(i = 0; i < n; i++){
      cafe = io.getWord();
      v = io.getInt();
      in = new long[v];
      out = new long[v];
      for(j = 0; j < v; j++){
        a = io.getLong();
        a = a - m;
        if(a < 0){
          a = 0;
        }
        b = io.getLong();
        in[j] = a;
        out[j] = b;
      }
      //insert sorting algo here pls
      //System.out.println(Arrays.toString(in));
      //System.out.println(cafe);
      visitors.add(maxOverlapCounter(in, out));
      cafes.add(cafe);
    }
    for(i = 0; i < visitors.size(); i++){
      if(visitors.get(i) > maxfriends){
        maxfriends = visitors.get(i);
      }
    }
    System.out.println(maxfriends);
    for(i = 0; i< visitors.size(); i++){
      if(visitors.get(i) == maxfriends){
        maxcafes.add(cafes.get(i));
      }
    }
    Collections.sort(maxcafes);
    for(i = 0; i < maxcafes.size(); i++){
      System.out.println(maxcafes.get(i));
    }
    //System.out.println(visitors);
    //System.out.println(cafes);
  }
  public static int maxOverlapCounter(long[] start, long[] end){
    int current = 0;
    int maxOverlap = 0;
    int i = 0, j = 0;
    int n = start.length;
    Arrays.sort(start);
    Arrays.sort(end);
    while(i < n && j < n){
      if(start[i] <= end[j]){
        current++;
        maxOverlap = Math.max(maxOverlap, current);
        i++;
      }
      else{
        current--;
        j++;
      }
    }
    return maxOverlap;
  }
}
