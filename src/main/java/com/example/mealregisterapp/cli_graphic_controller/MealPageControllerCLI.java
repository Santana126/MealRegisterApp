package com.example.mealregisterapp.cli_graphic_controller;

import com.example.mealregisterapp.utils.ClearCLI;
import com.example.mealregisterapp.utils.Printer;

import java.util.Scanner;

import static com.example.mealregisterapp.utils.NotImplementedMessage.notImplementedYetMessage;

public class MealPageControllerCLI {
    public void displayMealPage() {
        ClearCLI.clear();
        Printer.printPageTitle("Meal Page");
        Printer.printMessage("Scegli un operazione:\n");
        Printer.printMessage("1)Meal Register\n2)View Meal\n3)Back\n4)Exit");
        Scanner scanner = new Scanner(System.in);
        handleChoice(scanner.nextLine());
    }

    private void handleChoice(String nextLine) {
        //ToDO Check User Input (String ecc...)
        switch (Integer.parseInt(nextLine)){
            case 1 -> {
                MealRegisterControllerCLI mealRegisterControllerCLI = new MealRegisterControllerCLI();
                mealRegisterControllerCLI.displayMealRegisterPage();
            }
            case 2 -> notImplementedYetMessage();
            case 3 -> new HomePageControllerCLI().displayHomePage();
            case 4 -> System.exit(1);
            default -> {
                Printer.printMessage("Scegli una funzione valida");
                displayMealPage();
            }
        }

    }
}