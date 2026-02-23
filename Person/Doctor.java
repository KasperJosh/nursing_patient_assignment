package Person;

public class Doctor extends Person {

    private String doctorID;        // hospital ID / credential ID
    private String licenseNumber;   // professional license
    private String service;         // "Cardiology", "ICU", "Internal Med"
    private String role;            // "Staff", "Fellow", "Resident"
    private String pager;           // or extension

    // Default constructor
    public Doctor() {
        super(); // Person default constructor
        this.doctorID = "";
        this.licenseNumber = "";
        this.service = "";
        this.role = "";
        this.pager = "";
    }

    // Parameterized constructor
    public Doctor(String firstName, String lastName, int age, String gender,
                  String doctorID, String licenseNumber,
                  String service, String role, String pager) {

        super(firstName, lastName, age, gender); // Person parameterized constructor
        this.doctorID = doctorID;
        this.licenseNumber = licenseNumber;
        this.service = service;
        this.role = role;
        this.pager = pager;
    }

    // Copy constructor
    public Doctor(Doctor other) {
        super(other);
        this.doctorID = other.doctorID;
        this.licenseNumber = other.licenseNumber;
        this.service = other.service;
        this.role = other.role;
        this.pager = other.pager;
    }

    // Getters
    public String getDoctorID() {
        return doctorID;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public String getService() {
        return service;
    }

    public String getRole() {
        return role;
    }

    public String getPager() {
        return pager;
    }

    // Setters
    public void setDoctorID(String doctorID) {
        this.doctorID = doctorID;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public void setService(String service) {
        this.service = service;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setPager(String pager) {
        this.pager = pager;
    }

    // toString()
    public String toString() {
        return super.toString() +
                "\nDoctor ID: " + doctorID +
                "\nLicense #: " + licenseNumber +
                "\nService: " + service +
                "\nRole: " + role +
                "\nPager/Ext: " + pager;
    }

    // equals() (compare everything except IDs if you want IDs excluded like your Nurse class)
    public boolean equals(Object obj) {

        if (obj == null) return false;
        if (!(obj instanceof Doctor)) return false;

        Doctor other = (Doctor) obj;

        // Excluding doctorID + licenseNumber (similar to how you excluded hospitalID/OIIQ)
        return super.equals(other) &&
                this.service.equals(other.service) &&
                this.role.equals(other.role) &&
                this.pager.equals(other.pager);
    }
}
