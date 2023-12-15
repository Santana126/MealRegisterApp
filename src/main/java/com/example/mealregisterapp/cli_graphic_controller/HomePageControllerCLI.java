package com.example.mealregisterapp.cli_graphic_controller;

import com.example.mealregisterapp.utils.ClearCLI;
import com.example.mealregisterapp.utils.Printer;

public class HomePageControllerCLI {


    public void displayHomePage() {
        ClearCLI.clear();
        Printer.printMessage("-------------------------");
        Printer.printMessage("--------Welcome----------");
        Printer.printMessage("-------Home Page---------");
    }
}
