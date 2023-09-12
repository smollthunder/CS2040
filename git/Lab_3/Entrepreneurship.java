/**
 * Name:
 * Matric. No: 
 */
import java.util.*;
import java.io.*;

public class Entrepreneurship {
  public static void main(String args[]) throws IOException{
    Kattio io = new Kattio(System.in, System.out);
    int n = io.getInt();
    int m = io.getInt();
    int a, i, num, price;
    double b;
    double revenue = 0;
    int sum = 0;
    String direction;
    LinkedList <Integer> hold1 = new LinkedList<>();
    LinkedList <Double> hold2 = new LinkedList<>();
    LinkedList <Integer> order1 = new LinkedList<>();
    LinkedList <Double> order2 = new LinkedList<>();
    String word = io.getWord();
    while (word != null){
      if (word.contains("ADD")){
        a  = io.getInt(); // number of orders in the batch
        direction = io.getWord();
        if (direction.equals("L")){
          i = 0;
          while(i < a){
            num = io.getInt();
            b = io.getDouble();
            if(sum + num <= m){
              order1 = new LinkedList<>();
              order2 = new LinkedList<>();
              sum = sum + num;
              revenue = revenue + b*num;
              order1.addLast(num);
              order2.addLast(b);
            }
            i = i+ 1;
          }
        }
        else if (direction.equals("R")){
          for(i = 0; i < a; i++){
            num = io.getInt();
            hold1.addFirst(num);
            b = io.getDouble();
            hold2.addFirst(b);
          }
          i = 0;
          while(i < a){
            num = hold1.pop();
            b = hold2.pop();
            if(sum + num <= m){
              order1 = new LinkedList<>();
              order2 = new LinkedList<>();
              sum = sum + num;
              revenue = revenue + b*num;
              order1.addLast(num);
              order2.addLast(b);
            }
            i++;
          }
        } 
      }
      else if(word == "CANCEL"){
        for(i = 0; i < order1.size(); i++){
          num = order1.pop();
          sum = sum - num;
          revenue = revenue - order2.pop()*num;
        }
      }
      word = io.getWord();
    }
    System.out.println(Math.round(revenue*10)/10d);
    io.close();
  }
}
