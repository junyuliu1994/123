/*
* Junyu Liu
* Katie Pan
* 001E
*
* Assignment 4 - MonthCalendar, CSc 210, Spring 2017
* It is a program that read in a input year and month then print out the calendar for year/month
*/

import java.util.ArrayList;
import java.util.Scanner;

public class MonthCalendar {
    /*
    * main
    * call other methods and has some logic
    *
    * Arguments: String [] args
    * Return Value - void
    */
    public static void main(String [] args) {
        Scanner input = new Scanner(System.in);
        int year = 1;
        int month = 1;
        try {
            year= input.nextInt();
            month = input.nextInt();
        }
        catch (Exception e) {
            System.err.println("This is invalid.");
            System.exit(1);
        }

        if ((month < 1 || month > 12) || (year < 1753 || year > 3000)) {
            System.err.println("This is invalid.");
            System.exit(1);
        }

        boolean leapYear; //set the leapYear in boolean type
        leapYear = leapYearOrNot(year); //leapYearOrNot method

        int length; //set the length
        length = getLength(month, leapYear); //getLength method

        int firstWeekday; //set first weekday
        firstWeekday = getFirstWeekday(year, month, leapYear); //getFirstWeekday

        output(firstWeekday, length); //output

    }

    /*
    * Method Name:leapYearOrNot
    * Purpose of method: determine whether the year leap or not
    * Arguments:
    * int year - get the year need to be used
    * Return Value - a boolean type and name is leapYear if it is leap then return true otherwise false
    */
    public static boolean leapYearOrNot(int year){
        boolean leapYear;

        if ((year % 4 ==0 && year % 100 != 0) || year % 400 ==0) //leap year
            leapYear = true;
        else
            leapYear = false;

        return leapYear;
    }

    /*
    * Method Name:getLength
    * Purpose of method: print out the month name and get the length for that month
    * Arguments:
    * int month - get the month
    * boolean leapYear - determine the year leap or not
    * Return Value - a int length for that month
    */
    public static int getLength(int month, boolean leapYear){
        int length = 0;
        if (month == 1) {
            System.out.println("      January ");
            length = 31;
        }

        if (month == 2) {
            System.out.println("      February ");
            if (leapYear == true)
                length = 29;
            else
                length = 28;
        }

        if (month == 3) {
            System.out.println("      March ");
            length = 31;
        }

        if (month == 4) {
            System.out.println("      April ");
            length = 30;
        }

        if (month == 5) {
            System.out.println("      May ");
            length = 31;
        }

        if (month == 6) {
            System.out.println("      June ");
            length = 30;
        }

        if (month == 7) {
            System.out.println("      July ");
            length = 31;
        }

        if (month == 8) {
            System.out.println("      August ");
            length = 31;
        }

        if (month == 9) {
            System.out.println("      September ");
            length = 30;
        }

        if (month == 10) {
            System.out.println("      October ");
            length = 31;
        }

        if (month == 11) {
            System.out.println("      November ");
            length = 30;
        }

        if (month == 12) {
            System.out.println("      December ");
            length = 31;
        }
        return length;
    }


    /*
    * Method Name:getFirstWeekday
    * Purpose of method: get the first weekday for the first month
    * Arguments:
    * boolean leapYear - determine the year leap or not
    * int month - get the month
    * int year - get the input year
    * Return Value - the first weekday for the month in int type
    */
    public static int getFirstWeekday(int year, int month, boolean leapYear){
        int firstWeekday;
        int start = 1753; //start from 1753
        int sub = year - start; //the difference for input year and start year
        int sum = 0; //the days difference between input year and start year
        for (int i = 1; i <= sub; i++){
            if ((start % 4 ==0 && start % 100 != 0) || start % 400 ==0) { //leap year
                sum += 366;
            }
            else {
                sum += 365;
            }
            start++;
        }
        int sub2 = month - 1; //the month difference between the month and the 1st month for input year
        for(int j = 1; j <=sub2; j++){
            if(j == 1)
                sum += 31;
            if(j == 2) {
                if (leapYear == true)
                    sum += 29;
                else
                    sum += 28;
            }
            if(j == 3)
                sum += 31;
            if(j == 4)
                sum += 30;
            if(j == 5)
                sum += 31;
            if(j == 6)
                sum += 30;
            if(j == 7)
                sum += 31;
            if(j == 8)
                sum += 31;
            if(j == 9)
                sum += 30;
            if(j == 10)
                sum += 31;
            if(j == 11)
                sum += 30;

        }
        firstWeekday = sum % 7 + 1; //get the fist weekday for that month
                                   //sum % 7 is the day that finish so + 1 is the first weekday
        return firstWeekday;
    }

    /*
    * Method Name:output
    * Purpose of method: print out the rest information for that month
    * Arguments:
    * int firstWeekday - the start day for the month
    * int length - the length for that month
    * Return Value - void
    */
    public static void output(int firstWeekday, int length){
        int day = 1;
        System.out.println("Su Mo Tu We Th Fr Sa");
        String space = "";
        //sunday
        if (firstWeekday == 7) {
            space = " ";
        }
        //monday
        if (firstWeekday == 1) {
            space = "    ";
        }
        //tuesday
        if (firstWeekday == 2) {
            space = "       ";
        }
        //wednesday
        if (firstWeekday == 3) {
            space = "          ";
        }
        //thursday
        if (firstWeekday == 4) {
            space = "             ";
        }
        //friday
        if (firstWeekday == 5) {
            space = "                ";
        }
        //saturday
        if (firstWeekday == 6) {
            space = "                   ";
        }
        String line = space + day;

        while (day <= length){
            if (line.length() == 20 || day == length){ //the length of the line is 20 or the day reach the length
                                                       // of month
                System.out.println(line);  //print out the finished line
                day++;
                if(day >= 10) //reset the line with space and the day
                    line = "" + day;//Su
                                    //10
                else
                    line = " "  + day;//Su
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
