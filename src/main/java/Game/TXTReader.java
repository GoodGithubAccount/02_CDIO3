package Game;

import java.io.*;
import java.util.*;

public class TXTReader {

    private String txtToLoad;

    public TXTReader(String txtToLoad) {
        this.txtToLoad = txtToLoad;
    }

    public String readTXTFile() {

        File txtFile = new File(txtToLoad);

        String returnString = "";
        BufferedReader myReader = null;
        try {
            myReader = new BufferedReader(new FileReader("src/main/java/Game/" + txtFile));

            int line = myReader.read();
            while (line != -1) {
                returnString += (char) line;
                line = myReader.read();
            }


            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + txtFile);
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Failed to read or close file");
            e.printStackTrace();
        }

        return returnString;
    }

    public static String[] udskrift(String file) throws IOException {
        ArrayList<String> arr = new ArrayList();
        String currentline;
        int i = 0;
        BufferedReader myReader = new BufferedReader(new FileReader("src/main/java/Game/" + file));
        while ((currentline = myReader.readLine()) != null){
            //returnString[i] = currentline;
            arr.add(currentline);

        }

        return arr.toArray(new String[arr.size()]);


    }


}
