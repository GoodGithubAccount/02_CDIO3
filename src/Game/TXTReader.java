package Game;

import java.io.*;

public class TXTReader {

    private String txtToLoad;

    public TXTReader(String txtToLoad){
        this.txtToLoad = txtToLoad;
    }

    public String readTXTFile(){

        File txtFile = new File(txtToLoad);

        String returnString = "";
        BufferedReader myReader = null;
        try {
            myReader = new BufferedReader(new FileReader("src/Game/" + txtFile));

            int line = myReader.read();
            while(line != -1){
                returnString += (char)line;
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

}
