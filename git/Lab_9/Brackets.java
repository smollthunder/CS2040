/**
 * Name: Toh Xiao Lei
 * Matric. No: A0240359E
 */
import java.io.*;
import java.util.*;

public class Brackets {
  public static void main(String args[]) {
    Kattio io = new Kattio(System.in, System.out);
    int numofTokens = io.getInt();
    int i = 0, j = 0;
    int operation = 0;
    String token, token1;

    Stack <String> sequence = new Stack <String> (); //stack to hold all of the bracket sequence
    ArrayList <Long> currsequence = new ArrayList<>(); //arraylist to store elements in the current bracket that we are working on

    // loop to compute sequences in the brackets
    for(i = 0; i < numofTokens; i++){
      token = io.getWord();
      if(token.equals("(")){
        sequence.push(token);
        operation = (operation + 1) % 2;
      }
      else if(token.equals(")")){
        //computing all the numbers in the current bracket once a close bracket is encountered. 
        token1 = sequence.pop();
        //System.out.println("first token 1 is " + token1);
        currsequence = new ArrayList<Long>(); //creating a new Array List each time a close bracket is encountered.
        j = 0;
        while(token1.equals("(") == false){
          currsequence.add(j, Long.parseLong(token1));
          token1 = sequence.pop();
          j += 1;
        }
        Long[] currseq = new Long[currsequence.size()];
        currseq = currsequence.toArray(currseq);
        sequence.push(computeBracket(currseq, operation));
        operation = (operation + 1) % 2;
        
      }
      else{
        //else if token is not a bracket, means token is a number, it will be pushed into the stack
        sequence.push(token);
      }
    }
    //to compute remaining elements outside of brackets
    currsequence = new ArrayList<Long>();
    j = 0;
    while(sequence.empty() == false){
      token1 = sequence.pop();
      if(token1.equals("(")){
        continue;
      }
      currsequence.add(j, Long.parseLong(token1));
      j += 1;
    }
    Long[] currseq = new Long[currsequence.size()];
    currseq = currsequence.toArray(currseq);
    System.out.println(computeBracket(currseq, 0));
  }
  public static String computeBracket(Long[] sequence, int operation){
    long sum = operation; // output of the computations done.
    int i;
    long m = 1000000007;
    if(operation == 0){ //addition
      sum = 0;
      for(i = 0; i < sequence.length; i++){
        sum = (sum + sequence[i]) % m;
      }
    }
    if(operation == 1){ //multiplication
      sum = 1;
      for(i = 0; i< sequence.length; i++){
        sum = (sum * sequence[i]) % m;
      }
    }
    return String.valueOf(sum);
  }
}
