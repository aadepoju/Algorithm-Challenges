
import java.io.*;
public class ReadMore {
    public static void main (String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        while ((line = buffer.readLine()) != null) {
	           if(line.length() <= 55){
	        	   System.out.println(line);
	           }else{
	        	   String shortline = line.substring(0, 39);
	        	   
	        	   if(shortline.charAt(38) == ' '){
	        		   shortline = shortline.substring(0, 37);
	        	   }
	        	   System.out.println(shortline + "... <Read More>");
	           }
            // Process line of input Here
        }
    }
}
