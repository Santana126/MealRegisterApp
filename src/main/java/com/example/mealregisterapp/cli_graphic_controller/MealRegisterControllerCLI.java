package com.example.mealregisterapp.cli_graphic_controller;

import com.example.mealregisterapp.app_controller.MealRegisterController;
import com.example.mealregisterapp.bean.BeanFood;
import com.example.mealregisterapp.exception.SaveMealException;
import com.example.mealregisterapp.model.MealType;
import com.example.mealregisterapp.utils.ClearCLI;
import com.example.mealregisterapp.utils.Printer;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MealRegisterControllerCLI {

    MealRegisterController mealRegisterController = new MealRegisterController();

    private String data;

    private MealType mealType;

    private List<String> listOfAvailableFood;

    private final List<BeanFood> listOfFoodChoice = new ArrayList<>();

    public void displayMealRegisterPage() {
        ClearCLI.clear();
        Printer.printPageTitle("Meal Register Page");
        registMeal();
    }

    private void registMeal() {
        boolean saved = false;
        while (!saved) {
            selectData();
            selectMealType();
            try {
                mealRegisterController.createMeal(data, mealType);
            } catch (SQLException | SaveMealException e) {
                throw new RuntimeException(e);
            }
            selectFoods();

            if (showMealResume()) {
                try {
                    mealRegisterController.addFoodToMeal(listOfFoodChoice);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                try {
                    mealRegisterController.saveMeal();
                    mealRegisterController.mealResumeConfirmed();
                } catch (SQLException | SaveMealException e) {
                    throw new RuntimeException(e);
                }
                saved = true;
            } else {
                listOfFoodChoice.clear();
            }
        }
    }

    private void selectFoods() {
        do {
            showAvailableFood();
            BeanFood beanFood = new BeanFood();
            Integer choice;
            do {
                choice = chooseFood();
                if ((choice != null) && (choice > listOfAvailableFood.size())) {
                    choice = null;
                }
            } while (choice == null);
            beanFood.setName(listOfAvailableFood.get(choice - 1));
            listOfFoodChoice.add(beanFood);
        } while (askAnotherFood());
    }


    private void selectData() {
        Printer.printMessage("Inserisci la data del pasto:");
        Scanner scanner = new Scanner(System.in);
        data =  scanner.nextLine();
    }

    private boolean showMealResume() {

        Printer.printMessage("Meal Resume:");
        for (BeanFood food :
                listOfFoodChoice) {
            Printer.printMessage(food.getName());
        }
        return askYesOrNo("Confirm Meal?");


    }

    private boolean askAnotherFood() {
        return askYesOrNo("Vuoi aggiungere un nuovo cibo?");
    }

    private boolean askYesOrNo(String message) {
        while (true) {
            Printer.printMessage(message);
            Printer.printYesOrNo();
            Scanner scanner = new Scanner(System.in);
            switch (scanner.nextLine()) {
                case "Yes" -> {
                    return true;
                }
                case "No" -> {
                    return false;
                }
                default -> Printer.printMessage("Inserisci un opzione valida");
            }
        }
    }

    private Integer chooseFood() {
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine();
        if (choice.matches("\\d+")) {
            return Integer.parseInt(choice);
        } else {
            return null;
        }
    }

    private void showAvailableFood() {

        try {
            listOfAvailableFood = mealRegisterController.loadAvailableFood();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        Integer index = 1;
        for (String foodName : listOfAvailableFood
        ) {
            Printer.printMessage(index + ") " + foodName);
            index++;
        }

    }

    private void selectMealType() {
        do {
            Printer.printMessage("Inserisci il tipo di pasto:");
            Printer.printMessage("1)Colazione\n2)Pranzo\n3)Cena\n4)Spuntino");
            Scanner scanner = new Scanner(System.in);

            switch (scanner.nextLine()) {
                case "1" -> mealType = MealType.COLAZIONE;
                case "2" -> mealType = MealType.PRANZO;
                case "3" -> mealType = MealType.CENA;
                case "4" -> mealType = MealType.SPUNTINO;
                default -> {
                    Printer.printMessage("Inserisci un opzione valida");
                    mealType = null;
                }
            }
        }while (mealType == null);
    }
}
