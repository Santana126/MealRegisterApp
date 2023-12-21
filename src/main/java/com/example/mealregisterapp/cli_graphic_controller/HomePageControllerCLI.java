package com.example.mealregisterapp.cli_graphic_controller;

import com.example.mealregisterapp.utils.ClearCLI;
import com.example.mealregisterapp.utils.Printer;

import java.util.Scanner;

import static com.example.mealregisterapp.utils.NotImplementedMessage.notImplementedYetMessage;

public class HomePageControllerCLI {


    public void displayHomePage() {
        ClearCLI.clear();
        Printer.printMessage("-------------------------");
        Printer.printMessage("--------Welcome----------");
        Printer.printMessage("-------Home Page---------");
        Printer.printMessage("-------------------------\n\tScegli un operazione:\n");
        Printer.printMessage("1)MyAccount\n2)Meal Page\n3)Recipe Page\n4)Settings\n5)Exit");
        Scanner scanner = new Scanner(System.in);
        handleChoice(scanner.nextLine());
    }

    private void handleChoice(String nextLine) {
        switch (Integer.parseInt(nextLine)){
            case 1, 3, 4-> notImplementedYetMessage();
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