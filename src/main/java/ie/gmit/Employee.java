package ie.gmit;

public class Employee {

    private String name = "";
    private String employmentType = "";
    private String ppsNumber = "";
    private long phone = 0;
    private int age = 0;
    private String title = "";

    //Constructor
    public Employee(String title, String name, String employmentType, String ppsNumber, long phone, int age) {
        this.title = title;
        this.name = name;
        this.employmentType = employmentType;
        this.ppsNumber = ppsNumber;
        this.phone = phone;
        this.age = age;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name.length() < 5 || name.length() > 22)
            throw new IllegalArgumentException("Name must have minimum of 5 characters and maximum of 22 characters");
        else
            this.name = name;
    }

    public String getEmploymentType() {
        return  employmentType;

    }

    public void setEmploymentType(String employmentType) {
        if(employmentType == "Part-Time" || employmentType == "Full-Time")
            this.employmentType = employmentType;
        else
            throw new IllegalArgumentException("Invalid Employment Type");
    }

    public String getPpsNumber() {
        return ppsNumber;
    }

    public void setPpsNumber(String ppsNumber) {
        if(ppsNumber.length() < 6)
            throw new IllegalArgumentException("Invalid PPS Number, must contain minimum of 6 characters");
        else
            this.ppsNumber = ppsNumber;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        if(String.valueOf(phone).length() < 7 || String.valueOf(phone).length() > 7)
            throw new IllegalArgumentException("Invalid Phone Number, must be a 7 digits");
        else
            this.phone = phone;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if(age < 18)
            throw new IllegalArgumentException("Age must be over 18 to work in this company!");
        else
            this.age = age;
    }

    public String getTitle() {

        return title;
    }

    public void setTitle(String title) {
        if(title == "Mr" || title == "Mrs" || title == "Miss") {
            this.title = title;
        }
        else {
            throw new IllegalArgumentException("Invalid Title Provided!");
        }
    }
}