
/**
 * Just individual with attributes of name, ID, and date of birth.
 *
 * @author Ali Amer 
 * @version 01/09/2024
 */
public class Person
{
    private String _name;
    private String _id;
    private Date _dateOfBirth;
    private static final String DEFAULT_ID="000000000",DEFAULT_NAME="Someone";
    private static final  int ID_LENGTH=9;
    /*
     * private method Validates whether a given name is vaild.
     */
    private boolean isValidName(String name )
    {
        return name!="";
    }

    /*
     * Validates whether a given ID has a length of 9.
     */
    private boolean isValidId(String id )
    { 
        if (id.length()==ID_LENGTH)
            return true;
        return false;
    }
    //Constructors
    /**
     * Constructs a Person object .
     *  If name is an empty string, assign the default string "Someone"
     *  If id doesn't contain 9 digits, assign the default string "000000000"
     *
     * @param name   The name of the person.
     * @param day    The day  of the date of birth.
     * @param month  The month of the date of birth.
     * @param year   The year  of the date of birth.
     * @param id     The ID of the person.
     */
    public Person(String name,int day, int month ,int year ,String id)
    {
        if(isValidName(name))//check the day validtion according to the api using the private method
            _name=name;
        else
        {
            _name=DEFAULT_NAME;
        }

        if(isValidId(id))//check the id validtion according to the api using the private method
            _id=id;
        else
            _id=DEFAULT_ID;
        _dateOfBirth=new Date(day,month,year);
    }

    /**
     * copy Constructor.
     *
     * @param other The Person object to copy.
     */
    public Person(Person other)
    {
        if(other!=null)
        {
            _name=other._name;
            _id=other._id;
            _dateOfBirth=new Date(other._dateOfBirth);
        }
    }
    //getters
    /**
     * Gets the name of the person.
     *
     * @return The name of the person.
     */
    public String getName()
    {
        return _name;
    }

    /**
     * Gets the ID of the person.
     *
     * @return The ID of the person.
     */
    public String getId()
    {
        return _id;
    }

    /**
     * Gets the date of birth of the person.
     *
     * @return The date of birth of the person.
     */
    public Date getDateOfBirth()
    {
        return  new Date(_dateOfBirth);
    }
    //setters
    /**
     * Sets the person's name (only if the string given is not empty)
     * 
     * @param name The new name value.
     */
    public void setName(String name)
    {
        if(isValidName(name))//if checks name validation
            _name=name;

    }

    /**
     *Sets the person's id (only if the id is 9 digits)
     *
     * @param id The new ID value.
     */
    public void setId(String id)
    {
        if(isValidId(id))//if checks id validation
            _id=id;

    }

    /**
     * Sets the date of birth of the person.
     *
     * @param d The new date of birth value.
     */
    public void setDateOfBirth(Date d)
    {
        _dateOfBirth=new Date(d);
    }

    /**
     *representation of the person.
     *
     * @return The string representation of the person.
     */
    public String toString()
    {
        return "Name: "+_name+"\nID: "+_id+"\nDate of birth: "+_dateOfBirth.toString();//string for Person class
    }

    /**
     * Checks if two Person objects are equal.
     *
     * @param other The Person object .
     * @return True if all the attributes are the same.
    .
     */
    public boolean equals(Person other)
    {
        if (_name.equals(other._name)&&_id.equals(other._id)&&_dateOfBirth.equals(other._dateOfBirth))
        //"if" checks Person equalion based on their name, ID, and date of birth 
        { return true;}
        return false;
    }

    /**
     * Checks which person is older.
     *
     * @param other The Person object .
     * @return 1 if the current person's date of birth is older then the other person's,
     *         -1 if younger, and 0  If both people have the same birth date .
     */ 
    public int compareTo(Person other)
    {
        if(_dateOfBirth.before(other._dateOfBirth))//uss method from date class to compare ages.
            return 1;
        if(_dateOfBirth.after(other._dateOfBirth))//uses method from date class to compare ages.
            return -1;
        return 0;
    }

}

