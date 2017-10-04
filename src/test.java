/*
* Junyu Liu
* Katie Pan
* 001E
*
* Assignment 4 - YearCalendar, CSc 210, Spring 2017
* It is a program that read in a input year and print out the calendar for input year
*/

import java.util.Scanner;

public class test {

    /*
    * main
    * call other methods and has some logic
    *
    * Arguments: String [] args
    * Return Value - void
    */
    public static void main(String [] args) {
        Scanner input = new Scanner(System.in); //read input year
        int year = 1;
        try{
            year = input.nextInt();
        }
        catch (Exception e){
            System.err.println("This is an invalid year.");
            System.exit(1);
        }

        if (year < 1753 || year > 3000) {
            System.err.println("This is an invalid year.");
            System.exit(1);
        }

        int month = 1;  //set month start from 1
        boolean leapYear;  //whether the input year leap or not
        leapYear = leapYearOrNot(year);  //leapyear method

        int firstWeekday = fisrtday( leapYear, month,year); //get the firstweekday for the first month

        String [] wholeYear = getArray();  //create a array with 12 (string)months in it

        fullInfoEachMonth(month, firstWeekday, wholeYear, leapYear); //add the full information fdr every month

        fullLength(wholeYear); //add the whole length to 180 for each month
        //because every 3 month can hold 9 lines max

        //print out the output for the input year and the format is every 3 months print out together
        output(wholeYear);
    }

    /*
    * Method Name: getArray
    * Purpose of method: initiate a array which contains 12 months in string type
    *
    * Arguments: no
    * Return Value - String []
    */
    public static String [] getArray(){
        //set the 12 months with month name and the weeks
        String S1 = "      January       Su Mo Tu We Th Fr Sa";
        String S2 = "      February      Su Mo Tu We Th Fr Sa";
        String S3 = "      March         Su Mo Tu We Th Fr Sa";
        String S4 = "      April         Su Mo Tu We Th Fr Sa";
        String S5 = "      May           Su Mo Tu We Th Fr Sa";
        String S6 = "      June          Su Mo Tu We Th Fr Sa";
        String S7 = "      July          Su Mo Tu We Th Fr Sa";
        String S8 = "      August        Su Mo Tu We Th Fr Sa";
        String S9 = "      September     Su Mo Tu We Th Fr Sa";
        String S10 = "      October       Su Mo Tu We Th Fr Sa";
        String S11 = "      November      Su Mo Tu We Th Fr Sa";
        String S12 = "      December      Su Mo Tu We Th Fr Sa";
        String [] arr = {S1, S2, S3, S4 ,S5, S6, S7, S8, S9, S10, S11, S12}; //add 12 months into array
        return arr;
    }

    /*
    * Method Name:fullInfoEachMonth
    * Purpose of method: add the full information for every month
    * Arguments:
    * int month - month start from 1
    * int firstWeekday - get the firstweekday
    * String [] wholeYear - get the arr which created from the getArray method
    * boolean leapYear - determine the year leap or not
    * Return Value - void
    */
    public static void fullInfoEachMonth(int month, int firstWeekday, String [] wholeYear,
                                         boolean leapYear){
        int length = 0;
        while (month <= 12){        //add the whole monthly information for each month
            int day = 1;
            String space = "";

            space = addSpace(space, firstWeekday); //add space function

            String line = space + day; //set the beginning line
            switch (month) { //12 months
                case 1:
                    length = 31;
                    wholeYear[0] = addInfo(wholeYear[0], day, length, line); //addInfo methods
                    break;

                case 2:
                    if (leapYear == true) //leapyear Feb 29days
                        length = 29;
                    else
                        length = 28;
                    wholeYear[1] = addInfo(wholeYear[1], day, length, line); //addInfo methods
                    break;

                case 3:
                    length = 31;
                    wholeYear[2] = addInfo(wholeYear[2], day, length, line); //addInfo methods
                    break;

                case 4:
                    length = 30;
                    wholeYear[3] = addInfo(wholeYear[3], day, length, line); //addInfo methods
                    break;

                case 5:
                    length = 31;
                    wholeYear[4] = addInfo(wholeYear[4], day, length, line); //addInfo methods
                    break;


                case 6:
                    length = 30;
                    wholeYear[5] = addInfo(wholeYear[5], day, length, line); //addInfo methods
                    break;

                case 7:
                    length = 31;
                    wholeYear[6] = addInfo(wholeYear[6], day, length, line); //addInfo methods
                    break;

                case 8:
                    length = 31;
                    wholeYear[7] = addInfo(wholeYear[7], day, length, line); //addInfo methods
                    break;

                case 9:
                    length = 30;
                    wholeYear[8] = addInfo(wholeYear[8], day, length, line); //addInfo methods
                    break;

                case 10:
                    length = 31;
                    wholeYear[9] = addInfo(wholeYear[9], day, length, line); //addInfo methods
                    break;

                case 11:
                    length = 30;
                    wholeYear[10] = addInfo(wholeYear[10], day, length, line); //addInfo methods
                    break;

                case 12:
                    length = 31;
                    wholeYear[11] = addInfo(wholeYear[11], day, length, line); //addInfo methods
                    break;
            }
            month++; //next month

            int remainder = length % 7 + firstWeekday; //calculate the next firstweekday for next month

            if (remainder > 7) //when the remainder > 7, % 7 again get the first week day
                remainder %= 7;

            firstWeekday = remainder;
        }
    }

