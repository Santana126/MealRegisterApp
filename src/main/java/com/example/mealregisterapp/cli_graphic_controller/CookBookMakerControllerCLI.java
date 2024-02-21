package com.example.mealregisterapp.cli_graphic_controller;

import com.example.mealregisterapp.app_controller.CookBookMakerControllerApp;
import com.example.mealregisterapp.bean.CookBookBean;
import com.example.mealregisterapp.bean.RecipeBean;
import com.example.mealregisterapp.session.Session;
import com.example.mealregisterapp.utils.Printer;

import java.util.List;
import java.util.Scanner;

import static com.example.mealregisterapp.utils.ValidInputCheck.checkInputDigit;

public class CookBookMakerControllerCLI {

    CookBookMakerControllerApp cookBookMakerControllerApp;

    public CookBookMakerControllerCLI(CookBookMakerControllerApp cookBookMakerControllerApp) {
        this.cookBookMakerControllerApp = cookBookMakerControllerApp;
    }

    public CookBookBean createCookBook() {
        Printer.printPageTitle("Cook Book Page");

        return new CookBookBean(Session.getCurrentSession().getChefBean(), askCookBookTitle(), askDescription());

    }

    private String askDescription() {

        Printer.printMessage("Wanna insert Description?");
        Scanner scanner = new Scanner(System.in);
        Printer.printYesOrNo();
        String input = scanner.nextLine();
        if (input.equals("Yes")) {
            Printer.printMessage("CookBook description: \n");
            String cookBookDescription = scanner.nextLine();
            Printer.printMessage("Confirm description: " + cookBookDescription);
            Printer.printYesOrNo();
            if (!scanner.nextLine().equals("Yes")) {
                Printer.printMessage("Insert valid description...");
                return askDescription();
            }
            return cookBookDescription;
        } else if (input.equals("No")) {
            return "";
        } else {
            Printer.printMessage("Enter a valid choice...");
            return askDescription();
        }
    }

    private String askCookBookTitle() {
        Printer.printMessage("CookBook title: \n");
        Scanner scanner = new Scanner(System.in);
        String title = scanner.nextLine();
        Printer.printMessage("Confirm title: " + title);
        Printer.printYesOrNo();
        if (!scanner.nextLine().equals("Yes")) {
            Printer.printMessage("Insert correct title...");
            return askCookBookTitle();
        }
        return title;

    }

    public void cookBookMenu() {
        Printer.printPageTitle("CookBook Page");
        Scanner scanner;
        do {
            Printer.printMessage("Scegli un operazione:\n");
            Printer.printMessage("1)View CookBook Resume\n2)View Recipe\n3)Insert Recipe\n4)Confirm CookBook\n");
            scanner = new Scanner(System.in);
            Printer.printEndOfPage();
        } while (handleChoice(scanner.nextLine()));
        Printer.printEndOfPage();
    }

    private boolean handleChoice(String nextLine) {
        boolean condition = !checkInputDigit(nextLine);
        if (condition) {
            Printer.printMessage("Inserisci un input corretto");
            cookBookMenu();
        } else {
            int input = Integer.parseInt(nextLine);
            switch (input) {
                case 1 -> {
                    cookBookMakerControllerApp.showCookBookResume();
                    return true;
                }
                case 2 -> {
                    cookBookMakerControllerApp.viewRecipeOnCookBook();
                    return true;
                }

                case 3 -> {
                    Printer.printPageTitle("Recipe Page");
                    cookBookMakerControllerApp.insertNewRecipe();
                    return true;
                }
                case 4 -> {
                    cookBookMakerControllerApp.confirmCookBook();
                    return false;
                }
                default -> {
                    Printer.printMessage("Inserisci un input valido");
                    return true;
                }
            }
        }
        return true;

    }

    public void displayCookBookResume(CookBookBean newCookBookBean) {
        Printer.printPageTitle("CookBook Resume");
        displayCookBook(newCookBookBean);
        Printer.printEndOfPage();
    }

    private void displayCookBook(CookBookBean cookBookBean) {
        Printer.printMessage("Title: " + cookBookBean.getTitle() + "\nAuthor: " + cookBookBean.getAuthor().getName() + " " + cookBookBean.getAuthor().getSurname());
        if (!cookBookBean.getDescription().equals("")) {
            Printer.printMessage("Description: " + cookBookBean.getDescription());
        }
    }

    public void displayCookBookRecipes(CookBookBean newCookBookBean) {
        Printer.printPageTitle("CookBook Recipes");
        for (RecipeBean recipe : newCookBookBean.getRecipeBeanList()
        ) {
            Printer.printMessage("\n-- Recipe: " + recipe.getName() + "\n   Description:" + recipe.getDescription());
        }
    }

    public RecipeBean selectRecipe() {

        Printer.printPageTitle("Insert Recipe into this CookBook");

        return chooseRecipeFromList(cookBookMakerControllerApp.takeRecipeList());
    }

    private RecipeBean chooseRecipeFromList(List<RecipeBean> recipeBeans) {
        int i = 1;
        for (RecipeBean recipe :
                recipeBeans) {
            Printer.printMessage(i + ")Recipe\n\tName: " + recipe.getName() + "\n\tDescription: " + recipe.getDescription());
            i++;
        }
        Scanner scanner;
        do {
            Printer.printMessage("Scegli la ricetta da inserire:\n");
            scanner = new Scanner(System.in);
        } while (!checkInputDigit(scanner.nextLine()));
        return recipeBeans.get(i - 1);
    }

    public void cookBookSaveError(String message) {
        Printer.error("Error: " + message);
    }
}
