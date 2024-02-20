package com.example.mealregisterapp.cli_graphic_controller;

import com.example.mealregisterapp.bean.ChefBean;
import com.example.mealregisterapp.bean.UserBean;
import com.example.mealregisterapp.session.Session;
import com.example.mealregisterapp.utils.ClearCLI;
import com.example.mealregisterapp.utils.Printer;

import java.util.Scanner;

import static com.example.mealregisterapp.utils.NotImplementedMessage.notImplementedYetMessage;

public class AccountPageControllerCLI {

    private final UserHomePageControllerCLI userHomePageControllerCLI = new UserHomePageControllerCLI();


    public void displayAccountPage() {

        ClearCLI.clear();
        Printer.printPageTitle("My Account");
        choiceMenu();

    }

    private void choiceMenu() {
        Printer.printMessage("Scegli un operazione:");
        Printer.printMessage("1)Show Account Info\n2)Modify Account\n3)Home Page");
        Scanner scanner = new Scanner(System.in);
        handleChoice(scanner.nextLine());
    }

    private void handleChoice(String nextLine) {
        switch (Integer.parseInt(nextLine)) {
            case 1 -> accountInfo();
            case 2 -> notImplementedYetMessage();
            case 3 -> userHomePageControllerCLI.displayHomePage();
            default -> {
                Printer.printMessage("Scegli una funzione valida");
                displayAccountPage();
            }
        }
    }

    private void accountInfo() {
        ClearCLI.clear();
        Printer.printPageTitle("Welcome to Your Account");
        if (Session.getCurrentSession().getType() == 1) {
            //User type
            UserBean userBean = Session.getCurrentSession().getUserBean();
            Printer.printMessage("Username: " + userBean.getUsername());
            Printer.printMessage("Email: " + userBean.getEmail());
        } else {
            ChefBean chefBean = Session.getCurrentSession().getChefBean();
            Printer.printMessage("Name: " + chefBean.getName());
            Printer.printMessage("Surname: " + chefBean.getSurname());
            Printer.printMessage("Username: " + chefBean.getUsername());
            Printer.printMessage("Email: " + chefBean.getEmail());
        }
        Printer.printEndOfPage();
        choiceMenu();
    }


}
