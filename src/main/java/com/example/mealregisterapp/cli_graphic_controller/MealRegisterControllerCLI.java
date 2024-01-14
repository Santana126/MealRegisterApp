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

    private List<BeanFood> listOfFoodChoice = new ArrayList<>();

    public void displayMealRegisterPage() {
        ClearCLI.clear();
        Printer.printPageTitle("Meal Register Page");
        registMeal();
    }

    private void registMeal() {
        boolean saved = false;
        while (!saved) {
            Printer.printMessage("Inserisci la data del pasto:");
            Scanner scanner = new Scanner(System.in);
            data = scanner.nextLine();
            mealType = null;
            do {
                mealType = selectMealType();
            } while (mealType == null);
            try {
                mealRegisterController.createMeal(data, mealType);
            } catch (SQLException | SaveMealException e) {
                throw new RuntimeException(e);
            }
            do {
                showAvailableFood();
                BeanFood beanFood = new BeanFood();
                beanFood.setName(listOfAvailableFood.get(chooseFood() - 1));
                listOfFoodChoice.add(beanFood);
            } while (askAnotherFood());

            if (showMealResume()) {
                try {
                    mealRegisterController.addFoodToMeal(listOfFoodChoice);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                try {
                    mealRegisterController.saveMeal();
                } catch (SQLException | SaveMealException e) {
                    throw new RuntimeException(e);
                }
                try {
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
        return scanner.nextInt();
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

    private MealType selectMealType() {
        Printer.printMessage("Inserisci il tipo di pasto:");
        Printer.printMessage("1)Colazione\n2)Pranzo\n3)Cena\n4)Spuntino");
        Scanner scanner = new Scanner(System.in);

        MealType mealTypeInput;

        switch (scanner.nextLine()) {
            case "1" -> mealTypeInput = MealType.COLAZIONE;
            case "2" -> mealTypeInput = MealType.PRANZO;
            case "3" -> mealTypeInput = MealType.CENA;
            case "4" -> mealTypeInput = MealType.SPUNTINO;
            default -> {
                Printer.printMessage("Inserisci un opzione valida");
                return null;
            }
        }
        return mealTypeInput;
    }
}
