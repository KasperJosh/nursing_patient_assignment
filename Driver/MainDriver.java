// Main Driver for the Cardiology Unit Program


package Driver;


// Importing the necessary packages
import java.util.Scanner;
import Management.UnitManager;
import Person.Doctor;
import Person.Nurse;
import Person.Patient;
import Person.Person;


// Creating the MainDriver class 
public class MainDriver {
    
    public static void main(String[] args){
        
        Scanner input= new Scanner(System.in);
        
        System.out.println("==========================================================================");
        System.out.println("Welcome to the K2 Jewish General Hospital Cardiology/ Cardiac Surgery Unit");
        System.out.println("                  Charge Nurse UnitManager + Assignment                   ");
        System.out.println("==========================================================================");

        // Create UnitManager with the capacities
        UnitManager unit = new UnitManager(37, 9);
    
        boolean running = true;

        while (running) {

            printMenu(); // Printing the main menu
            System.out.println("Please choose an option: ");
            int choice = readIntSafely(input);

            //Cases 
            switch(choice){
                case 1:
                    addNurse(input, unit)
            }
        }
    }
    
    //---------------Main Menu----------------

    private static void printMenu() {
        System.out.println("------------Main Menu------------");
        System.out.println("------------ MENU ------------");
        System.out.println("1) Add Nurse");
        System.out.println("2) Admit Patient");
        System.out.println("3) Assign Nurse to Patient");
        System.out.println("4) Unassign Nurse from Patient");
        System.out.println("5) Discharge Patient by MRN");
        System.out.println("6) Print Census (Detailed)");
        System.out.println("7) Print Assignments (Summary)");
        System.out.println("8) Print Nurse List");
        System.out.println("9) Run Hardcoded Scenario");
        System.out.println("0) Exit");
        System.out.println("------------------------------");
    }
    

    //-------------INPUT HELPERS--------------

    private static int readIntSafely(Scanner input){
        while(!input.hasNextInt()){
            input.nextLine();
            System.out.print("Please enter your choice: ");
        }

        int value = input.nextInt();
        input.nextLine();
        return value;
    }

    private static String readNonEmptyLine(Scanner input, String prompt) {
        System.out.print(prompt);
        String s = input.nextLine().trim();
        while (s.isEmpty()) {
            System.out.print("Cannot be empty. " + prompt);
            s = input.nextLine().trim();
        }
        return s;
    }

    //-------------------HANDLERS---------------------

    private static void addNurse(Scanner input, UnitManager unit){

        System.out.println("\n--- Add Nurse ---");
        String firstName = readNonEmptyLine(input, "First name: ");
        String lastName = readNonEmptyLine(input, "Last name: ");

    }

}
