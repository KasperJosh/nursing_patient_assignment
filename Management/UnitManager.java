// Creating the Unit Manager/ Charge Nurse!
// The digital charge nurse brain of the unit 


package Management;

import Person.Patient;
import Person.Nurse;


public class UnitManager {
    
    private Patient[] patients; // Declares an array that will store Patient objects
    private int patientCount; // Number of patients tracker

    private Nurse[] nurses; // Declares an array that will store Nurse objects
    private int nurseCount; // Tracks how many nurses are currently added


    //Constructor that creates a Unit Manager and sets its maximum capacity
    public UnitManager (int maxPatients, int maxNurses){
        this.patients = new Patient[maxPatients]; // Creating the patient array with a fixed size
        this.nurses = new Nurse [maxNurses]; // Creates the nurse array with a fixed size
        this.patientCount = 0; // Empty unit
        this.nurseCount = 0;
    }

    //-------------------- PATIENT METHODS -------------------
    
    // Method that tries to add a patient to the unit
    public boolean addPatient (Patient p){
        
        if (p == null) return false; // Prevent adding a null patinet
        if (patientCount >= patients.length) return false; // If unit is full, don't add

        // Preventing duplicate MRN
        if (findPatientByMRN(p.getPatientMRN()) != null) return false;
        
        patients[patientCount++] = p; // Adding patient at the next free spot
        return true;
    }

    // Searches the patient array for a matching MRN
    public Patient findPatientByMRN(String mrn) {
        if (mrn == null) return null;
        
        // Looping through active patients
        for (int i = 0; i < patientCount; i++){
            // Comparing MRNs
            if (patients[i] != null && mrn.equals(patients[i].getPatientMRN())){
                return patients[i];
            }
        }

        return null;
    }

    // Method that tries to discharge a patient from the unit
    public boolean dischargePatientByMRN(String mrn){
        int idx = indexOfPatientByMRN(mrn); // Finds the patient by the MRN
        if (idx == -1) return false;
    

        // If assigned, decrement nurse load
        Nurse assigned = patients[idx].getAssignedNurse();
        if (assigned != null) {
            assigned.decrementLoad();
        }

        // Remove patient by shifting left
        for (int i = idx; i < patientCount - 1; i++) {
            patients[i] = patients[i + 1];
        }
        patients[patientCount - 1] = null;
        patientCount--;

        return true;
    }

    // Method that finds where are patient is from the MRN
    private int indexOfPatientByMRN(String mrn) {
        if (mrn == null) return -1;

        for (int i = 0; i < patientCount; i++) {
            if (patients[i] != null && mrn.equals(patients[i].getPatientMRN())) {
                return i;
            }
        }
        return -1;
    }

    // Returns how many patients are currently admitted
    public int getPatientCount() {
        return patientCount;
    }

    // ----------------- NURSE METHODS ---------------------------

    // Method that tries to add the nurse to the unit
    public boolean addNurse(Nurse n){
        if (n == null) return false;
        if (nurseCount >= nurses.length) return false;

        // Prevents the duplicate of HospitalID
        if(findNurseByHospitalID(n.getHospitalID()) != null) return false;

        nurses[nurseCount++] = n;
        return true;
    }

    // Finds the nurse based on hospital ID
    public Nurse findNurseByHospitalID(String hospitalID) {
        if (hospitalID == null) return null;

        for (int i = 0; i < nurseCount; i++) {
            if (nurses[i] != null && hospitalID.equals(nurses[i].getHospitalID())) {
                return nurses[i];
            }
        }
        return null;
    }

    private int indexOfNurseByHospitalID(String hospitalID) {
        if (hospitalID == null) return -1;

        for (int i = 0; i < nurseCount; i++) {
            if (nurses[i] != null && hospitalID.equals(nurses[i].getHospitalID())) {
                return i;
            }
        }
        return -1;
    }

    public int getNurseCount() {
        return nurseCount;
    }

    // -------------------- ASSIGNMENT METHODS --------------------

    // Finds the patient + nurse
    public boolean assignNurseToPatient(String mrn, String hospitalID) {
        Patient p = findPatientByMRN(mrn);
        Nurse n = findNurseByHospitalID(hospitalID);

        if (p == null || n == null) return false; // If neither exists
        if (!n.canTakePatient()) return false; // If reaches capacity 

        // If patient already assigned to someone else, decrement old nurse load
        Nurse old = p.getAssignedNurse();
        if (old != null) {
            // If assigning same nurse again, do nothing
            if (old.getHospitalID().equals(hospitalID)) return true;
            old.decrementLoad();
        }

        p.setAssignedNurse(n);  // Assign new nurse to patient
        n.incrementLoad(); // Increases new nurse's load
        return true;
    }

    // Unassigns this patient from the nurse 
    public boolean unassignNurseFromPatient(String mrn) {
        Patient p = findPatientByMRN(mrn);
        if (p == null) return false; // If unassigned already

        Nurse old = p.getAssignedNurse();
        if (old == null) return false;

        old.decrementLoad();
        p.setAssignedNurse(null);
        return true;
    }

    // -------------------- PRINTING METHODS (NO INPUT) --------------------
    // These are okay for debugging/testing. Your driver can call them.

    // Prints the recording/ census of the unit so far 
    // Eventually this will be a user interface (UI)
    public void printCensusDetailed() {
        System.out.println("\n===== UNIT CENSUS (Detailed) =====");
        if (patientCount == 0) {
            System.out.println("No patients in unit.");
            return;
        }

        for (int i = 0; i < patientCount; i++) {
            System.out.println("----------------------------------");
            System.out.println(patients[i]);
        }
    }

    // Print the one compact one-line summar per pt
    public void printAssignmentsSummary() {
        System.out.println("\n===== ASSIGNMENTS (Summary) =====");
        if (patientCount == 0) {
            System.out.println("No patients in unit.");
            return;
        }

        for (int i = 0; i < patientCount; i++) {
            Patient p = patients[i];
            String nurseID = (p.getAssignedNurse() == null) ? "Unassigned" : p.getAssignedNurse().getHospitalID();
            String room = (p.getRoomNumber() == null) ? "" : p.getRoomNumber();

            System.out.println(
                    "MRN: " + p.getPatientMRN() +
                    " | Room: " + room +
                    " | Nurse: " + nurseID
            );
        }
    }

    // Prints the nurse's list
    public void printNurseList() {
        System.out.println("\n===== NURSES =====");
        if (nurseCount == 0) {
            System.out.println("No nurses added.");
            return;
        }

        for (int i = 0; i < nurseCount; i++) {
            System.out.println("----------------------------------");
            System.out.println(nurses[i]);
        }
    }
}

