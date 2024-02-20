package com.example.mealregisterapp.cli_graphic_controller;

import com.example.mealregisterapp.utils.ClearCLI;
import com.example.mealregisterapp.utils.Printer;

import java.util.Scanner;

import static com.example.mealregisterapp.utils.NotImplementedMessage.notImplementedYetMessage;
import static com.example.mealregisterapp.utils.ValidInputCheck.checkInputDigit;

public class UserHomePageControllerCLI {


    public void displayHomePage() {
        ClearCLI.clear();
        Printer.printPageTitle("Home Page");
        Printer.printMessage("Scegli un operazione:\n");
        Printer.printMessage("1)MyAccount\n2)Meal Page\n3)Recipe Page\n4)Settings\n5)Exit");
        Scanner scanner = new Scanner(System.in);
        handleChoice(scanner.nextLine());
    }

    private void handleChoice(String nextLine) {
        if (!checkInputDigit(nextLine)) {
            invalidInput();

        } else {
            int choice = Integer.parseInt(nextLine);
            switch (choice) {
                case 1 -> {
                    AccountPageControllerCLI accountPageControllerCLI = new AccountPageControllerCLI();
                    accountPageControllerCLI.displayAccountPage();
                }
                case 3, 4 -> notImplementedYetMessage();
                case 2 -> {
                    MealPageControllerCLI mealPageControllerCLI = new MealPageControllerCLI();
                    mealPageControllerCLI.displayMealPage();
                }
                case 5 -> {
                    Printer.printMessage("Grazie per aver utilizzato l'app");
                    System.exit(1);
                }
                default -> {
                    Printer.printMessage("Scegli una funzione valida");
                    displayHomePage();
                }
            }
        }
    }

    private void invalidInput() {
        Printer.printMessage("Inserire un input valido");
        displayHomePage();
    }

}