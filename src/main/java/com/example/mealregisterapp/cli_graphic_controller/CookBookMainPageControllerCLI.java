package com.example.mealregisterapp.cli_graphic_controller;

import com.example.mealregisterapp.app_controller.RecipeMakerController;
import com.example.mealregisterapp.utils.ClearCLI;
import com.example.mealregisterapp.utils.NotImplementedMessage;
import com.example.mealregisterapp.utils.Printer;

import java.util.Scanner;

import static com.example.mealregisterapp.utils.ValidInputCheck.checkInputDigit;

public class CookBookMainPageControllerCLI {

    private ChefHomePageControllerCLI chefHomePageControllerCLI;

    public CookBookMainPageControllerCLI(ChefHomePageControllerCLI chefHomePageControllerCLICurrent) {
        this.chefHomePageControllerCLI = chefHomePageControllerCLICurrent;
    }

    public void displayCookBookMainPage() {
        ClearCLI.clear();
        Printer.printPageTitle("CookBook Page");
        Printer.printMessage("Scegli un operazione:\n");
        Printer.printMessage("1)View my CookBooks\n2)Create new CookBook\n3)View Recipe\n4)Create new Recipe\n5)HomePage\n");
        Scanner scanner = new Scanner(System.in);
        handleChoice(scanner.nextLine());
    }

    private void handleChoice(String nextLine) {
        if(!checkInputDigit(nextLine)){
            Printer.printMessage("Inserisci un input valido");
            displayCookBookMainPage();
        }else {
            switch (Integer.parseInt(nextLine)){
                case 1 -> cookBookList();
                case 2 -> newCookBook();
                case 3 -> NotImplementedMessage.notImplementedYetMessage();
                case 4 -> createNewRecipe();
                case 5 -> chefHomePageControllerCLI.displayHomePage();
                default -> {
                    Printer.printMessage("Inserisci un input valido");
                    displayCookBookMainPage();
                }
            }
        }
    }

    private void createNewRecipe() {
        RecipeMakerController recipeMakerController = new RecipeMakerController();
        recipeMakerController.createNewRecipe();
    }

    private void newCookBook() {
        NotImplementedMessage.notImplementedYetMessage();
    }

    private void cookBookList() {
        NotImplementedMessage.notImplementedYetMessage();
    }
}
