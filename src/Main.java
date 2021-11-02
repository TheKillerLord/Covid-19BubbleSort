import java.util.Scanner;                   //obtaining the input of the primitive types
import java.text.SimpleDateFormat;          //allows you to start by choosing user-defined patterns for date-time format
import java.util.Date;                      //represents date and time in Java
import java.text.ParseException;            //a checked exception when you fail to parse a string that have special format
import java.util.concurrent.TimeUnit;       //used to inform time-based methods

class IncomingPassenger{
    Scanner scanner = new Scanner(System.in);
    static int quarantine_period = 0;

    public void Input() {

        System.out.println("=========================");
        System.out.println("Passenger Information");
        System.out.println("=========================");

        System.out.print("First Name: ");                   //validate the input of the first name

        if (scanner.hasNext("[A-Za-z]*")) {
            String first_name = scanner.nextLine().toUpperCase().trim();
        } else {
            System.out.println("Invalid Input...");
            System.exit(0);
        }

        System.out.print("Last Name: ");                    //validate the input of the last name
        if (scanner.hasNext("[A-Za-z]*")) {
            String last_name = scanner.nextLine();
        } else {
            System.out.println("Invalid Input...");
            System.exit(0);
        }

        System.out.print("Enter your Country of Departure: ");

        String country_departure = null;

        if (scanner.hasNext("[A-Za-z]*")) {           //validate input of the country departure
            country_departure = scanner.next();
        } else {
            System.out.println("Invalid Input...");
            System.exit(0);
        }

        System.out.print("Date of Departure (DD-MM-YYYY): ");       //validate the format of the date
        String date_departure;
        date_departure = scanner.next();
        SimpleDateFormat date = new SimpleDateFormat("dd-MM-yyyy");
        date.setLenient(false);

        try {
            Date javaDate = date.parse(date_departure);
            System.out.println("Departure Date: " + date_departure);
        } catch (ParseException e) {
            System.out.println("Invalid Format...");
            System.exit(0);
        }

        //passenger enter where they are from, data will show whether the passenger should be quarantine for how many days
        switch (country_departure.toUpperCase().trim()) {
            case "CHINA", "UNITED STATES", "UNITED KINGDOM" -> {
                System.out.println("Quarantine period will be 14 days.");
                quarantine_period = 14;
            }
            case "HONG KONG", "JAPAN", "AUSTRALIA" -> {
                System.out.println("Quarantine period will be 10 days.");
                quarantine_period = 10;
            }
            case "THAILAND", "SINGAPORE", "VIETNAM" -> {
                System.out.println("Quarantine period will be 7 days.");
                quarantine_period = 7;
            }
            case "MALAYSIA" -> {
                System.out.println("Malaysian will have to follow the SOP which will be quarantine for 10 days.");
                quarantine_period = 10;
            }
            default -> {
                System.out.println("This country could not be found in the database system, therefore quarantine will be 14 days.");
                quarantine_period = 14;
            }
        }
    }
    public static int Quarantine(){return quarantine_period;}
}

class Locations{
    public static void LocalArea() {

        System.out.println("-------------------------");
        System.out.println("List of Places to Visit:-");
        System.out.println("-------------------------");
        System.out.println("1) Hospital");
        System.out.println("2) Shopping Mall");
        System.out.println("3) Bank");
        System.out.println("4) Restaurant");
        System.out.println("5) School");
        System.out.println("6) Supermarket");
        System.out.println("7) Residential Area");
        System.out.println("8) Leisure Park");
    }

}

