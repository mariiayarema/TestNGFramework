package com.hrms.testcases;

import com.hrms.pages.AddEmployeePage;
import com.hrms.pages.DashboardPage;
import com.hrms.pages.EmployeeListPage;
import com.hrms.pages.LoginPage;
import com.hrms.utils.CommonMethods;
import com.hrms.utils.ConfigsReader;
import com.hrms.utils.Constants;
import com.hrms.utils.ExcelReading;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import sun.security.util.Password;

import java.util.List;
import java.util.Map;

public class AddMultipleEmployee extends CommonMethods {

   // @Test(groups = "regression")
    public void addMultpEmployee() {

        //creating object of pages
        DashboardPage dashboardPage = new DashboardPage();
        AddEmployeePage addEmployeePage = new AddEmployeePage();
        LoginPage login = new LoginPage();
        EmployeeListPage employeeListPage = new EmployeeListPage();

        //login in to HRMS
        login.login(ConfigsReader.getPropertyValue("username"), ConfigsReader.getPropertyValue("password"));

        //converting excel into map
        List<Map<String, String>> listOfMaps = ExcelReading.exelIntoListOfMaps(Constants.EXCEL_FILEPATH, "EmployeeData");

        //looping through maps
        for (int i = 0; i < listOfMaps.size(); i++) {

            //navigating to add employee page
            JSClick(dashboardPage.pimBtn);
            JSClick(dashboardPage.addEmployeeBtn);


            sendText(addEmployeePage.firstNameTextBox, listOfMaps.get(i).get("FirstName"));
            String expectedFirstName = addEmployeePage.firstNameTextBox.getAttribute("value");


            sendText(addEmployeePage.middleNameTxtbox, listOfMaps.get(i).get("MiddleName"));
            sendText(addEmployeePage.lastNameTxtbox, listOfMaps.get(i).get("LastName"));

            addEmployeePage.photographInput.sendKeys(listOfMaps.get(i).get("Photograph"));

            JSClick(addEmployeePage.createLoginCheckbox);

            sendText(addEmployeePage.usernameTxtbox, listOfMaps.get(i).get("Username"));
            sendText(addEmployeePage.passwordTxtbox, listOfMaps.get(i).get("Password"));

            getSelect(addEmployeePage.statusDD).selectByValue("Enabled");

            JSClick(addEmployeePage.saveButton);

            //validation
            Assert.assertEquals(employeeListPage.perInfoFirstName.getText(), expectedFirstName, "First name doesnt match");

        }


    }
}
