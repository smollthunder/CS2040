/**
 * Name: Toh Xiao Lei
 * Matric. No:
 */
import java.util.*;

public class Macarons {
  public static void main(String args[]) {
    Kattio io = new Kattio(System.in, System.out);
    HashMap<Integer, Integer> macarons = new HashMap<>();
    int numofMacarons = io.getInt(); //number of macarons in the box
    int divisor = io.getInt();

    int i, start, end; //start and end of sequence
    int totalNum = 0, remainder = 0;
    int number, currentSum;

    for(i = 0; i < numofMacarons; i++){
      number = io.getInt(); //number on each macaron
      //System.out.println(number);
      remainder = (remainder + number) % divisor;
      if(macarons.containsKey(remainder) == true){
        macarons.put(remainder, macarons.get(remainder) + 1);
      }
      else{
        if(remainder == 0){
          macarons.put(0, 1);
        }
        else{
          macarons.put(remainder, 0);
        }
      }
      totalNum += macarons.get(remainder);
    }
    System.out.println(totalNum);
    io.close();
  }
}
