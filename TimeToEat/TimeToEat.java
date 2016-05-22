import java.io.*;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Collections;

public class TimeToEat {
	public static void main (String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        while ((line = buffer.readLine()) != null) {
            line = line.trim();
            String [] lineArray = line.split(" ");
            ArrayList<String> storedTime = new ArrayList<>();
            for(String time : lineArray){
            	time = time.replace(":", "");
            	storedTime.add(time);
            }
            String finalOutput = "";
            Collections.sort(storedTime, Collections.reverseOrder());
            for(String sortedTime : storedTime){
            
      
            	String timer[] = sortedTime.split("(?<=\\G..)");
            	Time myTime = new Time(Integer.parseInt(timer[0]), Integer.parseInt(timer[1]),
            			Integer.parseInt(timer[2]));
            	finalOutput += myTime.toString() + " ";
            }
            finalOutput = finalOutput.trim();
            System.out.println(finalOutput);
        }
    }
}
