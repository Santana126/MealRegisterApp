package com.example.mealregisterapp.cli_graphic_controller;

import com.example.mealregisterapp.app_controller.CookBookSellingController;
import com.example.mealregisterapp.bean.CookBookBean;
import com.example.mealregisterapp.exception.LoadCookBookException;
import com.example.mealregisterapp.session.Session;
import com.example.mealregisterapp.utils.ClearCLI;
import com.example.mealregisterapp.utils.NotImplementedMessage;
import com.example.mealregisterapp.utils.Printer;

import java.util.List;
import java.util.Scanner;

import static com.example.mealregisterapp.utils.ValidInputCheck.checkInputDigit;

public class CookBookMainPageControllerCLI {

    public void displayCookBookMainPage() {
        ClearCLI.clear();
        Printer.printPageTitle("CookBook Page");
        Printer.printMessage("Scegli un operazione:\n");
        Printer.printMessage("1)View my CookBooks\n2)Create new CookBook\n3)View Recipe\n4)Create new Recipe\n5)HomePage\n");
        Scanner scanner = new Scanner(System.in);
        handleChoice(scanner.nextLine());
    }

    private void handleChoice(String nextLine) {
        if (!checkInputDigit(nextLine)) {
            Printer.printMessage("Inserisci un input valido");
            displayCookBookMainPage();
        } else {
            switch (Integer.parseInt(nextLine)) {
                case 1 -> cookBookList();
                case 2 -> newCookBook();
                case 3 -> NotImplementedMessage.notImplementedYetMessage();
                case 4 -> createNewRecipe();
                case 5 -> {
                    ChefHomePageControllerCLI chefHomePageControllerCLI = new ChefHomePageControllerCLI();
                    chefHomePageControllerCLI.displayHomePage();
                }
                default -> {
                    Printer.printMessage("Inserisci un input valido...");
                    displayCookBookMainPage();
                }
            }
        }
    }

    private void createNewRecipe() {
        RecipeMakerControllerCLI recipeMakerControllerCLI = new RecipeMakerControllerCLI();
        recipeMakerControllerCLI.createRecipe();

    }

    private void newCookBook() {
        CookBookMakerControllerCLI cookBookMakerControllerCLI = new CookBookMakerControllerCLI();
        cookBookMakerControllerCLI.createCookBook();
    }

    private void cookBookList() {
        CookBookSellingController cookBookSellingController = new CookBookSellingController();
        List<CookBookBean> cookBookBeanList = null;
        try {
            cookBookBeanList = cookBookSellingController.takeCookBookList(Session.getCurrentSession().getChefBean());
            showCookBookList(cookBookBeanList);
            chooseAction(cookBookBeanList);
        } catch (LoadCookBookException e) {
            Printer.error(e.getMessage());
        }
    }

    private void chooseAction(List<CookBookBean> cookBookBeanList) {
        Printer.printMessage("------------------------");
        Printer.printMessage("---Choose a function----");
        Printer.printMessage("\n1)Sell CookBook\n2)Modify CookBook\n3)Delete CookBook\n4)Back");
        Scanner scanner = new Scanner(System.in);
        if (!checkInputDigit(scanner.nextLine())) {
            Printer.printMessage("Inserisci un input corretto");
            chooseAction(cookBookBeanList);
        } else {
            switch (Integer.parseInt(scanner.nextLine())) {
                case 1 -> {
                    CookBookSellingControllerCLI cookBookSellingControllerCLI = new CookBookSellingControllerCLI();
                    cookBookSellingControllerCLI.sellCookBook(cookBookBeanList);
                }
                case 2, 3 -> NotImplementedMessage.notImplementedYetMessage();
                case 4 -> displayCookBookMainPage();
                default -> {
                    Printer.printMessage("Inserisci un input valido..");
                    chooseAction(cookBookBeanList);
                }
            }
        }
    }


    private void showCookBookList(List<CookBookBean> cookBookBeanList) {
        Printer.printPageTitle("CookBooks");
        int i = 1;
        for (CookBookBean cookBookBean :
                cookBookBeanList) {
            Printer.printMessage("\n-------------------\n" + i + ")CookBook: " + cookBookBean.getTitle() + "\nAuthor: " + cookBookBean.getAuthor().getName() + " " + cookBookBean.getAuthor().getSurname() + "\nDescription: " + cookBookBean.getDescription());
            i++;
        }
    }
}
