package ca.ubc.cs304.service;

import ca.ubc.cs304.database.DatabaseConnectionHandler;
import ca.ubc.cs304.domain.Branch;
import ca.ubc.cs304.domain.Customer;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AdminMode {
    DatabaseConnectionHandler dbHandler;
    Scanner sc;

    public AdminMode() {
        dbHandler = new DatabaseConnectionHandler();
    }

    public void start(){
        mainMenu();
    }

    private void mainMenu(){
        clearScreen();
        sc = new Scanner(System.in);
        printInBox('#', "ADMIN MODE",
                " ",
                "choose option by entering corresponding number",
                "(1) View Tables",
                "(2) Insert Table",
                "(3) Delete Table",
                "(4) Update Table",
                "",
                "(5) exit",
                "");
        try {
            int selection = scanInt();
            switch (selection) {
                case 1:
                    viewTables();
                    break;
                case 2:
                    insertTables();
                    break;
                case 3:
                    deleteTables();
                    break;
                case 4:
                    updateTables();
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    mainMenu();
            }
        }catch (InputMismatchException e) {
            mainMenu();
        }
    }

    private void viewTables(){
        clearScreen();
        sc = new Scanner(System.in);
        printInBox('+',
                "VIEW TABLES",
                "",
                "(1) view branch",
                "(2) view vehicles",
                "(3) view vehicle types",
                "(4) view customers",
                "(5) view rentals",
                "(6) view reservations",
                "(7) view returns",
                "(8) view all tables",
                "",
                "(9) back to main menu",
                ""
                );
        try {
            int selection = scanInt();
            switch (selection) {
                case 1:
                    clearScreen();
                    dbHandler.viewBranch();
                    break;
                case 2:
                    clearScreen();
                    dbHandler.viewVehicles();
                    break;
                case 3:
                    clearScreen();
                    dbHandler.viewVehiclesTypes();
                    break;
                case 4:
                    clearScreen();
                    dbHandler.viewCustomers();
                    break;
                case 5:
                    clearScreen();
                    dbHandler.viewRentals();
                    break;
                case 6:
                    clearScreen();
                    dbHandler.viewReturns();
                    break;
                case 7:
                    clearScreen();
                    dbHandler.viewReservations();
                    break;
                case 8:
                    clearScreen();
                    dbHandler.viewAllTables();
                    break;
                case 9:
                    mainMenu();
                    break;
                default:
                    viewTables();
                    break;

            }
            backToMainMenuAfterInput();
        }catch (InputMismatchException e) {
            mainMenu();
        }catch (Exception e) {
            System.out.println(e);
            System.exit(-1);
        }

    }
    private void insertTables(){
        clearScreen();
        sc = new Scanner(System.in);
        printInBox('+',
                "INSERT TABLES",
                "",
                "(1) insert branch",
                "",
                "(2) back to main menu",
                ""
                );
        try {
            int selection = scanInt();
            switch (selection) {
                case 1:
                    clearScreen();
                    insertBranch();
                    break;
                case 2:
                    clearScreen();
                    mainMenu();
                    break;
                default:
                    insertTables();
                    break;

            }
            backToMainMenuAfterInput();
        }catch (InputMismatchException e) {
            mainMenu();
        }catch (Exception e) {
            System.out.println(e);
            System.exit(-1);
        }

    }

    private void insertBranch(){
        clearScreen();
        sc = new Scanner(System.in);

        String location, city;
        printInBox('$',
                "",
                "location:  ",
                "city:  ",
                "");
        printInBox('*',
                "enter location");
        location = scanLine();
        clearScreen();
        printInBox('$',
                "",
                "location: " + location,
                "city:",
                "");
        printInBox('*',
                "enter city");
        city = scanLine();
        clearScreen();

        printInBox('$',
                "",
                "location: " + location,
                "city: " + city,
                "");
        if (validateOption()) {
            Branch model = new Branch(location, city);
            dbHandler.insertBranch(model);
            
            backToMainMenuAfterInput();
        } else {
            insertBranch();
        }
        mainMenu();
    }
    private void deleteTables(){
        clearScreen();
        sc = new Scanner(System.in);
        printInBox('+',
                "DELETE TABLES",
                "",
                "(1) delete customer",
                "",
                "(2) back to main menu",
                ""
        );
        try {
            int selection = scanInt();
            switch (selection) {
                case 1:
                    clearScreen();
                    deleteCustomer();
                    break;
                case 2:
                    clearScreen();
                    mainMenu();
                    break;
                default:
                    deleteTables();
                    break;

            }
            backToMainMenuAfterInput();
        }catch (InputMismatchException e) {
            mainMenu();
        }catch (Exception e) {
            System.out.println(e);
            System.exit(-1);
        }

    }

    private void deleteCustomer(){
        clearScreen();
        sc = new Scanner(System.in);

        String dlicense;
        printInBox('$',
                "",
                "customer license number:  ",
                "");
        printInBox('*',
                "enter customer license number");
        dlicense = scanLine();
        clearScreen();
        printInBox('$',
                "",
                "customer license number: " + dlicense,
                "");
        if (validateOption()) {
            dbHandler.deleteCustomer(dlicense);
            backToMainMenuAfterInput();
        } else {
            deleteCustomer();
        }
        mainMenu();
    }
    private void updateTables(){
        clearScreen();
        sc = new Scanner(System.in);
        printInBox('+',
                "UPDATE TABLES",
                "",
                "(1) update customer",
                "",
                "(2) back to main menu",
                ""
        );
        try {
            int selection = scanInt();
            switch (selection) {
                case 1:
                    clearScreen();
                    updateCustomer();
                    break;
                case 2:
                    clearScreen();
                    mainMenu();
                    break;
                default:
                    updateTables();
                    break;

            }
            backToMainMenuAfterInput();
        }catch (InputMismatchException e) {
            mainMenu();
        }catch (Exception e) {
            System.out.println(e);
            System.exit(-1);
        }

    }

    private void updateCustomer() {
        clearScreen();
        sc = new Scanner(System.in);

        String dlicense, cellphone, name, address;
        printInBox('$',
                "LICENSE DETERMINES CUSTOMER TO UPDATE",
                "",
                "customer license number:  ",
                "cellphone number: ",
                "name: ",
                "address: ",
                "");
        printInBox('*',
                "enter customer license number");
        dlicense = scanLine();
        clearScreen();
        printInBox('$',"LICENSE DETERMINES CUSTOMER TO UPDATE",
                "",
                "customer license number: " + dlicense,
                "cellphone number: ",
                "name: ",
                "address: ",
                "");
        printInBox('*',
                "enter customer cellphone number");
        cellphone = scanLine();
        clearScreen();
        printInBox('$',"LICENSE DETERMINES CUSTOMER TO UPDATE",
                "",
                "customer license number: " + dlicense,
                "cellphone number: " + cellphone,
                "name: ",
                "address: ",
                "");
        printInBox('*',
                "enter customer name");
        name = scanLine();
        clearScreen();
        printInBox('$',"LICENSE DETERMINES CUSTOMER TO UPDATE",
                "",
                "customer license number: " + dlicense,
                "cellphone number: " + cellphone,
                "name: " + name,
                "address: ",
                "");
        printInBox('*',
                "enter customer address");
        address = scanLine();
        clearScreen();
        printInBox('$',"LICENSE DETERMINES CUSTOMER TO UPDATE",
                "",
                "customer license number: " + dlicense,
                "cellphone number: " + cellphone,
                "name: " + name,
                "address: " + address,
                "");
        if (validateOption()) {
            Customer model = new Customer(dlicense, cellphone, name, address);
            dbHandler.updateCustomer(model);
            backToMainMenuAfterInput();
        } else {
            updateCustomer();
        }
        mainMenu();
    }

    private int scanInt() throws InputMismatchException{
        return sc.nextInt();
    }

    private String scanLine(){
        return sc.nextLine();
    }

    private boolean validateOption(){

        printInBox('+',
                "is this correct?",
                "",
                "(1) yes",
                "(2) no",
                "");
        try {
            int selection = scanInt();
            switch (selection) {
                case 1:
                    return true;
                case 2:
                    return false;
                default:
                    return validateOption();

            }
        }catch (InputMismatchException e) {
            return validateOption();
        }catch (Exception e) {
            System.out.println(e);
            System.exit(-1);
        }
        return false;
    }
    private void backToMainMenuAfterInput(){
        printInBox('*', "press enter to return to the main menu");
        sc = new Scanner(System.in);
        String input = sc.nextLine();
        mainMenu();
    }

    private void printInBox(char texture, String... strings) {
        int maxLength = -1;
        for (String s : strings) {
            if (s.length() > maxLength) {
                maxLength = s.length();
            }
        }
        String horizontal = "";
        for (int i = 0; i < maxLength + 4; i++) {
            horizontal += texture;
        }
        System.out.println(horizontal); // top of box
        int maxLengthDiff;
        String bodyLine;
        for (String s : strings) {// prints body of box
            maxLengthDiff = maxLength - s.length();
            bodyLine = texture + " " + s;
            for (int i = 0; i < maxLengthDiff; i++) {
                bodyLine += " ";
            }
            bodyLine += " " + texture;
            System.out.println(bodyLine);

        }
        System.out.println(horizontal); // bottom of box

    }

    private static void clearScreen() {
        try
        {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows"))
            {
                Runtime.getRuntime().exec("cls");
            }
            else
            {
                Runtime.getRuntime().exec("clear");
            }
        }
        catch (final Exception e)
        {
            System.out.print("\033[H\033[2J");
            System.out.flush();
        }
    }
}
