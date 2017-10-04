/*
* Junyu Liu
* Katie Pan
* 001E
*
* Assignment 5 - MorseCode, CSc 210, Spring 2017
* It is a program that convert the morsecode into words and put it in a map
*/

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MorseCode {
    /*
    * Method Name: main
    * Purpose of method: print out the result and call other methods
    * Arguments:
    * String [] args - it is a String [] that contain the arguments from command line
    * Return Value - void
    */
    public static void main(String [] args) {
        Scanner file = readFile();
        Map<String, String> morse = createMorseMap(file);
        Map<String, Integer> result = getResultMap(morse);
        System.out.println(result);
    }

    /*
    * Method Name: getResultMap
    * Purpose of method: get the result map {whole words=counts}
    * Arguments:
    * Map<String, String> morse - it is a map contains String = String(morsecode)
    * Return Map<String, String>  - return the map that contains the morse code from stdin
    */
    public static Map<String, Integer> getResultMap(Map<String, String> morse){
        Scanner stdin = new Scanner(System.in); //stdin
        String line = "";
        while (stdin.hasNextLine()){ //add new line to String line
            line += stdin.nextLine() + "  ";
        }

        if(line.equals("")) //empty file
            System.exit(1);

        String [] code = line.split("  "); // ["--- ... ---", ". -- ."]
        Map<String, Integer> result = new HashMap(); //init map
        for(String word : code){ //iterate the morse code array
            String [] singleCode = word.split(" "); //every single word split by 1 white space
            String wholeWord = "";
            int count = 1; //times that code occurs
            for (String single : singleCode){
                if(morse.containsKey(single)){
                    wholeWord += morse.get(single); //the whole morse code which split by 2 space
                }
                else {
                    System.err.println("ERROR"); //exit when the single code is not in the morse.txt
                    System.exit(1);
                }
            }

            if(result.containsKey(wholeWord)) { //put the whole words in the result map
                count = result.get(wholeWord);
                count += 1;
                result.put(wholeWord, count);
            }
            else {
                result.put(wholeWord, count); //init the 1st time show whole word
            }

        }
        return result;
    }

    /*
    * Method Name: createMorseMap
    * Purpose of method: get the morse map {A=XXX, B=XXX, C=XXX}
    * Arguments:
    * Scanner file - the file content from stdin
    * Return Map<String, String>  - return the map that contains the morse code from stdin
    */
    public static Map<String, String> createMorseMap(Scanner file){
        Map<String, String> morse = new HashMap();
        while (file.hasNextLine()) { //only a sequence of morse code
            String line = file.nextLine();
            String[] morsecode = line.split("\\s+"); //split English words and morse code
            morse.put(morsecode[1], morsecode[0]); //{A=xxx, ...}
        }
        return morse;
    }

    /*
   * Method Name: readFile
   * Purpose of method: get input file content of morse.txt
   * Return Value - Scanner it is a Scanner object that contains the morse.txt file content
   */
    public static Scanner readFile(){
        File inFile = new File("morse.txt");
        Scanner in = new Scanner(System.in);
        try {
            in = new Scanner(inFile);
        }
        catch (IOException e){
            System.exit(1);
        }
        return  in;
    }
}
