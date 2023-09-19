import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WorkerTest{

    Worker w1, w2, w3, w4;
    @BeforeEach
    void setUp(){
        w1 = new Worker("00001", "Anthony" , "Tester1" , "Stu" , 2003 , 18.0);
        w2 = new Worker("00002", "Colton" , "Tester2" , "Stu" , 2003 , 19.0);
        w3 = new Worker("00003", "Adam" , "Tester3" , "Stu" , 2003 , 20.0);
        w4 = new Worker("00001", "Dlyan" , "DiNinno" , "Stu" , 2002 , 21.0);

    }
    @Test
    void getHourlyPayRate() {assertEquals (18.0 ,w1.getHourlyPayRate());}

    @Test
    void setHourlyPayRate() {
        w1.setHourlyPayRate(20.0);
        assertEquals (20.0 , w1.getHourlyPayRate());
    }

    @Test
    void testToString() {
        String expected = "Worker{" +
                "id='00001', " +
                "firstName='Anthony', " +
                "lastName='Tester1', " +
                "title='Stu', " +
                "dateOfBirth=2003" +
                "hourlyPayRate=18.0" +
                '}';
        assertEquals(expected, w1.toString());
    }

    @Test
    void calculateWeeklyPay() {
        double expectedPay = (40 * 18.0) + (5 * 18.0 * 1.5);
        assertEquals(expectedPay, w1.calculateWeeklyPay(45));
    }

    @Test
    void displayWeeklyPay() {
        // Assuming the worker worked 45 hours in a week
        // Expected display format
        String expected = "Weekly Pay Details:\n" +
                "Regular Hours (40 hours) at $18.0/hour: $720.0\n" +
                "Overtime Hours (5 hours) at $27.0/hour: $135.0\n" +
                "Total Pay: $855.0";
        assertEquals(expected, w1.displayWeeklyPay(45));
    }
}