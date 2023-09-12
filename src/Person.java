import java.util.Calendar;
import java.util.concurrent.Callable;

public class Person {
    private String id;
    private String firstName;
    private String lastName;
    private String title;
    private int dateOfBirth;

    //Constructors

    public Person(String id, String firstName, String lastName, String title, int dateOfBirth) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
        this.dateOfBirth = dateOfBirth;
    }

    // Getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(int dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    //start of using some unique methods
    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", title='" + title + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }

    //Converts everything to a csv
    public String toCSV(){
        return id + ", " + firstName + ", " + lastName + ", " + title + ", " + dateOfBirth;
    }

    public String fullName(){
        return firstName + ", " + lastName;
    }

    public String formalName(){
        return title + ", " + firstName + ", " + lastName;
    }

    public int getAge(){
        int age = 2023 - dateOfBirth;
        return age;
    }

    public int getAgeForYear(int year){
        Calendar currentCalendar = Calendar.getInstance();
        int currentYear  = currentCalendar.get(Calendar.YEAR);

        Calendar birthdateCalendar = Calendar.getInstance();
        birthdateCalendar.set(Calendar.YEAR, dateOfBirth);

        int calcAge = year - birthdateCalendar.get(Calendar.YEAR);

        return calcAge;

    }


}

