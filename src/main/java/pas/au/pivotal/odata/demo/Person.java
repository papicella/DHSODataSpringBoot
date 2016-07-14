package pas.au.pivotal.odata.demo;

public class Person
{
    private String userName;
    private String firstName;
    private String lastName;
    private String gender;
    private Long concurrency;

    public Person(String userName, String firstName, String lastName, String gender, Long concurrency) {
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.concurrency = concurrency;
    }

    public Person()
    {

    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Long getConcurrency() {
        return concurrency;
    }

    public void setOncurrency(Long concurrency) {
        this.concurrency = concurrency;
    }

    @Override
    public String toString() {
        return "Person{" +
                "userName='" + userName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender='" + gender + '\'' +
                ", Concurrency='" + concurrency + '\'' +
                '}';
    }
}
