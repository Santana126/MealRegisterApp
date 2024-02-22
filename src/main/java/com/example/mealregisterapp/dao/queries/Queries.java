package com.example.mealregisterapp.dao.queries;

import com.example.mealregisterapp.bean.CookBookBean;
import com.example.mealregisterapp.model.CookBook;
import com.example.mealregisterapp.model.Recipe;
import com.example.mealregisterapp.utils.Printer;

public class Queries {

    private Queries() {
    }

    public static String checkLogin(String email, String password) {
        return "SELECT CASE WHEN EXISTS (SELECT username, password FROM Users WHERE email = '" + email + "' AND password = '" + password + "') THEN 1 WHEN EXISTS (SELECT name, password FROM Chefs WHERE email = '" + email + "' AND password = '" + password + "') THEN 2 END;";
    }

    public static String selectUserById(int userId) {

        return "SELECT * FROM Users WHERE userId = '" + userId + "';";
    }

    public static String selectUserByEmail(String email) {

        return "SELECT * FROM Users WHERE email = '" + email + "';";
    }

    public static String selectChefByEmail(String email) {
        return "SELECT * FROM Chefs WHERE email = '" + email + "';";
    }

    public static String saveRecipe(Recipe recipe) {
        return "INSERT INTO `cookbookapp`.`Recipe` (`name`,`description`,`difficult`, `cost`,`author`) VALUES ('" + recipe.getName() + "', '" + recipe.getDescription() + "', '" + recipe.getDifficult() + "', '" + recipe.getCost() + "', " + recipe.getAuthor().getChefID() + ");";
    }

    public static String loadChefRecipe(int chefID) {
        return "SELECT * FROM Recipe WHERE author = " + chefID + ";";
    }

    public static String saveCookBook(CookBook cookBook, Recipe recipe) {
        Printer.printMessage("('" +cookBook.getTitle() + "'," + cookBook.getAuthor().getChefID() + "," + recipe.getRecipeId() + ", '" + cookBook.getDescription() + "');");
        return "INSERT INTO `cookbookapp`.`CookBook` (`title`, `authorId`, `recipeId`, `description`) VALUES ('" + cookBook.getTitle() + "'," + cookBook.getAuthor().getChefID() + "," + recipe.getRecipeId() + ", '" + cookBook.getDescription() + "');";
    }

    public static String loadChefCookBooks(int chefID) {
        return "SELECT * FROM CookBook WHERE authorId = '" + chefID + "';";
    }

    public static String sellCookBook(CookBookBean cookBook) {
        return "UPDATE `cookbookapp`.`CookBook` SET isSelling = 1 WHERE authorId = '" + cookBook.getAuthor().getChefID() + "' AND title = '" + cookBook.getTitle() + "' ;";
    }
}
