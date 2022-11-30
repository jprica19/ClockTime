
/**
 * Name: Jordan Prica
 * Course: CSCI 241 - Computer Science I
 * Section: 001 <-- choose your section
 * Assignment: 9
 *
 * Project/Class Description:
 * This is an instantiable class that will use three ClockTime objects 
 * with three private data fields.  This type of object will keep time
 * in the 24 hout format.  This class will have two constructors and have
 * methods to calculate and compare.
 *
 * Known bugs:
 * I believe that I had issues with the constructors. 
 */
public class ClockTime
{
    // Declare hour as a private int datafield
    private static int hour;
    
    // Declare minute as a private int datafield
    private static int minute;
    
    // Declare second as a private int datafield
    private static int second;
    
    // Create a default contstructor with no parameters
    // Initialize each datafield to 0
    ClockTime(){
        hour = 0;
        minute = 0;
        second = 0;
    }
    // Create a constructor that takes 3 integer parameters, holding the hour
    // minute, and second values to which the ClockTime object is initialized
    ClockTime(int hour, int minute, int second){
        // Set the instance variables to the values provided
        this.hour = hour;
        this.minute = minute;
        this.second = second;
        
        // Set up if statements for each instance variable to error check
        // Re-initialize each instance variable if need be
        if(second > 59){
            // use mod 60 to make it 59 or lower
            this.second = second % 60;
            // add the extra minutes to the minutes parameter
            minute++;
        }else if (second < 0){
            // Initialize second to 0 if negative
            this.second = 0;
        }
        
        if(minute > 59){
            // use mod 60 to make it 59 or lower
            this.minute = minute % 60;
            // add the hour value to the hours parameter
            hour++;
        }else if (minute < 0){
            // Initialize minute to 0 if negative
            this.minute = 0;
        }
        
        if(hour > 24){
            // use mod 24 to make it 23 or lower
            this.hour = hour % 24;
        }else if (hour < 0){
            // Initialize hour to 0 if negative
            this.hour = 0;
        }
    }
    
    // This method gets the hour and returns it
    public int getHour(){
        return hour;
    }
    
    // This method gets the minutes and returns it
    public int getMinute(){
        return minute;
    }
    
    // This method gets the seconds and returns it
    public int getSecond(){
        return second;
    }
    
    // This method will set the hour in integers, and not return anything
    public void setHour(int hour){
        // check the range with the constructor's if statement
            if(hour > 24){
            // use mod 24 to make it 23 or lower
            this.hour = hour % 24;
        }else if (hour < 0){
            // Initialize hour to 0 if negative
            this.hour = 0;
        }
    }
    
    // This method will set the minutes in integers, and not return anything
    public void setMinute(int minute){
        // check the range with the constructor's if statement
         if(minute > 59){
            // use mod 60 to make it 59 or lower
            this.minute = minute % 60;
            // add the hour value to the hours parameter
            hour++;
        }else if (minute < 0){
            // Initialize minute to 0 if negative
            this.minute = 0;
        }
    }
    
    // This method will set the seconds in integers, and not return anything
    public void setSecond(int second){
        // check the range with the constructor's if statement
           if(second > 59){
            // use mod 60 to make it 59 or lower
            this.second = second % 60;
            // add the extra minutes to the minutes parameter
            minute++;
        }else if (second < 0){
            // Initialize second to 0 if negative
            this.second = 0;
        }
    }
    
    // This method will create and return a string that holds the clock's
    // time in 24-hour format.  Does not contain AM or PM
    public String toString(){
        return hour + ":" + minute + ":" + second;
   }
   
    // This method will create and return a string that holds the clock's time
    // in 12-hour format and will include AM instead of PM when appropriate
    public String toString12(){
        // Declare AMPM as a String value
        String ampm = "";
        // Declare hour as an integer value
        int hour = 0;
        
        // Set up if statements to find the correct hour
        // and add AM and PM to time
        if (hour >= 12 && hour <= 23){
            ampm = "PM";
            hour = hour - 12;
        } else if (hour == 0){
            hour = 12;
            ampm = "AM";
        }else{
            ampm = "AM";
            hour = hour;
        }
        return hour + ":" + minute + ":" + second + ampm;
    }
    //  This method takes a positive integer as input and advances the ClockTime
    // Object by that many seconds
    public void advance(int number){
        // Create a while loop for the number of seconds if they exceed 60
        while(number == second && this.second > 60){
            minute++;
        }
        // Create a while loop for the number of minutes if they exceed 60
        while(number == minute && this.minute > 60){
            hour++;
        }
        // Create a while loop for the number of hours if they exceed 24
        while(number == hour && this.hour > 24){
            hour = hour % 24;
        }
    }
    
    // This method checks to see if the current ClockTime contains the same
    // values as the one sent in the parameter. If so, returns true and false
    // otherwise
    public boolean equals(ClockTime clock){
        return(this.hour == clock.getHour() && this.minute == clock.getMinute()
        && this.second == clock.getSecond());
    }
}
