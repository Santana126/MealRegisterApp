package com.example.mealregisterapp.cli_graphic_controller;

import com.example.mealregisterapp.utils.Printer;

import java.util.Scanner;

import static com.example.mealregisterapp.utils.ValidInputCheck.checkInputDigit;

public class CookBookSellingControllerCLI {
    public void showErrorMessage(String message) {
        Printer.error(message);
    }

    public int askCookBookToSell(int size) {

        Printer.printMessage("Scegli il CookBook da vendere:");
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine();
        if(!checkInputDigit(choice)){
            Printer.printMessage("Inserisci un input corretto");
            askCookBookToSell(size);
        }
        if((Integer.parseInt(choice) > size) || (Integer.parseInt(choice) <= 0)){
            Printer.printMessage("Scegli un cookBook valido");
            askCookBookToSell(size);
        }
        return Integer.parseInt(choice);
    }
}
