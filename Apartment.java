
/**
 * Just apartment with various attributes.
 *
 * @author Ali Amer 211614136
 * @version 01/09/2024
 */
public class Apartment
{
    private int _noOfRooms;
    private double _area;
    private double _price;
    private Person _tenant;
    private Date _rentalStartDate,_rentalEndDate;
    private final int DEFAULT_NO_OF_ROOMS =3;
    private final double  AREA=80, PRICE=5000;
    private final int ZERO=0,DEF_YEARS_TO_DAY=1,MAX_DAYS_TO_SWAP=90,YOUNGER_TENANT=-1;
    //private method helps to check if the number is postive
    private boolean isPostiveNum(double num)
    {
        if(num>ZERO)//if checks if number is higher then zero
            return true ;
        return false;
    }
    //Constructor
    /**
     * Constructor of the Apartment class .
     *
     * @param noOfRooms    Number of rooms in the apartment.
     * @param area         Area of the apartment.
     * @param price        Price of the apartment.
     * @param tenant       Tenant .
     * @param startDay     Start day of the rental period.
     * @param startMonth   Start month of the rental period.
     * @param startYear    Start year of the rental period.
     * @param endDay       Last day of the rental period.
     * @param endMonth     Last month of the rental period.
     * @param endYear      Last year of the rental period.
     */

    public Apartment(int noOfRooms ,double area ,double price,Person
    tenant ,int startDay ,int startMonth, int startYear,
    int endDay,int endMonth, int endYear)
    {//3ifs checks if the number of rooms annd area and price is postive
        if(isPostiveNum(noOfRooms))
            _noOfRooms=noOfRooms;
        else
            _noOfRooms=DEFAULT_NO_OF_ROOMS;
        if(isPostiveNum(area))
            _area=area;
        else
            _area=AREA;
        if(isPostiveNum(price))
            _price=price;
        else
            _price=PRICE;
        _tenant=new Person(tenant);
        _rentalStartDate=new Date(startDay,startMonth,startYear);
        //created object for end rental date  in order to  check him with other Date object
        _rentalEndDate=new Date(endDay,endMonth,endYear);
        //checking if the rental end date comes after the rental start date using method from date class
        if(_rentalEndDate.after(_rentalStartDate))
            _rentalEndDate=new Date(_rentalEndDate);
        else
            _rentalEndDate=_rentalStartDate.addYearsToDate(DEF_YEARS_TO_DAY);
    }

    /**
     * Creates a copy of the given Apartment object.
     *
     * @param other  Apartment object to copy.
     */
    public Apartment(Apartment other)
    {
        _noOfRooms=other._noOfRooms;
        _area=other._area;
        _price=other._price;
        _tenant=new Person(other._tenant);
        _rentalStartDate=new Date(other._rentalStartDate);
        _rentalEndDate= new  Date(other._rentalEndDate);

    }
    //getters
    /**
     *  number of rooms in the apartment.
     *
     * @return The number of rooms.
     */
    public int getNoOfRooms()
    {
        return _noOfRooms; 
    }

    /**
     * Gets the area of the apartment.
     *
     * @return The area.
     */
    public double getArea()
    {
        return _area;
    }

    /**
     * Gets the price of the apartment.
     *
     * @return The price.
     */
    public double getPrice()
    {
        return _price;
    }

    /**
     * Gets the tenant renting the apartment.
     *
     * @return The tenant.
     */
    public Person getTenant()
    {
        return  new Person(_tenant);//anti alaising
    }

    /**
     * Gets the rental start date.
     *
     * @return The rental start date.
     */
    public Date getRentalStartDate()
    {
        return new Date( _rentalStartDate);
    }

    /**
     * Gets the rental end date.
     *
     * @return The rental end date.
     */
    public Date getRentalEndDate()
    {
        return new Date(_rentalEndDate);
    }

    /**
     * Sets the apartment's number of rooms (only if the new value is positive).
     *
     * @param num The number of rooms to set.
     */
    public void setNoOfRooms(int num)
    {
        if (isPostiveNum(num))  //condition to check if the number positive
            _noOfRooms=num;
    }

