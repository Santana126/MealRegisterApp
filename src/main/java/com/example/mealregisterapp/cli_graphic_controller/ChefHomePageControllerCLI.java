package com.example.mealregisterapp.cli_graphic_controller;

import com.example.mealregisterapp.utils.ClearCLI;
import com.example.mealregisterapp.utils.NotImplementedMessage;
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
        if (!checkInput(nextLine)) {
            Printer.printMessage("Inserire un input valido");
            displayHomePage();
        } else {
            switch (Integer.parseInt(nextLine)) {
                case 1 -> {
                    AccountPageControllerCLI accountPageControllerCLI = new AccountPageControllerCLI();
                    //si deve passare la sessione (contiene i dati riguardanti l'account che si sta utilizzando)
                    accountPageControllerCLI.displayAccountPage();
                }
                case 2, 3 -> NotImplementedMessage.notImplementedYetMessage();
                case 4 -> System.exit(1);
                default -> {
                    Printer.printMessage("Inserisci una scelta valida");
                    displayHomePage();
                }
            }
        }
    }


    private boolean checkInput(String nextLine) {
        if (nextLine.length() > 1) {
            return false;
        }
        return nextLine.matches("\\d+");
    }
}