//Choosing options for a local area to visit, showing result of whether can the passenger visit or not
class RiskArea extends IncomingPassenger {
    public void chooseLocation() {
        Scanner scanner = new Scanner(System.in);

        int quarantine_days = Quarantine();

        System.out.println();

        System.out.print("Please choose the place you want to visit (Enter 1 - 8): ");

        int options = scanner.nextInt();

        System.out.println();

        //options and result of the place
        if (options == 1) {
            System.out.println("Report:");
            System.out.println("You have chosen Hospital, risk level is high.");
            System.out.println("Reported Cases: 200");
            if (quarantine_days == 14) {
                System.out.println("Risk Level is at Critical, please distance yourself from the area.");
            } else if (quarantine_days == 10) {
                System.out.println("Risk Level is at High, you are not allowed to visit that area.");
            } else if (quarantine_days == 7) {
                System.out.println("Risk Level is at Medium, you are allowed to visit but please follow SOP.");
            }

        } else if (options == 2) {
            System.out.println("Report:");
            System.out.println("You have chosen Shopping Mall, risk level is high.");
            System.out.println("Reported Cases: 150");
            if (quarantine_days == 14) {
                System.out.println("Risk Level is at Critical, please distance yourself from the area.");
            } else if (quarantine_days == 10) {
                System.out.println("Risk Level is at High, you are not allowed to visit that area.");
            } else if (quarantine_days == 7) {
                System.out.println("Risk Level is at Medium, you are allowed to visit but please follow SOP.");
            }

        } else if (options == 3) {
            System.out.println("Report:");
            System.out.println("You have chosen Bank, risk level is high.");
            System.out.println("Reported Cases: 165");
            if (quarantine_days == 14) {
                System.out.println("Risk Level is at Critical, please distance yourself from the area.");
            } else if (quarantine_days == 10) {
                System.out.println("Risk Level is at High, you are not allowed to visit that area.");
            } else if (quarantine_days == 7) {
                System.out.println("Risk Level is at Medium, you are allowed to visit but please follow SOP.");
            }

        } else if (options == 4) {
            System.out.println("Report:");
            System.out.println("You have chosen Restaurant, risk level is medium.");
            System.out.println("Reported Cases: 75");
            if (quarantine_days == 14) {
                System.out.println("Risk Level is at High, you are not allowed to visit that area.");
            } else if (quarantine_days == 10) {
                System.out.println("Risk Level is at Medium, you are allowed to visit but please follow SOP.");
            } else if (quarantine_days == 7) {
                System.out.println("Risk Level is at Medium, you are allowed to visit but please follow SOP.");
            }

        } else if (options == 5) {
            System.out.println("Report:");
            System.out.println("You have chosen School, risk level is medium.");
            System.out.println("Reported cases: 75");
            if (quarantine_days == 14) {
                System.out.println("Risk Level is at High, you are not allowed to visit that area.");
            } else if (quarantine_days == 10) {
                System.out.println("Risk Level is at Medium, you are allowed to visit but please follow SOP.");
            } else if (quarantine_days == 7) {
                System.out.println("Risk Level is at Medium, you are allowed to visit but please follow SOP.");
            }

        } else if (options == 6) {
            System.out.println("Report:");
            System.out.println("You have chosen Supermarket, risk level is medium.");
            System.out.println("Reported Cases: 60");
            if (quarantine_days == 14) {
                System.out.println("Risk Level is at High, you are not allowed to visit that area.");
            } else if (quarantine_days == 10) {
                System.out.println("Risk Level is at Medium, you are allowed to visit but please follow SOP.");
            } else if (quarantine_days == 7) {
                System.out.println("Risk Level is at Medium, you are allowed to visit but please follow SOP.");
            }

        } else if (options == 7) {
            System.out.println("Report:");
            System.out.println("You have chosen Residential Area, risk level is low.");
            System.out.println("Reported Cases: 40");
            if (quarantine_days == 14) {
                System.out.println("Risk Level is at Medium, you are allowed to visit but please follow SOP.");
            } else if (quarantine_days == 10) {
                System.out.println("Risk Level is at Medium, you are allowed to visit but please follow SOP.");
            } else if (quarantine_days == 7) {
                System.out.println("Risk Level is at Low, you are allowed to visit but please follow SOP.");
            }

        } else if (options == 8) {
            System.out.println("Report:");
            System.out.println("You have chosen Leisure Park, risk level is low.");
            System.out.println("Reported Cases: 30");
            if (quarantine_days == 14) {
                System.out.println("Risk Level is at Medium, you are allowed to visit but please follow SOP.");
            } else if (quarantine_days == 10) {
                System.out.println("Risk Level is at Medium, you are allowed to visit but please follow SOP.");
            } else if (quarantine_days == 7) {
                System.out.println("Risk Level is at Low, you are allowed to visit but please follow SOP.");
            }
        } else {
            System.err.println("Invalid Number, Please Try Again...");
        }
    }
}

public class Main extends RiskArea {
    public static void main(String[] args) throws InterruptedException {

        Main user = new Main();

        user.Input();

        System.out.println();

        //loading after putting personal information
        System.out.print("Loading places to visit... Please give us a moment");
        TimeUnit.SECONDS.sleep(2);
        System.out.println();
        System.out.println();

        Locations.LocalArea();

        user.chooseLocation();
    }
}




