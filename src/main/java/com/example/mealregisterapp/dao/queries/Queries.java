package com.example.mealregisterapp.dao.queries;

import com.example.mealregisterapp.model.Recipe;

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
        return "INSERT INTO `cookbookapp`.`Recipe` (`name`,`description`,`difficult`, `cost`,`author`) VALUES ('"+ recipe.getName() +"', '" + recipe.getDescription() +"', '" + recipe.getDifficult() +"', '" + recipe.getCost() +"', " + recipe.getAuthor().getChefID() + ");";
    }
}
