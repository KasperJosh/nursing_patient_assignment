package Person;


public class Patient extends Person {

    // Patient Room Number 
    private String roomNumber;

    // Basic identifiers
    private String patientMRN; // Permanent identifier 
    private String admissionDate; // "2026-02-22" or "Feb 22, 2026"
    private String dischargeDate; // Not set, ""
    

    //Unit/ Medical Overview
    private String isolationStatus;  // LRC, MRC, HRC
    private String lOI; // Level A,B,C,D
    private String cardiologyTeam; // Cardiology Team 1, Cardiology Team 2, Cardiac Surgery
    private String diagnosis; // U/A, NSTEMI, STEMI, AdHF, MVD, etc
    private String hx; // CAD, HTN, DLP, DM2, etc 
    private String allergy; // ASA, Morphine, etc

    // Cardiac-related
    private String cardiacSxComplications; // Bleeding Post Sumps,etc
    private String cardiacRhythm; //SR, AFib, 1st AVB
    private String ventilationStatus; // RA, NP 2L, CPAP, etc

    // Lines / Tubes/ Nutrition/ Elimination/ Moblity
    private String ivAccess; // PICC, PIV, CVC, etc
    private String nutrition; // NPO, Cardiac, Diabetic, NGT, etc
    private String drainsDrgs; // Drains/ Sumps, Harvest site Dressings
    private String elimination; // Folay, Voiding, BM
    private String mobility; // Independent, Assist x1,etc
    private String walkList; // Yes/No

    //"List that are stored as arrays"
    private String[] testsProcedures;  // CXR, Cardio Echo, Mibi,etc
    private int testsCount;

    private String[] alarmingLabs; //Hgb: 65, Sodium: 130, K+: 2.7, etc
    private int labsCount;

    private String[] prescriptions; // ASA, Apixaban, Metoprolol
    private int rxCount;

    private String [] issues; // Insomnia, New ST elevations, Refuses meds, etc
    private int issuesCount;

    private String[] plans; // IV diuretics,  CABG date, Cath
    private int plansCount;

    //Multidisciplinary follow-ups 
    private boolean followSW; //Social Worker
    private boolean followPT; // Physiotherapist
    private boolean followOT; // Occupational Therapist

    // Discharge Planning
    private String homeSituation; // Lives alone, Lives in Apartment, etc
    private String dcPlan; // "Home", "Rehab", "LTC", "CLSC Services"

    //Assignment Hook
    private Nurse assignedNurse; // Assigned Nurse for the shift 
    private Doctor assignedDoctor; // Assigned Doctors 



    //------------------------ Constructors -----------------------------

     // Default Constructor
     public Patient() {
        super();
        this.roomNumber = "";

        this.patientMRN = "";
        this.admissionDate = "";
        this.dischargeDate = "";

        this.isolationStatus = "";
        this.lOI = "";
        this.cardiologyTeam = "";
        this.diagnosis = "";
        this.hx = "";
        this.allergy = "";

        this.cardiacSxComplications = "";
        this.cardiacRhythm = "";
        this.ventilationStatus = "";

        this.ivAccess = "";
        this.nutrition = "";
        this.drainsDrgs = "";
        this.elimination = "";
        this.mobility = "";
        this.walkList = "";

        //Arrays
        this.testsProcedures = new String[20];
        this.testsCount = 0;

        this.alarmingLabs = new String[20];
        this.labsCount = 0;

        this.prescriptions = new String[30];
        this.rxCount = 0;

        this.issues = new String[20];
        this.issuesCount = 0;

        this.plans = new String[20];
        this.plansCount = 0;

        this.followSW = false;
        this.followPT = false;
        this.followOT = false;

        this.homeSituation = "";
        this.dcPlan = "";

        this.assignedNurse = null;
        this.assignedDoctor = null;
    }

