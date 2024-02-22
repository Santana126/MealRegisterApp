package com.example.mealregisterapp.cli_graphic_controller;

import com.example.mealregisterapp.app_controller.CookBookSellingController;
import com.example.mealregisterapp.bean.CookBookBean;
import com.example.mealregisterapp.exception.UpdateCookBookStatusException;
import com.example.mealregisterapp.utils.Printer;

import java.util.List;
import java.util.Scanner;

import static com.example.mealregisterapp.utils.ValidInputCheck.checkInputDigit;

public class CookBookSellingControllerCLI {
    public void showErrorMessage(String message) {
        Printer.error(message);
    }

    public int askCookBookToSell(int size) {

        Printer.printMessage("Scegli il CookBook da vendere:");
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine();
        if(!checkInputDigit(choice)){
            Printer.printMessage("Inserisci un input corretto");
            askCookBookToSell(size);
        }
        if((Integer.parseInt(choice) > size) || (Integer.parseInt(choice) <= 0)){
            Printer.printMessage("Scegli un cookBook valido");
            askCookBookToSell(size);
        }
        return Integer.parseInt(choice);
    }

    public void sellCookBook(List<CookBookBean> cookBookBeanList) {
        int choice = askCookBookToSell(cookBookBeanList.size());

        CookBookSellingController cookBookSellingController = new CookBookSellingController();
        try {
            cookBookSellingController.sellCookBookToUser(cookBookBeanList,choice);
        } catch (UpdateCookBookStatusException e) {
            showErrorMessage(e.getMessage());
        }
    }
}
