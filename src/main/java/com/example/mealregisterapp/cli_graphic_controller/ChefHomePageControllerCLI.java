package com.example.mealregisterapp.cli_graphic_controller;

import com.example.mealregisterapp.utils.ClearCLI;
import com.example.mealregisterapp.utils.NotImplementedMessage;
import com.example.mealregisterapp.utils.Printer;

import java.util.Scanner;

import static com.example.mealregisterapp.utils.ValidInputCheck.checkInputDigit;

public class ChefHomePageControllerCLI {

    public void displayHomePage() {
        ClearCLI.clear();
        chefOptionDisplay();
        Scanner scanner = new Scanner(System.in);
        handleChoice(scanner.nextLine());
    }

    private void chefOptionDisplay() {
        Printer.printPageTitle("Chef Home Page");
        Printer.printMessage("Scegli un operazione:\n");
        Printer.printMessage("1)MyAccount\n2)CookBook Page\n3)Settings\n4)Exit");
    }

    private void handleChoice(String nextLine) {
        if (!checkInputDigit(nextLine)) {
            Printer.printMessage("Sorry, your input is invalid");
            Printer.printMessage("Retry");
            displayHomePage();
        } else {
            switch (Integer.parseInt(nextLine)) {
                case 1 -> {
                    AccountPageControllerCLI accountPageControllerCLI = new AccountPageControllerCLI();
                    accountPageControllerCLI.displayAccountPage();
                }
                case 2 -> {
                    CookBookMainPageControllerCLI cookBookMainPageControllerCLI = new CookBookMainPageControllerCLI(this);
                    cookBookMainPageControllerCLI.displayCookBookMainPage();
                }
                case 3 -> NotImplementedMessage.notImplementedYetMessage();
                case 4 -> System.exit(1);
                default -> {
                    Printer.printMessage("Inserisci una scelta valida");
                    displayHomePage();
                }
            }
        }
    }

}