    /*
    * Method Name:output
    * Purpose of method: print out the result
    * Arguments:
    * String [] wholeYear - get the arr which created from the getArray method
    * Return Value - void
    */
    public static void output(String [] arr){
        for (int i = 0; i < arr.length; i += 3) {
            for (int k = 0; k <= 160; k += 20) {
                System.out.println(arr[i].substring(k, k + 20) + "  " + arr[i+1].substring(k, k + 20) + "  "
                        + arr[i+2].substring(k, k + 20));
            }
        }
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
    * Method Name:addInfo
    * Purpose of method: add information for each month
    * Arguments:
    * String [] month - it is a element from the array and it is added information
    * int day - each day in this month start from 1
    * int length - the length for month
    * String line - the beginning line for each month
    * Return Value - return the whole month information in string type
    */
    public static String addInfo(String month, int day, int length, String line){
        while (day <= length){ //stop until the day = length + 1
            if (line.length() == 20 || day == length){ //the length of the line is 20 or the day reach the length
                // of month

                month += (line); //this month add this line
                day++;
                if(day >= 10)  //reset the beginning line for each line
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
        return month;
    }

    /*
    * Method Name:fisrtday
    * Purpose of method: get the first weekday for the first month
    * Arguments:
    * boolean leapYear - determine the year leap or not
    * int month - get the month
    * int year - get the input year
    * Return Value - the first weekday for the month in int type
    */
    public static int fisrtday(boolean leapYear, int month, int year){
        int start = 1753; //start from 1753
        int sub = year - start; //the difference for input year and start year
        int sum = 0; //the days difference between input year and start year
        for (int i = 1; i <= sub; i++){
            if ((start % 4 ==0 && start % 100 != 0) || start % 400 ==0) { //leap year
                sum += 366;
            }
            else { //not leap year
                sum += 365;
            }
            start++;
        }
        int sub2 = month - 1; //the month difference between the month and the 1st month for input year
        for(int j = 1; j <=sub2; j++){
            //plus every month days
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
        int firstWeekday = sum % 7 + 1; //get the fist weekday for that month
        //sum % 7 is the day that finish so + 1 is the first weekday
        return firstWeekday;
    }

    /*
    * Method Name:fullLength
    * Purpose of method: add every month to 180 length in string type
    * Arguments:
    * String [] wholeYear - a array contains 12 months
    * Return Value - void
    */
    public static void fullLength(String [] wholeYear){
        for (int i  = 0; i < wholeYear.length; i++){
            while (wholeYear[i].length() < 180){ //because the number of line of output for every month <= 9
                //and every line length = 20
                wholeYear[i] += (" ");
            }
        }
    }



    /*
    * Method Name:addSpace
    * Purpose of method: add space before every firstWeekday
    * Arguments:
    * String space - get the space in string type
    * int firstWeekday - get the first weekday
    * Return Value - return the space needed before the firstweekday
    */
    public static String addSpace(String space, int firstWeekday){
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
        //satuarday
        if (firstWeekday == 6) {
            space = "                   ";
        }
        return space;
    }
}
