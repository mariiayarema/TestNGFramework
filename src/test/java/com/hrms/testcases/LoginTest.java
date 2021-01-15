package com.hrms.testcases;

import com.hrms.pages.DashboardPage;
import com.hrms.pages.LoginPage;
import com.hrms.utils.CommonMethods;
import com.hrms.utils.ConfigsReader;
import org.junit.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Date;

public class LoginTest extends CommonMethods {



    @Test(groups = "smoke")
    public void adminLogin(){

        //creating objects of pages
        LoginPage login=new LoginPage();
        DashboardPage dashboardPage=new DashboardPage();

        //login in with valid credentials
        sendText(login.usernameBox,ConfigsReader.getPropertyValue("username"));
        sendText(login.passwordBox,ConfigsReader.getPropertyValue("password"));
        JSClick(login.loginBtn);

        //validation
        Assert.assertTrue("Welcome message is NOT dispaled",dashboardPage.welcomeMessage.isDisplayed());
    }




    @Test(dataProvider = "invalidData",groups = "regression")
    public void invalidLoginErrorMessageValidation(String username,String password,String errorMsg ) {
        LoginPage login = new LoginPage();
        DashboardPage dashboardPage = new DashboardPage();

        sendText(login.usernameBox, username);
        sendText(login.passwordBox,password);
        click(login.loginBtn);
        //validation
        Assert.assertEquals(login.errorMsg.getText(),errorMsg);


    }

    @DataProvider
    public Object[][] invalidData() {

        Object[][] data = {
                {"James", "123!", "Invalid credentials"},
                {"Admin1", "Hum@Syntax123!", "Invalid credentials"},
                {"James", "", "Password cannot be empty"},
                {"", "Syntax123!", "Username cannot be empty"}
        };
        return data;

    }


}
