package Game;

import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class ChancekortReader {


    public static String[] text() throws IOException {
        String[] ar = new String[42];
        BufferedReader read = new BufferedReader(new FileReader("src/Game/Udskrift.txt"));
        int i = 0;
        while (true) {
            String ad = read.readLine();
            if (ad==null)
                break;
            ar[i] = ad;
            i++;


        }
        System.out.println(Arrays.toString(ar));
        return ar;


    }
}
