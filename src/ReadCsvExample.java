import com.google.common.collect.HashMultimap;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Hashtable;

import static java.util.Collections.*;

/**
 * Created by Sanjay_Shivanna on 11/20/2017.
 */
public class ReadCsvExample {


    public static void main(String[] args) {
        readCSVAndPrint("C:\\Users\\sanjay_shivanna\\Desktop\\testdata.csv");
    }


    public static  void readCSVAndPrint(String filepath){
        String csvFile = filepath ;
        String line = "";
        String cvsSplitBy = ",";
        HashMultimap<String,String> deviceUuidMapping =  HashMultimap.create();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

                while ((line = br.readLine()) != null) {

                    // use comma as separator
                    String[] deviceArray = line.split(cvsSplitBy);

                    deviceUuidMapping.put(deviceArray[1],deviceArray[0]);

                }


            /*Printing the values*/
            for(String key : deviceUuidMapping.keySet()) {
                System.out.println(key+": "+deviceUuidMapping.get(key));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }



}
