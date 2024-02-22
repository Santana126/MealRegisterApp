package com.example.mealregisterapp.cli_graphic_controller;

import com.example.mealregisterapp.app_controller.RecipeMakerController;
import com.example.mealregisterapp.bean.ChefBean;
import com.example.mealregisterapp.bean.IngredientBean;
import com.example.mealregisterapp.bean.RecipeBean;
import com.example.mealregisterapp.exception.SaveRecipeException;
import com.example.mealregisterapp.utils.Printer;
import com.example.mealregisterapp.utils.ValidInputCheck;

import java.util.Scanner;

import static com.example.mealregisterapp.utils.ValidInputCheck.checkInputDigit;

public class RecipeMakerControllerCLI {


    public void createRecipe() {
        startPage();
        RecipeMakerController recipeMakerController = new RecipeMakerController();
        recipeMakerController.createNewRecipe(askRecipeName(), askRecipeDifficult(), askRecipeCost(), askRecipeDescription());
        recipeMenu();
    }

    private void startPage() {
        Printer.printPageTitle("New Recipe");
        Printer.printMessage("Insert the Recipe Info");
    }

    private String askRecipeDescription() {
        Printer.printMessage("Recipe description: \n");
        Scanner scanner = new Scanner(System.in);
        String description = scanner.nextLine();
        Printer.printMessage("Confirm description: " + description);
        Printer.printYesOrNo();
        if (!scanner.nextLine().equals("Yes")) {
            Printer.printMessage("Insert correct description...");
            return askRecipeDescription();
        }
        return description;
    }

    private int askRecipeCost() {
        Printer.printMessage("Recipe cost (1 to 5): \n");
        Scanner scanner = new Scanner(System.in);
        String cost = scanner.nextLine();
        if ((!ValidInputCheck.checkInputDigit(cost)) || (Integer.parseInt(cost) > 5) || (Integer.parseInt(cost) < 1)) {
            Printer.printMessage("Insert a valid number");
            return askRecipeCost();
        } else {
            Printer.printMessage("Confirm cost: " + cost);
            Printer.printYesOrNo();
            if (!scanner.nextLine().equals("Yes")) {
                Printer.printMessage("Insert correct cost...");
                return askRecipeCost();
            }
            return Integer.parseInt(cost);
        }
    }

    private int askRecipeDifficult() {
        Printer.printMessage("Recipe difficult (1 to 5): \n");
        Scanner scanner = new Scanner(System.in);
        String difficult = scanner.nextLine();
        if ((!ValidInputCheck.checkInputDigit(difficult)) || (Integer.parseInt(difficult) > 5) || (Integer.parseInt(difficult) < 1)) {
            Printer.printMessage("Insert a valid number");
            return askRecipeDifficult();
        } else {
            Printer.printMessage("Confirm difficult: " + difficult);
            Printer.printYesOrNo();
            if (!scanner.nextLine().equals("Yes")) {
                Printer.printMessage("Insert correct difficult...");
                return askRecipeDifficult();
            }
            return Integer.parseInt(difficult);
        }
    }

    private String askRecipeName() {
        Printer.printMessage("Recipe name: \n");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        Printer.printMessage("Confirm name: " + name);
        Printer.printYesOrNo();
        if (!scanner.nextLine().equals("Yes")) {
            Printer.printMessage("Insert correct name...");
            return askRecipeName();
        }
        return name;
    }



    public void recipeMenu() {
        Printer.printPageTitle("Recipe Page");
        Scanner scanner;
        do {
            Printer.printMessage("Scegli un operazione:\n");
            Printer.printMessage("1)View Recipe Resume\n2)View Ingredient\n3)Insert new Ingredient\n4)Confirm Recipe\n");
            scanner = new Scanner(System.in);
        } while (handleChoice(scanner.nextLine()));
        Printer.printEndOfPage();
    }

    private boolean handleChoice(String nextLine) {
        if (!checkInputDigit(nextLine)) {
            Printer.printMessage("Inserisci un input valido");
            recipeMenu();
        } else {
            switch (Integer.parseInt(nextLine)) {
                case 1 -> {
                    displayRecipeResume();
                    return true;
                }
                case 2 -> {
                    displayRecipeIngredients();
                    return true;
                }
                    
                case 3 -> {
                    addIngredientToRecipe();
                    return true;
                }
                case 4 -> {
                    recipeConfirmed();
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

    private void addIngredientToRecipe() {
        Printer.printPageTitle("Ingredient Page");
        IngredientBean ingredientBean = selectIngredient();

        RecipeMakerController recipeMakerController = new RecipeMakerController();
        recipeMakerController.insertIngredientIntoRecipe(ingredientBean);
    }


    public void displayRecipeResume() {
        Printer.printPageTitle("Recipe Resume :)");
        RecipeMakerController recipeMakerController = new RecipeMakerController();
        ChefBean chefBean = recipeMakerController.takeRecipeAuthor();
        displayRecipe(recipeMakerController.takeRecipeResume(), chefBean.getName(), chefBean.getSurname());
    }

    private void displayRecipe(RecipeBean recipeBean, String name, String surname) {
        Printer.printMessage("Name: " + recipeBean.getName() + "\nAuthor: " + name + " " + surname);
        Printer.printMessage("Difficult (1 to 5): " + recipeBean.getDifficult());
        Printer.printMessage("Cost (1 to 5): " + recipeBean.getCost());
        Printer.printMessage("Description: " + recipeBean.getDescription());
    }


    private void recipeConfirmed() {
        RecipeMakerController recipeMakerController = new RecipeMakerController();
        try {
            recipeMakerController.confirmRecipe();
        } catch (SaveRecipeException e) {
            recipeSaveError(e.getMessage());
        }

    }

    public IngredientBean selectIngredient() {

        Printer.printPageTitle("Insert Ingredient to this Recipe");

        String name = selectIngredientName();

        Float quantity = selectIngredientQuantity();

        return new IngredientBean(name, quantity);
    }

    private Float selectIngredientQuantity() {
        Printer.printMessage("Insert Ingredient quantity");
        Scanner scanner = new Scanner(System.in);
        String quantity = scanner.nextLine();
        if (!ValidInputCheck.checkInputDigit(quantity)) {
            Printer.printMessage("Insert a correct number...");
            return selectIngredientQuantity();
        } else {
            Printer.printMessage("Confirm quantity: " + quantity);
            Printer.printYesOrNo();
            if (!scanner.nextLine().equals("Yes")) {
                Printer.printMessage("Insert correct quantity...");
                return selectIngredientQuantity();
            }
            return Float.parseFloat(quantity);
        }
    }

    private String selectIngredientName() {
        Printer.printMessage("Insert Ingredient name");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        Printer.printMessage("Confirm name: " + name);
        Printer.printYesOrNo();
        if (!scanner.nextLine().equals("Yes")) {
            Printer.printMessage("Insert correct name...");
            return selectIngredientName();
        }
        return name;
    }

    public void displayRecipeIngredients() {
        RecipeMakerController recipeMakerController = new RecipeMakerController();
        RecipeBean recipeBean = recipeMakerController.takeRecipeResume();
        Printer.printPageTitle("Recipe Ingredients");
        for (IngredientBean ingredients: recipeBean.getIngredientBeanList()
             ) {
            Printer.printMessage("\n-- " + ingredients.getName());
        }
    }

    public void recipeSaveError(String message) {
        Printer.error("Error:\n" + message);
    }
}