    // Parameterized constructor (main fields), Essential identity of the object, Defined who the patient is at admission
    public Patient(String firstName, String lastName, int age, String gender, String roomNumber,
                   String patientMRN, String admissionDate, String isolationStatus, String lOI, String cardiologyTeam,
                   String diagnosis, String hx, String allergy) {

        super(firstName, lastName, age, gender);
        
        this.roomNumber = roomNumber;
        this.patientMRN = patientMRN;
        this.admissionDate = admissionDate;
        this.dischargeDate = "";
        
        this.isolationStatus = isolationStatus;
        this.lOI = lOI;
        this.cardiologyTeam = cardiologyTeam;
        this.diagnosis = diagnosis;
        this.hx = hx;
        this.allergy = allergy;

        // Defaults for the rest
        // Things that may change often, Things not known at creation
        // Things updated during hospital stay/ Optional Things 
        this.cardiacSxComplications = "";
    
        this.cardiacRhythm = "";
        this.ventilationStatus = "";

        this.ivAccess = "";
        this.nutrition = "";
        this.drainsDrgs = "";
        this.elimination = "";
        this.mobility = "";
        this.walkList = "";

        this.testsProcedures = new String[20];
        this.testsCount = 0;

        this.alarmingLabs = new String[20];
        this.labsCount = 0;

        this.prescriptions = new String[30];
        this.rxCount = 0;

        this.issues = new String[20];
        this.issuesCount = 0;

        this.plans = new String[20];
        this.plansCount = 0;

        this.followSW = false;
        this.followPT = false;
        this.followOT = false;

        this.homeSituation = "";
        this.dcPlan = "";

        this.assignedNurse = null;
        this.assignedDoctor = null;
    }

    
    // Copy Constructor (new patientID)
    public Patient(Patient other) {
        super(other);
        
        this.roomNumber = other.roomNumber;
        this.patientMRN = other.patientMRN;
        this.admissionDate = other.admissionDate;
        this.dischargeDate = other.dischargeDate;

        this.isolationStatus = other.isolationStatus;
        this.lOI = other.lOI;
        this.cardiologyTeam = other.cardiologyTeam;
        this.diagnosis = other.diagnosis;
        this.hx = other.hx;
        this.allergy = other.allergy;

        this.cardiacSxComplications = other.cardiacSxComplications;
        this.cardiacRhythm = other.cardiacRhythm;
        this.ventilationStatus = other.ventilationStatus;

        this.ivAccess = other.ivAccess;
        this.nutrition = other.nutrition;
        this.drainsDrgs = other.drainsDrgs;
        this.elimination = other.elimination;
        this.mobility = other.mobility;
        this.walkList = other.walkList;

        // deep copy arrays
        this.testsProcedures = new String[other.testsProcedures.length];
        this.testsCount = other.testsCount;
        for (int i = 0; i < other.testsCount; i++) this.testsProcedures[i] = other.testsProcedures[i];

        this.alarmingLabs = new String[other.alarmingLabs.length];
        this.labsCount = other.labsCount;
        for (int i = 0; i < other.labsCount; i++) this.alarmingLabs[i] = other.alarmingLabs[i];

        this.prescriptions = new String[other.prescriptions.length];
        this.rxCount = other.rxCount;
        for (int i = 0; i < other.rxCount; i++) this.prescriptions[i] = other.prescriptions[i];

        this.issues = new String[other.issues.length];
        this.issuesCount = other.issuesCount;
        for (int i = 0; i < other.issuesCount; i++) this.issues[i] = other.issues[i];

        this.plans = new String[other.plans.length];
        this.plansCount = other.plansCount;
        for (int i = 0; i < other.plansCount; i++) this.plans[i] = other.plans[i];

        this.followSW = other.followSW;
        this.followPT = other.followPT;
        this.followOT = other.followOT;

        this.homeSituation = other.homeSituation;
        this.dcPlan = other.dcPlan;

        // usually you can copy assignment or reset it — your choice:
        this.assignedNurse = other.assignedNurse; // shallow copy is fine for references
        this.assignedDoctor = other.assignedDoctor;
    }

    // ---------------- Add-to-list helpers ----------------

    public boolean addTestProcedure(String item) {
        if (testsCount >= testsProcedures.length) return false;
        testsProcedures[testsCount++] = item;
        return true;
    }

    public boolean addAlarmingLab(String item) {
        if (labsCount >= alarmingLabs.length) return false;
        alarmingLabs[labsCount++] = item;
        return true;
    }

    public boolean addPrescription(String item) {
        if (rxCount >= prescriptions.length) return false;
        prescriptions[rxCount++] = item;
        return true;
    }

    public boolean addIssue(String item) {
        if (issuesCount >= issues.length) return false;
        issues[issuesCount++] = item;
        return true;
    }

    public boolean addPlan(String item) {
        if (plansCount >= plans.length) return false;
        plans[plansCount++] = item;
        return true;
    }

