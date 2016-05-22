import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class CountBinaryZeroes {

	public static void main (String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        while ((line = buffer.readLine()) != null) {
            line = line.trim();
            String [] lineArray = line.split(" ");
            int numOfZeroes = Integer.parseInt(lineArray[0]);
            int range = Integer.parseInt(lineArray[1]);
            int numOfOccurence = 0;
            for (int counter = 1; counter <= range; counter++){
            	String binaryRep = Integer.toString(counter, 2);
          
            	int count = binaryRep.length() - binaryRep.replace("0", "").length();
            	if(count == numOfZeroes){
            		numOfOccurence++;
            	}
            }
            System.out.println(numOfOccurence);
        }
    }
}

