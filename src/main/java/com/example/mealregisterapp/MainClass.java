package com.example.mealregisterapp;

import com.example.mealregisterapp.cli_graphic_controller.HomePageControllerCLI;
import com.example.mealregisterapp.utils.Printer;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Scanner;

public class MainClass extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        SceneManager sceneManager = SceneManager.getInstance(stage);
        sceneManager.showHomePage();
        stage.show();
    }

    public static void main(String[] args) {

        while (true) {
            Printer.printMessage("Welcome\nChoose the app interface\n1)CLI\n2)Desktop\n");
            Scanner scanner = new Scanner(System.in);
            try {
                int choice = scanner.nextInt();
            while (true){

                if (choice == 1) {
                HomePageControllerCLI homePageControllerCLI = new HomePageControllerCLI();
                homePageControllerCLI.displayHomePage();
            } else if (choice == 2) {
                launch();
            } else {
                Printer.printMessage("Enter a valid number");
                Printer.printMessage("-------------------------------------------------------");
                break;
            }
            }
            } catch (NumberFormatException e) {
                    launch();
                    break;
            }
        }
    }
}