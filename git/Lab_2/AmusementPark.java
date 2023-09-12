/**
 * Name :
 * Matric. No : 
 */
import java.util.*;
import java.io.*;
import java.lang.*;

public class AmusementPark {
  public static void main(String args[]) throws IOException {
    InputStreamReader ip = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(ip);
    String line = br.readLine();

    ArrayList<LinkedList<String>> output = new ArrayList<>();
    String last, endline;
    int i, j; 
    int day = 1;
    LinkedList<String> memory = new LinkedList<>();

    while(line != null){
      if (line.contains("START RIDE: ")){
        last = line.split(" ", 3)[2];
        memory.add(last);
      }
      else if (line.contains("NEXT RIDE: ")){
        last = line.split(" ", 3)[2];
        memory.add(last);
      }
      else if (line.contains("DELETE FRONT RIDE: ")){
        i = Integer.parseInt(line.split(" ")[3]);
        if (i > memory.size()){
          System.out.println("Invalid command"); //actual print statement
        }
        else{
          for(j = 0; j < i; j++){
            memory.removeFirst();
          }
        }
      }
      else if (line.contains("DELETE BACK RIDE: ")){
        i = Integer.parseInt(line.split(" ")[3]);
        if (i > memory.size()){
          System.out.println("Invalid command"); // actual print statement
        }
        else{
          for(j = 0; j < i; j++){
            memory.removeLast();
          }
        }
      }
      else if (line.contains("CHANGE FRONT RIDE: ")){
        i = Integer.parseInt(line.split(" ")[3]);
        last = line.split(" ")[4];
        if (i > memory.size()){
          System.out.println("Invalid command");
        }
        else{
          for (j = 0; j < i; j++){
            memory.removeFirst();
          }
        memory.addFirst(last);
        }
      }
      else if (line.contains("CHANGE BACK RIDE: ")){
        i = Integer.parseInt(line.split(" ")[3]);
        last = line.split(" ")[4];
        if( i > memory.size()){
          System.out.println("Invalid command");
        }
        else{
          for (j = 0; j < i; j++){
            memory.removeLast();
          }
          memory.addLast(last);
        }
      }
      else if (line.contains("NEXT DAY")){
        output.add(memory);
        memory = new LinkedList<String>();
      }
      else if (line.equals("END")){
        endline = "Day " + day + ": " + memory;
        output.add(memory);
        for (j = 0; j < output.size(); j++){
          System.out.println("Day " + day + ": " + output.get(j));
          day = day + 1;
        }
      }
      line = br.readLine();
    }
    br.close();
  }
}
