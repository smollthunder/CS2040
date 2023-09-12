/**
 * Name:
 * Matric. No:
 */

import java.io.*;
import java.util.*;

public class Monsters {
  public static void main(String args[]) {
    Kattio io = new Kattio(System.in, System.out);
    int N = io.getInt();
    int i, num, newvalue, value;
    Pair duo, duo1;
    PriorityQueue<Pair> queue = new PriorityQueue<>();
    PriorityQueue<Pair> output = new PriorityQueue<>(Collections.reverseOrder());

    for(i = 0; i < N; i++){
      num = io.getInt();
      duo = new Pair(num, i+ 1);
      queue.add(duo);
    }
    duo = queue.poll();
    for(i = 0; i < N ; i++){
      duo1 = queue.poll();
      if(duo1 == null){
        output.add(duo);
        break;
      }
      value = duo.compareTo(duo1);
      if(value == 1){
        output.add(duo1);
      }
      if(value == -1){
        output.add(duo);
        duo = duo1;
      }
      if(value == 0){
        newvalue = duo.value * 2;
        duo = new Pair(newvalue, Math.min(duo.index, duo1.index));
        //System.out.println("i is" + i);
      }
    }
    System.out.println(output.size());
    //System.out.println(output);
    String out = "";
    System.out.print(output.poll().value);
    for (i = 0; i <= output.size() + 1; i++){
      duo = output.poll();
      System.out.print(" ");
      System.out.print(duo.value);
    }
    System.out.println();
    io.close();
  }
}

class Pair implements Comparable<Pair>{
  public int value;
  public int index;

  public Pair(int value, int index){
    this.value = value;
    this.index = index;
  }

  public int compareTo(Pair pair){
    if (this.value == pair.value){
      return 0;
    }
    if (this.value > pair.value){
      return 1;
    }
    return -1;
  }
}
