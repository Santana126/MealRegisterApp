package junit;

import com.example.mealregisterapp.app_controller.CookBookMakerControllerApp;
import com.example.mealregisterapp.bean.ChefBean;
import com.example.mealregisterapp.bean.CookBookBean;
import com.example.mealregisterapp.bean.RecipeBean;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestRecipeAddedIntoCookBook {

    //Test if a recipe is correctly added into the cookbook

    @Test
    void addRecipe() {

        RecipeBean recipeBean = new RecipeBean("Pasta", "Pasta al dente", 42);
        CookBookMakerControllerApp cookBookMakerControllerApp = new CookBookMakerControllerApp();
        List<RecipeBean> recipeBeanList = new ArrayList<>();
        recipeBeanList.add(recipeBean);
        ChefBean chefBean = new ChefBean(1, "Franco", "Crimini", "franchi@gmail.com");
        CookBookBean cookBookBean = new CookBookBean(chefBean, "TestTitle", "DescriptionTitle");
        cookBookMakerControllerApp.insertRecipeIntoCookBook(recipeBeanList, cookBookBean);

        assertEquals(recipeBeanList, cookBookMakerControllerApp.takeRecipeFromCookBook(cookBookBean));

    }

}
