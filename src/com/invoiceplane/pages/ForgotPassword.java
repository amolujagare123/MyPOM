package com.invoiceplane.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by user on 2/12/2017.
 */
public class ForgotPassword {

    WebDriver driver;
    @FindBy(xpath = ".//*[@id='login']/div[2]/small/a")
    WebElement txtforgotpassword;

    ForgotPassword(WebDriver driver) {
        this.driver = driver;

        PageFactory.initElements(driver, this);


    }
    public void setforgotpassword(String forgotpassword)
    {
        txtforgotpassword.sendKeys(forgotpassword);
    }
}