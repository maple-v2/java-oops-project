
/**
 *Just normal date .
 *
 * @author Ali Amer 211614136
 * @version 01/09/2024
 */
public class Date
{
    private int _day; 
    private int _month; 
    private int _year; 
    private static final int DEFAULT_DAY=1,DEFAULT_MONTH=1,DEFAULT_YEAR=2000;
    private static final int MONTH_WITH_31_DAY=31,MONTH_WITH_30_DAYS=30,MAX_YEAR=9999 ,MIN_YEAR=1000;
    private static final int MONTH_WITH_28_DAY=28, MONTH_WITH_29_DAY=29,TWO_DIGITS_NUMBER=10;
    private static final int JANUARY=1 ,FEBRUARY=2, MARCH=3,APRIL=4,MAY=5,JUNE=6,JULY=7,AUGUST=8,SEPTEMBER=9,OCTOBER=10,NOVEMBER=11,DECEMBER=12;
    /*
     * private method to check whether the given day, month, and year form a valid date.
     */

    private boolean validDate(int day, int month,int year)
    {
        if(year>MAX_YEAR||year<MIN_YEAR||month<JANUARY||month>DECEMBER||day<1||day>MONTH_WITH_31_DAY)
        //checks an overall date validtion
            return false;
        else if(month==JANUARY ||month==MARCH||month==MAY||month==JULY||month==AUGUST||month==OCTOBER||month==DECEMBER)
        //checks month with 31 days
        {
            return true;
        }
        else if (day<=MONTH_WITH_30_DAYS&&(month==APRIL ||month==JUNE||month==SEPTEMBER||month==NOVEMBER))
        {//checks the month with 30 day
            return true;
        }
        else if(isLeapYear(year)&&day<=MONTH_WITH_29_DAY&&month==FEBRUARY)
        {//checks leap years  (february with 29 day)
            return true;
        }
        else if(month==FEBRUARY&&!isLeapYear(year)&&day<=MONTH_WITH_28_DAY)
        {//checks the !leapyears (february with 28 day)
            return true;
        }
        return false;

    }
    //constructors
    /**
     * Date constructor - If the given date is valid - creates a new Date object, otherwise creates the date 01/01/2000.
     *
     * @param day   The day  in the month.
     * @param month The month  in  the year.
     * @param year  The year  of 4 digits.
     */
    public Date(int day, int month,int year)
    {
        if(validDate(day,month,year))//checks if the day valid using the private method i created in date class
        {
            _day=day;
            _month=month;
            _year=year;
        }
        else
        {
            _day=DEFAULT_DAY;
            _month=DEFAULT_MONTH;
            _year=DEFAULT_YEAR;
        }
    }

    /**
     * Copy constructor.
     * 
     *
     * @param other the date to be copied.
     */
    public Date (Date other)
    {

        if(other!=null)//checks if the other object isnt null
        { 
            _day=other._day;
            _month=other._month;
            _year=other._year;
        }

    }
    //getters
    /**
     * Gets the day  .
     * @return The day of this date.
     */
    public int getDay()
    {
        return _day; 
    }

    /**
     * Gets the month.
     *
     * @return The month of this date.
     */
    public int getMonth()
    {
        return _month;
    }   

    /**
     * Gets the year.
     *
     * @return The year of this date.
     */
    public int getYear()
    {
        return _year;
    }
    //setters
    /**
     * Sets the Day (only if date remains valid) 
     * @param dayToSet The new day value.
     */
    public void setDay(int dayToSet)
    {
        if(validDate(dayToSet,_month,_year))
            _day=dayToSet;
    }

    /**
     *   Sets the month (only if date remains valid)   
     *
     * @param monthToSet The new month value.
     */
    public void  setMonth(int monthToSet)
    {
        if(validDate(_day,monthToSet,_year))
        {
            _month=monthToSet;
        }
    }

    /**
     * Sets the month (only if date remains valid)  .
     * 
     *
     * @param yearToSet The new year value.
     */
    public void setYear(int yearToSet)
    {
        if(validDate(_day,_month,yearToSet))
            _year=yearToSet;
    }

    /**
     * Checks if two Dates are the same .
     *
     * @param other The Date object to compare with.
     * @return True if the dates are equal.
     */
    public boolean equals (Date other)
    {
        if(_day==other._day&&_month==other._month&&_year==other._year)//if checks if the day and month and year equals
            return true;
        return false;
    }

    /**
     * Checks if the current Date is before another Date.
     *
     * @param other The Date to compare with.
     * @return True if the current date is before the other date.
     */
    public boolean before (Date other) 
    {
        if(_year<other._year||_month<other._month&&_year==other._year||_day<other._day&&_month==other._month&&_year==other._year)
        // if checks the current year of  date before the other year the that the method gets and if the years are equals
        //check if the month is before the other month same thing for the days.  
            return true;
        return false;
    }

    /**
     * Checks if the current Date is after another Date.
     *
     * @param other The Date to compare with.
     * @return True if the current date is after the other date.
     */
    public boolean after (Date other)
    {
        return other.before(this);//checks if the date the method gets is aftter the current date using the before method.
    }

    /*
     * Calculates a date value based on the given day, month, and year.
     * This is an private method .
     *
     */
    private int calculateDate ( int day, int month, int year)
    {
        if (month < 3) {
            year--;
            month = month + 12;
        }
        return 365 * year + year/4 - year/100 + year/400 + ((month+1) * 306)/10 + (day - 62);
    }

    /**
     * Calculates the  difference in days between the current date and another date.
     *
     * @param other The Date to calculate the difference with.
     * @return The absolute difference in days.
     */
    public int difference (Date other) 
    {
        return Math.abs(calculateDate ( _day, _month, _year)-calculateDate ( other._day, other._month,other. _year));
    }

    /**
     * Generates date in this format (DD/MM/YYYY).
     *
     * @return The  date string.
     */
    public String toString() 
    {

        if(_day<TWO_DIGITS_NUMBER&&_month<TWO_DIGITS_NUMBER)//condition to adjust the date to (DD/MM/YYYY) format
            return "0"+_day+"/0"+_month+"/"+_year;
        else if (_month<TWO_DIGITS_NUMBER)
            return _day+"/0"+_month+"/"+_year;
        else if (_day<TWO_DIGITS_NUMBER)
            return "0"+_day+"/"+_month+"/"+_year;
        return _day+"/"+_month+"/"+_year;

    }

    /*
     * Checks if a given year is a leap year.
     *this is an private method for the Date class
     */
    private boolean isLeapYear (int y)
    {
        return (y%4==0 && y%100!=0) || (y%400==0) ? true : false;
    } 

    /**
     * Returns a new Date which is the current date after adding a number of years to it 
     *
     * @param num The number of years to add.
     * @return A new Date object representing the date after adding the specified years.
     */
    public Date addYearsToDate(int num)
    {
        if(num>0){
            if(_day==MONTH_WITH_28_DAY&&_month==FEBRUARY&&isLeapYear(_year+num))//adjust the day of the month according to the year
                return new Date(MONTH_WITH_29_DAY, _month, _year+num);
            if(_day==MONTH_WITH_29_DAY&&_month==FEBRUARY&&!isLeapYear(_year+num))//adjust the day of the month according to the year
                return  new Date(MONTH_WITH_28_DAY, _month, _year+num);
            return new Date(_day, _month, _year+num);
        }
        return new Date(_day, _month, _year);
    }

}

