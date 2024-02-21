package com.example.mealregisterapp.app_controller;

import com.example.mealregisterapp.bean.ChefBean;
import com.example.mealregisterapp.bean.LoginBean;
import com.example.mealregisterapp.bean.UserBean;
import com.example.mealregisterapp.dao.*;
import com.example.mealregisterapp.exception.CheckLoginException;
import com.example.mealregisterapp.exception.NotFoundException;
import com.example.mealregisterapp.exception.RetriveUserCSVEXception;
import com.example.mealregisterapp.exception.RetriveUserException;
import com.example.mealregisterapp.model.ChefModel;
import com.example.mealregisterapp.model.UserModel;
import com.example.mealregisterapp.session.Session;
import com.example.mealregisterapp.utils.Settings;

import java.sql.SQLException;

public class LoginController {


    public void checkLogin(LoginBean loginBean) throws CheckLoginException {
        int type = LoginDAO.checkLogin(loginBean.getEmail(), loginBean.getPassword());
        loginBean.setAccountType(type);
    }

    public void completeUserLogin(LoginBean loginBean) throws NotFoundException, RetriveUserCSVEXception {
        UserDAO userDAO;
        Settings.setDaoImpl("JDBC");
        if (Settings.daoConfig().equals("JDBC")) {
            userDAO = new UserDAOJDBC();
        } else {
            userDAO = new UserDAOCSV();
        }
        UserModel userModel = userDAO.retrieveUserByEmail(loginBean.getEmail());
        UserBean userBean = new UserBean(userModel.getId(), userModel.getUsername(), userModel.getEmail());
        Session.setSessionInstance(userBean);

    }

    public void completeChefLogin(LoginBean loginBean) throws RetriveUserException {
        ChefModel chefModel = ChefDAO.retrieveChefByEmail(loginBean.getEmail());
        ChefBean chefBean = new ChefBean(chefModel.getId(), chefModel.getName(), chefModel.getSurname(), chefModel.getEmail());
        Session.setSessionInstance(chefBean);

    }
}
