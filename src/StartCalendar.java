/*
* Junyu Liu
* Katie Pan
* 001E
*
* Assignment 4 - StartCalendar, CSc 210, Spring 2017
* It is a program that read in a input length, firstweekday and print out the calendar for input year
*/

import java.util.Calendar;
import java.util.Scanner;

public class StartCalendar {
    /*
    * main
    * call other methods and has some logic
    *
    * Arguments: String [] args
    * Return Value - void
    */
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        int length = 1;
        int firstWeekday = 1;
        try {
            length= input.nextInt();
            firstWeekday = input.nextInt();
        }
        catch (Exception e) {
            System.err.println("This is invalid.");
            System.exit(1);
        }

        if ((firstWeekday < 1 || firstWeekday > 7) || (length > 31 || length < 28)){
            System.err.println("This is invalid.");
            System.exit(1);
        }

        output(firstWeekday, length); //output method
    }
    /*
    * Method Name:output
    * Purpose of method: print out the result
    * Arguments:
    * int firstWeekday - the start day for the output
    * int length - the length(days) for the output
    * Return Value - void
    */
    public static void output(int firstWeekday, int length){
        int day = 1;
        System.out.println("Su Mo Tu We Th Fr Sa"); //print out the weekday name
        String space = "";

        //sunday
        if (firstWeekday == 1) {           //the whitespace before the first weekday as the beginning line
            space = " ";
        }
        //monday
        if (firstWeekday == 2) {
            space = "    ";
        }
        //tuesday
        if (firstWeekday == 3) {
            space = "       ";
        }
        //wednesday
        if (firstWeekday == 4) {
            space = "          ";
        }
        //friday
        if (firstWeekday == 5) {
            space = "             ";
        }
        //saturday
        if (firstWeekday == 6) {
            space = "                ";
        }
        if (firstWeekday == 7) {
            space = "                   ";
        }
        String line = space + day; //beginning line
        while (day <= length){
            if (line.length() == 20 || day == length){//the length of the line is 20 or the day reach the length
                                                      // of month
                System.out.println(line); //print out the finished line
                day++;
                if(day >= 10) //reset the line with space and the day
                    line = "" + day; //Su
                                     //10
                else
                    line = " "  + day; //Su
                                       // 1

            }
            else{ //still not reach 20 length or the last day of this month
                day++;
                if(day >= 10)
                    line += " " + day; //10 11 12
                else
                    line += "  " + day; // 1  2  3
            }
        }
    }
}
