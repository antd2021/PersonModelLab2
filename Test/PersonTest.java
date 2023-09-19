import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    //Create object
    Person p1, p2, p3, p4;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        p1 = new Person("00001", "Anthony" , "Tester1" , "Stu" , 2003);
        p2 = new Person("00002", "Colton" , "Tester2" , "Stu" , 2003);
        p3 = new Person("00003", "Adam" , "Tester3" , "Stu" , 2003);
        p4 = new Person("00001", "Dlyan" , "DiNinno" , "Stu" , 2002);
    }

    @org.junit.jupiter.api.Test
    void getId() {assertEquals ("00001" , p1.getId());}

    @org.junit.jupiter.api.Test
    void setId() {
        p1.setId("00002");
        assertEquals ("00002" , p1.getId());
    }

    @org.junit.jupiter.api.Test
    void getFirstName() {assertEquals ("Anthony" , p1.getFirstName());}

    @org.junit.jupiter.api.Test
    void setFirstName() {
        p1.setFirstName("Colton");
        assertEquals ("Colton" , p1.getFirstName());
    }

    @org.junit.jupiter.api.Test
    void getLastName() {assertEquals ("Tester1" , p1.getLastName());}

    @org.junit.jupiter.api.Test
    void setLastName() {
        p1.setLastName("Tester2");
        assertEquals ("Tester2" , p1.getLastName());
    }

    @org.junit.jupiter.api.Test
    void getTitle() {assertEquals ("Stu" , p1.getTitle());}

    @org.junit.jupiter.api.Test
    void setTitle() {
        p1.setTitle("Prof");
        assertEquals ("Prof" , p1.getTitle());
    }

    @org.junit.jupiter.api.Test
    void getDateOfBirth() {assertEquals (2003 , p1.getDateOfBirth());}

    @org.junit.jupiter.api.Test
    void setDateOfBirth() {
        p1.setDateOfBirth(2002);
        assertEquals (2002 , p1.getDateOfBirth());
    }

    @org.junit.jupiter.api.Test
    void testToString() {
        String expected = "Person{id='00001', firstName='Anthony', lastName='Tester1', title='Stu', dateOfBirth=2003}";
        assertEquals(expected, p1.toString());
    }

    @org.junit.jupiter.api.Test
    void toCSV() {
        String expected = "00001, Anthony, Tester1, Stu, 2003";
        assertEquals(expected, p1.toCSV());
    }

    @org.junit.jupiter.api.Test
    void fullName() {
        assertEquals("Anthony, Tester1", p1.fullName());
    }

    @org.junit.jupiter.api.Test
    void formalName() {
        assertEquals("Stu, Anthony, Tester1", p1.formalName());
    }

    @org.junit.jupiter.api.Test
    void getAge() {
        int expectedAge = 2023 - 2003;
        assertEquals(expectedAge, p1.getAge());
    }

    @org.junit.jupiter.api.Test
    void getAgeForYear() {
        int year = 2030;
        int expectedAge = year - 2003;
        assertEquals(expectedAge, p1.getAgeForYear(year));
    }
}