package ie.gmit;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;


public class EmployeeTest {
    Employee employee;

    @BeforeAll
    static void  startingTest() {
        System.out.println("Starting tests");

    }


    @BeforeEach
    void printDisplayNames(TestInfo testInfo, TestReporter testReporter){
        testReporter.publishEntry(testInfo.getDisplayName());
    }

    @AfterAll
    static void testingComplete(){
        System.out.println("Testing Completed");
    }

    @DisplayName("Testing For Success")
    @Test
    void testingConstructorSuccess(){
        employee = new Employee("Mr","Daenkai",
                "Full-Time","123456",1234567,24);
        assertEquals("Mr", employee.getTitle());
        assertEquals("Daenkai", employee.getName());
        assertEquals("Full-Time", employee.getEmploymentType());
        assertEquals("123456", employee.getPpsNumber());
        assertEquals(1234567, employee.getPhone());
        assertEquals(24, employee.getAge());
    }

    // Testing for Failures.....

    @DisplayName("Testing Invalid Name")
    @Test
    void testingInvalidName(){
        Exception e = assertThrows(IllegalArgumentException.class, () ->{
            employee = new Employee("Mr", "Four", "Full-Time", "123456",
                    1234567, 24); // put characters in name less than 5
        });
        assertEquals("Name must have minimum of 5 characters and maximum of 22 characters", e.getMessage());
    }


      @DisplayName("Testing Invalid EmploymentType")
    @Test
    void testingInvalidEmploymentType(){
        Exception e = assertThrows(IllegalArgumentException.class, () ->{
            employee = new Employee("Mr", "Daenkai", "No-Time", "123456",
                    1234567, 24); // put thr wrong employmentType in
        });
        assertEquals("Invalid Employment Type", e.getMessage());
    }


    @DisplayName("Testing Invalid Age")
    @Test
    void testingInvalidAge(){
        Exception e = assertThrows(IllegalArgumentException.class, () ->{
            employee = new Employee("Mr", "Daenkai", "Full-Time", "123456",
                    1234567, 16); // making age less than 18
        });
        assertEquals("Age must be over 18 to work in this company!", e.getMessage());
    }

    @DisplayName("Testing Invalid Phone")
    @Test
    void testingInvalidPhone(){
        Exception e = assertThrows(IllegalArgumentException.class, () ->{
            employee = new Employee("Mr", "Daenkai", "Full-Time", "123456",
                    123456790, 24); // making phone number more than 7 digits
        });
        assertEquals("Invalid Phone Number, must be a 7 digits", e.getMessage());
    }

}

