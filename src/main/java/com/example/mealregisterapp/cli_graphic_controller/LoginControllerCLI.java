package com.example.mealregisterapp.cli_graphic_controller;

import com.example.mealregisterapp.app_controller.LoginController;
import com.example.mealregisterapp.bean.LoginBean;
import com.example.mealregisterapp.exception.*;
import com.example.mealregisterapp.utils.Printer;

import java.sql.SQLException;
import java.util.Scanner;

import static com.example.mealregisterapp.utils.NotImplementedMessage.notImplementedYetMessage;

public class LoginControllerCLI {


    public void displayLoginPage() {
        Printer.printPageTitle("Login Page");
        Printer.printMessage("1)Login\n2)Forgot Password\n3)Login with Google\n4)Register\n5)Continue as Guest");
        Scanner scanner = new Scanner(System.in);
        handleChoice(scanner.nextLine());
    }

    private void handleChoice(String nextLine) {
        if (!checkInput(nextLine)) {
            Printer.printMessage("Inserire un input valido");
        } else {

            switch (Integer.parseInt(nextLine)) {
                case 1 -> //Launch LoginApplicationController
                        getCredentials();
                case 2, 3, 4 -> notImplementedYetMessage();
                case 5 -> {
                    UserHomePageControllerCLI userHomePageControllerCLI = new UserHomePageControllerCLI();
                    userHomePageControllerCLI.displayHomePage();
                    //Launch App with Session(null)
                }
                default -> {
                    Printer.printMessage("Scegli una funzione valida");
                    displayLoginPage();
                }
            }
        }
    }

    private void getCredentials() {
        Printer.printMessage("Insert email:\n");
        Scanner scanner = new Scanner(System.in);
        String email = scanner.nextLine();
        Printer.printMessage("Insert password\n");
        String password = scanner.nextLine();


        checkLogin(email, password);
    }

    private void checkLogin(String email, String password) {
        try {
            LoginBean loginBean = new LoginBean(email, password);
            LoginController loginController = new LoginController();
            loginController.checkLogin(loginBean);

            if (loginBean.getAccountType() == 1) {
                loginController.completeUserLogin(loginBean);
                UserHomePageControllerCLI userHomePageControllerCLI = new UserHomePageControllerCLI();
                userHomePageControllerCLI.displayHomePage();
            } else if (loginBean.getAccountType() == 2) {
                loginController.completeChefLogin(loginBean);
                ChefHomePageControllerCLI chefHomePageControllerCLI = new ChefHomePageControllerCLI();
                chefHomePageControllerCLI.displayHomePage();
            } else {
                throw new UserNotFoundException();
            }
        } catch (EmailFormatException | UserNotFoundException | NotFoundException | SQLException |
                 RetriveUserException | CheckLoginException | RetriveUserCSVEXception e) {
            Printer.error(e.getMessage());
            displayLoginPage();
        }
    }

    private boolean checkInput(String nextLine) {
        if (nextLine.length() > 1) {
            return false;
        }
        return nextLine.matches("\\d+");
    }

}
