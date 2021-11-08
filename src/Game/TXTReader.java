package Game;

import java.io.*;

public class TXTReader {

    private String txtToLoad;

    public TXTReader(String txtToLoad){
        this.txtToLoad = txtToLoad;
    }

    public String readTXTFile(){

        File txtFile = new File(txtToLoad);
        char[] chars = new char[(int) txtFile.length()];

        String bigChungus = null;
        BufferedReader myReader = null;
        try {
            myReader = new BufferedReader(new FileReader("src/Game/" + txtFile));
            myReader.read(chars);
            bigChungus = new String(chars);
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + txtFile);
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Failed to read or close file");
            e.printStackTrace();
        }

        return bigChungus;
    }

}
