package junit;

import com.example.mealregisterapp.bean.ChefBean;
import com.example.mealregisterapp.bean.CookBookBean;
import com.example.mealregisterapp.dao.CookBookDAO;
import com.example.mealregisterapp.exception.SaveCookBookException;
import com.example.mealregisterapp.model.CookBook;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestProperlySaveCookbook {

    //Test if a cookbook is correctly saved into the DB

    @Test
    void saveCookBook() {
        //cookbook saving test into DB
            CookBookDAO cookBookDAO =new CookBookDAO();
        try{
            ChefBean chefBean = new ChefBean(1,"Franco","Crimini","franchi@gmail.com");
            CookBookBean cookBookBean = new CookBookBean(chefBean,"TestTitle","DescriptionTitle");
            CookBook cookBook = new CookBook(cookBookBean);
            cookBookDAO.saveCookBook(cookBook);
        } catch (SaveCookBookException e) {
            //Do Nothing
        } finally {
            assertEquals(1,cookBookDAO.getOutcome());
        }
    }
}
