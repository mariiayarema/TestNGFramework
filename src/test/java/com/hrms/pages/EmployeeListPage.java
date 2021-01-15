package com.hrms.pages;

import com.hrms.utils.CommonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmployeeListPage {

    @FindBy(id = "personal_txtEmpFirstName")
    public WebElement perInfoFirstName;

    @FindBy(id="personal_txtEmpLastName")
    public WebElement perInfoLastName;

    public EmployeeListPage(){

        PageFactory.initElements(CommonMethods.driver,this);
    }
}
