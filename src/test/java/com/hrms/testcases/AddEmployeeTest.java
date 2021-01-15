package com.hrms.testcases;

import com.hrms.pages.AddEmployeePage;
import com.hrms.pages.DashboardPage;
import com.hrms.pages.EmployeeListPage;
import com.hrms.pages.LoginPage;
import com.hrms.utils.CommonMethods;
import com.hrms.utils.ConfigsReader;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddEmployeeTest extends CommonMethods {

    @Test(groups = "regression")
    public void addEmployee() {

        DashboardPage dashboardPage=new DashboardPage();
        AddEmployeePage addEmployeePage=new AddEmployeePage();
        LoginPage login = new LoginPage();
        EmployeeListPage employeeListPage=new EmployeeListPage();
        login.login(ConfigsReader.getPropertyValue("username"),ConfigsReader.getPropertyValue("password"));

        //navigate to add employee page
        JSClick(dashboardPage.pimBtn);
        JSClick(dashboardPage.addEmployeeBtn);

        //add employee
        sendText(addEmployeePage.firstNameTextBox,"Aniya");
        String firstName=addEmployeePage.firstNameTextBox.getText();
        sendText(addEmployeePage.middleNameTxtbox,"Evgeniivna");
        sendText(addEmployeePage.lastNameTxtbox,"Slobodian");
        sendText(addEmployeePage.empIDTxtbox,"4450");
        JSClick(addEmployeePage.saveButton);

        //validation
        Assert.assertEquals(employeeListPage.perInfoFirstName.getText(),firstName);




    }
}
