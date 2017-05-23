package com.invoiceplane.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by user on 2/12/2017.
 */
public class Login {

    WebDriver driver;

    @FindBy(xpath = ".//*[@id='email']")
    WebElement txtEmail;


    @FindBy(xpath = ".//*[@id='password']")
    WebElement txtpassword;


    @FindBy(xpath = ".//*[@id='login']/form/input")
    WebElement btnlogin;


    @FindBy(xpath = ".//*[@id='login']/img")
    WebElement image;


    public Login(WebDriver driver) {
        this.driver = driver;

        PageFactory.initElements(driver, this);

    }


    public void setUsername(String username)
        {
        txtEmail.sendKeys(username);
    }      // set method used here

    public void setPassword(String password)

    {
        txtpassword.sendKeys(password);
    }        // set method used here

    public void clickLogin()
    {
        btnlogin.click();
    }
}