    // ---------------- Getters / Setters (key ones) ----------------
        
    public String getRoomNumber() { return roomNumber;}
    public void setRoomNumber(String roomNumber) {this.roomNumber = roomNumber;}

    public String getPatientMRN() {return patientMRN;}
    public void setPatientMRN(String patientMRN) {this.patientMRN = patientMRN;}

    public String getAdmissionDate() {return admissionDate;}
    public void setAdmissionDate(String admissionDate) {this.admissionDate = admissionDate;}

    public String getDischargeDate() {return dischargeDate;}
    public void setDischargeDate(String dischargeDate) {this.dischargeDate = dischargeDate;}

    public String getIsolationStatus() {return isolationStatus;}
    public void setIsolationStatus(String isolationStatus) {this.isolationStatus = isolationStatus;}

    public String getlOI() {return lOI;}
    public void setlOI(String lOI) {this.lOI = lOI;}

    public String getCardiologyTeam() {return cardiologyTeam;}
    public void setCardiologyTeam(String cardiologyTeam) {this.cardiologyTeam = cardiologyTeam;}

    public String getDiagnosis() {return diagnosis;}
    public void setDiagnosis(String diagnosis) {this.diagnosis = diagnosis;}

    public String getHx() {return hx;}
    public void setHx(String hx) {this.hx = hx;}

    public String getAllergy() {return allergy;}
    public void setAllergy(String allergy) {this.allergy = allergy;}

    public String getCardiacSxComplications() {return cardiacSxComplications;}
    public void setCardiacSxComplications(String cardiacSxComplications) {this.cardiacSxComplications = cardiacSxComplications;}

    public String getCardiacRhythm() {return cardiacRhythm;}
    public void setCardiacRhythm(String cardiacRhythm) {this.cardiacRhythm = cardiacRhythm;}

    public String getVentilationStatus() {return ventilationStatus;}
    public void setVentilationStatus(String ventilationStatus) {this.ventilationStatus = ventilationStatus;}

    public String getIvAccess() {return ivAccess;}
    public void setIvAccess(String ivAccess) {this.ivAccess = ivAccess;}

    public String getNutrition() {return nutrition;}
    public void setNutrition(String nutrition) {this.nutrition = nutrition;}

    public String getDrainsDrgs() {return drainsDrgs;}
    public void setDrainsDrgs(String drainsDrgs) {this.drainsDrgs = drainsDrgs;}

    public String getElimination() {return elimination;}
    public void setElimination(String elimination) {this.elimination = elimination;}

    public String getMobility() {return mobility;}
    public void setMobility(String mobility) {this.mobility = mobility;}

    public String getWalkList() {return walkList;}
    public void setWalkList(String walkList) {this.walkList = walkList;}

    public String[] getTestsProcedures() {return testsProcedures;}
    public void setTestsProcedures(String[] testsProcedures) {this.testsProcedures = testsProcedures;}

    public int getTestsCount() {return testsCount;}
    public void setTestsCount(int testsCount) {this.testsCount = testsCount;}

    public String[] getAlarmingLabs() {return alarmingLabs;}
    public void setAlarmingLabs(String[] alarmingLabs) {this.alarmingLabs = alarmingLabs;}

    public int getLabsCount() {return labsCount;}
    public void setLabsCount(int labsCount) {this.labsCount = labsCount;}

    public String[] getPrescriptions() {return prescriptions;}
    public void setPrescriptions(String[] prescriptions) {this.prescriptions = prescriptions;}

    public int getRxCount() {return rxCount;}
    public void setRxCount(int rxCount) {
        this.rxCount = rxCount;
    }

    public String[] getIssues() {
        return issues;
    }

    public void setIssues(String[] issues) {
        this.issues = issues;
    }

    public int getIssuesCount() {
        return issuesCount;
    }

    public void setIssuesCount(int issuesCount) {
        this.issuesCount = issuesCount;
    }

    public String[] getPlans() {
        return plans;
    }

    public void setPlans(String[] plans) {
        this.plans = plans;
    }

    public int getPlansCount() {
        return plansCount;
    }

    public void setPlansCount(int plansCount) {
        this.plansCount = plansCount;
    }

    public boolean isFollowSW() {
        return followSW;
    }

    public void setFollowSW(boolean followSW) {
        this.followSW = followSW;
    }

    public boolean isFollowPT() {
        return followPT;
    }

