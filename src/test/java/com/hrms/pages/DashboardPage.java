package com.hrms.pages;

import com.hrms.utils.CommonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage extends CommonMethods {
    @FindBy(id = "welcome")
    public WebElement welcomeMessage;

    @FindBy(xpath = "//b[text() = 'PIM']")
    public WebElement pimBtn;

    @FindBy(xpath = "//a[text() = 'Add Employee']")
    public WebElement addEmployeeBtn;


    public DashboardPage() {
        PageFactory.initElements(driver, this);
    }
}
