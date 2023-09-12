/**
 * Name: 
 * Matric. No: 
 */
import java.util.*;

public class Students {
  public static void main(String args[]) {
    Kattio io = new Kattio(System.in, System.out);
    int numofParticipants = io.getInt();
    int numofEntries = io.getInt();

    HashMap <String, String> studentlist = new HashMap<String, String>();
    HashMap <String, LinkedList<String>> entries = new HashMap<String, LinkedList<String>>();
    int i, j;
    String name, status, arrow, person, personstatus;
    Set<String> vertices = new HashSet<>();
    boolean victory = false;
    boolean unknown = false;
    LinkedList<String> list = new LinkedList<String>();
    LinkedList<String> listvoted = new LinkedList<String>();
    LinkedList <String> queue = new LinkedList<String>();

    //adding status of all participants into hashmap
    for(i = 0; i < numofParticipants; i++){
      name = io.getWord();
      status = io.getWord();
      studentlist.put(name, status);
      list = new LinkedList<String>();
      entries.put(name, list);
    }
    for(i = 0; i < numofEntries; i++){
      //name is participant1
      name = io.getWord();
      status = studentlist.get(name);
      //arrow is the arrow
      arrow = io.getWord();
      //person is participant2
      person = io.getWord();
      personstatus = studentlist.get(person);
      list = entries.get(name);
      //list contains the list of names that this participant has written the name of
      list.add(person);
      if(status.equals("?") || personstatus.equals("?")){
        unknown = true;
      }
    }
    //keys is the list of names who wrote down the name of another participant
    List<String> keys = new ArrayList<String>(studentlist.keySet());
    for(i = 0; i < keys.size(); i++){
      name = keys.get(i);
      status = studentlist.get(name);
      if(status.equals("s")){
        queue.add(name);
      }
      while(!queue.isEmpty()){
        person = queue.remove();
        vertices.add(person);
        personstatus = studentlist.get(person);
        if(personstatus.equals("n")){
          victory = true;
          //once victory is true, we can stop searching
          break;
        }
        //listvoted is the list of participants that person voted for
        listvoted = entries.get(person);
        for(j = 0; j < listvoted.size(); j++){
          if(vertices.contains(listvoted.get(j)) == false){
            queue.add(listvoted.get(j));
          }
        }
      }
      if(victory == true){
        break;
      }
    }
    //if victory is true, means there is an entry where a student wrote the name of a non-student
    if(victory == true){
      System.out.println("VICTORY");
    }
    //if unknown is true, we are not able to determine if there was a student who wrote down the name of a non-student
    else if(unknown == true){
      System.out.println("OUTCOME UNCLEAR");
    }
    //no one wrote the name of a person who is not a student
    else{
      System.out.println("EVERYONE LOSES");
    }
  }
}

