/*
* Junyu Liu
* Katie Pan
* 001E
*
* Assignment 5 - HappyScore, CSc 210, Spring 2017
* It is a program that can calculate the average happiness for words in a file
*/

import java.io.*;
import java.util.*;

public class HappyScore {
    /*
    * Method Name: main
    * Purpose of method: print out the result and call other methods
    * Arguments:
    * String [] args - it is a String [] that contain the arguments from command line
    * Return Value - void
    */
    public static void main(String [] args){
        Scanner file = readFile();  //read file method
        Map <String, Double> anew = anew(file); //create ANEW map {word=double}

        for(int i = 0; i < args.length; i++){ //iterate all files
            File inFile = new File(args[i]); //File object
            try{
                Scanner in = new Scanner(inFile);
                double avg = result(in, anew);  //call result method
                System.out.printf("Happiness Index for '" + args[i] +
                        "'" + ": %f\n",avg); //output
            }
            catch (IOException e){ //nonexist file
                System.out.println("Error: Encountered +" +
                        "a problem when opening file '" + args[i] + "'");
                System.exit(1);
            }

        }

    }

    /*
    * Method Name: result
    * Purpose of method: get the average result happiness
    * Arguments:
    * Scanner in - it is a Scanner object and read a file
    * Map <String, Double> anew - ANEW file map {word=double}
    * Return Value - double
    */
    public static double result(Scanner in, Map <String, Double> anew){
        double sum = 0; //the sum of happiness
        int count = 0;  //count of happiness word found
        while(in.hasNext()){ //next word
            String word = in.next();
            if (anew.containsKey(word.toLowerCase())){ //lower case word
                sum += anew.get(word.toLowerCase()); //+= happiness(double)
                count += 1;
            }
        }
        double avg = sum / count; //average
        return avg;
    }

    /*
    * Method Name: anew
    * Purpose of method: get input file map ANEW
    * Arguments:
    * Scanner file - it is a Scanner object and read a file
    * Return Value - Map <String, Double> it is a map that contains the ANEW.txt file content
    */
    public static Map <String, Double> anew(Scanner file){
        Map <String, Double> anew = new HashMap(); //create map
        while(file.hasNextLine()){
            String line = file.nextLine(); //get next line from ANEW.txt
            String [] happyWord = line.split("\\s+"); //split the white space
            anew.put(happyWord[0].toLowerCase(),Double.parseDouble(happyWord[1])); //add element into map
        }
        return anew;
    }

    /*
    * Method Name: readFile
    * Purpose of method: get input file content of ANEW.txt
    * Return Value - Scanner it is a Scanner object that contains the ANEW.txt file content
    */
    public static Scanner readFile(){
        File inFile = new File("ANEW.txt");
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
