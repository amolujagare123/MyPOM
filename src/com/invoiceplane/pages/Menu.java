package com.invoiceplane.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by user on 2/19/2017.
 */
public class Menu {
    WebDriver driver;

    @FindBy (xpath=".//*[@id='ip-navbar-collapse']/ul[1]/li[1]/a[1]")
    WebElement btndashboard;

    @FindBy (xpath=".//*[@id='ip-navbar-collapse']/ul[1]/li[2]/a/span")
    WebElement btnclient;

    @FindBy (xpath=".//*[@id='ip-navbar-collapse']/ul[1]/li[2]/ul/li[1]/a")
    WebElement btnAddclient;


    @FindBy (xpath=".//*[@id='ip-navbar-collapse']/ul[1]/li[2]/ul/li[2]/a")
    WebElement btnViewclient;

    @FindBy (xpath=".//*[@id='ip-navbar-collapse']/ul[1]/li[3]/a/span")
    WebElement btnQuotes;

    @FindBy (xpath=".//*[@id='ip-navbar-collapse']/ul[1]/li[3]/ul/li[1]/a")
    WebElement btncreateQuotes;

    @FindBy (xpath=".//*[@id='ip-navbar-collapse']/ul[1]/li[3]/ul/li[2]/a")
    WebElement btnviewQuotes;

    @FindBy (xpath=".//*[@id='ip-navbar-collapse']/ul[1]/li[4]/a/span")
    WebElement btninvoices;

    @FindBy (xpath=".//*[@id='ip-navbar-collapse']/ul[1]/li[4]/ul/li[1]/a")
    WebElement btncreateinvoices;

    @FindBy (xpath=".//*[@id='ip-navbar-collapse']/ul[1]/li[4]/ul/li[2]/a")
    WebElement btnviewinvoices;

    @FindBy (xpath=".//*[@id='ip-navbar-collapse']/ul[1]/li[4]/ul/li[3]/a")
    WebElement btnviewrecurringinvoices;

    @FindBy (xpath=".//*[@id='ip-navbar-collapse']/ul[1]/li[5]/a/span")
    WebElement btnproducts;

    @FindBy (xpath=".//*[@id='ip-navbar-collapse']/ul[1]/li[5]/ul/li[1]/a")
    WebElement btncreateproduct;

    @FindBy (xpath=".//*[@id='ip-navbar-collapse']/ul[1]/li[5]/ul/li[2]/a")
    WebElement btnviewproducts;

    @FindBy (xpath=".//*[@id='btn-submit']")
    WebElement btnsave;

public    Menu(WebDriver driver) {
        this.driver = driver;

        PageFactory.initElements(driver, this);

    }

    public void clickashboard()
    {
        btndashboard.click();
    }

    public void clickAddclient()
    {
        btnclient.click();btnAddclient.click();
    }

    public void viewclient() {btnclient.click();btnViewclient.click();}

   /* public void CreateQuotes() {btncreateQuotes.click();}

    public void ViewQuotes () {btnviewQuotes.click();}

    public void viewQuotes () {btnviewQuotes.click();}

    public void Createinvoices () {btncreateinvoices.click();}

    public void viewinvoices () {btnviewinvoices.click();}

    public void viewrecurringinvoices () {btnviewrecurringinvoices.click();}*/

    public void clicksave() {btnsave.click();}
}