    public void setFollowPT(boolean followPT) {
        this.followPT = followPT;
    }

    public boolean isFollowOT() {
        return followOT;
    }

    public void setFollowOT(boolean followOT) {
        this.followOT = followOT;
    }

    public String getHomeSituation() {
        return homeSituation;
    }

    public void setHomeSituation(String homeSituation) {
        this.homeSituation = homeSituation;
    }

    public String getDcPlan() {
        return dcPlan;
    }

    public void setDcPlan(String dcPlan) {
        this.dcPlan = dcPlan;
    }

    public Nurse getAssignedNurse() {
        return assignedNurse;
    }

    public void setAssignedNurse(Nurse assignedNurse) {
        this.assignedNurse = assignedNurse;
    }

    public Doctor getAssignedDoctor() {
        return assignedDoctor;
    }

    public void setAssignedDoctor(Doctor assignedDoctor) {
        this.assignedDoctor = assignedDoctor;
    }

    ///

    // ---------------- toString ----------------

    private String listToString(String title, String[] arr, int count) {
        String s = "\n" + title + ": ";
        if (count == 0) return s + "None";
        for (int i = 0; i < count; i++) {
            s += (i == 0 ? "" : ", ") + arr[i];
        }
        return s;
    }

    public String toString() {
    return super.toString() +
            "\nMRN: " + patientMRN +
            "\nAdmission Date: " + admissionDate +
            "\nDischarge Date: " + (dischargeDate.equals("") ? "Not set" : dischargeDate) +
            "\nLOI: " + lOI +
            "\nDoctor Team: " + cardiologyTeam +
            "\nDiagnosis: " + diagnosis +
            "\nPMHx: " + hx +
            "\nAllergy: " + allergy +
            "\nCardiac Sx/Complications: " + cardiacSxComplications +
            "\nHeart Rhythm: " + cardiacRhythm +
            "\nVentilation Status: " + ventilationStatus +
            "\nIV Access: " + ivAccess +
            "\nNutrition: " + nutrition +
            "\nDrains/Drsg: " + drainsDrgs +
            "\nElimination: " + elimination +
            "\nMobility: " + mobility +
            "\nWalk List: " + walkList +
            "\nFollow SW: " + followSW +
            "\nFollow PT: " + followPT +
            "\nFollow OT: " + followOT +
            "\nHome Situation: " + homeSituation +
            "\nD/C Plan: " + dcPlan +
            "\nAssigned Nurse: " + (assignedNurse == null ? "Unassigned" : assignedNurse.getHospitalID()) +
            listToString("Tests/Procedures", testsProcedures, testsCount) +
            listToString("Alarming Labs", alarmingLabs, labsCount) +
            listToString("Prescriptions", prescriptions, rxCount) +
            listToString("Issues", issues, issuesCount) +
            listToString("Plans", plans, plansCount);
    }

    // ---------------- equals ----------------
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof Patient)) return false;

        Patient other = (Patient) obj;

        return super.equals(other) &&
                this.admissionDate.equals(other.admissionDate) &&
                this.dischargeDate.equals(other.dischargeDate) &&
                this.lOI.equals(other.lOI) &&
                this.cardiologyTeam.equals(other.cardiologyTeam) &&
                this.diagnosis.equals(other.diagnosis) &&
                this.hx.equals(other.hx) &&
                this.allergy.equals(other.allergy) &&
                this.cardiacSxComplications.equals(other.cardiacSxComplications) &&
                this.cardiacRhythm.equals(other.cardiacRhythm) &&
                this.ventilationStatus.equals(other.ventilationStatus) &&
                this.ivAccess.equals(other.ivAccess) &&
                this.nutrition.equals(other.nutrition) &&
                this.drainsDrgs.equals(other.drainsDrgs) &&
                this.elimination.equals(other.elimination) &&
                this.mobility.equals(other.mobility) &&
                this.walkList.equals(other.walkList) &&
                this.followSW == other.followSW &&
                this.followPT == other.followPT &&
                this.followOT == other.followOT &&
                this.homeSituation.equals(other.homeSituation) &&
                this.dcPlan.equals(other.dcPlan) &&
                this.testsCount == other.testsCount &&
                this.labsCount == other.labsCount &&
                this.rxCount == other.rxCount &&
                this.issuesCount == other.issuesCount &&
                this.plansCount == other.plansCount;
    }

}