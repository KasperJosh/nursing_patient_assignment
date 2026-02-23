

package Person;
// Creating a Person's class 

public class Person {
    
    // Instantiate all the variables needed for the Person  class
    protected String firstName;
    protected String lastName;
    protected int age;
    protected String gender;


    // Default Constructor
    public Person() {
        this.firstName = "Unknown";
        this.lastName = "Unknown";
        this.age = 0;
        this.gender = "Unknown";
    }

    // Parameterized Constructor
    public Person (String firstName, String lastName, int age, String gender){
        this.firstName =  firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
        
    }

    // Copy Constructor
    public Person (Person other){
        this.firstName = other.firstName;
        this.lastName = other.lastName;
        this.age = other.age;
        this.gender = other.gender;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    //toString method
    public String toString(){
        return "Name: " + firstName + " " + lastName + "\nAge: " + age + "\nGender: " + gender;
    }

    // equals
    public boolean equals(Object obj) {

        if (obj == null)
            return false;

        if (!(obj instanceof Person))
            return false;

        Person other = (Person) obj;

        return this.firstName.equals(other.firstName)
                && this.lastName.equals(other.lastName)
                && this.age == other.age;
    }

}

    



