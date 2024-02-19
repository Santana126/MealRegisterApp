package com.example.mealregisterapp.cli_graphic_controller;

import com.example.mealregisterapp.utils.ClearCLI;
import com.example.mealregisterapp.utils.Printer;

import java.util.Scanner;

public class ChefHomePageControllerCLI {

    public void displayHomePage() {
        ClearCLI.clear();
        Printer.printPageTitle("Chef Home Page");
        Printer.printMessage("Scegli un operazione:\n");
        Printer.printMessage("1)MyAccount\n2)CookBook Page\n3)Settings\n4)Exit");
        Scanner scanner = new Scanner(System.in);
        handleChoice(scanner.nextLine());
    }

    private void handleChoice(String nextLine) {
        //Gestisci la scelta
    }
}
