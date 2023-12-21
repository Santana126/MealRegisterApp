package com.example.mealregisterapp.cli_graphic_controller;

import com.example.mealregisterapp.utils.ClearCLI;
import com.example.mealregisterapp.utils.Printer;

import java.util.Scanner;

import static com.example.mealregisterapp.utils.NotImplementedMessage.notImplementedYetMessage;

public class AccountPageControllerCLI {

    private final HomePageControllerCLI homePageControllerCLI = new HomePageControllerCLI();


    public void displayAccountPage() {

        ClearCLI.clear();
        Printer.printPageTitle("My Account");
        Printer.printMessage("Scegli un operazione:");
        Printer.printMessage("1)Modify Account\n2)Show stats\n3)Home Page");
        Scanner scanner = new Scanner(System.in);
        handleChoice(scanner.nextLine());

    }

    private void handleChoice(String nextLine) {
        switch (Integer.parseInt(nextLine)) {
            case 1, 2 -> notImplementedYetMessage();

            case 3 -> homePageControllerCLI.displayHomePage();

            default -> {
                Printer.printMessage("Scegli una funzione valida");
                displayAccountPage();
            }
        }
    }


}
