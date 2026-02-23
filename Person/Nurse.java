package Person;



public class Nurse extends Person {

    private String hospitalID;
    private int oiiqID;
    private int yearsExperience;
    private int maxPatients;
    private int currentLoad;


    // Default constructor
    public Nurse() {
        
        super();  // calls Person default constructor
        this.hospitalID = "";
        this.oiiqID = 0;
        this.yearsExperience = 0;
        this.maxPatients = 5;   // default stepdown ratio
        this.currentLoad = 0;
    }
    
    // Parameterized constructor
    public Nurse(String firstName, String lastName, int age, String gender, String hospitalID, int oiiqID,
                 int yearsExperience, int maxPatients) {

        super(firstName, lastName, age, gender); // calls Person parameterized constructor

        this.hospitalID = hospitalID;
        this.oiiqID = oiiqID;
        this.yearsExperience = yearsExperience;
        this.maxPatients = maxPatients;
        this.currentLoad = 0;
    }


    public Nurse(Nurse other) {

        super(other); // copy Person attributes

        this.hospitalID = other.hospitalID;
        this.oiiqID = other.oiiqID;
        this.yearsExperience = other.yearsExperience;
        this.maxPatients = other.maxPatients;
        this.currentLoad = other.currentLoad;
    }

     public String getHospitalID() {
        return hospitalID;
    }

    public void setHospitalID(String hospitalID) {
        this.hospitalID = hospitalID;
    }

    public int getOiiqID() {
        return oiiqID;
    }

    public void setOiiqID(int oiiqID) {
        this.oiiqID = oiiqID;
    }

    public int getYearsExperience() {
        return yearsExperience;
    }

    public void setYearsExperience(int yearsExperience) {
        this.yearsExperience = yearsExperience;
    }

    public int getMaxPatients() {
        return maxPatients;
    }

    public void setMaxPatients(int maxPatients) {
        this.maxPatients = maxPatients;
    }

    public int getCurrentLoad() {
        return currentLoad;
    }

    public void setCurrentLoad(int currentLoad) {
        this.currentLoad = currentLoad;
    }

    // Helper method to check if nurse can take patient
    public boolean canTakePatient() {
        return currentLoad < maxPatients;
    }

    // Increase load when assigning patient
    public void incrementLoad() {
        if (canTakePatient()) {
            currentLoad++;
        }
    }

    // Decrease load when unassigning patient
    public void decrementLoad() {
        if (currentLoad > 0) {
            currentLoad--;
        }
    }

    // toString()
    public String toString() {
        return super.toString () +
           "\nHospital ID: " + hospitalID +
           "\nOIIQ ID: " + oiiqID + 
            "\nYears Experience: " + yearsExperience +
            "\nMax Patients: " + maxPatients +
            "\nCurrent Load: " + currentLoad; 
    }

    // equals() (compare everything except HospitalID and OIIQ ID)
    public boolean equals(Object obj) {

        if (obj == null)
            return false;

        if (!(obj instanceof Nurse))
            return false;

        Nurse other = (Nurse) obj;

        return super.equals(other) &&
               this.yearsExperience == other.yearsExperience &&
               this.maxPatients == other.maxPatients &&
               this.currentLoad == other.currentLoad;
    }
}