    /**
     * Sets the apartment's area (only if the new value is positive).
     *
     * @param area The area to set.
     */
    public void setArea(double area)
    {
        if (isPostiveNum(area))  //condition to check if the number positive
            _area=area;
    }

    /**
     * Sets the apartment's price (only if the new value is positive).
     *
     * @param price The price to set.
     */
    public void setPrice(double price)
    {
        if (isPostiveNum(price))  //condition to check if the number positive
            _price=price;
    }

    /**
     * Sets the tenant .
     *
     * @param p The tenant to set.
     */
    public void setTenant(Person p)
    {
        _tenant=new Person(p);
    }

    /**
     * Sets the apartment's rental start date (only if the new rental start date is before the current rental end date).
     *
     * @param d The new rental start date to set.
     */
    public void setRentalStartDate(Date d)
    {
        if(d.before(_rentalEndDate))//condition to check if the rentalStarts comes before rental end date.
            _rentalStartDate=new Date(d);
    }

    /**
     * Sets the apartment's rental end date (only if the new rental end date is after the current rental start date).
     *
     * @param d The new rental end date to set.
     */
    public void setRentalEndDate(Date d)
    {
        if(d.after(_rentalStartDate))//condition to check if the rentalend comes after rental start date.
            _rentalEndDate=new Date(d);
    }

    /**
     * representation of the apartment.
     *
     * @return A string representing the apartment.
     */
    public String toString()
    {//string to representation the aparment
        return "Number of rooms: " +_noOfRooms +"\nArea: "
        +_area+"\nPrice: "+_price+" NIS"+"\nTenant name: "+_tenant.getName()
        +"\nRental start date: "+_rentalStartDate.toString()+"\nRental end date: "
        +_rentalEndDate.toString(); 

    }

    /**
     * Checks if two apartments are equal.
     *
     * @param other Another Apartment object .
     * @return true if the apartments are equal,  otherwise false.
     */
    public boolean equals(Apartment other)
    {//condition to check if everything is equals between 2 different  objects
        if(_noOfRooms==other._noOfRooms&&_area==other._area&&
        _price==other._price&&_tenant.equals(other._tenant)&&
        _rentalStartDate.equals(other._rentalStartDate)&&
        _rentalEndDate.equals(other._rentalEndDate))
            return true;
        return false;

    }

    /**
     * Extends the rental period by additional years(only if the years value is positive)
     *
     * @param years The number of years to extend the rental period.
     */
    public void extendRentalPeriod( int years)
    {
        if(isPostiveNum(years))
            _rentalEndDate=_rentalEndDate.addYearsToDate(years);//extendRental using method from date class
    }

    /**
     * Computes the number of days left between a given date and the end of rental date.
     * If the given date comes after the end of rental date, returns -1.
     *
     * @param d The date to check.
     * @return The number of days left in the rental period.
     */
    public int daysLeft(Date d)
    {
        if (_rentalEndDate.after(d))//checks if the given date before or equals end rental date and calculate the differnce
            return _rentalEndDate.difference(d);
        return -1;
    }

    /**
     * Checks if the apartment's tenant can be replaced and update apartment attributes accordingly 
     * ( if the tenant is younger, the rental end date ends up to 90 days after the new rental start date
     * and the new price is at least the current rental's price)
    .
     *
     * @param startDate The new rental start date.
     * @param p         The new tenant.
     * @param price     The new price.
     * @return true if the tenant has been changed.
     */
    public boolean changeTenant(Date startDate ,Person p,double price)
    {   //if checks the new tenant younger then current one and other and willing to pay equal or more then the current one and 
        //90 or less  days in the current tenant contract.
        if(p.compareTo(_tenant)==YOUNGER_TENANT&&
        _rentalEndDate.difference(startDate)<=MAX_DAYS_TO_SWAP&&_price<=price&&startDate.before(_rentalEndDate))
        {
            setRentalStartDate(startDate);
            setTenant(p);
            setPrice(price);
            setRentalEndDate(startDate.addYearsToDate(DEF_YEARS_TO_DAY));
            return true;
        }
        return false;
    }
}
